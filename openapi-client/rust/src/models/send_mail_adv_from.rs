/*
 * Mail Baby API
 *
 * This is an API defintion for accesssing the Mail.Baby mail service.
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: detain@interserver.net
 * Generated by: https://openapi-generator.tech
 */

/// SendMailAdvFrom : An Email Contact



#[derive(Clone, Debug, PartialEq, Serialize, Deserialize)]
pub struct SendMailAdvFrom {
    /// The email address
    #[serde(rename = "email")]
    pub email: String,
    /// Optional contact name
    #[serde(rename = "name", skip_serializing_if = "Option::is_none")]
    pub name: Option<String>,
}

impl SendMailAdvFrom {
    /// An Email Contact
    pub fn new(email: String) -> SendMailAdvFrom {
        SendMailAdvFrom {
            email,
            name: None,
        }
    }
}

