# Org.OpenAPITools.Api.DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetMailOrders**](DefaultApi.md#getmailorders) | **GET** /mail | displays a list of mail service orders
[**PingServer**](DefaultApi.md#pingserver) | **GET** /ping | Checks if the server is running
[**PlaceMailOrder**](DefaultApi.md#placemailorder) | **POST** /mail/order | places a mail order
[**SendAdvMail**](DefaultApi.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**SendMail**](DefaultApi.md#sendmail) | **POST** /mail/send | Sends an Email
[**ValidateMailOrder**](DefaultApi.md#validatemailorder) | **GET** /mail/order | validatess order details before placing an order
[**ViewMailLog**](DefaultApi.md#viewmaillog) | **GET** /mail/log | displays the mail log



## GetMailOrders

> List&lt;MailOrder&gt; GetMailOrders ()

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
            Configuration.Default.BasePath = "https://api.mailbaby.net";
            // Configure API key authorization: apiKeyAuth
            Configuration.Default.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new DefaultApi(Configuration.Default);

            try
            {
                // displays a list of mail service orders
                List<MailOrder> result = apiInstance.GetMailOrders();
                Debug.WriteLine(result);
            }
            catch (ApiException e)
            {
                Debug.Print("Exception when calling DefaultApi.GetMailOrders: " + e.Message );
                Debug.Print("Status Code: "+ e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;MailOrder&gt;**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml, text/plain


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |

[[Back to top]](#)
[[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PingServer

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
            Configuration.Default.BasePath = "https://api.mailbaby.net";
            var apiInstance = new DefaultApi(Configuration.Default);

            try
            {
                // Checks if the server is running
                apiInstance.PingServer();
            }
            catch (ApiException e)
            {
                Debug.Print("Exception when calling DefaultApi.PingServer: " + e.Message );
                Debug.Print("Status Code: "+ e.ErrorCode);
                Debug.Print(e.StackTrace);
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


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Server is up and running |  -  |
| **0** | Something is wrong |  -  |

[[Back to top]](#)
[[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PlaceMailOrder

> void PlaceMailOrder (MailOrder mailOrder = null)

places a mail order

Adds an item to the system

### Example

```csharp
using System.Collections.Generic;
using System.Diagnostics;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class PlaceMailOrderExample
    {
        public static void Main()
        {
            Configuration.Default.BasePath = "https://api.mailbaby.net";
            // Configure API key authorization: apiKeyAuth
            Configuration.Default.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new DefaultApi(Configuration.Default);
            var mailOrder = new MailOrder(); // MailOrder | Inventory item to add (optional) 

            try
            {
                // places a mail order
                apiInstance.PlaceMailOrder(mailOrder);
            }
            catch (ApiException e)
            {
                Debug.Print("Exception when calling DefaultApi.PlaceMailOrder: " + e.Message );
                Debug.Print("Status Code: "+ e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **mailOrder** | [**MailOrder**](MailOrder.md)| Inventory item to add | [optional] 

### Return type

void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | list of mail orders |  -  |
| **400** | invalid input, object invalid |  -  |
| **409** | an existing item already exists |  -  |
| **401** | Unauthorized |  -  |

[[Back to top]](#)
[[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SendAdvMail

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
            Configuration.Default.BasePath = "https://api.mailbaby.net";
            // Configure API key authorization: apiKeyAuth
            Configuration.Default.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new DefaultApi(Configuration.Default);
            var sendMailAdv = new SendMailAdv(); // SendMailAdv | 

            try
            {
                // Sends an Email with Advanced Options
                GenericResponse result = apiInstance.SendAdvMail(sendMailAdv);
                Debug.WriteLine(result);
            }
            catch (ApiException e)
            {
                Debug.Print("Exception when calling DefaultApi.SendAdvMail: " + e.Message );
                Debug.Print("Status Code: "+ e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sendMailAdv** | [**SendMailAdv**](SendMailAdv.md)|  | 

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
| **400** | bad input parameter |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

[[Back to top]](#)
[[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SendMail

> GenericResponse SendMail (string to, string from, string subject, string body)

Sends an Email

Sends An email through one of your mail orders.

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
            Configuration.Default.BasePath = "https://api.mailbaby.net";
            // Configure API key authorization: apiKeyAuth
            Configuration.Default.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new DefaultApi(Configuration.Default);
            var to = to_example;  // string | The Contact whom is the primary recipient of this email.
            var from = from_example;  // string | The contact whom is the this email is from.
            var subject = subject_example;  // string | The subject or title of the email
            var body = body_example;  // string | The main email contents.

            try
            {
                // Sends an Email
                GenericResponse result = apiInstance.SendMail(to, from, subject, body);
                Debug.WriteLine(result);
            }
            catch (ApiException e)
            {
                Debug.Print("Exception when calling DefaultApi.SendMail: " + e.Message );
                Debug.Print("Status Code: "+ e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **string**| The Contact whom is the primary recipient of this email. | 
 **from** | **string**| The contact whom is the this email is from. | 
 **subject** | **string**| The subject or title of the email | 
 **body** | **string**| The main email contents. | 

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
| **400** | bad input parameter |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

[[Back to top]](#)
[[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ValidateMailOrder

> void ValidateMailOrder ()

validatess order details before placing an order

### Example

```csharp
using System.Collections.Generic;
using System.Diagnostics;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class ValidateMailOrderExample
    {
        public static void Main()
        {
            Configuration.Default.BasePath = "https://api.mailbaby.net";
            // Configure API key authorization: apiKeyAuth
            Configuration.Default.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new DefaultApi(Configuration.Default);

            try
            {
                // validatess order details before placing an order
                apiInstance.ValidateMailOrder();
            }
            catch (ApiException e)
            {
                Debug.Print("Exception when calling DefaultApi.ValidateMailOrder: " + e.Message );
                Debug.Print("Status Code: "+ e.ErrorCode);
                Debug.Print(e.StackTrace);
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

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | list of mail orders |  -  |
| **401** | Unauthorized |  -  |

[[Back to top]](#)
[[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ViewMailLog

> List&lt;MailLog&gt; ViewMailLog (long? id = null, string searchString = null, int? skip = null, int? limit = null)

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

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
            Configuration.Default.BasePath = "https://api.mailbaby.net";
            // Configure API key authorization: apiKeyAuth
            Configuration.Default.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new DefaultApi(Configuration.Default);
            var id = 789;  // long? | The ID of your mail order this will be sent through. (optional) 
            var searchString = searchString_example;  // string | pass an optional search string for looking up inventory (optional) 
            var skip = 56;  // int? | number of records to skip for pagination (optional) 
            var limit = 56;  // int? | maximum number of records to return (optional) 

            try
            {
                // displays the mail log
                List<MailLog> result = apiInstance.ViewMailLog(id, searchString, skip, limit);
                Debug.WriteLine(result);
            }
            catch (ApiException e)
            {
                Debug.Print("Exception when calling DefaultApi.ViewMailLog: " + e.Message );
                Debug.Print("Status Code: "+ e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **long?**| The ID of your mail order this will be sent through. | [optional] 
 **searchString** | **string**| pass an optional search string for looking up inventory | [optional] 
 **skip** | **int?**| number of records to skip for pagination | [optional] 
 **limit** | **int?**| maximum number of records to return | [optional] 

### Return type

[**List&lt;MailLog&gt;**](MailLog.md)

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

[[Back to top]](#)
[[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

