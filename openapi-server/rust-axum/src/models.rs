#![allow(unused_qualifications)]

use http::HeaderValue;
use validator::Validate;

#[cfg(feature = "server")]
use crate::header;
use crate::{models, types::*};

#[allow(dead_code)]
pub type SSE = std::pin::Pin<std::boxed::Box<dyn futures_util::Stream<Item = std::result::Result<axum::response::sse::Event, std::convert::Infallible>> + std::marker::Send + std::marker::Sync>>;

#[allow(dead_code)]
fn from_validation_error(e: validator::ValidationError) -> validator::ValidationErrors {
    let mut errs = validator::ValidationErrors::new();
    errs.add("na", e);
    errs
}

#[allow(dead_code)]
pub fn check_xss_string(v: &str) -> std::result::Result<(), validator::ValidationError> {
    if ammonia::is_html(v) {
        std::result::Result::Err(validator::ValidationError::new("xss detected"))
    } else {
        std::result::Result::Ok(())
    }
}

#[allow(dead_code)]
pub fn check_xss_vec_string(v: &[String]) -> std::result::Result<(), validator::ValidationError> {
    if v.iter().any(|i| ammonia::is_html(i)) {
        std::result::Result::Err(validator::ValidationError::new("xss detected"))
    } else {
        std::result::Result::Ok(())
    }
}

#[allow(dead_code)]
pub fn check_xss_map_string(
    v: &std::collections::HashMap<String, String>,
) -> std::result::Result<(), validator::ValidationError> {
    if v.keys().any(|k| ammonia::is_html(k)) || v.values().any(|v| ammonia::is_html(v)) {
        std::result::Result::Err(validator::ValidationError::new("xss detected"))
    } else {
        std::result::Result::Ok(())
    }
}

#[allow(dead_code)]
pub fn check_xss_map_nested<T>(
    v: &std::collections::HashMap<String, T>,
) -> std::result::Result<(), validator::ValidationError>
where
    T: validator::Validate,
{
    if v.keys().any(|k| ammonia::is_html(k)) || v.values().any(|v| v.validate().is_err()) {
        std::result::Result::Err(validator::ValidationError::new("xss detected"))
    } else {
        std::result::Result::Ok(())
    }
}

#[allow(dead_code)]
pub fn check_xss_map<T>(v: &std::collections::HashMap<String, T>) -> std::result::Result<(), validator::ValidationError> {
    if v.keys().any(|k| ammonia::is_html(k)) {
        std::result::Result::Err(validator::ValidationError::new("xss detected"))
    } else {
        std::result::Result::Ok(())
    }
}



    #[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
    #[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
    pub struct DeleteRulePathParams {
            /// The numeric ID of the deny rule to delete.  Obtain this from the `id` field in `GET /mail/rules` or the `text` field of a `POST /mail/rules` response.
                pub rule_id: i32,
    }






    #[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
    #[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
    pub struct GetStatsQueryParams {
            /// The time window to scope `received`, `sent`, and `volume` statistics. Does not affect `usage` or `cost`, which are always calculated over the current billing cycle. Defaults to `1h`.
            /// Note: inline enums are not fully supported by openapi-generator
                #[serde(rename = "time")]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub time: Option<String>,
    }


    #[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
    #[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
    pub struct ViewMailLogQueryParams {
            /// The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from `GET /mail` or `GET /mail/{id}`.
                #[serde(rename = "id")]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub id: Option<i64>,
            /// Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address.
                #[serde(rename = "origin")]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub origin: Option<String>,
            /// Filter by the MX hostname the relay attempted delivery to.  For example `mx.google.com` would return messages destined for Gmail recipients. Maps to `mxHostname` in the `MailLogEntry` response.
                #[serde(rename = "mx")]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub mx: Option<String>,
            /// Filter by SMTP envelope `MAIL FROM` address (exact match).  This is the address the relay used for bounce handling and may differ from the `From:` message header.  For header-level filtering use `headerfrom`.
                #[serde(rename = "from")]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub from: Option<String>,
            /// Filter by SMTP envelope `RCPT TO` address (exact match).  This is the delivery address used by the relay and may differ from the `To:` header when BCC recipients are involved.
                #[serde(rename = "to")]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub to: Option<String>,
            /// Filter by email `Subject` header (exact match).  To search for a substring, include it in the full subject text.
                #[serde(rename = "subject")]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub subject: Option<String>,
            /// Filter by the relay-assigned mail ID string (exact match).  This corresponds to the `id` field in `MailLogEntry` and to the `text` value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as `185997065c60008840`.
                #[serde(rename = "mailid")]
                #[validate(
                        length(min = 18, max = 19),
              )]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub mailid: Option<String>,
            /// Filter by the `Message-ID` email header using a substring (case-insensitive) match. The `Message-ID` is assigned by the sending mail client and is visible in the `messageId` field of `MailLogEntry`.  Useful when you know the message ID generated by your application but not the relay `mailid`.
                #[serde(rename = "messageId")]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub message_id: Option<String>,
            /// Filter by the `Reply-To` message header address (exact match).  Only returns messages where this header was explicitly set.
                #[serde(rename = "replyto")]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub replyto: Option<String>,
            /// Filter by the `From` message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope `from` parameter when sending on behalf of another address.
                #[serde(rename = "headerfrom")]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub headerfrom: Option<String>,
            /// Filter by delivery status.  `1` returns only messages that were successfully delivered to the destination MX.  `0` returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status.
            /// Note: inline enums are not fully supported by openapi-generator
                #[serde(rename = "delivered")]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub delivered: Option<i32>,
            /// Number of records to skip for pagination.  Use in combination with `limit` to page through large result sets.  Defaults to `0` (no skip).
                #[serde(rename = "skip")]
                #[validate(
                        range(min = 0u32),
              )]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub skip: Option<u32>,
            /// Maximum number of records to return per page.  Defaults to `100`. Maximum allowed value is `10000`.  The response also includes a `total` field with the full matched count so you can calculate the number of pages.
                #[serde(rename = "limit")]
                #[validate(
                        range(min = 1u32, max = 10000u32),
              )]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub limit: Option<u32>,
            /// Earliest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` such as `2024-01-15` or `last monday`.  Messages with a `time` value **greater than or equal to** this value will be included.
                #[serde(rename = "startDate")]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub start_date: Option<models::OneOfLessThanLongCommaStringGreaterThan>,
            /// Latest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` such as `2024-01-31` or `yesterday`. Messages with a `time` value **less than or equal to** this value will be included.
                #[serde(rename = "endDate")]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub end_date: Option<models::OneOfLessThanLongCommaStringGreaterThan>,
            /// Field to sort results by.  Currently only `time` is supported (sorts by internal row ID which corresponds to chronological order).
            /// Note: inline enums are not fully supported by openapi-generator
                #[serde(rename = "sort")]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub sort: Option<String>,
            /// Sort direction.  `desc` returns newest first (default), `asc` returns oldest first.
            /// Note: inline enums are not fully supported by openapi-generator
                #[serde(rename = "dir")]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub dir: Option<String>,
            /// Controls how results are grouped.  `recipient` (default) returns one row per delivery attempt — a message sent to 4 recipients produces 4 rows, each with its own `recipient`, `delivered`, `response`, and delivery metadata.  `message` collapses to one row per unique message ID; delivery-level fields will reflect one arbitrary recipient per message.  The `total` count in the response matches the grouping mode.
            /// Note: inline enums are not fully supported by openapi-generator
                #[serde(rename = "groupby")]
                    #[serde(skip_serializing_if="Option::is_none")]
                    pub groupby: Option<String>,
    }





    #[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
    #[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
    pub struct GetMailOrderByIdPathParams {
            /// The numeric ID of the mail order.
                pub id: i64,
    }






/// A date/time value accepted as either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` (e.g. `2024-01-15`, `last monday`).
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize)]
#[serde(untagged)]
#[allow(non_camel_case_types, clippy::large_enum_variant)]
pub enum DateOrTimestamp {
    U64(u64),
    String(String),
}

impl validator::Validate for DateOrTimestamp
{
    fn validate(&self) -> std::result::Result<(), validator::ValidationErrors> {
        match self {
            Self::U64(_) => std::result::Result::Ok(()),
            Self::String(_) => std::result::Result::Ok(()),
        }
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a DateOrTimestamp value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for DateOrTimestamp {
    type Err = serde_json::Error;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        serde_json::from_str(s)
    }
}


impl From<u64> for DateOrTimestamp {
    fn from(value: u64) -> Self {
        Self::U64(value)
    }
}
impl From<String> for DateOrTimestamp {
    fn from(value: String) -> Self {
        Self::String(value)
    }
}





/// The fields required to create a new email deny rule via `POST /mail/rules`. The `type` controls what `data` is matched against: - `email` — exact sender address match - `domain` — all senders from a domain - `destination` — exact recipient address match - `startswith` — sender local-part prefix match (alphanumeric + `+_.-` only)
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct DenyRuleNew {
    /// The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
    /// Note: inline enums are not fully supported by openapi-generator
    #[serde(rename = "type")]
          #[validate(custom(function = "check_xss_string"))]
    pub r_type: String,

    /// The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
    #[serde(rename = "data")]
          #[validate(custom(function = "check_xss_string"))]
    pub data: String,

    /// Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
    #[serde(rename = "user")]
          #[validate(custom(function = "check_xss_string"))]
    #[serde(skip_serializing_if="Option::is_none")]
    pub user: Option<String>,

}



impl DenyRuleNew {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new(r_type: String, data: String, ) -> DenyRuleNew {
        DenyRuleNew {
 r_type,
 data,
 user: None,
        }
    }
}

/// Converts the DenyRuleNew value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for DenyRuleNew {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![

