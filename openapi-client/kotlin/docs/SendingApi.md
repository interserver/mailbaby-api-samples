# SendingApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**sendAdvMail**](SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options |
| [**sendMail**](SendingApi.md#sendMail) | **POST** /mail/send | Sends an Email |


<a id="sendAdvMail"></a>
# **sendAdvMail**
> GenericResponse sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60;BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ --data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ --data \&quot;to[1][name]&#x3D;Joe\&quot; \\ --data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/json&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#39; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/json&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#39; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/json&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#39; &#x60;&#x60;&#x60; 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = SendingApi()
val subject : kotlin.String = subject_example // kotlin.String | The subject or title of the email
val body : kotlin.String = body_example // kotlin.String | The main email contents.
val from : EmailAddressTypes =  // EmailAddressTypes | 
val to : EmailAddressesTypes =  // EmailAddressesTypes | 
val replyto : EmailAddressesTypes =  // EmailAddressesTypes | 
val cc : EmailAddressesTypes =  // EmailAddressesTypes | 
val bcc : EmailAddressesTypes =  // EmailAddressesTypes | 
val attachments : kotlin.collections.List<MailAttachment> =  // kotlin.collections.List<MailAttachment> | (optional) File attachments to include in the email.  The file contents must be base64 encoded!
val id : kotlin.Long = 789 // kotlin.Long | (optional)  ID of the Mail order within our system to use as the Mail Account.
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
| **subject** | **kotlin.String**| The subject or title of the email | |
| **body** | **kotlin.String**| The main email contents. | |
| **from** | [**EmailAddressTypes**](EmailAddressTypes.md)|  | |
| **to** | [**EmailAddressesTypes**](EmailAddressesTypes.md)|  | |
| **replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md)|  | [optional] |
| **cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md)|  | [optional] |
| **bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md)|  | [optional] |
| **attachments** | [**kotlin.collections.List&lt;MailAttachment&gt;**](MailAttachment.md)| (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.Long**| (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a id="sendMail"></a>
# **sendMail**
> GenericResponse sendMail(to, from, subject, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = SendingApi()
val to : kotlin.String = to_example // kotlin.String | The Contact whom is the primary recipient of this email.
val from : kotlin.String = from_example // kotlin.String | The contact whom is the this email is from.
val subject : kotlin.String = subject_example // kotlin.String | The subject or title of the email
val body : kotlin.String = body_example // kotlin.String | The main email contents.
try {
    val result : GenericResponse = apiInstance.sendMail(to, from, subject, body)
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
| **to** | **kotlin.String**| The Contact whom is the primary recipient of this email. | |
| **from** | **kotlin.String**| The contact whom is the this email is from. | |
| **subject** | **kotlin.String**| The subject or title of the email | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | **kotlin.String**| The main email contents. | |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

