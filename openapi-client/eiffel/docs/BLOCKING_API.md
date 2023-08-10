# BLOCKING_API

All URIs are relative to *https://api.mailbaby.net*

Feature | HTTP request | Description
------------- | ------------- | -------------
[**add_rule**](BLOCKING_API.md#add_rule) | **Post** /mail/rules | Creates a new email deny rule.
[**delete_rule**](BLOCKING_API.md#delete_rule) | **Delete** /mail/rules/{ruleId} | Removes an deny mail rule.
[**delist_block**](BLOCKING_API.md#delist_block) | **Post** /mail/blocks/delete | Removes an email address from the blocked list
[**mail_blocks**](BLOCKING_API.md#mail_blocks) | **Get** /mail/blocks | displays a list of blocked email addresses
[**rules**](BLOCKING_API.md#rules) | **Get** /mail/rules | Displays a listing of deny email rules.


# **add_rule**
> add_rule (type: STRING_32 ; data: STRING_32 ; user:  detachable STRING_32 ): detachable GENERIC_RESPONSE


Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **STRING_32**| The type of deny rule. | [default to null]
 **data** | **STRING_32**| The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | [default to null]
 **user** | **STRING_32**| Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | [optional] [default to null]

### Return type

[**GENERIC_RESPONSE**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_rule**
> delete_rule (rule_id: INTEGER_32 ): detachable GENERIC_RESPONSE


Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rule_id** | **INTEGER_32**| The ID of the Rules entry. | [default to null]

### Return type

[**GENERIC_RESPONSE**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delist_block**
> delist_block (email_address: EMAIL_ADDRESS ): detachable GENERIC_RESPONSE


Removes an email address from the blocked list

Removes an email address from the various block lists. 


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email_address** | [**EMAIL_ADDRESS**](EMAIL_ADDRESS.md)|  | 

### Return type

[**GENERIC_RESPONSE**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mail_blocks**
> mail_blocks : detachable MAIL_BLOCKS


displays a list of blocked email addresses


### Parameters
This endpoint does not need any parameter.

### Return type

[**MAIL_BLOCKS**](MailBlocks.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **rules**
> rules : detachable LIST [DENY_RULE_RECORD]


Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.


### Parameters
This endpoint does not need any parameter.

### Return type

[**LIST [DENY_RULE_RECORD]**](DenyRuleRecord.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

