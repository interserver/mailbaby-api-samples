# \ServicesApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_mail_orders**](ServicesApi.md#get_mail_orders) | **GET** /mail | displays a list of mail service orders



## get_mail_orders

> Vec<models::MailOrder> get_mail_orders()
displays a list of mail service orders

This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.

### Parameters

This endpoint does not need any parameter.

### Return type

[**Vec<models::MailOrder>**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

