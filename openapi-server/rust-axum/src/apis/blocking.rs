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
pub enum AddRuleResponse {
    /// Rule created successfully
    Status200_RuleCreatedSuccessfully
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
pub enum DeleteRuleResponse {
    /// Rule deleted successfully
    Status200_RuleDeletedSuccessfully
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
pub enum DelistBlockResponse {
    /// Address successfully delisted
    Status200_AddressSuccessfullyDelisted
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
pub enum GetMailBlocksResponse {
    /// OK
    Status200_OK
    (models::MailBlocks)
    ,
    /// Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).
    Status401_AuthenticationFailed
    (models::ErrorMessage)
}

#[derive(Debug, PartialEq, Serialize, Deserialize)]
#[must_use]
#[allow(clippy::large_enum_variant)]
pub enum GetRulesResponse {
    /// OK
    Status200_OK
    (Vec<models::DenyRuleRecord>)
    ,
    /// Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).
    Status401_AuthenticationFailed
    (models::ErrorMessage)
}




/// Blocking
#[async_trait]
#[allow(clippy::ptr_arg)]
pub trait Blocking<E: std::fmt::Debug + Send + Sync + 'static = ()>: super::ErrorHandler<E> {
    type Claims;

    /// Create a deny rule to block a sender, domain, destination, or prefix.
    ///
    /// AddRule - POST /mail/rules
    async fn add_rule(
    &self,
    
    method: &Method,
    host: &Host,
    cookies: &CookieJar,
        claims: &Self::Claims,
            body: &models::DenyRuleNew,
    ) -> Result<AddRuleResponse, E>;

    /// Delete a deny rule by its numeric ruleId.
    ///
    /// DeleteRule - DELETE /mail/rules/{ruleId}
    async fn delete_rule(
    &self,
    
    method: &Method,
    host: &Host,
    cookies: &CookieJar,
        claims: &Self::Claims,
      path_params: &models::DeleteRulePathParams,
    ) -> Result<DeleteRuleResponse, E>;

    /// Delist an email address from the spam-filter block lists.
    ///
    /// DelistBlock - POST /mail/blocks/delete
    async fn delist_block(
    &self,
    
    method: &Method,
    host: &Host,
    cookies: &CookieJar,
        claims: &Self::Claims,
            body: &models::EmailAddressParam,
    ) -> Result<DelistBlockResponse, E>;

    /// List addresses currently flagged by spam-filter block lists.
    ///
    /// GetMailBlocks - GET /mail/blocks
    async fn get_mail_blocks(
    &self,
    
    method: &Method,
    host: &Host,
    cookies: &CookieJar,
        claims: &Self::Claims,
    ) -> Result<GetMailBlocksResponse, E>;

    /// List custom deny rules (sender / domain / destination / prefix).
    ///
    /// GetRules - GET /mail/rules
    async fn get_rules(
    &self,
    
    method: &Method,
    host: &Host,
    cookies: &CookieJar,
        claims: &Self::Claims,
    ) -> Result<GetRulesResponse, E>;
}
