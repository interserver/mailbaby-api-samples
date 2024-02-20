# BlockingApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addRule**](BlockingApi.md#addRule) | **POST** /mail/rules | Creates a new email deny rule. |
| [**deleteRule**](BlockingApi.md#deleteRule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule. |
| [**delistBlock**](BlockingApi.md#delistBlock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list |
| [**getMailBlocks**](BlockingApi.md#getMailBlocks) | **GET** /mail/blocks | displays a list of blocked email addresses |
| [**getRules**](BlockingApi.md#getRules) | **GET** /mail/rules | Displays a listing of deny email rules. |


<a name="addRule"></a>
# **addRule**
> GenericResponse addRule(type, data, user)

Creates a new email deny rule.

    Adds a new email deny rule into the system to block new emails that match the given criteria

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **type** | **String**| The type of deny rule. | [default to null] [enum: domain, email, startswith, destination] |
| **data** | **String**| The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | [default to null] |
| **user** | **String**| Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | [optional] [default to null] |

### Return type

[**GenericResponse**](../Models/GenericResponse.md)

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

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **ruleId** | **Integer**| The ID of the Rules entry. | [default to null] |

### Return type

[**GenericResponse**](../Models/GenericResponse.md)

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

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **body** | **String**|  | |

### Return type

[**GenericResponse**](../Models/GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/json, multipart/form-data
- **Accept**: application/json

<a name="getMailBlocks"></a>
# **getMailBlocks**
> MailBlocks getMailBlocks()

displays a list of blocked email addresses

### Parameters
This endpoint does not need any parameter.

### Return type

[**MailBlocks**](../Models/MailBlocks.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="getRules"></a>
# **getRules**
> List getRules()

Displays a listing of deny email rules.

    Returns a listing of all the deny block rules you have configured.

### Parameters
This endpoint does not need any parameter.

### Return type

[**List**](../Models/DenyRuleRecord.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

