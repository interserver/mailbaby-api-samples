# .SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sendAdvMail**](SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](SendingApi.md#sendMail) | **POST** /mail/send | Sends an Email


# **sendAdvMail**
> GenericResponse sendAdvMail()

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SendingApi(configuration);

let body:.SendingApiSendAdvMailRequest = {
  // string | The subject or title of the email
  subject: "Your Package has been Delivered!",
  // string | The main email contents.
  body: "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.",
  // EmailAddressName
  _from: {
    email: "user@domain.com",
    name: "John Smith",
  },
  // Array<EmailAddressName> | A list of destionation email addresses to send this to
  to: [
    {
      email: "user@domain.com",
      name: "John Smith",
    },
  ],
  // Array<EmailAddressName> | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. (optional)
  replyto: [
    {
      email: "user@domain.com",
      name: "John Smith",
    },
  ],
  // Array<EmailAddressName> | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. (optional)
  cc: [
    {
      email: "user@domain.com",
      name: "John Smith",
    },
  ],
  // Array<EmailAddressName> | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. (optional)
  bcc: [
    {
      email: "user@domain.com",
      name: "John Smith",
    },
  ],
  // Array<MailAttachment> | (optional) File attachments to include in the email.  The file contents must be base64 encoded! (optional)
  attachments: [
    {
      filename: "message.txt",
      data: "aGVsbG8gdGhlcmUK",
    },
  ],
  // number | (optional)  ID of the Mail order within our system to use as the Mail Account. (optional)
  id: 5000,
};

apiInstance.sendAdvMail(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | [**string**] | The subject or title of the email | defaults to undefined
 **body** | [**string**] | The main email contents. | defaults to undefined
 **_from** | **EmailAddressName** |  | defaults to undefined
 **to** | **Array&lt;EmailAddressName&gt;** | A list of destionation email addresses to send this to | defaults to undefined
 **replyto** | **Array&lt;EmailAddressName&gt;** | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | (optional) defaults to undefined
 **cc** | **Array&lt;EmailAddressName&gt;** | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | (optional) defaults to undefined
 **bcc** | **Array&lt;EmailAddressName&gt;** | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | (optional) defaults to undefined
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
**400** | The specified resource was not found |  -  |
**401** | Unauthorized |  -  |
**404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **sendMail**
> GenericResponse sendMail()

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SendingApi(configuration);

let body:.SendingApiSendMailRequest = {
  // string | The Contact whom is the primary recipient of this email.
  to: "johndoe@company.com",
  // string | The contact whom is the this email is from.
  _from: "janedoe@company.com",
  // string | The subject or title of the email
  subject: "Attention Client",
  // string | The main email contents.
  body: "This is an email to inform you that something noteworthy happened.",
};

apiInstance.sendMail(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
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
**400** | The specified resource was not found |  -  |
**401** | Unauthorized |  -  |
**404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)


