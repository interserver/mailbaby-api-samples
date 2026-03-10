# mailbaby-client-python.SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**raw_mail**](SendingApi.md#raw_mail) | **POST** /mail/rawsend | Sends a raw RFC 822 email
[**send_adv_mail**](SendingApi.md#send_adv_mail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**send_mail**](SendingApi.md#send_mail) | **POST** /mail/send | Sends an Email

# **raw_mail**
> GenericResponse raw_mail(body)

Sends a raw RFC 822 email

Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact.  If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. 

### Example
```python
from __future__ import print_function
import time
import mailbaby-client-python
from mailbaby-client-python.rest import ApiException
from pprint import pprint

# Configure API key authorization: apiKeyAuth
configuration = mailbaby-client-python.Configuration()
configuration.api_key['X-API-KEY'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['X-API-KEY'] = 'Bearer'

# create an instance of the API class
api_instance = mailbaby-client-python.SendingApi(mailbaby-client-python.ApiClient(configuration))
body = mailbaby-client-python.SendMailRaw() # SendMailRaw | 

try:
    # Sends a raw RFC 822 email
    api_response = api_instance.raw_mail(body)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling SendingApi->raw_mail: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SendMailRaw**](SendMailRaw.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_adv_mail**
> GenericResponse send_adv_mail(subject, body, _from, to, replyto, cc, bcc, attachments, id)

Sends an Email with Advanced Options

Sends an email through one of your mail orders with full control over recipients, headers, and attachments.  Supports multiple To / CC / BCC addresses, named contacts, Reply-To overrides, and base64-encoded file attachments.  **Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `\"Joe <joe@example.com>, jane@example.com\"`) and the structured `[{\"email\":\"...\",\"name\":\"...\"}]` array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.  **Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.  ## Examples  ### Form — basic string addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d from=user@domain.com \\   -d to=support@interserver.net ``` ### Form — RFC 822 named addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d 'from=Joe <user@domain.com>' \\   -d 'to=Jane <support@interserver.net>' ``` ### Form — multiple recipients as array ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' -d 'body=Hello' \\   -d from=user@domain.com \\   -d 'to[0][name]=Joe' -d 'to[0][email]=support@interserver.net' \\   -d 'to[1][name]=Jane' -d 'to[1][email]=jane@interserver.net' ``` ### JSON — structured objects ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/json' \\   -d '{     \"subject\": \"Welcome\",     \"body\": \"<h1>Hello</h1>\",     \"from\": {\"email\": \"user@domain.com\", \"name\": \"Sender Name\"},     \"to\": [{\"email\": \"joe@client.com\", \"name\": \"Joe Client\"}],     \"cc\": [{\"email\": \"manager@client.com\"}],     \"attachments\": [{\"filename\": \"report.pdf\", \"data\": \"BASE64_DATA\"}]   }' ``` 

### Example
```python
from __future__ import print_function
import time
import mailbaby-client-python
from mailbaby-client-python.rest import ApiException
from pprint import pprint

# Configure API key authorization: apiKeyAuth
configuration = mailbaby-client-python.Configuration()
configuration.api_key['X-API-KEY'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['X-API-KEY'] = 'Bearer'

# create an instance of the API class
api_instance = mailbaby-client-python.SendingApi(mailbaby-client-python.ApiClient(configuration))
subject = 'subject_example' # str | 
body = 'body_example' # str | 
_from = mailbaby-client-python.EmailAddressTypes() # EmailAddressTypes | 
to = mailbaby-client-python.EmailAddressesTypes() # EmailAddressesTypes | 
replyto = mailbaby-client-python.EmailAddressesTypes() # EmailAddressesTypes | 
cc = mailbaby-client-python.EmailAddressesTypes() # EmailAddressesTypes | 
bcc = mailbaby-client-python.EmailAddressesTypes() # EmailAddressesTypes | 
attachments = [mailbaby-client-python.MailAttachment()] # list[MailAttachment] | 
id = 789 # int | 

try:
    # Sends an Email with Advanced Options
    api_response = api_instance.send_adv_mail(subject, body, _from, to, replyto, cc, bcc, attachments, id)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling SendingApi->send_adv_mail: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **str**|  | 
 **body** | **str**|  | 
 **_from** | [**EmailAddressTypes**](.md)|  | 
 **to** | [**EmailAddressesTypes**](.md)|  | 
 **replyto** | [**EmailAddressesTypes**](.md)|  | 
 **cc** | [**EmailAddressesTypes**](.md)|  | 
 **bcc** | [**EmailAddressesTypes**](.md)|  | 
 **attachments** | [**list[MailAttachment]**](MailAttachment.md)|  | 
 **id** | **int**|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_mail**
> GenericResponse send_mail(to, _from, subject, body, id)

Sends an Email

Sends an email through one of your mail orders using a simple flat set of fields. This is the quickest way to send a single-recipient plain-text or HTML message.  **HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.  The `from` address is also automatically set as the `Reply-To` header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. 

### Example
```python
from __future__ import print_function
import time
import mailbaby-client-python
from mailbaby-client-python.rest import ApiException
from pprint import pprint

# Configure API key authorization: apiKeyAuth
configuration = mailbaby-client-python.Configuration()
configuration.api_key['X-API-KEY'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['X-API-KEY'] = 'Bearer'

# create an instance of the API class
api_instance = mailbaby-client-python.SendingApi(mailbaby-client-python.ApiClient(configuration))
to = mailbaby-client-python.SendMailTo() # SendMailTo | 
_from = '_from_example' # str | 
subject = 'subject_example' # str | 
body = 'body_example' # str | 
id = 789 # int | 

try:
    # Sends an Email
    api_response = api_instance.send_mail(to, _from, subject, body, id)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling SendingApi->send_mail: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | [**SendMailTo**](.md)|  | 
 **_from** | **str**|  | 
 **subject** | **str**|  | 
 **body** | **str**|  | 
 **id** | **int**|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

