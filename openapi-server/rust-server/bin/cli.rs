//! CLI tool driving the API client
use anyhow::{anyhow, Context, Result};
use clap::Parser;
use dialoguer::Confirm;
use log::{debug, info};
// models may be unused if all inputs are primitive types
#[allow(unused_imports)]
use MailBabyRustServer::{
    models, ApiNoContext, Client, ContextWrapperExt,
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
use simple_logger::SimpleLogger;
use swagger::{AuthData, ContextBuilder, EmptyContext, Push, XSpanIdString};

type ClientContext = swagger::make_context_ty!(
    ContextBuilder,
    EmptyContext,
    Option<AuthData>,
    XSpanIdString
);

#[derive(Parser, Debug)]
#[clap(
    name = "MailBaby Email Delivery and Management Service API",
    version = "1.5.0",
    about = "CLI access to MailBaby Email Delivery and Management Service API"
)]
struct Cli {
    #[clap(subcommand)]
    operation: Operation,

    /// Address or hostname of the server hosting this API, including optional port
    #[clap(short = 'a', long, default_value = "http://localhost")]
    server_address: String,

    /// Path to the client private key if using client-side TLS authentication
    #[cfg(all(feature = "client-tls", not(any(target_os = "macos", target_os = "windows", target_os = "ios"))))]
    #[clap(long, requires_all(&["client_certificate", "server_certificate"]))]
    client_key: Option<String>,

    /// Path to the client's public certificate associated with the private key
    #[cfg(all(feature = "client-tls", not(any(target_os = "macos", target_os = "windows", target_os = "ios"))))]
    #[clap(long, requires_all(&["client_key", "server_certificate"]))]
    client_certificate: Option<String>,

    /// Path to CA certificate used to authenticate the server
    #[cfg(all(feature = "client-tls", not(any(target_os = "macos", target_os = "windows", target_os = "ios"))))]
    #[clap(long)]
    server_certificate: Option<String>,

    /// If set, write output to file instead of stdout
    #[clap(short, long)]
    output_file: Option<String>,

    #[command(flatten)]
    verbosity: clap_verbosity_flag::Verbosity,

    /// Don't ask for any confirmation prompts
    #[allow(dead_code)]
    #[clap(short, long)]
    force: bool,

    /// API key for authentication
    #[arg(long, env = "MAILBABYRUSTSERVER_API_KEY", hide_env = true)]
    api_key: Option<String>,
}

