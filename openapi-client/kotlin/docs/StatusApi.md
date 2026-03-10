# StatusApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**pingServer**](StatusApi.md#pingServer) | **GET** /ping | Checks if the server is running |


<a id="pingServer"></a>
# **pingServer**
> pingServer()

Checks if the server is running

A lightweight health-check endpoint.  Returns a plain-text &#x60;200 OK&#x60; when the API server is reachable.  No authentication is required.  Useful for monitoring and uptime checks. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = StatusApi()
try {
    apiInstance.pingServer()
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

null (empty response body)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