            Some("type".to_string()),
            Some(self.r_type.to_string()),


            Some("data".to_string()),
            Some(self.data.to_string()),


            self.user.as_ref().map(|user| {
                [
                    "user".to_string(),
                    user.to_string(),
                ].join(",")
            }),

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a DenyRuleNew value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for DenyRuleNew {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub r_type: Vec<String>,
            pub data: Vec<String>,
            pub user: Vec<String>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing DenyRuleNew".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    #[allow(clippy::redundant_clone)]
                    "type" => intermediate_rep.r_type.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "data" => intermediate_rep.data.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "user" => intermediate_rep.user.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    _ => return std::result::Result::Err("Unexpected key while parsing DenyRuleNew".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(DenyRuleNew {
            r_type: intermediate_rep.r_type.into_iter().next().ok_or_else(|| "type missing in DenyRuleNew".to_string())?,
            data: intermediate_rep.data.into_iter().next().ok_or_else(|| "data missing in DenyRuleNew".to_string())?,
            user: intermediate_rep.user.into_iter().next(),
        })
    }
}

// Methods for converting between header::IntoHeaderValue<DenyRuleNew> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<DenyRuleNew>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<DenyRuleNew>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for DenyRuleNew - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<DenyRuleNew> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <DenyRuleNew as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into DenyRuleNew - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// A complete deny rule record as returned by `GET /mail/rules`.  Combines the rule definition fields (`DenyRuleNew`) with server-assigned metadata (`id` and `created`).  The `id` value is required by `DELETE /mail/rules/{ruleId}`.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct DenyRuleRecord {
    /// The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
    /// Note: inline enums are not fully supported by openapi-generator
    #[serde(rename = "type")]
          #[validate(custom(function = "check_xss_string"))]
    pub r_type: String,

    /// The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
    #[serde(rename = "data")]
          #[validate(custom(function = "check_xss_string"))]
    pub data: String,

    /// The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule.
    #[serde(rename = "id")]
          #[validate(custom(function = "check_xss_string"))]
    pub id: String,

    /// The timestamp when the rule was created.
    #[serde(rename = "created")]
    pub created: chrono::DateTime::<chrono::Utc>,

    /// Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
    #[serde(rename = "user")]
          #[validate(custom(function = "check_xss_string"))]
    #[serde(skip_serializing_if="Option::is_none")]
    pub user: Option<String>,

}



impl DenyRuleRecord {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new(r_type: String, data: String, id: String, created: chrono::DateTime::<chrono::Utc>, ) -> DenyRuleRecord {
        DenyRuleRecord {
 r_type,
 data,
 id,
 created,
 user: None,
        }
    }
}

/// Converts the DenyRuleRecord value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for DenyRuleRecord {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![

            Some("type".to_string()),
            Some(self.r_type.to_string()),


            Some("data".to_string()),
            Some(self.data.to_string()),


            Some("id".to_string()),
            Some(self.id.to_string()),

            // Skipping created in query parameter serialization


            self.user.as_ref().map(|user| {
                [
                    "user".to_string(),
                    user.to_string(),
                ].join(",")
            }),

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a DenyRuleRecord value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for DenyRuleRecord {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub r_type: Vec<String>,
            pub data: Vec<String>,
            pub id: Vec<String>,
            pub created: Vec<chrono::DateTime::<chrono::Utc>>,
            pub user: Vec<String>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing DenyRuleRecord".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    #[allow(clippy::redundant_clone)]
                    "type" => intermediate_rep.r_type.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "data" => intermediate_rep.data.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "id" => intermediate_rep.id.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "created" => intermediate_rep.created.push(<chrono::DateTime::<chrono::Utc> as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "user" => intermediate_rep.user.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    _ => return std::result::Result::Err("Unexpected key while parsing DenyRuleRecord".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(DenyRuleRecord {
            r_type: intermediate_rep.r_type.into_iter().next().ok_or_else(|| "type missing in DenyRuleRecord".to_string())?,
            data: intermediate_rep.data.into_iter().next().ok_or_else(|| "data missing in DenyRuleRecord".to_string())?,
            id: intermediate_rep.id.into_iter().next().ok_or_else(|| "id missing in DenyRuleRecord".to_string())?,
            created: intermediate_rep.created.into_iter().next().ok_or_else(|| "created missing in DenyRuleRecord".to_string())?,
            user: intermediate_rep.user.into_iter().next(),
        })
    }
}

// Methods for converting between header::IntoHeaderValue<DenyRuleRecord> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<DenyRuleRecord>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<DenyRuleRecord>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for DenyRuleRecord - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<DenyRuleRecord> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <DenyRuleRecord as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into DenyRuleRecord - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// An email contact with an optional display name.  Used in structured address fields (`from`, `to`, `cc`, `bcc`, `replyto`) in `SendMailAdv`.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct EmailAddressName {
    /// The email address.
    #[serde(rename = "email")]
          #[validate(custom(function = "check_xss_string"))]
    pub email: String,

    /// Optional display name shown to recipients (e.g. in the `From:` header).
    #[serde(rename = "name")]
          #[validate(custom(function = "check_xss_string"))]
    #[serde(skip_serializing_if="Option::is_none")]
    pub name: Option<String>,

}



impl EmailAddressName {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new(email: String, ) -> EmailAddressName {
        EmailAddressName {
 email,
 name: None,
        }
    }
}

/// Converts the EmailAddressName value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for EmailAddressName {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![

            Some("email".to_string()),
            Some(self.email.to_string()),


            self.name.as_ref().map(|name| {
                [
                    "name".to_string(),
                    name.to_string(),
                ].join(",")
            }),

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a EmailAddressName value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for EmailAddressName {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub email: Vec<String>,
            pub name: Vec<String>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing EmailAddressName".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    #[allow(clippy::redundant_clone)]
                    "email" => intermediate_rep.email.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "name" => intermediate_rep.name.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    _ => return std::result::Result::Err("Unexpected key while parsing EmailAddressName".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(EmailAddressName {
            email: intermediate_rep.email.into_iter().next().ok_or_else(|| "email missing in EmailAddressName".to_string())?,
            name: intermediate_rep.name.into_iter().next(),
        })
    }
}

// Methods for converting between header::IntoHeaderValue<EmailAddressName> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<EmailAddressName>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<EmailAddressName>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for EmailAddressName - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<EmailAddressName> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <EmailAddressName as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into EmailAddressName - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// A single email address parameter used as the body of `POST /mail/blocks/delete`.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct EmailAddressParam {
    /// The email address to delist from all block lists.
    #[serde(rename = "email")]
          #[validate(custom(function = "check_xss_string"))]
    pub email: String,

}



impl EmailAddressParam {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new(email: String, ) -> EmailAddressParam {
        EmailAddressParam {
 email,
        }
    }
}

/// Converts the EmailAddressParam value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for EmailAddressParam {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![

            Some("email".to_string()),
            Some(self.email.to_string()),

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a EmailAddressParam value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for EmailAddressParam {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub email: Vec<String>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing EmailAddressParam".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    #[allow(clippy::redundant_clone)]
                    "email" => intermediate_rep.email.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    _ => return std::result::Result::Err("Unexpected key while parsing EmailAddressParam".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(EmailAddressParam {
            email: intermediate_rep.email.into_iter().next().ok_or_else(|| "email missing in EmailAddressParam".to_string())?,
        })
    }
}

// Methods for converting between header::IntoHeaderValue<EmailAddressParam> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<EmailAddressParam>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<EmailAddressParam>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for EmailAddressParam - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<EmailAddressParam> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <EmailAddressParam as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into EmailAddressParam - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (`\"Name <email>\"`), or a structured contact object.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize)]
#[serde(untagged)]
#[allow(non_camel_case_types, clippy::large_enum_variant)]
pub enum EmailAddressTypes {
    String(String),
    EmailAddressName(models::EmailAddressName),
}

impl validator::Validate for EmailAddressTypes
{
    fn validate(&self) -> std::result::Result<(), validator::ValidationErrors> {
        match self {
            Self::String(_) => std::result::Result::Ok(()),
            Self::EmailAddressName(v) => v.validate(),
        }
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a EmailAddressTypes value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for EmailAddressTypes {
    type Err = serde_json::Error;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        serde_json::from_str(s)
    }
}


impl From<String> for EmailAddressTypes {
    fn from(value: String) -> Self {
        Self::String(value)
    }
}
impl From<models::EmailAddressName> for EmailAddressTypes {
    fn from(value: models::EmailAddressName) -> Self {
        Self::EmailAddressName(value)
    }
}





/// A flexible email address list that accepts either a plain RFC 822 string or a structured array of contact objects.  When a string is provided it is parsed as a comma-separated list of RFC 822 addresses (supporting the `\"Name <email>\"` and bare `email` formats).  When an array is provided each entry must have at least an `email` field with an optional `name` field.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize)]
#[serde(untagged)]
#[allow(non_camel_case_types, clippy::large_enum_variant)]
pub enum EmailAddressesTypes {
    String(String),
    VecOfEmailAddressName(Vec<models::EmailAddressName>),
}

impl validator::Validate for EmailAddressesTypes
{
    fn validate(&self) -> std::result::Result<(), validator::ValidationErrors> {
        match self {
            Self::String(_) => std::result::Result::Ok(()),
            Self::VecOfEmailAddressName(_) => std::result::Result::Ok(()),
        }
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a EmailAddressesTypes value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for EmailAddressesTypes {
    type Err = serde_json::Error;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        serde_json::from_str(s)
    }
}


impl From<String> for EmailAddressesTypes {
    fn from(value: String) -> Self {
        Self::String(value)
    }
}
impl From<Vec<models::EmailAddressName>> for EmailAddressesTypes {
    fn from(value: Vec<models::EmailAddressName>) -> Self {
        Self::VecOfEmailAddressName(value)
    }
}





/// The response body returned when an error occurs.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct ErrorMessage {
    /// The HTTP-style status code associated with the error.
    #[serde(rename = "code")]
    pub code: i32,

