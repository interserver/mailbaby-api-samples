# IO.Swagger.Api.DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetMailOrders**](DefaultApi.md#getmailorders) | **GET** /mail | displays a list of mail service orders
[**PingServer**](DefaultApi.md#pingserver) | **GET** /ping | Checks if the server is running
[**SendAdvMail**](DefaultApi.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**SendMail**](DefaultApi.md#sendmail) | **POST** /mail/send | Sends an Email
[**ViewMailLog**](DefaultApi.md#viewmaillog) | **GET** /mail/log | displays the mail log

<a name="getmailorders"></a>
# **GetMailOrders**
> List<InlineResponse200> GetMailOrders ()

displays a list of mail service orders

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class GetMailOrdersExample
    {
        public void main()
        {

            // Configure API key authorization: apiKeyAuth
            Configuration.Default.ApiKey.Add("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.ApiKeyPrefix.Add("X-API-KEY", "Bearer");

            var apiInstance = new DefaultApi();

            try
            {
                // displays a list of mail service orders
                List&lt;InlineResponse200&gt; result = apiInstance.GetMailOrders();
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling DefaultApi.GetMailOrders: " + e.Message );
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

<a name="pingserver"></a>
# **PingServer**
> void PingServer ()

Checks if the server is running

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class PingServerExample
    {
        public void main()
        {

            var apiInstance = new DefaultApi();

            try
            {
                // Checks if the server is running
                apiInstance.PingServer();
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling DefaultApi.PingServer: " + e.Message );
            }
        }
    }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="sendadvmail"></a>
# **SendAdvMail**
> GenericResponse SendAdvMail (SendMailAdv body)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class SendAdvMailExample
    {
        public void main()
        {

            // Configure API key authorization: apiKeyAuth
            Configuration.Default.ApiKey.Add("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.ApiKeyPrefix.Add("X-API-KEY", "Bearer");

            var apiInstance = new DefaultApi();
            var body = new SendMailAdv(); // SendMailAdv | 

            try
            {
                // Sends an Email with Advanced Options
                GenericResponse result = apiInstance.SendAdvMail(body);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling DefaultApi.SendAdvMail: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SendMailAdv**](SendMailAdv.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="sendmail"></a>
# **SendMail**
> GenericResponse SendMail (string to, string from, string subject, string body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class SendMailExample
    {
        public void main()
        {

            // Configure API key authorization: apiKeyAuth
            Configuration.Default.ApiKey.Add("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.ApiKeyPrefix.Add("X-API-KEY", "Bearer");

            var apiInstance = new DefaultApi();
            var to = to_example;  // string | 
            var from = from_example;  // string | 
            var subject = subject_example;  // string | 
            var body = body_example;  // string | 

            try
            {
                // Sends an Email
                GenericResponse result = apiInstance.SendMail(to, from, subject, body);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling DefaultApi.SendMail: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **string**|  | 
 **from** | **string**|  | 
 **subject** | **string**|  | 
 **body** | **string**|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="viewmaillog"></a>
# **ViewMailLog**
> MailLog ViewMailLog (long? id, string origin, string mx, string from, string to, string subject, string mailid, int? skip, int? limit, long? startDate, long? endDate)

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
            Configuration.Default.ApiKey.Add("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.ApiKeyPrefix.Add("X-API-KEY", "Bearer");

            var apiInstance = new DefaultApi();
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
                Debug.Print("Exception when calling DefaultApi.ViewMailLog: " + e.Message );
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

