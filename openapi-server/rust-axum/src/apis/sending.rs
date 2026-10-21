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
pub enum RawMailResponse {
    /// Email accepted for delivery
    Status200_EmailAcceptedForDelivery
    (models::GenericResponse)
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
pub enum SendAdvMailResponse {
    /// Email accepted for delivery
    Status200_EmailAcceptedForDelivery
    (models::GenericResponse)
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
pub enum SendMailResponse {
    /// Email accepted for delivery
    Status200_EmailAcceptedForDelivery
    (models::GenericResponse)
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




/// Sending
#[async_trait]
#[allow(clippy::ptr_arg)]
pub trait Sending<E: std::fmt::Debug + Send + Sync + 'static = ()>: super::ErrorHandler<E> {
    type Claims;

    /// Send a pre-built RFC 822 message verbatim (preserves DKIM).
    ///
    /// RawMail - POST /mail/rawsend
    async fn raw_mail(
    &self,
    
    method: &Method,
    host: &Host,
    cookies: &CookieJar,
        claims: &Self::Claims,
    body: Multipart,
    ) -> Result<RawMailResponse, E>;

    /// Send email with multiple recipients, CC/BCC, attachments, named contacts.
    ///
    /// SendAdvMail - POST /mail/advsend
    async fn send_adv_mail(
    &self,
    
    method: &Method,
    host: &Host,
    cookies: &CookieJar,
        claims: &Self::Claims,
            body: &models::SendMailAdv,
    ) -> Result<SendAdvMailResponse, E>;

    /// Send a simple email (single recipient, plain or HTML).
    ///
    /// SendMail - POST /mail/send
    async fn send_mail(
    &self,
    
    method: &Method,
    host: &Host,
    cookies: &CookieJar,
        claims: &Self::Claims,
            body: &models::SendMail,
    ) -> Result<SendMailResponse, E>;
}
