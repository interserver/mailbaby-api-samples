# openapi_client.SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**raw_mail**](SendingApi.md#raw_mail) | **POST** /mail/rawsend | Sends a raw RFC 822 email
[**send_adv_mail**](SendingApi.md#send_adv_mail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**send_mail**](SendingApi.md#send_mail) | **POST** /mail/send | Sends an Email


# **raw_mail**
> GenericResponse raw_mail(send_mail_raw)

Sends a raw RFC 822 email

Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.

This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact. If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.

The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.

If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.

On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record.


### Example

* Api Key Authentication (apiKeyAuth):

```python
import openapi_client
from openapi_client.models.generic_response import GenericResponse
from openapi_client.models.send_mail_raw import SendMailRaw
from openapi_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to https://api.mailbaby.net
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "https://api.mailbaby.net"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure API key authorization: apiKeyAuth
configuration.api_key['apiKeyAuth'] = os.environ["API_KEY"]

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiKeyAuth'] = 'Bearer'

# Enter a context with an instance of the API client
with openapi_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = openapi_client.SendingApi(api_client)
    send_mail_raw = openapi_client.SendMailRaw() # SendMailRaw | 

    try:
        # Sends a raw RFC 822 email
        api_response = api_instance.raw_mail(send_mail_raw)
        print("The response of SendingApi->raw_mail:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SendingApi->raw_mail: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **send_mail_raw** | [**SendMailRaw**](SendMailRaw.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Email accepted for delivery |  -  |
**400** | Bad request — one or more input parameters were missing or invalid. |  -  |
**401** | Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security). |  -  |
**404** | The specified resource was not found or does not belong to your account. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_adv_mail**
> GenericResponse send_adv_mail(subject, body, var_from, to, replyto=replyto, cc=cc, bcc=bcc, attachments=attachments, id=id)

Sends an Email with Advanced Options

Sends an email through one of your mail orders with full control over recipients, headers, and attachments.  Supports multiple To / CC / BCC addresses, named contacts, Reply-To overrides, and base64-encoded file attachments.

**Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `"Joe <joe@example.com>, jane@example.com"`) and the structured `[{"email":"...","name":"..."}]` array format.  When using JSON, both formats are equally supported.

**HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.

**Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.

If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.

On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.

## Examples

### Form — basic string addresses
```sh curl -X POST https://api.mailbaby.net/mail/advsend \
  -H 'X-API-KEY: YOUR_API_KEY' \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  -d 'subject=Welcome' \
  -d 'body=Hello' \
  -d from=user@domain.com \
  -d to=support@interserver.net
```
### Form — RFC 822 named addresses
```sh curl -X POST https://api.mailbaby.net/mail/advsend \
  -H 'X-API-KEY: YOUR_API_KEY' \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  -d 'subject=Welcome' \
  -d 'body=Hello' \
  -d 'from=Joe <user@domain.com>' \
  -d 'to=Jane <support@interserver.net>'
```
### Form — multiple recipients as array
```sh curl -X POST https://api.mailbaby.net/mail/advsend \
  -H 'X-API-KEY: YOUR_API_KEY' \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  -d 'subject=Welcome' -d 'body=Hello' \
  -d from=user@domain.com \
  -d 'to[0][name]=Joe' -d 'to[0][email]=support@interserver.net' \
  -d 'to[1][name]=Jane' -d 'to[1][email]=jane@interserver.net'
```
### JSON — structured objects
```sh curl -X POST https://api.mailbaby.net/mail/advsend \
  -H 'X-API-KEY: YOUR_API_KEY' \
  -H 'Content-Type: application/json' \
  -d '{
    "subject": "Welcome",
    "body": "<h1>Hello</h1>",
    "from": {"email": "user@domain.com", "name": "Sender Name"},
    "to": [{"email": "joe@client.com", "name": "Joe Client"}],
    "cc": [{"email": "manager@client.com"}],
    "attachments": [{"filename": "report.pdf", "data": "BASE64_DATA"}]
  }'
```


### Example

* Api Key Authentication (apiKeyAuth):

```python
import openapi_client
from openapi_client.models.generic_response import GenericResponse
from openapi_client.models.mail_attachment import MailAttachment
from openapi_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to https://api.mailbaby.net
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "https://api.mailbaby.net"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure API key authorization: apiKeyAuth
configuration.api_key['apiKeyAuth'] = os.environ["API_KEY"]

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiKeyAuth'] = 'Bearer'

