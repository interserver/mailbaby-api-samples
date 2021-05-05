# {{classname}}

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetMailOrders**](DefaultApi.md#GetMailOrders) | **Get** /mail | displays a list of mail service orders
[**PingServer**](DefaultApi.md#PingServer) | **Get** /ping | Checks if the server is running
[**PlaceMailOrder**](DefaultApi.md#PlaceMailOrder) | **Post** /mail/order | places a mail order
[**SendAdvMail**](DefaultApi.md#SendAdvMail) | **Post** /mail/advsend | Sends an Email with Advanced Options
[**SendMail**](DefaultApi.md#SendMail) | **Post** /mail/send | Sends an Email
[**ValidateMailOrder**](DefaultApi.md#ValidateMailOrder) | **Get** /mail/order | validatess order details before placing an order
[**ViewMailLog**](DefaultApi.md#ViewMailLog) | **Get** /mail/log | displays the mail log

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

# **SendAdvMail**
> GenericResponse SendAdvMail(ctx, body, subject, body, from, to, id, replyto, cc, bcc, attachments)
Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
  **body** | [**SendMailAdv**](SendMailAdv.md)|  | 
  **subject** | **string**|  | 
  **body** | **string**|  | 
  **from** | [**[]SendMailAdvFrom**](SendMailAdvFrom.md)|  | 
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

# **SendMail**
> GenericResponse SendMail(ctx, to, from, subject, body, body)
Sends an Email

Sends An email through one of your mail orders.

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
  **to** | **string**|  | 
  **from** | **string**|  | 
  **subject** | **string**|  | 
  **body** | **string**|  | 
  **body** | [**SendMail**](SendMail.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
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

# **ViewMailLog**
> []MailLog ViewMailLog(ctx, optional)
displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
 **optional** | ***DefaultApiViewMailLogOpts** | optional parameters | nil if no parameters

### Optional Parameters
Optional parameters are passed through a pointer to a DefaultApiViewMailLogOpts struct
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

