#![allow(missing_docs, trivial_casts, unused_variables, unused_mut, unused_imports, unused_extern_crates, unused_attributes, non_camel_case_types)]
#![allow(clippy::derive_partial_eq_without_eq, clippy::disallowed_names)]

use async_trait::async_trait;
use futures::Stream;
#[cfg(feature = "mock")]
use mockall::automock;
use std::error::Error;
use std::collections::BTreeSet;
use std::task::{Poll, Context};
use swagger::{ApiError, ContextWrapper, auth::Authorization};
use serde::{Serialize, Deserialize};

#[cfg(any(feature = "client", feature = "server"))]
type ServiceError = Box<dyn Error + Send + Sync + 'static>;

pub const BASE_PATH: &str = "";
pub const API_VERSION: &str = "1.5.0";

mod auth;
pub use auth::{AuthenticationApi, Claims};


#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
pub enum AddRuleResponse {
    /// Rule created successfully
    RuleCreatedSuccessfully
    (models::GenericResponse)
    ,
    /// Bad request — one or more input parameters were missing or invalid.
    BadRequest
    (models::ErrorMessage)
    ,
    /// Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).
    AuthenticationFailed
    (models::ErrorMessage)
    ,
    /// The specified resource was not found or does not belong to your account.
    TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
    (models::ErrorMessage)
}

#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
pub enum DelistBlockResponse {
    /// Address successfully delisted
    AddressSuccessfullyDelisted
    (models::GenericResponse)
    ,
    /// Bad request — one or more input parameters were missing or invalid.
    BadRequest
    (models::ErrorMessage)
    ,
    /// Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).
    AuthenticationFailed
    (models::ErrorMessage)
    ,
    /// The specified resource was not found or does not belong to your account.
    TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
    (models::ErrorMessage)
}

#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
pub enum GetMailBlocksResponse {
    /// OK
    OK
    (models::MailBlocks)
    ,
    /// Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).
    AuthenticationFailed
    (models::ErrorMessage)
}

#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
pub enum GetRulesResponse {
    /// OK
    OK
    (Vec<models::DenyRuleRecord>)
    ,
    /// Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).
    AuthenticationFailed
    (models::ErrorMessage)
}

#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
pub enum DeleteRuleResponse {
    /// Rule deleted successfully
    RuleDeletedSuccessfully
    (models::GenericResponse)
    ,
    /// Bad request — one or more input parameters were missing or invalid.
    BadRequest
    (models::ErrorMessage)
    ,
    /// Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).
    AuthenticationFailed
    (models::ErrorMessage)
    ,
    /// The specified resource was not found or does not belong to your account.
    TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
    (models::ErrorMessage)
}

#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
pub enum GetStatsResponse {
    /// OK
    OK
    (models::MailStatsType)
    ,
    /// Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).
    AuthenticationFailed
    (models::ErrorMessage)
}

#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
pub enum ViewMailLogResponse {
    /// Paginated list of mail log entries
    PaginatedListOfMailLogEntries
    (models::MailLog)
    ,
    /// Bad request — one or more input parameters were missing or invalid.
    BadRequest
    (models::ErrorMessage)
    ,
    /// Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).
    AuthenticationFailed
    (models::ErrorMessage)
}

#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
pub enum RawMailResponse {
    /// Email accepted for delivery
    EmailAcceptedForDelivery
    (models::GenericResponse)
    ,
    /// Bad request — one or more input parameters were missing or invalid.
    BadRequest
    (models::ErrorMessage)
    ,
    /// Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).
    AuthenticationFailed
    (models::ErrorMessage)
    ,
    /// The specified resource was not found or does not belong to your account.
    TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
    (models::ErrorMessage)
}

#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
pub enum SendAdvMailResponse {
    /// Email accepted for delivery
    EmailAcceptedForDelivery
    (models::GenericResponse)
    ,
    /// Bad request — one or more input parameters were missing or invalid.
    BadRequest
    (models::ErrorMessage)
    ,
    /// Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).
    AuthenticationFailed
    (models::ErrorMessage)
    ,
    /// The specified resource was not found or does not belong to your account.
    TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
    (models::ErrorMessage)
}

