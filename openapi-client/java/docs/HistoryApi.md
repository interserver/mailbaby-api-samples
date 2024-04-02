# HistoryApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getStats**](HistoryApi.md#getStats) | **GET** /mail/stats | Account usage statistics. |
| [**viewMailLog**](HistoryApi.md#viewMailLog) | **GET** /mail/log | displays the mail log |


<a id="getStats"></a>
# **getStats**
> List&lt;GetStats200ResponseInner&gt; getStats()

Account usage statistics.

Returns information about the usage on your mail accounts.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.HistoryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mailbaby.net");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    HistoryApi apiInstance = new HistoryApi(defaultClient);
    try {
      List<GetStats200ResponseInner> result = apiInstance.getStats();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling HistoryApi#getStats");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;GetStats200ResponseInner&gt;**](GetStats200ResponseInner.md)

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

<a id="viewMailLog"></a>
# **viewMailLog**
> MailLog viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom)

displays the mail log

Get a listing of the emails sent through this system 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.HistoryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mailbaby.net");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    HistoryApi apiInstance = new HistoryApi(defaultClient);
    Long id = 2604L; // Long | The ID of your mail order this will be sent through.
    String origin = "1.2.3.4"; // String | originating ip address sending mail
    String mx = "mx.google.com"; // String | mx record mail was sent to
    String from = "me@sender.com"; // String | from email address
    String to = "you@receiver.com"; // String | to/destination email address
    String subject = "Support"; // String | subject containing this string
    String mailid = "185997065c60008840"; // String | mail id
    Integer skip = 0; // Integer | number of records to skip for pagination
    Integer limit = 100; // Integer | maximum number of records to return
    Long startDate = 1641781008L; // Long | earliest date to get emails in unix timestamp format
    Long endDate = 1673317008L; // Long | earliest date to get emails in unix timestamp format
    String replyto = "replyto_example"; // String | Reply-To Email Address
    String headerfrom = "headerfrom_example"; // String | Header From Email Address
    try {
      MailLog result = apiInstance.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling HistoryApi#viewMailLog");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| The ID of your mail order this will be sent through. | [optional] |
| **origin** | **String**| originating ip address sending mail | [optional] |
| **mx** | **String**| mx record mail was sent to | [optional] |
| **from** | **String**| from email address | [optional] |
| **to** | **String**| to/destination email address | [optional] |
| **subject** | **String**| subject containing this string | [optional] |
| **mailid** | **String**| mail id | [optional] |
| **skip** | **Integer**| number of records to skip for pagination | [optional] [default to 0] |
| **limit** | **Integer**| maximum number of records to return | [optional] [default to 100] |
| **startDate** | **Long**| earliest date to get emails in unix timestamp format | [optional] |
| **endDate** | **Long**| earliest date to get emails in unix timestamp format | [optional] |
| **replyto** | **String**| Reply-To Email Address | [optional] |
| **headerfrom** | **String**| Header From Email Address | [optional] |

### Return type

[**MailLog**](MailLog.md)

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

