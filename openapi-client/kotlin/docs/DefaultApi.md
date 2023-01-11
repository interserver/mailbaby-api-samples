# DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailOrders**](DefaultApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders
[**pingServer**](DefaultApi.md#pingServer) | **GET** /ping | Checks if the server is running
[**sendAdvMail**](DefaultApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](DefaultApi.md#sendMail) | **POST** /mail/send | Sends an Email
[**viewMailLog**](DefaultApi.md#viewMailLog) | **GET** /mail/log | displays the mail log


<a name="getMailOrders"></a>
# **getMailOrders**
> kotlin.collections.List&lt;GetMailOrders200ResponseInner&gt; getMailOrders()

displays a list of mail service orders

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
try {
    val result : kotlin.collections.List<GetMailOrders200ResponseInner> = apiInstance.getMailOrders()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#getMailOrders")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#getMailOrders")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;GetMailOrders200ResponseInner&gt;**](GetMailOrders200ResponseInner.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pingServer"></a>
# **pingServer**
> pingServer()

Checks if the server is running

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
try {
    apiInstance.pingServer()
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#pingServer")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#pingServer")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="sendAdvMail"></a>
# **sendAdvMail**
> GenericResponse sendAdvMail(sendMailAdv)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val sendMailAdv : SendMailAdv =  // SendMailAdv | 
try {
    val result : GenericResponse = apiInstance.sendAdvMail(sendMailAdv)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#sendAdvMail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#sendAdvMail")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sendMailAdv** | [**SendMailAdv**](SendMailAdv.md)|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="sendMail"></a>
# **sendMail**
> GenericResponse sendMail(to, from, subject, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val to : kotlin.String = to_example // kotlin.String | The Contact whom is the primary recipient of this email.
val from : kotlin.String = from_example // kotlin.String | The contact whom is the this email is from.
val subject : kotlin.String = subject_example // kotlin.String | The subject or title of the email
val body : kotlin.String = body_example // kotlin.String | The main email contents.
try {
    val result : GenericResponse = apiInstance.sendMail(to, from, subject, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#sendMail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#sendMail")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **kotlin.String**| The Contact whom is the primary recipient of this email. |
 **from** | **kotlin.String**| The contact whom is the this email is from. |
 **subject** | **kotlin.String**| The subject or title of the email |
 **body** | **kotlin.String**| The main email contents. |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="viewMailLog"></a>
# **viewMailLog**
> MailLog viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate)

displays the mail log

Get a listing of the emails sent through this system 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val id : kotlin.Long = 2604 // kotlin.Long | The ID of your mail order this will be sent through.
val origin : kotlin.String = 1.2.3.4 // kotlin.String | originating ip address sending mail
val mx : kotlin.String = mx.google.com // kotlin.String | mx record mail was sent to
val from : kotlin.String = me@sender.com // kotlin.String | from email address
val to : kotlin.String = you@receiver.com // kotlin.String | to/destination email address
val subject : kotlin.String = Support // kotlin.String | subject containing this string
val mailid : kotlin.String = 185997065c60008840 // kotlin.String | mail id
val skip : kotlin.Int = 1000 // kotlin.Int | number of records to skip for pagination
val limit : kotlin.Int = 1000 // kotlin.Int | maximum number of records to return
val startDate : kotlin.Long = 1641781008 // kotlin.Long | earliest date to get emails in unix timestamp format
val endDate : kotlin.Long = 1673317008 // kotlin.Long | earliest date to get emails in unix timestamp format
try {
    val result : MailLog = apiInstance.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#viewMailLog")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#viewMailLog")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.Long**| The ID of your mail order this will be sent through. | [optional]
 **origin** | **kotlin.String**| originating ip address sending mail | [optional]
 **mx** | **kotlin.String**| mx record mail was sent to | [optional]
 **from** | **kotlin.String**| from email address | [optional]
 **to** | **kotlin.String**| to/destination email address | [optional]
 **subject** | **kotlin.String**| subject containing this string | [optional]
 **mailid** | **kotlin.String**| mail id | [optional]
 **skip** | **kotlin.Int**| number of records to skip for pagination | [optional] [default to 0]
 **limit** | **kotlin.Int**| maximum number of records to return | [optional] [default to 100]
 **startDate** | **kotlin.Long**| earliest date to get emails in unix timestamp format | [optional]
 **endDate** | **kotlin.Long**| earliest date to get emails in unix timestamp format | [optional]

### Return type

[**MailLog**](MailLog.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

