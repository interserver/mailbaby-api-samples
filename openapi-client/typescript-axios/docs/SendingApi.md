# SendingApi

All URIs are relative to *https://api.mailbaby.net*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**rawMail**](#rawmail) | **POST** /mail/rawsend | Sends a raw RFC 822 email|
|[**sendAdvMail**](#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options|
|[**sendMail**](#sendmail) | **POST** /mail/send | Sends an Email|

# **rawMail**
> GenericResponse rawMail(sendMailRaw)

Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact.  If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. 

### Example

```typescript
import {
    SendingApi,
    Configuration,
    SendMailRaw
} from './api';

const configuration = new Configuration();
const apiInstance = new SendingApi(configuration);

let sendMailRaw: SendMailRaw; //

const { status, data } = await apiInstance.rawMail(
    sendMailRaw
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **sendMailRaw** | **SendMailRaw**|  | |


### Return type

**GenericResponse**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Email accepted for delivery |  -  |
|**400** | Bad request — one or more input parameters were missing or invalid. |  -  |
|**401** | Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security). |  -  |
|**404** | The specified resource was not found or does not belong to your account. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **sendAdvMail**
> GenericResponse sendAdvMail()

Sends an email through one of your mail orders with full control over recipients, headers, and attachments.  Supports multiple To / CC / BCC addresses, named contacts, Reply-To overrides, and base64-encoded file attachments.  **Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `\"Joe <joe@example.com>, jane@example.com\"`) and the structured `[{\"email\":\"...\",\"name\":\"...\"}]` array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.  **Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.  ## Examples  ### Form — basic string addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H \'X-API-KEY: YOUR_API_KEY\' \\   -H \'Content-Type: application/x-www-form-urlencoded\' \\   -d \'subject=Welcome\' \\   -d \'body=Hello\' \\   -d from=user@domain.com \\   -d to=support@interserver.net ``` ### Form — RFC 822 named addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H \'X-API-KEY: YOUR_API_KEY\' \\   -H \'Content-Type: application/x-www-form-urlencoded\' \\   -d \'subject=Welcome\' \\   -d \'body=Hello\' \\   -d \'from=Joe <user@domain.com>\' \\   -d \'to=Jane <support@interserver.net>\' ``` ### Form — multiple recipients as array ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H \'X-API-KEY: YOUR_API_KEY\' \\   -H \'Content-Type: application/x-www-form-urlencoded\' \\   -d \'subject=Welcome\' -d \'body=Hello\' \\   -d from=user@domain.com \\   -d \'to[0][name]=Joe\' -d \'to[0][email]=support@interserver.net\' \\   -d \'to[1][name]=Jane\' -d \'to[1][email]=jane@interserver.net\' ``` ### JSON — structured objects ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H \'X-API-KEY: YOUR_API_KEY\' \\   -H \'Content-Type: application/json\' \\   -d \'{     \"subject\": \"Welcome\",     \"body\": \"<h1>Hello</h1>\",     \"from\": {\"email\": \"user@domain.com\", \"name\": \"Sender Name\"},     \"to\": [{\"email\": \"joe@client.com\", \"name\": \"Joe Client\"}],     \"cc\": [{\"email\": \"manager@client.com\"}],     \"attachments\": [{\"filename\": \"report.pdf\", \"data\": \"BASE64_DATA\"}]   }\' ``` 

### Example

```typescript
import {
    SendingApi,
    Configuration,
    EmailAddressTypes,
    EmailAddressesTypes,
    EmailAddressesTypes,
    EmailAddressesTypes,
    EmailAddressesTypes
} from './api';

const configuration = new Configuration();
const apiInstance = new SendingApi(configuration);

let subject: string; //The subject line of the email. (default to undefined)
let body: string; //The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`. (default to undefined)
let from: EmailAddressTypes; // (default to undefined)
let to: EmailAddressesTypes; // (default to undefined)
let replyto: EmailAddressesTypes; // (optional) (default to undefined)
let cc: EmailAddressesTypes; // (optional) (default to undefined)
let bcc: EmailAddressesTypes; // (optional) (default to undefined)
let attachments: Array<MailAttachment>; //Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name. (optional) (default to undefined)
let id: number; //Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. (optional) (default to undefined)

const { status, data } = await apiInstance.sendAdvMail(
    subject,
    body,
    from,
    to,
    replyto,
    cc,
    bcc,
    attachments,
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **subject** | [**string**] | The subject line of the email. | defaults to undefined|
| **body** | [**string**] | The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | defaults to undefined|
| **from** | **EmailAddressTypes** |  | defaults to undefined|
| **to** | **EmailAddressesTypes** |  | defaults to undefined|
| **replyto** | **EmailAddressesTypes** |  | (optional) defaults to undefined|
| **cc** | **EmailAddressesTypes** |  | (optional) defaults to undefined|
| **bcc** | **EmailAddressesTypes** |  | (optional) defaults to undefined|
| **attachments** | **Array&lt;MailAttachment&gt;** | Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name. | (optional) defaults to undefined|
| **id** | [**number**] | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | (optional) defaults to undefined|


### Return type

**GenericResponse**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Email accepted for delivery |  -  |
|**400** | Bad request — one or more input parameters were missing or invalid. |  -  |
|**401** | Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security). |  -  |
|**404** | The specified resource was not found or does not belong to your account. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **sendMail**
> GenericResponse sendMail()

Sends an email through one of your mail orders using a simple flat set of fields. This is the quickest way to send a single-recipient plain-text or HTML message.  **HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.  The `from` address is also automatically set as the `Reply-To` header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. 

### Example

```typescript
import {
    SendingApi,
    Configuration,
    SendMailTo
} from './api';

const configuration = new Configuration();
const apiInstance = new SendingApi(configuration);

let to: SendMailTo; // (default to undefined)
let from: string; //The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order. (default to undefined)
let subject: string; //The subject line of the email. (default to undefined)
let body: string; //The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`. (default to undefined)
let id: number; //Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. (optional) (default to undefined)

const { status, data } = await apiInstance.sendMail(
    to,
    from,
    subject,
    body,
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **to** | **SendMailTo** |  | defaults to undefined|
| **from** | [**string**] | The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order. | defaults to undefined|
| **subject** | [**string**] | The subject line of the email. | defaults to undefined|
| **body** | [**string**] | The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | defaults to undefined|
| **id** | [**number**] | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | (optional) defaults to undefined|


### Return type

**GenericResponse**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Email accepted for delivery |  -  |
|**400** | Bad request — one or more input parameters were missing or invalid. |  -  |
|**401** | Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security). |  -  |
|**404** | The specified resource was not found or does not belong to your account. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

