# DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailById**](DefaultApi.md#getMailById) | **GET** /mail/{id} | Gets mail order information by id
[**getMailOrders**](DefaultApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders
[**pingServer**](DefaultApi.md#pingServer) | **GET** /ping | Checks if the server is running
[**placeMailOrder**](DefaultApi.md#placeMailOrder) | **POST** /mail/order | places a mail order
[**sendMailById**](DefaultApi.md#sendMailById) | **POST** /mail/{id}/send | Sends an Email
[**validateMailOrder**](DefaultApi.md#validateMailOrder) | **GET** /mail/order | validatess order details before placing an order
[**viewMailLogById**](DefaultApi.md#viewMailLogById) | **GET** /mail/{id}/log | displays the mail log


<a name="getMailById"></a>
# **getMailById**
> MailOrder getMailById(id)

Gets mail order information by id

returns information about a mail order in the system with the given id.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val id : kotlin.Long = 789 // kotlin.Long | User ID
try {
    val result : MailOrder = apiInstance.getMailById(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#getMailById")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#getMailById")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.Long**| User ID |

### Return type

[**MailOrder**](MailOrder.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""
Configure apiLoginAuth:
    ApiClient.apiKey["X-API-LOGIN"] = ""
    ApiClient.apiKeyPrefix["X-API-LOGIN"] = ""
Configure apiPasswordAuth:
    ApiClient.apiKey["X-API-PASS"] = ""
    ApiClient.apiKeyPrefix["X-API-PASS"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getMailOrders"></a>
# **getMailOrders**
> kotlin.collections.List&lt;MailOrder&gt; getMailOrders()

displays a list of mail service orders

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
try {
    val result : kotlin.collections.List<MailOrder> = apiInstance.getMailOrders()
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

[**kotlin.collections.List&lt;MailOrder&gt;**](MailOrder.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""
Configure apiLoginAuth:
    ApiClient.apiKey["X-API-LOGIN"] = ""
    ApiClient.apiKeyPrefix["X-API-LOGIN"] = ""
Configure apiPasswordAuth:
    ApiClient.apiKey["X-API-PASS"] = ""
    ApiClient.apiKeyPrefix["X-API-PASS"] = ""

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

<a name="placeMailOrder"></a>
# **placeMailOrder**
> placeMailOrder(mailOrder)

places a mail order

Adds an item to the system

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val mailOrder : MailOrder =  // MailOrder | Inventory item to add
try {
    apiInstance.placeMailOrder(mailOrder)
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
 **mailOrder** | [**MailOrder**](MailOrder.md)| Inventory item to add | [optional]

### Return type

null (empty response body)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""
Configure apiLoginAuth:
    ApiClient.apiKey["X-API-LOGIN"] = ""
    ApiClient.apiKeyPrefix["X-API-LOGIN"] = ""
Configure apiPasswordAuth:
    ApiClient.apiKey["X-API-PASS"] = ""
    ApiClient.apiKeyPrefix["X-API-PASS"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="sendMailById"></a>
# **sendMailById**
> GenericResponse sendMailById(id, subject, body, to, from)

Sends an Email

Sends An email through one of your mail orders.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val id : kotlin.Long = 789 // kotlin.Long | User ID
val subject : kotlin.String = subject_example // kotlin.String | 
val body : kotlin.String = body_example // kotlin.String | 
val to : kotlin.String = to_example // kotlin.String | 
val from : kotlin.String = from_example // kotlin.String | 
try {
    val result : GenericResponse = apiInstance.sendMailById(id, subject, body, to, from)
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
 **id** | **kotlin.Long**| User ID |
 **subject** | **kotlin.String**|  | [optional]
 **body** | **kotlin.String**|  | [optional]
 **to** | **kotlin.String**|  | [optional]
 **from** | **kotlin.String**|  | [optional]

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""
Configure apiLoginAuth:
    ApiClient.apiKey["X-API-LOGIN"] = ""
    ApiClient.apiKeyPrefix["X-API-LOGIN"] = ""
Configure apiPasswordAuth:
    ApiClient.apiKey["X-API-PASS"] = ""
    ApiClient.apiKeyPrefix["X-API-PASS"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="validateMailOrder"></a>
# **validateMailOrder**
> validateMailOrder()

validatess order details before placing an order

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

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


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""
Configure apiLoginAuth:
    ApiClient.apiKey["X-API-LOGIN"] = ""
    ApiClient.apiKeyPrefix["X-API-LOGIN"] = ""
Configure apiPasswordAuth:
    ApiClient.apiKey["X-API-PASS"] = ""
    ApiClient.apiKeyPrefix["X-API-PASS"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="viewMailLogById"></a>
# **viewMailLogById**
> kotlin.collections.List&lt;MailLog&gt; viewMailLogById(id, searchString, skip, limit)

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val id : kotlin.Long = 789 // kotlin.Long | User ID
val searchString : kotlin.String = searchString_example // kotlin.String | pass an optional search string for looking up inventory
val skip : kotlin.Int = 56 // kotlin.Int | number of records to skip for pagination
val limit : kotlin.Int = 56 // kotlin.Int | maximum number of records to return
try {
    val result : kotlin.collections.List<MailLog> = apiInstance.viewMailLogById(id, searchString, skip, limit)
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
 **id** | **kotlin.Long**| User ID |
 **searchString** | **kotlin.String**| pass an optional search string for looking up inventory | [optional]
 **skip** | **kotlin.Int**| number of records to skip for pagination | [optional]
 **limit** | **kotlin.Int**| maximum number of records to return | [optional]

### Return type

[**kotlin.collections.List&lt;MailLog&gt;**](MailLog.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""
Configure apiLoginAuth:
    ApiClient.apiKey["X-API-LOGIN"] = ""
    ApiClient.apiKeyPrefix["X-API-LOGIN"] = ""
Configure apiPasswordAuth:
    ApiClient.apiKey["X-API-PASS"] = ""
    ApiClient.apiKeyPrefix["X-API-PASS"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

