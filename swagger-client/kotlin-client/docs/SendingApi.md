# SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**rawMail**](SendingApi.md#rawMail) | **POST** /mail/rawsend | Sends a raw email
[**sendAdvMail**](SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](SendingApi.md#sendMail) | **POST** /mail/send | Sends an Email

<a name="rawMail"></a>
# **rawMail**
> GenericResponse rawMail(body)

Sends a raw email

This call will let you pass the raw / complete email contents (including headers) as a string and have it get sent as-is.  This is useful for things like DKIM signed messages.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
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

Sends a raw email

This call will let you pass the raw / complete email contents (including headers) as a string and have it get sent as-is.  This is useful for things like DKIM signed messages.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = SendingApi()
val rawEmail : kotlin.String = rawEmail_example // kotlin.String | 
val id : kotlin.Int = 56 // kotlin.Int | 
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
 **id** | **kotlin.Int**|  |

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

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60;BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ --data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ --data \&quot;to[1][name]&#x3D;Joe\&quot; \\ --data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#x27; &#x60;&#x60;&#x60; 

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
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

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60;BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ --data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ --data \&quot;to[1][name]&#x3D;Joe\&quot; \\ --data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#x27; &#x60;&#x60;&#x60; 

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = SendingApi()
val body : SendMailAdv = {
  "value" : {
    "subject" : "Welcome",
    "body" : "Hello",
    "from" : {
      "email" : "user@domain.com"
    },
    "to" : [ {
      "email" : "someone@client.com",
      "name" : "Mr Client"
    } ],
    "attachments" : [ {
      "filename" : "message.txt",
      "data" : "base64_encoded_contents"
    } ],
    "id" : 66
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

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = SendingApi()
val to : kotlin.String = to_example // kotlin.String | 
val from : kotlin.String = from_example // kotlin.String | 
val subject : kotlin.String = subject_example // kotlin.String | 
val body : kotlin.String = body_example // kotlin.String | 
val id : kotlin.Int = 56 // kotlin.Int | 
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
 **to** | **kotlin.String**|  |
 **from** | **kotlin.String**|  |
 **subject** | **kotlin.String**|  |
 **body** | **kotlin.String**|  |
 **id** | **kotlin.Int**|  |

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

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
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