# Enter a context with an instance of the API client
with openapi_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = openapi_client.SendingApi(api_client)
    subject = 'subject_example' # str | The subject line of the email.
    body = 'body_example' # str | The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
    var_from = openapi_client.EmailAddressTypes() # EmailAddressTypes | The sender address.  Accepts a plain email string, an RFC 822 named string (`\\\"Name <email>\\\"`), or a `{\\\"email\\\": \\\"...\\\", \\\"name\\\": \\\"...\\\"}` object.
    to = openapi_client.EmailAddressesTypes() # EmailAddressesTypes | One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
    replyto = openapi_client.EmailAddressesTypes() # EmailAddressesTypes | Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`. (optional)
    cc = openapi_client.EmailAddressesTypes() # EmailAddressesTypes | Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients. (optional)
    bcc = openapi_client.EmailAddressesTypes() # EmailAddressesTypes | Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header. (optional)
    attachments = [openapi_client.MailAttachment()] # List[MailAttachment] | Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name. (optional)
    id = 56 # int | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. (optional)

    try:
        # Sends an Email with Advanced Options
        api_response = api_instance.send_adv_mail(subject, body, var_from, to, replyto=replyto, cc=cc, bcc=bcc, attachments=attachments, id=id)
        print("The response of SendingApi->send_adv_mail:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SendingApi->send_adv_mail: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **str**| The subject line of the email. | 
 **body** | **str**| The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | 
 **var_from** | [**EmailAddressTypes**](EmailAddressTypes.md)| The sender address.  Accepts a plain email string, an RFC 822 named string (&#x60;\\\&quot;Name &lt;email&gt;\\\&quot;&#x60;), or a &#x60;{\\\&quot;email\\\&quot;: \\\&quot;...\\\&quot;, \\\&quot;name\\\&quot;: \\\&quot;...\\\&quot;}&#x60; object. | 
 **to** | [**EmailAddressesTypes**](EmailAddressesTypes.md)| One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects. | 
 **replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md)| Optional.  One or more addresses to set as the &#x60;Reply-To&#x60; header. When recipients reply to the message their email client will address the reply to these addresses instead of &#x60;from&#x60;. | [optional] 
 **cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md)| Optional.  Carbon-copy recipients.  These addresses are listed in the &#x60;Cc&#x60; header and are visible to all recipients. | [optional] 
 **bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md)| Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header. | [optional] 
 **attachments** | [**List[MailAttachment]**](MailAttachment.md)| Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name. | [optional] 
 **id** | **int**| Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Email accepted for delivery |  -  |
**400** | Bad request — one or more input parameters were missing or invalid. |  -  |
**401** | Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security). |  -  |
**404** | The specified resource was not found or does not belong to your account. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_mail**
> GenericResponse send_mail(to, var_from, subject, body, id=id)

Sends an Email

Sends an email through one of your mail orders using a simple flat set of fields. This is the quickest way to send a single-recipient plain-text or HTML message.

**HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.

The `from` address is also automatically set as the `Reply-To` header.

*Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.

On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record.


### Example

* Api Key Authentication (apiKeyAuth):

```python
import openapi_client
from openapi_client.models.generic_response import GenericResponse
from openapi_client.models.send_mail_to import SendMailTo
from openapi_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to https://api.mailbaby.net
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "https://api.mailbaby.net"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure API key authorization: apiKeyAuth
configuration.api_key['apiKeyAuth'] = os.environ["API_KEY"]

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiKeyAuth'] = 'Bearer'

# Enter a context with an instance of the API client
with openapi_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = openapi_client.SendingApi(api_client)
    to = openapi_client.SendMailTo() # SendMailTo | 
    var_from = 'var_from_example' # str | The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.
    subject = 'subject_example' # str | The subject line of the email.
    body = 'body_example' # str | The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
    id = 56 # int | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. (optional)

    try:
        # Sends an Email
        api_response = api_instance.send_mail(to, var_from, subject, body, id=id)
        print("The response of SendingApi->send_mail:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SendingApi->send_mail: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | [**SendMailTo**](SendMailTo.md)|  | 
 **var_from** | **str**| The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order. | 
 **subject** | **str**| The subject line of the email. | 
 **body** | **str**| The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | 
 **id** | **int**| Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Email accepted for delivery |  -  |
**400** | Bad request — one or more input parameters were missing or invalid. |  -  |
**401** | Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security). |  -  |
**404** | The specified resource was not found or does not belong to your account. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

