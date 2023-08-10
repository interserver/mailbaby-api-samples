# ServicesApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getMailOrders**](ServicesApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders |


<a name="getMailOrders"></a>
# **getMailOrders**
> List getMailOrders()

displays a list of mail service orders

    This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.

### Parameters
This endpoint does not need any parameter.

### Return type

[**List**](../Models/MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