#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
pub enum SendMailResponse {
    /// Email accepted for delivery
    EmailAcceptedForDelivery
    (models::GenericResponse)
    ,
    /// Bad request — one or more input parameters were missing or invalid.
    BadRequest
    (models::ErrorMessage)
    ,
    /// Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).
    AuthenticationFailed
    (models::ErrorMessage)
    ,
    /// The specified resource was not found or does not belong to your account.
    TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
    (models::ErrorMessage)
}

#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
pub enum GetMailOrdersResponse {
    /// OK
    OK
    (Vec<models::MailOrder>)
    ,
    /// Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).
    AuthenticationFailed
    (models::ErrorMessage)
}

#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
pub enum GetMailOrderByIdResponse {
    /// OK
    OK
    (models::MailOrderDetail)
    ,
    /// Bad request — one or more input parameters were missing or invalid.
    BadRequest
    (models::ErrorMessage)
    ,
    /// Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).
    AuthenticationFailed
    (models::ErrorMessage)
    ,
    /// The specified resource was not found or does not belong to your account.
    TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
    (models::ErrorMessage)
}

#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
pub enum PingServerResponse {
    /// Server is up and running
    ServerIsUpAndRunning
    (swagger::OneOf2::<String, String>)
    ,
    /// Something is wrong
    SomethingIsWrong
}

/// API
#[cfg_attr(feature = "mock", automock)]
#[async_trait]
#[allow(clippy::too_many_arguments, clippy::ptr_arg)]
pub trait Api<C: Send + Sync> {
    /// Create a deny rule to block a sender, domain, destination, or prefix
    async fn add_rule(
        &self,
        param_type: models::DenyRuleNewType,
        data: String,
        user: Option<String>,
        context: &C) -> Result<AddRuleResponse, ApiError>;

    /// Delist an email address from the spam-filter block lists
    async fn delist_block(
        &self,
        email_address_param: models::EmailAddressParam,
        context: &C) -> Result<DelistBlockResponse, ApiError>;

    /// List addresses currently flagged by spam-filter block lists
    async fn get_mail_blocks(
        &self,
        context: &C) -> Result<GetMailBlocksResponse, ApiError>;

    /// List custom deny rules (sender / domain / destination / prefix)
    async fn get_rules(
        &self,
        context: &C) -> Result<GetRulesResponse, ApiError>;

    /// Delete a deny rule by its numeric ruleId
    async fn delete_rule(
        &self,
        rule_id: i32,
        context: &C) -> Result<DeleteRuleResponse, ApiError>;

    /// Account usage, cost, and volume statistics for a time window
    async fn get_stats(
        &self,
        time: Option<models::GetStatsTimeParameter>,
        context: &C) -> Result<GetStatsResponse, ApiError>;

    /// Query the mail delivery log (filterable, paginated)
    async fn view_mail_log(
        &self,
        id: Option<i64>,
        origin: Option<String>,
        mx: Option<String>,
        from: Option<String>,
        to: Option<String>,
        subject: Option<String>,
        mailid: Option<String>,
        message_id: Option<String>,
        replyto: Option<String>,
        headerfrom: Option<String>,
        delivered: Option<models::DeliveredStatus>,
        skip: Option<u32>,
        limit: Option<u32>,
        start_date: Option<models::DateOrTimestamp>,
        end_date: Option<models::DateOrTimestamp>,
        sort: Option<models::ViewMailLogSortParameter>,
        dir: Option<models::ViewMailLogDirParameter>,
        groupby: Option<models::ViewMailLogGroupbyParameter>,
        context: &C) -> Result<ViewMailLogResponse, ApiError>;

    /// Send a pre-built RFC 822 message verbatim (preserves DKIM)
    async fn raw_mail(
        &self,
        send_mail_raw: models::SendMailRaw,
        context: &C) -> Result<RawMailResponse, ApiError>;