    /// A human-readable description of the error.
    #[serde(rename = "message")]
          #[validate(custom(function = "check_xss_string"))]
    pub message: String,

}



impl ErrorMessage {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new(code: i32, message: String, ) -> ErrorMessage {
        ErrorMessage {
 code,
 message,
        }
    }
}

/// Converts the ErrorMessage value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for ErrorMessage {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![

            Some("code".to_string()),
            Some(self.code.to_string()),


            Some("message".to_string()),
            Some(self.message.to_string()),

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a ErrorMessage value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for ErrorMessage {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub code: Vec<i32>,
            pub message: Vec<String>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing ErrorMessage".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    #[allow(clippy::redundant_clone)]
                    "code" => intermediate_rep.code.push(<i32 as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "message" => intermediate_rep.message.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    _ => return std::result::Result::Err("Unexpected key while parsing ErrorMessage".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(ErrorMessage {
            code: intermediate_rep.code.into_iter().next().ok_or_else(|| "code missing in ErrorMessage".to_string())?,
            message: intermediate_rep.message.into_iter().next().ok_or_else(|| "message missing in ErrorMessage".to_string())?,
        })
    }
}

// Methods for converting between header::IntoHeaderValue<ErrorMessage> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<ErrorMessage>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<ErrorMessage>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for ErrorMessage - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<ErrorMessage> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <ErrorMessage as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into ErrorMessage - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// Standard success response returned by write operations (send, add rule, delete, etc.).  The `status` field is always `\"ok\"` on success.  The `text` field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record's ID; for delete calls it contains a confirmation string.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct GenericResponse {
    /// Always `\"ok\"` on success.
    #[serde(rename = "status")]
          #[validate(custom(function = "check_xss_string"))]
    pub status: String,

    /// Operation-specific result string.  For send operations this is the relay transaction ID (e.g. `185caa69ff7000f47c`) which can be used as the `mailid` parameter in `GET /mail/log`.  For create operations this is the new record's numeric ID.  For delete operations this is a human-readable confirmation.
    #[serde(rename = "text")]
          #[validate(custom(function = "check_xss_string"))]
    pub text: String,

}



impl GenericResponse {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new(status: String, text: String, ) -> GenericResponse {
        GenericResponse {
 status,
 text,
        }
    }
}

/// Converts the GenericResponse value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for GenericResponse {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![

            Some("status".to_string()),
            Some(self.status.to_string()),


            Some("text".to_string()),
            Some(self.text.to_string()),

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a GenericResponse value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for GenericResponse {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub status: Vec<String>,
            pub text: Vec<String>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing GenericResponse".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    #[allow(clippy::redundant_clone)]
                    "status" => intermediate_rep.status.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "text" => intermediate_rep.text.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    _ => return std::result::Result::Err("Unexpected key while parsing GenericResponse".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(GenericResponse {
            status: intermediate_rep.status.into_iter().next().ok_or_else(|| "status missing in GenericResponse".to_string())?,
            text: intermediate_rep.text.into_iter().next().ok_or_else(|| "text missing in GenericResponse".to_string())?,
        })
    }
}

// Methods for converting between header::IntoHeaderValue<GenericResponse> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<GenericResponse>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<GenericResponse>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for GenericResponse - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<GenericResponse> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <GenericResponse as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into GenericResponse - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailAttachment {
    /// The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).
    #[serde(rename = "filename")]
          #[validate(custom(function = "check_xss_string"))]
    pub filename: String,

    /// The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
    #[serde(rename = "data")]
    pub data: ByteArray,

}



impl MailAttachment {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new(filename: String, data: ByteArray, ) -> MailAttachment {
        MailAttachment {
 filename,
 data,
        }
    }
}

/// Converts the MailAttachment value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for MailAttachment {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![

            Some("filename".to_string()),
            Some(self.filename.to_string()),

            // Skipping data in query parameter serialization
            // Skipping data in query parameter serialization

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a MailAttachment value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for MailAttachment {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub filename: Vec<String>,
            pub data: Vec<ByteArray>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing MailAttachment".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    #[allow(clippy::redundant_clone)]
                    "filename" => intermediate_rep.filename.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    "data" => return std::result::Result::Err("Parsing binary data in this style is not supported in MailAttachment".to_string()),
                    _ => return std::result::Result::Err("Unexpected key while parsing MailAttachment".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(MailAttachment {
            filename: intermediate_rep.filename.into_iter().next().ok_or_else(|| "filename missing in MailAttachment".to_string())?,
            data: intermediate_rep.data.into_iter().next().ok_or_else(|| "data missing in MailAttachment".to_string())?,
        })
    }
}

// Methods for converting between header::IntoHeaderValue<MailAttachment> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<MailAttachment>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailAttachment>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for MailAttachment - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<MailAttachment> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailAttachment as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into MailAttachment - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailBlockClickHouse {
    /// The date the block event was recorded.
    #[serde(rename = "date")]
    pub date: chrono::naive::NaiveDate,

    /// The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
    #[serde(rename = "from")]
          #[validate(custom(function = "check_xss_string"))]
    pub from: String,

    /// The `Subject` header of the blocked message.
    #[serde(rename = "subject")]
          #[validate(custom(function = "check_xss_string"))]
    pub subject: String,

    /// The serialized list of recipients of the blocked message.
    #[serde(rename = "to")]
          #[validate(custom(function = "check_xss_string"))]
    pub to: String,

    /// The `Message-ID` header of the blocked message, or `null` if not present.
    #[serde(rename = "messageId")]
    #[serde(deserialize_with = "deserialize_optional_nullable")]
    #[serde(default = "default_optional_nullable")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub message_id: Option<Nullable<String>>,

}



impl MailBlockClickHouse {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new(date: chrono::naive::NaiveDate, from: String, subject: String, to: String, ) -> MailBlockClickHouse {
        MailBlockClickHouse {
 date,
 from,
 subject,
 to,
 message_id: None,
        }
    }
}

/// Converts the MailBlockClickHouse value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for MailBlockClickHouse {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![
            // Skipping date in query parameter serialization


            Some("from".to_string()),
            Some(self.from.to_string()),


            Some("subject".to_string()),
            Some(self.subject.to_string()),


            Some("to".to_string()),
            Some(self.to.to_string()),


            self.message_id.as_ref().map(|message_id| {
                [
                    "messageId".to_string(),
                    message_id.as_ref().map_or("null".to_string(), |x| x.to_string()),
                ].join(",")
            }),

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a MailBlockClickHouse value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for MailBlockClickHouse {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub date: Vec<chrono::naive::NaiveDate>,
            pub from: Vec<String>,
            pub subject: Vec<String>,
            pub to: Vec<String>,
            pub message_id: Vec<String>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing MailBlockClickHouse".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    #[allow(clippy::redundant_clone)]
                    "date" => intermediate_rep.date.push(<chrono::naive::NaiveDate as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "from" => intermediate_rep.from.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "subject" => intermediate_rep.subject.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "to" => intermediate_rep.to.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    "messageId" => return std::result::Result::Err("Parsing a nullable type in this style is not supported in MailBlockClickHouse".to_string()),
                    _ => return std::result::Result::Err("Unexpected key while parsing MailBlockClickHouse".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(MailBlockClickHouse {
            date: intermediate_rep.date.into_iter().next().ok_or_else(|| "date missing in MailBlockClickHouse".to_string())?,
            from: intermediate_rep.from.into_iter().next().ok_or_else(|| "from missing in MailBlockClickHouse".to_string())?,
            subject: intermediate_rep.subject.into_iter().next().ok_or_else(|| "subject missing in MailBlockClickHouse".to_string())?,
            to: intermediate_rep.to.into_iter().next().ok_or_else(|| "to missing in MailBlockClickHouse".to_string())?,
            message_id: std::result::Result::Err("Nullable types not supported in MailBlockClickHouse".to_string())?,
        })
    }
}

// Methods for converting between header::IntoHeaderValue<MailBlockClickHouse> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<MailBlockClickHouse>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailBlockClickHouse>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for MailBlockClickHouse - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<MailBlockClickHouse> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailBlockClickHouse as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into MailBlockClickHouse - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailBlockRspamd {
    /// The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender.
    #[serde(rename = "from")]
          #[validate(custom(function = "check_xss_string"))]
    pub from: String,

    /// The suspicious subject pattern that triggered the block.
    #[serde(rename = "subject")]
          #[validate(custom(function = "check_xss_string"))]
    pub subject: String,

}



