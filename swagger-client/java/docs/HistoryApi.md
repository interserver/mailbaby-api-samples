# HistoryApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStats**](HistoryApi.md#getStats) | **GET** /mail/stats | displays a list of blocked email addresses
[**viewMailLog**](HistoryApi.md#viewMailLog) | **GET** /mail/log | displays the mail log

<a name="getStats"></a>
# **getStats**
> List&lt;InlineResponse200&gt; getStats()

displays a list of blocked email addresses

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
try {
    List<InlineResponse200> result = apiInstance.getStats();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling HistoryApi#getStats");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;InlineResponse200&gt;**](InlineResponse200.md)

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
try {
    MailLog result = apiInstance.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate);
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
 **skip** | **Integer**| number of records to skip for pagination | [optional] [default to 0] [enum: ]
 **limit** | **Integer**| maximum number of records to return | [optional] [default to 100] [enum: ]
 **startDate** | **Long**| earliest date to get emails in unix timestamp format | [optional] [enum: ]
 **endDate** | **Long**| earliest date to get emails in unix timestamp format | [optional] [enum: ]

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

