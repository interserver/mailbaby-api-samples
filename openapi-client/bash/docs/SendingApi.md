# SendingApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**sendAdvMail**](SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](SendingApi.md#sendMail) | **POST** /mail/send | Sends an Email



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
 **subject** | **string** | The subject or title of the email | [default to null]
 **body** | **string** | The main email contents. | [default to null]
 **from** | [**EmailAddressName**](EmailAddressName.md) |  | [default to null]
 **to** | [**array[EmailAddressName]**](EmailAddressName.md) | A list of destionation email addresses to send this to | [default to null]
 **replyto** | [**array[EmailAddressName]**](EmailAddressName.md) | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional] [default to null]
 **cc** | [**array[EmailAddressName]**](EmailAddressName.md) | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] [default to null]
 **bcc** | [**array[EmailAddressName]**](EmailAddressName.md) | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] [default to null]
 **attachments** | [**array[MailAttachment]**](MailAttachment.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] [default to null]
 **id** | **integer** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] [default to null]

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded, application/json
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

