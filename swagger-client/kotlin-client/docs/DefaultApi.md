# DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailOrders**](DefaultApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders
[**pingServer**](DefaultApi.md#pingServer) | **GET** /ping | Checks if the server is running
[**placeMailOrder**](DefaultApi.md#placeMailOrder) | **POST** /mail/order | places a mail order
[**sendAdvMailById**](DefaultApi.md#sendAdvMailById) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMailById**](DefaultApi.md#sendMailById) | **POST** /mail/send | Sends an Email
[**validateMailOrder**](DefaultApi.md#validateMailOrder) | **GET** /mail/order | validatess order details before placing an order
[**viewMailLogById**](DefaultApi.md#viewMailLogById) | **GET** /mail/log | displays the mail log

<a name="getMailOrders"></a>
# **getMailOrders**
> MailOrders getMailOrders(id)

displays a list of mail service orders

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DefaultApi()
val id : kotlin.Long = 789 // kotlin.Long | The ID of your mail order this will be sent through.
try {
    val result : MailOrders = apiInstance.getMailOrders(id)
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

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.Long**| The ID of your mail order this will be sent through. | [optional]

### Return type

[**MailOrders**](MailOrders.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, text/plain

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

<a name="placeMailOrder"></a>
# **placeMailOrder**
> placeMailOrder(body)

places a mail order

Adds an item to the system

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DefaultApi()
val body : MailOrder =  // MailOrder | Inventory item to add
try {
    apiInstance.placeMailOrder(body)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#placeMailOrder")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#placeMailOrder")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MailOrder**](MailOrder.md)| Inventory item to add | [optional]

### Return type

null (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="sendAdvMailById"></a>
# **sendAdvMailById**
> GenericResponse sendAdvMailById(body)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DefaultApi()
val body : SendMail =  // SendMail | 
try {
    val result : GenericResponse = apiInstance.sendAdvMailById(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#sendAdvMailById")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#sendAdvMailById")
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

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="sendMailById"></a>
# **sendMailById**
> GenericResponse sendMailById(body)

Sends an Email

Sends An email through one of your mail orders.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DefaultApi()
val body : SendMail =  // SendMail | 
try {
    val result : GenericResponse = apiInstance.sendMailById(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#sendMailById")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#sendMailById")
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

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="sendMailById"></a>
# **sendMailById**
> GenericResponse sendMailById(subject, body, from, to, id, replyto, cc, bcc, attachments)

Sends an Email

Sends An email through one of your mail orders.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DefaultApi()
val subject : kotlin.String = subject_example // kotlin.String | 
val body : kotlin.String = body_example // kotlin.String | 
val from : kotlin.Array<SendMailFrom> =  // kotlin.Array<SendMailFrom> | 
val to : kotlin.Array<MailContact> =  // kotlin.Array<MailContact> | 
val id : kotlin.Long = 789 // kotlin.Long | 
val replyto : kotlin.Array<MailContact> =  // kotlin.Array<MailContact> | 
val cc : kotlin.Array<MailContact> =  // kotlin.Array<MailContact> | 
val bcc : kotlin.Array<MailContact> =  // kotlin.Array<MailContact> | 
val attachments : kotlin.Array<MailAttachment> =  // kotlin.Array<MailAttachment> | 
try {
    val result : GenericResponse = apiInstance.sendMailById(subject, body, from, to, id, replyto, cc, bcc, attachments)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#sendMailById")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#sendMailById")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **kotlin.String**|  |
 **body** | **kotlin.String**|  |
 **from** | [**kotlin.Array&lt;SendMailFrom&gt;**](SendMailFrom.md)|  |
 **to** | [**kotlin.Array&lt;MailContact&gt;**](MailContact.md)|  |
 **id** | **kotlin.Long**|  |
 **replyto** | [**kotlin.Array&lt;MailContact&gt;**](MailContact.md)|  |
 **cc** | [**kotlin.Array&lt;MailContact&gt;**](MailContact.md)|  |
 **bcc** | [**kotlin.Array&lt;MailContact&gt;**](MailContact.md)|  |
 **attachments** | [**kotlin.Array&lt;MailAttachment&gt;**](MailAttachment.md)|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="validateMailOrder"></a>
# **validateMailOrder**
> validateMailOrder()

validatess order details before placing an order

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DefaultApi()
try {
    apiInstance.validateMailOrder()
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#validateMailOrder")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#validateMailOrder")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="viewMailLogById"></a>
# **viewMailLogById**
> kotlin.Array&lt;MailLog&gt; viewMailLogById(id, searchString, skip, limit)

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DefaultApi()
val id : kotlin.Long = 789 // kotlin.Long | The ID of your mail order this will be sent through.
val searchString : kotlin.String = searchString_example // kotlin.String | pass an optional search string for looking up inventory
val skip : kotlin.Int = 56 // kotlin.Int | number of records to skip for pagination
val limit : kotlin.Int = 56 // kotlin.Int | maximum number of records to return
try {
    val result : kotlin.Array<MailLog> = apiInstance.viewMailLogById(id, searchString, skip, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#viewMailLogById")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#viewMailLogById")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.Long**| The ID of your mail order this will be sent through. | [optional]
 **searchString** | **kotlin.String**| pass an optional search string for looking up inventory | [optional]
 **skip** | **kotlin.Int**| number of records to skip for pagination | [optional] [enum: ]
 **limit** | **kotlin.Int**| maximum number of records to return | [optional] [enum: ]

### Return type

[**kotlin.Array&lt;MailLog&gt;**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