#[derive(Parser, Debug)]
enum Operation {
    /// Create a deny rule to block a sender, domain, destination, or prefix
    AddRule {
        #[clap(value_parser = parse_json::<models::DenyRuleNewType>)]
        param_type: models::DenyRuleNewType,
        /// The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
        data: String,
        /// Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
        user: Option<String>,
    },
    /// Delist an email address from the spam-filter block lists
    DelistBlock {
        #[clap(value_parser = parse_json::<models::EmailAddressParam>)]
        email_address_param: models::EmailAddressParam,
    },
    /// List addresses currently flagged by spam-filter block lists
    GetMailBlocks {
    },
    /// List custom deny rules (sender / domain / destination / prefix)
    GetRules {
    },
    /// Delete a deny rule by its numeric ruleId
    DeleteRule {
        /// The numeric ID of the deny rule to delete.  Obtain this from the `id` field in `GET /mail/rules` or the `text` field of a `POST /mail/rules` response.
        rule_id: i32,
    },
    /// Account usage, cost, and volume statistics for a time window
    GetStats {
        /// The time window to scope `received`, `sent`, and `volume` statistics. Does not affect `usage` or `cost`, which are always calculated over the current billing cycle. Defaults to `1h`.
        #[clap(value_parser = parse_json::<models::GetStatsTimeParameter>)]
        time: Option<models::GetStatsTimeParameter>,
    },
    /// Query the mail delivery log (filterable, paginated)
    ViewMailLog {
        /// The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from `GET /mail` or `GET /mail/{id}`.
        id: Option<i64>,
        /// Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address.
        origin: Option<String>,
        /// Filter by the MX hostname the relay attempted delivery to.  For example `mx.google.com` would return messages destined for Gmail recipients. Maps to `mxHostname` in the `MailLogEntry` response.
        mx: Option<String>,
        /// Filter by SMTP envelope `MAIL FROM` address (exact match).  This is the address the relay used for bounce handling and may differ from the `From:` message header.  For header-level filtering use `headerfrom`.
        from: Option<String>,
        /// Filter by SMTP envelope `RCPT TO` address (exact match).  This is the delivery address used by the relay and may differ from the `To:` header when BCC recipients are involved.
        to: Option<String>,
        /// Filter by email `Subject` header (exact match).  To search for a substring, include it in the full subject text.
        subject: Option<String>,
        /// Filter by the relay-assigned mail ID string (exact match).  This corresponds to the `id` field in `MailLogEntry` and to the `text` value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as `185997065c60008840`.
        mailid: Option<String>,
        /// Filter by the `Message-ID` email header using a substring (case-insensitive) match. The `Message-ID` is assigned by the sending mail client and is visible in the `messageId` field of `MailLogEntry`.  Useful when you know the message ID generated by your application but not the relay `mailid`.
        message_id: Option<String>,
        /// Filter by the `Reply-To` message header address (exact match).  Only returns messages where this header was explicitly set.
        replyto: Option<String>,
        /// Filter by the `From` message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope `from` parameter when sending on behalf of another address.
        headerfrom: Option<String>,
        /// Filter by delivery status.  `1` returns only messages that were successfully delivered to the destination MX.  `0` returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status.
        #[clap(value_parser = parse_json::<models::DeliveredStatus>)]
        delivered: Option<models::DeliveredStatus>,
        /// Number of records to skip for pagination.  Use in combination with `limit` to page through large result sets.  Defaults to `0` (no skip).
        skip: Option<u32>,
        /// Maximum number of records to return per page.  Defaults to `100`. Maximum allowed value is `10000`.  The response also includes a `total` field with the full matched count so you can calculate the number of pages.
        limit: Option<u32>,
        /// Earliest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` such as `2024-01-15` or `last monday`.  Messages with a `time` value **greater than or equal to** this value will be included.
        start_date: Option<String>,
        /// Latest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` such as `2024-01-31` or `yesterday`. Messages with a `time` value **less than or equal to** this value will be included.
        end_date: Option<String>,
        /// Field to sort results by.  Currently only `time` is supported (sorts by internal row ID which corresponds to chronological order).
        #[clap(value_parser = parse_json::<models::ViewMailLogSortParameter>)]
        sort: Option<models::ViewMailLogSortParameter>,
        /// Sort direction.  `desc` returns newest first (default), `asc` returns oldest first.
        #[clap(value_parser = parse_json::<models::ViewMailLogDirParameter>)]
        dir: Option<models::ViewMailLogDirParameter>,
        /// Controls how results are grouped.  `recipient` (default) returns one row per delivery attempt — a message sent to 4 recipients produces 4 rows, each with its own `recipient`, `delivered`, `response`, and delivery metadata.  `message` collapses to one row per unique message ID; delivery-level fields will reflect one arbitrary recipient per message.  The `total` count in the response matches the grouping mode.
        #[clap(value_parser = parse_json::<models::ViewMailLogGroupbyParameter>)]
        groupby: Option<models::ViewMailLogGroupbyParameter>,
    },
    /// Send a pre-built RFC 822 message verbatim (preserves DKIM)
    RawMail {
        #[clap(value_parser = parse_json::<models::SendMailRaw>)]
        send_mail_raw: models::SendMailRaw,
    },
    /// Send email with multiple recipients, CC/BCC, attachments, named contacts
    SendAdvMail {
        /// The subject line of the email.
        subject: String,
        /// The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
        body: String,
        /// The sender address.  Accepts a plain email string, an RFC 822 named string (`\\\"Name <email>\\\"`), or a `{\\\"email\\\": \\\"...\\\", \\\"name\\\": \\\"...\\\"}` object.
        #[clap(value_parser = parse_json::<models::EmailAddressTypes>)]
        from: models::EmailAddressTypes,
        /// One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
        #[clap(value_parser = parse_json::<models::EmailAddressesTypes>)]
        to: models::EmailAddressesTypes,
        /// Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.
        #[clap(value_parser = parse_json::<models::EmailAddressesTypes>)]
        replyto: Option<models::EmailAddressesTypes>,
        /// Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.
        #[clap(value_parser = parse_json::<models::EmailAddressesTypes>)]
        cc: Option<models::EmailAddressesTypes>,
        /// Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
        #[clap(value_parser = parse_json::<models::EmailAddressesTypes>)]
        bcc: Option<models::EmailAddressesTypes>,
        /// Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
        #[clap(value_parser = parse_json::<Vec<models::MailAttachment>>, long)]
        attachments: Option<Vec<models::MailAttachment>>,
        /// Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
        id: Option<i64>,
    },
    /// Send a simple email (single recipient, plain or HTML)
    SendMail {
        #[clap(value_parser = parse_json::<models::SendMailTo>)]
        to: models::SendMailTo,
        /// The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.
        from: String,
        /// The subject line of the email.
        subject: String,
        /// The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
        body: String,
        /// Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
        id: Option<i64>,
    },
    /// List your provisioned mail orders (sending accounts)
    GetMailOrders {
    },
    /// Get one mail order's full detail including SMTP password
    GetMailOrderById {
        /// The numeric ID of the mail order.
        id: i64,
    },
    /// Health check — verify the API is reachable
    PingServer {
    },
}

