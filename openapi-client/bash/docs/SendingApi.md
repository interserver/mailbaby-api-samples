# SendingApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**rawMail**](SendingApi.md#rawMail) | **POST** /mail/rawsend | Sends a raw email
[**sendAdvMail**](SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](SendingApi.md#sendMail) | **POST** /mail/send | Sends an Email



## rawMail

Sends a raw email

This call will let you pass the raw / complete email contents (including headers) as a string and have it get sent as-is.  This is useful for things like DKIM signed messages.

### Example

```bash
 rawMail
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rawMail** | [**RawMail**](RawMail.md) |  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/json, multipart/form-data
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## sendAdvMail

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.

'''BasicForm
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/x-www-form-urlencoded' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data 'subject=Welcome' \\
--data 'body=Hello' \\
--data from=user@domain.com \\
--data to=support@interserver.net
'''

'''ArrayForm
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/x-www-form-urlencoded' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data 'subject=Welcome' \\
--data 'body=Hello' \\
--data from=user@domain.com \\
--data \"to[0][name]=Joe\" \\
--data \"to[0][email]=support@interserver.net\"
'''

'''NameEmailForm
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/x-www-form-urlencoded' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data 'subject=Welcome' \\
--data 'body=Hello' \\
--data from=\"Joe <user@domain.com>\" \\
--data to=\"Joe <support@interserver.net>\"
'''

'''MultToForm
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/x-www-form-urlencoded' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data 'subject=Welcome' \\
--data 'body=Hello' \\
--data from=user@domain.com \\
--data \"to=support@interserver.net, support@interserver.net\"
'''

'''MultToFullForm
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/x-www-form-urlencoded' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data 'subject=Welcome' \\
--data 'body=Hello' \\
--data from=user@domain.com \\
--data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\"
'''

'''MultToArrayForm
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/x-www-form-urlencoded' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data 'subject=Welcome' \\
--data 'body=Hello' \\
--data from=user@domain.com \\
--data \"to[0][name]=Joe\" \\
--data \"to[0][email]=support@interserver.net\" \\
--data \"to[1][name]=Joe\" \\
--data \"to[1][email]=support@interserver.net\"
'''

'''BasicJson
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/json' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data '{
\"subject\": \"Welcome\",
\"body\": \"Hello\",
\"from\": \"user@domain.com\",
\"to\": \"support@interserver.net\"
}'
'''

'''ArrayJson
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/json' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data '{
\"subject\": \"Welcome\",
\"body\": \"Hello\",
\"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"},
\"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}]
}'
'''

'''NameEmailJson
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/json' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data '{
\"subject\": \"Welcome\",
\"body\": \"Hello\",
\"from\": \"Joe <user@domain.com>\",
\"to\": \"Joe <support@interserver.net>\"
}'
'''

### Example

```bash
 sendAdvMail
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **string** | The subject or title of the email | [default to null]
 **body** | **string** | The main email contents. | [default to null]
 **from** | [**EmailAddressTypes**](EmailAddressTypes.md) |  | [default to null]
 **to** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [default to null]
 **replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] [default to null]
 **cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] [default to null]
 **bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] [default to null]
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

