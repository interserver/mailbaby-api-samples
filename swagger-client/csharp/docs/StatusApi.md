# mailbaby-client-csharp.Api.StatusApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**PingServer**](StatusApi.md#pingserver) | **GET** /ping | Checks if the server is running

<a name="pingserver"></a>
# **PingServer**
> void PingServer ()

Checks if the server is running

A lightweight health-check endpoint.  Returns a plain-text `200 OK` when the API server is reachable.  No authentication is required.  Useful for monitoring and uptime checks. 

### Example
```csharp
using System;
using System.Diagnostics;
using mailbaby-client-csharp.Api;
using mailbaby-client-csharp.Client;
using mailbaby-client-csharp.Model;

namespace Example
{
    public class PingServerExample
    {
        public void main()
        {
            // Configure API key authorization: apiKeyAuth
            Configuration.Default.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new StatusApi();

            try
            {
                // Checks if the server is running
                apiInstance.PingServer();
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling StatusApi.PingServer: " + e.Message );
            }
        }
    }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
