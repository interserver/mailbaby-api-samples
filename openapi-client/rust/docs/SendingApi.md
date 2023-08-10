# \SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**send_adv_mail**](SendingApi.md#send_adv_mail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**send_mail**](SendingApi.md#send_mail) | **POST** /mail/send | Sends an Email



## send_adv_mail

> crate::models::GenericResponse send_adv_mail(subject, body, from, to, replyto, cc, bcc, attachments, id)
Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**subject** | **String** | The subject or title of the email | [required] |
**body** | **String** | The main email contents. | [required] |
**from** | [**crate::models::EmailAddressName**](EmailAddressName.md) |  | [required] |
**to** | [**Vec<crate::models::EmailAddressName>**](crate::models::EmailAddressName.md) | A list of destionation email addresses to send this to | [required] |
**replyto** | Option<[**Vec<crate::models::EmailAddressName>**](crate::models::EmailAddressName.md)> | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. |  |
**cc** | Option<[**Vec<crate::models::EmailAddressName>**](crate::models::EmailAddressName.md)> | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. |  |
**bcc** | Option<[**Vec<crate::models::EmailAddressName>**](crate::models::EmailAddressName.md)> | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. |  |
**attachments** | Option<[**Vec<crate::models::MailAttachment>**](crate::models::MailAttachment.md)> | (optional) File attachments to include in the email.  The file contents must be base64 encoded! |  |
**id** | Option<**i64**> | (optional)  ID of the Mail order within our system to use as the Mail Account. |  |

### Return type

[**crate::models::GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded, application/json
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

