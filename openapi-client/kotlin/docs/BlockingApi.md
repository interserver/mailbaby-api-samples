# BlockingApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**addRule**](BlockingApi.md#addRule) | **POST** /mail/rules | Creates a new email deny rule. |
| [**deleteRule**](BlockingApi.md#deleteRule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule. |
| [**delistBlock**](BlockingApi.md#delistBlock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list |
| [**getMailBlocks**](BlockingApi.md#getMailBlocks) | **GET** /mail/blocks | displays a list of blocked email addresses |
| [**getRules**](BlockingApi.md#getRules) | **GET** /mail/rules | Displays a listing of deny email rules. |


<a id="addRule"></a>
# **addRule**
> GenericResponse addRule(type, `data`, user)

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = BlockingApi()
val type : kotlin.String = type_example // kotlin.String | The type of deny rule.
val `data` : kotlin.String = `data`_example // kotlin.String | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
val user : kotlin.String = user_example // kotlin.String | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
try {
    val result : GenericResponse = apiInstance.addRule(type, `data`, user)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BlockingApi#addRule")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BlockingApi#addRule")
    e.printStackTrace()
}
```

### Parameters
| **type** | **kotlin.String**| The type of deny rule. | [enum: domain, email, startswith, destination] |
| **&#x60;data&#x60;** | **kotlin.String**| The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **user** | **kotlin.String**| Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | [optional] |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a id="deleteRule"></a>
# **deleteRule**
> GenericResponse deleteRule(ruleId)

Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = BlockingApi()
val ruleId : kotlin.Int = 34 // kotlin.Int | The ID of the Rules entry.
try {
    val result : GenericResponse = apiInstance.deleteRule(ruleId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BlockingApi#deleteRule")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BlockingApi#deleteRule")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **ruleId** | **kotlin.Int**| The ID of the Rules entry. | |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="delistBlock"></a>
# **delistBlock**
> GenericResponse delistBlock(body)

Removes an email address from the blocked list

Removes an email address from the various block lists. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = BlockingApi()
val body : kotlin.String = {"email":"client@domain.com"} // kotlin.String | 
try {
    val result : GenericResponse = apiInstance.delistBlock(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BlockingApi#delistBlock")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BlockingApi#delistBlock")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | **kotlin.String**|  | |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="getMailBlocks"></a>
# **getMailBlocks**
> MailBlocks getMailBlocks()

displays a list of blocked email addresses

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = BlockingApi()
try {
    val result : MailBlocks = apiInstance.getMailBlocks()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BlockingApi#getMailBlocks")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BlockingApi#getMailBlocks")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**MailBlocks**](MailBlocks.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getRules"></a>
# **getRules**
> kotlin.collections.List&lt;DenyRuleRecord&gt; getRules()

Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = BlockingApi()
try {
    val result : kotlin.collections.List<DenyRuleRecord> = apiInstance.getRules()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BlockingApi#getRules")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BlockingApi#getRules")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;DenyRuleRecord&gt;**](DenyRuleRecord.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

