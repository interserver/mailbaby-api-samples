# BlockingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addRule**](BlockingApi.md#addRule) | **POST** /mail/rules | Creates a new email deny rule.
[**deleteRule**](BlockingApi.md#deleteRule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
[**delistBlock**](BlockingApi.md#delistBlock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
[**getMailBlocks**](BlockingApi.md#getMailBlocks) | **GET** /mail/blocks | displays a list of blocked email addresses
[**getRules**](BlockingApi.md#getRules) | **GET** /mail/rules | Displays a listing of deny email rules.

<a name="addRule"></a>
# **addRule**
> GenericResponse addRule(user, type, data)

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BlockingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKeyAuth
ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
apiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.setApiKeyPrefix("Token");

BlockingApi apiInstance = new BlockingApi();
String user = "user_example"; // String | 
String type = "type_example"; // String | 
String data = "data_example"; // String | 
try {
    GenericResponse result = apiInstance.addRule(user, type, data);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BlockingApi#addRule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **user** | **String**|  |
 **type** | **String**|  | [enum: domain, email, startswith, destination]
 **data** | **String**|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

<a name="addRule"></a>
# **addRule**
> GenericResponse addRule(body)

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BlockingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKeyAuth
ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
apiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.setApiKeyPrefix("Token");

BlockingApi apiInstance = new BlockingApi();
DenyRuleNew body = new DenyRuleNew(); // DenyRuleNew | These are the fields needed to create a new email deny rule.
try {
    GenericResponse result = apiInstance.addRule(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BlockingApi#addRule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**DenyRuleNew**](DenyRuleNew.md)| These are the fields needed to create a new email deny rule. |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

<a name="deleteRule"></a>
# **deleteRule**
> GenericResponse deleteRule(ruleId)

Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BlockingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKeyAuth
ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
apiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.setApiKeyPrefix("Token");

BlockingApi apiInstance = new BlockingApi();
Integer ruleId = 56; // Integer | The ID of the Rules entry.
try {
    GenericResponse result = apiInstance.deleteRule(ruleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BlockingApi#deleteRule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ruleId** | **Integer**| The ID of the Rules entry. |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="delistBlock"></a>
# **delistBlock**
> GenericResponse delistBlock(body)

Removes an email address from the blocked list

Removes an email address from the various block lists. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BlockingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKeyAuth
ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
apiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.setApiKeyPrefix("Token");

BlockingApi apiInstance = new BlockingApi();
String body = "{   \"value\" : {     \"email\" : \"client@domain.com\"   } }"; // String | 
try {
    GenericResponse result = apiInstance.delistBlock(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BlockingApi#delistBlock");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**String**](String.md)|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

<a name="getMailBlocks"></a>
# **getMailBlocks**
> MailBlocks getMailBlocks()

displays a list of blocked email addresses

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BlockingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKeyAuth
ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
apiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.setApiKeyPrefix("Token");

BlockingApi apiInstance = new BlockingApi();
try {
    MailBlocks result = apiInstance.getMailBlocks();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BlockingApi#getMailBlocks");
    e.printStackTrace();
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

<a name="getRules"></a>
# **getRules**
> List&lt;DenyRuleRecord&gt; getRules()

Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BlockingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKeyAuth
ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
apiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.setApiKeyPrefix("Token");

BlockingApi apiInstance = new BlockingApi();
try {
    List<DenyRuleRecord> result = apiInstance.getRules();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BlockingApi#getRules");
    e.printStackTrace();
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

