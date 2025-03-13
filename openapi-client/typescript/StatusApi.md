# .StatusApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**pingServer**](StatusApi.md#pingServer) | **GET** /ping | Checks if the server is running


# **pingServer**
> void pingServer()


### Example


```typescript
import { createConfiguration, StatusApi } from '';

const configuration = createConfiguration();
const apiInstance = new StatusApi(configuration);

const request = {};

const data = await apiInstance.pingServer(request);
console.log('API called successfully. Returned data:', data);
```


### Parameters
This endpoint does not need any parameter.


### Return type

**void**

### Authorization

[apiKeyAuth](README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Server is up and running |  -  |
**0** | Something is wrong |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)


