use bytes::Bytes;
use futures::{future, future::BoxFuture, Stream, stream, future::FutureExt, stream::TryStreamExt};
use http_body_util::{combinators::BoxBody, Full};
use hyper::{body::{Body, Incoming}, HeaderMap, Request, Response, StatusCode};
use hyper::header::{HeaderName, HeaderValue, CONTENT_TYPE};
use log::warn;
#[cfg(feature = "validate")]
use serde_valid::Validate;
#[allow(unused_imports)]
use std::convert::{TryFrom, TryInto};
use std::{convert::Infallible, error::Error};
use std::future::Future;
use std::marker::PhantomData;
use std::task::{Context, Poll};
use swagger::{ApiError, BodyExt, Has, RequestParser, XSpanIdString};
pub use swagger::auth::Authorization;
use swagger::auth::Scopes;
use url::form_urlencoded;
use multipart::server::Multipart;
use multipart::server::save::{PartialReason, SaveResult};

#[allow(unused_imports)]
use crate::{models, header, AuthenticationApi};

pub use crate::context;

type ServiceFuture = BoxFuture<'static, Result<Response<BoxBody<Bytes, Infallible>>, crate::ServiceError>>;

use crate::{Api,
     AddRuleResponse,
     DelistBlockResponse,
     GetMailBlocksResponse,
     GetRulesResponse,
     DeleteRuleResponse,
     GetStatsResponse,
     ViewMailLogResponse,
     RawMailResponse,
     SendAdvMailResponse,
     SendMailResponse,
     GetMailOrdersResponse,
     GetMailOrderByIdResponse,
     PingServerResponse
};

mod server_auth;

mod paths {
    use lazy_static::lazy_static;

    lazy_static! {
        pub static ref GLOBAL_REGEX_SET: regex::RegexSet = regex::RegexSet::new(vec![
            r"^/mail$",
            r"^/mail/advsend$",
            r"^/mail/blocks$",
            r"^/mail/blocks/delete$",
            r"^/mail/log$",
            r"^/mail/rawsend$",
            r"^/mail/rules$",
            r"^/mail/rules/(?P<ruleId>[^/?#]*)$",
            r"^/mail/send$",
            r"^/mail/stats$",
            r"^/mail/(?P<id>[^/?#]*)$",
            r"^/ping$"
        ])
        .expect("Unable to create global regex set");
    }
    pub(crate) static ID_MAIL: usize = 0;
    pub(crate) static ID_MAIL_ADVSEND: usize = 1;
    pub(crate) static ID_MAIL_BLOCKS: usize = 2;
    pub(crate) static ID_MAIL_BLOCKS_DELETE: usize = 3;
    pub(crate) static ID_MAIL_LOG: usize = 4;
    pub(crate) static ID_MAIL_RAWSEND: usize = 5;
    pub(crate) static ID_MAIL_RULES: usize = 6;
    pub(crate) static ID_MAIL_RULES_RULEID: usize = 7;
    lazy_static! {
        pub static ref REGEX_MAIL_RULES_RULEID: regex::Regex =
            #[allow(clippy::invalid_regex)]
            regex::Regex::new(r"^/mail/rules/(?P<ruleId>[^/?#]*)$")
                .expect("Unable to create regex for MAIL_RULES_RULEID");
    }
    pub(crate) static ID_MAIL_SEND: usize = 8;
    pub(crate) static ID_MAIL_STATS: usize = 9;
    pub(crate) static ID_MAIL_ID: usize = 10;
    lazy_static! {
        pub static ref REGEX_MAIL_ID: regex::Regex =
            #[allow(clippy::invalid_regex)]
            regex::Regex::new(r"^/mail/(?P<id>[^/?#]*)$")
                .expect("Unable to create regex for MAIL_ID");
    }
    pub(crate) static ID_PING: usize = 11;
}


pub struct MakeService<T, C>
where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static
{
    api_impl: T,
    multipart_form_size_limit: Option<u64>,
    marker: PhantomData<C>,
    validation: bool
}

impl<T, C> MakeService<T, C>
where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static
{
    pub fn new(api_impl: T) -> Self {
        MakeService {
            api_impl,
            multipart_form_size_limit: Some(8 * 1024 * 1024),
            marker: PhantomData,
            validation: false
        }
    }

    /// Configure size limit when inspecting a multipart/form body.
    ///
    /// Default is 8 MiB.
    ///
    /// Set to None for no size limit, which presents a Denial of Service attack risk.
    pub fn multipart_form_size_limit(mut self, multipart_form_size_limit: Option<u64>) -> Self {
        self.multipart_form_size_limit = multipart_form_size_limit;
        self
    }

    // Turn on/off validation for the service being made.
    #[cfg(feature = "validate")]
    pub fn set_validation(&mut self, validation: bool) {
        self.validation = validation;
    }
}

impl<T, C> Clone for MakeService<T, C>
where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString>  + Has<Option<Authorization>> + Send + Sync + 'static
{
    fn clone(&self) -> Self {
        Self {
            api_impl: self.api_impl.clone(),
            multipart_form_size_limit: Some(8 * 1024 * 1024),
            marker: PhantomData,
            validation: self.validation
        }
    }
}

impl<T, C, Target> hyper::service::Service<Target> for MakeService<T, C>
where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static
{
    type Response = Service<T, C>;
    type Error = crate::ServiceError;
    type Future = future::Ready<Result<Self::Response, Self::Error>>;

    fn call(&self, target: Target) -> Self::Future {
        let service = Service::new(self.api_impl.clone(), self.validation)
            .multipart_form_size_limit(self.multipart_form_size_limit);

        future::ok(service)
    }
}

fn method_not_allowed() -> Result<Response<BoxBody<Bytes, Infallible>>, crate::ServiceError> {
    Ok(
        Response::builder().status(StatusCode::METHOD_NOT_ALLOWED)
            .body(BoxBody::new(http_body_util::Empty::new()))
            .expect("Unable to create Method Not Allowed response")
    )
}

#[allow(unused_macros)]
#[cfg(not(feature = "validate"))]
macro_rules! run_validation {
    ($parameter:tt, $base_name:tt, $validation:tt) => ();
}

#[allow(unused_macros)]
#[cfg(feature = "validate")]
macro_rules! run_validation {
    ($parameter:tt, $base_name:tt, $validation:tt) => {
        let $parameter = if $validation {
            match $parameter.validate() {
            Ok(()) => $parameter,
            Err(e) => return Ok(Response::builder()
                                    .status(StatusCode::BAD_REQUEST)
                                    .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                    .body(BoxBody::new(format!("Invalid value in body parameter {}: {}", $base_name, e)))
                                    .expect(&format!("Unable to create Bad Request response for invalid value in body parameter {}", $base_name))),
            }
        } else {
            $parameter
        };
    }
}

pub struct Service<T, C> where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static
{
    api_impl: T,
    multipart_form_size_limit: Option<u64>,
    marker: PhantomData<C>,
    // Enable regex pattern validation of received JSON models
    validation: bool,
}

impl<T, C> Service<T, C> where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static
{
    pub fn new(api_impl: T, validation: bool) -> Self {
        Service {
            api_impl,
            multipart_form_size_limit: Some(8 * 1024 * 1024),
            marker: PhantomData,
            validation,
        }
    }
    #[cfg(feature = "validate")]
    pub fn set_validation(&mut self, validation: bool) {
        self.validation = validation
    }


    /// Configure size limit when extracting a multipart/form body.
    ///
    /// Default is 8 MiB.
    ///
    /// Set to None for no size limit, which presents a Denial of Service attack risk.
    pub fn multipart_form_size_limit(mut self, multipart_form_size_limit: Option<u64>) -> Self {
        self.multipart_form_size_limit = multipart_form_size_limit;
        self
    }
}

