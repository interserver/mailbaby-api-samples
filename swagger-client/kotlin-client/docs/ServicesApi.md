# ServicesApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailOrders**](ServicesApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders

<a name="getMailOrders"></a>
# **getMailOrders**
> kotlin.Array&lt;MailOrder&gt; getMailOrders()

displays a list of mail service orders

This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = ServicesApi()
try {
    val result : kotlin.Array<MailOrder> = apiInstance.getMailOrders()
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

[**kotlin.Array&lt;MailOrder&gt;**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

