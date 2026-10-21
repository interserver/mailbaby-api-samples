use async_trait::async_trait;
use bytes::Bytes;
use futures::{Stream, future, future::BoxFuture, stream, future::TryFutureExt, future::FutureExt, stream::StreamExt};
use http_body_util::{combinators::BoxBody, Full};
use hyper::header::{HeaderName, HeaderValue, CONTENT_TYPE};
use hyper::{body::{Body, Incoming}, Request, Response, service::Service, Uri};
use percent_encoding::{utf8_percent_encode, AsciiSet};
use std::borrow::Cow;
use std::convert::{TryInto, Infallible};
use std::io::{ErrorKind, Read};
use std::error::Error;
use std::future::Future;
use std::fmt;
use std::marker::PhantomData;
use std::path::Path;
use std::sync::{Arc, Mutex};
use std::str;
use std::str::FromStr;
use std::string::ToString;
use std::task::{Context, Poll};
use swagger::{ApiError, AuthData, BodyExt, Connector, DropContextService, Has, XSpanIdString};
use url::form_urlencoded;
use tower_service::Service as _;

use mime::Mime;
use std::io::Cursor;
use multipart::client::lazy::Multipart;

use crate::models;
use crate::header;

/// https://url.spec.whatwg.org/#fragment-percent-encode-set
#[allow(dead_code)]
const FRAGMENT_ENCODE_SET: &AsciiSet = &percent_encoding::CONTROLS
    .add(b' ').add(b'"').add(b'<').add(b'>').add(b'`');

/// This encode set is used for object IDs
///
/// Aside from the special characters defined in the `PATH_SEGMENT_ENCODE_SET`,
/// the vertical bar (|) is encoded.
#[allow(dead_code)]
const ID_ENCODE_SET: &AsciiSet = &FRAGMENT_ENCODE_SET.add(b'|');

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

/// Convert input into a base path, e.g. "http://example:123". Also checks the scheme as it goes.
fn into_base_path(input: impl TryInto<Uri, Error=hyper::http::uri::InvalidUri>, correct_scheme: Option<&'static str>) -> Result<String, ClientInitError> {
    // First convert to Uri, since a base path is a subset of Uri.
    let uri = input.try_into()?;

    let scheme = uri.scheme_str().ok_or(ClientInitError::InvalidScheme)?;

    // Check the scheme if necessary
    if let Some(correct_scheme) = correct_scheme {
        if scheme != correct_scheme {
            return Err(ClientInitError::InvalidScheme);
        }
    }

    let host = uri.host().ok_or(ClientInitError::MissingHost)?;
    let port = uri.port_u16().map(|x| format!(":{x}")).unwrap_or_default();
    Ok(format!("{scheme}://{host}{port}{}", uri.path().trim_end_matches('/')))
}

/// A client that implements the API by making HTTP calls out to a server.
pub struct Client<S, C> where
    S: Service<
           (Request<BoxBody<Bytes, Infallible>>, C)> + Clone + Sync + Send + 'static,
    S::Future: Send + 'static,
    S::Error: Into<crate::ServiceError> + fmt::Display,
    C: Clone + Send + Sync + 'static
{
    /// Inner service
    client_service: S,

    /// Base path of the API
    base_path: String,

    /// Marker
    marker: PhantomData<fn(C)>,
}

impl<S, C> fmt::Debug for Client<S, C> where
    S: Service<
           (Request<BoxBody<Bytes, Infallible>>, C)> + Clone + Sync + Send + 'static,
    S::Future: Send + 'static,
    S::Error: Into<crate::ServiceError> + fmt::Display,
    C: Clone + Send + Sync + 'static
{
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(f, "Client {{ base_path: {} }}", self.base_path)
    }
}

impl<S, C> Clone for Client<S, C> where
    S: Service<
           (Request<BoxBody<Bytes, Infallible>>, C)> + Clone + Sync + Send + 'static,
    S::Future: Send + 'static,
    S::Error: Into<crate::ServiceError> + fmt::Display,
    C: Clone + Send + Sync + 'static
{
    fn clone(&self) -> Self {
        Self {
            client_service: self.client_service.clone(),
            base_path: self.base_path.clone(),
            marker: PhantomData,
        }
    }
}

impl<Connector, C> Client<
    DropContextService<
        hyper_util::service::TowerToHyperService<
            hyper_util::client::legacy::Client<
                Connector,
                BoxBody<Bytes, Infallible>
            >
        >,
        C
    >,
    C
> where
    Connector: hyper_util::client::legacy::connect::Connect + Clone + Send + Sync + 'static,
    C: Clone + Send + Sync + 'static,
{
    /// Create a client with a custom implementation of hyper::client::Connect.
    ///
    /// Intended for use with custom implementations of connect for e.g. protocol logging
    /// or similar functionality which requires wrapping the transport layer. When wrapping a TCP connection,
    /// this function should be used in conjunction with `swagger::Connector::builder()`.
    ///
    /// For ordinary tcp connections, prefer the use of `try_new_http`, `try_new_https`
    /// and `try_new_https_mutual`, to avoid introducing a dependency on the underlying transport layer.
    ///
    /// # Arguments
    ///
    /// * `base_path` - base path of the client API, i.e. "<http://www.my-api-implementation.com>"
    /// * `protocol` - Which protocol to use when constructing the request url, e.g. `Some("http")`
    /// * `connector` - Implementation of `hyper::client::Connect` to use for the client
    pub fn try_new_with_connector(
        base_path: &str,
        protocol: Option<&'static str>,
        connector: Connector,
    ) -> Result<Self, ClientInitError>
    {
        let client_service = hyper_util::client::legacy::Client::builder(hyper_util::rt::TokioExecutor::new()).build(connector);
        let client_service = DropContextService::new(hyper_util::service::TowerToHyperService::new(client_service));

        Ok(Self {
            client_service,
            base_path: into_base_path(base_path, protocol)?,
            marker: PhantomData,
        })
    }
}

#[cfg(all(feature = "client-tls", any(target_os = "macos", target_os = "windows", target_os = "ios")))]
type HyperHttpsConnector = hyper_tls::HttpsConnector<hyper_util::client::legacy::connect::HttpConnector>;

#[cfg(all(feature = "client-tls", not(any(target_os = "macos", target_os = "windows", target_os = "ios"))))]
type HyperHttpsConnector = hyper_openssl::client::legacy::HttpsConnector<hyper_util::client::legacy::connect::HttpConnector>;

#[derive(Debug, Clone)]
pub enum HyperClient {
    Http(hyper_util::client::legacy::Client<hyper_util::client::legacy::connect::HttpConnector, BoxBody<Bytes, Infallible>>),
    #[cfg(feature = "client-tls")]
    Https(hyper_util::client::legacy::Client<HyperHttpsConnector, BoxBody<Bytes, Infallible>>),
}

impl Service<Request<BoxBody<Bytes, Infallible>>> for HyperClient {
    type Response = Response<Incoming>;
    type Error = hyper_util::client::legacy::Error;
    type Future = hyper_util::client::legacy::ResponseFuture;

    fn call(&self, req: Request<BoxBody<Bytes, Infallible>>) -> Self::Future {
       match self {
          HyperClient::Http(client) => client.request(req),
          #[cfg(feature = "client-tls")]
          HyperClient::Https(client) => client.request(req),
       }
    }
}

impl<C> Client<DropContextService<HyperClient, C>, C> where
    C: Clone + Send + Sync + 'static,
{
    /// Create an HTTP client.
    ///
    /// # Arguments
    /// * `base_path` - base path of the client API, i.e. "<http://www.my-api-implementation.com>"
    pub fn try_new(
        base_path: &str,
    ) -> Result<Self, ClientInitError> {
        let uri = Uri::from_str(base_path)?;

        let scheme = uri.scheme_str().ok_or(ClientInitError::InvalidScheme)?;
        let scheme = scheme.to_ascii_lowercase();

        let connector = Connector::builder();

        let client_service = match scheme.as_str() {
            "http" => {
                HyperClient::Http(hyper_util::client::legacy::Client::builder(hyper_util::rt::TokioExecutor::new()).build(connector.build()))
            },
            #[cfg(feature = "client-tls")]
            "https" => {
                let https_connector = connector
                    .https()
                    .build()
                    .map_err(ClientInitError::SslError)?;
                HyperClient::Https(hyper_util::client::legacy::Client::builder(hyper_util::rt::TokioExecutor::new()).build(https_connector))
            },
            #[cfg(not(feature = "client-tls"))]
            "https" => {
                return Err(ClientInitError::TlsNotEnabled);
            },
            _ => {
                return Err(ClientInitError::InvalidScheme);
            }
        };

        let client_service = DropContextService::new(client_service);

        Ok(Self {
            client_service,
            base_path: into_base_path(base_path, None)?,
            marker: PhantomData,
        })
    }
}