impl<T, C> Clone for Service<T, C> where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static
{
    fn clone(&self) -> Self {
        Service {
            api_impl: self.api_impl.clone(),
            multipart_form_size_limit: Some(8 * 1024 * 1024),
            marker: self.marker,
            validation: self.validation,
        }
    }
}

#[allow(dead_code)]
fn body_from_string(s: String) -> BoxBody<Bytes, Infallible> {
    BoxBody::new(Full::new(Bytes::from(s)))
}

fn body_from_str(s: &str) -> BoxBody<Bytes, Infallible> {
    BoxBody::new(Full::new(Bytes::copy_from_slice(s.as_bytes())))
}

impl<T, C, ReqBody> hyper::service::Service<(Request<ReqBody>, C)> for Service<T, C> where
    T: Api<C> + Clone + Send + Sync + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static,
    ReqBody: Body + Send + 'static,
    ReqBody::Error: Into<Box<dyn Error + Send + Sync>> + Send,
    ReqBody::Data: Send,
{
    type Response = Response<BoxBody<Bytes, Infallible>>;
    type Error = crate::ServiceError;
    type Future = ServiceFuture;

    fn call(&self, req: (Request<ReqBody>, C)) -> Self::Future {
        async fn run<T, C, ReqBody>(
            mut api_impl: T,
            req: (Request<ReqBody>, C),
            validation: bool,
            multipart_form_size_limit: Option<u64>,
        ) -> Result<Response<BoxBody<Bytes, Infallible>>, crate::ServiceError>
        where
            T: Api<C> + Clone + Send + 'static,
            C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static,
            ReqBody: Body + Send + 'static,
            ReqBody::Error: Into<Box<dyn Error + Send + Sync>> + Send,
            ReqBody::Data: Send,
        {
            let (request, context) = req;
            let (parts, body) = request.into_parts();
            let (method, uri, headers) = (parts.method, parts.uri, parts.headers);
            let path = paths::GLOBAL_REGEX_SET.matches(uri.path());

            match method {

            // AddRule - POST /mail/rules
            hyper::Method::POST if path.matched(paths::ID_MAIL_RULES) => {
                handle_add_rule(api_impl, uri, headers, body, context, validation, multipart_form_size_limit).await
            },

            // DelistBlock - POST /mail/blocks/delete
            hyper::Method::POST if path.matched(paths::ID_MAIL_BLOCKS_DELETE) => {
                handle_delist_block(api_impl, uri, headers, body, context, validation, multipart_form_size_limit).await
            },

            // GetMailBlocks - GET /mail/blocks
            hyper::Method::GET if path.matched(paths::ID_MAIL_BLOCKS) => {
                handle_get_mail_blocks(api_impl, uri, headers, body, context, validation, multipart_form_size_limit).await
            },

            // GetRules - GET /mail/rules
            hyper::Method::GET if path.matched(paths::ID_MAIL_RULES) => {
                handle_get_rules(api_impl, uri, headers, body, context, validation, multipart_form_size_limit).await
            },

            // DeleteRule - DELETE /mail/rules/{ruleId}
            hyper::Method::DELETE if path.matched(paths::ID_MAIL_RULES_RULEID) => {
                handle_delete_rule(api_impl, uri, headers, body, context, validation, multipart_form_size_limit).await
            },

            // GetStats - GET /mail/stats
            hyper::Method::GET if path.matched(paths::ID_MAIL_STATS) => {
                handle_get_stats(api_impl, uri, headers, body, context, validation, multipart_form_size_limit).await
            },

            // ViewMailLog - GET /mail/log
            hyper::Method::GET if path.matched(paths::ID_MAIL_LOG) => {
                handle_view_mail_log(api_impl, uri, headers, body, context, validation, multipart_form_size_limit).await
            },

            // RawMail - POST /mail/rawsend
            hyper::Method::POST if path.matched(paths::ID_MAIL_RAWSEND) => {
                handle_raw_mail(api_impl, uri, headers, body, context, validation, multipart_form_size_limit).await
            },

            // SendAdvMail - POST /mail/advsend
            hyper::Method::POST if path.matched(paths::ID_MAIL_ADVSEND) => {
                handle_send_adv_mail(api_impl, uri, headers, body, context, validation, multipart_form_size_limit).await
            },

            // SendMail - POST /mail/send
            hyper::Method::POST if path.matched(paths::ID_MAIL_SEND) => {
                handle_send_mail(api_impl, uri, headers, body, context, validation, multipart_form_size_limit).await
            },

            // GetMailOrders - GET /mail
            hyper::Method::GET if path.matched(paths::ID_MAIL) => {
                handle_get_mail_orders(api_impl, uri, headers, body, context, validation, multipart_form_size_limit).await
            },

            // GetMailOrderById - GET /mail/{id}
            hyper::Method::GET if path.matched(paths::ID_MAIL_ID) => {
                handle_get_mail_order_by_id(api_impl, uri, headers, body, context, validation, multipart_form_size_limit).await
            },

            // PingServer - GET /ping
            hyper::Method::GET if path.matched(paths::ID_PING) => {
                handle_ping_server(api_impl, uri, headers, body, context, validation, multipart_form_size_limit).await
            },

            _ if path.matched(paths::ID_MAIL) => method_not_allowed(),
            _ if path.matched(paths::ID_MAIL_ADVSEND) => method_not_allowed(),
            _ if path.matched(paths::ID_MAIL_BLOCKS) => method_not_allowed(),
            _ if path.matched(paths::ID_MAIL_BLOCKS_DELETE) => method_not_allowed(),
            _ if path.matched(paths::ID_MAIL_LOG) => method_not_allowed(),
            _ if path.matched(paths::ID_MAIL_RAWSEND) => method_not_allowed(),
            _ if path.matched(paths::ID_MAIL_RULES) => method_not_allowed(),
            _ if path.matched(paths::ID_MAIL_RULES_RULEID) => method_not_allowed(),
            _ if path.matched(paths::ID_MAIL_SEND) => method_not_allowed(),
            _ if path.matched(paths::ID_MAIL_STATS) => method_not_allowed(),
            _ if path.matched(paths::ID_MAIL_ID) => method_not_allowed(),
            _ if path.matched(paths::ID_PING) => method_not_allowed(),
                _ => Ok(Response::builder().status(StatusCode::NOT_FOUND)
                        .body(BoxBody::new(http_body_util::Empty::new()))
                        .expect("Unable to create Not Found response"))
            }
        }
        Box::pin(run(
            self.api_impl.clone(),
            req,
            self.validation,
            self.multipart_form_size_limit
        ))
    }
}

