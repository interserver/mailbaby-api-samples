# ServicesApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getMailOrders**](ServicesApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders |


<a id="getMailOrders"></a>
# **getMailOrders**
> List&lt;MailOrder&gt; getMailOrders()

displays a list of mail service orders

This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mailbaby.net");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    ServicesApi apiInstance = new ServicesApi(defaultClient);
    try {
      List<MailOrder> result = apiInstance.getMailOrders();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServicesApi#getMailOrders");
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

[**List&lt;MailOrder&gt;**](MailOrder.md)

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

