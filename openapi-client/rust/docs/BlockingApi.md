# \BlockingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**add_rule**](BlockingApi.md#add_rule) | **POST** /mail/rules | Creates a new email deny rule.
[**delete_rule**](BlockingApi.md#delete_rule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
[**delist_block**](BlockingApi.md#delist_block) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
[**get_mail_blocks**](BlockingApi.md#get_mail_blocks) | **GET** /mail/blocks | displays a list of blocked email addresses
[**get_rules**](BlockingApi.md#get_rules) | **GET** /mail/rules | Displays a listing of deny email rules.



## add_rule

> crate::models::GenericResponse add_rule(r#type, data, user)
Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**r#type** | **String** | The type of deny rule. | [required] |
**data** | **String** | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | [required] |
**user** | Option<**String**> | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. |  |

### Return type

[**crate::models::GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded, application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## delete_rule

> crate::models::GenericResponse delete_rule(rule_id)
Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**rule_id** | **i32** | The ID of the Rules entry. | [required] |

### Return type

[**crate::models::GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## delist_block

> crate::models::GenericResponse delist_block(body)
Removes an email address from the blocked list

Removes an email address from the various block lists. 

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**body** | **String** |  | [required] |

### Return type

[**crate::models::GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/json, multipart/form-data
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## get_mail_blocks

> crate::models::MailBlocks get_mail_blocks()
displays a list of blocked email addresses

### Parameters

This endpoint does not need any parameter.

### Return type

[**crate::models::MailBlocks**](MailBlocks.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## get_rules

> Vec<crate::models::DenyRuleRecord> get_rules()
Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.

### Parameters

This endpoint does not need any parameter.

### Return type

[**Vec<crate::models::DenyRuleRecord>**](DenyRuleRecord.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

