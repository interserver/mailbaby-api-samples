# \DefaultApi

All URIs are relative to *http://mystage.interserver.net:8787*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_mail_orders**](DefaultApi.md#get_mail_orders) | **get** /mail | displays a list of mail service orders
[**ping_server**](DefaultApi.md#ping_server) | **get** /ping | Checks if the server is running
[**place_mail_order**](DefaultApi.md#place_mail_order) | **post** /mail/order | places a mail order
[**send_adv_mail**](DefaultApi.md#send_adv_mail) | **post** /mail/advsend | Sends an Email with Advanced Options
[**send_mail**](DefaultApi.md#send_mail) | **post** /mail/send | Sends an Email
[**validate_mail_order**](DefaultApi.md#validate_mail_order) | **get** /mail/order | validatess order details before placing an order
[**view_mail_log**](DefaultApi.md#view_mail_log) | **get** /mail/log | displays the mail log



## get_mail_orders

> Vec<crate::models::MailOrder> get_mail_orders(id)
displays a list of mail service orders

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**id** | Option<**i64**> | The ID of your mail order this will be sent through. |  |

### Return type

[**Vec<crate::models::MailOrder>**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml, text/plain

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


## place_mail_order

> place_mail_order(mail_order)
places a mail order

Adds an item to the system

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**mail_order** | Option<[**MailOrder**](MailOrder.md)> | Inventory item to add |  |

### Return type

 (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

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

Sends An email through one of your mail orders.

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


## validate_mail_order

> validate_mail_order()
validatess order details before placing an order

### Parameters

This endpoint does not need any parameter.

### Return type

 (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## view_mail_log

> Vec<crate::models::MailLog> view_mail_log(id, search_string, skip, limit)
displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**id** | Option<**i64**> | The ID of your mail order this will be sent through. |  |
**search_string** | Option<**String**> | pass an optional search string for looking up inventory |  |
**skip** | Option<**i32**> | number of records to skip for pagination |  |
**limit** | Option<**i32**> | maximum number of records to return |  |

### Return type

[**Vec<crate::models::MailLog>**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

