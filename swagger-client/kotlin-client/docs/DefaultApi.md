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
> kotlin.Array&lt;InlineResponse200&gt; getMailOrders()

displays a list of mail service orders

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DefaultApi()
try {
    val result : kotlin.Array<InlineResponse200> = apiInstance.getMailOrders()
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

[**kotlin.Array&lt;InlineResponse200&gt;**](InlineResponse200.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

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
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

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
> GenericResponse sendAdvMail(body)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DefaultApi()
val body : SendMailAdv =  // SendMailAdv | 
try {
    val result : GenericResponse = apiInstance.sendAdvMail(body)
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
 **body** | [**SendMailAdv**](SendMailAdv.md)|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="sendAdvMail"></a>
# **sendAdvMail**
> GenericResponse sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DefaultApi()
val subject : kotlin.String = subject_example // kotlin.String | 
val body : kotlin.String = body_example // kotlin.String | 
val from : SendMailAdvFrom =  // SendMailAdvFrom | 
val to : kotlin.Array<SendMailAdvTo> =  // kotlin.Array<SendMailAdvTo> | 
val replyto : kotlin.Array<SendMailAdvReplyto> =  // kotlin.Array<SendMailAdvReplyto> | 
val cc : kotlin.Array<SendMailAdvCc> =  // kotlin.Array<SendMailAdvCc> | 
val bcc : kotlin.Array<SendMailAdvBcc> =  // kotlin.Array<SendMailAdvBcc> | 
val attachments : kotlin.Array<SendMailAdvAttachments> =  // kotlin.Array<SendMailAdvAttachments> | 
val id : kotlin.Long = 789 // kotlin.Long | 
try {
    val result : GenericResponse = apiInstance.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id)
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
 **subject** | **kotlin.String**|  |
 **body** | **kotlin.String**|  |
 **from** | [**SendMailAdvFrom**](.md)|  |
 **to** | [**kotlin.Array&lt;SendMailAdvTo&gt;**](SendMailAdvTo.md)|  |
 **replyto** | [**kotlin.Array&lt;SendMailAdvReplyto&gt;**](SendMailAdvReplyto.md)|  |
 **cc** | [**kotlin.Array&lt;SendMailAdvCc&gt;**](SendMailAdvCc.md)|  |
 **bcc** | [**kotlin.Array&lt;SendMailAdvBcc&gt;**](SendMailAdvBcc.md)|  |
 **attachments** | [**kotlin.Array&lt;SendMailAdvAttachments&gt;**](SendMailAdvAttachments.md)|  |
 **id** | **kotlin.Long**|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="sendMail"></a>
# **sendMail**
> GenericResponse sendMail(to, from, subject, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DefaultApi()
val to : kotlin.String = to_example // kotlin.String | 
val from : kotlin.String = from_example // kotlin.String | 
val subject : kotlin.String = subject_example // kotlin.String | 
val body : kotlin.String = body_example // kotlin.String | 
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
 **to** | **kotlin.String**|  |
 **from** | **kotlin.String**|  |
 **subject** | **kotlin.String**|  |
 **body** | **kotlin.String**|  |

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

val apiInstance = DefaultApi()
val body : SendMail =  // SendMail | 
try {
    val result : GenericResponse = apiInstance.sendMail(body)
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
 **body** | [**SendMail**](SendMail.md)|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

<a name="viewMailLog"></a>
# **viewMailLog**
> MailLog viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate)

displays the mail log

Get a listing of the emails sent through this system 

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DefaultApi()
val id : kotlin.Long = 789 // kotlin.Long | The ID of your mail order this will be sent through.
val origin : kotlin.String = origin_example // kotlin.String | originating ip address sending mail
val mx : kotlin.String = mx_example // kotlin.String | mx record mail was sent to
val from : kotlin.String = from_example // kotlin.String | from email address
val to : kotlin.String = to_example // kotlin.String | to/destination email address
val subject : kotlin.String = subject_example // kotlin.String | subject containing this string
val mailid : kotlin.String = mailid_example // kotlin.String | mail id
val skip : kotlin.Int = 56 // kotlin.Int | number of records to skip for pagination
val limit : kotlin.Int = 56 // kotlin.Int | maximum number of records to return
val startDate : kotlin.Long = 789 // kotlin.Long | earliest date to get emails in unix timestamp format
val endDate : kotlin.Long = 789 // kotlin.Long | earliest date to get emails in unix timestamp format
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
 **skip** | **kotlin.Int**| number of records to skip for pagination | [optional] [default to 0] [enum: ]
 **limit** | **kotlin.Int**| maximum number of records to return | [optional] [default to 100] [enum: ]
 **startDate** | **kotlin.Long**| earliest date to get emails in unix timestamp format | [optional] [enum: ]
 **endDate** | **kotlin.Long**| earliest date to get emails in unix timestamp format | [optional] [enum: ]

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

