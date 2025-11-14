# HistoryApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getStats**](HistoryApi.md#getstats) | **GET** /mail/stats | Account usage statistics. |
| [**viewMailLog**](HistoryApi.md#viewmaillog) | **GET** /mail/log | displays the mail log |



## getStats

> MailStatsType getStats(time)

Account usage statistics.

Returns information about the usage on your mail accounts.

### Example

```ts
import {
  Configuration,
  HistoryApi,
} from '';
import type { GetStatsRequest } from '';

async function example() {
  console.log("🚀 Testing  SDK...");
  const config = new Configuration({ 
    // To configure API key authorization: apiKeyAuth
    apiKey: "YOUR API KEY",
  });
  const api = new HistoryApi(config);

  const body = {
    // 'all' | 'billing' | 'month' | '7d' | '24h' | '1d' | '1h' | The timeframe for the statistics. (optional)
    time: time_example,
  } satisfies GetStatsRequest;

  try {
    const data = await api.getStats(body);
    console.log(data);
  } catch (error) {
    console.error(error);
  }
}

// Run the test
example().catch(console.error);
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **time** | `all`, `billing`, `month`, `7d`, `24h`, `1d`, `1h` | The timeframe for the statistics. | [Optional] [Defaults to `undefined`] [Enum: all, billing, month, 7d, 24h, 1d, 1h] |

### Return type

[**MailStatsType**](MailStatsType.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **404** | Unauthorized |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


## viewMailLog

> MailLog viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered)

displays the mail log

Get a listing of the emails sent through this system 

### Example

```ts
import {
  Configuration,
  HistoryApi,
} from '';
import type { ViewMailLogRequest } from '';

async function example() {
  console.log("🚀 Testing  SDK...");
  const config = new Configuration({ 
    // To configure API key authorization: apiKeyAuth
    apiKey: "YOUR API KEY",
  });
  const api = new HistoryApi(config);

  const body = {
    // number | The ID of your mail order this will be sent through. (optional)
    id: 2604,
    // string | originating ip address sending mail (optional)
    origin: 1.2.3.4,
    // string | mx record mail was sent to (optional)
    mx: mx.google.com,
    // string | from email address (optional)
    from: me@sender.com,
    // string | to/destination email address (optional)
    to: you@receiver.com,
    // string | subject containing this string (optional)
    subject: Support,
    // string | mail id (optional)
    mailid: 185997065c60008840,
    // number | number of records to skip for pagination (optional)
    skip: 1000,
    // number | maximum number of records to return (optional)
    limit: 1000,
    // number | earliest date to get emails in unix timestamp format (optional)
    startDate: 1641781008,
    // number | earliest date to get emails in unix timestamp format (optional)
    endDate: 1673317008,
    // string | Reply-To Email Address (optional)
    replyto: replyto_example,
    // string | Header From Email Address (optional)
    headerfrom: headerfrom_example,
    // '0' | '1' | Limiting the emails to wether or not they were delivered. (optional)
    delivered: delivered_example,
  } satisfies ViewMailLogRequest;

  try {
    const data = await api.viewMailLog(body);
    console.log(data);
  } catch (error) {
    console.error(error);
  }
}

// Run the test
example().catch(console.error);
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | `number` | The ID of your mail order this will be sent through. | [Optional] [Defaults to `undefined`] |
| **origin** | `string` | originating ip address sending mail | [Optional] [Defaults to `undefined`] |
| **mx** | `string` | mx record mail was sent to | [Optional] [Defaults to `undefined`] |
| **from** | `string` | from email address | [Optional] [Defaults to `undefined`] |
| **to** | `string` | to/destination email address | [Optional] [Defaults to `undefined`] |
| **subject** | `string` | subject containing this string | [Optional] [Defaults to `undefined`] |
| **mailid** | `string` | mail id | [Optional] [Defaults to `undefined`] |
| **skip** | `number` | number of records to skip for pagination | [Optional] [Defaults to `0`] |
| **limit** | `number` | maximum number of records to return | [Optional] [Defaults to `100`] |
| **startDate** | `number` | earliest date to get emails in unix timestamp format | [Optional] [Defaults to `undefined`] |
| **endDate** | `number` | earliest date to get emails in unix timestamp format | [Optional] [Defaults to `undefined`] |
| **replyto** | `string` | Reply-To Email Address | [Optional] [Defaults to `undefined`] |
| **headerfrom** | `string` | Header From Email Address | [Optional] [Defaults to `undefined`] |
| **delivered** | `0`, `1` | Limiting the emails to wether or not they were delivered. | [Optional] [Defaults to `undefined`] [Enum: 0, 1] |

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | search results matching criteria |  -  |
| **400** | bad input parameter |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)

