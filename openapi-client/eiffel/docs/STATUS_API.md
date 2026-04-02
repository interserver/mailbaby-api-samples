# STATUS_API

All URIs are relative to *https://api.mailbaby.net*

Feature | HTTP request | Description
------------- | ------------- | -------------
[**ping_server**](STATUS_API.md#ping_server) | **Get** /ping | Checks if the server is running


# **ping_server**
> ping_server : detachable STRING_32


Checks if the server is running

A lightweight health-check endpoint.  Returns the plain-text string `Server is up and running` with a `200` status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests. 


### Parameters
This endpoint does not need any parameter.

### Return type

[**STRING_32**](STRING_32.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

