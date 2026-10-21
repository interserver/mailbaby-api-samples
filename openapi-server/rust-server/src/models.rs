#![allow(unused_qualifications)]
#[cfg(not(feature = "validate"))]
use validator::Validate;

use crate::models;
#[cfg(any(feature = "client", feature = "server"))]
use crate::header;
#[cfg(feature = "validate")]
use serde_valid::Validate;

/// A date/time value accepted as either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` (e.g. `2024-01-15`, `last monday`).
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "validate", derive(Validate))]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct DateOrTimestamp(
    swagger::OneOf2<i64,String>
);

impl std::convert::From<swagger::OneOf2<i64,String>> for DateOrTimestamp {
    fn from(x: swagger::OneOf2<i64,String>) -> Self {
        DateOrTimestamp(x)
    }
}

impl std::convert::From<DateOrTimestamp> for swagger::OneOf2<i64,String> {
    fn from(x: DateOrTimestamp) -> Self {
        x.0
    }
}

impl std::ops::Deref for DateOrTimestamp {
    type Target = swagger::OneOf2<i64,String>;
    fn deref(&self) -> &swagger::OneOf2<i64,String> {
        &self.0
    }
}

impl std::ops::DerefMut for DateOrTimestamp {
    fn deref_mut(&mut self) -> &mut swagger::OneOf2<i64,String> {
        &mut self.0
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for DateOrTimestamp {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for DateOrTimestamp {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}
/// Converts the DateOrTimestamp value to the Query Parameters representation (style=form, explode=false)
/// specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde serializer
impl std::fmt::Display for DateOrTimestamp {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        // Display for this model is not supported
        write!(f, "")
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a DateOrTimestamp value
/// as specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde deserializer
impl ::std::str::FromStr for DateOrTimestamp {
    type Err = &'static str;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        std::result::Result::Err("Parsing DateOrTimestamp is not supported")
    }
}

// Methods for converting between header::IntoHeaderValue<DateOrTimestamp> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<DateOrTimestamp>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<DateOrTimestamp>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for DateOrTimestamp - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<DateOrTimestamp> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <DateOrTimestamp as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into DateOrTimestamp - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<DateOrTimestamp>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<DateOrTimestamp>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<DateOrTimestamp>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<DateOrTimestamp> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <DateOrTimestamp as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into DateOrTimestamp - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// Enumeration of values.
/// Since this enum's variants do not hold data, we can easily define them as `#[repr(C)]`
/// which helps with FFI.
#[allow(non_camel_case_types)]
#[repr(i32)]
#[derive(Debug, Clone, Copy, PartialEq, Eq, PartialOrd, Ord, serde_repr::Serialize_repr, serde_repr::Deserialize_repr, Hash)]
#[cfg_attr(feature = "validate", derive(Validate))]
#[cfg_attr(feature = "conversion", derive(frunk_enum_derive::LabelledGenericEnum))]
pub enum DeliveredStatus {
    NotDelivered = 0,
    Delivered = 1,
    UnknownDefaultOpenApi = 11184809,
}

impl std::fmt::Display for DeliveredStatus {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(f, "{}", *self as i32)
    }
}

impl std::str::FromStr for DeliveredStatus {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        match s.parse::<i32>() {
            std::result::Result::Ok(0) => std::result::Result::Ok(DeliveredStatus::NotDelivered),
            std::result::Result::Ok(1) => std::result::Result::Ok(DeliveredStatus::Delivered),
            std::result::Result::Ok(11184809) => std::result::Result::Ok(DeliveredStatus::UnknownDefaultOpenApi),
            _ => std::result::Result::Err(format!("Value not valid: {s}")),
        }
    }
}

// Methods for converting between header::IntoHeaderValue<DeliveredStatus> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<DeliveredStatus>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<DeliveredStatus>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for DeliveredStatus - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<DeliveredStatus> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <DeliveredStatus as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into DeliveredStatus - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<DeliveredStatus>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<DeliveredStatus>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<DeliveredStatus>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<DeliveredStatus> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <DeliveredStatus as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into DeliveredStatus - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// The fields required to create a new email deny rule via `POST /mail/rules`. The `type` controls what `data` is matched against: - `email` — exact sender address match - `domain` — all senders from a domain - `destination` — exact recipient address match - `startswith` — sender local-part prefix match (alphanumeric + `+_.-` only)
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct DenyRuleNew {
    #[serde(rename = "type")]

    #[cfg_attr(feature = "validate", validate)]
    pub r#type: models::DenyRuleNewType,

    /// The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
    #[serde(rename = "data")]

    pub data: String,

    /// Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
    #[serde(rename = "user")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub user: Option<String>,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for DenyRuleNew {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for DenyRuleNew {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}


impl DenyRuleNew {
    #[allow(clippy::new_without_default)]
    pub fn new(r#type: models::DenyRuleNewType, data: String, ) -> DenyRuleNew {
        DenyRuleNew {
            r#type,
            data,
            user: None,
        }
    }
}

/// Converts the DenyRuleNew value to the Query Parameters representation (style=form, explode=false)
/// specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde serializer
impl std::fmt::Display for DenyRuleNew {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![
            // Skipping non-primitive type type in query parameter serialization
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
/// as specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde deserializer
impl std::str::FromStr for DenyRuleNew {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub r#type: Vec<models::DenyRuleNewType>,
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
                    "type" => intermediate_rep.r#type.push(<models::DenyRuleNewType as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
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
            r#type: intermediate_rep.r#type.into_iter().next().ok_or_else(|| "type missing in DenyRuleNew".to_string())?,
            data: intermediate_rep.data.into_iter().next().ok_or_else(|| "data missing in DenyRuleNew".to_string())?,
            user: intermediate_rep.user.into_iter().next(),
        })
    }
}

// Methods for converting between header::IntoHeaderValue<DenyRuleNew> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<DenyRuleNew>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<DenyRuleNew>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for DenyRuleNew - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<DenyRuleNew> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <DenyRuleNew as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into DenyRuleNew - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<DenyRuleNew>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<DenyRuleNew>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<DenyRuleNew>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<DenyRuleNew> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <DenyRuleNew as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into DenyRuleNew - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
/// Enumeration of values.
/// Since this enum's variants do not hold data, we can easily define them as `#[repr(C)]`
/// which helps with FFI.
#[allow(non_camel_case_types)]
#[repr(C)]
#[derive(Debug, Clone, Copy, PartialEq, Eq, PartialOrd, Ord, serde::Serialize, serde::Deserialize, Hash)]
#[cfg_attr(feature = "validate", derive(Validate))]
#[cfg_attr(feature = "conversion", derive(frunk_enum_derive::LabelledGenericEnum))]
pub enum DenyRuleNewType {
    #[serde(rename = "domain")]
    Domain,
    #[serde(rename = "email")]
    Email,
    #[serde(rename = "startswith")]
    Startswith,
    #[serde(rename = "destination")]
    Destination,
    #[serde(rename = "11184809")]
    UnknownDefaultOpenApi,
}

impl std::fmt::Display for DenyRuleNewType {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match *self {
            DenyRuleNewType::Domain => write!(f, "domain"),
            DenyRuleNewType::Email => write!(f, "email"),
            DenyRuleNewType::Startswith => write!(f, "startswith"),
            DenyRuleNewType::Destination => write!(f, "destination"),
            DenyRuleNewType::UnknownDefaultOpenApi => write!(f, "11184809"),
        }
    }
}

impl std::str::FromStr for DenyRuleNewType {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        match s {
            "domain" => std::result::Result::Ok(DenyRuleNewType::Domain),
            "email" => std::result::Result::Ok(DenyRuleNewType::Email),
            "startswith" => std::result::Result::Ok(DenyRuleNewType::Startswith),
            "destination" => std::result::Result::Ok(DenyRuleNewType::Destination),
            "11184809" => std::result::Result::Ok(DenyRuleNewType::UnknownDefaultOpenApi),
            _ => std::result::Result::Err(format!("Value not valid: {s}")),
        }
    }
}

