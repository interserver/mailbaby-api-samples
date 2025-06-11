# ServicesApi

All URIs are relative to *https://api.mailbaby.net*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**getMailOrders**](#getmailorders) | **GET** /mail | displays a list of mail service orders|

# **getMailOrders**
> Array<MailOrder> getMailOrders()

This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.

### Example

```typescript
import {
    ServicesApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new ServicesApi(configuration);

const { status, data } = await apiInstance.getMailOrders();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**Array<MailOrder>**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |
|**401** | Unauthorized |  -  |
|**404** | Unauthorized |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

