# DEFAULT_API

All URIs are relative to *https://api.mailbaby.net*

Feature | HTTP request | Description
------------- | ------------- | -------------
[**mail_by_id**](DEFAULT_API.md#mail_by_id) | **Get** /mail/{id} | Gets mail order information by id
[**mail_orders**](DEFAULT_API.md#mail_orders) | **Get** /mail | displays a list of mail service orders
[**ping_server**](DEFAULT_API.md#ping_server) | **Get** /ping | Checks if the server is running
[**place_mail_order**](DEFAULT_API.md#place_mail_order) | **Post** /mail/order | places a mail order
[**send_adv_mail_by_id**](DEFAULT_API.md#send_adv_mail_by_id) | **Post** /mail/{id}/advsend | Sends an Email with Advanced Options
[**send_mail_by_id**](DEFAULT_API.md#send_mail_by_id) | **Post** /mail/{id}/send | Sends an Email
[**validate_mail_order**](DEFAULT_API.md#validate_mail_order) | **Get** /mail/order | validatess order details before placing an order
[**view_mail_log_by_id**](DEFAULT_API.md#view_mail_log_by_id) | **Get** /mail/{id}/log | displays the mail log


# **mail_by_id**
> mail_by_id (id: INTEGER_64 ): detachable MAIL_ORDER
	

Gets mail order information by id

returns information about a mail order in the system with the given id.


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **INTEGER_64**| User ID | [default to null]

### Return type

[**MAIL_ORDER**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mail_orders**
> mail_orders : detachable LIST [MAIL_ORDER]
	

displays a list of mail service orders


### Parameters
This endpoint does not need any parameter.

### Return type

[**LIST [MAIL_ORDER]**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **ping_server**
> ping_server 
	

Checks if the server is running


### Parameters
This endpoint does not need any parameter.

### Return type

{empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **place_mail_order**
> place_mail_order (mail_order:  detachable MAIL_ORDER )
	

places a mail order

Adds an item to the system


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **mail_order** | [**MAIL_ORDER**](MAIL_ORDER.md)| Inventory item to add | [optional] 

### Return type

{empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_adv_mail_by_id**
> send_adv_mail_by_id (id: INTEGER_64 ; send_mail: SEND_MAIL ): detachable GENERIC_RESPONSE
	

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **INTEGER_64**| User ID | [default to null]
 **send_mail** | [**SEND_MAIL**](SEND_MAIL.md)|  | 

### Return type

[**GENERIC_RESPONSE**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/xml, application/x-www-form-urlencoded, text/plain
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_mail_by_id**
> send_mail_by_id (id: INTEGER_64 ; subject:  detachable STRING_32 ; body:  detachable STRING_32 ; to:  detachable STRING_32 ; to_name:  detachable STRING_32 ; var_from:  detachable STRING_32 ; from_name:  detachable STRING_32 ): detachable GENERIC_RESPONSE
	

Sends an Email

Sends An email through one of your mail orders.


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **INTEGER_64**| User ID | [default to null]
 **subject** | **STRING_32**|  | [optional] [default to null]
 **body** | **STRING_32**|  | [optional] [default to null]
 **to** | **STRING_32**|  | [optional] [default to null]
 **to_name** | **STRING_32**|  | [optional] [default to null]
 **var_from** | **STRING_32**|  | [optional] [default to null]
 **from_name** | **STRING_32**|  | [optional] [default to null]

### Return type

[**GENERIC_RESPONSE**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **validate_mail_order**
> validate_mail_order 
	

validatess order details before placing an order


### Parameters
This endpoint does not need any parameter.

### Return type

{empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **view_mail_log_by_id**
> view_mail_log_by_id (id: INTEGER_64 ; search_string:  detachable STRING_32 ; skip:  detachable INTEGER_32 ; limit:  detachable INTEGER_32 ): detachable LIST [MAIL_LOG]
	

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **INTEGER_64**| User ID | [default to null]
 **search_string** | **STRING_32**| pass an optional search string for looking up inventory | [optional] [default to null]
 **skip** | **INTEGER_32**| number of records to skip for pagination | [optional] [default to null]
 **limit** | **INTEGER_32**| maximum number of records to return | [optional] [default to null]

### Return type

[**LIST [MAIL_LOG]**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
