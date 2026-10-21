# MailBabyCsharp.Api.SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**RawMail**](SendingApi.md#rawmail) | **POST** /mail/rawsend | Send a pre-built RFC 822 message verbatim (preserves DKIM)
[**SendAdvMail**](SendingApi.md#sendadvmail) | **POST** /mail/advsend | Send email with multiple recipients, CC/BCC, attachments, named contacts
[**SendMail**](SendingApi.md#sendmail) | **POST** /mail/send | Send a simple email (single recipient, plain or HTML)

<a name="rawmail"></a>
# **RawMail**
> GenericResponse RawMail (SendMailRaw body)

Send a pre-built RFC 822 message verbatim (preserves DKIM)

**Use this when you have already built (and possibly DKIM-signed) the full RFC 822 message yourself** and want the relay to transmit it byte-for-byte. Required: `raw_email` (full RFC 822 string with headers + body). Optional: `id` (mail order to authenticate as). Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact. If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. 

### Example
```csharp
using System;
using System.Diagnostics;
using MailBabyCsharp.Api;
using MailBabyCsharp.Client;
using MailBabyCsharp.Model;

namespace Example
{
    public class RawMailExample
    {
        public void main()
        {
            // Configure API key authorization: apiKeyAuth
            Configuration.Default.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new SendingApi();
            var body = new SendMailRaw(); // SendMailRaw | 

            try
            {
                // Send a pre-built RFC 822 message verbatim (preserves DKIM)
                GenericResponse result = apiInstance.RawMail(body);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling SendingApi.RawMail: " + e.Message );
            }
        }
    }
}
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
<a name="sendadvmail"></a>
# **SendAdvMail**
> GenericResponse SendAdvMail (string subject, string body, Object from, Object to, Object replyto, Object cc, Object bcc, List<MailAttachment> attachments, long? id)

Send email with multiple recipients, CC/BCC, attachments, named contacts

**Use this when the simple send is not enough** — multiple recipients, CC/BCC, named contacts, custom Reply-To, or file attachments. Required: `from`, `to`, `subject`, `body`. Optional: `cc`, `bcc`, `replyto`, `attachments` (array of `{filename,data}` with base64 data), `id`. Sends through one of your mail orders with full control over recipients, headers, and attachments.  **Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `\"Joe <joe@example.com>, jane@example.com\"`) and the structured `[{\"email\":\"...\",\"name\":\"...\"}]` array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.  **Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.  ## Examples  ### Form — basic string addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d from=user@domain.com \\   -d to=support@interserver.net ``` ### Form — RFC 822 named addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d 'from=Joe <user@domain.com>' \\   -d 'to=Jane <support@interserver.net>' ``` ### Form — multiple recipients as array ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' -d 'body=Hello' \\   -d from=user@domain.com \\   -d 'to[0][name]=Joe' -d 'to[0][email]=support@interserver.net' \\   -d 'to[1][name]=Jane' -d 'to[1][email]=jane@interserver.net' ``` ### JSON — structured objects ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/json' \\   -d '{     \"subject\": \"Welcome\",     \"body\": \"<h1>Hello</h1>\",     \"from\": {\"email\": \"user@domain.com\", \"name\": \"Sender Name\"},     \"to\": [{\"email\": \"joe@client.com\", \"name\": \"Joe Client\"}],     \"cc\": [{\"email\": \"manager@client.com\"}],     \"attachments\": [{\"filename\": \"report.pdf\", \"data\": \"BASE64_DATA\"}]   }' ``` 

### Example
```csharp
using System;
using System.Diagnostics;
using MailBabyCsharp.Api;
using MailBabyCsharp.Client;
using MailBabyCsharp.Model;

namespace Example
{
    public class SendAdvMailExample
    {
        public void main()
        {
            // Configure API key authorization: apiKeyAuth
            Configuration.Default.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new SendingApi();
            var subject = subject_example;  // string | 
            var body = body_example;  // string | 
            var from = new Object(); // Object | 
            var to = new Object(); // Object | 
            var replyto = new Object(); // Object | 
            var cc = new Object(); // Object | 
            var bcc = new Object(); // Object | 
            var attachments = new List<MailAttachment>(); // List<MailAttachment> | 
            var id = 789;  // long? | 

            try
            {
                // Send email with multiple recipients, CC/BCC, attachments, named contacts
                GenericResponse result = apiInstance.SendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling SendingApi.SendAdvMail: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **string**|  | 
 **body** | **string**|  | 
 **from** | [**Object**](Object.md)|  | 
 **to** | [**Object**](Object.md)|  | 
 **replyto** | [**Object**](Object.md)|  | 
 **cc** | [**Object**](Object.md)|  | 
 **bcc** | [**Object**](Object.md)|  | 
 **attachments** | [**List&lt;MailAttachment&gt;**](MailAttachment.md)|  | 
 **id** | **long?**|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
<a name="sendmail"></a>
# **SendMail**
> GenericResponse SendMail (SendMailTo to, string from, string subject, string body, long? id)

Send a simple email (single recipient, plain or HTML)

**Use this for the simplest case** — one or a few plain-string recipients, no attachments, no CC/BCC, no named contacts. Required: `from`, `to`, `subject`, `body`. Optional: `id` (selects which mail order to send through; auto-selects your first active order if omitted). Sends through one of your mail orders using a flat set of fields.  **HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.  The `from` address is also automatically set as the `Reply-To` header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. 

### Example
```csharp
using System;
using System.Diagnostics;
using MailBabyCsharp.Api;
using MailBabyCsharp.Client;
using MailBabyCsharp.Model;

namespace Example
{
    public class SendMailExample
    {
        public void main()
        {
            // Configure API key authorization: apiKeyAuth
            Configuration.Default.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new SendingApi();
            var to = new SendMailTo(); // SendMailTo | 
            var from = from_example;  // string | 
            var subject = subject_example;  // string | 
            var body = body_example;  // string | 
            var id = 789;  // long? | 

            try
            {
                // Send a simple email (single recipient, plain or HTML)
                GenericResponse result = apiInstance.SendMail(to, from, subject, body, id);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling SendingApi.SendMail: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | [**SendMailTo**](SendMailTo.md)|  | 
 **from** | **string**|  | 
 **subject** | **string**|  | 
 **body** | **string**|  | 
 **id** | **long?**|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
