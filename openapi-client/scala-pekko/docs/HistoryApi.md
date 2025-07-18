# HistoryApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStats**](HistoryApi.md#getStats) | **GET** /mail/stats | Account usage statistics.
[**getStatsWithHttpInfo**](HistoryApi.md#getStatsWithHttpInfo) | **GET** /mail/stats | Account usage statistics.
[**viewMailLog**](HistoryApi.md#viewMailLog) | **GET** /mail/log | displays the mail log
[**viewMailLogWithHttpInfo**](HistoryApi.md#viewMailLogWithHttpInfo) | **GET** /mail/log | displays the mail log



## getStats

> getStats(getStatsRequest): ApiRequest[MailStatsType]

Account usage statistics.

Returns information about the usage on your mail accounts.

### Example

```scala
// Import classes:
import 
import 
import org.openapitools.client.core._
import org.openapitools.client.core.CollectionFormats._
import org.openapitools.client.core.ApiKeyLocations._

import org.apache.pekko.actor.ActorSystem
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Example extends App {
    
    implicit val system: ActorSystem = ActorSystem()
    import system.dispatcher
    
    // Configure API key authorization: apiKeyAuth
    implicit val apiKeyAuth: ApiKeyValue = ApiKeyValue("YOUR API KEY")

    val apiInvoker = ApiInvoker()
    val apiInstance = HistoryApi("https://api.mailbaby.net")
    val time: String = time_example // String | The timeframe for the statistics.
    
    val request = apiInstance.getStats(time)
    val response = apiInvoker.execute(request)

    response.onComplete {
        case Success(ApiResponse(code, content, headers)) =>
            System.out.println(s"Status code: $code}")
            System.out.println(s"Response headers: ${headers.mkString(", ")}")
            System.out.println(s"Response body: $content")
        
        case Failure(error @ ApiError(code, message, responseContent, cause, headers)) =>
            System.err.println("Exception when calling HistoryApi#getStats")
            System.err.println(s"Status code: $code}")
            System.err.println(s"Reason: $responseContent")
            System.err.println(s"Response headers: ${headers.mkString(", ")}")
            error.printStackTrace();

        case Failure(exception) => 
            System.err.println("Exception when calling HistoryApi#getStats")
            exception.printStackTrace();
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **time** | **String**| The timeframe for the statistics. | [optional] [enum: all, billing, month, 7d, 24h, 1d, 1h]

### Return type

ApiRequest[[**MailStatsType**](MailStatsType.md)]


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **404** | Unauthorized |  -  |


## viewMailLog

> viewMailLog(viewMailLogRequest): ApiRequest[MailLog]

displays the mail log

Get a listing of the emails sent through this system 

### Example

```scala
// Import classes:
import 
import org.openapitools.client.core._
import org.openapitools.client.core.CollectionFormats._
import org.openapitools.client.core.ApiKeyLocations._

import org.apache.pekko.actor.ActorSystem
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Example extends App {
    
    implicit val system: ActorSystem = ActorSystem()
    import system.dispatcher
    
    // Configure API key authorization: apiKeyAuth
    implicit val apiKeyAuth: ApiKeyValue = ApiKeyValue("YOUR API KEY")

    val apiInvoker = ApiInvoker()
    val apiInstance = HistoryApi("https://api.mailbaby.net")
    val id: Long = 2604 // Long | The ID of your mail order this will be sent through.

    val origin: String = 1.2.3.4 // String | originating ip address sending mail

    val mx: String = mx.google.com // String | mx record mail was sent to

    val from: String = me@sender.com // String | from email address

    val to: String = you@receiver.com // String | to/destination email address

    val subject: String = Support // String | subject containing this string

    val mailid: String = 185997065c60008840 // String | mail id

    val skip: Int = 1000 // Int | number of records to skip for pagination

    val limit: Int = 1000 // Int | maximum number of records to return

    val startDate: Long = 1641781008 // Long | earliest date to get emails in unix timestamp format

    val endDate: Long = 1673317008 // Long | earliest date to get emails in unix timestamp format

    val replyto: String = replyto_example // String | Reply-To Email Address

    val headerfrom: String = headerfrom_example // String | Header From Email Address

    val delivered: String = delivered_example // String | Limiting the emails to wether or not they were delivered.
    
    val request = apiInstance.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered)
    val response = apiInvoker.execute(request)

    response.onComplete {
        case Success(ApiResponse(code, content, headers)) =>
            System.out.println(s"Status code: $code}")
            System.out.println(s"Response headers: ${headers.mkString(", ")}")
            System.out.println(s"Response body: $content")
        
        case Failure(error @ ApiError(code, message, responseContent, cause, headers)) =>
            System.err.println("Exception when calling HistoryApi#viewMailLog")
            System.err.println(s"Status code: $code}")
            System.err.println(s"Reason: $responseContent")
            System.err.println(s"Response headers: ${headers.mkString(", ")}")
            error.printStackTrace();

        case Failure(exception) => 
            System.err.println("Exception when calling HistoryApi#viewMailLog")
            exception.printStackTrace();
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The ID of your mail order this will be sent through. | [optional]
 **origin** | **String**| originating ip address sending mail | [optional]
 **mx** | **String**| mx record mail was sent to | [optional]
 **from** | **String**| from email address | [optional]
 **to** | **String**| to/destination email address | [optional]
 **subject** | **String**| subject containing this string | [optional]
 **mailid** | **String**| mail id | [optional]
 **skip** | **Int**| number of records to skip for pagination | [optional]
 **limit** | **Int**| maximum number of records to return | [optional]
 **startDate** | **Long**| earliest date to get emails in unix timestamp format | [optional]
 **endDate** | **Long**| earliest date to get emails in unix timestamp format | [optional]
 **replyto** | **String**| Reply-To Email Address | [optional]
 **headerfrom** | **String**| Header From Email Address | [optional]
 **delivered** | **String**| Limiting the emails to wether or not they were delivered. | [optional] [enum: 0, 1]

### Return type

ApiRequest[[**MailLog**](MailLog.md)]


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | search results matching criteria |  -  |
| **400** | bad input parameter |  -  |

