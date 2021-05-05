# {{classname}}

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetMailOrders**](DefaultApi.md#GetMailOrders) | **Get** /mail | displays a list of mail service orders
[**PingServer**](DefaultApi.md#PingServer) | **Get** /ping | Checks if the server is running
[**PlaceMailOrder**](DefaultApi.md#PlaceMailOrder) | **Post** /mail/order | places a mail order
[**SendAdvMailById**](DefaultApi.md#SendAdvMailById) | **Post** /mail/advsend | Sends an Email with Advanced Options
[**SendMailById**](DefaultApi.md#SendMailById) | **Post** /mail/send | Sends an Email
[**ValidateMailOrder**](DefaultApi.md#ValidateMailOrder) | **Get** /mail/order | validatess order details before placing an order
[**ViewMailLogById**](DefaultApi.md#ViewMailLogById) | **Get** /mail/log | displays the mail log

# **GetMailOrders**
> []MailOrder GetMailOrders(ctx, optional)
displays a list of mail service orders

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
 **optional** | ***DefaultApiGetMailOrdersOpts** | optional parameters | nil if no parameters

### Optional Parameters
Optional parameters are passed through a pointer to a DefaultApiGetMailOrdersOpts struct
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **optional.Int64**| The ID of your mail order this will be sent through. | 

### Return type

[**[]MailOrder**](array.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **PingServer**
> PingServer(ctx, )
Checks if the server is running

### Required Parameters
This endpoint does not need any parameter.

### Return type

 (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **PlaceMailOrder**
> PlaceMailOrder(ctx, optional)
places a mail order

Adds an item to the system

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
 **optional** | ***DefaultApiPlaceMailOrderOpts** | optional parameters | nil if no parameters

### Optional Parameters
Optional parameters are passed through a pointer to a DefaultApiPlaceMailOrderOpts struct
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**optional.Interface of MailOrder**](MailOrder.md)| Inventory item to add | 

### Return type

 (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **SendAdvMailById**
> GenericResponse SendAdvMailById(ctx, body)
Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
  **body** | [**SendMail**](SendMail.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **SendMailById**
> GenericResponse SendMailById(ctx, body, subject, body, from, to, id, replyto, cc, bcc, attachments)
Sends an Email

Sends An email through one of your mail orders.

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
  **body** | [**SendMail**](SendMail.md)|  | 
  **subject** | **string**|  | 
  **body** | **string**|  | 
  **from** | [**[]SendMailFrom**](SendMailFrom.md)|  | 
  **to** | [**[]MailContact**](MailContact.md)|  | 
  **id** | **int64**|  | 
  **replyto** | [**[]MailContact**](MailContact.md)|  | 
  **cc** | [**[]MailContact**](MailContact.md)|  | 
  **bcc** | [**[]MailContact**](MailContact.md)|  | 
  **attachments** | [**[]MailAttachment**](MailAttachment.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **ValidateMailOrder**
> ValidateMailOrder(ctx, )
validatess order details before placing an order

### Required Parameters
This endpoint does not need any parameter.

### Return type

 (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **ViewMailLogById**
> []MailLog ViewMailLogById(ctx, optional)
displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
 **optional** | ***DefaultApiViewMailLogByIdOpts** | optional parameters | nil if no parameters

### Optional Parameters
Optional parameters are passed through a pointer to a DefaultApiViewMailLogByIdOpts struct
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **optional.Int64**| The ID of your mail order this will be sent through. | 
 **searchString** | **optional.String**| pass an optional search string for looking up inventory | 
 **skip** | **optional.Int32**| number of records to skip for pagination | 
 **limit** | **optional.Int32**| maximum number of records to return | 

### Return type

[**[]MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