impl MailBlockRspamd {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new(from: String, subject: String, ) -> MailBlockRspamd {
        MailBlockRspamd {
 from,
 subject,
        }
    }
}

/// Converts the MailBlockRspamd value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for MailBlockRspamd {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![

            Some("from".to_string()),
            Some(self.from.to_string()),


            Some("subject".to_string()),
            Some(self.subject.to_string()),

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a MailBlockRspamd value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for MailBlockRspamd {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub from: Vec<String>,
            pub subject: Vec<String>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing MailBlockRspamd".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    #[allow(clippy::redundant_clone)]
                    "from" => intermediate_rep.from.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "subject" => intermediate_rep.subject.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    _ => return std::result::Result::Err("Unexpected key while parsing MailBlockRspamd".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(MailBlockRspamd {
            from: intermediate_rep.from.into_iter().next().ok_or_else(|| "from missing in MailBlockRspamd".to_string())?,
            subject: intermediate_rep.subject.into_iter().next().ok_or_else(|| "subject missing in MailBlockRspamd".to_string())?,
        })
    }
}

// Methods for converting between header::IntoHeaderValue<MailBlockRspamd> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<MailBlockRspamd>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailBlockRspamd>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for MailBlockRspamd - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<MailBlockRspamd> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailBlockRspamd as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into MailBlockRspamd - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// The complete set of blocked addresses and message patterns returned by `GET /mail/blocks`. Three independent block sources are combined into one response. Use `POST /mail/blocks/delete` with a `from` address from any entry to delist it.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailBlocks {
    /// Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
    #[serde(rename = "local")]
          #[validate(nested)]
    pub local: Vec<models::MailBlockClickHouse>,

    /// Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.
    #[serde(rename = "mbtrap")]
          #[validate(nested)]
    pub mbtrap: Vec<models::MailBlockClickHouse>,

    /// Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.
    #[serde(rename = "subject")]
          #[validate(nested)]
    pub subject: Vec<models::MailBlockRspamd>,

}



impl MailBlocks {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new(local: Vec<models::MailBlockClickHouse>, mbtrap: Vec<models::MailBlockClickHouse>, subject: Vec<models::MailBlockRspamd>, ) -> MailBlocks {
        MailBlocks {
 local,
 mbtrap,
 subject,
        }
    }
}

/// Converts the MailBlocks value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for MailBlocks {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![
            // Skipping local in query parameter serialization

            // Skipping mbtrap in query parameter serialization

            // Skipping subject in query parameter serialization

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a MailBlocks value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for MailBlocks {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub local: Vec<Vec<models::MailBlockClickHouse>>,
            pub mbtrap: Vec<Vec<models::MailBlockClickHouse>>,
            pub subject: Vec<Vec<models::MailBlockRspamd>>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing MailBlocks".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    "local" => return std::result::Result::Err("Parsing a container in this style is not supported in MailBlocks".to_string()),
                    "mbtrap" => return std::result::Result::Err("Parsing a container in this style is not supported in MailBlocks".to_string()),
                    "subject" => return std::result::Result::Err("Parsing a container in this style is not supported in MailBlocks".to_string()),
                    _ => return std::result::Result::Err("Unexpected key while parsing MailBlocks".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(MailBlocks {
            local: intermediate_rep.local.into_iter().next().ok_or_else(|| "local missing in MailBlocks".to_string())?,
            mbtrap: intermediate_rep.mbtrap.into_iter().next().ok_or_else(|| "mbtrap missing in MailBlocks".to_string())?,
            subject: intermediate_rep.subject.into_iter().next().ok_or_else(|| "subject missing in MailBlocks".to_string())?,
        })
    }
}

// Methods for converting between header::IntoHeaderValue<MailBlocks> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<MailBlocks>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailBlocks>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for MailBlocks - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<MailBlocks> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailBlocks as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into MailBlocks - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// Paginated mail log response returned by `GET /mail/log`.  Contains the full matched count (`total`) plus a page of `MailLogEntry` records.  Use `skip` and `limit` to page through large result sets.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailLog {
    /// Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.
    #[serde(rename = "total")]
    pub total: i32,

    /// The `skip` value used for this page (echoed from the request).
    #[serde(rename = "skip")]
    pub skip: i32,

    /// The `limit` value used for this page (echoed from the request).
    #[serde(rename = "limit")]
    pub limit: i32,

    #[serde(rename = "emails")]
          #[validate(nested)]
    pub emails: Vec<models::MailLogEntry>,

}



impl MailLog {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new(total: i32, skip: i32, limit: i32, emails: Vec<models::MailLogEntry>, ) -> MailLog {
        MailLog {
 total,
 skip,
 limit,
 emails,
        }
    }
}

/// Converts the MailLog value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for MailLog {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![

            Some("total".to_string()),
            Some(self.total.to_string()),


            Some("skip".to_string()),
            Some(self.skip.to_string()),


            Some("limit".to_string()),
            Some(self.limit.to_string()),

            // Skipping emails in query parameter serialization

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a MailLog value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for MailLog {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub total: Vec<i32>,
            pub skip: Vec<i32>,
            pub limit: Vec<i32>,
            pub emails: Vec<Vec<models::MailLogEntry>>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing MailLog".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    #[allow(clippy::redundant_clone)]
                    "total" => intermediate_rep.total.push(<i32 as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "skip" => intermediate_rep.skip.push(<i32 as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "limit" => intermediate_rep.limit.push(<i32 as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    "emails" => return std::result::Result::Err("Parsing a container in this style is not supported in MailLog".to_string()),
                    _ => return std::result::Result::Err("Unexpected key while parsing MailLog".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(MailLog {
            total: intermediate_rep.total.into_iter().next().ok_or_else(|| "total missing in MailLog".to_string())?,
            skip: intermediate_rep.skip.into_iter().next().ok_or_else(|| "skip missing in MailLog".to_string())?,
            limit: intermediate_rep.limit.into_iter().next().ok_or_else(|| "limit missing in MailLog".to_string())?,
            emails: intermediate_rep.emails.into_iter().next().ok_or_else(|| "emails missing in MailLog".to_string())?,
        })
    }
}

// Methods for converting between header::IntoHeaderValue<MailLog> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<MailLog>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailLog>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for MailLog - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<MailLog> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailLog as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into MailLog - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The `id` field matches the `mailid` query parameter on `GET /mail/log` and   the `text` field of a successful send response. - The `from` address can be passed to `POST /mail/blocks/delete` to delist a   flagged sender. - The `user` field is the SMTP username (e.g. `mb5658`) corresponding to the   `username` field in `GET /mail` / `GET /mail/{id}`.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailLogEntry {
    /// Internal auto-increment database row ID.  Not meaningful outside the API.
    #[serde(rename = "_id")]
    pub _id: i32,

    /// The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.
    #[serde(rename = "id")]
    #[validate(
            length(min = 18, max = 19),
          custom(function = "check_xss_string"),
    )]
    pub id: String,

    /// SMTP envelope `MAIL FROM` address (may differ from the `From:` header).
    #[serde(rename = "from")]
          #[validate(custom(function = "check_xss_string"))]
    pub from: String,

    /// SMTP envelope `RCPT TO` address.
    #[serde(rename = "to")]
          #[validate(custom(function = "check_xss_string"))]
    pub to: String,

    /// Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.
    #[serde(rename = "created")]
          #[validate(custom(function = "check_xss_string"))]
    pub created: String,

    /// Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.
    #[serde(rename = "time")]
    pub time: i32,

    /// The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.
    #[serde(rename = "user")]
          #[validate(custom(function = "check_xss_string"))]
    pub user: String,

    /// SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).
    #[serde(rename = "transtype")]
          #[validate(custom(function = "check_xss_string"))]
    pub transtype: String,

    /// IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.
    #[serde(rename = "origin")]
          #[validate(custom(function = "check_xss_string"))]
    pub origin: String,

    /// Relay interface name that accepted the message (e.g. `feeder`).
    #[serde(rename = "interface")]
          #[validate(custom(function = "check_xss_string"))]
    pub interface: String,

    /// The `Subject` header value, if available.
    #[serde(rename = "subject")]
    #[serde(deserialize_with = "deserialize_optional_nullable")]
    #[serde(default = "default_optional_nullable")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub subject: Option<Nullable<String>>,

    /// The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.
    #[serde(rename = "messageId")]
    #[serde(deserialize_with = "deserialize_optional_nullable")]
    #[serde(default = "default_optional_nullable")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub message_id: Option<Nullable<String>>,

    /// The sending zone assigned by the relay for outbound delivery.
    #[serde(rename = "sendingZone")]
    #[serde(deserialize_with = "deserialize_optional_nullable")]
    #[serde(default = "default_optional_nullable")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub sending_zone: Option<Nullable<String>>,

    /// Size of the message body in bytes.
    #[serde(rename = "bodySize")]
    #[serde(deserialize_with = "deserialize_optional_nullable")]
    #[serde(default = "default_optional_nullable")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub body_size: Option<Nullable<i32>>,

    /// Sequence index of this recipient in a multi-recipient message. Starts at 1.
    #[serde(rename = "seq")]
    #[serde(deserialize_with = "deserialize_optional_nullable")]
    #[serde(default = "default_optional_nullable")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub seq: Option<Nullable<i32>>,

    /// Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.
    #[serde(rename = "delivered")]
    #[serde(deserialize_with = "deserialize_optional_nullable")]
    #[serde(default = "default_optional_nullable")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub delivered: Option<Nullable<i32>>,

    /// The SMTP response code from the destination MX server (e.g. `250` for success, `550` for permanent failure).
    #[serde(rename = "code")]
    #[serde(deserialize_with = "deserialize_optional_nullable")]
    #[serde(default = "default_optional_nullable")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub code: Option<Nullable<i32>>,

    /// The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).
    #[serde(rename = "response")]
    #[serde(deserialize_with = "deserialize_optional_nullable")]
    #[serde(default = "default_optional_nullable")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub response: Option<Nullable<String>>,

    /// The specific recipient address this delivery record is for.
    #[serde(rename = "recipient")]
    #[serde(deserialize_with = "deserialize_optional_nullable")]
    #[serde(default = "default_optional_nullable")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub recipient: Option<Nullable<String>>,

    /// The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.
    #[serde(rename = "domain")]
    #[serde(deserialize_with = "deserialize_optional_nullable")]
    #[serde(default = "default_optional_nullable")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub domain: Option<Nullable<String>>,

    /// Whether the queue entry is currently locked for delivery processing.
    #[serde(rename = "locked")]
    #[serde(deserialize_with = "deserialize_optional_nullable")]
    #[serde(default = "default_optional_nullable")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub locked: Option<Nullable<i32>>,

    /// Millisecond-precision timestamp of the last queue lock acquisition.
    #[serde(rename = "lockTime")]
    #[serde(deserialize_with = "deserialize_optional_nullable")]
    #[serde(default = "default_optional_nullable")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub lock_time: Option<Nullable<String>>,

    /// The relay server node assigned to deliver this message.
    #[serde(rename = "assigned")]
    #[serde(deserialize_with = "deserialize_optional_nullable")]
    #[serde(default = "default_optional_nullable")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub assigned: Option<Nullable<String>>,

    /// ISO 8601 timestamp when the message was placed into the delivery queue.
    #[serde(rename = "queued")]
    #[serde(deserialize_with = "deserialize_optional_nullable")]
    #[serde(default = "default_optional_nullable")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub queued: Option<Nullable<String>>,

    /// The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.
    #[serde(rename = "mxHostname")]
    #[serde(deserialize_with = "deserialize_optional_nullable")]
    #[serde(default = "default_optional_nullable")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub mx_hostname: Option<Nullable<String>>,

}



