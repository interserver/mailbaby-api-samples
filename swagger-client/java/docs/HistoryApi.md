# HistoryApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStats**](HistoryApi.md#getStats) | **GET** /mail/stats | Account usage statistics.
[**viewMailLog**](HistoryApi.md#viewMailLog) | **GET** /mail/log | displays the mail log

<a name="getStats"></a>
# **getStats**
> MailStatsType getStats(time)

Account usage statistics.

Returns information about the usage on your mail accounts.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.HistoryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKeyAuth
ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
apiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.setApiKeyPrefix("Token");

HistoryApi apiInstance = new HistoryApi();
String time = "time_example"; // String | The timeframe for the statistics.
try {
    MailStatsType result = apiInstance.getStats(time);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling HistoryApi#getStats");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **time** | **String**| The timeframe for the statistics. | [optional] [enum: all, billing, month, 7d, 24h, 1d, 1h]

### Return type

[**MailStatsType**](MailStatsType.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="viewMailLog"></a>
# **viewMailLog**
> MailLog viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered)

displays the mail log

Get a listing of the emails sent through this system 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.HistoryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKeyAuth
ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
apiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.setApiKeyPrefix("Token");

HistoryApi apiInstance = new HistoryApi();
Long id = 789L; // Long | The ID of your mail order this will be sent through.
String origin = "origin_example"; // String | originating ip address sending mail
String mx = "mx_example"; // String | mx record mail was sent to
String from = "from_example"; // String | from email address
String to = "to_example"; // String | to/destination email address
String subject = "subject_example"; // String | subject containing this string
String mailid = "mailid_example"; // String | mail id
Integer skip = 0; // Integer | number of records to skip for pagination
Integer limit = 100; // Integer | maximum number of records to return
Long startDate = 789L; // Long | earliest date to get emails in unix timestamp format
Long endDate = 789L; // Long | earliest date to get emails in unix timestamp format
String replyto = "replyto_example"; // String | Reply-To Email Address
String headerfrom = "headerfrom_example"; // String | Header From Email Address
String delivered = "delivered_example"; // String | Limiting the emails to wether or not they were delivered.
try {
    MailLog result = apiInstance.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling HistoryApi#viewMailLog");
    e.printStackTrace();
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
 **skip** | **Integer**| number of records to skip for pagination | [optional] [default to 0] [enum: 0]
 **limit** | **Integer**| maximum number of records to return | [optional] [default to 100] [enum: 1, 10000]
 **startDate** | **Long**| earliest date to get emails in unix timestamp format | [optional] [enum: 0, 9999999999]
 **endDate** | **Long**| earliest date to get emails in unix timestamp format | [optional] [enum: 0, 9999999999]
 **replyto** | **String**| Reply-To Email Address | [optional]
 **headerfrom** | **String**| Header From Email Address | [optional]
 **delivered** | **String**| Limiting the emails to wether or not they were delivered. | [optional] [enum: 0, 1]

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

