#
# MailBaby Email Delivery and Management Service API
# 
# **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
# The version of the OpenAPI document: 1.1.0
# Contact: support@interserver.net
# Generated by: https://openapi-generator.tech
#

import json
import tables


type `Type`* {.pure.} = enum
  Domain
  Email
  Startswith

type DenyRuleRecord* = object
  ## The data for a email deny rule record.
  `type`*: `Type` ## The type of deny rule.
  data*: string ## The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
  id*: int ## The deny rule Id number.
  created*: string ## the date the rule was created.
  user*: string ## Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.

func `%`*(v: `Type`): JsonNode =
  let str = case v:
    of `Type`.Domain: "domain"
    of `Type`.Email: "email"
    of `Type`.Startswith: "startswith"

  JsonNode(kind: JString, str: str)

func `$`*(v: `Type`): string =
  result = case v:
    of `Type`.Domain: "domain"
    of `Type`.Email: "email"
    of `Type`.Startswith: "startswith"