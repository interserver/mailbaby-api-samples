# MailBabyCsharp.Api.StatusApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**PingServer**](StatusApi.md#pingserver) | **GET** /ping | Health check — verify the API is reachable

<a name="pingserver"></a>
# **PingServer**
> string PingServer ()

Health check — verify the API is reachable

**No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 

### Example
```csharp
using System;
using System.Diagnostics;
using MailBabyCsharp.Api;
using MailBabyCsharp.Client;
using MailBabyCsharp.Model;

namespace Example
{
    public class PingServerExample
    {
        public void main()
        {
            var apiInstance = new StatusApi();

            try
            {
                // Health check — verify the API is reachable
                string result = apiInstance.PingServer();
                Debug.WriteLine(result);
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

**string**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
