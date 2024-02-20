# IO.Swagger.Api.HistoryApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetStats**](HistoryApi.md#getstats) | **GET** /mail/stats | Account usage statistics.
[**ViewMailLog**](HistoryApi.md#viewmaillog) | **GET** /mail/log | displays the mail log

<a name="getstats"></a>
# **GetStats**
> List<InlineResponse200> GetStats ()

Account usage statistics.

Returns information about the usage on your mail accounts.

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class GetStatsExample
    {
        public void main()
        {
            // Configure API key authorization: apiKeyAuth
            Configuration.Default.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new HistoryApi();

            try
            {
                // Account usage statistics.
                List&lt;InlineResponse200&gt; result = apiInstance.GetStats();
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling HistoryApi.GetStats: " + e.Message );
            }
        }
    }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List<InlineResponse200>**](InlineResponse200.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
<a name="viewmaillog"></a>
# **ViewMailLog**
> MailLog ViewMailLog (long? id = null, string origin = null, string mx = null, string from = null, string to = null, string subject = null, string mailid = null, int? skip = null, int? limit = null, long? startDate = null, long? endDate = null)

displays the mail log

Get a listing of the emails sent through this system 

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class ViewMailLogExample
    {
        public void main()
        {
            // Configure API key authorization: apiKeyAuth
            Configuration.Default.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new HistoryApi();
            var id = 789;  // long? | The ID of your mail order this will be sent through. (optional) 
            var origin = origin_example;  // string | originating ip address sending mail (optional) 
            var mx = mx_example;  // string | mx record mail was sent to (optional) 
            var from = from_example;  // string | from email address (optional) 
            var to = to_example;  // string | to/destination email address (optional) 
            var subject = subject_example;  // string | subject containing this string (optional) 
            var mailid = mailid_example;  // string | mail id (optional) 
            var skip = 56;  // int? | number of records to skip for pagination (optional)  (default to 0)
            var limit = 56;  // int? | maximum number of records to return (optional)  (default to 100)
            var startDate = 789;  // long? | earliest date to get emails in unix timestamp format (optional) 
            var endDate = 789;  // long? | earliest date to get emails in unix timestamp format (optional) 

            try
            {
                // displays the mail log
                MailLog result = apiInstance.ViewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling HistoryApi.ViewMailLog: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **long?**| The ID of your mail order this will be sent through. | [optional] 
 **origin** | **string**| originating ip address sending mail | [optional] 
 **mx** | **string**| mx record mail was sent to | [optional] 
 **from** | **string**| from email address | [optional] 
 **to** | **string**| to/destination email address | [optional] 
 **subject** | **string**| subject containing this string | [optional] 
 **mailid** | **string**| mail id | [optional] 
 **skip** | **int?**| number of records to skip for pagination | [optional] [default to 0]
 **limit** | **int?**| maximum number of records to return | [optional] [default to 100]
 **startDate** | **long?**| earliest date to get emails in unix timestamp format | [optional] 
 **endDate** | **long?**| earliest date to get emails in unix timestamp format | [optional] 

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
