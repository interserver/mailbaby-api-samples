//! Main library entry point for MailBabyRustServer implementation.

#![allow(unused_imports)]

use async_trait::async_trait;
use futures::{future, Stream, StreamExt, TryFutureExt, TryStreamExt};
use hyper::server::conn::http1;
use hyper_util::rt::TokioIo;
use hyper::service::{service_fn, Service};
use log::info;
use std::future::Future;
use std::marker::PhantomData;
use std::net::SocketAddr;
use std::sync::{Arc, Mutex};
use std::task::{Context, Poll};
use swagger::{Has, XSpanIdString};
use swagger::auth::MakeAllowAllAuthenticator;
use swagger::EmptyContext;
use tokio::net::TcpListener;

#[cfg(not(any(target_os = "macos", target_os = "windows", target_os = "ios")))]
use openssl::ssl::{Ssl, SslAcceptor, SslAcceptorBuilder, SslFiletype, SslMethod};

use MailBabyRustServer::models;

/// Builds an SSL implementation for Simple HTTPS from some hard-coded file names
pub async fn create(addr: &str, https: bool) {
    let addr: SocketAddr = addr.parse().expect("Failed to parse bind address");
    let listener = TcpListener::bind(&addr).await.unwrap();

    let server = Server::new();

    let service = MakeService::new(server);
    let service = MakeAllowAllAuthenticator::new(service, "cosmo");

    #[allow(unused_mut)]
    let mut service =
        MailBabyRustServer::server::context::MakeAddContext::<_, EmptyContext>::new(
            service
        );

    if https {
        #[cfg(any(target_os = "macos", target_os = "windows", target_os = "ios"))]
        {
            unimplemented!("SSL is not implemented for the examples on MacOS, Windows or iOS");
        }

        #[cfg(not(any(target_os = "macos", target_os = "windows", target_os = "ios")))]
        {
            let mut ssl = SslAcceptor::mozilla_intermediate_v5(SslMethod::tls()).expect("Failed to create SSL Acceptor");

            // Server authentication
            ssl.set_private_key_file("examples/server-key.pem", SslFiletype::PEM).expect("Failed to set private key");
            ssl.set_certificate_chain_file("examples/server-chain.pem").expect("Failed to set certificate chain");
            ssl.check_private_key().expect("Failed to check private key");

            let tls_acceptor = ssl.build();

            info!("Starting a server (with https)");
            loop {
                if let Ok((tcp, addr)) = listener.accept().await {
                    let ssl = Ssl::new(tls_acceptor.context()).unwrap();
                    let service = service.call(addr);

                    tokio::spawn(async move {
                        let tls = tokio_openssl::SslStream::new(ssl, tcp).map_err(|_| ())?;
                        let service = service.await.map_err(|_| ())?;

                        http1::Builder::new()
                            .serve_connection(TokioIo::new(tls), service)
                            .await
                            .map_err(|_| ())
                    });
                }
            }
        }
    } else {
        info!("Starting a server (over http, so no TLS)");
        println!("Listening on http://{}", addr);

        loop {
            // When an incoming TCP connection is received grab a TCP stream for
            // client<->server communication.
            //
            // Note, this is a .await point, this loop will loop forever but is not a busy loop. The
            // .await point allows the Tokio runtime to pull the task off of the thread until the task
            // has work to do. In this case, a connection arrives on the port we are listening on and
            // the task is woken up, at which point the task is then put back on a thread, and is
            // driven forward by the runtime, eventually yielding a TCP stream.
            let (tcp_stream, addr) = listener.accept().await.expect("Failed to accept connection");

            let service = service.call(addr).await.unwrap();
            let io = TokioIo::new(tcp_stream);
            // Spin up a new task in Tokio so we can continue to listen for new TCP connection on the
            // current task without waiting for the processing of the HTTP1 connection we just received
            // to finish
            tokio::task::spawn(async move {
                // Handle the connection from the client using HTTP1 and pass any
                // HTTP requests received on that connection to the `hello` function
                let result = http1::Builder::new()
                    .serve_connection(io, service)
                    .await;
                if let Err(err) = result
                {
                    println!("Error serving connection: {err:?}");
                }
            });
        }
    }
}

#[derive(Copy)]
pub struct Server<C> {
    marker: PhantomData<C>,
}

impl<C> Server<C> {
    pub fn new() -> Self {
        Server{marker: PhantomData}
    }
}

impl<C> Clone for Server<C> {
    fn clone(&self) -> Self {
        Self {
            marker: PhantomData,
        }
    }
}


use jsonwebtoken::{decode, encode, errors::Error as JwtError, Algorithm, DecodingKey, EncodingKey, Header, TokenData, Validation};
use serde::{Deserialize, Serialize};
use swagger::auth::Authorization;
use crate::server_auth;


use MailBabyRustServer::{
    Api,
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
    PingServerResponse,
};
use MailBabyRustServer::server::MakeService;
use std::error::Error;
use swagger::ApiError;

#[async_trait]
impl<C> Api<C> for Server<C> where C: Has<XSpanIdString> + Send + Sync
{
    /// Create a deny rule to block a sender, domain, destination, or prefix
    async fn add_rule(
        &self,
        param_type: models::DenyRuleNewType,
        data: String,
        user: Option<String>,
        context: &C) -> Result<AddRuleResponse, ApiError>
    {
        info!("add_rule({:?}, {:?}, {:?}) - X-Span-ID: {:?}", param_type, data, user, context.get().0.clone());
        Err(ApiError("Api-Error: Operation is NOT implemented".into()))
    }

