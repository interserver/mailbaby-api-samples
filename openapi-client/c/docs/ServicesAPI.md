# ServicesAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**ServicesAPI_getMailOrders**](ServicesAPI.md#ServicesAPI_getMailOrders) | **GET** /mail | displays a list of mail service orders


# **ServicesAPI_getMailOrders**
```c
// displays a list of mail service orders
//
// This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
//
list_t* ServicesAPI_getMailOrders(apiClient_t *apiClient);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |

### Return type

[list_t](mail_order.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

