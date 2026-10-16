# SENDING_API

All URIs are relative to *https://api.mailbaby.net*

Feature | HTTP request | Description
------------- | ------------- | -------------
[**raw_mail**](SENDING_API.md#raw_mail) | **Post** /mail/rawsend | Send a pre-built RFC 822 message verbatim (preserves DKIM)
[**send_adv_mail**](SENDING_API.md#send_adv_mail) | **Post** /mail/advsend | Send email with multiple recipients, CC/BCC, attachments, named contacts
[**send_mail**](SENDING_API.md#send_mail) | **Post** /mail/send | Send a simple email (single recipient, plain or HTML)


# **raw_mail**
> raw_mail (send_mail_raw: SEND_MAIL_RAW ): detachable GENERIC_RESPONSE


Send a pre-built RFC 822 message verbatim (preserves DKIM)

**Use this when you have already built (and possibly DKIM-signed) the full RFC 822 message yourself** and want the relay to transmit it byte-for-byte. Required: `raw_email` (full RFC 822 string with headers + body). Optional: `id` (mail order to authenticate as). Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact. If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. 


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **send_mail_raw** | [**SEND_MAIL_RAW**](SEND_MAIL_RAW.md)|  | 

### Return type

[**GENERIC_RESPONSE**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_adv_mail**
> send_adv_mail (subject: STRING_32 ; body: STRING_32 ; var_from: EMAIL_ADDRESS_TYPES ; to: EMAIL_ADDRESSES_TYPES ; replyto:  detachable EMAIL_ADDRESSES_TYPES ; cc:  detachable EMAIL_ADDRESSES_TYPES ; bcc:  detachable EMAIL_ADDRESSES_TYPES ; attachments:  detachable LIST [MAIL_ATTACHMENT] ; id:  detachable INTEGER_64 ): detachable GENERIC_RESPONSE


Send email with multiple recipients, CC/BCC, attachments, named contacts

**Use this when the simple send is not enough** — multiple recipients, CC/BCC, named contacts, custom Reply-To, or file attachments. Required: `from`, `to`, `subject`, `body`. Optional: `cc`, `bcc`, `replyto`, `attachments` (array of `{filename,data}` with base64 data), `id`. Sends through one of your mail orders with full control over recipients, headers, and attachments.  **Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `\"Joe <joe@example.com>, jane@example.com\"`) and the structured `[{\"email\":\"...\",\"name\":\"...\"}]` array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.  **Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.  ## Examples  ### Form — basic string addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d from=user@domain.com \\   -d to=support@interserver.net ``` ### Form — RFC 822 named addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d 'from=Joe <user@domain.com>' \\   -d 'to=Jane <support@interserver.net>' ``` ### Form — multiple recipients as array ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' -d 'body=Hello' \\   -d from=user@domain.com \\   -d 'to[0][name]=Joe' -d 'to[0][email]=support@interserver.net' \\   -d 'to[1][name]=Jane' -d 'to[1][email]=jane@interserver.net' ``` ### JSON — structured objects ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/json' \\   -d '{     \"subject\": \"Welcome\",     \"body\": \"<h1>Hello</h1>\",     \"from\": {\"email\": \"user@domain.com\", \"name\": \"Sender Name\"},     \"to\": [{\"email\": \"joe@client.com\", \"name\": \"Joe Client\"}],     \"cc\": [{\"email\": \"manager@client.com\"}],     \"attachments\": [{\"filename\": \"report.pdf\", \"data\": \"BASE64_DATA\"}]   }' ``` 


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **STRING_32**| The subject line of the email. | [default to null]
 **body** | **STRING_32**| The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | [default to null]
 **var_from** | [**EMAIL_ADDRESS_TYPES**](EmailAddressTypes.md)| The sender address.  Accepts a plain email string, an RFC 822 named string (&#x60;\\\&quot;Name &lt;email&gt;\\\&quot;&#x60;), or a &#x60;{\\\&quot;email\\\&quot;: \\\&quot;...\\\&quot;, \\\&quot;name\\\&quot;: \\\&quot;...\\\&quot;}&#x60; object. | [default to null]
 **to** | [**EMAIL_ADDRESSES_TYPES**](EmailAddressesTypes.md)| One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects. | [default to null]
 **replyto** | [**EMAIL_ADDRESSES_TYPES**](EmailAddressesTypes.md)| Optional.  One or more addresses to set as the &#x60;Reply-To&#x60; header. When recipients reply to the message their email client will address the reply to these addresses instead of &#x60;from&#x60;. | [optional] [default to null]
 **cc** | [**EMAIL_ADDRESSES_TYPES**](EmailAddressesTypes.md)| Optional.  Carbon-copy recipients.  These addresses are listed in the &#x60;Cc&#x60; header and are visible to all recipients. | [optional] [default to null]
 **bcc** | [**EMAIL_ADDRESSES_TYPES**](EmailAddressesTypes.md)| Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header. | [optional] [default to null]
 **attachments** | [**LIST [MAIL_ATTACHMENT]**](MAIL_ATTACHMENT.md)| Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name. | [optional] [default to null]
 **id** | **INTEGER_64**| Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] [default to null]

### Return type

[**GENERIC_RESPONSE**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_mail**
> send_mail (to: SEND_MAIL_TO ; var_from: STRING_32 ; subject: STRING_32 ; body: STRING_32 ; id:  detachable INTEGER_64 ): detachable GENERIC_RESPONSE


Send a simple email (single recipient, plain or HTML)

**Use this for the simplest case** — one or a few plain-string recipients, no attachments, no CC/BCC, no named contacts. Required: `from`, `to`, `subject`, `body`. Optional: `id` (selects which mail order to send through; auto-selects your first active order if omitted). Sends through one of your mail orders using a flat set of fields.  **HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.  The `from` address is also automatically set as the `Reply-To` header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. 


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | [**SEND_MAIL_TO**](SendMailTo.md)|  | [default to null]
 **var_from** | **STRING_32**| The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order. | [default to null]
 **subject** | **STRING_32**| The subject line of the email. | [default to null]
 **body** | **STRING_32**| The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | [default to null]
 **id** | **INTEGER_64**| Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] [default to null]

### Return type

[**GENERIC_RESPONSE**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

