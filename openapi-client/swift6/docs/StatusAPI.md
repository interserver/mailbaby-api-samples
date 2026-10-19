# StatusAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**pingServer**](StatusAPI.md#pingserver) | **GET** /ping | Health check — verify the API is reachable


# **pingServer**
```swift
    open class func pingServer(apiConfiguration: OpenAPIClientAPIConfiguration = OpenAPIClientAPIConfiguration.shared) async throws(ErrorResponse) -> String
```

Health check — verify the API is reachable

**No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient


// Health check — verify the API is reachable
do {
    let response = try await StatusAPI.pingServer()
    dump(response)
} catch {
    print(error)
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

