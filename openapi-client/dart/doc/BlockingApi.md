# openapi.api.BlockingApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addRule**](BlockingApi.md#addrule) | **POST** /mail/rules | Creates a new email deny rule.
[**deleteRule**](BlockingApi.md#deleterule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
[**delistBlock**](BlockingApi.md#delistblock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
[**getMailBlocks**](BlockingApi.md#getmailblocks) | **GET** /mail/blocks | displays a list of blocked email addresses
[**getRules**](BlockingApi.md#getrules) | **GET** /mail/rules | Displays a listing of deny email rules.


# **addRule**
> GenericResponse addRule(type, data, user)

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

### Example
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';

final api_instance = BlockingApi();
final type = type_example; // String | The type of deny rule.
final data = data_example; // String | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
final user = user_example; // String | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.

try {
    final result = api_instance.addRule(type, data, user);
    print(result);
} catch (e) {
    print('Exception when calling BlockingApi->addRule: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **String**| The type of deny rule. | 
 **data** | **String**| The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | 
 **user** | **String**| Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | [optional] 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteRule**
> GenericResponse deleteRule(ruleId)

Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.

### Example
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';

final api_instance = BlockingApi();
final ruleId = 34; // int | The ID of the Rules entry.

try {
    final result = api_instance.deleteRule(ruleId);
    print(result);
} catch (e) {
    print('Exception when calling BlockingApi->deleteRule: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ruleId** | **int**| The ID of the Rules entry. | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delistBlock**
> GenericResponse delistBlock(body)

Removes an email address from the blocked list

Removes an email address from the various block lists. 

### Example
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';

final api_instance = BlockingApi();
final body = String(); // String | 

try {
    final result = api_instance.delistBlock(body);
    print(result);
} catch (e) {
    print('Exception when calling BlockingApi->delistBlock: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | **String**|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getMailBlocks**
> MailBlocks getMailBlocks()

displays a list of blocked email addresses

### Example
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';

final api_instance = BlockingApi();

try {
    final result = api_instance.getMailBlocks();
    print(result);
} catch (e) {
    print('Exception when calling BlockingApi->getMailBlocks: $e\n');
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**MailBlocks**](MailBlocks.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getRules**
> List<DenyRuleRecord> getRules()

Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.

### Example
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';

final api_instance = BlockingApi();

try {
    final result = api_instance.getRules();
    print(result);
} catch (e) {
    print('Exception when calling BlockingApi->getRules: $e\n');
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List<DenyRuleRecord>**](DenyRuleRecord.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