impl MailLogEntry {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new(_id: i32, id: String, from: String, to: String, created: String, time: i32, user: String, transtype: String, origin: String, interface: String, ) -> MailLogEntry {
        MailLogEntry {
 _id,
 id,
 from,
 to,
 created,
 time,
 user,
 transtype,
 origin,
 interface,
 subject: None,
 message_id: None,
 sending_zone: None,
 body_size: None,
 seq: None,
 delivered: None,
 code: None,
 response: None,
 recipient: None,
 domain: None,
 locked: None,
 lock_time: None,
 assigned: None,
 queued: None,
 mx_hostname: None,
        }
    }
}

/// Converts the MailLogEntry value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for MailLogEntry {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![

            Some("_id".to_string()),
            Some(self._id.to_string()),


            Some("id".to_string()),
            Some(self.id.to_string()),


            Some("from".to_string()),
            Some(self.from.to_string()),


            Some("to".to_string()),
            Some(self.to.to_string()),


            Some("created".to_string()),
            Some(self.created.to_string()),


            Some("time".to_string()),
            Some(self.time.to_string()),


            Some("user".to_string()),
            Some(self.user.to_string()),


            Some("transtype".to_string()),
            Some(self.transtype.to_string()),


            Some("origin".to_string()),
            Some(self.origin.to_string()),


            Some("interface".to_string()),
            Some(self.interface.to_string()),


            self.subject.as_ref().map(|subject| {
                [
                    "subject".to_string(),
                    subject.as_ref().map_or("null".to_string(), |x| x.to_string()),
                ].join(",")
            }),


            self.message_id.as_ref().map(|message_id| {
                [
                    "messageId".to_string(),
                    message_id.as_ref().map_or("null".to_string(), |x| x.to_string()),
                ].join(",")
            }),


            self.sending_zone.as_ref().map(|sending_zone| {
                [
                    "sendingZone".to_string(),
                    sending_zone.as_ref().map_or("null".to_string(), |x| x.to_string()),
                ].join(",")
            }),


            self.body_size.as_ref().map(|body_size| {
                [
                    "bodySize".to_string(),
                    body_size.as_ref().map_or("null".to_string(), |x| x.to_string()),
                ].join(",")
            }),


            self.seq.as_ref().map(|seq| {
                [
                    "seq".to_string(),
                    seq.as_ref().map_or("null".to_string(), |x| x.to_string()),
                ].join(",")
            }),


            self.delivered.as_ref().map(|delivered| {
                [
                    "delivered".to_string(),
                    delivered.as_ref().map_or("null".to_string(), |x| x.to_string()),
                ].join(",")
            }),


            self.code.as_ref().map(|code| {
                [
                    "code".to_string(),
                    code.as_ref().map_or("null".to_string(), |x| x.to_string()),
                ].join(",")
            }),


            self.response.as_ref().map(|response| {
                [
                    "response".to_string(),
                    response.as_ref().map_or("null".to_string(), |x| x.to_string()),
                ].join(",")
            }),


            self.recipient.as_ref().map(|recipient| {
                [
                    "recipient".to_string(),
                    recipient.as_ref().map_or("null".to_string(), |x| x.to_string()),
                ].join(",")
            }),


            self.domain.as_ref().map(|domain| {
                [
                    "domain".to_string(),
                    domain.as_ref().map_or("null".to_string(), |x| x.to_string()),
                ].join(",")
            }),


            self.locked.as_ref().map(|locked| {
                [
                    "locked".to_string(),
                    locked.as_ref().map_or("null".to_string(), |x| x.to_string()),
                ].join(",")
            }),


            self.lock_time.as_ref().map(|lock_time| {
                [
                    "lockTime".to_string(),
                    lock_time.as_ref().map_or("null".to_string(), |x| x.to_string()),
                ].join(",")
            }),


            self.assigned.as_ref().map(|assigned| {
                [
                    "assigned".to_string(),
                    assigned.as_ref().map_or("null".to_string(), |x| x.to_string()),
                ].join(",")
            }),


            self.queued.as_ref().map(|queued| {
                [
                    "queued".to_string(),
                    queued.as_ref().map_or("null".to_string(), |x| x.to_string()),
                ].join(",")
            }),


            self.mx_hostname.as_ref().map(|mx_hostname| {
                [
                    "mxHostname".to_string(),
                    mx_hostname.as_ref().map_or("null".to_string(), |x| x.to_string()),
                ].join(",")
            }),

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a MailLogEntry value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for MailLogEntry {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub _id: Vec<i32>,
            pub id: Vec<String>,
            pub from: Vec<String>,
            pub to: Vec<String>,
            pub created: Vec<String>,
            pub time: Vec<i32>,
            pub user: Vec<String>,
            pub transtype: Vec<String>,
            pub origin: Vec<String>,
            pub interface: Vec<String>,
            pub subject: Vec<String>,
            pub message_id: Vec<String>,
            pub sending_zone: Vec<String>,
            pub body_size: Vec<i32>,
            pub seq: Vec<i32>,
            pub delivered: Vec<i32>,
            pub code: Vec<i32>,
            pub response: Vec<String>,
            pub recipient: Vec<String>,
            pub domain: Vec<String>,
            pub locked: Vec<i32>,
            pub lock_time: Vec<String>,
            pub assigned: Vec<String>,
            pub queued: Vec<String>,
            pub mx_hostname: Vec<String>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing MailLogEntry".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    #[allow(clippy::redundant_clone)]
                    "_id" => intermediate_rep._id.push(<i32 as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "id" => intermediate_rep.id.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "from" => intermediate_rep.from.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "to" => intermediate_rep.to.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "created" => intermediate_rep.created.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "time" => intermediate_rep.time.push(<i32 as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "user" => intermediate_rep.user.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "transtype" => intermediate_rep.transtype.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "origin" => intermediate_rep.origin.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "interface" => intermediate_rep.interface.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    "subject" => return std::result::Result::Err("Parsing a nullable type in this style is not supported in MailLogEntry".to_string()),
                    "messageId" => return std::result::Result::Err("Parsing a nullable type in this style is not supported in MailLogEntry".to_string()),
                    "sendingZone" => return std::result::Result::Err("Parsing a nullable type in this style is not supported in MailLogEntry".to_string()),
                    "bodySize" => return std::result::Result::Err("Parsing a nullable type in this style is not supported in MailLogEntry".to_string()),
                    "seq" => return std::result::Result::Err("Parsing a nullable type in this style is not supported in MailLogEntry".to_string()),
                    "delivered" => return std::result::Result::Err("Parsing a nullable type in this style is not supported in MailLogEntry".to_string()),
                    "code" => return std::result::Result::Err("Parsing a nullable type in this style is not supported in MailLogEntry".to_string()),
                    "response" => return std::result::Result::Err("Parsing a nullable type in this style is not supported in MailLogEntry".to_string()),
                    "recipient" => return std::result::Result::Err("Parsing a nullable type in this style is not supported in MailLogEntry".to_string()),
                    "domain" => return std::result::Result::Err("Parsing a nullable type in this style is not supported in MailLogEntry".to_string()),
                    "locked" => return std::result::Result::Err("Parsing a nullable type in this style is not supported in MailLogEntry".to_string()),
                    "lockTime" => return std::result::Result::Err("Parsing a nullable type in this style is not supported in MailLogEntry".to_string()),
                    "assigned" => return std::result::Result::Err("Parsing a nullable type in this style is not supported in MailLogEntry".to_string()),
                    "queued" => return std::result::Result::Err("Parsing a nullable type in this style is not supported in MailLogEntry".to_string()),
                    "mxHostname" => return std::result::Result::Err("Parsing a nullable type in this style is not supported in MailLogEntry".to_string()),
                    _ => return std::result::Result::Err("Unexpected key while parsing MailLogEntry".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(MailLogEntry {
            _id: intermediate_rep._id.into_iter().next().ok_or_else(|| "_id missing in MailLogEntry".to_string())?,
            id: intermediate_rep.id.into_iter().next().ok_or_else(|| "id missing in MailLogEntry".to_string())?,
            from: intermediate_rep.from.into_iter().next().ok_or_else(|| "from missing in MailLogEntry".to_string())?,
            to: intermediate_rep.to.into_iter().next().ok_or_else(|| "to missing in MailLogEntry".to_string())?,
            created: intermediate_rep.created.into_iter().next().ok_or_else(|| "created missing in MailLogEntry".to_string())?,
            time: intermediate_rep.time.into_iter().next().ok_or_else(|| "time missing in MailLogEntry".to_string())?,
            user: intermediate_rep.user.into_iter().next().ok_or_else(|| "user missing in MailLogEntry".to_string())?,
            transtype: intermediate_rep.transtype.into_iter().next().ok_or_else(|| "transtype missing in MailLogEntry".to_string())?,
            origin: intermediate_rep.origin.into_iter().next().ok_or_else(|| "origin missing in MailLogEntry".to_string())?,
            interface: intermediate_rep.interface.into_iter().next().ok_or_else(|| "interface missing in MailLogEntry".to_string())?,
            subject: std::result::Result::Err("Nullable types not supported in MailLogEntry".to_string())?,
            message_id: std::result::Result::Err("Nullable types not supported in MailLogEntry".to_string())?,
            sending_zone: std::result::Result::Err("Nullable types not supported in MailLogEntry".to_string())?,
            body_size: std::result::Result::Err("Nullable types not supported in MailLogEntry".to_string())?,
            seq: std::result::Result::Err("Nullable types not supported in MailLogEntry".to_string())?,
            delivered: std::result::Result::Err("Nullable types not supported in MailLogEntry".to_string())?,
            code: std::result::Result::Err("Nullable types not supported in MailLogEntry".to_string())?,
            response: std::result::Result::Err("Nullable types not supported in MailLogEntry".to_string())?,
            recipient: std::result::Result::Err("Nullable types not supported in MailLogEntry".to_string())?,
            domain: std::result::Result::Err("Nullable types not supported in MailLogEntry".to_string())?,
            locked: std::result::Result::Err("Nullable types not supported in MailLogEntry".to_string())?,
            lock_time: std::result::Result::Err("Nullable types not supported in MailLogEntry".to_string())?,
            assigned: std::result::Result::Err("Nullable types not supported in MailLogEntry".to_string())?,
            queued: std::result::Result::Err("Nullable types not supported in MailLogEntry".to_string())?,
            mx_hostname: std::result::Result::Err("Nullable types not supported in MailLogEntry".to_string())?,
        })
    }
}

// Methods for converting between header::IntoHeaderValue<MailLogEntry> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<MailLogEntry>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailLogEntry>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for MailLogEntry - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<MailLogEntry> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailLogEntry as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into MailLogEntry - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The `id` is the numeric identifier used across most API calls.  The `username` is always `mb<id>` and is the SMTP AUTH username for `relay.mailbaby.net`.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailOrder {
    /// The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
    #[serde(rename = "id")]
    pub id: i32,

    /// The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
    /// Note: inline enums are not fully supported by openapi-generator
    #[serde(rename = "status")]
          #[validate(custom(function = "check_xss_string"))]
    pub status: String,

    /// The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
    #[serde(rename = "username")]
    #[validate(
            regex(path = *RE_MAILORDER_USERNAME),
          custom(function = "check_xss_string"),
    )]
    pub username: String,

    /// Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
    #[serde(rename = "comment")]
          #[validate(custom(function = "check_xss_string"))]
    #[serde(skip_serializing_if="Option::is_none")]
    pub comment: Option<String>,

}


