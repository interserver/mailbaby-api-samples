# DEFAULT_API

All URIs are relative to *https://api.mailbaby.net*

Feature | HTTP request | Description
------------- | ------------- | -------------
[**mail_orders**](DEFAULT_API.md#mail_orders) | **Get** /mail | displays a list of mail service orders
[**ping_server**](DEFAULT_API.md#ping_server) | **Get** /ping | Checks if the server is running
[**send_adv_mail**](DEFAULT_API.md#send_adv_mail) | **Post** /mail/advsend | Sends an Email with Advanced Options
[**send_mail**](DEFAULT_API.md#send_mail) | **Post** /mail/send | Sends an Email
[**view_mail_log**](DEFAULT_API.md#view_mail_log) | **Get** /mail/log | displays the mail log


# **mail_orders**
> mail_orders : detachable LIST [GET_MAIL_ORDERS_200_RESPONSE_INNER]


displays a list of mail service orders


### Parameters
This endpoint does not need any parameter.

### Return type

[**LIST [GET_MAIL_ORDERS_200_RESPONSE_INNER]**](getMailOrders_200_response_inner.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

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

# **send_adv_mail**
> send_adv_mail (send_mail_adv: SEND_MAIL_ADV ): detachable GENERIC_RESPONSE


Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **send_mail_adv** | [**SEND_MAIL_ADV**](SEND_MAIL_ADV.md)|  | 

### Return type

[**GENERIC_RESPONSE**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_mail**
> send_mail (to: STRING_32 ; var_from: STRING_32 ; subject: STRING_32 ; body: STRING_32 ): detachable GENERIC_RESPONSE


Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **STRING_32**| The Contact whom is the primary recipient of this email. | [default to null]
 **var_from** | **STRING_32**| The contact whom is the this email is from. | [default to null]
 **subject** | **STRING_32**| The subject or title of the email | [default to null]
 **body** | **STRING_32**| The main email contents. | [default to null]

### Return type

[**GENERIC_RESPONSE**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **view_mail_log**
> view_mail_log (id:  detachable INTEGER_64 ; search:  detachable STRING_32 ; skip:  detachable INTEGER_32 ; limit:  detachable INTEGER_32 ): detachable MAIL_LOG


displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **INTEGER_64**| The ID of your mail order this will be sent through. | [optional] [default to null]
 **search** | **STRING_32**| pass an optional search string for looking up inventory | [optional] [default to null]
 **skip** | **INTEGER_32**| number of records to skip for pagination | [optional] [default to 0]
 **limit** | **INTEGER_32**| maximum number of records to return | [optional] [default to 100]

### Return type

[**MAIL_LOG**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

