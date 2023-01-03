# DefaultApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getMailOrders**](DefaultApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders |
| [**pingServer**](DefaultApi.md#pingServer) | **GET** /ping | Checks if the server is running |
| [**sendAdvMail**](DefaultApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options |
| [**sendMail**](DefaultApi.md#sendMail) | **POST** /mail/send | Sends an Email |
| [**viewMailLog**](DefaultApi.md#viewMailLog) | **GET** /mail/log | displays the mail log |


<a name="getMailOrders"></a>
# **getMailOrders**
> List getMailOrders()

displays a list of mail service orders

### Parameters
This endpoint does not need any parameter.

### Return type

[**List**](../Models/getMailOrders_200_response_inner.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

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

<a name="sendAdvMail"></a>
# **sendAdvMail**
> GenericResponse sendAdvMail(SendMailAdv)

Sends an Email with Advanced Options

    Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **SendMailAdv** | [**SendMailAdv**](../Models/SendMailAdv.md)|  | |

### Return type

[**GenericResponse**](../Models/GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/json, application/x-www-form-urlencoded
- **Accept**: application/json

<a name="sendMail"></a>
# **sendMail**
> GenericResponse sendMail(to, from, subject, body)

Sends an Email

    Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **to** | **String**| The Contact whom is the primary recipient of this email. | [default to null] |
| **from** | **String**| The contact whom is the this email is from. | [default to null] |
| **subject** | **String**| The subject or title of the email | [default to null] |
| **body** | **String**| The main email contents. | [default to null] |

### Return type

[**GenericResponse**](../Models/GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded, application/json
- **Accept**: application/json

<a name="viewMailLog"></a>
# **viewMailLog**
> MailLog viewMailLog(id, search, skip, limit, startDate, endDate)

displays the mail log

    By passing in the appropriate options, you can search for available inventory in the system 

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| The ID of your mail order this will be sent through. | [optional] [default to null] |
| **search** | **String**| pass an optional search string for looking up inventory | [optional] [default to null] |
| **skip** | **Integer**| number of records to skip for pagination | [optional] [default to 0] |
| **limit** | **Integer**| maximum number of records to return | [optional] [default to 100] |
| **startDate** | **Long**| earliest date to get emails in unix timestamp format | [optional] [default to null] |
| **endDate** | **Long**| earliest date to get emails in unix timestamp format | [optional] [default to null] |

### Return type

[**MailLog**](../Models/MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

