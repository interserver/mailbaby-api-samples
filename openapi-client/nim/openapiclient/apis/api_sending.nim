#
# MailBaby Email Delivery and Management Service API
# 
# **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
# The version of the OpenAPI document: 1.1.0
# Contact: support@interserver.net
# Generated by: https://openapi-generator.tech
#

import httpclient
import json
import logging
import marshal
import options
import strformat
import strutils
import tables
import typetraits
import uri

import ../models/model_email_address_types
import ../models/model_email_addresses_types
import ../models/model_error_message
import ../models/model_generic_response
import ../models/model_mail_attachment

const basepath = "https://api.mailbaby.net"

template constructResult[T](response: Response): untyped =
  if response.code in {Http200, Http201, Http202, Http204, Http206}:
    try:
      when name(stripGenericParams(T.typedesc).typedesc) == name(Table):
        (some(json.to(parseJson(response.body), T.typedesc)), response)
      else:
        (some(marshal.to[T](response.body)), response)
    except JsonParsingError:
      # The server returned a malformed response though the response code is 2XX
      # TODO: need better error handling
      error("JsonParsingError")
      (none(T.typedesc), response)
  else:
    (none(T.typedesc), response)


proc sendAdvMail*(httpClient: HttpClient, subject: string, body: string, `from`: EmailAddressTypes, to: EmailAddressesTypes, replyto: EmailAddressesTypes, cc: EmailAddressesTypes, bcc: EmailAddressesTypes, attachments: seq[MailAttachment], id: int64): (Option[GenericResponse], Response) =
  ## Sends an Email with Advanced Options
  httpClient.headers["Content-Type"] = "application/x-www-form-urlencoded"
  let form_data = encodeQuery([
    ("subject", $subject), # The subject or title of the email
    ("body", $body), # The main email contents.
    ("from", $`from`), # 
    ("to", $to), # 
    ("replyto", $replyto), # 
    ("cc", $cc), # 
    ("bcc", $bcc), # 
    ("attachments", $attachments.join(",")), # (optional) File attachments to include in the email.  The file contents must be base64 encoded!
    ("id", $id), # (optional)  ID of the Mail order within our system to use as the Mail Account.
  ])

  let response = httpClient.post(basepath & "/mail/advsend", $form_data)
  constructResult[GenericResponse](response)


proc sendMail*(httpClient: HttpClient, to: string, `from`: string, subject: string, body: string): (Option[GenericResponse], Response) =
  ## Sends an Email
  httpClient.headers["Content-Type"] = "application/x-www-form-urlencoded"
  let form_data = encodeQuery([
    ("to", $to), # The Contact whom is the primary recipient of this email.
    ("from", $`from`), # The contact whom is the this email is from.
    ("subject", $subject), # The subject or title of the email
    ("body", $body), # The main email contents.
  ])

  let response = httpClient.post(basepath & "/mail/send", $form_data)
  constructResult[GenericResponse](response)

