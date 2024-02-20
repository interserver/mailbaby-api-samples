# HistoryApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStats**](HistoryApi.md#getStats) | **GET** /mail/stats | Account usage statistics.
[**viewMailLog**](HistoryApi.md#viewMailLog) | **GET** /mail/log | displays the mail log

<a name="getStats"></a>
# **getStats**
> kotlin.Array&lt;InlineResponse200&gt; getStats()

Account usage statistics.

Returns information about the usage on your mail accounts.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = HistoryApi()
try {
    val result : kotlin.Array<InlineResponse200> = apiInstance.getStats()
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
This endpoint does not need any parameter.

### Return type

[**kotlin.Array&lt;InlineResponse200&gt;**](InlineResponse200.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="viewMailLog"></a>
# **viewMailLog**
> MailLog viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate)

displays the mail log

Get a listing of the emails sent through this system 

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = HistoryApi()
val id : kotlin.Long = 789 // kotlin.Long | The ID of your mail order this will be sent through.
val origin : kotlin.String = origin_example // kotlin.String | originating ip address sending mail
val mx : kotlin.String = mx_example // kotlin.String | mx record mail was sent to
val from : kotlin.String = from_example // kotlin.String | from email address
val to : kotlin.String = to_example // kotlin.String | to/destination email address
val subject : kotlin.String = subject_example // kotlin.String | subject containing this string
val mailid : kotlin.String = mailid_example // kotlin.String | mail id
val skip : kotlin.Int = 56 // kotlin.Int | number of records to skip for pagination
val limit : kotlin.Int = 56 // kotlin.Int | maximum number of records to return
val startDate : kotlin.Long = 789 // kotlin.Long | earliest date to get emails in unix timestamp format
val endDate : kotlin.Long = 789 // kotlin.Long | earliest date to get emails in unix timestamp format
try {
    val result : MailLog = apiInstance.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate)
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

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.Long**| The ID of your mail order this will be sent through. | [optional]
 **origin** | **kotlin.String**| originating ip address sending mail | [optional]
 **mx** | **kotlin.String**| mx record mail was sent to | [optional]
 **from** | **kotlin.String**| from email address | [optional]
 **to** | **kotlin.String**| to/destination email address | [optional]
 **subject** | **kotlin.String**| subject containing this string | [optional]
 **mailid** | **kotlin.String**| mail id | [optional]
 **skip** | **kotlin.Int**| number of records to skip for pagination | [optional] [default to 0] [enum: ]
 **limit** | **kotlin.Int**| maximum number of records to return | [optional] [default to 100] [enum: ]
 **startDate** | **kotlin.Long**| earliest date to get emails in unix timestamp format | [optional] [enum: ]
 **endDate** | **kotlin.Long**| earliest date to get emails in unix timestamp format | [optional] [enum: ]

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

