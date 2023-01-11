# DefaultApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailOrders**](DefaultApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders
[**pingServer**](DefaultApi.md#pingServer) | **GET** /ping | Checks if the server is running
[**sendAdvMail**](DefaultApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](DefaultApi.md#sendMail) | **POST** /mail/send | Sends an Email
[**viewMailLog**](DefaultApi.md#viewMailLog) | **GET** /mail/log | displays the mail log



## getMailOrders

displays a list of mail service orders

### Example

```bash
 getMailOrders
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**array[GetMailOrders200ResponseInner]**](GetMailOrders200ResponseInner.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

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


## sendAdvMail

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example

```bash
 sendAdvMail
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sendMailAdv** | [**SendMailAdv**](SendMailAdv.md) |  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/json, application/x-www-form-urlencoded
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## sendMail

Sends an Email

Sends an email through one of your mail orders.

*Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead.

### Example

```bash
 sendMail
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **string** | The Contact whom is the primary recipient of this email. | [default to null]
 **from** | **string** | The contact whom is the this email is from. | [default to null]
 **subject** | **string** | The subject or title of the email | [default to null]
 **body** | **string** | The main email contents. | [default to null]

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded, application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## viewMailLog

displays the mail log

Get a listing of the emails sent through this system

### Example

```bash
 viewMailLog  id=value  origin=value  mx=value  from=value  to=value  subject=value  mailid=value  skip=value  limit=value  startDate=value  endDate=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer** | The ID of your mail order this will be sent through. | [optional] [default to null]
 **origin** | **string** | originating ip address sending mail | [optional] [default to null]
 **mx** | **string** | mx record mail was sent to | [optional] [default to null]
 **from** | **string** | from email address | [optional] [default to null]
 **to** | **string** | to/destination email address | [optional] [default to null]
 **subject** | **string** | subject containing this string | [optional] [default to null]
 **mailid** | **string** | mail id | [optional] [default to null]
 **skip** | **integer** | number of records to skip for pagination | [optional] [default to 0]
 **limit** | **integer** | maximum number of records to return | [optional] [default to 100]
 **startDate** | **integer** | earliest date to get emails in unix timestamp format | [optional] [default to null]
 **endDate** | **integer** | earliest date to get emails in unix timestamp format | [optional] [default to null]

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

