# {{classname}}

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**PingServer**](StatusApi.md#PingServer) | **Get** /ping | Checks if the server is running

# **PingServer**
> string PingServer(ctx, )
Checks if the server is running

A lightweight health-check endpoint.  Returns the plain-text string `Server is up and running` with a `200` status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests. 

### Required Parameters
This endpoint does not need any parameter.

### Return type

**string**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

