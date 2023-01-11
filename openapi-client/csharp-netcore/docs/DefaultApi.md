# Org.OpenAPITools.Api.DefaultApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|--------|--------------|-------------|
| [**GetMailOrders**](DefaultApi.md#getmailorders) | **GET** /mail | displays a list of mail service orders |
| [**PingServer**](DefaultApi.md#pingserver) | **GET** /ping | Checks if the server is running |
| [**SendAdvMail**](DefaultApi.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options |
| [**SendMail**](DefaultApi.md#sendmail) | **POST** /mail/send | Sends an Email |
| [**ViewMailLog**](DefaultApi.md#viewmaillog) | **GET** /mail/log | displays the mail log |

<a name="getmailorders"></a>
# **GetMailOrders**
> List&lt;GetMailOrders200ResponseInner&gt; GetMailOrders ()

displays a list of mail service orders

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class GetMailOrdersExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://api.mailbaby.net";
            // Configure API key authorization: apiKeyAuth
            config.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new DefaultApi(config);

            try
            {
                // displays a list of mail service orders
                List<GetMailOrders200ResponseInner> result = apiInstance.GetMailOrders();
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling DefaultApi.GetMailOrders: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the GetMailOrdersWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // displays a list of mail service orders
    ApiResponse<List<GetMailOrders200ResponseInner>> response = apiInstance.GetMailOrdersWithHttpInfo();
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling DefaultApi.GetMailOrdersWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters
This endpoint does not need any parameter.
### Return type

[**List&lt;GetMailOrders200ResponseInner&gt;**](GetMailOrders200ResponseInner.md)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="pingserver"></a>
# **PingServer**
> void PingServer ()

Checks if the server is running

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class PingServerExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://api.mailbaby.net";
            var apiInstance = new DefaultApi(config);

            try
            {
                // Checks if the server is running
                apiInstance.PingServer();
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling DefaultApi.PingServer: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the PingServerWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Checks if the server is running
    apiInstance.PingServerWithHttpInfo();
}
catch (ApiException e)
{
    Debug.Print("Exception when calling DefaultApi.PingServerWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
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


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Server is up and running |  -  |
| **0** | Something is wrong |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="sendadvmail"></a>
# **SendAdvMail**
> GenericResponse SendAdvMail (SendMailAdv sendMailAdv)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class SendAdvMailExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://api.mailbaby.net";
            // Configure API key authorization: apiKeyAuth
            config.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new DefaultApi(config);
            var sendMailAdv = new SendMailAdv(); // SendMailAdv | 

            try
            {
                // Sends an Email with Advanced Options
                GenericResponse result = apiInstance.SendAdvMail(sendMailAdv);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling DefaultApi.SendAdvMail: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the SendAdvMailWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Sends an Email with Advanced Options
    ApiResponse<GenericResponse> response = apiInstance.SendAdvMailWithHttpInfo(sendMailAdv);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling DefaultApi.SendAdvMailWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **sendMailAdv** | [**SendMailAdv**](SendMailAdv.md) |  |  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | search results matching criteria |  -  |
| **400** | The specified resource was not found |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="sendmail"></a>
# **SendMail**
> GenericResponse SendMail (string to, string from, string subject, string body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class SendMailExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://api.mailbaby.net";
            // Configure API key authorization: apiKeyAuth
            config.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new DefaultApi(config);
            var to = "to_example";  // string | The Contact whom is the primary recipient of this email.
            var from = "from_example";  // string | The contact whom is the this email is from.
            var subject = "subject_example";  // string | The subject or title of the email
            var body = "body_example";  // string | The main email contents.

            try
            {
                // Sends an Email
                GenericResponse result = apiInstance.SendMail(to, from, subject, body);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling DefaultApi.SendMail: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the SendMailWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Sends an Email
    ApiResponse<GenericResponse> response = apiInstance.SendMailWithHttpInfo(to, from, subject, body);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling DefaultApi.SendMailWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **to** | **string** | The Contact whom is the primary recipient of this email. |  |
| **from** | **string** | The contact whom is the this email is from. |  |
| **subject** | **string** | The subject or title of the email |  |
| **body** | **string** | The main email contents. |  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | search results matching criteria |  -  |
| **400** | The specified resource was not found |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="viewmaillog"></a>
# **ViewMailLog**
> MailLog ViewMailLog (long? id = null, string origin = null, string mx = null, string from = null, string to = null, string subject = null, string mailid = null, int? skip = null, int? limit = null, long? startDate = null, long? endDate = null)

displays the mail log

Get a listing of the emails sent through this system 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class ViewMailLogExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://api.mailbaby.net";
            // Configure API key authorization: apiKeyAuth
            config.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new DefaultApi(config);
            var id = 2604;  // long? | The ID of your mail order this will be sent through. (optional) 
            var origin = 1.2.3.4;  // string | originating ip address sending mail (optional) 
            var mx = mx.google.com;  // string | mx record mail was sent to (optional) 
            var from = me@sender.com;  // string | from email address (optional) 
            var to = you@receiver.com;  // string | to/destination email address (optional) 
            var subject = Support;  // string | subject containing this string (optional) 
            var mailid = 185997065c60008840;  // string | mail id (optional) 
            var skip = 1000;  // int? | number of records to skip for pagination (optional)  (default to 0)
            var limit = 1000;  // int? | maximum number of records to return (optional)  (default to 100)
            var startDate = 1641781008;  // long? | earliest date to get emails in unix timestamp format (optional) 
            var endDate = 1673317008;  // long? | earliest date to get emails in unix timestamp format (optional) 

            try
            {
                // displays the mail log
                MailLog result = apiInstance.ViewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling DefaultApi.ViewMailLog: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the ViewMailLogWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // displays the mail log
    ApiResponse<MailLog> response = apiInstance.ViewMailLogWithHttpInfo(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling DefaultApi.ViewMailLogWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **id** | **long?** | The ID of your mail order this will be sent through. | [optional]  |
| **origin** | **string** | originating ip address sending mail | [optional]  |
| **mx** | **string** | mx record mail was sent to | [optional]  |
| **from** | **string** | from email address | [optional]  |
| **to** | **string** | to/destination email address | [optional]  |
| **subject** | **string** | subject containing this string | [optional]  |
| **mailid** | **string** | mail id | [optional]  |
| **skip** | **int?** | number of records to skip for pagination | [optional] [default to 0] |
| **limit** | **int?** | maximum number of records to return | [optional] [default to 100] |
| **startDate** | **long?** | earliest date to get emails in unix timestamp format | [optional]  |
| **endDate** | **long?** | earliest date to get emails in unix timestamp format | [optional]  |

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

