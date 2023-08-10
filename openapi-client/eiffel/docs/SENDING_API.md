# SENDING_API

All URIs are relative to *https://api.mailbaby.net*

Feature | HTTP request | Description
------------- | ------------- | -------------
[**send_adv_mail**](SENDING_API.md#send_adv_mail) | **Post** /mail/advsend | Sends an Email with Advanced Options
[**send_mail**](SENDING_API.md#send_mail) | **Post** /mail/send | Sends an Email


# **send_adv_mail**
> send_adv_mail (subject: STRING_32 ; body: STRING_32 ; var_from: EMAIL_ADDRESS_NAME ; to: LIST [EMAIL_ADDRESS_NAME] ; replyto:  detachable LIST [EMAIL_ADDRESS_NAME] ; cc:  detachable LIST [EMAIL_ADDRESS_NAME] ; bcc:  detachable LIST [EMAIL_ADDRESS_NAME] ; attachments:  detachable LIST [MAIL_ATTACHMENT] ; id:  detachable INTEGER_64 ): detachable GENERIC_RESPONSE


Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **STRING_32**| The subject or title of the email | [default to null]
 **body** | **STRING_32**| The main email contents. | [default to null]
 **var_from** | [**EMAIL_ADDRESS_NAME**](EmailAddressName.md)|  | [default to null]
 **to** | [**LIST [EMAIL_ADDRESS_NAME]**](EMAIL_ADDRESS_NAME.md)| A list of destionation email addresses to send this to | [default to null]
 **replyto** | [**LIST [EMAIL_ADDRESS_NAME]**](EMAIL_ADDRESS_NAME.md)| (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional] [default to null]
 **cc** | [**LIST [EMAIL_ADDRESS_NAME]**](EMAIL_ADDRESS_NAME.md)| (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] [default to null]
 **bcc** | [**LIST [EMAIL_ADDRESS_NAME]**](EMAIL_ADDRESS_NAME.md)| (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] [default to null]
 **attachments** | [**LIST [MAIL_ATTACHMENT]**](MAIL_ATTACHMENT.md)| (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] [default to null]
 **id** | **INTEGER_64**| (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] [default to null]

### Return type

[**GENERIC_RESPONSE**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
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

