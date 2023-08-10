# ServicesApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailOrders**](ServicesApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders



## getMailOrders

displays a list of mail service orders

This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.

### Example

```bash
 getMailOrders
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**array[MailOrder]**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

