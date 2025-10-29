# .BlockingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addRule**](BlockingApi.md#addRule) | **POST** /mail/rules | Creates a new email deny rule.
[**deleteRule**](BlockingApi.md#deleteRule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
[**delistBlock**](BlockingApi.md#delistBlock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
[**getMailBlocks**](BlockingApi.md#getMailBlocks) | **GET** /mail/blocks | displays a list of blocked email addresses
[**getRules**](BlockingApi.md#getRules) | **GET** /mail/rules | Displays a listing of deny email rules.


# **addRule**
> GenericResponse addRule()

Adds a new email deny rule into the system to block new emails that match the given criteria

### Example


```typescript
import { createConfiguration, BlockingApi } from '';
import type { BlockingApiAddRuleRequest } from '';

const configuration = createConfiguration();
const apiInstance = new BlockingApi(configuration);

const request: BlockingApiAddRuleRequest = {
    // The type of deny rule.
  type: "email",
    // The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
  data: "domeinwo@server.guesshost.net",
    // Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. (optional)
  user: "mb20682",
};

const data = await apiInstance.addRule(request);
console.log('API called successfully. Returned data:', data);
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | [**string**]**Array<&#39;domain&#39; &#124; &#39;email&#39; &#124; &#39;startswith&#39; &#124; &#39;destination&#39;>** | The type of deny rule. | defaults to undefined
 **data** | [**string**] | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | defaults to undefined
 **user** | [**string**] | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | (optional) defaults to undefined


### Return type

**GenericResponse**

### Authorization

[apiKeyAuth](README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | search results matching criteria |  -  |
**400** | Error message when there was a problem with the input parameters. |  -  |
**401** | Unauthorized |  -  |
**404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **deleteRule**
> GenericResponse deleteRule()

Removes one of the configured deny mail rules from the system.

### Example


```typescript
import { createConfiguration, BlockingApi } from '';
import type { BlockingApiDeleteRuleRequest } from '';

const configuration = createConfiguration();
const apiInstance = new BlockingApi(configuration);

const request: BlockingApiDeleteRuleRequest = {
    // The ID of the Rules entry.
  ruleId: 34,
};

const data = await apiInstance.deleteRule(request);
console.log('API called successfully. Returned data:', data);
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ruleId** | [**number**] | The ID of the Rules entry. | defaults to undefined


### Return type

**GenericResponse**

### Authorization

[apiKeyAuth](README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | search results matching criteria |  -  |
**400** | Error message when there was a problem with the input parameters. |  -  |
**401** | Unauthorized |  -  |
**404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **delistBlock**
> GenericResponse delistBlock(body)

Removes an email address from the various block lists. 

### Example


```typescript
import { createConfiguration, BlockingApi } from '';
import type { BlockingApiDelistBlockRequest } from '';

const configuration = createConfiguration();
const apiInstance = new BlockingApi(configuration);

const request: BlockingApiDelistBlockRequest = {
  
  body: "{"email":"client@domain.com"}",
};

const data = await apiInstance.delistBlock(request);
console.log('API called successfully. Returned data:', data);
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | **string**|  |


### Return type

**GenericResponse**

### Authorization

[apiKeyAuth](README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | search results matching criteria |  -  |
**400** | Error message when there was a problem with the input parameters. |  -  |
**401** | Unauthorized |  -  |
**404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **getMailBlocks**
> MailBlocks getMailBlocks()


### Example


```typescript
import { createConfiguration, BlockingApi } from '';

const configuration = createConfiguration();
const apiInstance = new BlockingApi(configuration);

const request = {};

const data = await apiInstance.getMailBlocks(request);
console.log('API called successfully. Returned data:', data);
```


### Parameters
This endpoint does not need any parameter.


### Return type

**MailBlocks**

### Authorization

[apiKeyAuth](README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |
**404** | Unauthorized |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **getRules**
> Array<DenyRuleRecord> getRules()

Returns a listing of all the deny block rules you have configured.

### Example


```typescript
import { createConfiguration, BlockingApi } from '';

const configuration = createConfiguration();
const apiInstance = new BlockingApi(configuration);

const request = {};

const data = await apiInstance.getRules(request);
console.log('API called successfully. Returned data:', data);
```


### Parameters
This endpoint does not need any parameter.


### Return type

**Array<DenyRuleRecord>**

### Authorization

[apiKeyAuth](README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |
**404** | Unauthorized |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)