impl<C> Client<
    DropContextService<
        hyper_util::service::TowerToHyperService<
            hyper_util::client::legacy::Client<
                hyper_util::client::legacy::connect::HttpConnector,
                BoxBody<Bytes, Infallible>
            >
        >,
        C
    >,
    C
> where
    C: Clone + Send + Sync + 'static
{
    /// Create an HTTP client.
    ///
    /// # Arguments
    /// * `base_path` - base path of the client API, i.e. "<http://www.my-api-implementation.com>"
    pub fn try_new_http(
        base_path: &str,
    ) -> Result<Self, ClientInitError> {
        let http_connector = Connector::builder().build();

        Self::try_new_with_connector(base_path, Some("http"), http_connector)
    }
}

#[cfg(all(feature = "client-tls", any(target_os = "macos", target_os = "windows", target_os = "ios")))]
type HttpsConnector = hyper_tls::HttpsConnector<hyper_util::client::legacy::connect::HttpConnector>;

#[cfg(all(feature = "client-tls", not(any(target_os = "macos", target_os = "windows", target_os = "ios"))))]
type HttpsConnector = hyper_openssl::client::legacy::HttpsConnector<hyper_util::client::legacy::connect::HttpConnector>;

#[cfg(feature = "client-tls")]
impl<C> Client<
    DropContextService<
        hyper_util::service::TowerToHyperService<
            hyper_util::client::legacy::Client<
                HttpsConnector,
                BoxBody<Bytes, Infallible>
            >
        >,
        C
    >,
    C
> where
    C: Clone + Send + Sync + 'static
{
    /// Create a client with a TLS connection to the server.
    ///
    /// # Arguments
    /// * `base_path` - base path of the client API, i.e. "<https://www.my-api-implementation.com>"
    #[cfg(any(target_os = "macos", target_os = "windows", target_os = "ios"))]
    pub fn try_new_https(base_path: &str) -> Result<Self, ClientInitError>
    {
        let https_connector = Connector::builder()
            .https()
            .build()
            .map_err(ClientInitError::SslError)?;
        Self::try_new_with_connector(base_path, Some("https"), https_connector)
    }

    /// Create a client with a TLS connection to the server using OpenSSL via swagger.
    ///
    /// # Arguments
    /// * `base_path` - base path of the client API, i.e. "<https://www.my-api-implementation.com>"
    #[cfg(not(any(target_os = "macos", target_os = "windows", target_os = "ios")))]
    pub fn try_new_https(base_path: &str) -> Result<Self, ClientInitError>
    {
        let https_connector = Connector::builder()
            .https()
            .build()
            .map_err(ClientInitError::SslError)?;
        Self::try_new_with_connector(base_path, Some("https"), https_connector)
    }

    /// Create a client with a TLS connection to the server using a pinned certificate.
    ///
    /// # Arguments
    /// * `base_path` - base path of the client API, i.e. "<https://www.my-api-implementation.com>"
    /// * `ca_certificate` - Path to CA certificate used to authenticate the server
    #[cfg(not(any(target_os = "macos", target_os = "windows", target_os = "ios")))]
    pub fn try_new_https_pinned<CA>(
        base_path: &str,
        ca_certificate: CA,
    ) -> Result<Self, ClientInitError>
    where
        CA: AsRef<Path>,
    {
        let https_connector = Connector::builder()
            .https()
            .pin_server_certificate(ca_certificate)
            .build()
            .map_err(ClientInitError::SslError)?;
        Self::try_new_with_connector(base_path, Some("https"), https_connector)
    }

    /// Create a client with a mutually authenticated TLS connection to the server.
    ///
    /// # Arguments
    /// * `base_path` - base path of the client API, i.e. "<https://www.my-api-implementation.com>"
    /// * `ca_certificate` - Path to CA certificate used to authenticate the server
    /// * `client_key` - Path to the client private key
    /// * `client_certificate` - Path to the client's public certificate associated with the private key
    #[cfg(not(any(target_os = "macos", target_os = "windows", target_os = "ios")))]
    pub fn try_new_https_mutual<CA, K, D>(
        base_path: &str,
        ca_certificate: CA,
        client_key: K,
        client_certificate: D,
    ) -> Result<Self, ClientInitError>
    where
        CA: AsRef<Path>,
        K: AsRef<Path>,
        D: AsRef<Path>,
    {
        let https_connector = Connector::builder()
            .https()
            .pin_server_certificate(ca_certificate)
            .client_authentication(client_key, client_certificate)
            .build()
            .map_err(ClientInitError::SslError)?;
        Self::try_new_with_connector(base_path, Some("https"), https_connector)
    }
}

impl<S, C> Client<S, C> where
    S: Service<
           (Request<BoxBody<Bytes, Infallible>>, C)> + Clone + Sync + Send + 'static,
    S::Future: Send + 'static,
    S::Error: Into<crate::ServiceError> + fmt::Display,
    C: Clone + Send + Sync + 'static
{
    /// Constructor for creating a `Client` by passing in a pre-made `hyper::service::Service` /
    /// `tower::Service`
    ///
    /// This allows adding custom wrappers around the underlying transport, for example for logging.
    pub fn try_new_with_client_service(
        client_service: S,
        base_path: &str,
    ) -> Result<Self, ClientInitError>
    {
        Ok(Self {
            client_service,
            base_path: into_base_path(base_path, None)?,
            marker: PhantomData,
        })
    }
}

/// Error type failing to create a Client
#[derive(Debug)]
pub enum ClientInitError {
    /// Invalid URL Scheme
    InvalidScheme,

    /// Invalid URI
    InvalidUri(hyper::http::uri::InvalidUri),

    /// Missing Hostname
    MissingHost,

    /// HTTPS requested but TLS features not enabled
    TlsNotEnabled,

    /// SSL Connection Error
    #[cfg(all(feature = "client-tls", any(target_os = "macos", target_os = "windows", target_os = "ios")))]
    SslError(native_tls::Error),

    /// SSL Connection Error
    #[cfg(all(feature = "client-tls", not(any(target_os = "macos", target_os = "windows", target_os = "ios"))))]
    SslError(openssl::error::ErrorStack),
}

impl From<hyper::http::uri::InvalidUri> for ClientInitError {
    fn from(err: hyper::http::uri::InvalidUri) -> ClientInitError {
        ClientInitError::InvalidUri(err)
    }
}

impl fmt::Display for ClientInitError {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        let s: &dyn fmt::Debug = self;
        s.fmt(f)
    }
}

impl Error for ClientInitError {
    fn description(&self) -> &str {
        "Failed to produce a hyper client."
    }
}

#[allow(dead_code)]
fn body_from_string(s: String) -> BoxBody<Bytes, Infallible> {
    BoxBody::new(Full::new(Bytes::from(s)))
}

#[allow(dead_code)]
fn body_from_bytes(b: Vec<u8>) -> BoxBody<Bytes, Infallible> {
    BoxBody::new(Full::new(Bytes::from(b)))
}

