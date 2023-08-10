# SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sendAdvMail**](SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](SendingApi.md#sendMail) | **POST** /mail/send | Sends an Email

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

val apiInstance = SendingApi()
val subject : kotlin.String = subject_example // kotlin.String | 
val body : kotlin.String = body_example // kotlin.String | 
val from : EmailAddressName =  // EmailAddressName | 
val to : kotlin.Array<EmailAddressName> =  // kotlin.Array<EmailAddressName> | 
val replyto : kotlin.Array<EmailAddressName> =  // kotlin.Array<EmailAddressName> | 
val cc : kotlin.Array<EmailAddressName> =  // kotlin.Array<EmailAddressName> | 
val bcc : kotlin.Array<EmailAddressName> =  // kotlin.Array<EmailAddressName> | 
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
 **from** | [**EmailAddressName**](.md)|  |
 **to** | [**kotlin.Array&lt;EmailAddressName&gt;**](EmailAddressName.md)|  |
 **replyto** | [**kotlin.Array&lt;EmailAddressName&gt;**](EmailAddressName.md)|  |
 **cc** | [**kotlin.Array&lt;EmailAddressName&gt;**](EmailAddressName.md)|  |
 **bcc** | [**kotlin.Array&lt;EmailAddressName&gt;**](EmailAddressName.md)|  |
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

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

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
> GenericResponse sendMail(to, from, subject, body)

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

