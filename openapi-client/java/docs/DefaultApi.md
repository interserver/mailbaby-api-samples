# DefaultApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getMailOrders**](DefaultApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders |
| [**pingServer**](DefaultApi.md#pingServer) | **GET** /ping | Checks if the server is running |
| [**sendAdvMail**](DefaultApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options |
| [**sendMail**](DefaultApi.md#sendMail) | **POST** /mail/send | Sends an Email |
| [**viewMailLog**](DefaultApi.md#viewMailLog) | **GET** /mail/log | displays the mail log |


<a name="getMailOrders"></a>
# **getMailOrders**
> List&lt;GetMailOrders200ResponseInner&gt; getMailOrders()

displays a list of mail service orders

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mailbaby.net");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      List<GetMailOrders200ResponseInner> result = apiInstance.getMailOrders();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getMailOrders");
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

<a name="pingServer"></a>
# **pingServer**
> pingServer()

Checks if the server is running

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mailbaby.net");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      apiInstance.pingServer();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#pingServer");
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

null (empty response body)

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

<a name="sendAdvMail"></a>
# **sendAdvMail**
> GenericResponse sendAdvMail(sendMailAdv)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mailbaby.net");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    SendMailAdv sendMailAdv = new SendMailAdv(); // SendMailAdv | 
    try {
      GenericResponse result = apiInstance.sendAdvMail(sendMailAdv);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#sendAdvMail");
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
| **sendMailAdv** | [**SendMailAdv**](SendMailAdv.md)|  | |

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

<a name="sendMail"></a>
# **sendMail**
> GenericResponse sendMail(to, from, subject, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mailbaby.net");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String to = "to_example"; // String | The Contact whom is the primary recipient of this email.
    String from = "from_example"; // String | The contact whom is the this email is from.
    String subject = "subject_example"; // String | The subject or title of the email
    String body = "body_example"; // String | The main email contents.
    try {
      GenericResponse result = apiInstance.sendMail(to, from, subject, body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#sendMail");
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
| **to** | **String**| The Contact whom is the primary recipient of this email. | |
| **from** | **String**| The contact whom is the this email is from. | |
| **subject** | **String**| The subject or title of the email | |
| **body** | **String**| The main email contents. | |

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

<a name="viewMailLog"></a>
# **viewMailLog**
> MailLog viewMailLog(id, search, skip, limit)

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mailbaby.net");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Long id = 56L; // Long | The ID of your mail order this will be sent through.
    String search = "search_example"; // String | pass an optional search string for looking up inventory
    Integer skip = 0; // Integer | number of records to skip for pagination
    Integer limit = 100; // Integer | maximum number of records to return
    try {
      MailLog result = apiInstance.viewMailLog(id, search, skip, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#viewMailLog");
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
| **search** | **String**| pass an optional search string for looking up inventory | [optional] |
| **skip** | **Integer**| number of records to skip for pagination | [optional] [default to 0] |
| **limit** | **Integer**| maximum number of records to return | [optional] [default to 100] |

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

