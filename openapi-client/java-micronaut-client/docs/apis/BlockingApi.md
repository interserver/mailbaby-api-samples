# BlockingApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addRule**](BlockingApi.md#addRule) | **POST** /mail/rules | Creates a new email deny rule. |
| [**deleteRule**](BlockingApi.md#deleteRule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule. |
| [**delistBlock**](BlockingApi.md#delistBlock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list |
| [**getMailBlocks**](BlockingApi.md#getMailBlocks) | **GET** /mail/blocks | displays a list of blocked email addresses |
| [**getRules**](BlockingApi.md#getRules) | **GET** /mail/rules | Displays a listing of deny email rules. |


## Creating BlockingApi

To initiate an instance of `BlockingApi`, you can use micronaut's `ApplicationContext`:
```java
/* imports
import io.micronaut.runtime.Micronaut;
import io.micronaut.context.ApplicationContext;
import org.openapitools.api.BlockingApi;
*/

ApplicationContext context = Micronaut.run(/* ... */);
PetApi apiInstance = context.getBean(BlockingApi.class);
```

Or the `@Inject` annotation:
```java
@Singleton
class MyClass {
    @Inject
    BlockingApi blockingApi;

    /* ... use the injected variable */
}
```
Note that the class needs to be annotated with one of Micronaut's [scope annotations](https://docs.micronaut.io/latest/guide/#scopes) like `Singleton` in order to be processed.

More information can be found inside [Inversion of Control guide section](https://docs.micronaut.io/latest/guide/#ioc).

<a id="addRule"></a>
# **addRule**
```java
Mono<GenericResponse> BlockingApi.addRule(typedatauser)
```

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

### Parameters
| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **type** | `String`| The type of deny rule. | [enum: `domain`, `email`, `startswith`, `destination`] |
| **data** | `String`| The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | |
| **user** | `String`| Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | [optional parameter] |


### Return type
[**GenericResponse**](GenericResponse.md)

### Authorization
* **[apiKeyAuth](auth.md#apiKeyAuth)**

### HTTP request headers
 - **Content-Type**: `application/x-www-form-urlencoded`, `application/json`
 - **Accept**: `application/json`

<a id="deleteRule"></a>
# **deleteRule**
```java
Mono<GenericResponse> BlockingApi.deleteRule(ruleId)
```

Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.

### Parameters
| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **ruleId** | `Integer`| The ID of the Rules entry. | |


### Return type
[**GenericResponse**](GenericResponse.md)

### Authorization
* **[apiKeyAuth](auth.md#apiKeyAuth)**

### HTTP request headers
 - **Content-Type**: Not defined
 - **Accept**: `application/json`

<a id="delistBlock"></a>
# **delistBlock**
```java
Mono<GenericResponse> BlockingApi.delistBlock(_body)
```

Removes an email address from the blocked list

Removes an email address from the various block lists. 

### Parameters
| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **_body** | `String`|  | |


### Return type
[**GenericResponse**](GenericResponse.md)

### Authorization
* **[apiKeyAuth](auth.md#apiKeyAuth)**

### HTTP request headers
 - **Content-Type**: `application/json`, `multipart/form-data`
 - **Accept**: `application/json`

<a id="getMailBlocks"></a>
# **getMailBlocks**
```java
Mono<MailBlocks> BlockingApi.getMailBlocks()
```

displays a list of blocked email addresses



### Return type
[**MailBlocks**](MailBlocks.md)

### Authorization
* **[apiKeyAuth](auth.md#apiKeyAuth)**

### HTTP request headers
 - **Content-Type**: Not defined
 - **Accept**: `application/json`

<a id="getRules"></a>
# **getRules**
```java
Mono<List<DenyRuleRecord>> BlockingApi.getRules()
```

Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.



### Return type
[**List&lt;DenyRuleRecord&gt;**](DenyRuleRecord.md)

### Authorization
* **[apiKeyAuth](auth.md#apiKeyAuth)**

### HTTP request headers
 - **Content-Type**: Not defined
 - **Accept**: `application/json`

