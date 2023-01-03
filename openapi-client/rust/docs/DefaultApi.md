# \DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_mail_orders**](DefaultApi.md#get_mail_orders) | **GET** /mail | displays a list of mail service orders
[**ping_server**](DefaultApi.md#ping_server) | **GET** /ping | Checks if the server is running
[**send_adv_mail**](DefaultApi.md#send_adv_mail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**send_mail**](DefaultApi.md#send_mail) | **POST** /mail/send | Sends an Email
[**view_mail_log**](DefaultApi.md#view_mail_log) | **GET** /mail/log | displays the mail log



## get_mail_orders

> Vec<crate::models::GetMailOrders200ResponseInner> get_mail_orders()
displays a list of mail service orders

### Parameters

This endpoint does not need any parameter.

### Return type

[**Vec<crate::models::GetMailOrders200ResponseInner>**](getMailOrders_200_response_inner.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## ping_server

> ping_server()
Checks if the server is running

### Parameters

This endpoint does not need any parameter.

### Return type

 (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## send_adv_mail

> crate::models::GenericResponse send_adv_mail(send_mail_adv)
Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**send_mail_adv** | [**SendMailAdv**](SendMailAdv.md) |  | [required] |

### Return type

[**crate::models::GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/json, application/x-www-form-urlencoded
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## send_mail

> crate::models::GenericResponse send_mail(to, from, subject, body)
Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**to** | **String** | The Contact whom is the primary recipient of this email. | [required] |
**from** | **String** | The contact whom is the this email is from. | [required] |
**subject** | **String** | The subject or title of the email | [required] |
**body** | **String** | The main email contents. | [required] |

### Return type

[**crate::models::GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded, application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## view_mail_log

> crate::models::MailLog view_mail_log(id, search, skip, limit, start_date, end_date)
displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**id** | Option<**i64**> | The ID of your mail order this will be sent through. |  |
**search** | Option<**String**> | pass an optional search string for looking up inventory |  |
**skip** | Option<**i32**> | number of records to skip for pagination |  |[default to 0]
**limit** | Option<**i32**> | maximum number of records to return |  |[default to 100]
**start_date** | Option<**i64**> | earliest date to get emails in unix timestamp format |  |
**end_date** | Option<**i64**> | earliest date to get emails in unix timestamp format |  |

### Return type

[**crate::models::MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