    /// Delist an email address from the spam-filter block lists
    async fn delist_block(
        &self,
        email_address_param: models::EmailAddressParam,
        context: &C) -> Result<DelistBlockResponse, ApiError>
    {
        info!("delist_block({:?}) - X-Span-ID: {:?}", email_address_param, context.get().0.clone());
        Err(ApiError("Api-Error: Operation is NOT implemented".into()))
    }

    /// List addresses currently flagged by spam-filter block lists
    async fn get_mail_blocks(
        &self,
        context: &C) -> Result<GetMailBlocksResponse, ApiError>
    {
        info!("get_mail_blocks() - X-Span-ID: {:?}", context.get().0.clone());
        Err(ApiError("Api-Error: Operation is NOT implemented".into()))
    }

    /// List custom deny rules (sender / domain / destination / prefix)
    async fn get_rules(
        &self,
        context: &C) -> Result<GetRulesResponse, ApiError>
    {
        info!("get_rules() - X-Span-ID: {:?}", context.get().0.clone());
        Err(ApiError("Api-Error: Operation is NOT implemented".into()))
    }

    /// Delete a deny rule by its numeric ruleId
    async fn delete_rule(
        &self,
        rule_id: i32,
        context: &C) -> Result<DeleteRuleResponse, ApiError>
    {
        info!("delete_rule({:?}) - X-Span-ID: {:?}", rule_id, context.get().0.clone());
        Err(ApiError("Api-Error: Operation is NOT implemented".into()))
    }

    /// Account usage, cost, and volume statistics for a time window
    async fn get_stats(
        &self,
        time: Option<models::GetStatsTimeParameter>,
        context: &C) -> Result<GetStatsResponse, ApiError>
    {
        info!("get_stats({:?}) - X-Span-ID: {:?}", time, context.get().0.clone());
        Err(ApiError("Api-Error: Operation is NOT implemented".into()))
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
        context: &C) -> Result<ViewMailLogResponse, ApiError>
    {
        info!("view_mail_log({:?}, {:?}, {:?}, {:?}, {:?}, {:?}, {:?}, {:?}, {:?}, {:?}, {:?}, {:?}, {:?}, {:?}, {:?}, {:?}, {:?}, {:?}) - X-Span-ID: {:?}", id, origin, mx, from, to, subject, mailid, message_id, replyto, headerfrom, delivered, skip, limit, start_date, end_date, sort, dir, groupby, context.get().0.clone());
        Err(ApiError("Api-Error: Operation is NOT implemented".into()))
    }

    /// Send a pre-built RFC 822 message verbatim (preserves DKIM)
    async fn raw_mail(
        &self,
        send_mail_raw: models::SendMailRaw,
        context: &C) -> Result<RawMailResponse, ApiError>
    {
        info!("raw_mail({:?}) - X-Span-ID: {:?}", send_mail_raw, context.get().0.clone());
        Err(ApiError("Api-Error: Operation is NOT implemented".into()))
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
        context: &C) -> Result<SendAdvMailResponse, ApiError>
    {
        info!("send_adv_mail({:?}, {:?}, {:?}, {:?}, {:?}, {:?}, {:?}, {:?}, {:?}) - X-Span-ID: {:?}", subject, body, from, to, replyto, cc, bcc, attachments, id, context.get().0.clone());
        Err(ApiError("Api-Error: Operation is NOT implemented".into()))
    }

    /// Send a simple email (single recipient, plain or HTML)
    async fn send_mail(
        &self,
        to: models::SendMailTo,
        from: String,
        subject: String,
        body: String,
        id: Option<i64>,
        context: &C) -> Result<SendMailResponse, ApiError>
    {
        info!("send_mail({:?}, {:?}, {:?}, {:?}, {:?}) - X-Span-ID: {:?}", to, from, subject, body, id, context.get().0.clone());
        Err(ApiError("Api-Error: Operation is NOT implemented".into()))
    }

    /// List your provisioned mail orders (sending accounts)
    async fn get_mail_orders(
        &self,
        context: &C) -> Result<GetMailOrdersResponse, ApiError>
    {
        info!("get_mail_orders() - X-Span-ID: {:?}", context.get().0.clone());
        Err(ApiError("Api-Error: Operation is NOT implemented".into()))
    }

    /// Get one mail order's full detail including SMTP password
    async fn get_mail_order_by_id(
        &self,
        id: i64,
        context: &C) -> Result<GetMailOrderByIdResponse, ApiError>
    {
        info!("get_mail_order_by_id({:?}) - X-Span-ID: {:?}", id, context.get().0.clone());
        Err(ApiError("Api-Error: Operation is NOT implemented".into()))
    }

    /// Health check — verify the API is reachable
    async fn ping_server(
        &self,
        context: &C) -> Result<PingServerResponse, ApiError>
    {
        info!("ping_server() - X-Span-ID: {:?}", context.get().0.clone());
        Err(ApiError("Api-Error: Operation is NOT implemented".into()))
    }

}