// On Linux/Unix with OpenSSL (client-tls feature), support certificate pinning and mutual TLS
#[cfg(all(feature = "client-tls", not(any(target_os = "macos", target_os = "windows", target_os = "ios"))))]
fn create_client(args: &Cli, context: ClientContext) -> Result<Box<dyn ApiNoContext<ClientContext>>> {
    if args.client_certificate.is_some() {
        debug!("Using mutual TLS");
        let client = Client::try_new_https_mutual(
            &args.server_address,
            args.server_certificate.clone().unwrap(),
            args.client_key.clone().unwrap(),
            args.client_certificate.clone().unwrap(),
        )
        .context("Failed to create HTTPS client")?;
        Ok(Box::new(client.with_context(context)))
    } else if args.server_certificate.is_some() {
        debug!("Using TLS with pinned server certificate");
        let client =
            Client::try_new_https_pinned(&args.server_address, args.server_certificate.clone().unwrap())
                .context("Failed to create HTTPS client")?;
        Ok(Box::new(client.with_context(context)))
    } else {
        debug!("Using client without certificates");
        let client =
            Client::try_new(&args.server_address).context("Failed to create HTTP(S) client")?;
        Ok(Box::new(client.with_context(context)))
    }
}

// On macOS/Windows/iOS or without client-tls feature, use simple client (no cert pinning/mutual TLS)
#[cfg(any(
    not(feature = "client-tls"),
    all(feature = "client-tls", any(target_os = "macos", target_os = "windows", target_os = "ios"))
))]
fn create_client(args: &Cli, context: ClientContext) -> Result<Box<dyn ApiNoContext<ClientContext>>> {
    // Client::try_new() automatically detects the URL scheme (http:// or https://)
    // and creates the appropriate client.
    // Note: Certificate pinning and mutual TLS are only available on Linux/Unix with OpenSSL
    let client =
        Client::try_new(&args.server_address).context("Failed to create HTTP(S) client")?;
    Ok(Box::new(client.with_context(context)))
}

