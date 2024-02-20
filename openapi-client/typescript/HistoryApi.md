# .HistoryApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStats**](HistoryApi.md#getStats) | **GET** /mail/stats | Account usage statistics.
[**viewMailLog**](HistoryApi.md#viewMailLog) | **GET** /mail/log | displays the mail log


# **getStats**
> Array<GetStats200ResponseInner> getStats()

Returns information about the usage on your mail accounts.

### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .HistoryApi(configuration);

let body:any = {};

apiInstance.getStats(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters
This endpoint does not need any parameter.


### Return type

**Array<GetStats200ResponseInner>**

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

# **viewMailLog**
> MailLog viewMailLog()

Get a listing of the emails sent through this system 

### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .HistoryApi(configuration);

let body:.HistoryApiViewMailLogRequest = {
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


