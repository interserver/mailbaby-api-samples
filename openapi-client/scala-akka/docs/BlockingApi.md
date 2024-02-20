# BlockingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addRule**](BlockingApi.md#addRule) | **POST** /mail/rules | Creates a new email deny rule.
[**addRuleWithHttpInfo**](BlockingApi.md#addRuleWithHttpInfo) | **POST** /mail/rules | Creates a new email deny rule.
[**deleteRule**](BlockingApi.md#deleteRule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
[**deleteRuleWithHttpInfo**](BlockingApi.md#deleteRuleWithHttpInfo) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
[**delistBlock**](BlockingApi.md#delistBlock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
[**delistBlockWithHttpInfo**](BlockingApi.md#delistBlockWithHttpInfo) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
[**getMailBlocks**](BlockingApi.md#getMailBlocks) | **GET** /mail/blocks | displays a list of blocked email addresses
[**getMailBlocksWithHttpInfo**](BlockingApi.md#getMailBlocksWithHttpInfo) | **GET** /mail/blocks | displays a list of blocked email addresses
[**getRules**](BlockingApi.md#getRules) | **GET** /mail/rules | Displays a listing of deny email rules.
[**getRulesWithHttpInfo**](BlockingApi.md#getRulesWithHttpInfo) | **GET** /mail/rules | Displays a listing of deny email rules.



## addRule

> addRule(addRuleRequest): ApiRequest[GenericResponse]

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

### Example

```scala
// Import classes:
import 
import 
import org.openapitools.client.core._
import org.openapitools.client.core.CollectionFormats._
import org.openapitools.client.core.ApiKeyLocations._

import akka.actor.ActorSystem
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Example extends App {
    
    implicit val system: ActorSystem = ActorSystem()
    import system.dispatcher
    
    // Configure API key authorization: apiKeyAuth
    implicit val apiKeyAuth: ApiKeyValue = ApiKeyValue("YOUR API KEY")

    val apiInvoker = ApiInvoker()
    val apiInstance = BlockingApi("https://api.mailbaby.net")
    val `type`: String = `type`_example // String | The type of deny rule.

    val data: String = data_example // String | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.

    val user: String = user_example // String | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
    
    val request = apiInstance.addRule(`type`, data, user)
    val response = apiInvoker.execute(request)

    response.onComplete {
        case Success(ApiResponse(code, content, headers)) =>
            System.out.println(s"Status code: $code}")
            System.out.println(s"Response headers: ${headers.mkString(", ")}")
            System.out.println(s"Response body: $content")
        
        case Failure(error @ ApiError(code, message, responseContent, cause, headers)) =>
            System.err.println("Exception when calling BlockingApi#addRule")
            System.err.println(s"Status code: $code}")
            System.err.println(s"Reason: $responseContent")
            System.err.println(s"Response headers: ${headers.mkString(", ")}")
            error.printStackTrace();

        case Failure(exception) => 
            System.err.println("Exception when calling BlockingApi#addRule")
            exception.printStackTrace();
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **`type`** | **String**| The type of deny rule. | [enum: domain, email, startswith, destination]
 **data** | **String**| The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. |
 **user** | **String**| Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | [optional]

### Return type

ApiRequest[[**GenericResponse**](GenericResponse.md)]


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


## deleteRule

> deleteRule(deleteRuleRequest): ApiRequest[GenericResponse]

Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.

### Example

```scala
// Import classes:
import 
import 
import org.openapitools.client.core._
import org.openapitools.client.core.CollectionFormats._
import org.openapitools.client.core.ApiKeyLocations._

import akka.actor.ActorSystem
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Example extends App {
    
    implicit val system: ActorSystem = ActorSystem()
    import system.dispatcher
    
    // Configure API key authorization: apiKeyAuth
    implicit val apiKeyAuth: ApiKeyValue = ApiKeyValue("YOUR API KEY")

    val apiInvoker = ApiInvoker()
    val apiInstance = BlockingApi("https://api.mailbaby.net")
    val ruleId: Int = 34 // Int | The ID of the Rules entry.
    
    val request = apiInstance.deleteRule(ruleId)
    val response = apiInvoker.execute(request)

    response.onComplete {
        case Success(ApiResponse(code, content, headers)) =>
            System.out.println(s"Status code: $code}")
            System.out.println(s"Response headers: ${headers.mkString(", ")}")
            System.out.println(s"Response body: $content")
        
        case Failure(error @ ApiError(code, message, responseContent, cause, headers)) =>
            System.err.println("Exception when calling BlockingApi#deleteRule")
            System.err.println(s"Status code: $code}")
            System.err.println(s"Reason: $responseContent")
            System.err.println(s"Response headers: ${headers.mkString(", ")}")
            error.printStackTrace();

        case Failure(exception) => 
            System.err.println("Exception when calling BlockingApi#deleteRule")
            exception.printStackTrace();
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ruleId** | **Int**| The ID of the Rules entry. |

### Return type

ApiRequest[[**GenericResponse**](GenericResponse.md)]


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


## delistBlock

> delistBlock(delistBlockRequest): ApiRequest[GenericResponse]

Removes an email address from the blocked list

Removes an email address from the various block lists. 

### Example

```scala
// Import classes:
import 
import 
import org.openapitools.client.core._
import org.openapitools.client.core.CollectionFormats._
import org.openapitools.client.core.ApiKeyLocations._

import akka.actor.ActorSystem
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Example extends App {
    
    implicit val system: ActorSystem = ActorSystem()
    import system.dispatcher
    
    // Configure API key authorization: apiKeyAuth
    implicit val apiKeyAuth: ApiKeyValue = ApiKeyValue("YOUR API KEY")

    val apiInvoker = ApiInvoker()
    val apiInstance = BlockingApi("https://api.mailbaby.net")
    val body: String = {"email":"client@domain.com"} // String | 
    
    val request = apiInstance.delistBlock(body)
    val response = apiInvoker.execute(request)

    response.onComplete {
        case Success(ApiResponse(code, content, headers)) =>
            System.out.println(s"Status code: $code}")
            System.out.println(s"Response headers: ${headers.mkString(", ")}")
            System.out.println(s"Response body: $content")
        
        case Failure(error @ ApiError(code, message, responseContent, cause, headers)) =>
            System.err.println("Exception when calling BlockingApi#delistBlock")
            System.err.println(s"Status code: $code}")
            System.err.println(s"Reason: $responseContent")
            System.err.println(s"Response headers: ${headers.mkString(", ")}")
            error.printStackTrace();

        case Failure(exception) => 
            System.err.println("Exception when calling BlockingApi#delistBlock")
            exception.printStackTrace();
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | **String**|  |

### Return type

ApiRequest[[**GenericResponse**](GenericResponse.md)]


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


## getMailBlocks

> getMailBlocks(): ApiRequest[MailBlocks]

displays a list of blocked email addresses

### Example

```scala
// Import classes:
import 
import 
import org.openapitools.client.core._
import org.openapitools.client.core.CollectionFormats._
import org.openapitools.client.core.ApiKeyLocations._

import akka.actor.ActorSystem
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Example extends App {
    
    implicit val system: ActorSystem = ActorSystem()
    import system.dispatcher
    
    // Configure API key authorization: apiKeyAuth
    implicit val apiKeyAuth: ApiKeyValue = ApiKeyValue("YOUR API KEY")

    val apiInvoker = ApiInvoker()
    val apiInstance = BlockingApi("https://api.mailbaby.net")    
    val request = apiInstance.getMailBlocks()
    val response = apiInvoker.execute(request)

    response.onComplete {
        case Success(ApiResponse(code, content, headers)) =>
            System.out.println(s"Status code: $code}")
            System.out.println(s"Response headers: ${headers.mkString(", ")}")
            System.out.println(s"Response body: $content")
        
        case Failure(error @ ApiError(code, message, responseContent, cause, headers)) =>
            System.err.println("Exception when calling BlockingApi#getMailBlocks")
            System.err.println(s"Status code: $code}")
            System.err.println(s"Reason: $responseContent")
            System.err.println(s"Response headers: ${headers.mkString(", ")}")
            error.printStackTrace();

        case Failure(exception) => 
            System.err.println("Exception when calling BlockingApi#getMailBlocks")
            exception.printStackTrace();
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

ApiRequest[[**MailBlocks**](MailBlocks.md)]


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


## getRules

> getRules(): ApiRequest[Seq[DenyRuleRecord]]

Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.

### Example

```scala
// Import classes:
import 
import 
import org.openapitools.client.core._
import org.openapitools.client.core.CollectionFormats._
import org.openapitools.client.core.ApiKeyLocations._

import akka.actor.ActorSystem
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Example extends App {
    
    implicit val system: ActorSystem = ActorSystem()
    import system.dispatcher
    
    // Configure API key authorization: apiKeyAuth
    implicit val apiKeyAuth: ApiKeyValue = ApiKeyValue("YOUR API KEY")

    val apiInvoker = ApiInvoker()
    val apiInstance = BlockingApi("https://api.mailbaby.net")    
    val request = apiInstance.getRules()
    val response = apiInvoker.execute(request)

    response.onComplete {
        case Success(ApiResponse(code, content, headers)) =>
            System.out.println(s"Status code: $code}")
            System.out.println(s"Response headers: ${headers.mkString(", ")}")
            System.out.println(s"Response body: $content")
        
        case Failure(error @ ApiError(code, message, responseContent, cause, headers)) =>
            System.err.println("Exception when calling BlockingApi#getRules")
            System.err.println(s"Status code: $code}")
            System.err.println(s"Reason: $responseContent")
            System.err.println(s"Response headers: ${headers.mkString(", ")}")
            error.printStackTrace();

        case Failure(exception) => 
            System.err.println("Exception when calling BlockingApi#getRules")
            exception.printStackTrace();
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

ApiRequest[[**Seq[DenyRuleRecord]**](DenyRuleRecord.md)]


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

