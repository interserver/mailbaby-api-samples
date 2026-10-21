# OAISendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**rawMail**](OAISendingApi.md#rawmail) | **POST** /mail/rawsend | Send a pre-built RFC 822 message verbatim (preserves DKIM)
[**sendAdvMail**](OAISendingApi.md#sendadvmail) | **POST** /mail/advsend | Send email with multiple recipients, CC/BCC, attachments, named contacts
[**sendMail**](OAISendingApi.md#sendmail) | **POST** /mail/send | Send a simple email (single recipient, plain or HTML)


# **rawMail**
```objc
-(NSURLSessionTask*) rawMailWithSendMailRaw: (OAISendMailRaw*) sendMailRaw
        completionHandler: (void (^)(OAIGenericResponse* output, NSError* error)) handler;
```

Send a pre-built RFC 822 message verbatim (preserves DKIM)

**Use this when you have already built (and possibly DKIM-signed) the full RFC 822 message yourself** and want the relay to transmit it byte-for-byte. Required: `raw_email` (full RFC 822 string with headers + body). Optional: `id` (mail order to authenticate as). Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact. If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. 

### Example
```objc
OAIDefaultConfiguration *apiConfig = [OAIDefaultConfiguration sharedConfig];

// Configure API key authorization: (authentication scheme: apiKeyAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-KEY"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-KEY"];


OAISendMailRaw* sendMailRaw = [[OAISendMailRaw alloc] init]; // 

OAISendingApi*apiInstance = [[OAISendingApi alloc] init];

// Send a pre-built RFC 822 message verbatim (preserves DKIM)
[apiInstance rawMailWithSendMailRaw:sendMailRaw
          completionHandler: ^(OAIGenericResponse* output, NSError* error) {
                        if (output) {
                            NSLog(@"%@", output);
                        }
                        if (error) {
                            NSLog(@"Error calling OAISendingApi->rawMail: %@", error);
                        }
                    }];
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sendMailRaw** | [**OAISendMailRaw***](OAISendMailRaw.md)|  | 

### Return type

[**OAIGenericResponse***](OAIGenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **sendAdvMail**
```objc
-(NSURLSessionTask*) sendAdvMailWithSubject: (NSString*) subject
    body: (NSString*) body
    from: (OAIEmailAddressTypes*) from
    to: (OAIEmailAddressesTypes*) to
    replyto: (OAIEmailAddressesTypes*) replyto
    cc: (OAIEmailAddressesTypes*) cc
    bcc: (OAIEmailAddressesTypes*) bcc
    attachments: (NSArray<OAIMailAttachment>*) attachments
    _id: (NSNumber*) _id
        completionHandler: (void (^)(OAIGenericResponse* output, NSError* error)) handler;
```

Send email with multiple recipients, CC/BCC, attachments, named contacts

**Use this when the simple send is not enough** — multiple recipients, CC/BCC, named contacts, custom Reply-To, or file attachments. Required: `from`, `to`, `subject`, `body`. Optional: `cc`, `bcc`, `replyto`, `attachments` (array of `{filename,data}` with base64 data), `id`. Sends through one of your mail orders with full control over recipients, headers, and attachments.  **Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `\"Joe <joe@example.com>, jane@example.com\"`) and the structured `[{\"email\":\"...\",\"name\":\"...\"}]` array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.  **Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.  ## Examples  ### Form — basic string addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d from=user@domain.com \\   -d to=support@interserver.net ``` ### Form — RFC 822 named addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d 'from=Joe <user@domain.com>' \\   -d 'to=Jane <support@interserver.net>' ``` ### Form — multiple recipients as array ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' -d 'body=Hello' \\   -d from=user@domain.com \\   -d 'to[0][name]=Joe' -d 'to[0][email]=support@interserver.net' \\   -d 'to[1][name]=Jane' -d 'to[1][email]=jane@interserver.net' ``` ### JSON — structured objects ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/json' \\   -d '{     \"subject\": \"Welcome\",     \"body\": \"<h1>Hello</h1>\",     \"from\": {\"email\": \"user@domain.com\", \"name\": \"Sender Name\"},     \"to\": [{\"email\": \"joe@client.com\", \"name\": \"Joe Client\"}],     \"cc\": [{\"email\": \"manager@client.com\"}],     \"attachments\": [{\"filename\": \"report.pdf\", \"data\": \"BASE64_DATA\"}]   }' ``` 

### Example
```objc
OAIDefaultConfiguration *apiConfig = [OAIDefaultConfiguration sharedConfig];

// Configure API key authorization: (authentication scheme: apiKeyAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-KEY"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-KEY"];


NSString* subject = @"subject_example"; // The subject line of the email.
NSString* body = @"body_example"; // The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
OAIEmailAddressTypes* from = [[OAIEmailAddressTypes alloc] init]; // The sender address.  Accepts a plain email string, an RFC 822 named string (`\\\"Name <email>\\\"`), or a `{\\\"email\\\": \\\"...\\\", \\\"name\\\": \\\"...\\\"}` object.
OAIEmailAddressesTypes* to = [[OAIEmailAddressesTypes alloc] init]; // One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
OAIEmailAddressesTypes* replyto = [[OAIEmailAddressesTypes alloc] init]; // Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`. (optional)
OAIEmailAddressesTypes* cc = [[OAIEmailAddressesTypes alloc] init]; // Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients. (optional)
OAIEmailAddressesTypes* bcc = [[OAIEmailAddressesTypes alloc] init]; // Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header. (optional)
NSArray<OAIMailAttachment>* attachments = @[[[OAIMailAttachment alloc] init]]; // Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name. (optional)
NSNumber* _id = @56; // Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. (optional)

OAISendingApi*apiInstance = [[OAISendingApi alloc] init];

// Send email with multiple recipients, CC/BCC, attachments, named contacts
[apiInstance sendAdvMailWithSubject:subject
              body:body
              from:from
              to:to
              replyto:replyto
              cc:cc
              bcc:bcc
              attachments:attachments
              _id:_id
          completionHandler: ^(OAIGenericResponse* output, NSError* error) {
                        if (output) {
                            NSLog(@"%@", output);
                        }
                        if (error) {
                            NSLog(@"Error calling OAISendingApi->sendAdvMail: %@", error);
                        }
                    }];
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **NSString***| The subject line of the email. | 
 **body** | **NSString***| The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | 
 **from** | [**OAIEmailAddressTypes***](OAIEmailAddressTypes.md)| The sender address.  Accepts a plain email string, an RFC 822 named string (&#x60;\\\&quot;Name &lt;email&gt;\\\&quot;&#x60;), or a &#x60;{\\\&quot;email\\\&quot;: \\\&quot;...\\\&quot;, \\\&quot;name\\\&quot;: \\\&quot;...\\\&quot;}&#x60; object. | 
 **to** | [**OAIEmailAddressesTypes***](OAIEmailAddressesTypes.md)| One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects. | 
 **replyto** | [**OAIEmailAddressesTypes***](OAIEmailAddressesTypes.md)| Optional.  One or more addresses to set as the &#x60;Reply-To&#x60; header. When recipients reply to the message their email client will address the reply to these addresses instead of &#x60;from&#x60;. | [optional] 
 **cc** | [**OAIEmailAddressesTypes***](OAIEmailAddressesTypes.md)| Optional.  Carbon-copy recipients.  These addresses are listed in the &#x60;Cc&#x60; header and are visible to all recipients. | [optional] 
 **bcc** | [**OAIEmailAddressesTypes***](OAIEmailAddressesTypes.md)| Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header. | [optional] 
 **attachments** | [**NSArray&lt;OAIMailAttachment&gt;***](OAIMailAttachment*.md)| Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name. | [optional] 
 **_id** | **NSNumber***| Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] 

### Return type

[**OAIGenericResponse***](OAIGenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **sendMail**
```objc
-(NSURLSessionTask*) sendMailWithTo: (OAISendMailTo*) to
    from: (NSString*) from
    subject: (NSString*) subject
    body: (NSString*) body
    _id: (NSNumber*) _id
        completionHandler: (void (^)(OAIGenericResponse* output, NSError* error)) handler;
```

Send a simple email (single recipient, plain or HTML)

**Use this for the simplest case** — one or a few plain-string recipients, no attachments, no CC/BCC, no named contacts. Required: `from`, `to`, `subject`, `body`. Optional: `id` (selects which mail order to send through; auto-selects your first active order if omitted). Sends through one of your mail orders using a flat set of fields.  **HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.  The `from` address is also automatically set as the `Reply-To` header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. 

### Example
```objc
OAIDefaultConfiguration *apiConfig = [OAIDefaultConfiguration sharedConfig];

// Configure API key authorization: (authentication scheme: apiKeyAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-KEY"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-KEY"];


OAISendMailTo* to = [[OAISendMailTo alloc] init]; // 
NSString* from = @"from_example"; // The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.
NSString* subject = @"subject_example"; // The subject line of the email.
NSString* body = @"body_example"; // The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
NSNumber* _id = @56; // Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. (optional)

OAISendingApi*apiInstance = [[OAISendingApi alloc] init];

// Send a simple email (single recipient, plain or HTML)
[apiInstance sendMailWithTo:to
              from:from
              subject:subject
              body:body
              _id:_id
          completionHandler: ^(OAIGenericResponse* output, NSError* error) {
                        if (output) {
                            NSLog(@"%@", output);
                        }
                        if (error) {
                            NSLog(@"Error calling OAISendingApi->sendMail: %@", error);
                        }
                    }];
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | [**OAISendMailTo***](OAISendMailTo.md)|  | 
 **from** | **NSString***| The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order. | 
 **subject** | **NSString***| The subject line of the email. | 
 **body** | **NSString***| The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | 
 **_id** | **NSNumber***| Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] 

### Return type

[**OAIGenericResponse***](OAIGenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

