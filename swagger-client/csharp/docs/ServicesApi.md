# mailbaby-client-csharp.Api.ServicesApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetMailOrderById**](ServicesApi.md#getmailorderbyid) | **GET** /mail/{id} | Displays details for a single mail order
[**GetMailOrders**](ServicesApi.md#getmailorders) | **GET** /mail | Displays a list of mail service orders

<a name="getmailorderbyid"></a>
# **GetMailOrderById**
> MailOrderDetail GetMailOrderById (long? id)

Displays details for a single mail order

Returns the full detail record for one specific mail order identified by its numeric `id`.  In addition to the fields returned by `GET /mail`, this endpoint also includes the current **SMTP password** for the order.  The `username` and `password` values returned here can be used directly to authenticate against `relay.mailbaby.net:25` (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.  The `id` path parameter is the same integer `id` value returned by `GET /mail`. 

### Example
```csharp
using System;
using System.Diagnostics;
using mailbaby-client-csharp.Api;
using mailbaby-client-csharp.Client;
using mailbaby-client-csharp.Model;

namespace Example
{
    public class GetMailOrderByIdExample
    {
        public void main()
        {
            // Configure API key authorization: apiKeyAuth
            Configuration.Default.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new ServicesApi();
            var id = 789;  // long? | The numeric ID of the mail order.

            try
            {
                // Displays details for a single mail order
                MailOrderDetail result = apiInstance.GetMailOrderById(id);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling ServicesApi.GetMailOrderById: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **long?**| The numeric ID of the mail order. | 

### Return type

[**MailOrderDetail**](MailOrderDetail.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
<a name="getmailorders"></a>
# **GetMailOrders**
> List<MailOrder> GetMailOrders ()

Displays a list of mail service orders

Returns every mail order (active **and** inactive) associated with your account. Each record includes the numeric `id`, the `status` (`active` or `canceled`), the SMTP `username` (always `mb<id>`), and an optional human-readable `comment`.  The `id` values returned here are used as the `id` input parameter on all sending endpoints (`/mail/send`, `/mail/advsend`, `/mail/rawsend`) as well as the log and stats queries.  When the `id` parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.  To retrieve full details — including the current SMTP password — for a single order use `GET /mail/{id}`. 

### Example
```csharp
using System;
using System.Diagnostics;
using mailbaby-client-csharp.Api;
using mailbaby-client-csharp.Client;
using mailbaby-client-csharp.Model;

namespace Example
{
    public class GetMailOrdersExample
    {
        public void main()
        {
            // Configure API key authorization: apiKeyAuth
            Configuration.Default.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new ServicesApi();

            try
            {
                // Displays a list of mail service orders
                List&lt;MailOrder&gt; result = apiInstance.GetMailOrders();
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling ServicesApi.GetMailOrders: " + e.Message );
            }
        }
    }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List<MailOrder>**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
