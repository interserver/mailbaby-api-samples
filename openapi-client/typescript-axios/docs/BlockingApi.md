# BlockingApi

All URIs are relative to *https://api.mailbaby.net*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**addRule**](#addrule) | **POST** /mail/rules | Creates a new email deny rule.|
|[**deleteRule**](#deleterule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.|
|[**delistBlock**](#delistblock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list|
|[**getMailBlocks**](#getmailblocks) | **GET** /mail/blocks | displays a list of blocked email addresses|
|[**getRules**](#getrules) | **GET** /mail/rules | Displays a listing of deny email rules.|

# **addRule**
> GenericResponse addRule()

Adds a new email deny rule into the system to block new emails that match the given criteria

### Example

```typescript
import {
    BlockingApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new BlockingApi(configuration);

let type: string; //The type of deny rule. (default to undefined)
let data: string; //The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. (default to undefined)
let user: string; //Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. (optional) (default to undefined)

const { status, data } = await apiInstance.addRule(
    type,
    data,
    user
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **type** | [**string**]**Array<&#39;domain&#39; &#124; &#39;email&#39; &#124; &#39;startswith&#39; &#124; &#39;destination&#39;>** | The type of deny rule. | defaults to undefined|
| **data** | [**string**] | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | defaults to undefined|
| **user** | [**string**] | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | (optional) defaults to undefined|


### Return type

**GenericResponse**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | search results matching criteria |  -  |
|**400** | Error message when there was a problem with the input parameters. |  -  |
|**401** | Unauthorized |  -  |
|**404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteRule**
> GenericResponse deleteRule()

Removes one of the configured deny mail rules from the system.

### Example

```typescript
import {
    BlockingApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new BlockingApi(configuration);

let ruleId: number; //The ID of the Rules entry. (default to undefined)

const { status, data } = await apiInstance.deleteRule(
    ruleId
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **ruleId** | [**number**] | The ID of the Rules entry. | defaults to undefined|


### Return type

**GenericResponse**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | search results matching criteria |  -  |
|**400** | Error message when there was a problem with the input parameters. |  -  |
|**401** | Unauthorized |  -  |
|**404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delistBlock**
> GenericResponse delistBlock(body)

Removes an email address from the various block lists. 

### Example

```typescript
import {
    BlockingApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new BlockingApi(configuration);

let body: string; //

const { status, data } = await apiInstance.delistBlock(
    body
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **body** | **string**|  | |


### Return type

**GenericResponse**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | search results matching criteria |  -  |
|**400** | Error message when there was a problem with the input parameters. |  -  |
|**401** | Unauthorized |  -  |
|**404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getMailBlocks**
> MailBlocks getMailBlocks()


### Example

```typescript
import {
    BlockingApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new BlockingApi(configuration);

const { status, data } = await apiInstance.getMailBlocks();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MailBlocks**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |
|**401** | Unauthorized |  -  |
|**404** | Unauthorized |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getRules**
> Array<DenyRuleRecord> getRules()

Returns a listing of all the deny block rules you have configured.

### Example

```typescript
import {
    BlockingApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new BlockingApi(configuration);

const { status, data } = await apiInstance.getRules();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**Array<DenyRuleRecord>**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |
|**401** | Unauthorized |  -  |
|**404** | Unauthorized |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

