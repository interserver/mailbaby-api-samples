# DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailById**](DefaultApi.md#getMailById) | **GET** /mail/{id} | Gets mail order information by id
[**getMailOrders**](DefaultApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders
[**pingServer**](DefaultApi.md#pingServer) | **GET** /ping | Checks if the server is running
[**placeMailOrder**](DefaultApi.md#placeMailOrder) | **POST** /mail/order | places a mail order
[**sendAdvMailById**](DefaultApi.md#sendAdvMailById) | **POST** /mail/{id}/advsend | Sends an Email with Advanced Options
[**sendMailById**](DefaultApi.md#sendMailById) | **POST** /mail/{id}/send | Sends an Email
[**validateMailOrder**](DefaultApi.md#validateMailOrder) | **GET** /mail/order | validatess order details before placing an order
[**viewMailLogById**](DefaultApi.md#viewMailLogById) | **GET** /mail/{id}/log | displays the mail log


<a name="getMailById"></a>
# **getMailById**
> MailOrder getMailById(id)

Gets mail order information by id

    returns information about a mail order in the system with the given id.

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| User ID | [default to null]

### Return type

[**MailOrder**](../Models/MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="getMailOrders"></a>
# **getMailOrders**
> List getMailOrders()

displays a list of mail service orders

### Parameters
This endpoint does not need any parameter.

### Return type

[**List**](../Models/MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

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

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

<a name="sendAdvMailById"></a>
# **sendAdvMailById**
> GenericResponse sendAdvMailById(id, SendMail)

Sends an Email with Advanced Options

    Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| User ID | [default to null]
 **SendMail** | [**SendMail**](../Models/SendMail.md)|  |

### Return type

[**GenericResponse**](../Models/GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: application/json, application/xml, application/x-www-form-urlencoded, text/plain
- **Accept**: application/json

<a name="sendMailById"></a>
# **sendMailById**
> GenericResponse sendMailById(id, subject, body, to, toName, from, fromName)

Sends an Email

    Sends An email through one of your mail orders.

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| User ID | [default to null]
 **subject** | **String**|  | [optional] [default to null]
 **body** | **String**|  | [optional] [default to null]
 **to** | **String**|  | [optional] [default to null]
 **toName** | **String**|  | [optional] [default to null]
 **from** | **String**|  | [optional] [default to null]
 **fromName** | **String**|  | [optional] [default to null]

### Return type

[**GenericResponse**](../Models/GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not defined
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

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="viewMailLogById"></a>
# **viewMailLogById**
> List viewMailLogById(id, searchString, skip, limit)

displays the mail log

    By passing in the appropriate options, you can search for available inventory in the system 

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| User ID | [default to null]
 **searchString** | **String**| pass an optional search string for looking up inventory | [optional] [default to null]
 **skip** | **Integer**| number of records to skip for pagination | [optional] [default to null]
 **limit** | **Integer**| maximum number of records to return | [optional] [default to null]

### Return type

[**List**](../Models/MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

