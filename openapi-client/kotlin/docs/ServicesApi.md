# ServicesApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getMailOrders**](ServicesApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders |


<a id="getMailOrders"></a>
# **getMailOrders**
> kotlin.collections.List&lt;MailOrder&gt; getMailOrders()

displays a list of mail service orders

This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ServicesApi()
try {
    val result : kotlin.collections.List<MailOrder> = apiInstance.getMailOrders()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ServicesApi#getMailOrders")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ServicesApi#getMailOrders")
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

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

