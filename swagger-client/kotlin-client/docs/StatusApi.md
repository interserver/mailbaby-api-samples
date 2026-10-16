# StatusApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**pingServer**](StatusApi.md#pingServer) | **GET** /ping | Health check — verify the API is reachable

<a name="pingServer"></a>
# **pingServer**
> kotlin.String pingServer()

Health check — verify the API is reachable

**No authentication required.** Returns the plain-text string &#x60;Server is up and running&#x60; with a &#x60;200&#x60; status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 

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

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

