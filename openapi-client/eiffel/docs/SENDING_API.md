# SENDING_API

All URIs are relative to *https://api.mailbaby.net*

Feature | HTTP request | Description
------------- | ------------- | -------------
[**raw_mail**](SENDING_API.md#raw_mail) | **Post** /mail/rawsend | Sends a raw email
[**send_adv_mail**](SENDING_API.md#send_adv_mail) | **Post** /mail/advsend | Sends an Email with Advanced Options
[**send_mail**](SENDING_API.md#send_mail) | **Post** /mail/send | Sends an Email


# **raw_mail**
> raw_mail (send_mail_raw: SEND_MAIL_RAW ): detachable GENERIC_RESPONSE


Sends a raw email

This call will let you pass the raw / complete email contents (including headers) as a string and have it get sent as-is.  This is useful for things like DKIM signed messages.


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **send_mail_raw** | [**SEND_MAIL_RAW**](SEND_MAIL_RAW.md)|  | 

### Return type

[**GENERIC_RESPONSE**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_adv_mail**
> send_adv_mail (subject: STRING_32 ; body: STRING_32 ; var_from: EMAIL_ADDRESS_TYPES ; to: EMAIL_ADDRESSES_TYPES ; replyto:  detachable EMAIL_ADDRESSES_TYPES ; cc:  detachable EMAIL_ADDRESSES_TYPES ; bcc:  detachable EMAIL_ADDRESSES_TYPES ; attachments:  detachable LIST [MAIL_ATTACHMENT] ; id:  detachable INTEGER_64 ): detachable GENERIC_RESPONSE


Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ```BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ```ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ```NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ```MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ```MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ```MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ```BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }' ```  ```ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }' ```  ```NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }' ``` 


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **STRING_32**| The subject or title of the email | [default to null]
 **body** | **STRING_32**| The main email contents. | [default to null]
 **var_from** | [**EMAIL_ADDRESS_TYPES**](EmailAddressTypes.md)|  | [default to null]
 **to** | [**EMAIL_ADDRESSES_TYPES**](EmailAddressesTypes.md)|  | [default to null]
 **replyto** | [**EMAIL_ADDRESSES_TYPES**](EmailAddressesTypes.md)|  | [optional] [default to null]
 **cc** | [**EMAIL_ADDRESSES_TYPES**](EmailAddressesTypes.md)|  | [optional] [default to null]
 **bcc** | [**EMAIL_ADDRESSES_TYPES**](EmailAddressesTypes.md)|  | [optional] [default to null]
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
> send_mail (to: STRING_32 ; var_from: STRING_32 ; subject: STRING_32 ; body: STRING_32 ; id:  detachable INTEGER_32 ): detachable GENERIC_RESPONSE


Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **STRING_32**| The Contact whom is the primary recipient of this email. | [default to null]
 **var_from** | **STRING_32**| The contact whom is the this email is from. | [default to null]
 **subject** | **STRING_32**| The subject or title of the email | [default to null]
 **body** | **STRING_32**| The main email contents. | [default to null]
 **id** | **INTEGER_32**| Optional Order ID | [optional] [default to null]

### Return type

[**GENERIC_RESPONSE**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

