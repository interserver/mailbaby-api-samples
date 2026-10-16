# STATUS_API

All URIs are relative to *https://api.mailbaby.net*

Feature | HTTP request | Description
------------- | ------------- | -------------
[**ping_server**](STATUS_API.md#ping_server) | **Get** /ping | Health check — verify the API is reachable


# **ping_server**
> ping_server : detachable STRING_32


Health check — verify the API is reachable

**No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 


### Parameters
This endpoint does not need any parameter.

### Return type

[**STRING_32**](STRING_32.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

