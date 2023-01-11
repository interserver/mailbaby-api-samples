# .DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailOrders**](DefaultApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders
[**pingServer**](DefaultApi.md#pingServer) | **GET** /ping | Checks if the server is running
[**sendAdvMail**](DefaultApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](DefaultApi.md#sendMail) | **POST** /mail/send | Sends an Email
[**viewMailLog**](DefaultApi.md#viewMailLog) | **GET** /mail/log | displays the mail log


# **getMailOrders**
> Array<GetMailOrders200ResponseInner> getMailOrders()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .DefaultApi(configuration);

let body:any = {};

apiInstance.getMailOrders(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters
This endpoint does not need any parameter.


### Return type

**Array<GetMailOrders200ResponseInner>**

### Authorization

[apiKeyAuth](README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |
**404** | Unauthorized |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **pingServer**
> void pingServer()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .DefaultApi(configuration);

let body:any = {};

apiInstance.pingServer(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters
This endpoint does not need any parameter.


### Return type

**void**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Server is up and running |  -  |
**0** | Something is wrong |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **sendAdvMail**
> GenericResponse sendAdvMail(sendMailAdv)

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .DefaultApi(configuration);

let body:.DefaultApiSendAdvMailRequest = {
  // SendMailAdv
  sendMailAdv: {
    subject: "Your Package has been Delivered!",
    body: "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.",
    _from: {
      email: "business@company.com",
      name: "The Man",
    },
    to: [
      {
        email: "johndoe@isp.com",
        name: "John Doe",
      },
    ],
    replyto: [
      {
        email: "support@company.com",
        name: "Support Staff",
      },
    ],
    cc: [
      {
        email: "janedoe@isp.com",
        name: "Jane Doe",
      },
    ],
    bcc: [
      {
        email: "records@company.com",
        name: "Records Department",
      },
    ],
    attachments: [
      {
        filename: "company_logo.png",
        data: { data: Buffer.from(fs.readFileSync('/path/to/file', 'utf-8')), name: '/path/to/file' },
      },
    ],
    id: 5000,
  },
};

apiInstance.sendAdvMail(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sendMailAdv** | **SendMailAdv**|  |


### Return type

**GenericResponse**

### Authorization

[apiKeyAuth](README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
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
const apiInstance = new .DefaultApi(configuration);

let body:.DefaultApiSendMailRequest = {
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

# **viewMailLog**
> MailLog viewMailLog()

Get a listing of the emails sent through this system 

### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .DefaultApi(configuration);

let body:.DefaultApiViewMailLogRequest = {
  // number | The ID of your mail order this will be sent through. (optional)
  id: 2604,
  // string | originating ip address sending mail (optional)
  origin: "1.2.3.4",
  // string | mx record mail was sent to (optional)
  mx: "mx.google.com",
  // string | from email address (optional)
  _from: "me@sender.com",
  // string | to/destination email address (optional)
  to: "you@receiver.com",
  // string | subject containing this string (optional)
  subject: "Support",
  // string | mail id (optional)
  mailid: "185997065c60008840",
  // number | number of records to skip for pagination (optional)
  skip: 1000,
  // number | maximum number of records to return (optional)
  limit: 1000,
  // number | earliest date to get emails in unix timestamp format (optional)
  startDate: 1641781008,
  // number | earliest date to get emails in unix timestamp format (optional)
  endDate: 1673317008,
};

apiInstance.viewMailLog(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | [**number**] | The ID of your mail order this will be sent through. | (optional) defaults to undefined
 **origin** | [**string**] | originating ip address sending mail | (optional) defaults to undefined
 **mx** | [**string**] | mx record mail was sent to | (optional) defaults to undefined
 **_from** | [**string**] | from email address | (optional) defaults to undefined
 **to** | [**string**] | to/destination email address | (optional) defaults to undefined
 **subject** | [**string**] | subject containing this string | (optional) defaults to undefined
 **mailid** | [**string**] | mail id | (optional) defaults to undefined
 **skip** | [**number**] | number of records to skip for pagination | (optional) defaults to 0
 **limit** | [**number**] | maximum number of records to return | (optional) defaults to 100
 **startDate** | [**number**] | earliest date to get emails in unix timestamp format | (optional) defaults to undefined
 **endDate** | [**number**] | earliest date to get emails in unix timestamp format | (optional) defaults to undefined


### Return type

**MailLog**

### Authorization

[apiKeyAuth](README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | search results matching criteria |  -  |
**400** | bad input parameter |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)


