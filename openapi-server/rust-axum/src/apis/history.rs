use async_trait::async_trait;
use axum::extract::*;
use axum_extra::extract::CookieJar;
use bytes::Bytes;
use headers::Host;
use http::Method;
use serde::{Deserialize, Serialize};

use crate::{models, types::*};

#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
#[allow(clippy::large_enum_variant)]
pub enum GetStatsResponse {
    /// OK
    Status200_OK
    (models::MailStatsType)
    ,
    /// Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).
    Status401_AuthenticationFailed
    (models::ErrorMessage)
}

#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
#[allow(clippy::large_enum_variant)]
pub enum ViewMailLogResponse {
    /// Paginated list of mail log entries
    Status200_PaginatedListOfMailLogEntries
    (models::MailLog)
    ,
    /// Bad request — one or more input parameters were missing or invalid.
    Status400_BadRequest
    (models::ErrorMessage)
    ,
    /// Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).
    Status401_AuthenticationFailed
    (models::ErrorMessage)
}




/// History
#[async_trait]
#[allow(clippy::ptr_arg)]
pub trait History<E: std::fmt::Debug + Send + Sync + 'static = ()>: super::ErrorHandler<E> {
    type Claims;

    /// Account usage, cost, and volume statistics for a time window.
    ///
    /// GetStats - GET /mail/stats
    async fn get_stats(
    &self,
    
    method: &Method,
    host: &Host,
    cookies: &CookieJar,
        claims: &Self::Claims,
      query_params: &models::GetStatsQueryParams,
    ) -> Result<GetStatsResponse, E>;

    /// Query the mail delivery log (filterable, paginated).
    ///
    /// ViewMailLog - GET /mail/log
    async fn view_mail_log(
    &self,
    
    method: &Method,
    host: &Host,
    cookies: &CookieJar,
        claims: &Self::Claims,
      query_params: &models::ViewMailLogQueryParams,
    ) -> Result<ViewMailLogResponse, E>;
}
