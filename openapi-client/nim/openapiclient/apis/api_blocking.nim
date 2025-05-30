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

import ../models/model_deny_rule_record
import ../models/model_error_message
import ../models/model_generic_response
import ../models/model_mail_blocks

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


proc addRule*(httpClient: HttpClient, `type`: string, data: string, user: string): (Option[GenericResponse], Response) =
  ## Creates a new email deny rule.
  httpClient.headers["Content-Type"] = "application/x-www-form-urlencoded"
  let form_data = encodeQuery([
    ("user", $user), # Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
    ("type", $`type`), # The type of deny rule.
    ("data", $data), # The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
  ])

  let response = httpClient.post(basepath & "/mail/rules", $form_data)
  constructResult[GenericResponse](response)


proc deleteRule*(httpClient: HttpClient, ruleId: int): (Option[GenericResponse], Response) =
  ## Removes an deny mail rule.

  let response = httpClient.delete(basepath & fmt"/mail/rules/{ruleId}")
  constructResult[GenericResponse](response)


proc delistBlock*(httpClient: HttpClient, body: string): (Option[GenericResponse], Response) =
  ## Removes an email address from the blocked list
  httpClient.headers["Content-Type"] = "application/json"

  let response = httpClient.post(basepath & "/mail/blocks/delete", $(%body))
  constructResult[GenericResponse](response)


proc getMailBlocks*(httpClient: HttpClient): (Option[MailBlocks], Response) =
  ## displays a list of blocked email addresses

  let response = httpClient.get(basepath & "/mail/blocks")
  constructResult[MailBlocks](response)


proc getRules*(httpClient: HttpClient): (Option[seq[DenyRuleRecord]], Response) =
  ## Displays a listing of deny email rules.

  let response = httpClient.get(basepath & "/mail/rules")
  constructResult[seq[DenyRuleRecord]](response)