#[allow(unused_variables)]
async fn handle_add_rule<T, C, ReqBody>(
    mut api_impl: T,
    uri: hyper::Uri,
    headers: HeaderMap,
    body: ReqBody,
    context: C,
    validation: bool,
    multipart_form_size_limit: Option<u64>,
) -> Result<Response<BoxBody<Bytes, Infallible>>, crate::ServiceError>
where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static,
    ReqBody: Body + Send + 'static,
    ReqBody::Error: Into<Box<dyn Error + Send + Sync>> + Send,
    ReqBody::Data: Send,
{
                {
                    let authorization = match *(&context as &dyn Has<Option<Authorization>>).get() {
                        Some(ref authorization) => authorization,
                        None => return Ok(Response::builder()
                                                .status(StatusCode::FORBIDDEN)
                                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                .body(body_from_str("Unauthenticated"))
                                                .expect("Unable to create Authentication Forbidden response")),
                    };
                }

                // Handle body parameters (note that non-required body parameters will ignore garbage
                // values, rather than causing a 400 response). Produce warning header and logs for
                // any unused fields.
                let result = http_body_util::BodyExt::collect(body).await.map(|f| f.to_bytes().to_vec());
                match result {
                     Ok(body) => {
                                // Form parameters
                                let param_user =
                                    Some("user_example".to_string());
                                let param_r#type =
                                    models::DenyRuleNewType::Domain;
                                let param_data =
                                    "data_example".to_string();

                                let result = api_impl.add_rule(
                                            param_r#type,
                                            param_data,
                                            param_user,
                                        &context
                                    ).await;
                                let mut response = Response::new(BoxBody::new(http_body_util::Empty::new()));
                                response.headers_mut().insert(
                                            HeaderName::from_static("x-span-id"),
                                            HeaderValue::from_str((&context as &dyn Has<XSpanIdString>).get().0.clone().as_str())
                                                .expect("Unable to create X-Span-ID header value"));

                                        match result {
                                            Ok(rsp) => match rsp {
                                                AddRuleResponse::RuleCreatedSuccessfully
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(200).expect("Unable to turn 200 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                AddRuleResponse::BadRequest
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(400).expect("Unable to turn 400 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                AddRuleResponse::AuthenticationFailed
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(401).expect("Unable to turn 401 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                AddRuleResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(404).expect("Unable to turn 404 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                            },
                                            Err(_) => {
                                                // Application code returned an error. This should not happen, as the implementation should
                                                // return a valid response.
                                                *response.status_mut() = StatusCode::INTERNAL_SERVER_ERROR;
                                                response.headers_mut().insert(
                                                    CONTENT_TYPE,
                                                    HeaderValue::from_static("text/plain"),
                                                );
                                                *response.body_mut() = body_from_str("An internal error occurred");
                                            },
                                        }

                                        Ok(response)
                            },
                            Err(e) => Ok(Response::builder()
                                                .status(StatusCode::BAD_REQUEST)
                                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                .body(body_from_string(format!("Unable to read body: {}", e.into())))
                                                .expect("Unable to create Bad Request response due to unable to read body")),
                        }
}

#[allow(unused_variables)]
async fn handle_delist_block<T, C, ReqBody>(
    mut api_impl: T,
    uri: hyper::Uri,
    headers: HeaderMap,
    body: ReqBody,
    context: C,
    validation: bool,
    multipart_form_size_limit: Option<u64>,
) -> Result<Response<BoxBody<Bytes, Infallible>>, crate::ServiceError>
where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static,
    ReqBody: Body + Send + 'static,
    ReqBody::Error: Into<Box<dyn Error + Send + Sync>> + Send,
    ReqBody::Data: Send,
{
                {
                    let authorization = match *(&context as &dyn Has<Option<Authorization>>).get() {
                        Some(ref authorization) => authorization,
                        None => return Ok(Response::builder()
                                                .status(StatusCode::FORBIDDEN)
                                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                .body(body_from_str("Unauthenticated"))
                                                .expect("Unable to create Authentication Forbidden response")),
                    };
                }

                // Handle body parameters (note that non-required body parameters will ignore garbage
                // values, rather than causing a 400 response). Produce warning header and logs for
                // any unused fields.
                let result = http_body_util::BodyExt::collect(body).await.map(|f| f.to_bytes().to_vec());
                match result {
                     Ok(body) => {
                                let param_email_address_param: Option<models::EmailAddressParam> = if !body.is_empty() {
                                    let deserializer = &mut serde_json::Deserializer::from_slice(&body);
                                    match serde_ignored::deserialize(deserializer, |path| {
                                            warn!("Ignoring unknown field in body: {path}");
                                            unused_elements.push(path.to_string());
                                    }) {
                                        Ok(param_email_address_param) => param_email_address_param,
                                        Err(e) => return Ok(Response::builder()
                                                        .status(StatusCode::BAD_REQUEST)
                                                        .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                        .body(BoxBody::new(format!("Couldn't parse body parameter EmailAddressParam - doesn't match schema: {e}")))
                                                        .expect("Unable to create Bad Request response for invalid body parameter EmailAddressParam due to schema")),
                                    }

                                } else {
                                    None
                                };
                                let param_email_address_param = match param_email_address_param {
                                    Some(param_email_address_param) => param_email_address_param,
                                    None => return Ok(Response::builder()
                                                        .status(StatusCode::BAD_REQUEST)
                                                        .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                        .body(BoxBody::new("Missing required body parameter EmailAddressParam".to_string()))
                                                        .expect("Unable to create Bad Request response for missing body parameter EmailAddressParam")),
                                };

                                let result = api_impl.delist_block(
                                            param_email_address_param,
                                        &context
                                    ).await;
                                let mut response = Response::new(BoxBody::new(http_body_util::Empty::new()));
                                response.headers_mut().insert(
                                            HeaderName::from_static("x-span-id"),
                                            HeaderValue::from_str((&context as &dyn Has<XSpanIdString>).get().0.clone().as_str())
                                                .expect("Unable to create X-Span-ID header value"));

                                        match result {
                                            Ok(rsp) => match rsp {
                                                DelistBlockResponse::AddressSuccessfullyDelisted
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(200).expect("Unable to turn 200 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                DelistBlockResponse::BadRequest
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(400).expect("Unable to turn 400 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                DelistBlockResponse::AuthenticationFailed
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(401).expect("Unable to turn 401 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                DelistBlockResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(404).expect("Unable to turn 404 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                            },
                                            Err(_) => {
                                                // Application code returned an error. This should not happen, as the implementation should
                                                // return a valid response.
                                                *response.status_mut() = StatusCode::INTERNAL_SERVER_ERROR;
                                                response.headers_mut().insert(
                                                    CONTENT_TYPE,
                                                    HeaderValue::from_static("text/plain"),
                                                );
                                                *response.body_mut() = body_from_str("An internal error occurred");
                                            },
                                        }

                                        Ok(response)
                            },
                            Err(e) => Ok(Response::builder()
                                                .status(StatusCode::BAD_REQUEST)
                                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                .body(body_from_string(format!("Unable to read body: {}", e.into())))
                                                .expect("Unable to create Bad Request response due to unable to read body")),
                        }
}

#[allow(unused_variables)]
async fn handle_get_mail_blocks<T, C, ReqBody>(
    mut api_impl: T,
    uri: hyper::Uri,
    headers: HeaderMap,
    body: ReqBody,
    context: C,
    validation: bool,
    multipart_form_size_limit: Option<u64>,
) -> Result<Response<BoxBody<Bytes, Infallible>>, crate::ServiceError>
where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static,
    ReqBody: Body + Send + 'static,
    ReqBody::Error: Into<Box<dyn Error + Send + Sync>> + Send,
    ReqBody::Data: Send,
{
                {
                    let authorization = match *(&context as &dyn Has<Option<Authorization>>).get() {
                        Some(ref authorization) => authorization,
                        None => return Ok(Response::builder()
                                                .status(StatusCode::FORBIDDEN)
                                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                .body(body_from_str("Unauthenticated"))
                                                .expect("Unable to create Authentication Forbidden response")),
                    };
                }

                                let result = api_impl.get_mail_blocks(
                                        &context
                                    ).await;
                                let mut response = Response::new(BoxBody::new(http_body_util::Empty::new()));
                                response.headers_mut().insert(
                                            HeaderName::from_static("x-span-id"),
                                            HeaderValue::from_str((&context as &dyn Has<XSpanIdString>).get().0.clone().as_str())
                                                .expect("Unable to create X-Span-ID header value"));

                                        match result {
                                            Ok(rsp) => match rsp {
                                                GetMailBlocksResponse::OK
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(200).expect("Unable to turn 200 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                GetMailBlocksResponse::AuthenticationFailed
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(401).expect("Unable to turn 401 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                            },
                                            Err(_) => {
                                                // Application code returned an error. This should not happen, as the implementation should
                                                // return a valid response.
                                                *response.status_mut() = StatusCode::INTERNAL_SERVER_ERROR;
                                                response.headers_mut().insert(
                                                    CONTENT_TYPE,
                                                    HeaderValue::from_static("text/plain"),
                                                );
                                                *response.body_mut() = body_from_str("An internal error occurred");
                                            },
                                        }

                                        Ok(response)
}

#[allow(unused_variables)]
async fn handle_get_rules<T, C, ReqBody>(
    mut api_impl: T,
    uri: hyper::Uri,
    headers: HeaderMap,
    body: ReqBody,
    context: C,
    validation: bool,
    multipart_form_size_limit: Option<u64>,
) -> Result<Response<BoxBody<Bytes, Infallible>>, crate::ServiceError>
where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static,
    ReqBody: Body + Send + 'static,
    ReqBody::Error: Into<Box<dyn Error + Send + Sync>> + Send,
    ReqBody::Data: Send,
{
                {
                    let authorization = match *(&context as &dyn Has<Option<Authorization>>).get() {
                        Some(ref authorization) => authorization,
                        None => return Ok(Response::builder()
                                                .status(StatusCode::FORBIDDEN)
                                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                .body(body_from_str("Unauthenticated"))
                                                .expect("Unable to create Authentication Forbidden response")),
                    };
                }

                                let result = api_impl.get_rules(
                                        &context
                                    ).await;
                                let mut response = Response::new(BoxBody::new(http_body_util::Empty::new()));
                                response.headers_mut().insert(
                                            HeaderName::from_static("x-span-id"),
                                            HeaderValue::from_str((&context as &dyn Has<XSpanIdString>).get().0.clone().as_str())
                                                .expect("Unable to create X-Span-ID header value"));

                                        match result {
                                            Ok(rsp) => match rsp {
                                                GetRulesResponse::OK
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(200).expect("Unable to turn 200 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                GetRulesResponse::AuthenticationFailed
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(401).expect("Unable to turn 401 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                            },
                                            Err(_) => {
                                                // Application code returned an error. This should not happen, as the implementation should
                                                // return a valid response.
                                                *response.status_mut() = StatusCode::INTERNAL_SERVER_ERROR;
                                                response.headers_mut().insert(
                                                    CONTENT_TYPE,
                                                    HeaderValue::from_static("text/plain"),
                                                );
                                                *response.body_mut() = body_from_str("An internal error occurred");
                                            },
                                        }

                                        Ok(response)
}

#[allow(unused_variables)]
async fn handle_delete_rule<T, C, ReqBody>(
    mut api_impl: T,
    uri: hyper::Uri,
    headers: HeaderMap,
    body: ReqBody,
    context: C,
    validation: bool,
    multipart_form_size_limit: Option<u64>,
) -> Result<Response<BoxBody<Bytes, Infallible>>, crate::ServiceError>
where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static,
    ReqBody: Body + Send + 'static,
    ReqBody::Error: Into<Box<dyn Error + Send + Sync>> + Send,
    ReqBody::Data: Send,
{
                {
                    let authorization = match *(&context as &dyn Has<Option<Authorization>>).get() {
                        Some(ref authorization) => authorization,
                        None => return Ok(Response::builder()
                                                .status(StatusCode::FORBIDDEN)
                                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                .body(body_from_str("Unauthenticated"))
                                                .expect("Unable to create Authentication Forbidden response")),
                    };
                }

                // Path parameters
                let path: &str = uri.path();
                let path_params =
                    paths::REGEX_MAIL_RULES_RULEID
                    .captures(path)
                    .unwrap_or_else(||
                        panic!("Path {} matched RE MAIL_RULES_RULEID in set but failed match against \"{}\"", path, paths::REGEX_MAIL_RULES_RULEID.as_str())
                    );

                let param_rule_id = match percent_encoding::percent_decode(path_params["ruleId"].as_bytes()).decode_utf8() {
                    Ok(param_rule_id) => match param_rule_id.parse::<i32>() {
                        Ok(param_rule_id) => param_rule_id,
                        Err(e) => return Ok(Response::builder()
                                        .status(StatusCode::BAD_REQUEST)
                                        .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                        .body(body_from_string(format!("Couldn't parse path parameter ruleId: {e}")))
                                        .expect("Unable to create Bad Request response for invalid path parameter")),
                    },
                    Err(_) => return Ok(Response::builder()
                                        .status(StatusCode::BAD_REQUEST)
                                        .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                        .body(body_from_string(format!("Couldn't percent-decode path parameter as UTF-8: {}", &path_params["ruleId"])))
                                        .expect("Unable to create Bad Request response for invalid percent decode"))
                };

                                let result = api_impl.delete_rule(
                                            param_rule_id,
                                        &context
                                    ).await;
                                let mut response = Response::new(BoxBody::new(http_body_util::Empty::new()));
                                response.headers_mut().insert(
                                            HeaderName::from_static("x-span-id"),
                                            HeaderValue::from_str((&context as &dyn Has<XSpanIdString>).get().0.clone().as_str())
                                                .expect("Unable to create X-Span-ID header value"));

                                        match result {
                                            Ok(rsp) => match rsp {
                                                DeleteRuleResponse::RuleDeletedSuccessfully
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(200).expect("Unable to turn 200 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                DeleteRuleResponse::BadRequest
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(400).expect("Unable to turn 400 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                DeleteRuleResponse::AuthenticationFailed
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(401).expect("Unable to turn 401 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                DeleteRuleResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(404).expect("Unable to turn 404 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                            },
                                            Err(_) => {
                                                // Application code returned an error. This should not happen, as the implementation should
                                                // return a valid response.
                                                *response.status_mut() = StatusCode::INTERNAL_SERVER_ERROR;
                                                response.headers_mut().insert(
                                                    CONTENT_TYPE,
                                                    HeaderValue::from_static("text/plain"),
                                                );
                                                *response.body_mut() = body_from_str("An internal error occurred");
                                            },
                                        }

                                        Ok(response)
}

#[allow(unused_variables)]
async fn handle_get_stats<T, C, ReqBody>(
    mut api_impl: T,
    uri: hyper::Uri,
    headers: HeaderMap,
    body: ReqBody,
    context: C,
    validation: bool,
    multipart_form_size_limit: Option<u64>,
) -> Result<Response<BoxBody<Bytes, Infallible>>, crate::ServiceError>
where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static,
    ReqBody: Body + Send + 'static,
    ReqBody::Error: Into<Box<dyn Error + Send + Sync>> + Send,
    ReqBody::Data: Send,
{
                {
                    let authorization = match *(&context as &dyn Has<Option<Authorization>>).get() {
                        Some(ref authorization) => authorization,
                        None => return Ok(Response::builder()
                                                .status(StatusCode::FORBIDDEN)
                                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                .body(body_from_str("Unauthenticated"))
                                                .expect("Unable to create Authentication Forbidden response")),
                    };
                }

                // Query parameters (note that non-required or collection query parameters will ignore garbage values, rather than causing a 400 response)
                let query_params = form_urlencoded::parse(uri.query().unwrap_or_default().as_bytes()).collect::<Vec<_>>();
                let param_time = query_params.iter().filter(|e| e.0 == "time").map(|e| e.1.clone())
                    .next();
                let param_time = match param_time {
                    Some(param_time) => {
                        let param_time =
                            <models::GetStatsTimeParameter as std::str::FromStr>::from_str
                                (&param_time);
                        match param_time {
                            Ok(param_time) => Some(param_time),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter time - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter time")),
                        }
                    },
                    None => None,
                };

                                let result = api_impl.get_stats(
                                            param_time,
                                        &context
                                    ).await;
                                let mut response = Response::new(BoxBody::new(http_body_util::Empty::new()));
                                response.headers_mut().insert(
                                            HeaderName::from_static("x-span-id"),
                                            HeaderValue::from_str((&context as &dyn Has<XSpanIdString>).get().0.clone().as_str())
                                                .expect("Unable to create X-Span-ID header value"));

                                        match result {
                                            Ok(rsp) => match rsp {
                                                GetStatsResponse::OK
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(200).expect("Unable to turn 200 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                GetStatsResponse::AuthenticationFailed
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(401).expect("Unable to turn 401 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                            },
                                            Err(_) => {
                                                // Application code returned an error. This should not happen, as the implementation should
                                                // return a valid response.
                                                *response.status_mut() = StatusCode::INTERNAL_SERVER_ERROR;
                                                response.headers_mut().insert(
                                                    CONTENT_TYPE,
                                                    HeaderValue::from_static("text/plain"),
                                                );
                                                *response.body_mut() = body_from_str("An internal error occurred");
                                            },
                                        }

                                        Ok(response)
}

#[allow(unused_variables)]
async fn handle_view_mail_log<T, C, ReqBody>(
    mut api_impl: T,
    uri: hyper::Uri,
    headers: HeaderMap,
    body: ReqBody,
    context: C,
    validation: bool,
    multipart_form_size_limit: Option<u64>,
) -> Result<Response<BoxBody<Bytes, Infallible>>, crate::ServiceError>
where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static,
    ReqBody: Body + Send + 'static,
    ReqBody::Error: Into<Box<dyn Error + Send + Sync>> + Send,
    ReqBody::Data: Send,
{
                {
                    let authorization = match *(&context as &dyn Has<Option<Authorization>>).get() {
                        Some(ref authorization) => authorization,
                        None => return Ok(Response::builder()
                                                .status(StatusCode::FORBIDDEN)
                                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                .body(body_from_str("Unauthenticated"))
                                                .expect("Unable to create Authentication Forbidden response")),
                    };
                }

                // Query parameters (note that non-required or collection query parameters will ignore garbage values, rather than causing a 400 response)
                let query_params = form_urlencoded::parse(uri.query().unwrap_or_default().as_bytes()).collect::<Vec<_>>();
                let param_id = query_params.iter().filter(|e| e.0 == "id").map(|e| e.1.clone())
                    .next();
                let param_id = match param_id {
                    Some(param_id) => {
                        let param_id =
                            <i64 as std::str::FromStr>::from_str
                                (&param_id);
                        match param_id {
                            Ok(param_id) => Some(param_id),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter id - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter id")),
                        }
                    },
                    None => None,
                };
                let param_origin = query_params.iter().filter(|e| e.0 == "origin").map(|e| e.1.clone())
                    .next();
                let param_origin = match param_origin {
                    Some(param_origin) => {
                        let param_origin =
                            <String as std::str::FromStr>::from_str
                                (&param_origin);
                        match param_origin {
                            Ok(param_origin) => Some(param_origin),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter origin - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter origin")),
                        }
                    },
                    None => None,
                };
                let param_mx = query_params.iter().filter(|e| e.0 == "mx").map(|e| e.1.clone())
                    .next();
                let param_mx = match param_mx {
                    Some(param_mx) => {
                        let param_mx =
                            <String as std::str::FromStr>::from_str
                                (&param_mx);
                        match param_mx {
                            Ok(param_mx) => Some(param_mx),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter mx - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter mx")),
                        }
                    },
                    None => None,
                };
                let param_from = query_params.iter().filter(|e| e.0 == "from").map(|e| e.1.clone())
                    .next();
                let param_from = match param_from {
                    Some(param_from) => {
                        let param_from =
                            <String as std::str::FromStr>::from_str
                                (&param_from);
                        match param_from {
                            Ok(param_from) => Some(param_from),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter from - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter from")),
                        }
                    },
                    None => None,
                };
                let param_to = query_params.iter().filter(|e| e.0 == "to").map(|e| e.1.clone())
                    .next();
                let param_to = match param_to {
                    Some(param_to) => {
                        let param_to =
                            <String as std::str::FromStr>::from_str
                                (&param_to);
                        match param_to {
                            Ok(param_to) => Some(param_to),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter to - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter to")),
                        }
                    },
                    None => None,
                };
                let param_subject = query_params.iter().filter(|e| e.0 == "subject").map(|e| e.1.clone())
                    .next();
                let param_subject = match param_subject {
                    Some(param_subject) => {
                        let param_subject =
                            <String as std::str::FromStr>::from_str
                                (&param_subject);
                        match param_subject {
                            Ok(param_subject) => Some(param_subject),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter subject - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter subject")),
                        }
                    },
                    None => None,
                };
                let param_mailid = query_params.iter().filter(|e| e.0 == "mailid").map(|e| e.1.clone())
                    .next();
                let param_mailid = match param_mailid {
                    Some(param_mailid) => {
                        let param_mailid =
                            <String as std::str::FromStr>::from_str
                                (&param_mailid);
                        match param_mailid {
                            Ok(param_mailid) => Some(param_mailid),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter mailid - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter mailid")),
                        }
                    },
                    None => None,
                };
                let param_message_id = query_params.iter().filter(|e| e.0 == "messageId").map(|e| e.1.clone())
                    .next();
                let param_message_id = match param_message_id {
                    Some(param_message_id) => {
                        let param_message_id =
                            <String as std::str::FromStr>::from_str
                                (&param_message_id);
                        match param_message_id {
                            Ok(param_message_id) => Some(param_message_id),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter messageId - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter messageId")),
                        }
                    },
                    None => None,
                };
                let param_replyto = query_params.iter().filter(|e| e.0 == "replyto").map(|e| e.1.clone())
                    .next();
                let param_replyto = match param_replyto {
                    Some(param_replyto) => {
                        let param_replyto =
                            <String as std::str::FromStr>::from_str
                                (&param_replyto);
                        match param_replyto {
                            Ok(param_replyto) => Some(param_replyto),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter replyto - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter replyto")),
                        }
                    },
                    None => None,
                };
                let param_headerfrom = query_params.iter().filter(|e| e.0 == "headerfrom").map(|e| e.1.clone())
                    .next();
                let param_headerfrom = match param_headerfrom {
                    Some(param_headerfrom) => {
                        let param_headerfrom =
                            <String as std::str::FromStr>::from_str
                                (&param_headerfrom);
                        match param_headerfrom {
                            Ok(param_headerfrom) => Some(param_headerfrom),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter headerfrom - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter headerfrom")),
                        }
                    },
                    None => None,
                };
                let param_delivered = query_params.iter().filter(|e| e.0 == "delivered").map(|e| e.1.clone())
                    .next();
                let param_delivered = match param_delivered {
                    Some(param_delivered) => {
                        let param_delivered =
                            <models::DeliveredStatus as std::str::FromStr>::from_str
                                (&param_delivered);
                        match param_delivered {
                            Ok(param_delivered) => Some(param_delivered),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter delivered - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter delivered")),
                        }
                    },
                    None => None,
                };
                let param_skip = query_params.iter().filter(|e| e.0 == "skip").map(|e| e.1.clone())
                    .next();
                let param_skip = match param_skip {
                    Some(param_skip) => {
                        let param_skip =
                            <i32 as std::str::FromStr>::from_str
                                (&param_skip);
                        match param_skip {
                            Ok(param_skip) => Some(param_skip),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter skip - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter skip")),
                        }
                    },
                    None => None,
                };
                let param_limit = query_params.iter().filter(|e| e.0 == "limit").map(|e| e.1.clone())
                    .next();
                let param_limit = match param_limit {
                    Some(param_limit) => {
                        let param_limit =
                            <i32 as std::str::FromStr>::from_str
                                (&param_limit);
                        match param_limit {
                            Ok(param_limit) => Some(param_limit),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter limit - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter limit")),
                        }
                    },
                    None => None,
                };
                let param_start_date = query_params.iter().filter(|e| e.0 == "startDate").map(|e| e.1.clone())
                    .next();
                let param_start_date = match param_start_date {
                    Some(param_start_date) => {
                        let param_start_date =
                            <models::SwaggerColonColonOneOf2LessThanI64CommaStringGreaterThan as std::str::FromStr>::from_str
                                (&param_start_date);
                        match param_start_date {
                            Ok(param_start_date) => Some(param_start_date),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter startDate - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter startDate")),
                        }
                    },
                    None => None,
                };
                let param_end_date = query_params.iter().filter(|e| e.0 == "endDate").map(|e| e.1.clone())
                    .next();
                let param_end_date = match param_end_date {
                    Some(param_end_date) => {
                        let param_end_date =
                            <models::SwaggerColonColonOneOf2LessThanI64CommaStringGreaterThan as std::str::FromStr>::from_str
                                (&param_end_date);
                        match param_end_date {
                            Ok(param_end_date) => Some(param_end_date),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter endDate - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter endDate")),
                        }
                    },
                    None => None,
                };
                let param_sort = query_params.iter().filter(|e| e.0 == "sort").map(|e| e.1.clone())
                    .next();
                let param_sort = match param_sort {
                    Some(param_sort) => {
                        let param_sort =
                            <models::ViewMailLogSortParameter as std::str::FromStr>::from_str
                                (&param_sort);
                        match param_sort {
                            Ok(param_sort) => Some(param_sort),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter sort - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter sort")),
                        }
                    },
                    None => None,
                };
                let param_dir = query_params.iter().filter(|e| e.0 == "dir").map(|e| e.1.clone())
                    .next();
                let param_dir = match param_dir {
                    Some(param_dir) => {
                        let param_dir =
                            <models::ViewMailLogDirParameter as std::str::FromStr>::from_str
                                (&param_dir);
                        match param_dir {
                            Ok(param_dir) => Some(param_dir),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter dir - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter dir")),
                        }
                    },
                    None => None,
                };
                let param_groupby = query_params.iter().filter(|e| e.0 == "groupby").map(|e| e.1.clone())
                    .next();
                let param_groupby = match param_groupby {
                    Some(param_groupby) => {
                        let param_groupby =
                            <models::ViewMailLogGroupbyParameter as std::str::FromStr>::from_str
                                (&param_groupby);
                        match param_groupby {
                            Ok(param_groupby) => Some(param_groupby),
                            Err(e) => return Ok(Response::builder()
                                .status(StatusCode::BAD_REQUEST)
                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                .body(body_from_string(format!("Couldn't parse query parameter groupby - doesn't match schema: {e}")))
                                .expect("Unable to create Bad Request response for invalid query parameter groupby")),
                        }
                    },
                    None => None,
                };

                                let result = api_impl.view_mail_log(
                                            param_id,
                                            param_origin,
                                            param_mx,
                                            param_from,
                                            param_to,
                                            param_subject,
                                            param_mailid,
                                            param_message_id,
                                            param_replyto,
                                            param_headerfrom,
                                            param_delivered,
                                            param_skip,
                                            param_limit,
                                            param_start_date,
                                            param_end_date,
                                            param_sort,
                                            param_dir,
                                            param_groupby,
                                        &context
                                    ).await;
                                let mut response = Response::new(BoxBody::new(http_body_util::Empty::new()));
                                response.headers_mut().insert(
                                            HeaderName::from_static("x-span-id"),
                                            HeaderValue::from_str((&context as &dyn Has<XSpanIdString>).get().0.clone().as_str())
                                                .expect("Unable to create X-Span-ID header value"));

                                        match result {
                                            Ok(rsp) => match rsp {
                                                ViewMailLogResponse::PaginatedListOfMailLogEntries
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(200).expect("Unable to turn 200 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                ViewMailLogResponse::BadRequest
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(400).expect("Unable to turn 400 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                ViewMailLogResponse::AuthenticationFailed
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(401).expect("Unable to turn 401 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                            },
                                            Err(_) => {
                                                // Application code returned an error. This should not happen, as the implementation should
                                                // return a valid response.
                                                *response.status_mut() = StatusCode::INTERNAL_SERVER_ERROR;
                                                response.headers_mut().insert(
                                                    CONTENT_TYPE,
                                                    HeaderValue::from_static("text/plain"),
                                                );
                                                *response.body_mut() = body_from_str("An internal error occurred");
                                            },
                                        }

                                        Ok(response)
}

#[allow(unused_variables)]
async fn handle_raw_mail<T, C, ReqBody>(
    mut api_impl: T,
    uri: hyper::Uri,
    headers: HeaderMap,
    body: ReqBody,
    context: C,
    validation: bool,
    multipart_form_size_limit: Option<u64>,
) -> Result<Response<BoxBody<Bytes, Infallible>>, crate::ServiceError>
where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static,
    ReqBody: Body + Send + 'static,
    ReqBody::Error: Into<Box<dyn Error + Send + Sync>> + Send,
    ReqBody::Data: Send,
{
                {
                    let authorization = match *(&context as &dyn Has<Option<Authorization>>).get() {
                        Some(ref authorization) => authorization,
                        None => return Ok(Response::builder()
                                                .status(StatusCode::FORBIDDEN)
                                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                .body(body_from_str("Unauthenticated"))
                                                .expect("Unable to create Authentication Forbidden response")),
                    };
                }

                // Handle body parameters (note that non-required body parameters will ignore garbage
                // values, rather than causing a 400 response). Produce warning header and logs for
                // any unused fields.
                let result = http_body_util::BodyExt::collect(body).await.map(|f| f.to_bytes().to_vec());
                match result {
                     Ok(body) => {

                                let result = api_impl.raw_mail(
                                            param_send_mail_raw,
                                        &context
                                    ).await;
                                let mut response = Response::new(BoxBody::new(http_body_util::Empty::new()));
                                response.headers_mut().insert(
                                            HeaderName::from_static("x-span-id"),
                                            HeaderValue::from_str((&context as &dyn Has<XSpanIdString>).get().0.clone().as_str())
                                                .expect("Unable to create X-Span-ID header value"));

                                        match result {
                                            Ok(rsp) => match rsp {
                                                RawMailResponse::EmailAcceptedForDelivery
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(200).expect("Unable to turn 200 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                RawMailResponse::BadRequest
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(400).expect("Unable to turn 400 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                RawMailResponse::AuthenticationFailed
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(401).expect("Unable to turn 401 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                RawMailResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(404).expect("Unable to turn 404 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                            },
                                            Err(_) => {
                                                // Application code returned an error. This should not happen, as the implementation should
                                                // return a valid response.
                                                *response.status_mut() = StatusCode::INTERNAL_SERVER_ERROR;
                                                response.headers_mut().insert(
                                                    CONTENT_TYPE,
                                                    HeaderValue::from_static("text/plain"),
                                                );
                                                *response.body_mut() = body_from_str("An internal error occurred");
                                            },
                                        }

                                        Ok(response)
                            },
                            Err(e) => Ok(Response::builder()
                                                .status(StatusCode::BAD_REQUEST)
                                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                .body(body_from_string(format!("Unable to read body: {}", e.into())))
                                                .expect("Unable to create Bad Request response due to unable to read body")),
                        }
}

#[allow(unused_variables)]
async fn handle_send_adv_mail<T, C, ReqBody>(
    mut api_impl: T,
    uri: hyper::Uri,
    headers: HeaderMap,
    body: ReqBody,
    context: C,
    validation: bool,
    multipart_form_size_limit: Option<u64>,
) -> Result<Response<BoxBody<Bytes, Infallible>>, crate::ServiceError>
where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static,
    ReqBody: Body + Send + 'static,
    ReqBody::Error: Into<Box<dyn Error + Send + Sync>> + Send,
    ReqBody::Data: Send,
{
                {
                    let authorization = match *(&context as &dyn Has<Option<Authorization>>).get() {
                        Some(ref authorization) => authorization,
                        None => return Ok(Response::builder()
                                                .status(StatusCode::FORBIDDEN)
                                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                .body(body_from_str("Unauthenticated"))
                                                .expect("Unable to create Authentication Forbidden response")),
                    };
                }

                // Handle body parameters (note that non-required body parameters will ignore garbage
                // values, rather than causing a 400 response). Produce warning header and logs for
                // any unused fields.
                let result = http_body_util::BodyExt::collect(body).await.map(|f| f.to_bytes().to_vec());
                match result {
                     Ok(body) => {
                                // Form parameters
                                let param_subject =
                                    "subject_example".to_string();
                                let param_body =
                                    "body_example".to_string();
                                let param_from =
                                    ???;
                                let param_to =
                                    ???;
                                let param_replyto =
                                    None;
                                let param_cc =
                                    None;
                                let param_bcc =
                                    None;
                                let param_attachments =
                                    None;
                                let param_id =
                                    Some(789);

                                let result = api_impl.send_adv_mail(
                                            param_subject,
                                            param_body,
                                            param_from,
                                            param_to,
                                            param_replyto,
                                            param_cc,
                                            param_bcc,
                                            param_attachments.as_ref(),
                                            param_id,
                                        &context
                                    ).await;
                                let mut response = Response::new(BoxBody::new(http_body_util::Empty::new()));
                                response.headers_mut().insert(
                                            HeaderName::from_static("x-span-id"),
                                            HeaderValue::from_str((&context as &dyn Has<XSpanIdString>).get().0.clone().as_str())
                                                .expect("Unable to create X-Span-ID header value"));

                                        match result {
                                            Ok(rsp) => match rsp {
                                                SendAdvMailResponse::EmailAcceptedForDelivery
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(200).expect("Unable to turn 200 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                SendAdvMailResponse::BadRequest
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(400).expect("Unable to turn 400 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                SendAdvMailResponse::AuthenticationFailed
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(401).expect("Unable to turn 401 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                SendAdvMailResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(404).expect("Unable to turn 404 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                            },
                                            Err(_) => {
                                                // Application code returned an error. This should not happen, as the implementation should
                                                // return a valid response.
                                                *response.status_mut() = StatusCode::INTERNAL_SERVER_ERROR;
                                                response.headers_mut().insert(
                                                    CONTENT_TYPE,
                                                    HeaderValue::from_static("text/plain"),
                                                );
                                                *response.body_mut() = body_from_str("An internal error occurred");
                                            },
                                        }

                                        Ok(response)
                            },
                            Err(e) => Ok(Response::builder()
                                                .status(StatusCode::BAD_REQUEST)
                                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                .body(body_from_string(format!("Unable to read body: {}", e.into())))
                                                .expect("Unable to create Bad Request response due to unable to read body")),
                        }
}

#[allow(unused_variables)]
async fn handle_send_mail<T, C, ReqBody>(
    mut api_impl: T,
    uri: hyper::Uri,
    headers: HeaderMap,
    body: ReqBody,
    context: C,
    validation: bool,
    multipart_form_size_limit: Option<u64>,
) -> Result<Response<BoxBody<Bytes, Infallible>>, crate::ServiceError>
where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static,
    ReqBody: Body + Send + 'static,
    ReqBody::Error: Into<Box<dyn Error + Send + Sync>> + Send,
    ReqBody::Data: Send,
{
                {
                    let authorization = match *(&context as &dyn Has<Option<Authorization>>).get() {
                        Some(ref authorization) => authorization,
                        None => return Ok(Response::builder()
                                                .status(StatusCode::FORBIDDEN)
                                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                .body(body_from_str("Unauthenticated"))
                                                .expect("Unable to create Authentication Forbidden response")),
                    };
                }

                // Handle body parameters (note that non-required body parameters will ignore garbage
                // values, rather than causing a 400 response). Produce warning header and logs for
                // any unused fields.
                let result = http_body_util::BodyExt::collect(body).await.map(|f| f.to_bytes().to_vec());
                match result {
                     Ok(body) => {
                                // Form parameters
                                let param_to =
                                    ???;
                                let param_from =
                                    "from_example".to_string();
                                let param_subject =
                                    "subject_example".to_string();
                                let param_body =
                                    "body_example".to_string();
                                let param_id =
                                    Some(789);

                                let result = api_impl.send_mail(
                                            param_to,
                                            param_from,
                                            param_subject,
                                            param_body,
                                            param_id,
                                        &context
                                    ).await;
                                let mut response = Response::new(BoxBody::new(http_body_util::Empty::new()));
                                response.headers_mut().insert(
                                            HeaderName::from_static("x-span-id"),
                                            HeaderValue::from_str((&context as &dyn Has<XSpanIdString>).get().0.clone().as_str())
                                                .expect("Unable to create X-Span-ID header value"));

                                        match result {
                                            Ok(rsp) => match rsp {
                                                SendMailResponse::EmailAcceptedForDelivery
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(200).expect("Unable to turn 200 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                SendMailResponse::BadRequest
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(400).expect("Unable to turn 400 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                SendMailResponse::AuthenticationFailed
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(401).expect("Unable to turn 401 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                SendMailResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(404).expect("Unable to turn 404 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                            },
                                            Err(_) => {
                                                // Application code returned an error. This should not happen, as the implementation should
                                                // return a valid response.
                                                *response.status_mut() = StatusCode::INTERNAL_SERVER_ERROR;
                                                response.headers_mut().insert(
                                                    CONTENT_TYPE,
                                                    HeaderValue::from_static("text/plain"),
                                                );
                                                *response.body_mut() = body_from_str("An internal error occurred");
                                            },
                                        }

                                        Ok(response)
                            },
                            Err(e) => Ok(Response::builder()
                                                .status(StatusCode::BAD_REQUEST)
                                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                .body(body_from_string(format!("Unable to read body: {}", e.into())))
                                                .expect("Unable to create Bad Request response due to unable to read body")),
                        }
}

#[allow(unused_variables)]
async fn handle_get_mail_orders<T, C, ReqBody>(
    mut api_impl: T,
    uri: hyper::Uri,
    headers: HeaderMap,
    body: ReqBody,
    context: C,
    validation: bool,
    multipart_form_size_limit: Option<u64>,
) -> Result<Response<BoxBody<Bytes, Infallible>>, crate::ServiceError>
where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static,
    ReqBody: Body + Send + 'static,
    ReqBody::Error: Into<Box<dyn Error + Send + Sync>> + Send,
    ReqBody::Data: Send,
{
                {
                    let authorization = match *(&context as &dyn Has<Option<Authorization>>).get() {
                        Some(ref authorization) => authorization,
                        None => return Ok(Response::builder()
                                                .status(StatusCode::FORBIDDEN)
                                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                .body(body_from_str("Unauthenticated"))
                                                .expect("Unable to create Authentication Forbidden response")),
                    };
                }

                                let result = api_impl.get_mail_orders(
                                        &context
                                    ).await;
                                let mut response = Response::new(BoxBody::new(http_body_util::Empty::new()));
                                response.headers_mut().insert(
                                            HeaderName::from_static("x-span-id"),
                                            HeaderValue::from_str((&context as &dyn Has<XSpanIdString>).get().0.clone().as_str())
                                                .expect("Unable to create X-Span-ID header value"));

                                        match result {
                                            Ok(rsp) => match rsp {
                                                GetMailOrdersResponse::OK
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(200).expect("Unable to turn 200 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                GetMailOrdersResponse::AuthenticationFailed
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(401).expect("Unable to turn 401 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                            },
                                            Err(_) => {
                                                // Application code returned an error. This should not happen, as the implementation should
                                                // return a valid response.
                                                *response.status_mut() = StatusCode::INTERNAL_SERVER_ERROR;
                                                response.headers_mut().insert(
                                                    CONTENT_TYPE,
                                                    HeaderValue::from_static("text/plain"),
                                                );
                                                *response.body_mut() = body_from_str("An internal error occurred");
                                            },
                                        }

                                        Ok(response)
}

#[allow(unused_variables)]
async fn handle_get_mail_order_by_id<T, C, ReqBody>(
    mut api_impl: T,
    uri: hyper::Uri,
    headers: HeaderMap,
    body: ReqBody,
    context: C,
    validation: bool,
    multipart_form_size_limit: Option<u64>,
) -> Result<Response<BoxBody<Bytes, Infallible>>, crate::ServiceError>
where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString> + Has<Option<Authorization>> + Send + Sync + 'static,
    ReqBody: Body + Send + 'static,
    ReqBody::Error: Into<Box<dyn Error + Send + Sync>> + Send,
    ReqBody::Data: Send,
{
                {
                    let authorization = match *(&context as &dyn Has<Option<Authorization>>).get() {
                        Some(ref authorization) => authorization,
                        None => return Ok(Response::builder()
                                                .status(StatusCode::FORBIDDEN)
                                                .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                                .body(body_from_str("Unauthenticated"))
                                                .expect("Unable to create Authentication Forbidden response")),
                    };
                }

                // Path parameters
                let path: &str = uri.path();
                let path_params =
                    paths::REGEX_MAIL_ID
                    .captures(path)
                    .unwrap_or_else(||
                        panic!("Path {} matched RE MAIL_ID in set but failed match against \"{}\"", path, paths::REGEX_MAIL_ID.as_str())
                    );

                let param_id = match percent_encoding::percent_decode(path_params["id"].as_bytes()).decode_utf8() {
                    Ok(param_id) => match param_id.parse::<i64>() {
                        Ok(param_id) => param_id,
                        Err(e) => return Ok(Response::builder()
                                        .status(StatusCode::BAD_REQUEST)
                                        .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                        .body(body_from_string(format!("Couldn't parse path parameter id: {e}")))
                                        .expect("Unable to create Bad Request response for invalid path parameter")),
                    },
                    Err(_) => return Ok(Response::builder()
                                        .status(StatusCode::BAD_REQUEST)
                                        .header(CONTENT_TYPE, mime::TEXT_PLAIN.as_ref())
                                        .body(body_from_string(format!("Couldn't percent-decode path parameter as UTF-8: {}", &path_params["id"])))
                                        .expect("Unable to create Bad Request response for invalid percent decode"))
                };

                                let result = api_impl.get_mail_order_by_id(
                                            param_id,
                                        &context
                                    ).await;
                                let mut response = Response::new(BoxBody::new(http_body_util::Empty::new()));
                                response.headers_mut().insert(
                                            HeaderName::from_static("x-span-id"),
                                            HeaderValue::from_str((&context as &dyn Has<XSpanIdString>).get().0.clone().as_str())
                                                .expect("Unable to create X-Span-ID header value"));

                                        match result {
                                            Ok(rsp) => match rsp {
                                                GetMailOrderByIdResponse::OK
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(200).expect("Unable to turn 200 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                GetMailOrderByIdResponse::BadRequest
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(400).expect("Unable to turn 400 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                GetMailOrderByIdResponse::AuthenticationFailed
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(401).expect("Unable to turn 401 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                GetMailOrderByIdResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(404).expect("Unable to turn 404 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("application/json"));
                                                    // JSON Body
                                                    let body = serde_json::to_string(&body).expect("impossible to fail to serialize");
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                            },
                                            Err(_) => {
                                                // Application code returned an error. This should not happen, as the implementation should
                                                // return a valid response.
                                                *response.status_mut() = StatusCode::INTERNAL_SERVER_ERROR;
                                                response.headers_mut().insert(
                                                    CONTENT_TYPE,
                                                    HeaderValue::from_static("text/plain"),
                                                );
                                                *response.body_mut() = body_from_str("An internal error occurred");
                                            },
                                        }

                                        Ok(response)
}

#[allow(unused_variables)]
async fn handle_ping_server<T, C, ReqBody>(
    mut api_impl: T,
    uri: hyper::Uri,
    headers: HeaderMap,
    body: ReqBody,
    context: C,
    validation: bool,
    multipart_form_size_limit: Option<u64>,
) -> Result<Response<BoxBody<Bytes, Infallible>>, crate::ServiceError>
where
    T: Api<C> + Clone + Send + 'static,
    C: Has<XSpanIdString>  + Send + Sync + 'static,
    ReqBody: Body + Send + 'static,
    ReqBody::Error: Into<Box<dyn Error + Send + Sync>> + Send,
    ReqBody::Data: Send,
{
                                let result = api_impl.ping_server(
                                        &context
                                    ).await;
                                let mut response = Response::new(BoxBody::new(http_body_util::Empty::new()));
                                response.headers_mut().insert(
                                            HeaderName::from_static("x-span-id"),
                                            HeaderValue::from_str((&context as &dyn Has<XSpanIdString>).get().0.clone().as_str())
                                                .expect("Unable to create X-Span-ID header value"));

                                        match result {
                                            Ok(rsp) => match rsp {
                                                PingServerResponse::ServerIsUpAndRunning
                                                    (body)
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(200).expect("Unable to turn 200 into a StatusCode");
                                                    response.headers_mut().insert(
                                                        CONTENT_TYPE,
                                                        HeaderValue::from_static("text/plain"));
                                                    // Plain text Body
                                                    *response.body_mut() = body_from_string(body);

                                                },
                                                PingServerResponse::SomethingIsWrong
                                                => {
                                                    *response.status_mut() = StatusCode::from_u16(0).expect("Unable to turn 0 into a StatusCode");

                                                },
                                            },
                                            Err(_) => {
                                                // Application code returned an error. This should not happen, as the implementation should
                                                // return a valid response.
                                                *response.status_mut() = StatusCode::INTERNAL_SERVER_ERROR;
                                                response.headers_mut().insert(
                                                    CONTENT_TYPE,
                                                    HeaderValue::from_static("text/plain"),
                                                );
                                                *response.body_mut() = body_from_str("An internal error occurred");
                                            },
                                        }

                                        Ok(response)
}

/// Request parser for `Api`.
pub struct ApiRequestParser;
impl<T> RequestParser<T> for ApiRequestParser {
    fn parse_operation_id(request: &Request<T>) -> Option<&'static str> {
        let path = paths::GLOBAL_REGEX_SET.matches(request.uri().path());
        match *request.method() {
            // AddRule - POST /mail/rules
            hyper::Method::POST if path.matched(paths::ID_MAIL_RULES) => Some("AddRule"),
            // DelistBlock - POST /mail/blocks/delete
            hyper::Method::POST if path.matched(paths::ID_MAIL_BLOCKS_DELETE) => Some("DelistBlock"),
            // GetMailBlocks - GET /mail/blocks
            hyper::Method::GET if path.matched(paths::ID_MAIL_BLOCKS) => Some("GetMailBlocks"),
            // GetRules - GET /mail/rules
            hyper::Method::GET if path.matched(paths::ID_MAIL_RULES) => Some("GetRules"),
            // DeleteRule - DELETE /mail/rules/{ruleId}
            hyper::Method::DELETE if path.matched(paths::ID_MAIL_RULES_RULEID) => Some("DeleteRule"),
            // GetStats - GET /mail/stats
            hyper::Method::GET if path.matched(paths::ID_MAIL_STATS) => Some("GetStats"),
            // ViewMailLog - GET /mail/log
            hyper::Method::GET if path.matched(paths::ID_MAIL_LOG) => Some("ViewMailLog"),
            // RawMail - POST /mail/rawsend
            hyper::Method::POST if path.matched(paths::ID_MAIL_RAWSEND) => Some("RawMail"),
            // SendAdvMail - POST /mail/advsend
            hyper::Method::POST if path.matched(paths::ID_MAIL_ADVSEND) => Some("SendAdvMail"),
            // SendMail - POST /mail/send
            hyper::Method::POST if path.matched(paths::ID_MAIL_SEND) => Some("SendMail"),
            // GetMailOrders - GET /mail
            hyper::Method::GET if path.matched(paths::ID_MAIL) => Some("GetMailOrders"),
            // GetMailOrderById - GET /mail/{id}
            hyper::Method::GET if path.matched(paths::ID_MAIL_ID) => Some("GetMailOrderById"),
            // PingServer - GET /ping
            hyper::Method::GET if path.matched(paths::ID_PING) => Some("PingServer"),
            _ => None,
        }
    }
}