#[async_trait]
impl<S, C, B> Api<C> for Client<S, C> where
    S: Service<
       (Request<BoxBody<Bytes, Infallible>>, C),
       Response=Response<B>> + Clone + Sync + Send + 'static,
    S::Future: Send + 'static,
    S::Error: Into<crate::ServiceError> + fmt::Display,
    C: Has<XSpanIdString> + Has<Option<AuthData>> + Clone + Send + Sync + 'static,
    B: hyper::body::Body + Send + 'static + Unpin,
    B::Data: Send,
    B::Error: Into<Box<dyn Error + Send + Sync>>,
{

    #[allow(clippy::vec_init_then_push)]
    async fn add_rule(
        &self,
        param_param_type: models::DenyRuleNewType,
        param_data: String,
        param_user: Option<String>,
        context: &C) -> Result<AddRuleResponse, ApiError>
    {
        let mut client_service = self.client_service.clone();
        #[allow(clippy::uninlined_format_args)]
        let mut uri = format!(
            "{}/mail/rules",
            self.base_path
        );

        // Query parameters
        let query_string = {
            let mut query_string = form_urlencoded::Serializer::new("".to_owned());
            query_string.finish()
        };
        if !query_string.is_empty() {
            uri += "?";
            uri += &query_string;
        }

        let uri = match Uri::from_str(&uri) {
            Ok(uri) => uri,
            Err(err) => return Err(ApiError(format!("Unable to build URI: {err}"))),
        };

        let mut request = match Request::builder()
            .method("POST")
            .uri(uri)
            .body(BoxBody::new(http_body_util::Empty::new())) {
                Ok(req) => req,
                Err(e) => return Err(ApiError(format!("Unable to create request: {e}")))
        };

        // Consumes form body
        let mut params = vec![];
        if let Some(param_user) = param_user {
        #[allow(clippy::uninlined_format_args)]
        params.push(("user",
            param_user
        ));
        }
        #[allow(clippy::uninlined_format_args)]
        params.push(("type",
            format!("{}", param_param_type)
        ));
        #[allow(clippy::uninlined_format_args)]
        params.push(("data",
            param_data
        ));

        let body = serde_urlencoded::to_string(params).expect("impossible to fail to serialize");

        *request.body_mut() = body_from_string(body);

        let header = "application/x-www-form-urlencoded";
        request.headers_mut().insert(CONTENT_TYPE, HeaderValue::from_static(header));

        // Consumes basic body

        let header = HeaderValue::from_str(Has::<XSpanIdString>::get(context).0.as_str());
        request.headers_mut().insert(HeaderName::from_static("x-span-id"), match header {
            Ok(h) => h,
            Err(e) => return Err(ApiError(format!("Unable to create X-Span ID header value: {e}")))
        });

        #[allow(clippy::collapsible_match)]
        if let Some(auth_data) = Has::<Option<AuthData>>::get(context).as_ref() {
            use headers::authorization::Credentials;
            // The trailing `_` arm is unreachable when the spec declares every kind of
            // scheme `AuthData` can represent, and the workspace denies warnings.
            #[allow(unreachable_patterns, clippy::single_match, clippy::match_single_binding)]
            match auth_data {
                AuthData::ApiKey(ref api_key) => {
                    let header = match HeaderValue::from_str(api_key.as_str()) {
                        Ok(h) => h,
                        Err(e) => return Err(ApiError(format!("Unable to create header: {e}")))
                    };
                    request.headers_mut().insert(
                        HeaderName::from_static("x-api-key"),
                        header);
                },
                _ => {}
            }
        }

        let response = client_service.call((request, context.clone()))
            .map_err(|e| ApiError(format!("No response received: {e}"))).await?;

        match response.status().as_u16() {
            200 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::GenericResponse>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(AddRuleResponse::RuleCreatedSuccessfully
                    (body)
                )
            }
            400 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(AddRuleResponse::BadRequest
                    (body)
                )
            }
            401 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(AddRuleResponse::AuthenticationFailed
                    (body)
                )
            }
            404 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(AddRuleResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                    (body)
                )
            }
            code => {
                let headers = response.headers().clone();
                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec());
                Err(ApiError(format!("Unexpected response code {code}:\n{headers:?}\n\n{}",
                    match body {
                        Ok(body) => match String::from_utf8(body) {
                            Ok(body) => body,
                            Err(e) => format!("<Body was not UTF8: {e:?}>"),
                        },
                        Err(e) => format!("<Failed to read body: {}>", Into::<crate::ServiceError>::into(e)),
                    }
                )))
            }
        }
    }

    #[allow(clippy::vec_init_then_push)]
    async fn delist_block(
        &self,
        param_email_address_param: models::EmailAddressParam,
        context: &C) -> Result<DelistBlockResponse, ApiError>
    {
        let mut client_service = self.client_service.clone();
        #[allow(clippy::uninlined_format_args)]
        let mut uri = format!(
            "{}/mail/blocks/delete",
            self.base_path
        );

        // Query parameters
        let query_string = {
            let mut query_string = form_urlencoded::Serializer::new("".to_owned());
            query_string.finish()
        };
        if !query_string.is_empty() {
            uri += "?";
            uri += &query_string;
        }

        let uri = match Uri::from_str(&uri) {
            Ok(uri) => uri,
            Err(err) => return Err(ApiError(format!("Unable to build URI: {err}"))),
        };

        let mut request = match Request::builder()
            .method("POST")
            .uri(uri)
            .body(BoxBody::new(http_body_util::Empty::new())) {
                Ok(req) => req,
                Err(e) => return Err(ApiError(format!("Unable to create request: {e}")))
        };

        // Consumes form body

        // Consumes basic body
        // Body parameter
        let body = serde_json::to_string(&param_email_address_param).expect("impossible to fail to serialize");
        *request.body_mut() = body_from_string(body);

        let header = "application/json";
        request.headers_mut().insert(CONTENT_TYPE, HeaderValue::from_static(header));

        let header = HeaderValue::from_str(Has::<XSpanIdString>::get(context).0.as_str());
        request.headers_mut().insert(HeaderName::from_static("x-span-id"), match header {
            Ok(h) => h,
            Err(e) => return Err(ApiError(format!("Unable to create X-Span ID header value: {e}")))
        });

        #[allow(clippy::collapsible_match)]
        if let Some(auth_data) = Has::<Option<AuthData>>::get(context).as_ref() {
            use headers::authorization::Credentials;
            // The trailing `_` arm is unreachable when the spec declares every kind of
            // scheme `AuthData` can represent, and the workspace denies warnings.
            #[allow(unreachable_patterns, clippy::single_match, clippy::match_single_binding)]
            match auth_data {
                AuthData::ApiKey(ref api_key) => {
                    let header = match HeaderValue::from_str(api_key.as_str()) {
                        Ok(h) => h,
                        Err(e) => return Err(ApiError(format!("Unable to create header: {e}")))
                    };
                    request.headers_mut().insert(
                        HeaderName::from_static("x-api-key"),
                        header);
                },
                _ => {}
            }
        }

        let response = client_service.call((request, context.clone()))
            .map_err(|e| ApiError(format!("No response received: {e}"))).await?;

        match response.status().as_u16() {
            200 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::GenericResponse>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(DelistBlockResponse::AddressSuccessfullyDelisted
                    (body)
                )
            }
            400 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(DelistBlockResponse::BadRequest
                    (body)
                )
            }
            401 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(DelistBlockResponse::AuthenticationFailed
                    (body)
                )
            }
            404 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(DelistBlockResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                    (body)
                )
            }
            code => {
                let headers = response.headers().clone();
                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec());
                Err(ApiError(format!("Unexpected response code {code}:\n{headers:?}\n\n{}",
                    match body {
                        Ok(body) => match String::from_utf8(body) {
                            Ok(body) => body,
                            Err(e) => format!("<Body was not UTF8: {e:?}>"),
                        },
                        Err(e) => format!("<Failed to read body: {}>", Into::<crate::ServiceError>::into(e)),
                    }
                )))
            }
        }
    }

    #[allow(clippy::vec_init_then_push)]
    async fn get_mail_blocks(
        &self,
        context: &C) -> Result<GetMailBlocksResponse, ApiError>
    {
        let mut client_service = self.client_service.clone();
        #[allow(clippy::uninlined_format_args)]
        let mut uri = format!(
            "{}/mail/blocks",
            self.base_path
        );

        // Query parameters
        let query_string = {
            let mut query_string = form_urlencoded::Serializer::new("".to_owned());
            query_string.finish()
        };
        if !query_string.is_empty() {
            uri += "?";
            uri += &query_string;
        }

        let uri = match Uri::from_str(&uri) {
            Ok(uri) => uri,
            Err(err) => return Err(ApiError(format!("Unable to build URI: {err}"))),
        };

        let mut request = match Request::builder()
            .method("GET")
            .uri(uri)
            .body(BoxBody::new(http_body_util::Empty::new())) {
                Ok(req) => req,
                Err(e) => return Err(ApiError(format!("Unable to create request: {e}")))
        };

        let header = HeaderValue::from_str(Has::<XSpanIdString>::get(context).0.as_str());
        request.headers_mut().insert(HeaderName::from_static("x-span-id"), match header {
            Ok(h) => h,
            Err(e) => return Err(ApiError(format!("Unable to create X-Span ID header value: {e}")))
        });

        #[allow(clippy::collapsible_match)]
        if let Some(auth_data) = Has::<Option<AuthData>>::get(context).as_ref() {
            use headers::authorization::Credentials;
            // The trailing `_` arm is unreachable when the spec declares every kind of
            // scheme `AuthData` can represent, and the workspace denies warnings.
            #[allow(unreachable_patterns, clippy::single_match, clippy::match_single_binding)]
            match auth_data {
                AuthData::ApiKey(ref api_key) => {
                    let header = match HeaderValue::from_str(api_key.as_str()) {
                        Ok(h) => h,
                        Err(e) => return Err(ApiError(format!("Unable to create header: {e}")))
                    };
                    request.headers_mut().insert(
                        HeaderName::from_static("x-api-key"),
                        header);
                },
                _ => {}
            }
        }

        let response = client_service.call((request, context.clone()))
            .map_err(|e| ApiError(format!("No response received: {e}"))).await?;

        match response.status().as_u16() {
            200 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::MailBlocks>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(GetMailBlocksResponse::OK
                    (body)
                )
            }
            401 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(GetMailBlocksResponse::AuthenticationFailed
                    (body)
                )
            }
            code => {
                let headers = response.headers().clone();
                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec());
                Err(ApiError(format!("Unexpected response code {code}:\n{headers:?}\n\n{}",
                    match body {
                        Ok(body) => match String::from_utf8(body) {
                            Ok(body) => body,
                            Err(e) => format!("<Body was not UTF8: {e:?}>"),
                        },
                        Err(e) => format!("<Failed to read body: {}>", Into::<crate::ServiceError>::into(e)),
                    }
                )))
            }
        }
    }

    #[allow(clippy::vec_init_then_push)]
    async fn get_rules(
        &self,
        context: &C) -> Result<GetRulesResponse, ApiError>
    {
        let mut client_service = self.client_service.clone();
        #[allow(clippy::uninlined_format_args)]
        let mut uri = format!(
            "{}/mail/rules",
            self.base_path
        );

        // Query parameters
        let query_string = {
            let mut query_string = form_urlencoded::Serializer::new("".to_owned());
            query_string.finish()
        };
        if !query_string.is_empty() {
            uri += "?";
            uri += &query_string;
        }

        let uri = match Uri::from_str(&uri) {
            Ok(uri) => uri,
            Err(err) => return Err(ApiError(format!("Unable to build URI: {err}"))),
        };

        let mut request = match Request::builder()
            .method("GET")
            .uri(uri)
            .body(BoxBody::new(http_body_util::Empty::new())) {
                Ok(req) => req,
                Err(e) => return Err(ApiError(format!("Unable to create request: {e}")))
        };

        let header = HeaderValue::from_str(Has::<XSpanIdString>::get(context).0.as_str());
        request.headers_mut().insert(HeaderName::from_static("x-span-id"), match header {
            Ok(h) => h,
            Err(e) => return Err(ApiError(format!("Unable to create X-Span ID header value: {e}")))
        });

        #[allow(clippy::collapsible_match)]
        if let Some(auth_data) = Has::<Option<AuthData>>::get(context).as_ref() {
            use headers::authorization::Credentials;
            // The trailing `_` arm is unreachable when the spec declares every kind of
            // scheme `AuthData` can represent, and the workspace denies warnings.
            #[allow(unreachable_patterns, clippy::single_match, clippy::match_single_binding)]
            match auth_data {
                AuthData::ApiKey(ref api_key) => {
                    let header = match HeaderValue::from_str(api_key.as_str()) {
                        Ok(h) => h,
                        Err(e) => return Err(ApiError(format!("Unable to create header: {e}")))
                    };
                    request.headers_mut().insert(
                        HeaderName::from_static("x-api-key"),
                        header);
                },
                _ => {}
            }
        }

        let response = client_service.call((request, context.clone()))
            .map_err(|e| ApiError(format!("No response received: {e}"))).await?;

        match response.status().as_u16() {
            200 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<Vec<models::DenyRuleRecord>>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(GetRulesResponse::OK
                    (body)
                )
            }
            401 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(GetRulesResponse::AuthenticationFailed
                    (body)
                )
            }
            code => {
                let headers = response.headers().clone();
                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec());
                Err(ApiError(format!("Unexpected response code {code}:\n{headers:?}\n\n{}",
                    match body {
                        Ok(body) => match String::from_utf8(body) {
                            Ok(body) => body,
                            Err(e) => format!("<Body was not UTF8: {e:?}>"),
                        },
                        Err(e) => format!("<Failed to read body: {}>", Into::<crate::ServiceError>::into(e)),
                    }
                )))
            }
        }
    }

    #[allow(clippy::vec_init_then_push)]
    async fn delete_rule(
        &self,
        param_rule_id: i32,
        context: &C) -> Result<DeleteRuleResponse, ApiError>
    {
        let mut client_service = self.client_service.clone();
        #[allow(clippy::uninlined_format_args)]
        let mut uri = format!(
            "{}/mail/rules/{rule_id}",
            self.base_path
            ,rule_id=utf8_percent_encode(&param_rule_id.to_string(), ID_ENCODE_SET)
        );

        // Query parameters
        let query_string = {
            let mut query_string = form_urlencoded::Serializer::new("".to_owned());
            query_string.finish()
        };
        if !query_string.is_empty() {
            uri += "?";
            uri += &query_string;
        }

        let uri = match Uri::from_str(&uri) {
            Ok(uri) => uri,
            Err(err) => return Err(ApiError(format!("Unable to build URI: {err}"))),
        };

        let mut request = match Request::builder()
            .method("DELETE")
            .uri(uri)
            .body(BoxBody::new(http_body_util::Empty::new())) {
                Ok(req) => req,
                Err(e) => return Err(ApiError(format!("Unable to create request: {e}")))
        };

        let header = HeaderValue::from_str(Has::<XSpanIdString>::get(context).0.as_str());
        request.headers_mut().insert(HeaderName::from_static("x-span-id"), match header {
            Ok(h) => h,
            Err(e) => return Err(ApiError(format!("Unable to create X-Span ID header value: {e}")))
        });

        #[allow(clippy::collapsible_match)]
        if let Some(auth_data) = Has::<Option<AuthData>>::get(context).as_ref() {
            use headers::authorization::Credentials;
            // The trailing `_` arm is unreachable when the spec declares every kind of
            // scheme `AuthData` can represent, and the workspace denies warnings.
            #[allow(unreachable_patterns, clippy::single_match, clippy::match_single_binding)]
            match auth_data {
                AuthData::ApiKey(ref api_key) => {
                    let header = match HeaderValue::from_str(api_key.as_str()) {
                        Ok(h) => h,
                        Err(e) => return Err(ApiError(format!("Unable to create header: {e}")))
                    };
                    request.headers_mut().insert(
                        HeaderName::from_static("x-api-key"),
                        header);
                },
                _ => {}
            }
        }

        let response = client_service.call((request, context.clone()))
            .map_err(|e| ApiError(format!("No response received: {e}"))).await?;

        match response.status().as_u16() {
            200 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::GenericResponse>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(DeleteRuleResponse::RuleDeletedSuccessfully
                    (body)
                )
            }
            400 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(DeleteRuleResponse::BadRequest
                    (body)
                )
            }
            401 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(DeleteRuleResponse::AuthenticationFailed
                    (body)
                )
            }
            404 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(DeleteRuleResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                    (body)
                )
            }
            code => {
                let headers = response.headers().clone();
                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec());
                Err(ApiError(format!("Unexpected response code {code}:\n{headers:?}\n\n{}",
                    match body {
                        Ok(body) => match String::from_utf8(body) {
                            Ok(body) => body,
                            Err(e) => format!("<Body was not UTF8: {e:?}>"),
                        },
                        Err(e) => format!("<Failed to read body: {}>", Into::<crate::ServiceError>::into(e)),
                    }
                )))
            }
        }
    }

    #[allow(clippy::vec_init_then_push)]
    async fn get_stats(
        &self,
        param_time: Option<models::GetStatsTimeParameter>,
        context: &C) -> Result<GetStatsResponse, ApiError>
    {
        let mut client_service = self.client_service.clone();
        #[allow(clippy::uninlined_format_args)]
        let mut uri = format!(
            "{}/mail/stats",
            self.base_path
        );

        // Query parameters
        let query_string = {
            let mut query_string = form_urlencoded::Serializer::new("".to_owned());
            if let Some(param_time) = param_time {
                query_string.append_pair("time",
                    &param_time.to_string());
            }
            query_string.finish()
        };
        if !query_string.is_empty() {
            uri += "?";
            uri += &query_string;
        }

        let uri = match Uri::from_str(&uri) {
            Ok(uri) => uri,
            Err(err) => return Err(ApiError(format!("Unable to build URI: {err}"))),
        };

        let mut request = match Request::builder()
            .method("GET")
            .uri(uri)
            .body(BoxBody::new(http_body_util::Empty::new())) {
                Ok(req) => req,
                Err(e) => return Err(ApiError(format!("Unable to create request: {e}")))
        };

        let header = HeaderValue::from_str(Has::<XSpanIdString>::get(context).0.as_str());
        request.headers_mut().insert(HeaderName::from_static("x-span-id"), match header {
            Ok(h) => h,
            Err(e) => return Err(ApiError(format!("Unable to create X-Span ID header value: {e}")))
        });

        #[allow(clippy::collapsible_match)]
        if let Some(auth_data) = Has::<Option<AuthData>>::get(context).as_ref() {
            use headers::authorization::Credentials;
            // The trailing `_` arm is unreachable when the spec declares every kind of
            // scheme `AuthData` can represent, and the workspace denies warnings.
            #[allow(unreachable_patterns, clippy::single_match, clippy::match_single_binding)]
            match auth_data {
                AuthData::ApiKey(ref api_key) => {
                    let header = match HeaderValue::from_str(api_key.as_str()) {
                        Ok(h) => h,
                        Err(e) => return Err(ApiError(format!("Unable to create header: {e}")))
                    };
                    request.headers_mut().insert(
                        HeaderName::from_static("x-api-key"),
                        header);
                },
                _ => {}
            }
        }

        let response = client_service.call((request, context.clone()))
            .map_err(|e| ApiError(format!("No response received: {e}"))).await?;

        match response.status().as_u16() {
            200 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::MailStatsType>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(GetStatsResponse::OK
                    (body)
                )
            }
            401 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(GetStatsResponse::AuthenticationFailed
                    (body)
                )
            }
            code => {
                let headers = response.headers().clone();
                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec());
                Err(ApiError(format!("Unexpected response code {code}:\n{headers:?}\n\n{}",
                    match body {
                        Ok(body) => match String::from_utf8(body) {
                            Ok(body) => body,
                            Err(e) => format!("<Body was not UTF8: {e:?}>"),
                        },
                        Err(e) => format!("<Failed to read body: {}>", Into::<crate::ServiceError>::into(e)),
                    }
                )))
            }
        }
    }

    #[allow(clippy::vec_init_then_push)]
    async fn view_mail_log(
        &self,
        param_id: Option<i64>,
        param_origin: Option<String>,
        param_mx: Option<String>,
        param_from: Option<String>,
        param_to: Option<String>,
        param_subject: Option<String>,
        param_mailid: Option<String>,
        param_message_id: Option<String>,
        param_replyto: Option<String>,
        param_headerfrom: Option<String>,
        param_delivered: Option<models::DeliveredStatus>,
        param_skip: Option<u32>,
        param_limit: Option<u32>,
        param_start_date: Option<models::DateOrTimestamp>,
        param_end_date: Option<models::DateOrTimestamp>,
        param_sort: Option<models::ViewMailLogSortParameter>,
        param_dir: Option<models::ViewMailLogDirParameter>,
        param_groupby: Option<models::ViewMailLogGroupbyParameter>,
        context: &C) -> Result<ViewMailLogResponse, ApiError>
    {
        let mut client_service = self.client_service.clone();
        #[allow(clippy::uninlined_format_args)]
        let mut uri = format!(
            "{}/mail/log",
            self.base_path
        );

        // Query parameters
        let query_string = {
            let mut query_string = form_urlencoded::Serializer::new("".to_owned());
            if let Some(param_id) = param_id {
                query_string.append_pair("id",
                    &param_id.to_string());
            }
            if let Some(param_origin) = param_origin {
                query_string.append_pair("origin",
                    &param_origin);
            }
            if let Some(param_mx) = param_mx {
                query_string.append_pair("mx",
                    &param_mx);
            }
            if let Some(param_from) = param_from {
                query_string.append_pair("from",
                    &param_from);
            }
            if let Some(param_to) = param_to {
                query_string.append_pair("to",
                    &param_to);
            }
            if let Some(param_subject) = param_subject {
                query_string.append_pair("subject",
                    &param_subject);
            }
            if let Some(param_mailid) = param_mailid {
                query_string.append_pair("mailid",
                    &param_mailid);
            }
            if let Some(param_message_id) = param_message_id {
                query_string.append_pair("messageId",
                    &param_message_id);
            }
            if let Some(param_replyto) = param_replyto {
                query_string.append_pair("replyto",
                    &param_replyto);
            }
            if let Some(param_headerfrom) = param_headerfrom {
                query_string.append_pair("headerfrom",
                    &param_headerfrom);
            }
            if let Some(param_delivered) = param_delivered {
                query_string.append_pair("delivered",
                    &param_delivered.to_string());
            }
            if let Some(param_skip) = param_skip {
                query_string.append_pair("skip",
                    &param_skip.to_string());
            }
            if let Some(param_limit) = param_limit {
                query_string.append_pair("limit",
                    &param_limit.to_string());
            }
            if let Some(param_start_date) = param_start_date {
                query_string.append_pair("startDate",
                    &param_start_date.to_string());
            }
            if let Some(param_end_date) = param_end_date {
                query_string.append_pair("endDate",
                    &param_end_date.to_string());
            }
            if let Some(param_sort) = param_sort {
                query_string.append_pair("sort",
                    &param_sort.to_string());
            }
            if let Some(param_dir) = param_dir {
                query_string.append_pair("dir",
                    &param_dir.to_string());
            }
            if let Some(param_groupby) = param_groupby {
                query_string.append_pair("groupby",
                    &param_groupby.to_string());
            }
            query_string.finish()
        };
        if !query_string.is_empty() {
            uri += "?";
            uri += &query_string;
        }

        let uri = match Uri::from_str(&uri) {
            Ok(uri) => uri,
            Err(err) => return Err(ApiError(format!("Unable to build URI: {err}"))),
        };

        let mut request = match Request::builder()
            .method("GET")
            .uri(uri)
            .body(BoxBody::new(http_body_util::Empty::new())) {
                Ok(req) => req,
                Err(e) => return Err(ApiError(format!("Unable to create request: {e}")))
        };

        let header = HeaderValue::from_str(Has::<XSpanIdString>::get(context).0.as_str());
        request.headers_mut().insert(HeaderName::from_static("x-span-id"), match header {
            Ok(h) => h,
            Err(e) => return Err(ApiError(format!("Unable to create X-Span ID header value: {e}")))
        });

        #[allow(clippy::collapsible_match)]
        if let Some(auth_data) = Has::<Option<AuthData>>::get(context).as_ref() {
            use headers::authorization::Credentials;
            // The trailing `_` arm is unreachable when the spec declares every kind of
            // scheme `AuthData` can represent, and the workspace denies warnings.
            #[allow(unreachable_patterns, clippy::single_match, clippy::match_single_binding)]
            match auth_data {
                AuthData::ApiKey(ref api_key) => {
                    let header = match HeaderValue::from_str(api_key.as_str()) {
                        Ok(h) => h,
                        Err(e) => return Err(ApiError(format!("Unable to create header: {e}")))
                    };
                    request.headers_mut().insert(
                        HeaderName::from_static("x-api-key"),
                        header);
                },
                _ => {}
            }
        }

        let response = client_service.call((request, context.clone()))
            .map_err(|e| ApiError(format!("No response received: {e}"))).await?;

        match response.status().as_u16() {
            200 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::MailLog>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(ViewMailLogResponse::PaginatedListOfMailLogEntries
                    (body)
                )
            }
            400 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(ViewMailLogResponse::BadRequest
                    (body)
                )
            }
            401 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(ViewMailLogResponse::AuthenticationFailed
                    (body)
                )
            }
            code => {
                let headers = response.headers().clone();
                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec());
                Err(ApiError(format!("Unexpected response code {code}:\n{headers:?}\n\n{}",
                    match body {
                        Ok(body) => match String::from_utf8(body) {
                            Ok(body) => body,
                            Err(e) => format!("<Body was not UTF8: {e:?}>"),
                        },
                        Err(e) => format!("<Failed to read body: {}>", Into::<crate::ServiceError>::into(e)),
                    }
                )))
            }
        }
    }

    #[allow(clippy::vec_init_then_push)]
    async fn raw_mail(
        &self,
        param_send_mail_raw: models::SendMailRaw,
        context: &C) -> Result<RawMailResponse, ApiError>
    {
        let mut client_service = self.client_service.clone();
        #[allow(clippy::uninlined_format_args)]
        let mut uri = format!(
            "{}/mail/rawsend",
            self.base_path
        );

        // Query parameters
        let query_string = {
            let mut query_string = form_urlencoded::Serializer::new("".to_owned());
            query_string.finish()
        };
        if !query_string.is_empty() {
            uri += "?";
            uri += &query_string;
        }

        let uri = match Uri::from_str(&uri) {
            Ok(uri) => uri,
            Err(err) => return Err(ApiError(format!("Unable to build URI: {err}"))),
        };

        let mut request = match Request::builder()
            .method("POST")
            .uri(uri)
            .body(BoxBody::new(http_body_util::Empty::new())) {
                Ok(req) => req,
                Err(e) => return Err(ApiError(format!("Unable to create request: {e}")))
        };

        // Consumes multipart/form body
        let (body_bytes, multipart_header) = {
            let mut multipart = Multipart::new();


            let mut fields = match multipart.prepare() {
                Ok(fields) => fields,
                Err(err) => return Err(ApiError(format!("Unable to build request: {err}"))),
            };

            let mut body_bytes = Vec::new();

            match fields.read_to_end(&mut body_bytes) {
                Ok(_) => (),
                Err(err) => return Err(ApiError(format!("Unable to build body: {err}"))),
            }

            let boundary = fields.boundary();

            let multipart_header = format!("multipart/form-data;boundary={boundary}");

            (body_bytes, multipart_header)
          };

        *request.body_mut() = BoxBody::new(Full::new(Bytes::from(body_bytes)));

        request.headers_mut().insert(CONTENT_TYPE, match HeaderValue::from_str(&multipart_header) {
            Ok(h) => h,
            Err(e) => return Err(ApiError(format!("Unable to create header: {multipart_header} - {e}")))
        });

        // Consumes basic body
        // Body parameter
        let body = serde_json::to_string(&param_send_mail_raw).expect("impossible to fail to serialize");
        *request.body_mut() = body_from_string(body);

        let header = "application/json";
        request.headers_mut().insert(CONTENT_TYPE, HeaderValue::from_static(header));

        let header = HeaderValue::from_str(Has::<XSpanIdString>::get(context).0.as_str());
        request.headers_mut().insert(HeaderName::from_static("x-span-id"), match header {
            Ok(h) => h,
            Err(e) => return Err(ApiError(format!("Unable to create X-Span ID header value: {e}")))
        });

        #[allow(clippy::collapsible_match)]
        if let Some(auth_data) = Has::<Option<AuthData>>::get(context).as_ref() {
            use headers::authorization::Credentials;
            // The trailing `_` arm is unreachable when the spec declares every kind of
            // scheme `AuthData` can represent, and the workspace denies warnings.
            #[allow(unreachable_patterns, clippy::single_match, clippy::match_single_binding)]
            match auth_data {
                AuthData::ApiKey(ref api_key) => {
                    let header = match HeaderValue::from_str(api_key.as_str()) {
                        Ok(h) => h,
                        Err(e) => return Err(ApiError(format!("Unable to create header: {e}")))
                    };
                    request.headers_mut().insert(
                        HeaderName::from_static("x-api-key"),
                        header);
                },
                _ => {}
            }
        }

        let response = client_service.call((request, context.clone()))
            .map_err(|e| ApiError(format!("No response received: {e}"))).await?;

        match response.status().as_u16() {
            200 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::GenericResponse>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(RawMailResponse::EmailAcceptedForDelivery
                    (body)
                )
            }
            400 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(RawMailResponse::BadRequest
                    (body)
                )
            }
            401 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(RawMailResponse::AuthenticationFailed
                    (body)
                )
            }
            404 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(RawMailResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                    (body)
                )
            }
            code => {
                let headers = response.headers().clone();
                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec());
                Err(ApiError(format!("Unexpected response code {code}:\n{headers:?}\n\n{}",
                    match body {
                        Ok(body) => match String::from_utf8(body) {
                            Ok(body) => body,
                            Err(e) => format!("<Body was not UTF8: {e:?}>"),
                        },
                        Err(e) => format!("<Failed to read body: {}>", Into::<crate::ServiceError>::into(e)),
                    }
                )))
            }
        }
    }

    #[allow(clippy::vec_init_then_push)]
    async fn send_adv_mail<'a>(
        &self,
        param_subject: String,
        param_body: String,
        param_from: models::EmailAddressTypes,
        param_to: models::EmailAddressesTypes,
        param_replyto: Option<models::EmailAddressesTypes>,
        param_cc: Option<models::EmailAddressesTypes>,
        param_bcc: Option<models::EmailAddressesTypes>,
        param_attachments: Option<&'a Vec<models::MailAttachment>>,
        param_id: Option<i64>,
        context: &C) -> Result<SendAdvMailResponse, ApiError>
    {
        let mut client_service = self.client_service.clone();
        #[allow(clippy::uninlined_format_args)]
        let mut uri = format!(
            "{}/mail/advsend",
            self.base_path
        );

        // Query parameters
        let query_string = {
            let mut query_string = form_urlencoded::Serializer::new("".to_owned());
            query_string.finish()
        };
        if !query_string.is_empty() {
            uri += "?";
            uri += &query_string;
        }

        let uri = match Uri::from_str(&uri) {
            Ok(uri) => uri,
            Err(err) => return Err(ApiError(format!("Unable to build URI: {err}"))),
        };

        let mut request = match Request::builder()
            .method("POST")
            .uri(uri)
            .body(BoxBody::new(http_body_util::Empty::new())) {
                Ok(req) => req,
                Err(e) => return Err(ApiError(format!("Unable to create request: {e}")))
        };

        // Consumes form body
        let mut params = vec![];
        #[allow(clippy::uninlined_format_args)]
        params.push(("subject",
            param_subject
        ));
        #[allow(clippy::uninlined_format_args)]
        params.push(("body",
            param_body
        ));
        #[allow(clippy::uninlined_format_args)]
        params.push(("from",
            format!("{:?}", param_from)
        ));
        #[allow(clippy::uninlined_format_args)]
        params.push(("to",
            format!("{:?}", param_to)
        ));
        if let Some(param_replyto) = param_replyto {
        #[allow(clippy::uninlined_format_args)]
        params.push(("replyto",
            format!("{:?}", param_replyto)
        ));
        }
        if let Some(param_cc) = param_cc {
        #[allow(clippy::uninlined_format_args)]
        params.push(("cc",
            format!("{:?}", param_cc)
        ));
        }
        if let Some(param_bcc) = param_bcc {
        #[allow(clippy::uninlined_format_args)]
        params.push(("bcc",
            format!("{:?}", param_bcc)
        ));
        }
        if let Some(param_attachments) = param_attachments {
        // style=form,explode=true
        for param_attachments in param_attachments {
        #[allow(clippy::uninlined_format_args)]
        params.push(("attachments",
            format!("{:?}", param_attachments)
        ));
        }
        }
        if let Some(param_id) = param_id {
        #[allow(clippy::uninlined_format_args)]
        params.push(("id",
            format!("{:?}", param_id)
        ));
        }

        let body = serde_urlencoded::to_string(params).expect("impossible to fail to serialize");

        *request.body_mut() = body_from_string(body);

        let header = "application/x-www-form-urlencoded";
        request.headers_mut().insert(CONTENT_TYPE, HeaderValue::from_static(header));

        // Consumes basic body

        let header = HeaderValue::from_str(Has::<XSpanIdString>::get(context).0.as_str());
        request.headers_mut().insert(HeaderName::from_static("x-span-id"), match header {
            Ok(h) => h,
            Err(e) => return Err(ApiError(format!("Unable to create X-Span ID header value: {e}")))
        });

        #[allow(clippy::collapsible_match)]
        if let Some(auth_data) = Has::<Option<AuthData>>::get(context).as_ref() {
            use headers::authorization::Credentials;
            // The trailing `_` arm is unreachable when the spec declares every kind of
            // scheme `AuthData` can represent, and the workspace denies warnings.
            #[allow(unreachable_patterns, clippy::single_match, clippy::match_single_binding)]
            match auth_data {
                AuthData::ApiKey(ref api_key) => {
                    let header = match HeaderValue::from_str(api_key.as_str()) {
                        Ok(h) => h,
                        Err(e) => return Err(ApiError(format!("Unable to create header: {e}")))
                    };
                    request.headers_mut().insert(
                        HeaderName::from_static("x-api-key"),
                        header);
                },
                _ => {}
            }
        }

        let response = client_service.call((request, context.clone()))
            .map_err(|e| ApiError(format!("No response received: {e}"))).await?;

        match response.status().as_u16() {
            200 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::GenericResponse>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(SendAdvMailResponse::EmailAcceptedForDelivery
                    (body)
                )
            }
            400 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(SendAdvMailResponse::BadRequest
                    (body)
                )
            }
            401 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(SendAdvMailResponse::AuthenticationFailed
                    (body)
                )
            }
            404 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(SendAdvMailResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                    (body)
                )
            }
            code => {
                let headers = response.headers().clone();
                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec());
                Err(ApiError(format!("Unexpected response code {code}:\n{headers:?}\n\n{}",
                    match body {
                        Ok(body) => match String::from_utf8(body) {
                            Ok(body) => body,
                            Err(e) => format!("<Body was not UTF8: {e:?}>"),
                        },
                        Err(e) => format!("<Failed to read body: {}>", Into::<crate::ServiceError>::into(e)),
                    }
                )))
            }
        }
    }

    #[allow(clippy::vec_init_then_push)]
    async fn send_mail(
        &self,
        param_to: models::SendMailTo,
        param_from: String,
        param_subject: String,
        param_body: String,
        param_id: Option<i64>,
        context: &C) -> Result<SendMailResponse, ApiError>
    {
        let mut client_service = self.client_service.clone();
        #[allow(clippy::uninlined_format_args)]
        let mut uri = format!(
            "{}/mail/send",
            self.base_path
        );

        // Query parameters
        let query_string = {
            let mut query_string = form_urlencoded::Serializer::new("".to_owned());
            query_string.finish()
        };
        if !query_string.is_empty() {
            uri += "?";
            uri += &query_string;
        }

        let uri = match Uri::from_str(&uri) {
            Ok(uri) => uri,
            Err(err) => return Err(ApiError(format!("Unable to build URI: {err}"))),
        };

        let mut request = match Request::builder()
            .method("POST")
            .uri(uri)
            .body(BoxBody::new(http_body_util::Empty::new())) {
                Ok(req) => req,
                Err(e) => return Err(ApiError(format!("Unable to create request: {e}")))
        };

        // Consumes form body
        let mut params = vec![];
        #[allow(clippy::uninlined_format_args)]
        params.push(("to",
            format!("{:?}", param_to)
        ));
        #[allow(clippy::uninlined_format_args)]
        params.push(("from",
            param_from
        ));
        #[allow(clippy::uninlined_format_args)]
        params.push(("subject",
            param_subject
        ));
        #[allow(clippy::uninlined_format_args)]
        params.push(("body",
            param_body
        ));
        if let Some(param_id) = param_id {
        #[allow(clippy::uninlined_format_args)]
        params.push(("id",
            format!("{:?}", param_id)
        ));
        }

        let body = serde_urlencoded::to_string(params).expect("impossible to fail to serialize");

        *request.body_mut() = body_from_string(body);

        let header = "application/x-www-form-urlencoded";
        request.headers_mut().insert(CONTENT_TYPE, HeaderValue::from_static(header));

        // Consumes basic body

        let header = HeaderValue::from_str(Has::<XSpanIdString>::get(context).0.as_str());
        request.headers_mut().insert(HeaderName::from_static("x-span-id"), match header {
            Ok(h) => h,
            Err(e) => return Err(ApiError(format!("Unable to create X-Span ID header value: {e}")))
        });

        #[allow(clippy::collapsible_match)]
        if let Some(auth_data) = Has::<Option<AuthData>>::get(context).as_ref() {
            use headers::authorization::Credentials;
            // The trailing `_` arm is unreachable when the spec declares every kind of
            // scheme `AuthData` can represent, and the workspace denies warnings.
            #[allow(unreachable_patterns, clippy::single_match, clippy::match_single_binding)]
            match auth_data {
                AuthData::ApiKey(ref api_key) => {
                    let header = match HeaderValue::from_str(api_key.as_str()) {
                        Ok(h) => h,
                        Err(e) => return Err(ApiError(format!("Unable to create header: {e}")))
                    };
                    request.headers_mut().insert(
                        HeaderName::from_static("x-api-key"),
                        header);
                },
                _ => {}
            }
        }

        let response = client_service.call((request, context.clone()))
            .map_err(|e| ApiError(format!("No response received: {e}"))).await?;

        match response.status().as_u16() {
            200 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::GenericResponse>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(SendMailResponse::EmailAcceptedForDelivery
                    (body)
                )
            }
            400 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(SendMailResponse::BadRequest
                    (body)
                )
            }
            401 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(SendMailResponse::AuthenticationFailed
                    (body)
                )
            }
            404 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(SendMailResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                    (body)
                )
            }
            code => {
                let headers = response.headers().clone();
                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec());
                Err(ApiError(format!("Unexpected response code {code}:\n{headers:?}\n\n{}",
                    match body {
                        Ok(body) => match String::from_utf8(body) {
                            Ok(body) => body,
                            Err(e) => format!("<Body was not UTF8: {e:?}>"),
                        },
                        Err(e) => format!("<Failed to read body: {}>", Into::<crate::ServiceError>::into(e)),
                    }
                )))
            }
        }
    }

    #[allow(clippy::vec_init_then_push)]
    async fn get_mail_orders(
        &self,
        context: &C) -> Result<GetMailOrdersResponse, ApiError>
    {
        let mut client_service = self.client_service.clone();
        #[allow(clippy::uninlined_format_args)]
        let mut uri = format!(
            "{}/mail",
            self.base_path
        );

        // Query parameters
        let query_string = {
            let mut query_string = form_urlencoded::Serializer::new("".to_owned());
            query_string.finish()
        };
        if !query_string.is_empty() {
            uri += "?";
            uri += &query_string;
        }

        let uri = match Uri::from_str(&uri) {
            Ok(uri) => uri,
            Err(err) => return Err(ApiError(format!("Unable to build URI: {err}"))),
        };

        let mut request = match Request::builder()
            .method("GET")
            .uri(uri)
            .body(BoxBody::new(http_body_util::Empty::new())) {
                Ok(req) => req,
                Err(e) => return Err(ApiError(format!("Unable to create request: {e}")))
        };

        let header = HeaderValue::from_str(Has::<XSpanIdString>::get(context).0.as_str());
        request.headers_mut().insert(HeaderName::from_static("x-span-id"), match header {
            Ok(h) => h,
            Err(e) => return Err(ApiError(format!("Unable to create X-Span ID header value: {e}")))
        });

        #[allow(clippy::collapsible_match)]
        if let Some(auth_data) = Has::<Option<AuthData>>::get(context).as_ref() {
            use headers::authorization::Credentials;
            // The trailing `_` arm is unreachable when the spec declares every kind of
            // scheme `AuthData` can represent, and the workspace denies warnings.
            #[allow(unreachable_patterns, clippy::single_match, clippy::match_single_binding)]
            match auth_data {
                AuthData::ApiKey(ref api_key) => {
                    let header = match HeaderValue::from_str(api_key.as_str()) {
                        Ok(h) => h,
                        Err(e) => return Err(ApiError(format!("Unable to create header: {e}")))
                    };
                    request.headers_mut().insert(
                        HeaderName::from_static("x-api-key"),
                        header);
                },
                _ => {}
            }
        }

        let response = client_service.call((request, context.clone()))
            .map_err(|e| ApiError(format!("No response received: {e}"))).await?;

        match response.status().as_u16() {
            200 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<Vec<models::MailOrder>>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(GetMailOrdersResponse::OK
                    (body)
                )
            }
            401 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(GetMailOrdersResponse::AuthenticationFailed
                    (body)
                )
            }
            code => {
                let headers = response.headers().clone();
                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec());
                Err(ApiError(format!("Unexpected response code {code}:\n{headers:?}\n\n{}",
                    match body {
                        Ok(body) => match String::from_utf8(body) {
                            Ok(body) => body,
                            Err(e) => format!("<Body was not UTF8: {e:?}>"),
                        },
                        Err(e) => format!("<Failed to read body: {}>", Into::<crate::ServiceError>::into(e)),
                    }
                )))
            }
        }
    }

    #[allow(clippy::vec_init_then_push)]
    async fn get_mail_order_by_id(
        &self,
        param_id: i64,
        context: &C) -> Result<GetMailOrderByIdResponse, ApiError>
    {
        let mut client_service = self.client_service.clone();
        #[allow(clippy::uninlined_format_args)]
        let mut uri = format!(
            "{}/mail/{id}",
            self.base_path
            ,id=utf8_percent_encode(&param_id.to_string(), ID_ENCODE_SET)
        );

        // Query parameters
        let query_string = {
            let mut query_string = form_urlencoded::Serializer::new("".to_owned());
            query_string.finish()
        };
        if !query_string.is_empty() {
            uri += "?";
            uri += &query_string;
        }

        let uri = match Uri::from_str(&uri) {
            Ok(uri) => uri,
            Err(err) => return Err(ApiError(format!("Unable to build URI: {err}"))),
        };

        let mut request = match Request::builder()
            .method("GET")
            .uri(uri)
            .body(BoxBody::new(http_body_util::Empty::new())) {
                Ok(req) => req,
                Err(e) => return Err(ApiError(format!("Unable to create request: {e}")))
        };

        let header = HeaderValue::from_str(Has::<XSpanIdString>::get(context).0.as_str());
        request.headers_mut().insert(HeaderName::from_static("x-span-id"), match header {
            Ok(h) => h,
            Err(e) => return Err(ApiError(format!("Unable to create X-Span ID header value: {e}")))
        });

        #[allow(clippy::collapsible_match)]
        if let Some(auth_data) = Has::<Option<AuthData>>::get(context).as_ref() {
            use headers::authorization::Credentials;
            // The trailing `_` arm is unreachable when the spec declares every kind of
            // scheme `AuthData` can represent, and the workspace denies warnings.
            #[allow(unreachable_patterns, clippy::single_match, clippy::match_single_binding)]
            match auth_data {
                AuthData::ApiKey(ref api_key) => {
                    let header = match HeaderValue::from_str(api_key.as_str()) {
                        Ok(h) => h,
                        Err(e) => return Err(ApiError(format!("Unable to create header: {e}")))
                    };
                    request.headers_mut().insert(
                        HeaderName::from_static("x-api-key"),
                        header);
                },
                _ => {}
            }
        }

        let response = client_service.call((request, context.clone()))
            .map_err(|e| ApiError(format!("No response received: {e}"))).await?;

        match response.status().as_u16() {
            200 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::MailOrderDetail>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(GetMailOrderByIdResponse::OK
                    (body)
                )
            }
            400 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(GetMailOrderByIdResponse::BadRequest
                    (body)
                )
            }
            401 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(GetMailOrderByIdResponse::AuthenticationFailed
                    (body)
                )
            }
            404 => {

                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                let body = str::from_utf8(&body)
                    .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                let body = serde_json::from_str::<models::ErrorMessage>(body)
                    .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;

                Ok(GetMailOrderByIdResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                    (body)
                )
            }
            code => {
                let headers = response.headers().clone();
                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec());
                Err(ApiError(format!("Unexpected response code {code}:\n{headers:?}\n\n{}",
                    match body {
                        Ok(body) => match String::from_utf8(body) {
                            Ok(body) => body,
                            Err(e) => format!("<Body was not UTF8: {e:?}>"),
                        },
                        Err(e) => format!("<Failed to read body: {}>", Into::<crate::ServiceError>::into(e)),
                    }
                )))
            }
        }
    }

    #[allow(clippy::vec_init_then_push)]
    async fn ping_server(
        &self,
        context: &C) -> Result<PingServerResponse, ApiError>
    {
        let mut client_service = self.client_service.clone();
        #[allow(clippy::uninlined_format_args)]
        let mut uri = format!(
            "{}/ping",
            self.base_path
        );

        // Query parameters
        let query_string = {
            let mut query_string = form_urlencoded::Serializer::new("".to_owned());
            query_string.finish()
        };
        if !query_string.is_empty() {
            uri += "?";
            uri += &query_string;
        }

        let uri = match Uri::from_str(&uri) {
            Ok(uri) => uri,
            Err(err) => return Err(ApiError(format!("Unable to build URI: {err}"))),
        };

        let mut request = match Request::builder()
            .method("GET")
            .uri(uri)
            .body(BoxBody::new(http_body_util::Empty::new())) {
                Ok(req) => req,
                Err(e) => return Err(ApiError(format!("Unable to create request: {e}")))
        };

        let header = HeaderValue::from_str(Has::<XSpanIdString>::get(context).0.as_str());
        request.headers_mut().insert(HeaderName::from_static("x-span-id"), match header {
            Ok(h) => h,
            Err(e) => return Err(ApiError(format!("Unable to create X-Span ID header value: {e}")))
        });

        let response = client_service.call((request, context.clone()))
            .map_err(|e| ApiError(format!("No response received: {e}"))).await?;

        match response.status().as_u16() {
            200 => {

                let (header, body) = response.into_parts();
                let body = http_body_util::BodyExt::collect(body)
                        .await
                        .map(|f| f.to_bytes().to_vec())
                        .map_err(|e| ApiError(format!("Failed to read response: {}", e.into())))?;

                // Body has multiple variant schemas
                let content_type = if let Some(content_type) = header.headers.get(CONTENT_TYPE) {
                    content_type.to_str()
                } else {
                    return Err(ApiError(String::from("Missing content type header")));
                };

                let content_type = content_type.map(|s|
                    s.split(';').next().expect("Splitting content type header failed").trim());

                let body = match content_type {
                    Ok(ct) if ct.eq_ignore_ascii_case("text/plain") => {
                        let body = str::from_utf8(&body)
                            .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                        let body = body.to_string();
                        swagger::OneOf2::<String, String>::A(body)
                    },
                    Ok(ct) if ct.eq_ignore_ascii_case("application/json") => {
                        let body = str::from_utf8(&body)
                            .map_err(|e| ApiError(format!("Response was not valid UTF8: {e}")))?;
                        let body = serde_json::from_str::<String>(body)
                            .map_err(|e| ApiError(format!("Response body did not match the schema: {e}")))?;
                        swagger::OneOf2::<String, String>::B(body)
                    },
                    e => {
                        return Err(ApiError(format!("Unexpected content type: {:?}", e)));
                    }
                };

                Ok(PingServerResponse::ServerIsUpAndRunning
                    (body)
                )
            }
            0 => {
                Ok(
                    PingServerResponse::SomethingIsWrong
                )
            }
            code => {
                let headers = response.headers().clone();
                let body = http_body_util::BodyExt::collect(response.into_body())
                        .await
                        .map(|f| f.to_bytes().to_vec());
                Err(ApiError(format!("Unexpected response code {code}:\n{headers:?}\n\n{}",
                    match body {
                        Ok(body) => match String::from_utf8(body) {
                            Ok(body) => body,
                            Err(e) => format!("<Body was not UTF8: {e:?}>"),
                        },
                        Err(e) => format!("<Failed to read body: {}>", Into::<crate::ServiceError>::into(e)),
                    }
                )))
            }
        }
    }

}
