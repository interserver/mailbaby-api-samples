# StatusApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**pingServer**](StatusApi.md#pingserver) | **GET** /ping | Checks if the server is running |



## pingServer

> string pingServer()

Checks if the server is running

A lightweight health-check endpoint.  Returns the plain-text string &#x60;Server is up and running&#x60; with a &#x60;200&#x60; status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests. 

### Example

```ts
import {
  Configuration,
  StatusApi,
} from '';
import type { PingServerRequest } from '';

async function example() {
  console.log("🚀 Testing  SDK...");
  const config = new Configuration({ 
    // To configure API key authorization: apiKeyAuth
    apiKey: "YOUR API KEY",
  });
  const api = new StatusApi(config);

  try {
    const data = await api.pingServer();
    console.log(data);
  } catch (error) {
    console.error(error);
  }
}

// Run the test
example().catch(console.error);
```

### Parameters

This endpoint does not need any parameter.

### Return type

**string**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `text/plain`


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Server is up and running |  -  |
| **0** | Something is wrong |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)

