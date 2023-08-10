# {{classname}}

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**SendAdvMail**](SendingApi.md#SendAdvMail) | **Post** /mail/advsend | Sends an Email with Advanced Options
[**SendMail**](SendingApi.md#SendMail) | **Post** /mail/send | Sends an Email

# **SendAdvMail**
> GenericResponse SendAdvMail(ctx, subject, body, from, to, replyto, cc, bcc, attachments, id, body)
Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
  **subject** | **string**|  | 
  **body** | **string**|  | 
  **from** | [**EmailAddressName**](.md)|  | 
  **to** | [**[]EmailAddressName**](EmailAddressName.md)|  | 
  **replyto** | [**[]EmailAddressName**](EmailAddressName.md)|  | 
  **cc** | [**[]EmailAddressName**](EmailAddressName.md)|  | 
  **bcc** | [**[]EmailAddressName**](EmailAddressName.md)|  | 
  **attachments** | [**[]MailAttachment**](MailAttachment.md)|  | 
  **id** | **int64**|  | 
  **body** | [**SendMailAdv**](SendMailAdv.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **SendMail**
> GenericResponse SendMail(ctx, to, from, subject, body, body)
Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

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

