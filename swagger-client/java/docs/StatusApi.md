# StatusApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**pingServer**](StatusApi.md#pingServer) | **GET** /ping | Health check — verify the API is reachable

<a name="pingServer"></a>
# **pingServer**
> String pingServer()

Health check — verify the API is reachable

**No authentication required.** Returns the plain-text string &#x60;Server is up and running&#x60; with a &#x60;200&#x60; status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StatusApi;


StatusApi apiInstance = new StatusApi();
try {
    String result = apiInstance.pingServer();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StatusApi#pingServer");
    e.printStackTrace();
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

