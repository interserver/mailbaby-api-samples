# MailBabyEmailDeliveryAndManagementServiceApi.BlockingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addRule**](BlockingApi.md#addRule) | **POST** /mail/rules | Creates a new email deny rule.
[**deleteRule**](BlockingApi.md#deleteRule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
[**delistBlock**](BlockingApi.md#delistBlock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
[**getMailBlocks**](BlockingApi.md#getMailBlocks) | **GET** /mail/blocks | displays a list of blocked email addresses
[**getRules**](BlockingApi.md#getRules) | **GET** /mail/rules | Displays a listing of deny email rules.



## addRule

> GenericResponse addRule(type, data, opts)

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

### Example

```javascript
import MailBabyEmailDeliveryAndManagementServiceApi from 'mail_baby_email_delivery_and_management_service_api';
let defaultClient = MailBabyEmailDeliveryAndManagementServiceApi.ApiClient.instance;
// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryAndManagementServiceApi.BlockingApi();
let type = "type_example"; // String | The type of deny rule.
let data = "data_example"; // String | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
let opts = {
  'user': "user_example" // String | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
};
apiInstance.addRule(type, data, opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
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


## deleteRule

> GenericResponse deleteRule(ruleId)

Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.

### Example

```javascript
import MailBabyEmailDeliveryAndManagementServiceApi from 'mail_baby_email_delivery_and_management_service_api';
let defaultClient = MailBabyEmailDeliveryAndManagementServiceApi.ApiClient.instance;
// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryAndManagementServiceApi.BlockingApi();
let ruleId = 34; // Number | The ID of the Rules entry.
apiInstance.deleteRule(ruleId, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ruleId** | **Number**| The ID of the Rules entry. | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## delistBlock

> GenericResponse delistBlock(body)

Removes an email address from the blocked list

Removes an email address from the various block lists. 

### Example

```javascript
import MailBabyEmailDeliveryAndManagementServiceApi from 'mail_baby_email_delivery_and_management_service_api';
let defaultClient = MailBabyEmailDeliveryAndManagementServiceApi.ApiClient.instance;
// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryAndManagementServiceApi.BlockingApi();
let body = {"email":"client@domain.com"}; // String | 
apiInstance.delistBlock(body, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
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


## getMailBlocks

> MailBlocks getMailBlocks()

displays a list of blocked email addresses

### Example

```javascript
import MailBabyEmailDeliveryAndManagementServiceApi from 'mail_baby_email_delivery_and_management_service_api';
let defaultClient = MailBabyEmailDeliveryAndManagementServiceApi.ApiClient.instance;
// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryAndManagementServiceApi.BlockingApi();
apiInstance.getMailBlocks((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
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


## getRules

> [DenyRuleRecord] getRules()

Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.

### Example

```javascript
import MailBabyEmailDeliveryAndManagementServiceApi from 'mail_baby_email_delivery_and_management_service_api';
let defaultClient = MailBabyEmailDeliveryAndManagementServiceApi.ApiClient.instance;
// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryAndManagementServiceApi.BlockingApi();
apiInstance.getRules((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**[DenyRuleRecord]**](DenyRuleRecord.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

