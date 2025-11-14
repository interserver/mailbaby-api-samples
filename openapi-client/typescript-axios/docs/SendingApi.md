# SendingApi

All URIs are relative to *https://api.mailbaby.net*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**rawMail**](#rawmail) | **POST** /mail/rawsend | Sends a raw email|
|[**sendAdvMail**](#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options|
|[**sendMail**](#sendmail) | **POST** /mail/send | Sends an Email|

# **rawMail**
> GenericResponse rawMail(sendMailRaw)

This call will let you pass the raw / complete email contents (including headers) as a string and have it get sent as-is.  This is useful for things like DKIM signed messages.

### Example

```typescript
import {
    SendingApi,
    Configuration,
    SendMailRaw
} from './api';

const configuration = new Configuration();
const apiInstance = new SendingApi(configuration);

let sendMailRaw: SendMailRaw; //

const { status, data } = await apiInstance.rawMail(
    sendMailRaw
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **sendMailRaw** | **SendMailRaw**|  | |


### Return type

**GenericResponse**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | successful email response |  -  |
|**400** | Error message when there was a problem with the input parameters. |  -  |
|**401** | Unauthorized |  -  |
|**404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **sendAdvMail**
> GenericResponse sendAdvMail()

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ```BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ```ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ```NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ```MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ```MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ```MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ```BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }\' ```  ```ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }\' ```  ```NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }\' ``` 

### Example

```typescript
import {
    SendingApi,
    Configuration,
    EmailAddressTypes,
    EmailAddressesTypes,
    EmailAddressesTypes,
    EmailAddressesTypes,
    EmailAddressesTypes
} from './api';

const configuration = new Configuration();
const apiInstance = new SendingApi(configuration);

let subject: string; //The subject or title of the email (default to undefined)
let body: string; //The main email contents. (default to undefined)
let from: EmailAddressTypes; // (default to undefined)
let to: EmailAddressesTypes; // (default to undefined)
let replyto: EmailAddressesTypes; // (optional) (default to undefined)
let cc: EmailAddressesTypes; // (optional) (default to undefined)
let bcc: EmailAddressesTypes; // (optional) (default to undefined)
let attachments: Array<MailAttachment>; //(optional) File attachments to include in the email.  The file contents must be base64 encoded! (optional) (default to undefined)
let id: number; //(optional)  ID of the Mail order within our system to use as the Mail Account. (optional) (default to undefined)

const { status, data } = await apiInstance.sendAdvMail(
    subject,
    body,
    from,
    to,
    replyto,
    cc,
    bcc,
    attachments,
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **subject** | [**string**] | The subject or title of the email | defaults to undefined|
| **body** | [**string**] | The main email contents. | defaults to undefined|
| **from** | **EmailAddressTypes** |  | defaults to undefined|
| **to** | **EmailAddressesTypes** |  | defaults to undefined|
| **replyto** | **EmailAddressesTypes** |  | (optional) defaults to undefined|
| **cc** | **EmailAddressesTypes** |  | (optional) defaults to undefined|
| **bcc** | **EmailAddressesTypes** |  | (optional) defaults to undefined|
| **attachments** | **Array&lt;MailAttachment&gt;** | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | (optional) defaults to undefined|
| **id** | [**number**] | (optional)  ID of the Mail order within our system to use as the Mail Account. | (optional) defaults to undefined|


### Return type

**GenericResponse**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | search results matching criteria |  -  |
|**400** | Error message when there was a problem with the input parameters. |  -  |
|**401** | Unauthorized |  -  |
|**404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **sendMail**
> GenericResponse sendMail()

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example

```typescript
import {
    SendingApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new SendingApi(configuration);

let to: string; //The Contact whom is the primary recipient of this email. (default to undefined)
let from: string; //The contact whom is the this email is from. (default to undefined)
let subject: string; //The subject or title of the email (default to undefined)
let body: string; //The main email contents. (default to undefined)
let id: number; //Optional Order ID (optional) (default to undefined)

const { status, data } = await apiInstance.sendMail(
    to,
    from,
    subject,
    body,
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **to** | [**string**] | The Contact whom is the primary recipient of this email. | defaults to undefined|
| **from** | [**string**] | The contact whom is the this email is from. | defaults to undefined|
| **subject** | [**string**] | The subject or title of the email | defaults to undefined|
| **body** | [**string**] | The main email contents. | defaults to undefined|
| **id** | [**number**] | Optional Order ID | (optional) defaults to undefined|


### Return type

**GenericResponse**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | search results matching criteria |  -  |
|**400** | Error message when there was a problem with the input parameters. |  -  |
|**401** | Unauthorized |  -  |
|**404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

