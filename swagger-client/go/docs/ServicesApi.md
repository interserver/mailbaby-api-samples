# {{classname}}

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetMailOrders**](ServicesApi.md#GetMailOrders) | **Get** /mail | displays a list of mail service orders

# **GetMailOrders**
> []MailOrder GetMailOrders(ctx, )
displays a list of mail service orders

This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.

### Required Parameters
This endpoint does not need any parameter.

### Return type

[**[]MailOrder**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