lazy_static::lazy_static! {
    static ref RE_MAILORDER_USERNAME: regex::Regex = regex::Regex::new("^mb\\d+$").unwrap();
}

impl MailOrder {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new(id: i32, status: String, username: String, ) -> MailOrder {
        MailOrder {
 id,
 status,
 username,
 comment: None,
        }
    }
}

/// Converts the MailOrder value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for MailOrder {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![

            Some("id".to_string()),
            Some(self.id.to_string()),


            Some("status".to_string()),
            Some(self.status.to_string()),


            Some("username".to_string()),
            Some(self.username.to_string()),


            self.comment.as_ref().map(|comment| {
                [
                    "comment".to_string(),
                    comment.to_string(),
                ].join(",")
            }),

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a MailOrder value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for MailOrder {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub id: Vec<i32>,
            pub status: Vec<String>,
            pub username: Vec<String>,
            pub comment: Vec<String>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing MailOrder".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    #[allow(clippy::redundant_clone)]
                    "id" => intermediate_rep.id.push(<i32 as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "status" => intermediate_rep.status.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "username" => intermediate_rep.username.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "comment" => intermediate_rep.comment.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    _ => return std::result::Result::Err("Unexpected key while parsing MailOrder".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(MailOrder {
            id: intermediate_rep.id.into_iter().next().ok_or_else(|| "id missing in MailOrder".to_string())?,
            status: intermediate_rep.status.into_iter().next().ok_or_else(|| "status missing in MailOrder".to_string())?,
            username: intermediate_rep.username.into_iter().next().ok_or_else(|| "username missing in MailOrder".to_string())?,
            comment: intermediate_rep.comment.into_iter().next(),
        })
    }
}

// Methods for converting between header::IntoHeaderValue<MailOrder> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<MailOrder>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailOrder>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for MailOrder - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<MailOrder> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailOrder as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into MailOrder - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// Extended mail order record including the current SMTP password.  Returned by `GET /mail/{id}`.  The `username` and `password` fields can be used to authenticate directly against `relay.mailbaby.net:25` via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailOrderDetail {
    /// The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
    #[serde(rename = "id")]
    pub id: i32,

    /// The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
    /// Note: inline enums are not fully supported by openapi-generator
    #[serde(rename = "status")]
          #[validate(custom(function = "check_xss_string"))]
    pub status: String,

    /// The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
    #[serde(rename = "username")]
    #[validate(
            regex(path = *RE_MAILORDERDETAIL_USERNAME),
          custom(function = "check_xss_string"),
    )]
    pub username: String,

    /// The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.
    #[serde(rename = "password")]
          #[validate(custom(function = "check_xss_string"))]
    pub password: String,

    /// Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
    #[serde(rename = "comment")]
          #[validate(custom(function = "check_xss_string"))]
    #[serde(skip_serializing_if="Option::is_none")]
    pub comment: Option<String>,

}


lazy_static::lazy_static! {
    static ref RE_MAILORDERDETAIL_USERNAME: regex::Regex = regex::Regex::new("^mb\\d+$").unwrap();
}

impl MailOrderDetail {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new(id: i32, status: String, username: String, password: String, ) -> MailOrderDetail {
        MailOrderDetail {
 id,
 status,
 username,
 password,
 comment: None,
        }
    }
}

/// Converts the MailOrderDetail value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for MailOrderDetail {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![

            Some("id".to_string()),
            Some(self.id.to_string()),


            Some("status".to_string()),
            Some(self.status.to_string()),


            Some("username".to_string()),
            Some(self.username.to_string()),


            Some("password".to_string()),
            Some(self.password.to_string()),


            self.comment.as_ref().map(|comment| {
                [
                    "comment".to_string(),
                    comment.to_string(),
                ].join(",")
            }),

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a MailOrderDetail value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for MailOrderDetail {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub id: Vec<i32>,
            pub status: Vec<String>,
            pub username: Vec<String>,
            pub password: Vec<String>,
            pub comment: Vec<String>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing MailOrderDetail".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    #[allow(clippy::redundant_clone)]
                    "id" => intermediate_rep.id.push(<i32 as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "status" => intermediate_rep.status.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "username" => intermediate_rep.username.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "password" => intermediate_rep.password.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "comment" => intermediate_rep.comment.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    _ => return std::result::Result::Err("Unexpected key while parsing MailOrderDetail".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(MailOrderDetail {
            id: intermediate_rep.id.into_iter().next().ok_or_else(|| "id missing in MailOrderDetail".to_string())?,
            status: intermediate_rep.status.into_iter().next().ok_or_else(|| "status missing in MailOrderDetail".to_string())?,
            username: intermediate_rep.username.into_iter().next().ok_or_else(|| "username missing in MailOrderDetail".to_string())?,
            password: intermediate_rep.password.into_iter().next().ok_or_else(|| "password missing in MailOrderDetail".to_string())?,
            comment: intermediate_rep.comment.into_iter().next(),
        })
    }
}

// Methods for converting between header::IntoHeaderValue<MailOrderDetail> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<MailOrderDetail>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailOrderDetail>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for MailOrderDetail - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<MailOrderDetail> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailOrderDetail as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into MailOrderDetail - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailStatsType {
    /// The time window these `received`, `sent`, and `volume` statistics cover.
    /// Note: inline enums are not fully supported by openapi-generator
    #[serde(rename = "time")]
          #[validate(custom(function = "check_xss_string"))]
    #[serde(skip_serializing_if="Option::is_none")]
    pub time: Option<String>,

    /// Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
    #[serde(rename = "usage")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub usage: Option<i32>,

    /// The ISO 4217 currency code for this account (e.g. `USD`).
    #[serde(rename = "currency")]
          #[validate(custom(function = "check_xss_string"))]
    #[serde(skip_serializing_if="Option::is_none")]
    pub currency: Option<String>,

    /// Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
    #[serde(rename = "cost")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub cost: Option<f64>,

    /// Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
    #[serde(rename = "received")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub received: Option<i32>,

    /// Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
    #[serde(rename = "sent")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub sent: Option<i32>,

    #[serde(rename = "volume")]
          #[validate(nested)]
    #[serde(skip_serializing_if="Option::is_none")]
    pub volume: Option<models::MailStatsVolume>,

}



