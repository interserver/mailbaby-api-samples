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
```kotlin
// Import classes:
//import mailbaby-client-kotlin-client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = SendingApi()
val body : SendMailRaw =  // SendMailRaw | 
try {
    val result : GenericResponse = apiInstance.rawMail(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SendingApi#rawMail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SendingApi#rawMail")
    e.printStackTrace()
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
```kotlin
// Import classes:
//import mailbaby-client-kotlin-client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = SendingApi()
val rawEmail : kotlin.String = rawEmail_example // kotlin.String | 
val id : kotlin.Long = 789 // kotlin.Long | 
try {
    val result : GenericResponse = apiInstance.rawMail(rawEmail, id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SendingApi#rawMail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SendingApi#rawMail")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rawEmail** | **kotlin.String**|  |
 **id** | **kotlin.Long**|  |

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
```kotlin
// Import classes:
//import mailbaby-client-kotlin-client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = SendingApi()
val subject : kotlin.String = subject_example // kotlin.String | 
val body : kotlin.String = body_example // kotlin.String | 
val from : EmailAddressTypes =  // EmailAddressTypes | 
val to : EmailAddressesTypes =  // EmailAddressesTypes | 
val replyto : EmailAddressesTypes =  // EmailAddressesTypes | 
val cc : EmailAddressesTypes =  // EmailAddressesTypes | 
val bcc : EmailAddressesTypes =  // EmailAddressesTypes | 
val attachments : kotlin.Array<MailAttachment> =  // kotlin.Array<MailAttachment> | 
val id : kotlin.Long = 789 // kotlin.Long | 
try {
    val result : GenericResponse = apiInstance.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SendingApi#sendAdvMail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SendingApi#sendAdvMail")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **kotlin.String**|  |
 **body** | **kotlin.String**|  |
 **from** | [**EmailAddressTypes**](.md)|  |
 **to** | [**EmailAddressesTypes**](.md)|  |
 **replyto** | [**EmailAddressesTypes**](.md)|  |
 **cc** | [**EmailAddressesTypes**](.md)|  |
 **bcc** | [**EmailAddressesTypes**](.md)|  |
 **attachments** | [**kotlin.Array&lt;MailAttachment&gt;**](MailAttachment.md)|  |
 **id** | **kotlin.Long**|  |

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
```kotlin
// Import classes:
//import mailbaby-client-kotlin-client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = SendingApi()
val body : SendMailAdv = {
  "summary" : "Simple string addresses",
  "value" : {
    "subject" : "Welcome",
    "body" : "Hello",
    "from" : "user@domain.com",
    "to" : "support@interserver.net"
  }
} // SendMailAdv | 
try {
    val result : GenericResponse = apiInstance.sendAdvMail(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SendingApi#sendAdvMail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SendingApi#sendAdvMail")
    e.printStackTrace()
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
```kotlin
// Import classes:
//import mailbaby-client-kotlin-client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = SendingApi()
val to : kotlin.Any =  // kotlin.Any | 
val from : kotlin.String = from_example // kotlin.String | 
val subject : kotlin.String = subject_example // kotlin.String | 
val body : kotlin.String = body_example // kotlin.String | 
val id : kotlin.Long = 789 // kotlin.Long | 
try {
    val result : GenericResponse = apiInstance.sendMail(to, from, subject, body, id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SendingApi#sendMail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SendingApi#sendMail")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | [**kotlin.Any**](.md)|  |
 **from** | **kotlin.String**|  |
 **subject** | **kotlin.String**|  |
 **body** | **kotlin.String**|  |
 **id** | **kotlin.Long**|  |

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
```kotlin
// Import classes:
//import mailbaby-client-kotlin-client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = SendingApi()
val body : SendMail =  // SendMail | 
try {
    val result : GenericResponse = apiInstance.sendMail(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SendingApi#sendMail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SendingApi#sendMail")
    e.printStackTrace()
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

