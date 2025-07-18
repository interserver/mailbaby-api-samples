# HistoryApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getStats**](HistoryApi.md#getStats) | **GET** /mail/stats | Account usage statistics. |
| [**viewMailLog**](HistoryApi.md#viewMailLog) | **GET** /mail/log | displays the mail log |


<a id="getStats"></a>
# **getStats**
> MailStatsType getStats(time)

Account usage statistics.

Returns information about the usage on your mail accounts.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = HistoryApi()
val time : kotlin.String = time_example // kotlin.String | The timeframe for the statistics.
try {
    val result : MailStatsType = apiInstance.getStats(time)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HistoryApi#getStats")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HistoryApi#getStats")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **time** | **kotlin.String**| The timeframe for the statistics. | [optional] [enum: all, billing, month, 7d, 24h, 1d, 1h] |

### Return type

[**MailStatsType**](MailStatsType.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="viewMailLog"></a>
# **viewMailLog**
> MailLog viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered)

displays the mail log

Get a listing of the emails sent through this system 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = HistoryApi()
val id : kotlin.Long = 2604 // kotlin.Long | The ID of your mail order this will be sent through.
val origin : kotlin.String = 1.2.3.4 // kotlin.String | originating ip address sending mail
val mx : kotlin.String = mx.google.com // kotlin.String | mx record mail was sent to
val from : kotlin.String = me@sender.com // kotlin.String | from email address
val to : kotlin.String = you@receiver.com // kotlin.String | to/destination email address
val subject : kotlin.String = Support // kotlin.String | subject containing this string
val mailid : kotlin.String = 185997065c60008840 // kotlin.String | mail id
val skip : kotlin.Int = 1000 // kotlin.Int | number of records to skip for pagination
val limit : kotlin.Int = 1000 // kotlin.Int | maximum number of records to return
val startDate : kotlin.Long = 1641781008 // kotlin.Long | earliest date to get emails in unix timestamp format
val endDate : kotlin.Long = 1673317008 // kotlin.Long | earliest date to get emails in unix timestamp format
val replyto : kotlin.String = replyto_example // kotlin.String | Reply-To Email Address
val headerfrom : kotlin.String = headerfrom_example // kotlin.String | Header From Email Address
val delivered : kotlin.String = delivered_example // kotlin.String | Limiting the emails to wether or not they were delivered.
try {
    val result : MailLog = apiInstance.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HistoryApi#viewMailLog")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HistoryApi#viewMailLog")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.Long**| The ID of your mail order this will be sent through. | [optional] |
| **origin** | **kotlin.String**| originating ip address sending mail | [optional] |
| **mx** | **kotlin.String**| mx record mail was sent to | [optional] |
| **from** | **kotlin.String**| from email address | [optional] |
| **to** | **kotlin.String**| to/destination email address | [optional] |
| **subject** | **kotlin.String**| subject containing this string | [optional] |
| **mailid** | **kotlin.String**| mail id | [optional] |
| **skip** | **kotlin.Int**| number of records to skip for pagination | [optional] [default to 0] |
| **limit** | **kotlin.Int**| maximum number of records to return | [optional] [default to 100] |
| **startDate** | **kotlin.Long**| earliest date to get emails in unix timestamp format | [optional] |
| **endDate** | **kotlin.Long**| earliest date to get emails in unix timestamp format | [optional] |
| **replyto** | **kotlin.String**| Reply-To Email Address | [optional] |
| **headerfrom** | **kotlin.String**| Header From Email Address | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **delivered** | **kotlin.String**| Limiting the emails to wether or not they were delivered. | [optional] [enum: 0, 1] |

### Return type

[**MailLog**](MailLog.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

