# HistoryApi

All URIs are relative to *https://api.mailbaby.net*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**getStats**](#getstats) | **GET** /mail/stats | Account usage statistics.|
|[**viewMailLog**](#viewmaillog) | **GET** /mail/log | displays the mail log|

# **getStats**
> MailStatsType getStats()

Returns information about the usage on your mail accounts.

### Example

```typescript
import {
    HistoryApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new HistoryApi(configuration);

let time: 'all' | 'billing' | 'month' | '7d' | '24h' | '1d' | '1h'; //The timeframe for the statistics. (optional) (default to undefined)

const { status, data } = await apiInstance.getStats(
    time
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **time** | [**&#39;all&#39; | &#39;billing&#39; | &#39;month&#39; | &#39;7d&#39; | &#39;24h&#39; | &#39;1d&#39; | &#39;1h&#39;**]**Array<&#39;all&#39; &#124; &#39;billing&#39; &#124; &#39;month&#39; &#124; &#39;7d&#39; &#124; &#39;24h&#39; &#124; &#39;1d&#39; &#124; &#39;1h&#39;>** | The timeframe for the statistics. | (optional) defaults to undefined|


### Return type

**MailStatsType**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |
|**401** | Unauthorized |  -  |
|**404** | Unauthorized |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **viewMailLog**
> MailLog viewMailLog()

Get a listing of the emails sent through this system 

### Example

```typescript
import {
    HistoryApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new HistoryApi(configuration);

let id: number; //The ID of your mail order this will be sent through. (optional) (default to undefined)
let origin: string; //originating ip address sending mail (optional) (default to undefined)
let mx: string; //mx record mail was sent to (optional) (default to undefined)
let from: string; //from email address (optional) (default to undefined)
let to: string; //to/destination email address (optional) (default to undefined)
let subject: string; //subject containing this string (optional) (default to undefined)
let mailid: string; //mail id (optional) (default to undefined)
let skip: number; //number of records to skip for pagination (optional) (default to 0)
let limit: number; //maximum number of records to return (optional) (default to 100)
let startDate: number; //earliest date to get emails in unix timestamp format (optional) (default to undefined)
let endDate: number; //earliest date to get emails in unix timestamp format (optional) (default to undefined)
let replyto: string; //Reply-To Email Address (optional) (default to undefined)
let headerfrom: string; //Header From Email Address (optional) (default to undefined)
let delivered: '0' | '1'; //Limiting the emails to wether or not they were delivered. (optional) (default to undefined)

const { status, data } = await apiInstance.viewMailLog(
    id,
    origin,
    mx,
    from,
    to,
    subject,
    mailid,
    skip,
    limit,
    startDate,
    endDate,
    replyto,
    headerfrom,
    delivered
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] | The ID of your mail order this will be sent through. | (optional) defaults to undefined|
| **origin** | [**string**] | originating ip address sending mail | (optional) defaults to undefined|
| **mx** | [**string**] | mx record mail was sent to | (optional) defaults to undefined|
| **from** | [**string**] | from email address | (optional) defaults to undefined|
| **to** | [**string**] | to/destination email address | (optional) defaults to undefined|
| **subject** | [**string**] | subject containing this string | (optional) defaults to undefined|
| **mailid** | [**string**] | mail id | (optional) defaults to undefined|
| **skip** | [**number**] | number of records to skip for pagination | (optional) defaults to 0|
| **limit** | [**number**] | maximum number of records to return | (optional) defaults to 100|
| **startDate** | [**number**] | earliest date to get emails in unix timestamp format | (optional) defaults to undefined|
| **endDate** | [**number**] | earliest date to get emails in unix timestamp format | (optional) defaults to undefined|
| **replyto** | [**string**] | Reply-To Email Address | (optional) defaults to undefined|
| **headerfrom** | [**string**] | Header From Email Address | (optional) defaults to undefined|
| **delivered** | [**&#39;0&#39; | &#39;1&#39;**]**Array<&#39;0&#39; &#124; &#39;1&#39;>** | Limiting the emails to wether or not they were delivered. | (optional) defaults to undefined|


### Return type

**MailLog**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | search results matching criteria |  -  |
|**400** | bad input parameter |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

