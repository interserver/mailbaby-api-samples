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
> GenericResponse addRule(user, type, `data`)

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BlockingApi()
val user : kotlin.String = user_example // kotlin.String | 
val type : kotlin.String = type_example // kotlin.String | 
val `data` : kotlin.String = `data`_example // kotlin.String | 
try {
    val result : GenericResponse = apiInstance.addRule(user, type, `data`)
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

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **user** | **kotlin.String**|  |
 **type** | **kotlin.String**|  | [enum: domain, email, startswith]
 **&#x60;data&#x60;** | **kotlin.String**|  |

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
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BlockingApi()
val body : DenyRuleNew = {
  "value" : {
    "user" : "mb20682",
    "type" : "email",
    "data" : "domeinwo@server.guesshost.net"
  }
} // DenyRuleNew | These are the fields needed to create a new email deny rule.
try {
    val result : GenericResponse = apiInstance.addRule(body)
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
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BlockingApi()
val ruleId : kotlin.Int = 56 // kotlin.Int | The ID of the Rules entry.
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

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ruleId** | **kotlin.Int**| The ID of the Rules entry. |

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
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BlockingApi()
val body : EmailAddress = {
  "value" : {
    "email" : "client@domain.com"
  }
} // EmailAddress | 
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

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**EmailAddress**](EmailAddress.md)|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

<a name="delistBlock"></a>
# **delistBlock**
> GenericResponse delistBlock(email)

Removes an email address from the blocked list

Removes an email address from the various block lists. 

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BlockingApi()
val email : kotlin.String = email_example // kotlin.String | 
try {
    val result : GenericResponse = apiInstance.delistBlock(email)
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

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **kotlin.String**|  |

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
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

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

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getRules"></a>
# **getRules**
> kotlin.Array&lt;DenyRuleRecord&gt; getRules()

Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BlockingApi()
try {
    val result : kotlin.Array<DenyRuleRecord> = apiInstance.getRules()
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

[**kotlin.Array&lt;DenyRuleRecord&gt;**](DenyRuleRecord.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

