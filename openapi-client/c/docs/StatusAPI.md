# StatusAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**StatusAPI_pingServer**](StatusAPI.md#StatusAPI_pingServer) | **GET** /ping | Health check — verify the API is reachable


# **StatusAPI_pingServer**
```c
// Health check — verify the API is reachable
//
// **No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 
//
char* StatusAPI_pingServer(apiClient_t *apiClient);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |

### Return type

char*



### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