impl MailStatsType {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new() -> MailStatsType {
        MailStatsType {
 time: None,
 usage: None,
 currency: None,
 cost: None,
 received: None,
 sent: None,
 volume: None,
        }
    }
}

/// Converts the MailStatsType value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for MailStatsType {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![

            self.time.as_ref().map(|time| {
                [
                    "time".to_string(),
                    time.to_string(),
                ].join(",")
            }),


            self.usage.as_ref().map(|usage| {
                [
                    "usage".to_string(),
                    usage.to_string(),
                ].join(",")
            }),


            self.currency.as_ref().map(|currency| {
                [
                    "currency".to_string(),
                    currency.to_string(),
                ].join(",")
            }),


            self.cost.as_ref().map(|cost| {
                [
                    "cost".to_string(),
                    cost.to_string(),
                ].join(",")
            }),


            self.received.as_ref().map(|received| {
                [
                    "received".to_string(),
                    received.to_string(),
                ].join(",")
            }),


            self.sent.as_ref().map(|sent| {
                [
                    "sent".to_string(),
                    sent.to_string(),
                ].join(",")
            }),

            // Skipping volume in query parameter serialization

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a MailStatsType value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for MailStatsType {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub time: Vec<String>,
            pub usage: Vec<i32>,
            pub currency: Vec<String>,
            pub cost: Vec<f64>,
            pub received: Vec<i32>,
            pub sent: Vec<i32>,
            pub volume: Vec<models::MailStatsVolume>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing MailStatsType".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    #[allow(clippy::redundant_clone)]
                    "time" => intermediate_rep.time.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "usage" => intermediate_rep.usage.push(<i32 as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "currency" => intermediate_rep.currency.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "cost" => intermediate_rep.cost.push(<f64 as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "received" => intermediate_rep.received.push(<i32 as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "sent" => intermediate_rep.sent.push(<i32 as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "volume" => intermediate_rep.volume.push(<models::MailStatsVolume as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    _ => return std::result::Result::Err("Unexpected key while parsing MailStatsType".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(MailStatsType {
            time: intermediate_rep.time.into_iter().next(),
            usage: intermediate_rep.usage.into_iter().next(),
            currency: intermediate_rep.currency.into_iter().next(),
            cost: intermediate_rep.cost.into_iter().next(),
            received: intermediate_rep.received.into_iter().next(),
            sent: intermediate_rep.sent.into_iter().next(),
            volume: intermediate_rep.volume.into_iter().next(),
        })
    }
}

// Methods for converting between header::IntoHeaderValue<MailStatsType> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<MailStatsType>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailStatsType>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for MailStatsType - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<MailStatsType> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailStatsType as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into MailStatsType - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailStatsVolume {
    /// Message counts keyed by destination (envelope `to`) email address.
    #[serde(rename = "to")]
          #[validate(custom(function = "check_xss_map"))]
    #[serde(skip_serializing_if="Option::is_none")]
    pub to: Option<std::collections::HashMap<String, i32>>,

    /// Message counts keyed by sender (envelope `from`) email address.
    #[serde(rename = "from")]
          #[validate(custom(function = "check_xss_map"))]
    #[serde(skip_serializing_if="Option::is_none")]
    pub from: Option<std::collections::HashMap<String, i32>>,

    /// Message counts keyed by originating client IP address.
    #[serde(rename = "ip")]
          #[validate(custom(function = "check_xss_map"))]
    #[serde(skip_serializing_if="Option::is_none")]
    pub ip: Option<std::collections::HashMap<String, i32>>,

}



impl MailStatsVolume {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new() -> MailStatsVolume {
        MailStatsVolume {
 to: None,
 from: None,
 ip: None,
        }
    }
}

/// Converts the MailStatsVolume value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for MailStatsVolume {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![
            // Skipping to in query parameter serialization
            // Skipping to in query parameter serialization

            // Skipping from in query parameter serialization
            // Skipping from in query parameter serialization

            // Skipping ip in query parameter serialization
            // Skipping ip in query parameter serialization

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a MailStatsVolume value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for MailStatsVolume {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub to: Vec<std::collections::HashMap<String, i32>>,
            pub from: Vec<std::collections::HashMap<String, i32>>,
            pub ip: Vec<std::collections::HashMap<String, i32>>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing MailStatsVolume".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    "to" => return std::result::Result::Err("Parsing a container in this style is not supported in MailStatsVolume".to_string()),
                    "from" => return std::result::Result::Err("Parsing a container in this style is not supported in MailStatsVolume".to_string()),
                    "ip" => return std::result::Result::Err("Parsing a container in this style is not supported in MailStatsVolume".to_string()),
                    _ => return std::result::Result::Err("Unexpected key while parsing MailStatsVolume".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(MailStatsVolume {
            to: intermediate_rep.to.into_iter().next(),
            from: intermediate_rep.from.into_iter().next(),
            ip: intermediate_rep.ip.into_iter().next(),
        })
    }
}

// Methods for converting between header::IntoHeaderValue<MailStatsVolume> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<MailStatsVolume>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailStatsVolume>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for MailStatsVolume - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<MailStatsVolume> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailStatsVolume as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into MailStatsVolume - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// Request body for `POST /mail/send`.  Sends a simple single-recipient message. HTML detection is automatic — if `body` contains HTML tags the message is sent as `text/html`; otherwise as `text/plain`.  The `from` address is automatically set as both the `From` and `Reply-To` headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use `POST /mail/advsend` instead.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct SendMail {
    #[serde(rename = "to")]
          #[validate(nested)]
    pub to: models::SendMailTo,

    /// The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.
    #[serde(rename = "from")]
          #[validate(custom(function = "check_xss_string"))]
    pub from: String,

    /// The subject line of the email.
    #[serde(rename = "subject")]
          #[validate(custom(function = "check_xss_string"))]
    pub subject: String,

    /// The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
    #[serde(rename = "body")]
          #[validate(custom(function = "check_xss_string"))]
    pub body: String,

    /// Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
    #[serde(rename = "id")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub id: Option<i64>,

}



impl SendMail {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new(to: models::SendMailTo, from: String, subject: String, body: String, ) -> SendMail {
        SendMail {
 to,
 from,
 subject,
 body,
 id: None,
        }
    }
}

/// Converts the SendMail value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for SendMail {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![
            // Skipping to in query parameter serialization


            Some("from".to_string()),
            Some(self.from.to_string()),


            Some("subject".to_string()),
            Some(self.subject.to_string()),


            Some("body".to_string()),
            Some(self.body.to_string()),


            self.id.as_ref().map(|id| {
                [
                    "id".to_string(),
                    id.to_string(),
                ].join(",")
            }),

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a SendMail value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for SendMail {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub to: Vec<models::SendMailTo>,
            pub from: Vec<String>,
            pub subject: Vec<String>,
            pub body: Vec<String>,
            pub id: Vec<i64>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing SendMail".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    #[allow(clippy::redundant_clone)]
                    "to" => intermediate_rep.to.push(<models::SendMailTo as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "from" => intermediate_rep.from.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "subject" => intermediate_rep.subject.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "body" => intermediate_rep.body.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "id" => intermediate_rep.id.push(<i64 as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    _ => return std::result::Result::Err("Unexpected key while parsing SendMail".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(SendMail {
            to: intermediate_rep.to.into_iter().next().ok_or_else(|| "to missing in SendMail".to_string())?,
            from: intermediate_rep.from.into_iter().next().ok_or_else(|| "from missing in SendMail".to_string())?,
            subject: intermediate_rep.subject.into_iter().next().ok_or_else(|| "subject missing in SendMail".to_string())?,
            body: intermediate_rep.body.into_iter().next().ok_or_else(|| "body missing in SendMail".to_string())?,
            id: intermediate_rep.id.into_iter().next(),
        })
    }
}

// Methods for converting between header::IntoHeaderValue<SendMail> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<SendMail>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<SendMail>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for SendMail - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<SendMail> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <SendMail as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into SendMail - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct SendMailAdv {
    /// The subject line of the email.
    #[serde(rename = "subject")]
          #[validate(custom(function = "check_xss_string"))]
    pub subject: String,

    /// The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
    #[serde(rename = "body")]
          #[validate(custom(function = "check_xss_string"))]
    pub body: String,

    /// The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.
    #[serde(rename = "from")]
          #[validate(nested)]
    pub from: models::EmailAddressTypes,

    /// One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
    #[serde(rename = "to")]
          #[validate(nested)]
    pub to: models::EmailAddressesTypes,

    /// Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.
    #[serde(rename = "replyto")]
          #[validate(nested)]
    #[serde(skip_serializing_if="Option::is_none")]
    pub replyto: Option<models::EmailAddressesTypes>,

    /// Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.
    #[serde(rename = "cc")]
          #[validate(nested)]
    #[serde(skip_serializing_if="Option::is_none")]
    pub cc: Option<models::EmailAddressesTypes>,

    /// Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
    #[serde(rename = "bcc")]
          #[validate(nested)]
    #[serde(skip_serializing_if="Option::is_none")]
    pub bcc: Option<models::EmailAddressesTypes>,

    /// Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
    #[serde(rename = "attachments")]
          #[validate(nested)]
    #[serde(skip_serializing_if="Option::is_none")]
    pub attachments: Option<Vec<models::MailAttachment>>,

    /// Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
    #[serde(rename = "id")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub id: Option<i64>,

}



impl SendMailAdv {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new(subject: String, body: String, from: models::EmailAddressTypes, to: models::EmailAddressesTypes, ) -> SendMailAdv {
        SendMailAdv {
 subject,
 body,
 from,
 to,
 replyto: None,
 cc: None,
 bcc: None,
 attachments: None,
 id: None,
        }
    }
}

/// Converts the SendMailAdv value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for SendMailAdv {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![

            Some("subject".to_string()),
            Some(self.subject.to_string()),


            Some("body".to_string()),
            Some(self.body.to_string()),

            // Skipping from in query parameter serialization

            // Skipping to in query parameter serialization

            // Skipping replyto in query parameter serialization

            // Skipping cc in query parameter serialization

            // Skipping bcc in query parameter serialization

            // Skipping attachments in query parameter serialization


            self.id.as_ref().map(|id| {
                [
                    "id".to_string(),
                    id.to_string(),
                ].join(",")
            }),

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a SendMailAdv value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for SendMailAdv {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub subject: Vec<String>,
            pub body: Vec<String>,
            pub from: Vec<models::EmailAddressTypes>,
            pub to: Vec<models::EmailAddressesTypes>,
            pub replyto: Vec<models::EmailAddressesTypes>,
            pub cc: Vec<models::EmailAddressesTypes>,
            pub bcc: Vec<models::EmailAddressesTypes>,
            pub attachments: Vec<Vec<models::MailAttachment>>,
            pub id: Vec<i64>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing SendMailAdv".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    #[allow(clippy::redundant_clone)]
                    "subject" => intermediate_rep.subject.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "body" => intermediate_rep.body.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "from" => intermediate_rep.from.push(<models::EmailAddressTypes as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "to" => intermediate_rep.to.push(<models::EmailAddressesTypes as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "replyto" => intermediate_rep.replyto.push(<models::EmailAddressesTypes as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "cc" => intermediate_rep.cc.push(<models::EmailAddressesTypes as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "bcc" => intermediate_rep.bcc.push(<models::EmailAddressesTypes as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    "attachments" => return std::result::Result::Err("Parsing a container in this style is not supported in SendMailAdv".to_string()),
                    #[allow(clippy::redundant_clone)]
                    "id" => intermediate_rep.id.push(<i64 as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    _ => return std::result::Result::Err("Unexpected key while parsing SendMailAdv".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(SendMailAdv {
            subject: intermediate_rep.subject.into_iter().next().ok_or_else(|| "subject missing in SendMailAdv".to_string())?,
            body: intermediate_rep.body.into_iter().next().ok_or_else(|| "body missing in SendMailAdv".to_string())?,
            from: intermediate_rep.from.into_iter().next().ok_or_else(|| "from missing in SendMailAdv".to_string())?,
            to: intermediate_rep.to.into_iter().next().ok_or_else(|| "to missing in SendMailAdv".to_string())?,
            replyto: intermediate_rep.replyto.into_iter().next(),
            cc: intermediate_rep.cc.into_iter().next(),
            bcc: intermediate_rep.bcc.into_iter().next(),
            attachments: intermediate_rep.attachments.into_iter().next(),
            id: intermediate_rep.id.into_iter().next(),
        })
    }
}

// Methods for converting between header::IntoHeaderValue<SendMailAdv> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<SendMailAdv>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<SendMailAdv>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for SendMailAdv - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<SendMailAdv> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <SendMailAdv as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into SendMailAdv - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// Request body for `POST /mail/rawsend`.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing `DKIM-Signature` header intact.  The `From`, `To`, `Cc`, and `Bcc` addresses are extracted from the message headers automatically — you do not need to specify them separately.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize, validator::Validate)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct SendMailRaw {
    /// The complete RFC 822 email message including all headers and the body. Must include at minimum `From`, `To`, `Subject`, `Date`, and `MIME-Version` headers.  DKIM signatures in the `DKIM-Signature` header are transmitted verbatim and will pass verification at the destination.
    #[serde(rename = "raw_email")]
          #[validate(custom(function = "check_xss_string"))]
    pub raw_email: String,

    /// Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by `GET /mail`.
    #[serde(rename = "id")]
    #[serde(skip_serializing_if="Option::is_none")]
    pub id: Option<i64>,

}



impl SendMailRaw {
    #[allow(clippy::new_without_default, clippy::too_many_arguments)]
    pub fn new(raw_email: String, ) -> SendMailRaw {
        SendMailRaw {
 raw_email,
 id: None,
        }
    }
}

/// Converts the SendMailRaw value to the Query Parameters representation (style=form, explode=false)
/// specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde serializer
impl std::fmt::Display for SendMailRaw {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![

            Some("raw_email".to_string()),
            Some(self.raw_email.to_string()),


            self.id.as_ref().map(|id| {
                [
                    "id".to_string(),
                    id.to_string(),
                ].join(",")
            }),

        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a SendMailRaw value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for SendMailRaw {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub raw_email: Vec<String>,
            pub id: Vec<i64>,
        }

        let mut intermediate_rep = IntermediateRep::default();

        // Parse into intermediate representation
        let mut string_iter = s.split(',');
        let mut key_result = string_iter.next();

        while key_result.is_some() {
            let val = match string_iter.next() {
                Some(x) => x,
                None => return std::result::Result::Err("Missing value while parsing SendMailRaw".to_string())
            };

            if let Some(key) = key_result {
                #[allow(clippy::match_single_binding)]
                match key {
                    #[allow(clippy::redundant_clone)]
                    "raw_email" => intermediate_rep.raw_email.push(<String as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    #[allow(clippy::redundant_clone)]
                    "id" => intermediate_rep.id.push(<i64 as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
                    _ => return std::result::Result::Err("Unexpected key while parsing SendMailRaw".to_string())
                }
            }

            // Get the next key
            key_result = string_iter.next();
        }

        // Use the intermediate representation to return the struct
        std::result::Result::Ok(SendMailRaw {
            raw_email: intermediate_rep.raw_email.into_iter().next().ok_or_else(|| "raw_email missing in SendMailRaw".to_string())?,
            id: intermediate_rep.id.into_iter().next(),
        })
    }
}

// Methods for converting between header::IntoHeaderValue<SendMailRaw> and HeaderValue

#[cfg(feature = "server")]
impl std::convert::TryFrom<header::IntoHeaderValue<SendMailRaw>> for HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<SendMailRaw>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Invalid header value for SendMailRaw - value: {hdr_value} is invalid {e}"#))
        }
    }
}

#[cfg(feature = "server")]
impl std::convert::TryFrom<HeaderValue> for header::IntoHeaderValue<SendMailRaw> {
    type Error = String;

    fn try_from(hdr_value: HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <SendMailRaw as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(format!(r#"Unable to convert header value '{value}' into SendMailRaw - {err}"#))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(format!(r#"Unable to convert header: {hdr_value:?} to string: {e}"#))
        }
    }
}



/// The primary recipient address for a simple send request. Accepts a single email address string or an array of email address strings for multiple recipients.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize)]
#[serde(untagged)]
#[allow(non_camel_case_types, clippy::large_enum_variant)]
pub enum SendMailTo {
    String(String),
    VecOfString(Vec<String>),
}

impl validator::Validate for SendMailTo
{
    fn validate(&self) -> std::result::Result<(), validator::ValidationErrors> {
        match self {
            Self::String(_) => std::result::Result::Ok(()),
            Self::VecOfString(_) => std::result::Result::Ok(()),
        }
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a SendMailTo value
/// as specified in https://swagger.io/docs/specification/serialization/
/// Should be implemented in a serde deserializer
impl std::str::FromStr for SendMailTo {
    type Err = serde_json::Error;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        serde_json::from_str(s)
    }
}


impl From<String> for SendMailTo {
    fn from(value: String) -> Self {
        Self::String(value)
    }
}
impl From<Vec<String>> for SendMailTo {
    fn from(value: Vec<String>) -> Self {
        Self::VecOfString(value)
    }
}




