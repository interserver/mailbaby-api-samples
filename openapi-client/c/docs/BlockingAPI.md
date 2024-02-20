# BlockingAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**BlockingAPI_addRule**](BlockingAPI.md#BlockingAPI_addRule) | **POST** /mail/rules | Creates a new email deny rule.
[**BlockingAPI_deleteRule**](BlockingAPI.md#BlockingAPI_deleteRule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
[**BlockingAPI_delistBlock**](BlockingAPI.md#BlockingAPI_delistBlock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
[**BlockingAPI_getMailBlocks**](BlockingAPI.md#BlockingAPI_getMailBlocks) | **GET** /mail/blocks | displays a list of blocked email addresses
[**BlockingAPI_getRules**](BlockingAPI.md#BlockingAPI_getRules) | **GET** /mail/rules | Displays a listing of deny email rules.


# **BlockingAPI_addRule**
```c
// Creates a new email deny rule.
//
// Adds a new email deny rule into the system to block new emails that match the given criteria
//
generic_response_t* BlockingAPI_addRule(apiClient_t *apiClient, mailbaby_email_delivery_and_management_service_api_addRule_type_e type, char * data, char * user);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |
**type** | **mailbaby_email_delivery_and_management_service_api_addRule_type_e** | The type of deny rule. | 
**data** | **char \*** | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | 
**user** | **char \*** | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | [optional] 

### Return type

[generic_response_t](generic_response.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **BlockingAPI_deleteRule**
```c
// Removes an deny mail rule.
//
// Removes one of the configured deny mail rules from the system.
//
generic_response_t* BlockingAPI_deleteRule(apiClient_t *apiClient, int ruleId);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |
**ruleId** | **int** | The ID of the Rules entry. | 

### Return type

[generic_response_t](generic_response.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **BlockingAPI_delistBlock**
```c
// Removes an email address from the blocked list
//
// Removes an email address from the various block lists. 
//
generic_response_t* BlockingAPI_delistBlock(apiClient_t *apiClient, char * body);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |
**body** | **char \*** |  | 

### Return type

[generic_response_t](generic_response.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **BlockingAPI_getMailBlocks**
```c
// displays a list of blocked email addresses
//
mail_blocks_t* BlockingAPI_getMailBlocks(apiClient_t *apiClient);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |

### Return type

[mail_blocks_t](mail_blocks.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **BlockingAPI_getRules**
```c
// Displays a listing of deny email rules.
//
// Returns a listing of all the deny block rules you have configured.
//
list_t* BlockingAPI_getRules(apiClient_t *apiClient);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |

### Return type

[list_t](deny_rule_record.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

