# StatusApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**pingServer**](StatusApi.md#pingserver) | **GET** /ping | Health check — verify the API is reachable |



## pingServer

> string pingServer()

Health check — verify the API is reachable

**No authentication required.** Returns the plain-text string &#x60;Server is up and running&#x60; with a &#x60;200&#x60; status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 

### Example

```ts
import {
  Configuration,
  StatusApi,
} from '';
import type { PingServerRequest } from '';

async function example() {
  console.log("🚀 Testing  SDK...");
  const api = new StatusApi();

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

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `text/plain`, `application/json`


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Server is up and running |  -  |
| **0** | Something is wrong |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)

