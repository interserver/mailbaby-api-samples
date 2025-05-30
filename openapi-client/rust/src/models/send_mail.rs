/*
 * MailBaby Email Delivery and Management Service API
 *
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * The version of the OpenAPI document: 1.1.0
 * Contact: support@interserver.net
 * Generated by: https://openapi-generator.tech
 */

use crate::models;
use serde::{Deserialize, Serialize};

/// SendMail : Details for an Email
#[derive(Clone, Default, Debug, PartialEq, Serialize, Deserialize)]
pub struct SendMail {
    /// The Contact whom is the primary recipient of this email.
    #[serde(rename = "to")]
    pub to: String,
    /// The contact whom is the this email is from.
    #[serde(rename = "from")]
    pub from: String,
    /// The subject or title of the email
    #[serde(rename = "subject")]
    pub subject: String,
    /// The main email contents.
    #[serde(rename = "body")]
    pub body: String,
}

impl SendMail {
    /// Details for an Email
    pub fn new(to: String, from: String, subject: String, body: String) -> SendMail {
        SendMail {
            to,
            from,
            subject,
            body,
        }
    }
}

