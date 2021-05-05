# DefaultApi

All URIs are relative to *http://mystage.interserver.net:8787*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailOrders**](DefaultApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders
[**pingServer**](DefaultApi.md#pingServer) | **GET** /ping | Checks if the server is running
[**placeMailOrder**](DefaultApi.md#placeMailOrder) | **POST** /mail/order | places a mail order
[**sendAdvMail**](DefaultApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](DefaultApi.md#sendMail) | **POST** /mail/send | Sends an Email
[**validateMailOrder**](DefaultApi.md#validateMailOrder) | **GET** /mail/order | validatess order details before placing an order
[**viewMailLog**](DefaultApi.md#viewMailLog) | **GET** /mail/log | displays the mail log


<a name="getMailOrders"></a>
# **getMailOrders**
> List getMailOrders(id)

displays a list of mail service orders

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The ID of your mail order this will be sent through. | [optional] [default to null]

### Return type

[**List**](../Models/MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml, text/plain

<a name="pingServer"></a>
# **pingServer**
> pingServer()

Checks if the server is running

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

<a name="placeMailOrder"></a>
# **placeMailOrder**
> placeMailOrder(MailOrder)

places a mail order

    Adds an item to the system

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **MailOrder** | [**MailOrder**](../Models/MailOrder.md)| Inventory item to add | [optional]

### Return type

null (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

<a name="sendAdvMail"></a>
# **sendAdvMail**
> GenericResponse sendAdvMail(SendMailAdv)

Sends an Email with Advanced Options

    Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **SendMailAdv** | [**SendMailAdv**](../Models/SendMailAdv.md)|  |

### Return type

[**GenericResponse**](../Models/GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/json, application/x-www-form-urlencoded
- **Accept**: application/json

<a name="sendMail"></a>
# **sendMail**
> GenericResponse sendMail(to, from, subject, body)

Sends an Email

    Sends An email through one of your mail orders.

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **String**| The Contact whom is the primary recipient of this email. | [default to null]
 **from** | **String**| The contact whom is the this email is from. | [default to null]
 **subject** | **String**| The subject or title of the email | [default to null]
 **body** | **String**| The main email contents. | [default to null]

### Return type

[**GenericResponse**](../Models/GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded, application/json
- **Accept**: application/json

<a name="validateMailOrder"></a>
# **validateMailOrder**
> validateMailOrder()

validatess order details before placing an order

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="viewMailLog"></a>
# **viewMailLog**
> List viewMailLog(id, searchString, skip, limit)

displays the mail log

    By passing in the appropriate options, you can search for available inventory in the system 

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The ID of your mail order this will be sent through. | [optional] [default to null]
 **searchString** | **String**| pass an optional search string for looking up inventory | [optional] [default to null]
 **skip** | **Integer**| number of records to skip for pagination | [optional] [default to null]
 **limit** | **Integer**| maximum number of records to return | [optional] [default to null]

### Return type

[**List**](../Models/MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