    /// Send email with multiple recipients, CC/BCC, attachments, named contacts
    async fn send_adv_mail<'a>(
        &self,
        subject: String,
        body: String,
        from: models::EmailAddressTypes,
        to: models::EmailAddressesTypes,
        replyto: Option<models::EmailAddressesTypes>,
        cc: Option<models::EmailAddressesTypes>,
        bcc: Option<models::EmailAddressesTypes>,
        attachments: Option<&'a Vec<models::MailAttachment>>,
        id: Option<i64>,
        context: &C) -> Result<SendAdvMailResponse, ApiError>;

    /// Send a simple email (single recipient, plain or HTML)
    async fn send_mail(
        &self,
        to: models::SendMailTo,
        from: String,
        subject: String,
        body: String,
        id: Option<i64>,
        context: &C) -> Result<SendMailResponse, ApiError>;

    /// List your provisioned mail orders (sending accounts)
    async fn get_mail_orders(
        &self,
        context: &C) -> Result<GetMailOrdersResponse, ApiError>;

    /// Get one mail order's full detail including SMTP password
    async fn get_mail_order_by_id(
        &self,
        id: i64,
        context: &C) -> Result<GetMailOrderByIdResponse, ApiError>;

    /// Health check — verify the API is reachable
    async fn ping_server(
        &self,
        context: &C) -> Result<PingServerResponse, ApiError>;

}

/// API where `Context` isn't passed on every API call
#[cfg_attr(feature = "mock", automock)]
#[async_trait]
#[allow(clippy::too_many_arguments, clippy::ptr_arg)]
pub trait ApiNoContext<C: Send + Sync> {
    // The std::task::Context struct houses a reference to std::task::Waker with the lifetime <'a>.
    // Adding an anonymous lifetime `'a` to allow mockall to create a mock object with the right lifetimes.
    // This is needed because the compiler is unable to determine the lifetimes on F's trait bound
    // where F is the closure created by mockall. We use higher-rank trait bounds here to get around this.

    fn context(&self) -> &C;

    /// Create a deny rule to block a sender, domain, destination, or prefix
    async fn add_rule(
        &self,
        param_type: models::DenyRuleNewType,
        data: String,
        user: Option<String>,
        ) -> Result<AddRuleResponse, ApiError>;

    /// Delist an email address from the spam-filter block lists
    async fn delist_block(
        &self,
        email_address_param: models::EmailAddressParam,
        ) -> Result<DelistBlockResponse, ApiError>;

    /// List addresses currently flagged by spam-filter block lists
    async fn get_mail_blocks(
        &self,
        ) -> Result<GetMailBlocksResponse, ApiError>;

    /// List custom deny rules (sender / domain / destination / prefix)
    async fn get_rules(
        &self,
        ) -> Result<GetRulesResponse, ApiError>;

    /// Delete a deny rule by its numeric ruleId
    async fn delete_rule(
        &self,
        rule_id: i32,
        ) -> Result<DeleteRuleResponse, ApiError>;

    /// Account usage, cost, and volume statistics for a time window
    async fn get_stats(
        &self,
        time: Option<models::GetStatsTimeParameter>,
        ) -> Result<GetStatsResponse, ApiError>;

    /// Query the mail delivery log (filterable, paginated)
    async fn view_mail_log(
        &self,
        id: Option<i64>,
        origin: Option<String>,
        mx: Option<String>,
        from: Option<String>,
        to: Option<String>,
        subject: Option<String>,
        mailid: Option<String>,
        message_id: Option<String>,
        replyto: Option<String>,
        headerfrom: Option<String>,
        delivered: Option<models::DeliveredStatus>,
        skip: Option<u32>,
        limit: Option<u32>,
        start_date: Option<models::DateOrTimestamp>,
        end_date: Option<models::DateOrTimestamp>,
        sort: Option<models::ViewMailLogSortParameter>,
        dir: Option<models::ViewMailLogDirParameter>,
        groupby: Option<models::ViewMailLogGroupbyParameter>,
        ) -> Result<ViewMailLogResponse, ApiError>;

