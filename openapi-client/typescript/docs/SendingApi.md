# .SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sendAdvMail**](SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](SendingApi.md#sendMail) | **POST** /mail/send | Sends an Email


# **sendAdvMail**
> GenericResponse sendAdvMail()

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ```BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ```ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ```NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ```MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ```MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ```MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ```BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }\' ```  ```ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }\' ```  ```NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }\' ``` 

### Example


```typescript
import { createConfiguration, SendingApi } from '';
import type { SendingApiSendAdvMailRequest } from '';

const configuration = createConfiguration();
const apiInstance = new SendingApi(configuration);

const request: SendingApiSendAdvMailRequest = {
    // The subject or title of the email
  subject: "Your Package has been Delivered!",
    // The main email contents.
  body: "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.",
  
  _from: null,
  
  to: null,
  
  replyto: null,
  
  cc: null,
  
  bcc: null,
    // (optional) File attachments to include in the email.  The file contents must be base64 encoded! (optional)
  attachments: [
    {
      filename: "message.txt",
      data: "aGVsbG8gdGhlcmUK",
    },
  ],
    // (optional)  ID of the Mail order within our system to use as the Mail Account. (optional)
  id: 5000,
};

const data = await apiInstance.sendAdvMail(request);
console.log('API called successfully. Returned data:', data);
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | [**string**] | The subject or title of the email | defaults to undefined
 **body** | [**string**] | The main email contents. | defaults to undefined
 **_from** | **EmailAddressTypes** |  | defaults to undefined
 **to** | **EmailAddressesTypes** |  | defaults to undefined
 **replyto** | **EmailAddressesTypes** |  | (optional) defaults to undefined
 **cc** | **EmailAddressesTypes** |  | (optional) defaults to undefined
 **bcc** | **EmailAddressesTypes** |  | (optional) defaults to undefined
 **attachments** | **Array&lt;MailAttachment&gt;** | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | (optional) defaults to undefined
 **id** | [**number**] | (optional)  ID of the Mail order within our system to use as the Mail Account. | (optional) defaults to undefined


### Return type

**GenericResponse**

### Authorization

[apiKeyAuth](README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | search results matching criteria |  -  |
**400** | Error message when there was a problem with the input parameters. |  -  |
**401** | Unauthorized |  -  |
**404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **sendMail**
> GenericResponse sendMail()

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example


```typescript
import { createConfiguration, SendingApi } from '';
import type { SendingApiSendMailRequest } from '';

const configuration = createConfiguration();
const apiInstance = new SendingApi(configuration);

const request: SendingApiSendMailRequest = {
    // The Contact whom is the primary recipient of this email.
  to: "johndoe@company.com",
    // The contact whom is the this email is from.
  _from: "janedoe@company.com",
    // The subject or title of the email
  subject: "Attention Client",
    // The main email contents.
  body: "This is an email to inform you that something noteworthy happened.",
};

const data = await apiInstance.sendMail(request);
console.log('API called successfully. Returned data:', data);
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | [**string**] | The Contact whom is the primary recipient of this email. | defaults to undefined
 **_from** | [**string**] | The contact whom is the this email is from. | defaults to undefined
 **subject** | [**string**] | The subject or title of the email | defaults to undefined
 **body** | [**string**] | The main email contents. | defaults to undefined


### Return type

**GenericResponse**

### Authorization

[apiKeyAuth](README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | search results matching criteria |  -  |
**400** | Error message when there was a problem with the input parameters. |  -  |
**401** | Unauthorized |  -  |
**404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)


