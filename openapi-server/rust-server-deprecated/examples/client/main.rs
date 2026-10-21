#![allow(missing_docs, unused_variables, trivial_casts)]


#[allow(unused_imports)]
use futures::{future, Stream, stream};
#[allow(unused_imports)]
use MailBabyRustServerDeprecated::{Api, ApiNoContext, Claims, Client, ContextWrapperExt, models,
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
use clap::{Command, Arg};

// NOTE: Set environment variable RUST_LOG to the name of the executable (or "cargo run") to activate console logging for all loglevels.
//     See https://docs.rs/env_logger/latest/env_logger/  for more details

#[allow(unused_imports)]
use log::info;

// swagger::Has may be unused if there are no examples
#[allow(unused_imports)]
use swagger::{AuthData, ContextBuilder, EmptyContext, Has, Push, XSpanIdString};

type ClientContext = swagger::make_context_ty!(ContextBuilder, EmptyContext, Option<AuthData>, XSpanIdString);

mod client_auth;
use client_auth::build_token;


// rt may be unused if there are no examples
#[allow(unused_mut)]
fn main() {
    env_logger::init();

    let matches = Command::new("client")
        .arg(Arg::new("operation")
            .help("Sets the operation to run")
            .value_parser(Vec::<&str>::from([
                "AddRule",
                "DelistBlock",
                "GetMailBlocks",
                "GetRules",
                "DeleteRule",
                "GetStats",
                "ViewMailLog",
                "GetMailOrders",
                "GetMailOrderById",
                "PingServer",
            ]))
            .required(true)
            .index(1))
        .arg(Arg::new("https")
            .long("https")
            .help("Whether to use HTTPS or not"))
        .arg(Arg::new("host")
            .long("host")
            .default_value("api.mailbaby.net")
            .help("Hostname to contact"))
        .arg(Arg::new("port")
            .long("port")
            .value_parser(clap::value_parser!(u16))
            .default_value("8080")
            .help("Port to contact"))
        .get_matches();

    // Create Bearer-token with a fixed key (secret) for test purposes.
    // In a real (production) system this Bearer token should be obtained via an external Identity/Authentication-server
    // Ensure that you set the correct algorithm and encodingkey that matches what is used on the server side.
    // See https://github.com/Keats/jsonwebtoken for more information
    let auth_token = build_token(
            Claims {
                sub: "tester@acme.com".to_owned(),
                company: "ACME".to_owned(),
                iss: "my_identity_provider".to_owned(),
                // added a very long expiry time
                aud: "org.acme.Resource_Server".to_string(),
                exp: 10000000000,
                // In this example code all available Scopes are added, so the current Bearer Token gets fully authorization.
                scopes:
                  "".to_owned()
            },
            b"secret").unwrap();

    let auth_data = if !auth_token.is_empty() {
        Some(AuthData::Bearer(auth_token))
    } else {
        // No Bearer-token available, so return None
        None
    };

    let is_https = matches.contains_id("https");
    let base_url = format!("{}://{}:{}",
        if is_https { "https" } else { "http" },
        matches.get_one::<String>("host").unwrap(),
        matches.get_one::<u16>("port").unwrap());

    let context: ClientContext =
        swagger::make_context!(ContextBuilder, EmptyContext, auth_data, XSpanIdString::default());

    let mut client : Box<dyn ApiNoContext<ClientContext>> = {
        #[cfg(feature = "client-tls")]
        {
            if is_https {
                // Using HTTPS with native-tls
                let client = Box::new(Client::try_new_https(&base_url)
                    .expect("Failed to create HTTPS client"));
                Box::new(client.with_context(context))
            } else {
                // Using HTTP
                let client = Box::new(Client::try_new_http(&base_url)
                    .expect("Failed to create HTTP client"));
                Box::new(client.with_context(context))
            }
        }

        #[cfg(not(feature = "client-tls"))]
        {
            if is_https {
                panic!("HTTPS requested but TLS support not enabled. \
                        Enable the 'client-tls' feature to use HTTPS.");
            }
            // Using HTTP only
            let client = Box::new(Client::try_new_http(&base_url)
                .expect("Failed to create HTTP client"));
            Box::new(client.with_context(context))
        }
    };

    let mut rt = tokio::runtime::Runtime::new().unwrap();

    match matches.get_one::<String>("operation").map(String::as_str) {
        Some("AddRule") => {
            let result = rt.block_on(client.add_rule(
                  models::DenyRuleNewType::Domain,
                  "data_example".to_string(),
                  Some("user_example".to_string())
            ));
            info!("{:?} (X-Span-ID: {:?})", result, (client.context() as &dyn Has<XSpanIdString>).get().clone());
        },
        Some("DelistBlock") => {
            let result = rt.block_on(client.delist_block(
                  serde_json::from_str::<models::EmailAddressParam>(r#"{"email":"client@domain.com"}"#).expect("Failed to parse JSON example")
            ));
            info!("{:?} (X-Span-ID: {:?})", result, (client.context() as &dyn Has<XSpanIdString>).get().clone());
        },
        Some("GetMailBlocks") => {
            let result = rt.block_on(client.get_mail_blocks(
            ));
            info!("{:?} (X-Span-ID: {:?})", result, (client.context() as &dyn Has<XSpanIdString>).get().clone());
        },
        Some("GetRules") => {
            let result = rt.block_on(client.get_rules(
            ));
            info!("{:?} (X-Span-ID: {:?})", result, (client.context() as &dyn Has<XSpanIdString>).get().clone());
        },
        Some("DeleteRule") => {
            let result = rt.block_on(client.delete_rule(
                  34
            ));
            info!("{:?} (X-Span-ID: {:?})", result, (client.context() as &dyn Has<XSpanIdString>).get().clone());
        },
        Some("GetStats") => {
            let result = rt.block_on(client.get_stats(
                  Some(models::GetStatsTimeParameter::All)
            ));
            info!("{:?} (X-Span-ID: {:?})", result, (client.context() as &dyn Has<XSpanIdString>).get().clone());
        },
        Some("ViewMailLog") => {
            let result = rt.block_on(client.view_mail_log(
                  Some(2604),
                  Some("1.2.3.4".to_string()),
                  Some("mx.google.com".to_string()),
                  Some("me@sender.com".to_string()),
                  Some("you@receiver.com".to_string()),
                  Some("Your order has shipped".to_string()),
                  Some("185997065c60008840".to_string()),
                  Some("<abc123@yourdomain.com>".to_string()),
                  Some("replies@sender.com".to_string()),
                  Some("newsletter@sender.com".to_string()),
                  Some(models::DeliveredStatus::Variant0),
                  Some(0),
                  Some(100),
                  Some(serde_json::from_str::<models::SwaggerColonColonOneOf2LessThanI64CommaStringGreaterThan>(r#"1641781008"#).expect("Failed to parse JSON example")),
                  Some(serde_json::from_str::<models::SwaggerColonColonOneOf2LessThanI64CommaStringGreaterThan>(r#"1673317008"#).expect("Failed to parse JSON example")),
                  Some(models::ViewMailLogSortParameter::Time),
                  Some(models::ViewMailLogDirParameter::Asc),
                  Some(models::ViewMailLogGroupbyParameter::Message)
            ));
            info!("{:?} (X-Span-ID: {:?})", result, (client.context() as &dyn Has<XSpanIdString>).get().clone());
        },
        /* Disabled because there's no example.
        Some("RawMail") => {
            let result = rt.block_on(client.raw_mail(
                  ???
            ));
            info!("{:?} (X-Span-ID: {:?})", result, (client.context() as &dyn Has<XSpanIdString>).get().clone());
        },
        */
        /* Disabled because there's no example.
        Some("SendAdvMail") => {
            let result = rt.block_on(client.send_adv_mail(
                  "subject_example".to_string(),
                  "body_example".to_string(),
                  ???,
                  ???,
                  None,
                  None,
                  None,
                  Some(&Vec::new()),
                  Some(789)
            ));
            info!("{:?} (X-Span-ID: {:?})", result, (client.context() as &dyn Has<XSpanIdString>).get().clone());
        },
        */
        /* Disabled because there's no example.
        Some("SendMail") => {
            let result = rt.block_on(client.send_mail(
                  ???,
                  "from_example".to_string(),
                  "subject_example".to_string(),
                  "body_example".to_string(),
                  Some(789)
            ));
            info!("{:?} (X-Span-ID: {:?})", result, (client.context() as &dyn Has<XSpanIdString>).get().clone());
        },
        */
        Some("GetMailOrders") => {
            let result = rt.block_on(client.get_mail_orders(
            ));
            info!("{:?} (X-Span-ID: {:?})", result, (client.context() as &dyn Has<XSpanIdString>).get().clone());
        },
        Some("GetMailOrderById") => {
            let result = rt.block_on(client.get_mail_order_by_id(
                  39
            ));
            info!("{:?} (X-Span-ID: {:?})", result, (client.context() as &dyn Has<XSpanIdString>).get().clone());
        },
        Some("PingServer") => {
            let result = rt.block_on(client.ping_server(
            ));
            info!("{:?} (X-Span-ID: {:?})", result, (client.context() as &dyn Has<XSpanIdString>).get().clone());
        },
        _ => {
            panic!("Invalid operation provided")
        }
    }
}