    /// Send a pre-built RFC 822 message verbatim (preserves DKIM)
    async fn raw_mail(
        &self,
        send_mail_raw: models::SendMailRaw,
        ) -> Result<RawMailResponse, ApiError>;

    /// Send email with multiple recipients, CC/BCC, attachments, named contacts
    async fn send_adv_mail<'a>(
        &self,
        subject: String,
        body: String,
        from: models::EmailAddressTypes,
        to: models::EmailAddressesTypes,
        replyto: Option<models::EmailAddressesTypes>,
        cc: Option<models::EmailAddressesTypes>,
        bcc: Option<models::EmailAddressesTypes>,
        attachments: Option<&'a Vec<models::MailAttachment>>,
        id: Option<i64>,
        ) -> Result<SendAdvMailResponse, ApiError>;

    /// Send a simple email (single recipient, plain or HTML)
    async fn send_mail(
        &self,
        to: models::SendMailTo,
        from: String,
        subject: String,
        body: String,
        id: Option<i64>,
        ) -> Result<SendMailResponse, ApiError>;

    /// List your provisioned mail orders (sending accounts)
    async fn get_mail_orders(
        &self,
        ) -> Result<GetMailOrdersResponse, ApiError>;

    /// Get one mail order's full detail including SMTP password
    async fn get_mail_order_by_id(
        &self,
        id: i64,
        ) -> Result<GetMailOrderByIdResponse, ApiError>;

    /// Health check — verify the API is reachable
    async fn ping_server(
        &self,
        ) -> Result<PingServerResponse, ApiError>;

}

/// Trait to extend an API to make it easy to bind it to a context.
pub trait ContextWrapperExt<C: Send + Sync> where Self: Sized
{
    /// Binds this API to a context.
    fn with_context(self, context: C) -> ContextWrapper<Self, C>;
}

impl<T: Api<C> + Send + Sync, C: Clone + Send + Sync> ContextWrapperExt<C> for T {
    fn with_context(self: T, context: C) -> ContextWrapper<T, C> {
         ContextWrapper::<T, C>::new(self, context)
    }
}

#[async_trait]
impl<T: Api<C> + Send + Sync, C: Clone + Send + Sync> ApiNoContext<C> for ContextWrapper<T, C> {
    fn context(&self) -> &C {
        ContextWrapper::context(self)
    }

    /// Create a deny rule to block a sender, domain, destination, or prefix
    async fn add_rule(
        &self,
        param_type: models::DenyRuleNewType,
        data: String,
        user: Option<String>,
        ) -> Result<AddRuleResponse, ApiError>
    {
        let context = self.context().clone();
        self.api().add_rule(param_type, data, user, &context).await
    }

    /// Delist an email address from the spam-filter block lists
    async fn delist_block(
        &self,
        email_address_param: models::EmailAddressParam,
        ) -> Result<DelistBlockResponse, ApiError>
    {
        let context = self.context().clone();
        self.api().delist_block(email_address_param, &context).await
    }

    /// List addresses currently flagged by spam-filter block lists
    async fn get_mail_blocks(
        &self,
        ) -> Result<GetMailBlocksResponse, ApiError>
    {
        let context = self.context().clone();
        self.api().get_mail_blocks(&context).await
    }

    /// List custom deny rules (sender / domain / destination / prefix)
    async fn get_rules(
        &self,
        ) -> Result<GetRulesResponse, ApiError>
    {
        let context = self.context().clone();
        self.api().get_rules(&context).await
    }

    /// Delete a deny rule by its numeric ruleId
    async fn delete_rule(
        &self,
        rule_id: i32,
        ) -> Result<DeleteRuleResponse, ApiError>
    {
        let context = self.context().clone();
        self.api().delete_rule(rule_id, &context).await
    }

