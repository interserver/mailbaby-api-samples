# StatusApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**pingServer**](StatusApi.md#pingServer) | **GET** /ping | Checks if the server is running

<a name="pingServer"></a>
# **pingServer**
> kotlin.String pingServer()

Checks if the server is running

A lightweight health-check endpoint.  Returns the plain-text string &#x60;Server is up and running&#x60; with a &#x60;200&#x60; status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests. 

### Example
```kotlin
// Import classes:
//import mailbaby-client-kotlin-client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = StatusApi()
try {
    val result : kotlin.String = apiInstance.pingServer()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling StatusApi#pingServer")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling StatusApi#pingServer")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**kotlin.String**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

