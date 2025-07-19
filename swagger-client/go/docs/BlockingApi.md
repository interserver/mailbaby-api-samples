# {{classname}}

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**AddRule**](BlockingApi.md#AddRule) | **Post** /mail/rules | Creates a new email deny rule.
[**DeleteRule**](BlockingApi.md#DeleteRule) | **Delete** /mail/rules/{ruleId} | Removes an deny mail rule.
[**DelistBlock**](BlockingApi.md#DelistBlock) | **Post** /mail/blocks/delete | Removes an email address from the blocked list
[**GetMailBlocks**](BlockingApi.md#GetMailBlocks) | **Get** /mail/blocks | displays a list of blocked email addresses
[**GetRules**](BlockingApi.md#GetRules) | **Get** /mail/rules | Displays a listing of deny email rules.

# **AddRule**
> GenericResponse AddRule(ctx, user, type_, data, body)
Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
  **user** | **string**|  | 
  **type_** | **string**|  | 
  **data** | **string**|  | 
  **body** | [**DenyRuleNew**](DenyRuleNew.md)| These are the fields needed to create a new email deny rule. | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **DeleteRule**
> GenericResponse DeleteRule(ctx, ruleId)
Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
  **ruleId** | **int32**| The ID of the Rules entry. | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **DelistBlock**
> GenericResponse DelistBlock(ctx, body)
Removes an email address from the blocked list

Removes an email address from the various block lists. 

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
  **body** | [**string**](string.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **GetMailBlocks**
> MailBlocks GetMailBlocks(ctx, )
displays a list of blocked email addresses

### Required Parameters
This endpoint does not need any parameter.

### Return type

[**MailBlocks**](MailBlocks.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **GetRules**
> []DenyRuleRecord GetRules(ctx, )
Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.

### Required Parameters
This endpoint does not need any parameter.

### Return type

[**[]DenyRuleRecord**](DenyRuleRecord.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