    /// Account usage, cost, and volume statistics for a time window
    async fn get_stats(
        &self,
        time: Option<models::GetStatsTimeParameter>,
        ) -> Result<GetStatsResponse, ApiError>
    {
        let context = self.context().clone();
        self.api().get_stats(time, &context).await
    }

    /// Query the mail delivery log (filterable, paginated)
    async fn view_mail_log(
        &self,
        id: Option<i64>,
        origin: Option<String>,
        mx: Option<String>,
        from: Option<String>,
        to: Option<String>,
        subject: Option<String>,
        mailid: Option<String>,
        message_id: Option<String>,
        replyto: Option<String>,
        headerfrom: Option<String>,
        delivered: Option<models::DeliveredStatus>,
        skip: Option<u32>,
        limit: Option<u32>,
        start_date: Option<models::DateOrTimestamp>,
        end_date: Option<models::DateOrTimestamp>,
        sort: Option<models::ViewMailLogSortParameter>,
        dir: Option<models::ViewMailLogDirParameter>,
        groupby: Option<models::ViewMailLogGroupbyParameter>,
        ) -> Result<ViewMailLogResponse, ApiError>
    {
        let context = self.context().clone();
        self.api().view_mail_log(id, origin, mx, from, to, subject, mailid, message_id, replyto, headerfrom, delivered, skip, limit, start_date, end_date, sort, dir, groupby, &context).await
    }

    /// Send a pre-built RFC 822 message verbatim (preserves DKIM)
    async fn raw_mail(
        &self,
        send_mail_raw: models::SendMailRaw,
        ) -> Result<RawMailResponse, ApiError>
    {
        let context = self.context().clone();
        self.api().raw_mail(send_mail_raw, &context).await
    }

    /// Send email with multiple recipients, CC/BCC, attachments, named contacts
    async fn send_adv_mail<'a>(
        &self,
        subject: String,
        body: String,
        from: models::EmailAddressTypes,
        to: models::EmailAddressesTypes,
        replyto: Option<models::EmailAddressesTypes>,
        cc: Option<models::EmailAddressesTypes>,
        bcc: Option<models::EmailAddressesTypes>,
        attachments: Option<&'a Vec<models::MailAttachment>>,
        id: Option<i64>,
        ) -> Result<SendAdvMailResponse, ApiError>
    {
        let context = self.context().clone();
        self.api().send_adv_mail(subject, body, from, to, replyto, cc, bcc, attachments, id, &context).await
    }

    /// Send a simple email (single recipient, plain or HTML)
    async fn send_mail(
        &self,
        to: models::SendMailTo,
        from: String,
        subject: String,
        body: String,
        id: Option<i64>,
        ) -> Result<SendMailResponse, ApiError>
    {
        let context = self.context().clone();
        self.api().send_mail(to, from, subject, body, id, &context).await
    }

    /// List your provisioned mail orders (sending accounts)
    async fn get_mail_orders(
        &self,
        ) -> Result<GetMailOrdersResponse, ApiError>
    {
        let context = self.context().clone();
        self.api().get_mail_orders(&context).await
    }

    /// Get one mail order's full detail including SMTP password
    async fn get_mail_order_by_id(
        &self,
        id: i64,
        ) -> Result<GetMailOrderByIdResponse, ApiError>
    {
        let context = self.context().clone();
        self.api().get_mail_order_by_id(id, &context).await
    }

    /// Health check — verify the API is reachable
    async fn ping_server(
        &self,
        ) -> Result<PingServerResponse, ApiError>
    {
        let context = self.context().clone();
        self.api().ping_server(&context).await
    }

}


#[cfg(feature = "client")]
pub mod client;

// Re-export Client as a top-level name
#[cfg(feature = "client")]
pub use client::Client;

#[cfg(feature = "server")]
pub mod server;

// Re-export router() as a top-level name
#[cfg(feature = "server")]
pub use self::server::Service;

#[cfg(feature = "server")]
pub mod context;

pub mod models;

#[cfg(any(feature = "client", feature = "server"))]
pub(crate) mod header;
