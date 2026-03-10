# StatusApi

All URIs are relative to *https://api.mailbaby.net*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**pingServer**](#pingserver) | **GET** /ping | Checks if the server is running|

# **pingServer**
> pingServer()

A lightweight health-check endpoint.  Returns a plain-text `200 OK` when the API server is reachable.  No authentication is required.  Useful for monitoring and uptime checks. 

### Example

```typescript
import {
    StatusApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new StatusApi(configuration);

const { status, data } = await apiInstance.pingServer();
```

### Parameters
This endpoint does not have any parameters.


### Return type

void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Server is up and running |  -  |
|**0** | Something is wrong |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

