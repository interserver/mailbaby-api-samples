# SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**rawMail**](SendingApi.md#rawMail) | **POST** /mail/rawsend | Sends a raw RFC 822 email
[**sendAdvMail**](SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](SendingApi.md#sendMail) | **POST** /mail/send | Sends an Email

<a name="rawMail"></a>
# **rawMail**
> GenericResponse rawMail(body)

Sends a raw RFC 822 email

Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact.  If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The &#x60;From&#x60; and recipient addresses are parsed automatically from the message headers (&#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, &#x60;Bcc&#x60;).  You do **not** need to specify them separately.  If an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SendingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKeyAuth
ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
apiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.setApiKeyPrefix("Token");

SendingApi apiInstance = new SendingApi();
SendMailRaw body = new SendMailRaw(); // SendMailRaw | 
try {
    GenericResponse result = apiInstance.rawMail(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SendingApi#rawMail");
    e.printStackTrace();
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

<a name="rawMail"></a>
# **rawMail**
> GenericResponse rawMail(rawEmail, id)

Sends a raw RFC 822 email

Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact.  If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The &#x60;From&#x60; and recipient addresses are parsed automatically from the message headers (&#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, &#x60;Bcc&#x60;).  You do **not** need to specify them separately.  If an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SendingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKeyAuth
ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
apiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.setApiKeyPrefix("Token");

SendingApi apiInstance = new SendingApi();
String rawEmail = "rawEmail_example"; // String | 
Long id = 789L; // Long | 
try {
    GenericResponse result = apiInstance.rawMail(rawEmail, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SendingApi#rawMail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rawEmail** | **String**|  |
 **id** | **Long**|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

<a name="sendAdvMail"></a>
# **sendAdvMail**
> GenericResponse sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id)

Sends an Email with Advanced Options

Sends an email through one of your mail orders with full control over recipients, headers, and attachments.  Supports multiple To / CC / BCC addresses, named contacts, Reply-To overrides, and base64-encoded file attachments.  **Content-type flexibility** — the request body may be submitted as either &#x60;application/x-www-form-urlencoded&#x60; or &#x60;application/json&#x60;.  When using form encoding, address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) accept both a plain RFC 822 comma-separated string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;, jane@example.com\&quot;&#x60;) and the structured &#x60;[{\&quot;email\&quot;:\&quot;...\&quot;,\&quot;name\&quot;:\&quot;...\&quot;}]&#x60; array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if &#x60;body&#x60; contains HTML tags the &#x60;Content-Type&#x60; is set to &#x60;text/html&#x60;; otherwise &#x60;text/plain&#x60;.  **Attachments** must be base64-encoded.  Each attachment requires at least a &#x60;data&#x60; field; the optional &#x60;filename&#x60; field controls the attachment name shown to recipients.  If an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response &#x60;text&#x60; field contains the relay transaction ID which can be looked up in &#x60;GET /mail/log&#x60; via the &#x60;mailid&#x60; query parameter.  ## Examples  ### Form — basic string addresses &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\   -d &#x27;subject&#x3D;Welcome&#x27; \\   -d &#x27;body&#x3D;Hello&#x27; \\   -d from&#x3D;user@domain.com \\   -d to&#x3D;support@interserver.net &#x60;&#x60;&#x60; ### Form — RFC 822 named addresses &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\   -d &#x27;subject&#x3D;Welcome&#x27; \\   -d &#x27;body&#x3D;Hello&#x27; \\   -d &#x27;from&#x3D;Joe &lt;user@domain.com&gt;&#x27; \\   -d &#x27;to&#x3D;Jane &lt;support@interserver.net&gt;&#x27; &#x60;&#x60;&#x60; ### Form — multiple recipients as array &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\   -d &#x27;subject&#x3D;Welcome&#x27; -d &#x27;body&#x3D;Hello&#x27; \\   -d from&#x3D;user@domain.com \\   -d &#x27;to[0][name]&#x3D;Joe&#x27; -d &#x27;to[0][email]&#x3D;support@interserver.net&#x27; \\   -d &#x27;to[1][name]&#x3D;Jane&#x27; -d &#x27;to[1][email]&#x3D;jane@interserver.net&#x27; &#x60;&#x60;&#x60; ### JSON — structured objects &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -d &#x27;{     \&quot;subject\&quot;: \&quot;Welcome\&quot;,     \&quot;body\&quot;: \&quot;&lt;h1&gt;Hello&lt;/h1&gt;\&quot;,     \&quot;from\&quot;: {\&quot;email\&quot;: \&quot;user@domain.com\&quot;, \&quot;name\&quot;: \&quot;Sender Name\&quot;},     \&quot;to\&quot;: [{\&quot;email\&quot;: \&quot;joe@client.com\&quot;, \&quot;name\&quot;: \&quot;Joe Client\&quot;}],     \&quot;cc\&quot;: [{\&quot;email\&quot;: \&quot;manager@client.com\&quot;}],     \&quot;attachments\&quot;: [{\&quot;filename\&quot;: \&quot;report.pdf\&quot;, \&quot;data\&quot;: \&quot;BASE64_DATA\&quot;}]   }&#x27; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SendingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKeyAuth
ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
apiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.setApiKeyPrefix("Token");

SendingApi apiInstance = new SendingApi();
String subject = "subject_example"; // String | 
String body = "body_example"; // String | 
EmailAddressTypes from = new EmailAddressTypes(); // EmailAddressTypes | 
EmailAddressesTypes to = new EmailAddressesTypes(); // EmailAddressesTypes | 
EmailAddressesTypes replyto = new EmailAddressesTypes(); // EmailAddressesTypes | 
EmailAddressesTypes cc = new EmailAddressesTypes(); // EmailAddressesTypes | 
EmailAddressesTypes bcc = new EmailAddressesTypes(); // EmailAddressesTypes | 
List<MailAttachment> attachments = Arrays.asList(new MailAttachment()); // List<MailAttachment> | 
Long id = 789L; // Long | 
try {
    GenericResponse result = apiInstance.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SendingApi#sendAdvMail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **String**|  |
 **body** | **String**|  |
 **from** | [**EmailAddressTypes**](.md)|  |
 **to** | [**EmailAddressesTypes**](.md)|  |
 **replyto** | [**EmailAddressesTypes**](.md)|  |
 **cc** | [**EmailAddressesTypes**](.md)|  |
 **bcc** | [**EmailAddressesTypes**](.md)|  |
 **attachments** | [**List&lt;MailAttachment&gt;**](MailAttachment.md)|  |
 **id** | **Long**|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

<a name="sendAdvMail"></a>
# **sendAdvMail**
> GenericResponse sendAdvMail(body)

Sends an Email with Advanced Options

Sends an email through one of your mail orders with full control over recipients, headers, and attachments.  Supports multiple To / CC / BCC addresses, named contacts, Reply-To overrides, and base64-encoded file attachments.  **Content-type flexibility** — the request body may be submitted as either &#x60;application/x-www-form-urlencoded&#x60; or &#x60;application/json&#x60;.  When using form encoding, address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) accept both a plain RFC 822 comma-separated string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;, jane@example.com\&quot;&#x60;) and the structured &#x60;[{\&quot;email\&quot;:\&quot;...\&quot;,\&quot;name\&quot;:\&quot;...\&quot;}]&#x60; array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if &#x60;body&#x60; contains HTML tags the &#x60;Content-Type&#x60; is set to &#x60;text/html&#x60;; otherwise &#x60;text/plain&#x60;.  **Attachments** must be base64-encoded.  Each attachment requires at least a &#x60;data&#x60; field; the optional &#x60;filename&#x60; field controls the attachment name shown to recipients.  If an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response &#x60;text&#x60; field contains the relay transaction ID which can be looked up in &#x60;GET /mail/log&#x60; via the &#x60;mailid&#x60; query parameter.  ## Examples  ### Form — basic string addresses &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\   -d &#x27;subject&#x3D;Welcome&#x27; \\   -d &#x27;body&#x3D;Hello&#x27; \\   -d from&#x3D;user@domain.com \\   -d to&#x3D;support@interserver.net &#x60;&#x60;&#x60; ### Form — RFC 822 named addresses &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\   -d &#x27;subject&#x3D;Welcome&#x27; \\   -d &#x27;body&#x3D;Hello&#x27; \\   -d &#x27;from&#x3D;Joe &lt;user@domain.com&gt;&#x27; \\   -d &#x27;to&#x3D;Jane &lt;support@interserver.net&gt;&#x27; &#x60;&#x60;&#x60; ### Form — multiple recipients as array &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\   -d &#x27;subject&#x3D;Welcome&#x27; -d &#x27;body&#x3D;Hello&#x27; \\   -d from&#x3D;user@domain.com \\   -d &#x27;to[0][name]&#x3D;Joe&#x27; -d &#x27;to[0][email]&#x3D;support@interserver.net&#x27; \\   -d &#x27;to[1][name]&#x3D;Jane&#x27; -d &#x27;to[1][email]&#x3D;jane@interserver.net&#x27; &#x60;&#x60;&#x60; ### JSON — structured objects &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -d &#x27;{     \&quot;subject\&quot;: \&quot;Welcome\&quot;,     \&quot;body\&quot;: \&quot;&lt;h1&gt;Hello&lt;/h1&gt;\&quot;,     \&quot;from\&quot;: {\&quot;email\&quot;: \&quot;user@domain.com\&quot;, \&quot;name\&quot;: \&quot;Sender Name\&quot;},     \&quot;to\&quot;: [{\&quot;email\&quot;: \&quot;joe@client.com\&quot;, \&quot;name\&quot;: \&quot;Joe Client\&quot;}],     \&quot;cc\&quot;: [{\&quot;email\&quot;: \&quot;manager@client.com\&quot;}],     \&quot;attachments\&quot;: [{\&quot;filename\&quot;: \&quot;report.pdf\&quot;, \&quot;data\&quot;: \&quot;BASE64_DATA\&quot;}]   }&#x27; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SendingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKeyAuth
ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
apiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.setApiKeyPrefix("Token");

SendingApi apiInstance = new SendingApi();
SendMailAdv body = new SendMailAdv(); // SendMailAdv | 
try {
    GenericResponse result = apiInstance.sendAdvMail(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SendingApi#sendAdvMail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SendMailAdv**](SendMailAdv.md)|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

<a name="sendMail"></a>
# **sendMail**
> GenericResponse sendMail(to, from, subject, body, id)

Sends an Email

Sends an email through one of your mail orders using a simple flat set of fields. This is the quickest way to send a single-recipient plain-text or HTML message.  **HTML detection** is automatic — if the &#x60;body&#x60; value contains any HTML tags the message will be sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is also automatically set as the &#x60;Reply-To&#x60; header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use &#x60;POST /mail/advsend&#x60; instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use &#x60;POST /mail/rawsend&#x60;.  On success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SendingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKeyAuth
ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
apiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.setApiKeyPrefix("Token");

SendingApi apiInstance = new SendingApi();
SendMailTo to = new SendMailTo(); // SendMailTo | 
String from = "from_example"; // String | 
String subject = "subject_example"; // String | 
String body = "body_example"; // String | 
Long id = 789L; // Long | 
try {
    GenericResponse result = apiInstance.sendMail(to, from, subject, body, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SendingApi#sendMail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | [**SendMailTo**](.md)|  |
 **from** | **String**|  |
 **subject** | **String**|  |
 **body** | **String**|  |
 **id** | **Long**|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

<a name="sendMail"></a>
# **sendMail**
> GenericResponse sendMail(body)

Sends an Email

Sends an email through one of your mail orders using a simple flat set of fields. This is the quickest way to send a single-recipient plain-text or HTML message.  **HTML detection** is automatic — if the &#x60;body&#x60; value contains any HTML tags the message will be sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is also automatically set as the &#x60;Reply-To&#x60; header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use &#x60;POST /mail/advsend&#x60; instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use &#x60;POST /mail/rawsend&#x60;.  On success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SendingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKeyAuth
ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
apiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.setApiKeyPrefix("Token");

SendingApi apiInstance = new SendingApi();
SendMail body = new SendMail(); // SendMail | 
try {
    GenericResponse result = apiInstance.sendMail(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SendingApi#sendMail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SendMail**](SendMail.md)|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

