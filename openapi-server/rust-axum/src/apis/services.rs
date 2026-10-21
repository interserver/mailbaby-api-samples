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
pub enum GetMailOrderByIdResponse {
    /// OK
    Status200_OK
    (models::MailOrderDetail)
    ,
    /// Bad request — one or more input parameters were missing or invalid.
    Status400_BadRequest
    (models::ErrorMessage)
    ,
    /// Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).
    Status401_AuthenticationFailed
    (models::ErrorMessage)
    ,
    /// The specified resource was not found or does not belong to your account.
    Status404_TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
    (models::ErrorMessage)
}

#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
#[allow(clippy::large_enum_variant)]
pub enum GetMailOrdersResponse {
    /// OK
    Status200_OK
    (Vec<models::MailOrder>)
    ,
    /// Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).
    Status401_AuthenticationFailed
    (models::ErrorMessage)
}




/// Services
#[async_trait]
#[allow(clippy::ptr_arg)]
pub trait Services<E: std::fmt::Debug + Send + Sync + 'static = ()>: super::ErrorHandler<E> {
    type Claims;

    /// Get one mail order's full detail including SMTP password.
    ///
    /// GetMailOrderById - GET /mail/{id}
    async fn get_mail_order_by_id(
    &self,
    
    method: &Method,
    host: &Host,
    cookies: &CookieJar,
        claims: &Self::Claims,
      path_params: &models::GetMailOrderByIdPathParams,
    ) -> Result<GetMailOrderByIdResponse, E>;

    /// List your provisioned mail orders (sending accounts).
    ///
    /// GetMailOrders - GET /mail
    async fn get_mail_orders(
    &self,
    
    method: &Method,
    host: &Host,
    cookies: &CookieJar,
        claims: &Self::Claims,
    ) -> Result<GetMailOrdersResponse, E>;
}