// Methods for converting between header::IntoHeaderValue<DenyRuleNewType> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<DenyRuleNewType>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<DenyRuleNewType>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for DenyRuleNewType - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<DenyRuleNewType> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <DenyRuleNewType as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into DenyRuleNewType - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<DenyRuleNewType>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<DenyRuleNewType>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<DenyRuleNewType>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<DenyRuleNewType> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <DenyRuleNewType as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into DenyRuleNewType - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// A complete deny rule record as returned by `GET /mail/rules`.  Combines the rule definition fields (`DenyRuleNew`) with server-assigned metadata (`id` and `created`).  The `id` value is required by `DELETE /mail/rules/{ruleId}`.
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct DenyRuleRecord {
    #[serde(rename = "type")]

    #[cfg_attr(feature = "validate", validate)]
    pub r#type: models::DenyRuleNewType,

    /// The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
    #[serde(rename = "data")]

    pub data: String,

    /// The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule.
    #[serde(rename = "id")]

    pub id: String,

    /// The timestamp when the rule was created.
    #[serde(rename = "created")]

    pub created: chrono::DateTime::<chrono::Utc>,

    /// Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
    #[serde(rename = "user")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub user: Option<String>,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for DenyRuleRecord {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for DenyRuleRecord {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}


impl DenyRuleRecord {
    #[allow(clippy::new_without_default)]
    pub fn new(r#type: models::DenyRuleNewType, data: String, id: String, created: chrono::DateTime::<chrono::Utc>, ) -> DenyRuleRecord {
        DenyRuleRecord {
            r#type,
            data,
            id,
            created,
            user: None,
        }
    }
}

/// Converts the DenyRuleRecord value to the Query Parameters representation (style=form, explode=false)
/// specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde serializer
impl std::fmt::Display for DenyRuleRecord {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![
            // Skipping non-primitive type type in query parameter serialization
            Some("data".to_string()),
            Some(self.data.to_string()),
            Some("id".to_string()),
            Some(self.id.to_string()),
            // Skipping non-primitive type created in query parameter serialization
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
/// as specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde deserializer
impl std::str::FromStr for DenyRuleRecord {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub r#type: Vec<models::DenyRuleNewType>,
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
                    "type" => intermediate_rep.r#type.push(<models::DenyRuleNewType as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
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
            r#type: intermediate_rep.r#type.into_iter().next().ok_or_else(|| "type missing in DenyRuleRecord".to_string())?,
            data: intermediate_rep.data.into_iter().next().ok_or_else(|| "data missing in DenyRuleRecord".to_string())?,
            id: intermediate_rep.id.into_iter().next().ok_or_else(|| "id missing in DenyRuleRecord".to_string())?,
            created: intermediate_rep.created.into_iter().next().ok_or_else(|| "created missing in DenyRuleRecord".to_string())?,
            user: intermediate_rep.user.into_iter().next(),
        })
    }
}

