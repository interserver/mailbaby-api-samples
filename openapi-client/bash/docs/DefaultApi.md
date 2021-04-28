# DefaultApi

All URIs are relative to **

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



## getMailById

Gets mail order information by id

returns information about a mail order in the system with the given id.

### Example

```bash
 getMailById id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer** | User ID | [default to null]

### Return type

[**MailOrder**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getMailOrders

displays a list of mail service orders

### Example

```bash
 getMailOrders
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**array[MailOrder]**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json, application/xml, text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## pingServer

Checks if the server is running

### Example

```bash
 pingServer
```

### Parameters

This endpoint does not need any parameter.

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: Not Applicable

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## placeMailOrder

places a mail order

Adds an item to the system

### Example

```bash
 placeMailOrder
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **mailOrder** | [**MailOrder**](MailOrder.md) | Inventory item to add | [optional]

### Return type

(empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## sendAdvMailById

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example

```bash
 sendAdvMailById id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer** | User ID | [default to null]
 **sendMail** | [**SendMail**](SendMail.md) |  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: application/json, application/xml, application/x-www-form-urlencoded, text/plain
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## sendMailById

Sends an Email

Sends An email through one of your mail orders.

### Example

```bash
 sendMailById id=value  subject=value  body=value  to=value  toName=value  from=value  fromName=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer** | User ID | [default to null]
 **subject** | **string** |  | [optional] [default to null]
 **body** | **string** |  | [optional] [default to null]
 **to** | **string** |  | [optional] [default to null]
 **toName** | **string** |  | [optional] [default to null]
 **from** | **string** |  | [optional] [default to null]
 **fromName** | **string** |  | [optional] [default to null]

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## validateMailOrder

validatess order details before placing an order

### Example

```bash
 validateMailOrder
```

### Parameters

This endpoint does not need any parameter.

### Return type

(empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## viewMailLogById

displays the mail log

By passing in the appropriate options, you can search for
available inventory in the system

### Example

```bash
 viewMailLogById id=value  searchString=value  skip=value  limit=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer** | User ID | [default to null]
 **searchString** | **string** | pass an optional search string for looking up inventory | [optional] [default to null]
 **skip** | **integer** | number of records to skip for pagination | [optional] [default to null]
 **limit** | **integer** | maximum number of records to return | [optional] [default to null]

### Return type

[**array[MailLog]**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

