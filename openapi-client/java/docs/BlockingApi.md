# BlockingApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addRule**](BlockingApi.md#addRule) | **POST** /mail/rules | Creates a new email deny rule. |
| [**deleteRule**](BlockingApi.md#deleteRule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule. |
| [**delistBlock**](BlockingApi.md#delistBlock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list |
| [**getMailBlocks**](BlockingApi.md#getMailBlocks) | **GET** /mail/blocks | displays a list of blocked email addresses |
| [**getRules**](BlockingApi.md#getRules) | **GET** /mail/rules | Displays a listing of deny email rules. |


<a id="addRule"></a>
# **addRule**
> GenericResponse addRule(type, data, user)

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BlockingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mailbaby.net");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    BlockingApi apiInstance = new BlockingApi(defaultClient);
    String type = "domain"; // String | The type of deny rule.
    String data = "data_example"; // String | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
    String user = "user_example"; // String | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
    try {
      GenericResponse result = apiInstance.addRule(type, data, user);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BlockingApi#addRule");
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
| **type** | **String**| The type of deny rule. | [enum: domain, email, startswith, destination] |
| **data** | **String**| The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | |
| **user** | **String**| Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | [optional] |

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
| **400** | Error message when there was a problem with the input parameters. |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

<a id="deleteRule"></a>
# **deleteRule**
> GenericResponse deleteRule(ruleId)

Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BlockingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mailbaby.net");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    BlockingApi apiInstance = new BlockingApi(defaultClient);
    Integer ruleId = 34; // Integer | The ID of the Rules entry.
    try {
      GenericResponse result = apiInstance.deleteRule(ruleId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BlockingApi#deleteRule");
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
| **ruleId** | **Integer**| The ID of the Rules entry. | |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | search results matching criteria |  -  |
| **400** | Error message when there was a problem with the input parameters. |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

<a id="delistBlock"></a>
# **delistBlock**
> GenericResponse delistBlock(body)

Removes an email address from the blocked list

Removes an email address from the various block lists. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BlockingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mailbaby.net");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    BlockingApi apiInstance = new BlockingApi(defaultClient);
    String body = {"email":"client@domain.com"}; // String | 
    try {
      GenericResponse result = apiInstance.delistBlock(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BlockingApi#delistBlock");
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
| **body** | **String**|  | |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | search results matching criteria |  -  |
| **400** | Error message when there was a problem with the input parameters. |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

<a id="getMailBlocks"></a>
# **getMailBlocks**
> MailBlocks getMailBlocks()

displays a list of blocked email addresses

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BlockingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mailbaby.net");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    BlockingApi apiInstance = new BlockingApi(defaultClient);
    try {
      MailBlocks result = apiInstance.getMailBlocks();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BlockingApi#getMailBlocks");
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

[**MailBlocks**](MailBlocks.md)

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

<a id="getRules"></a>
# **getRules**
> List&lt;DenyRuleRecord&gt; getRules()

Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BlockingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mailbaby.net");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    BlockingApi apiInstance = new BlockingApi(defaultClient);
    try {
      List<DenyRuleRecord> result = apiInstance.getRules();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BlockingApi#getRules");
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

[**List&lt;DenyRuleRecord&gt;**](DenyRuleRecord.md)

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

