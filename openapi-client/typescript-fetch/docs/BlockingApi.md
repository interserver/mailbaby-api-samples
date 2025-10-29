# BlockingApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addRule**](BlockingApi.md#addrule) | **POST** /mail/rules | Creates a new email deny rule. |
| [**deleteRule**](BlockingApi.md#deleterule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule. |
| [**delistBlock**](BlockingApi.md#delistblock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list |
| [**getMailBlocks**](BlockingApi.md#getmailblocks) | **GET** /mail/blocks | displays a list of blocked email addresses |
| [**getRules**](BlockingApi.md#getrules) | **GET** /mail/rules | Displays a listing of deny email rules. |



## addRule

> GenericResponse addRule(type, data, user)

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

### Example

```ts
import {
  Configuration,
  BlockingApi,
} from '';
import type { AddRuleRequest } from '';

async function example() {
  console.log("🚀 Testing  SDK...");
  const config = new Configuration({ 
    // To configure API key authorization: apiKeyAuth
    apiKey: "YOUR API KEY",
  });
  const api = new BlockingApi(config);

  const body = {
    // string | The type of deny rule.
    type: type_example,
    // string | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
    data: data_example,
    // string | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. (optional)
    user: user_example,
  } satisfies AddRuleRequest;

  try {
    const data = await api.addRule(body);
    console.log(data);
  } catch (error) {
    console.error(error);
  }
}

// Run the test
example().catch(console.error);
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **type** | `domain`, `email`, `startswith`, `destination` | The type of deny rule. | [Defaults to `undefined`] [Enum: domain, email, startswith, destination] |
| **data** | `string` | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | [Defaults to `undefined`] |
| **user** | `string` | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | [Optional] [Defaults to `undefined`] |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: `application/x-www-form-urlencoded`, `application/json`
- **Accept**: `application/json`


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | search results matching criteria |  -  |
| **400** | Error message when there was a problem with the input parameters. |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


## deleteRule

> GenericResponse deleteRule(ruleId)

Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.

### Example

```ts
import {
  Configuration,
  BlockingApi,
} from '';
import type { DeleteRuleRequest } from '';

async function example() {
  console.log("🚀 Testing  SDK...");
  const config = new Configuration({ 
    // To configure API key authorization: apiKeyAuth
    apiKey: "YOUR API KEY",
  });
  const api = new BlockingApi(config);

  const body = {
    // number | The ID of the Rules entry.
    ruleId: 34,
  } satisfies DeleteRuleRequest;

  try {
    const data = await api.deleteRule(body);
    console.log(data);
  } catch (error) {
    console.error(error);
  }
}

// Run the test
example().catch(console.error);
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **ruleId** | `number` | The ID of the Rules entry. | [Defaults to `undefined`] |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | search results matching criteria |  -  |
| **400** | Error message when there was a problem with the input parameters. |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


## delistBlock

> GenericResponse delistBlock(body)

Removes an email address from the blocked list

Removes an email address from the various block lists. 

### Example

```ts
import {
  Configuration,
  BlockingApi,
} from '';
import type { DelistBlockRequest } from '';

async function example() {
  console.log("🚀 Testing  SDK...");
  const config = new Configuration({ 
    // To configure API key authorization: apiKeyAuth
    apiKey: "YOUR API KEY",
  });
  const api = new BlockingApi(config);

  const body = {
    // string
    body: {"email":"client@domain.com"},
  } satisfies DelistBlockRequest;

  try {
    const data = await api.delistBlock(body);
    console.log(data);
  } catch (error) {
    console.error(error);
  }
}

// Run the test
example().catch(console.error);
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **body** | `string` |  | |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: `application/json`, `multipart/form-data`
- **Accept**: `application/json`


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | search results matching criteria |  -  |
| **400** | Error message when there was a problem with the input parameters. |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


## getMailBlocks

> MailBlocks getMailBlocks()

displays a list of blocked email addresses

### Example

```ts
import {
  Configuration,
  BlockingApi,
} from '';
import type { GetMailBlocksRequest } from '';

async function example() {
  console.log("🚀 Testing  SDK...");
  const config = new Configuration({ 
    // To configure API key authorization: apiKeyAuth
    apiKey: "YOUR API KEY",
  });
  const api = new BlockingApi(config);

  try {
    const data = await api.getMailBlocks();
    console.log(data);
  } catch (error) {
    console.error(error);
  }
}

// Run the test
example().catch(console.error);
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**MailBlocks**](MailBlocks.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **404** | Unauthorized |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


## getRules

> Array&lt;DenyRuleRecord&gt; getRules()

Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.

### Example

```ts
import {
  Configuration,
  BlockingApi,
} from '';
import type { GetRulesRequest } from '';

async function example() {
  console.log("🚀 Testing  SDK...");
  const config = new Configuration({ 
    // To configure API key authorization: apiKeyAuth
    apiKey: "YOUR API KEY",
  });
  const api = new BlockingApi(config);

  try {
    const data = await api.getRules();
    console.log(data);
  } catch (error) {
    console.error(error);
  }
}

// Run the test
example().catch(console.error);
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**Array&lt;DenyRuleRecord&gt;**](DenyRuleRecord.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **404** | Unauthorized |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)