#[tokio::main]
async fn main() -> Result<()> {
    let args = Cli::parse();
    if let Some(log_level) = args.verbosity.log_level() {
        SimpleLogger::new().with_level(log_level.to_level_filter()).init()?;
    }

    debug!("Arguments: {:?}", &args);

    let mut auth_data: Option<AuthData> = None;

    if let Some(ref api_key) = args.api_key {
        debug!("Using API key");
        auth_data = Some(AuthData::apikey(api_key));
    }

    #[allow(trivial_casts)]
    let context = swagger::make_context!(
        ContextBuilder,
        EmptyContext,
        auth_data,
        XSpanIdString::default()
    );

    let client = create_client(&args, context)?;

    let result = match args.operation {
        Operation::AddRule {
            param_type,
            data,
            user,
        } => {
            info!("Performing a AddRule request");

            let result = client.add_rule(
                param_type,
                data,
                user,
            ).await?;
            debug!("Result: {:?}", result);

            match result {
                AddRuleResponse::RuleCreatedSuccessfully
                (body)
                => "RuleCreatedSuccessfully\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                AddRuleResponse::BadRequest
                (body)
                => "BadRequest\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                AddRuleResponse::AuthenticationFailed
                (body)
                => "AuthenticationFailed\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                AddRuleResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                (body)
                => "TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
            }
        }
        Operation::DelistBlock {
            email_address_param,
        } => {
            info!("Performing a DelistBlock request");

            let result = client.delist_block(
                email_address_param,
            ).await?;
            debug!("Result: {:?}", result);

            match result {
                DelistBlockResponse::AddressSuccessfullyDelisted
                (body)
                => "AddressSuccessfullyDelisted\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                DelistBlockResponse::BadRequest
                (body)
                => "BadRequest\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                DelistBlockResponse::AuthenticationFailed
                (body)
                => "AuthenticationFailed\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                DelistBlockResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                (body)
                => "TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
            }
        }
        Operation::GetMailBlocks {
        } => {
            info!("Performing a GetMailBlocks request");

            let result = client.get_mail_blocks(
            ).await?;
            debug!("Result: {:?}", result);

            match result {
                GetMailBlocksResponse::OK
                (body)
                => "OK\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                GetMailBlocksResponse::AuthenticationFailed
                (body)
                => "AuthenticationFailed\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
            }
        }
        Operation::GetRules {
        } => {
            info!("Performing a GetRules request");

            let result = client.get_rules(
            ).await?;
            debug!("Result: {:?}", result);

            match result {
                GetRulesResponse::OK
                (body)
                => "OK\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                GetRulesResponse::AuthenticationFailed
                (body)
                => "AuthenticationFailed\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
            }
        }
        Operation::DeleteRule {
            rule_id,
        } => {
            prompt(args.force, "This will delete the given entry, are you sure?")?;
            info!("Performing a DeleteRule request on {:?}", (
                &rule_id
            ));

            let result = client.delete_rule(
                rule_id,
            ).await?;
            debug!("Result: {:?}", result);

            match result {
                DeleteRuleResponse::RuleDeletedSuccessfully
                (body)
                => "RuleDeletedSuccessfully\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                DeleteRuleResponse::BadRequest
                (body)
                => "BadRequest\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                DeleteRuleResponse::AuthenticationFailed
                (body)
                => "AuthenticationFailed\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                DeleteRuleResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                (body)
                => "TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
            }
        }
        Operation::GetStats {
            time,
        } => {
            info!("Performing a GetStats request");

            let result = client.get_stats(
                time,
            ).await?;
            debug!("Result: {:?}", result);

            match result {
                GetStatsResponse::OK
                (body)
                => "OK\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                GetStatsResponse::AuthenticationFailed
                (body)
                => "AuthenticationFailed\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
            }
        }
        Operation::ViewMailLog {
            id,
            origin,
            mx,
            from,
            to,
            subject,
            mailid,
            message_id,
            replyto,
            headerfrom,
            delivered,
            skip,
            limit,
            start_date,
            end_date,
            sort,
            dir,
            groupby,
        } => {
            info!("Performing a ViewMailLog request");

            let result = client.view_mail_log(
                id,
                origin,
                mx,
                from,
                to,
                subject,
                mailid,
                message_id,
                replyto,
                headerfrom,
                delivered,
                skip,
                limit,
                start_date,
                end_date,
                sort,
                dir,
                groupby,
            ).await?;
            debug!("Result: {:?}", result);

            match result {
                ViewMailLogResponse::PaginatedListOfMailLogEntries
                (body)
                => "PaginatedListOfMailLogEntries\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                ViewMailLogResponse::BadRequest
                (body)
                => "BadRequest\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                ViewMailLogResponse::AuthenticationFailed
                (body)
                => "AuthenticationFailed\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
            }
        }
        Operation::RawMail {
            send_mail_raw,
        } => {
            info!("Performing a RawMail request");

            let result = client.raw_mail(
                send_mail_raw,
            ).await?;
            debug!("Result: {:?}", result);

            match result {
                RawMailResponse::EmailAcceptedForDelivery
                (body)
                => "EmailAcceptedForDelivery\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                RawMailResponse::BadRequest
                (body)
                => "BadRequest\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                RawMailResponse::AuthenticationFailed
                (body)
                => "AuthenticationFailed\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                RawMailResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                (body)
                => "TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
            }
        }
        Operation::SendAdvMail {
            subject,
            body,
            from,
            to,
            replyto,
            cc,
            bcc,
            attachments,
            id,
        } => {
            info!("Performing a SendAdvMail request");

            let result = client.send_adv_mail(
                subject,
                body,
                from,
                to,
                replyto,
                cc,
                bcc,
                attachments.as_ref(),
                id,
            ).await?;
            debug!("Result: {:?}", result);

            match result {
                SendAdvMailResponse::EmailAcceptedForDelivery
                (body)
                => "EmailAcceptedForDelivery\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                SendAdvMailResponse::BadRequest
                (body)
                => "BadRequest\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                SendAdvMailResponse::AuthenticationFailed
                (body)
                => "AuthenticationFailed\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                SendAdvMailResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                (body)
                => "TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
            }
        }
        Operation::SendMail {
            to,
            from,
            subject,
            body,
            id,
        } => {
            info!("Performing a SendMail request");

            let result = client.send_mail(
                to,
                from,
                subject,
                body,
                id,
            ).await?;
            debug!("Result: {:?}", result);

            match result {
                SendMailResponse::EmailAcceptedForDelivery
                (body)
                => "EmailAcceptedForDelivery\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                SendMailResponse::BadRequest
                (body)
                => "BadRequest\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                SendMailResponse::AuthenticationFailed
                (body)
                => "AuthenticationFailed\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                SendMailResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                (body)
                => "TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
            }
        }
        Operation::GetMailOrders {
        } => {
            info!("Performing a GetMailOrders request");

            let result = client.get_mail_orders(
            ).await?;
            debug!("Result: {:?}", result);

            match result {
                GetMailOrdersResponse::OK
                (body)
                => "OK\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                GetMailOrdersResponse::AuthenticationFailed
                (body)
                => "AuthenticationFailed\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
            }
        }
        Operation::GetMailOrderById {
            id,
        } => {
            info!("Performing a GetMailOrderById request on {:?}", (
                &id
            ));

            let result = client.get_mail_order_by_id(
                id,
            ).await?;
            debug!("Result: {:?}", result);

            match result {
                GetMailOrderByIdResponse::OK
                (body)
                => "OK\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                GetMailOrderByIdResponse::BadRequest
                (body)
                => "BadRequest\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                GetMailOrderByIdResponse::AuthenticationFailed
                (body)
                => "AuthenticationFailed\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                GetMailOrderByIdResponse::TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount
                (body)
                => "TheSpecifiedResourceWasNotFoundOrDoesNotBelongToYourAccount\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
            }
        }
        Operation::PingServer {
        } => {
            info!("Performing a PingServer request");

            let result = client.ping_server(
            ).await?;
            debug!("Result: {:?}", result);

            match result {
                PingServerResponse::ServerIsUpAndRunning
                (body)
                => "ServerIsUpAndRunning\n".to_string()
                   +
                    &serde_json::to_string_pretty(&body)?,
                PingServerResponse::SomethingIsWrong
                => "SomethingIsWrong\n".to_string()
                    ,
            }
        }
    };

    if let Some(output_file) = args.output_file {
        std::fs::write(output_file, result)?
    } else {
        println!("{}", result);
    }
    Ok(())
}

fn prompt(force: bool, text: &str) -> Result<()> {
    if force || Confirm::new().with_prompt(text).interact()? {
        Ok(())
    } else {
        Err(anyhow!("Aborting"))
    }
}

// May be unused if all inputs are primitive types
#[allow(dead_code)]
fn parse_json<T: serde::de::DeserializeOwned>(json_string: &str) -> Result<T> {
    serde_json::from_str(json_string).map_err(|err| anyhow!("Error parsing input: {}", err))
}
