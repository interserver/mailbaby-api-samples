# SERVICES_API

All URIs are relative to *https://api.mailbaby.net*

Feature | HTTP request | Description
------------- | ------------- | -------------
[**mail_orders**](SERVICES_API.md#mail_orders) | **Get** /mail | displays a list of mail service orders


# **mail_orders**
> mail_orders : detachable LIST [MAIL_ORDER]


displays a list of mail service orders

This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.


### Parameters
This endpoint does not need any parameter.

### Return type

[**LIST [MAIL_ORDER]**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