// Methods for converting between header::IntoHeaderValue<DenyRuleRecord> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<DenyRuleRecord>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<DenyRuleRecord>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for DenyRuleRecord - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<DenyRuleRecord> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <DenyRuleRecord as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into DenyRuleRecord - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<DenyRuleRecord>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<DenyRuleRecord>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<DenyRuleRecord>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<DenyRuleRecord> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <DenyRuleRecord as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into DenyRuleRecord - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// An email contact with an optional display name.  Used in structured address fields (`from`, `to`, `cc`, `bcc`, `replyto`) in `SendMailAdv`.
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct EmailAddressName {
    /// The email address.
    #[serde(rename = "email")]

    pub email: String,

    /// Optional display name shown to recipients (e.g. in the `From:` header).
    #[serde(rename = "name")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub name: Option<String>,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for EmailAddressName {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for EmailAddressName {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}


impl EmailAddressName {
    #[allow(clippy::new_without_default)]
    pub fn new(email: String, ) -> EmailAddressName {
        EmailAddressName {
            email,
            name: None,
        }
    }
}

/// Converts the EmailAddressName value to the Query Parameters representation (style=form, explode=false)
/// specified in <https://swagger.io/docs/specification/serialization/>
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
/// as specified in <https://swagger.io/docs/specification/serialization/>
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

// Methods for converting between header::IntoHeaderValue<EmailAddressName> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<EmailAddressName>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<EmailAddressName>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for EmailAddressName - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<EmailAddressName> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <EmailAddressName as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into EmailAddressName - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<EmailAddressName>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<EmailAddressName>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<EmailAddressName>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<EmailAddressName> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <EmailAddressName as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into EmailAddressName - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// A single email address parameter used as the body of `POST /mail/blocks/delete`.
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct EmailAddressParam {
    /// The email address to delist from all block lists.
    #[serde(rename = "email")]

    pub email: String,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for EmailAddressParam {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for EmailAddressParam {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}


impl EmailAddressParam {
    #[allow(clippy::new_without_default)]
    pub fn new(email: String, ) -> EmailAddressParam {
        EmailAddressParam {
            email,
        }
    }
}

/// Converts the EmailAddressParam value to the Query Parameters representation (style=form, explode=false)
/// specified in <https://swagger.io/docs/specification/serialization/>
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
/// as specified in <https://swagger.io/docs/specification/serialization/>
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

// Methods for converting between header::IntoHeaderValue<EmailAddressParam> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<EmailAddressParam>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<EmailAddressParam>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for EmailAddressParam - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<EmailAddressParam> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <EmailAddressParam as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into EmailAddressParam - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<EmailAddressParam>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<EmailAddressParam>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<EmailAddressParam>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<EmailAddressParam> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <EmailAddressParam as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into EmailAddressParam - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (`\"Name <email>\"`), or a structured contact object.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "validate", derive(Validate))]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct EmailAddressTypes(
    swagger::OneOf2<String,models::EmailAddressName>
);

impl std::convert::From<swagger::OneOf2<String,models::EmailAddressName>> for EmailAddressTypes {
    fn from(x: swagger::OneOf2<String,models::EmailAddressName>) -> Self {
        EmailAddressTypes(x)
    }
}

impl std::convert::From<EmailAddressTypes> for swagger::OneOf2<String,models::EmailAddressName> {
    fn from(x: EmailAddressTypes) -> Self {
        x.0
    }
}

impl std::ops::Deref for EmailAddressTypes {
    type Target = swagger::OneOf2<String,models::EmailAddressName>;
    fn deref(&self) -> &swagger::OneOf2<String,models::EmailAddressName> {
        &self.0
    }
}

impl std::ops::DerefMut for EmailAddressTypes {
    fn deref_mut(&mut self) -> &mut swagger::OneOf2<String,models::EmailAddressName> {
        &mut self.0
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for EmailAddressTypes {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for EmailAddressTypes {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}
/// Converts the EmailAddressTypes value to the Query Parameters representation (style=form, explode=false)
/// specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde serializer
impl std::fmt::Display for EmailAddressTypes {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        // Display for this model is not supported
        write!(f, "")
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a EmailAddressTypes value
/// as specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde deserializer
impl ::std::str::FromStr for EmailAddressTypes {
    type Err = &'static str;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        std::result::Result::Err("Parsing EmailAddressTypes is not supported")
    }
}

// Methods for converting between header::IntoHeaderValue<EmailAddressTypes> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<EmailAddressTypes>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<EmailAddressTypes>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for EmailAddressTypes - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<EmailAddressTypes> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <EmailAddressTypes as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into EmailAddressTypes - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<EmailAddressTypes>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<EmailAddressTypes>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<EmailAddressTypes>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<EmailAddressTypes> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <EmailAddressTypes as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into EmailAddressTypes - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// A flexible email address list that accepts either a plain RFC 822 string or a structured array of contact objects.  When a string is provided it is parsed as a comma-separated list of RFC 822 addresses (supporting the `\"Name <email>\"` and bare `email` formats).  When an array is provided each entry must have at least an `email` field with an optional `name` field.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "validate", derive(Validate))]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct EmailAddressesTypes(
    swagger::OneOf2<String,models::EmailAddressNames>
);

impl std::convert::From<swagger::OneOf2<String,models::EmailAddressNames>> for EmailAddressesTypes {
    fn from(x: swagger::OneOf2<String,models::EmailAddressNames>) -> Self {
        EmailAddressesTypes(x)
    }
}

impl std::convert::From<EmailAddressesTypes> for swagger::OneOf2<String,models::EmailAddressNames> {
    fn from(x: EmailAddressesTypes) -> Self {
        x.0
    }
}

impl std::ops::Deref for EmailAddressesTypes {
    type Target = swagger::OneOf2<String,models::EmailAddressNames>;
    fn deref(&self) -> &swagger::OneOf2<String,models::EmailAddressNames> {
        &self.0
    }
}

impl std::ops::DerefMut for EmailAddressesTypes {
    fn deref_mut(&mut self) -> &mut swagger::OneOf2<String,models::EmailAddressNames> {
        &mut self.0
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for EmailAddressesTypes {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for EmailAddressesTypes {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}
/// Converts the EmailAddressesTypes value to the Query Parameters representation (style=form, explode=false)
/// specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde serializer
impl std::fmt::Display for EmailAddressesTypes {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        // Display for this model is not supported
        write!(f, "")
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a EmailAddressesTypes value
/// as specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde deserializer
impl ::std::str::FromStr for EmailAddressesTypes {
    type Err = &'static str;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        std::result::Result::Err("Parsing EmailAddressesTypes is not supported")
    }
}

// Methods for converting between header::IntoHeaderValue<EmailAddressesTypes> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<EmailAddressesTypes>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<EmailAddressesTypes>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for EmailAddressesTypes - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<EmailAddressesTypes> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <EmailAddressesTypes as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into EmailAddressesTypes - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<EmailAddressesTypes>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<EmailAddressesTypes>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<EmailAddressesTypes>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<EmailAddressesTypes> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <EmailAddressesTypes as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into EmailAddressesTypes - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// The response body returned when an error occurs.
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct ErrorMessage {
    /// The HTTP-style status code associated with the error.
    #[serde(rename = "code")]

    pub code: i32,

    /// A human-readable description of the error.
    #[serde(rename = "message")]

    pub message: String,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for ErrorMessage {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for ErrorMessage {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}


impl ErrorMessage {
    #[allow(clippy::new_without_default)]
    pub fn new(code: i32, message: String, ) -> ErrorMessage {
        ErrorMessage {
            code,
            message,
        }
    }
}

/// Converts the ErrorMessage value to the Query Parameters representation (style=form, explode=false)
/// specified in <https://swagger.io/docs/specification/serialization/>
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
/// as specified in <https://swagger.io/docs/specification/serialization/>
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

// Methods for converting between header::IntoHeaderValue<ErrorMessage> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<ErrorMessage>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<ErrorMessage>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for ErrorMessage - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<ErrorMessage> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <ErrorMessage as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into ErrorMessage - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<ErrorMessage>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<ErrorMessage>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<ErrorMessage>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<ErrorMessage> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <ErrorMessage as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into ErrorMessage - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// Standard success response returned by write operations (send, add rule, delete, etc.).  The `status` field is always `\"ok\"` on success.  The `text` field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record's ID; for delete calls it contains a confirmation string.
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct GenericResponse {
    /// Always `\"ok\"` on success.
    #[serde(rename = "status")]

    pub status: String,

    /// Operation-specific result string.  For send operations this is the relay transaction ID (e.g. `185caa69ff7000f47c`) which can be used as the `mailid` parameter in `GET /mail/log`.  For create operations this is the new record's numeric ID.  For delete operations this is a human-readable confirmation.
    #[serde(rename = "text")]

    pub text: String,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for GenericResponse {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for GenericResponse {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}


impl GenericResponse {
    #[allow(clippy::new_without_default)]
    pub fn new(status: String, text: String, ) -> GenericResponse {
        GenericResponse {
            status,
            text,
        }
    }
}

/// Converts the GenericResponse value to the Query Parameters representation (style=form, explode=false)
/// specified in <https://swagger.io/docs/specification/serialization/>
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
/// as specified in <https://swagger.io/docs/specification/serialization/>
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

// Methods for converting between header::IntoHeaderValue<GenericResponse> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<GenericResponse>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<GenericResponse>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for GenericResponse - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<GenericResponse> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <GenericResponse as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into GenericResponse - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<GenericResponse>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<GenericResponse>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<GenericResponse>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<GenericResponse> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <GenericResponse as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into GenericResponse - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// Enumeration of values.
/// Since this enum's variants do not hold data, we can easily define them as `#[repr(C)]`
/// which helps with FFI.
#[allow(non_camel_case_types)]
#[repr(C)]
#[derive(Debug, Clone, Copy, PartialEq, Eq, PartialOrd, Ord, serde::Serialize, serde::Deserialize, Hash)]
#[cfg_attr(feature = "validate", derive(Validate))]
#[cfg_attr(feature = "conversion", derive(frunk_enum_derive::LabelledGenericEnum))]
pub enum GetStatsTimeParameter {
    #[serde(rename = "all")]
    All,
    #[serde(rename = "billing")]
    Billing,
    #[serde(rename = "month")]
    Month,
    #[serde(rename = "7d")]
    SevenDays,
    #[serde(rename = "24h")]
    TwentyFourHours,
    #[serde(rename = "day")]
    Day,
    #[serde(rename = "1h")]
    OneHour,
    #[serde(rename = "11184809")]
    UnknownDefaultOpenApi,
}

impl std::fmt::Display for GetStatsTimeParameter {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match *self {
            GetStatsTimeParameter::All => write!(f, "all"),
            GetStatsTimeParameter::Billing => write!(f, "billing"),
            GetStatsTimeParameter::Month => write!(f, "month"),
            GetStatsTimeParameter::SevenDays => write!(f, "7d"),
            GetStatsTimeParameter::TwentyFourHours => write!(f, "24h"),
            GetStatsTimeParameter::Day => write!(f, "day"),
            GetStatsTimeParameter::OneHour => write!(f, "1h"),
            GetStatsTimeParameter::UnknownDefaultOpenApi => write!(f, "11184809"),
        }
    }
}

impl std::str::FromStr for GetStatsTimeParameter {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        match s {
            "all" => std::result::Result::Ok(GetStatsTimeParameter::All),
            "billing" => std::result::Result::Ok(GetStatsTimeParameter::Billing),
            "month" => std::result::Result::Ok(GetStatsTimeParameter::Month),
            "7d" => std::result::Result::Ok(GetStatsTimeParameter::SevenDays),
            "24h" => std::result::Result::Ok(GetStatsTimeParameter::TwentyFourHours),
            "day" => std::result::Result::Ok(GetStatsTimeParameter::Day),
            "1h" => std::result::Result::Ok(GetStatsTimeParameter::OneHour),
            "11184809" => std::result::Result::Ok(GetStatsTimeParameter::UnknownDefaultOpenApi),
            _ => std::result::Result::Err(format!("Value not valid: {s}")),
        }
    }
}

// Methods for converting between header::IntoHeaderValue<GetStatsTimeParameter> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<GetStatsTimeParameter>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<GetStatsTimeParameter>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for GetStatsTimeParameter - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<GetStatsTimeParameter> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <GetStatsTimeParameter as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into GetStatsTimeParameter - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<GetStatsTimeParameter>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<GetStatsTimeParameter>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<GetStatsTimeParameter>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<GetStatsTimeParameter> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <GetStatsTimeParameter as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into GetStatsTimeParameter - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailAttachment {
    /// The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).
    #[serde(rename = "filename")]

    pub filename: String,

    /// The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
    #[serde(rename = "data")]

    pub data: swagger::ByteArray,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for MailAttachment {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for MailAttachment {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}


impl MailAttachment {
    #[allow(clippy::new_without_default)]
    pub fn new(filename: String, data: swagger::ByteArray, ) -> MailAttachment {
        MailAttachment {
            filename,
            data,
        }
    }
}

/// Converts the MailAttachment value to the Query Parameters representation (style=form, explode=false)
/// specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde serializer
impl std::fmt::Display for MailAttachment {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![
            Some("filename".to_string()),
            Some(self.filename.to_string()),
            // Skipping byte array data in query parameter serialization
        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a MailAttachment value
/// as specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde deserializer
impl std::str::FromStr for MailAttachment {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub filename: Vec<String>,
            pub data: Vec<swagger::ByteArray>,
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

// Methods for converting between header::IntoHeaderValue<MailAttachment> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<MailAttachment>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailAttachment>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for MailAttachment - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<MailAttachment> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailAttachment as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into MailAttachment - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<MailAttachment>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<MailAttachment>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<MailAttachment>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<MailAttachment> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <MailAttachment as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into MailAttachment - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailBlockClickHouse {
    /// The date the block event was recorded.
    #[serde(rename = "date")]

    pub date: chrono::naive::NaiveDate,

    /// The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
    #[serde(rename = "from")]

    pub from: String,

    /// The `Subject` header of the blocked message.
    #[serde(rename = "subject")]

    pub subject: String,

    /// The serialized list of recipients of the blocked message.
    #[serde(rename = "to")]

    pub to: String,

    /// The `Message-ID` header of the blocked message, or `null` if not present.
    #[serde(rename = "messageId")]
    #[serde(deserialize_with = "swagger::nullable_format::deserialize_optional_nullable")]
    #[serde(default = "swagger::nullable_format::default_optional_nullable")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub message_id: Option<swagger::Nullable<String>>,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for MailBlockClickHouse {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for MailBlockClickHouse {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}


impl MailBlockClickHouse {
    #[allow(clippy::new_without_default)]
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
/// specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde serializer
impl std::fmt::Display for MailBlockClickHouse {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![
            // Skipping non-primitive type date in query parameter serialization
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
/// as specified in <https://swagger.io/docs/specification/serialization/>
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
            pub message_id: Vec<swagger::Nullable<String>>,
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

// Methods for converting between header::IntoHeaderValue<MailBlockClickHouse> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<MailBlockClickHouse>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailBlockClickHouse>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for MailBlockClickHouse - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<MailBlockClickHouse> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailBlockClickHouse as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into MailBlockClickHouse - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<MailBlockClickHouse>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<MailBlockClickHouse>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<MailBlockClickHouse>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<MailBlockClickHouse> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <MailBlockClickHouse as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into MailBlockClickHouse - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailBlockRspamd {
    /// The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender.
    #[serde(rename = "from")]

    pub from: String,

    /// The suspicious subject pattern that triggered the block.
    #[serde(rename = "subject")]

    pub subject: String,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for MailBlockRspamd {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for MailBlockRspamd {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}


impl MailBlockRspamd {
    #[allow(clippy::new_without_default)]
    pub fn new(from: String, subject: String, ) -> MailBlockRspamd {
        MailBlockRspamd {
            from,
            subject,
        }
    }
}

/// Converts the MailBlockRspamd value to the Query Parameters representation (style=form, explode=false)
/// specified in <https://swagger.io/docs/specification/serialization/>
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
/// as specified in <https://swagger.io/docs/specification/serialization/>
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

// Methods for converting between header::IntoHeaderValue<MailBlockRspamd> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<MailBlockRspamd>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailBlockRspamd>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for MailBlockRspamd - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<MailBlockRspamd> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailBlockRspamd as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into MailBlockRspamd - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<MailBlockRspamd>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<MailBlockRspamd>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<MailBlockRspamd>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<MailBlockRspamd> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <MailBlockRspamd as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into MailBlockRspamd - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// The complete set of blocked addresses and message patterns returned by `GET /mail/blocks`. Three independent block sources are combined into one response. Use `POST /mail/blocks/delete` with a `from` address from any entry to delist it.
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailBlocks {
    /// Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
    #[serde(rename = "local")]

    #[cfg_attr(feature = "validate", validate)]
    pub local: Vec<models::MailBlockClickHouse>,

    /// Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.
    #[serde(rename = "mbtrap")]

    #[cfg_attr(feature = "validate", validate)]
    pub mbtrap: Vec<models::MailBlockClickHouse>,

    /// Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.
    #[serde(rename = "subject")]

    #[cfg_attr(feature = "validate", validate)]
    pub subject: Vec<models::MailBlockRspamd>,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for MailBlocks {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for MailBlocks {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}


impl MailBlocks {
    #[allow(clippy::new_without_default)]
    pub fn new(local: Vec<models::MailBlockClickHouse>, mbtrap: Vec<models::MailBlockClickHouse>, subject: Vec<models::MailBlockRspamd>, ) -> MailBlocks {
        MailBlocks {
            local,
            mbtrap,
            subject,
        }
    }
}

/// Converts the MailBlocks value to the Query Parameters representation (style=form, explode=false)
/// specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde serializer
impl std::fmt::Display for MailBlocks {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![
            // Skipping non-primitive type local in query parameter serialization
            // Skipping non-primitive type mbtrap in query parameter serialization
            // Skipping non-primitive type subject in query parameter serialization
        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a MailBlocks value
/// as specified in <https://swagger.io/docs/specification/serialization/>
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

// Methods for converting between header::IntoHeaderValue<MailBlocks> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<MailBlocks>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailBlocks>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for MailBlocks - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<MailBlocks> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailBlocks as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into MailBlocks - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<MailBlocks>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<MailBlocks>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<MailBlocks>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<MailBlocks> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <MailBlocks as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into MailBlocks - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// Paginated mail log response returned by `GET /mail/log`.  Contains the full matched count (`total`) plus a page of `MailLogEntry` records.  Use `skip` and `limit` to page through large result sets.
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
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

    #[cfg_attr(feature = "validate", validate)]
    pub emails: Vec<models::MailLogEntry>,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for MailLog {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for MailLog {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}


impl MailLog {
    #[allow(clippy::new_without_default)]
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
/// specified in <https://swagger.io/docs/specification/serialization/>
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
            // Skipping non-primitive type emails in query parameter serialization
        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a MailLog value
/// as specified in <https://swagger.io/docs/specification/serialization/>
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

// Methods for converting between header::IntoHeaderValue<MailLog> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<MailLog>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailLog>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for MailLog - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<MailLog> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailLog as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into MailLog - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<MailLog>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<MailLog>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<MailLog>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<MailLog> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <MailLog as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into MailLog - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The `id` field matches the `mailid` query parameter on `GET /mail/log` and   the `text` field of a successful send response. - The `from` address can be passed to `POST /mail/blocks/delete` to delist a   flagged sender. - The `user` field is the SMTP username (e.g. `mb5658`) corresponding to the   `username` field in `GET /mail` / `GET /mail/{id}`.
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailLogEntry {
    /// Internal auto-increment database row ID.  Not meaningful outside the API.
    #[serde(rename = "_id")]

    pub _id: i32,

    /// The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.
    #[serde(rename = "id")]
    #[cfg_attr(not(feature = "validate"), validate(
            length(min = 18, max = 19),
        ))]
    #[cfg_attr(feature = "validate", validate(min_length = 18))]
    #[cfg_attr(feature = "validate", validate(max_length = 19))]

    pub id: String,

    /// SMTP envelope `MAIL FROM` address (may differ from the `From:` header).
    #[serde(rename = "from")]

    pub from: String,

    /// SMTP envelope `RCPT TO` address.
    #[serde(rename = "to")]

    pub to: String,

    /// Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.
    #[serde(rename = "created")]

    pub created: String,

    /// Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.
    #[serde(rename = "time")]

    pub time: i32,

    /// The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.
    #[serde(rename = "user")]

    pub user: String,

    /// SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).
    #[serde(rename = "transtype")]

    pub transtype: String,

    /// IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.
    #[serde(rename = "origin")]

    pub origin: String,

    /// Relay interface name that accepted the message (e.g. `feeder`).
    #[serde(rename = "interface")]

    pub interface: String,

    /// The `Subject` header value, if available.
    #[serde(rename = "subject")]
    #[serde(deserialize_with = "swagger::nullable_format::deserialize_optional_nullable")]
    #[serde(default = "swagger::nullable_format::default_optional_nullable")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub subject: Option<swagger::Nullable<String>>,

    /// The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.
    #[serde(rename = "messageId")]
    #[serde(deserialize_with = "swagger::nullable_format::deserialize_optional_nullable")]
    #[serde(default = "swagger::nullable_format::default_optional_nullable")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub message_id: Option<swagger::Nullable<String>>,

    /// The sending zone assigned by the relay for outbound delivery.
    #[serde(rename = "sendingZone")]
    #[serde(deserialize_with = "swagger::nullable_format::deserialize_optional_nullable")]
    #[serde(default = "swagger::nullable_format::default_optional_nullable")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub sending_zone: Option<swagger::Nullable<String>>,

    /// Size of the message body in bytes.
    #[serde(rename = "bodySize")]
    #[serde(deserialize_with = "swagger::nullable_format::deserialize_optional_nullable")]
    #[serde(default = "swagger::nullable_format::default_optional_nullable")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub body_size: Option<i32>,

    /// Sequence index of this recipient in a multi-recipient message. Starts at 1.
    #[serde(rename = "seq")]
    #[serde(deserialize_with = "swagger::nullable_format::deserialize_optional_nullable")]
    #[serde(default = "swagger::nullable_format::default_optional_nullable")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub seq: Option<i32>,

    /// Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.
    #[serde(rename = "delivered")]
    #[serde(deserialize_with = "swagger::nullable_format::deserialize_optional_nullable")]
    #[serde(default = "swagger::nullable_format::default_optional_nullable")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub delivered: Option<i32>,

    /// The SMTP response code from the destination MX server (e.g. `250` for success, `550` for permanent failure).
    #[serde(rename = "code")]
    #[serde(deserialize_with = "swagger::nullable_format::deserialize_optional_nullable")]
    #[serde(default = "swagger::nullable_format::default_optional_nullable")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub code: Option<i32>,

    /// The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).
    #[serde(rename = "response")]
    #[serde(deserialize_with = "swagger::nullable_format::deserialize_optional_nullable")]
    #[serde(default = "swagger::nullable_format::default_optional_nullable")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub response: Option<swagger::Nullable<String>>,

    /// The specific recipient address this delivery record is for.
    #[serde(rename = "recipient")]
    #[serde(deserialize_with = "swagger::nullable_format::deserialize_optional_nullable")]
    #[serde(default = "swagger::nullable_format::default_optional_nullable")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub recipient: Option<swagger::Nullable<String>>,

    /// The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.
    #[serde(rename = "domain")]
    #[serde(deserialize_with = "swagger::nullable_format::deserialize_optional_nullable")]
    #[serde(default = "swagger::nullable_format::default_optional_nullable")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub domain: Option<swagger::Nullable<String>>,

    /// Whether the queue entry is currently locked for delivery processing.
    #[serde(rename = "locked")]
    #[serde(deserialize_with = "swagger::nullable_format::deserialize_optional_nullable")]
    #[serde(default = "swagger::nullable_format::default_optional_nullable")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub locked: Option<i32>,

    /// Millisecond-precision timestamp of the last queue lock acquisition.
    #[serde(rename = "lockTime")]
    #[serde(deserialize_with = "swagger::nullable_format::deserialize_optional_nullable")]
    #[serde(default = "swagger::nullable_format::default_optional_nullable")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub lock_time: Option<swagger::Nullable<String>>,

    /// The relay server node assigned to deliver this message.
    #[serde(rename = "assigned")]
    #[serde(deserialize_with = "swagger::nullable_format::deserialize_optional_nullable")]
    #[serde(default = "swagger::nullable_format::default_optional_nullable")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub assigned: Option<swagger::Nullable<String>>,

    /// ISO 8601 timestamp when the message was placed into the delivery queue.
    #[serde(rename = "queued")]
    #[serde(deserialize_with = "swagger::nullable_format::deserialize_optional_nullable")]
    #[serde(default = "swagger::nullable_format::default_optional_nullable")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub queued: Option<swagger::Nullable<String>>,

    /// The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.
    #[serde(rename = "mxHostname")]
    #[serde(deserialize_with = "swagger::nullable_format::deserialize_optional_nullable")]
    #[serde(default = "swagger::nullable_format::default_optional_nullable")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub mx_hostname: Option<swagger::Nullable<String>>,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for MailLogEntry {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for MailLogEntry {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}


impl MailLogEntry {
    #[allow(clippy::new_without_default)]
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
/// specified in <https://swagger.io/docs/specification/serialization/>
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
/// as specified in <https://swagger.io/docs/specification/serialization/>
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
            pub subject: Vec<swagger::Nullable<String>>,
            pub message_id: Vec<swagger::Nullable<String>>,
            pub sending_zone: Vec<swagger::Nullable<String>>,
            pub body_size: Vec<i32>,
            pub seq: Vec<i32>,
            pub delivered: Vec<i32>,
            pub code: Vec<i32>,
            pub response: Vec<swagger::Nullable<String>>,
            pub recipient: Vec<swagger::Nullable<String>>,
            pub domain: Vec<swagger::Nullable<String>>,
            pub locked: Vec<i32>,
            pub lock_time: Vec<swagger::Nullable<String>>,
            pub assigned: Vec<swagger::Nullable<String>>,
            pub queued: Vec<swagger::Nullable<String>>,
            pub mx_hostname: Vec<swagger::Nullable<String>>,
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

// Methods for converting between header::IntoHeaderValue<MailLogEntry> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<MailLogEntry>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailLogEntry>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for MailLogEntry - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<MailLogEntry> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailLogEntry as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into MailLogEntry - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<MailLogEntry>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<MailLogEntry>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<MailLogEntry>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<MailLogEntry> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <MailLogEntry as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into MailLogEntry - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The `id` is the numeric identifier used across most API calls.  The `username` is always `mb<id>` and is the SMTP AUTH username for `relay.mailbaby.net`.
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailOrder {
    /// The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
    #[serde(rename = "id")]

    pub id: i32,

    #[serde(rename = "status")]

    #[cfg_attr(feature = "validate", validate)]
    pub status: models::MailOrderStatus,

    /// The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
    #[serde(rename = "username")]
    #[cfg_attr(not(feature = "validate"), validate(
           regex(path = *RE_MAILORDER_USERNAME),
        ))]
    #[cfg_attr(feature = "validate", validate(pattern = r"^mb\\d+$"))]

    pub username: String,

    /// Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
    #[serde(rename = "comment")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub comment: Option<String>,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for MailOrder {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for MailOrder {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}

lazy_static::lazy_static! {
    static ref RE_MAILORDER_USERNAME: regex::Regex = regex::Regex::new(r"^mb\\d+$").unwrap();
}

impl MailOrder {
    #[allow(clippy::new_without_default)]
    pub fn new(id: i32, status: models::MailOrderStatus, username: String, ) -> MailOrder {
        MailOrder {
            id,
            status,
            username,
            comment: None,
        }
    }
}

/// Converts the MailOrder value to the Query Parameters representation (style=form, explode=false)
/// specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde serializer
impl std::fmt::Display for MailOrder {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![
            Some("id".to_string()),
            Some(self.id.to_string()),
            // Skipping non-primitive type status in query parameter serialization
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
/// as specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde deserializer
impl std::str::FromStr for MailOrder {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub id: Vec<i32>,
            pub status: Vec<models::MailOrderStatus>,
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
                    "status" => intermediate_rep.status.push(<models::MailOrderStatus as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
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

// Methods for converting between header::IntoHeaderValue<MailOrder> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<MailOrder>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailOrder>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for MailOrder - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<MailOrder> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailOrder as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into MailOrder - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<MailOrder>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<MailOrder>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<MailOrder>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<MailOrder> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <MailOrder as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into MailOrder - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// Extended mail order record including the current SMTP password.  Returned by `GET /mail/{id}`.  The `username` and `password` fields can be used to authenticate directly against `relay.mailbaby.net:25` via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailOrderDetail {
    /// The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
    #[serde(rename = "id")]

    pub id: i32,

    #[serde(rename = "status")]

    #[cfg_attr(feature = "validate", validate)]
    pub status: models::MailOrderStatus,

    /// The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
    #[serde(rename = "username")]
    #[cfg_attr(not(feature = "validate"), validate(
           regex(path = *RE_MAILORDERDETAIL_USERNAME),
        ))]
    #[cfg_attr(feature = "validate", validate(pattern = r"^mb\\d+$"))]

    pub username: String,

    /// The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.
    #[serde(rename = "password")]

    pub password: String,

    /// Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
    #[serde(rename = "comment")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub comment: Option<String>,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for MailOrderDetail {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for MailOrderDetail {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}

lazy_static::lazy_static! {
    static ref RE_MAILORDERDETAIL_USERNAME: regex::Regex = regex::Regex::new(r"^mb\\d+$").unwrap();
}

impl MailOrderDetail {
    #[allow(clippy::new_without_default)]
    pub fn new(id: i32, status: models::MailOrderStatus, username: String, password: String, ) -> MailOrderDetail {
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
/// specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde serializer
impl std::fmt::Display for MailOrderDetail {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![
            Some("id".to_string()),
            Some(self.id.to_string()),
            // Skipping non-primitive type status in query parameter serialization
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
/// as specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde deserializer
impl std::str::FromStr for MailOrderDetail {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub id: Vec<i32>,
            pub status: Vec<models::MailOrderStatus>,
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
                    "status" => intermediate_rep.status.push(<models::MailOrderStatus as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
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

// Methods for converting between header::IntoHeaderValue<MailOrderDetail> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<MailOrderDetail>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailOrderDetail>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for MailOrderDetail - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<MailOrderDetail> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailOrderDetail as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into MailOrderDetail - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<MailOrderDetail>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<MailOrderDetail>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<MailOrderDetail>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<MailOrderDetail> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <MailOrderDetail as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into MailOrderDetail - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
/// Enumeration of values.
/// Since this enum's variants do not hold data, we can easily define them as `#[repr(C)]`
/// which helps with FFI.
#[allow(non_camel_case_types)]
#[repr(C)]
#[derive(Debug, Clone, Copy, PartialEq, Eq, PartialOrd, Ord, serde::Serialize, serde::Deserialize, Hash)]
#[cfg_attr(feature = "validate", derive(Validate))]
#[cfg_attr(feature = "conversion", derive(frunk_enum_derive::LabelledGenericEnum))]
pub enum MailOrderStatus {
    #[serde(rename = "active")]
    Active,
    #[serde(rename = "canceled")]
    Canceled,
    #[serde(rename = "11184809")]
    UnknownDefaultOpenApi,
}

impl std::fmt::Display for MailOrderStatus {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match *self {
            MailOrderStatus::Active => write!(f, "active"),
            MailOrderStatus::Canceled => write!(f, "canceled"),
            MailOrderStatus::UnknownDefaultOpenApi => write!(f, "11184809"),
        }
    }
}

impl std::str::FromStr for MailOrderStatus {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        match s {
            "active" => std::result::Result::Ok(MailOrderStatus::Active),
            "canceled" => std::result::Result::Ok(MailOrderStatus::Canceled),
            "11184809" => std::result::Result::Ok(MailOrderStatus::UnknownDefaultOpenApi),
            _ => std::result::Result::Err(format!("Value not valid: {s}")),
        }
    }
}

// Methods for converting between header::IntoHeaderValue<MailOrderStatus> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<MailOrderStatus>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailOrderStatus>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for MailOrderStatus - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<MailOrderStatus> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailOrderStatus as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into MailOrderStatus - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<MailOrderStatus>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<MailOrderStatus>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<MailOrderStatus>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<MailOrderStatus> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <MailOrderStatus as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into MailOrderStatus - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailStatsType {
    #[serde(rename = "time")]

    #[cfg_attr(feature = "validate", validate)]
    #[serde(skip_serializing_if="Option::is_none")]
    pub time: Option<models::MailStatsTypeTime>,

    /// Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
    #[serde(rename = "usage")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub usage: Option<i32>,

    /// The ISO 4217 currency code for this account (e.g. `USD`).
    #[serde(rename = "currency")]

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

    #[cfg_attr(feature = "validate", validate)]
    #[serde(skip_serializing_if="Option::is_none")]
    pub volume: Option<models::MailStatsVolume>,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for MailStatsType {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for MailStatsType {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}


impl MailStatsType {
    #[allow(clippy::new_without_default)]
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
/// specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde serializer
impl std::fmt::Display for MailStatsType {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![
            // Skipping non-primitive type time in query parameter serialization
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
            // Skipping non-primitive type volume in query parameter serialization
        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a MailStatsType value
/// as specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde deserializer
impl std::str::FromStr for MailStatsType {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        /// An intermediate representation of the struct to use for parsing.
        #[derive(Default)]
        #[allow(dead_code)]
        struct IntermediateRep {
            pub time: Vec<models::MailStatsTypeTime>,
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
                    "time" => intermediate_rep.time.push(<models::MailStatsTypeTime as std::str::FromStr>::from_str(val).map_err(|x| x.to_string())?),
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

// Methods for converting between header::IntoHeaderValue<MailStatsType> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<MailStatsType>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailStatsType>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for MailStatsType - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<MailStatsType> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailStatsType as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into MailStatsType - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<MailStatsType>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<MailStatsType>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<MailStatsType>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<MailStatsType> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <MailStatsType as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into MailStatsType - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// The time window these `received`, `sent`, and `volume` statistics cover.
/// Enumeration of values.
/// Since this enum's variants do not hold data, we can easily define them as `#[repr(C)]`
/// which helps with FFI.
#[allow(non_camel_case_types)]
#[repr(C)]
#[derive(Debug, Clone, Copy, PartialEq, Eq, PartialOrd, Ord, serde::Serialize, serde::Deserialize, Hash)]
#[cfg_attr(feature = "validate", derive(Validate))]
#[cfg_attr(feature = "conversion", derive(frunk_enum_derive::LabelledGenericEnum))]
pub enum MailStatsTypeTime {
    #[serde(rename = "all")]
    All,
    #[serde(rename = "billing")]
    Billing,
    #[serde(rename = "month")]
    Month,
    #[serde(rename = "7d")]
    SevenDays,
    #[serde(rename = "24h")]
    TwentyFourHours,
    #[serde(rename = "day")]
    Day,
    #[serde(rename = "1h")]
    OneHour,
    #[serde(rename = "11184809")]
    UnknownDefaultOpenApi,
}

impl std::fmt::Display for MailStatsTypeTime {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match *self {
            MailStatsTypeTime::All => write!(f, "all"),
            MailStatsTypeTime::Billing => write!(f, "billing"),
            MailStatsTypeTime::Month => write!(f, "month"),
            MailStatsTypeTime::SevenDays => write!(f, "7d"),
            MailStatsTypeTime::TwentyFourHours => write!(f, "24h"),
            MailStatsTypeTime::Day => write!(f, "day"),
            MailStatsTypeTime::OneHour => write!(f, "1h"),
            MailStatsTypeTime::UnknownDefaultOpenApi => write!(f, "11184809"),
        }
    }
}

impl std::str::FromStr for MailStatsTypeTime {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        match s {
            "all" => std::result::Result::Ok(MailStatsTypeTime::All),
            "billing" => std::result::Result::Ok(MailStatsTypeTime::Billing),
            "month" => std::result::Result::Ok(MailStatsTypeTime::Month),
            "7d" => std::result::Result::Ok(MailStatsTypeTime::SevenDays),
            "24h" => std::result::Result::Ok(MailStatsTypeTime::TwentyFourHours),
            "day" => std::result::Result::Ok(MailStatsTypeTime::Day),
            "1h" => std::result::Result::Ok(MailStatsTypeTime::OneHour),
            "11184809" => std::result::Result::Ok(MailStatsTypeTime::UnknownDefaultOpenApi),
            _ => std::result::Result::Err(format!("Value not valid: {s}")),
        }
    }
}

// Methods for converting between header::IntoHeaderValue<MailStatsTypeTime> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<MailStatsTypeTime>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailStatsTypeTime>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for MailStatsTypeTime - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<MailStatsTypeTime> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailStatsTypeTime as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into MailStatsTypeTime - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<MailStatsTypeTime>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<MailStatsTypeTime>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<MailStatsTypeTime>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<MailStatsTypeTime> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <MailStatsTypeTime as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into MailStatsTypeTime - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct MailStatsVolume {
    /// Message counts keyed by destination (envelope `to`) email address.
    #[serde(rename = "to")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub to: Option<std::collections::HashMap<String, i32>>,

    /// Message counts keyed by sender (envelope `from`) email address.
    #[serde(rename = "from")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub from: Option<std::collections::HashMap<String, i32>>,

    /// Message counts keyed by originating client IP address.
    #[serde(rename = "ip")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub ip: Option<std::collections::HashMap<String, i32>>,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for MailStatsVolume {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for MailStatsVolume {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}


impl MailStatsVolume {
    #[allow(clippy::new_without_default)]
    pub fn new() -> MailStatsVolume {
        MailStatsVolume {
            to: None,
            from: None,
            ip: None,
        }
    }
}

/// Converts the MailStatsVolume value to the Query Parameters representation (style=form, explode=false)
/// specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde serializer
impl std::fmt::Display for MailStatsVolume {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![
            // Skipping map to in query parameter serialization
            // Skipping map from in query parameter serialization
            // Skipping map ip in query parameter serialization
        ];

        write!(f, "{}", params.into_iter().flatten().collect::<Vec<_>>().join(","))
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a MailStatsVolume value
/// as specified in <https://swagger.io/docs/specification/serialization/>
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

// Methods for converting between header::IntoHeaderValue<MailStatsVolume> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<MailStatsVolume>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<MailStatsVolume>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for MailStatsVolume - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<MailStatsVolume> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <MailStatsVolume as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into MailStatsVolume - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<MailStatsVolume>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<MailStatsVolume>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<MailStatsVolume>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<MailStatsVolume> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <MailStatsVolume as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into MailStatsVolume - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// Request body for `POST /mail/send`.  Sends a simple single-recipient message. HTML detection is automatic — if `body` contains HTML tags the message is sent as `text/html`; otherwise as `text/plain`.  The `from` address is automatically set as both the `From` and `Reply-To` headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use `POST /mail/advsend` instead.
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct SendMail {
    #[serde(rename = "to")]

    #[cfg_attr(feature = "validate", validate)]
    pub to: models::SendMailTo,

    /// The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.
    #[serde(rename = "from")]

    pub from: String,

    /// The subject line of the email.
    #[serde(rename = "subject")]

    pub subject: String,

    /// The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
    #[serde(rename = "body")]

    pub body: String,

    /// Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
    #[serde(rename = "id")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub id: Option<i64>,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for SendMail {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for SendMail {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}


impl SendMail {
    #[allow(clippy::new_without_default)]
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
/// specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde serializer
impl std::fmt::Display for SendMail {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![
            // Skipping non-primitive type to in query parameter serialization
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
/// as specified in <https://swagger.io/docs/specification/serialization/>
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

// Methods for converting between header::IntoHeaderValue<SendMail> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<SendMail>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<SendMail>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for SendMail - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<SendMail> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <SendMail as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into SendMail - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<SendMail>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<SendMail>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<SendMail>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<SendMail> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <SendMail as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into SendMail - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct SendMailAdv {
    /// The subject line of the email.
    #[serde(rename = "subject")]

    pub subject: String,

    /// The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
    #[serde(rename = "body")]

    pub body: String,

    /// The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.
    #[serde(rename = "from")]

    #[cfg_attr(feature = "validate", validate)]
    pub from: models::EmailAddressTypes,

    /// One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
    #[serde(rename = "to")]

    #[cfg_attr(feature = "validate", validate)]
    pub to: models::EmailAddressesTypes,

    /// Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.
    #[serde(rename = "replyto")]

    #[cfg_attr(feature = "validate", validate)]
    #[serde(skip_serializing_if="Option::is_none")]
    pub replyto: Option<models::EmailAddressesTypes>,

    /// Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.
    #[serde(rename = "cc")]

    #[cfg_attr(feature = "validate", validate)]
    #[serde(skip_serializing_if="Option::is_none")]
    pub cc: Option<models::EmailAddressesTypes>,

    /// Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
    #[serde(rename = "bcc")]

    #[cfg_attr(feature = "validate", validate)]
    #[serde(skip_serializing_if="Option::is_none")]
    pub bcc: Option<models::EmailAddressesTypes>,

    /// Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
    #[serde(rename = "attachments")]

    #[cfg_attr(feature = "validate", validate)]
    #[serde(skip_serializing_if="Option::is_none")]
    pub attachments: Option<Vec<models::MailAttachment>>,

    /// Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
    #[serde(rename = "id")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub id: Option<i64>,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for SendMailAdv {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for SendMailAdv {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}


impl SendMailAdv {
    #[allow(clippy::new_without_default)]
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
/// specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde serializer
impl std::fmt::Display for SendMailAdv {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let params: Vec<Option<String>> = vec![
            Some("subject".to_string()),
            Some(self.subject.to_string()),
            Some("body".to_string()),
            Some(self.body.to_string()),
            // Skipping non-primitive type from in query parameter serialization
            // Skipping non-primitive type to in query parameter serialization
            // Skipping non-primitive type replyto in query parameter serialization
            // Skipping non-primitive type cc in query parameter serialization
            // Skipping non-primitive type bcc in query parameter serialization
            // Skipping non-primitive type attachments in query parameter serialization
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
/// as specified in <https://swagger.io/docs/specification/serialization/>
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

// Methods for converting between header::IntoHeaderValue<SendMailAdv> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<SendMailAdv>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<SendMailAdv>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for SendMailAdv - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<SendMailAdv> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <SendMailAdv as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into SendMailAdv - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<SendMailAdv>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<SendMailAdv>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<SendMailAdv>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<SendMailAdv> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <SendMailAdv as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into SendMailAdv - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// Request body for `POST /mail/rawsend`.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing `DKIM-Signature` header intact.  The `From`, `To`, `Cc`, and `Bcc` addresses are extracted from the message headers automatically — you do not need to specify them separately.
#[derive(Debug, Clone, PartialEq, Validate, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct SendMailRaw {
    /// The complete RFC 822 email message including all headers and the body. Must include at minimum `From`, `To`, `Subject`, `Date`, and `MIME-Version` headers.  DKIM signatures in the `DKIM-Signature` header are transmitted verbatim and will pass verification at the destination.
    #[serde(rename = "raw_email")]

    pub raw_email: String,

    /// Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by `GET /mail`.
    #[serde(rename = "id")]

    #[serde(skip_serializing_if="Option::is_none")]
    pub id: Option<i64>,

}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for SendMailRaw {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for SendMailRaw {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}


impl SendMailRaw {
    #[allow(clippy::new_without_default)]
    pub fn new(raw_email: String, ) -> SendMailRaw {
        SendMailRaw {
            raw_email,
            id: None,
        }
    }
}

/// Converts the SendMailRaw value to the Query Parameters representation (style=form, explode=false)
/// specified in <https://swagger.io/docs/specification/serialization/>
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
/// as specified in <https://swagger.io/docs/specification/serialization/>
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

// Methods for converting between header::IntoHeaderValue<SendMailRaw> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<SendMailRaw>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<SendMailRaw>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for SendMailRaw - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<SendMailRaw> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <SendMailRaw as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into SendMailRaw - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<SendMailRaw>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<SendMailRaw>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<SendMailRaw>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<SendMailRaw> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <SendMailRaw as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into SendMailRaw - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// The primary recipient address for a simple send request. Accepts a single email address string or an array of email address strings for multiple recipients.
#[derive(Debug, Clone, PartialEq, serde::Serialize, serde::Deserialize)]
#[cfg_attr(feature = "validate", derive(Validate))]
#[cfg_attr(feature = "conversion", derive(frunk::LabelledGeneric))]
pub struct SendMailTo(
    swagger::OneOf2<String,Vec<String>>
);

impl std::convert::From<swagger::OneOf2<String,Vec<String>>> for SendMailTo {
    fn from(x: swagger::OneOf2<String,Vec<String>>) -> Self {
        SendMailTo(x)
    }
}

impl std::convert::From<SendMailTo> for swagger::OneOf2<String,Vec<String>> {
    fn from(x: SendMailTo) -> Self {
        x.0
    }
}

impl std::ops::Deref for SendMailTo {
    type Target = swagger::OneOf2<String,Vec<String>>;
    fn deref(&self) -> &swagger::OneOf2<String,Vec<String>> {
        &self.0
    }
}

impl std::ops::DerefMut for SendMailTo {
    fn deref_mut(&mut self) -> &mut swagger::OneOf2<String,Vec<String>> {
        &mut self.0
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMinLength for SendMailTo {
    fn validate_composited_min_length(
        &self,
        _min_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MinLengthError>> {
        Ok(())
    }
}

#[cfg(feature = "validate")]
impl serde_valid::validation::ValidateCompositedMaxLength for SendMailTo {
    fn validate_composited_max_length(
        &self,
        _max_length: usize,
    ) -> Result<(), serde_valid::validation::Composited<serde_valid::validation::error::MaxLengthError>> {
        Ok(())
    }
}
/// Converts the SendMailTo value to the Query Parameters representation (style=form, explode=false)
/// specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde serializer
impl std::fmt::Display for SendMailTo {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        // Display for this model is not supported
        write!(f, "")
    }
}

/// Converts Query Parameters representation (style=form, explode=false) to a SendMailTo value
/// as specified in <https://swagger.io/docs/specification/serialization/>
/// Should be implemented in a serde deserializer
impl ::std::str::FromStr for SendMailTo {
    type Err = &'static str;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        std::result::Result::Err("Parsing SendMailTo is not supported")
    }
}

// Methods for converting between header::IntoHeaderValue<SendMailTo> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<SendMailTo>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<SendMailTo>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for SendMailTo - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<SendMailTo> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <SendMailTo as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into SendMailTo - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<SendMailTo>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<SendMailTo>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<SendMailTo>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<SendMailTo> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <SendMailTo as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into SendMailTo - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// Enumeration of values.
/// Since this enum's variants do not hold data, we can easily define them as `#[repr(C)]`
/// which helps with FFI.
#[allow(non_camel_case_types)]
#[repr(C)]
#[derive(Debug, Clone, Copy, PartialEq, Eq, PartialOrd, Ord, serde::Serialize, serde::Deserialize, Hash)]
#[cfg_attr(feature = "validate", derive(Validate))]
#[cfg_attr(feature = "conversion", derive(frunk_enum_derive::LabelledGenericEnum))]
pub enum ViewMailLogDirParameter {
    #[serde(rename = "asc")]
    Asc,
    #[serde(rename = "desc")]
    Desc,
    #[serde(rename = "11184809")]
    UnknownDefaultOpenApi,
}

impl std::fmt::Display for ViewMailLogDirParameter {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match *self {
            ViewMailLogDirParameter::Asc => write!(f, "asc"),
            ViewMailLogDirParameter::Desc => write!(f, "desc"),
            ViewMailLogDirParameter::UnknownDefaultOpenApi => write!(f, "11184809"),
        }
    }
}

impl std::str::FromStr for ViewMailLogDirParameter {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        match s {
            "asc" => std::result::Result::Ok(ViewMailLogDirParameter::Asc),
            "desc" => std::result::Result::Ok(ViewMailLogDirParameter::Desc),
            "11184809" => std::result::Result::Ok(ViewMailLogDirParameter::UnknownDefaultOpenApi),
            _ => std::result::Result::Err(format!("Value not valid: {s}")),
        }
    }
}

// Methods for converting between header::IntoHeaderValue<ViewMailLogDirParameter> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<ViewMailLogDirParameter>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<ViewMailLogDirParameter>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for ViewMailLogDirParameter - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<ViewMailLogDirParameter> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <ViewMailLogDirParameter as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into ViewMailLogDirParameter - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<ViewMailLogDirParameter>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<ViewMailLogDirParameter>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<ViewMailLogDirParameter>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<ViewMailLogDirParameter> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <ViewMailLogDirParameter as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into ViewMailLogDirParameter - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// Enumeration of values.
/// Since this enum's variants do not hold data, we can easily define them as `#[repr(C)]`
/// which helps with FFI.
#[allow(non_camel_case_types)]
#[repr(C)]
#[derive(Debug, Clone, Copy, PartialEq, Eq, PartialOrd, Ord, serde::Serialize, serde::Deserialize, Hash)]
#[cfg_attr(feature = "validate", derive(Validate))]
#[cfg_attr(feature = "conversion", derive(frunk_enum_derive::LabelledGenericEnum))]
pub enum ViewMailLogGroupbyParameter {
    #[serde(rename = "message")]
    Message,
    #[serde(rename = "recipient")]
    Recipient,
    #[serde(rename = "11184809")]
    UnknownDefaultOpenApi,
}

impl std::fmt::Display for ViewMailLogGroupbyParameter {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match *self {
            ViewMailLogGroupbyParameter::Message => write!(f, "message"),
            ViewMailLogGroupbyParameter::Recipient => write!(f, "recipient"),
            ViewMailLogGroupbyParameter::UnknownDefaultOpenApi => write!(f, "11184809"),
        }
    }
}

impl std::str::FromStr for ViewMailLogGroupbyParameter {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        match s {
            "message" => std::result::Result::Ok(ViewMailLogGroupbyParameter::Message),
            "recipient" => std::result::Result::Ok(ViewMailLogGroupbyParameter::Recipient),
            "11184809" => std::result::Result::Ok(ViewMailLogGroupbyParameter::UnknownDefaultOpenApi),
            _ => std::result::Result::Err(format!("Value not valid: {s}")),
        }
    }
}

// Methods for converting between header::IntoHeaderValue<ViewMailLogGroupbyParameter> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<ViewMailLogGroupbyParameter>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<ViewMailLogGroupbyParameter>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for ViewMailLogGroupbyParameter - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<ViewMailLogGroupbyParameter> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <ViewMailLogGroupbyParameter as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into ViewMailLogGroupbyParameter - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<ViewMailLogGroupbyParameter>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<ViewMailLogGroupbyParameter>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<ViewMailLogGroupbyParameter>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<ViewMailLogGroupbyParameter> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <ViewMailLogGroupbyParameter as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into ViewMailLogGroupbyParameter - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}

/// Enumeration of values.
/// Since this enum's variants do not hold data, we can easily define them as `#[repr(C)]`
/// which helps with FFI.
#[allow(non_camel_case_types)]
#[repr(C)]
#[derive(Debug, Clone, Copy, PartialEq, Eq, PartialOrd, Ord, serde::Serialize, serde::Deserialize, Hash)]
#[cfg_attr(feature = "validate", derive(Validate))]
#[cfg_attr(feature = "conversion", derive(frunk_enum_derive::LabelledGenericEnum))]
pub enum ViewMailLogSortParameter {
    #[serde(rename = "time")]
    Time,
    #[serde(rename = "11184809")]
    UnknownDefaultOpenApi,
}

impl std::fmt::Display for ViewMailLogSortParameter {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match *self {
            ViewMailLogSortParameter::Time => write!(f, "time"),
            ViewMailLogSortParameter::UnknownDefaultOpenApi => write!(f, "11184809"),
        }
    }
}

impl std::str::FromStr for ViewMailLogSortParameter {
    type Err = String;

    fn from_str(s: &str) -> std::result::Result<Self, Self::Err> {
        match s {
            "time" => std::result::Result::Ok(ViewMailLogSortParameter::Time),
            "11184809" => std::result::Result::Ok(ViewMailLogSortParameter::UnknownDefaultOpenApi),
            _ => std::result::Result::Err(format!("Value not valid: {s}")),
        }
    }
}

// Methods for converting between header::IntoHeaderValue<ViewMailLogSortParameter> and hyper::header::HeaderValue

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<ViewMailLogSortParameter>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_value: header::IntoHeaderValue<ViewMailLogSortParameter>) -> std::result::Result<Self, Self::Error> {
        let hdr_value = hdr_value.to_string();
        match hyper::header::HeaderValue::from_str(&hdr_value) {
             std::result::Result::Ok(value) => std::result::Result::Ok(value),
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Invalid header value for ViewMailLogSortParameter - value: {hdr_value} is invalid {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<ViewMailLogSortParameter> {
    type Error = String;

    fn try_from(hdr_value: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_value.to_str() {
             std::result::Result::Ok(value) => {
                    match <ViewMailLogSortParameter as std::str::FromStr>::from_str(value) {
                        std::result::Result::Ok(value) => std::result::Result::Ok(header::IntoHeaderValue(value)),
                        std::result::Result::Err(err) => std::result::Result::Err(
                            format!("Unable to convert header value '{value}' into ViewMailLogSortParameter - {err}"))
                    }
             },
             std::result::Result::Err(e) => std::result::Result::Err(
                 format!("Unable to convert header: {hdr_value:?} to string: {e}"))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<header::IntoHeaderValue<Vec<ViewMailLogSortParameter>>> for hyper::header::HeaderValue {
    type Error = String;

    fn try_from(hdr_values: header::IntoHeaderValue<Vec<ViewMailLogSortParameter>>) -> std::result::Result<Self, Self::Error> {
        let hdr_values : Vec<String> = hdr_values.0.into_iter().map(|hdr_value| {
            hdr_value.to_string()
        }).collect();

        match hyper::header::HeaderValue::from_str(&hdr_values.join(", ")) {
           std::result::Result::Ok(hdr_value) => std::result::Result::Ok(hdr_value),
           std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to convert {hdr_values:?} into a header - {e}",))
        }
    }
}

#[cfg(any(feature = "client", feature = "server"))]
impl std::convert::TryFrom<hyper::header::HeaderValue> for header::IntoHeaderValue<Vec<ViewMailLogSortParameter>> {
    type Error = String;

    fn try_from(hdr_values: hyper::header::HeaderValue) -> std::result::Result<Self, Self::Error> {
        match hdr_values.to_str() {
            std::result::Result::Ok(hdr_values) => {
                let hdr_values : std::vec::Vec<ViewMailLogSortParameter> = hdr_values
                .split(',')
                .filter_map(|hdr_value| match hdr_value.trim() {
                    "" => std::option::Option::None,
                    hdr_value => std::option::Option::Some({
                        match <ViewMailLogSortParameter as std::str::FromStr>::from_str(hdr_value) {
                            std::result::Result::Ok(value) => std::result::Result::Ok(value),
                            std::result::Result::Err(err) => std::result::Result::Err(
                                format!("Unable to convert header value '{hdr_value}' into ViewMailLogSortParameter - {err}"))
                        }
                    })
                }).collect::<std::result::Result<std::vec::Vec<_>, String>>()?;

                std::result::Result::Ok(header::IntoHeaderValue(hdr_values))
            },
            std::result::Result::Err(e) => std::result::Result::Err(format!("Unable to parse header: {hdr_values:?} as a string - {e}")),
        }
    }
}
