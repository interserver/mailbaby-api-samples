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
pub enum PingServerResponse {
    /// Server is up and running
    Status200_ServerIsUpAndRunning
    (String)
    ,
    /// Something is wrong
    Status0_SomethingIsWrong
}




/// Status
#[async_trait]
#[allow(clippy::ptr_arg)]
pub trait Status<E: std::fmt::Debug + Send + Sync + 'static = ()>: super::ErrorHandler<E> {
    /// Health check — verify the API is reachable.
    ///
    /// PingServer - GET /ping
    async fn ping_server(
    &self,
    
    method: &Method,
    host: &Host,
    cookies: &CookieJar,
    ) -> Result<PingServerResponse, E>;
}
