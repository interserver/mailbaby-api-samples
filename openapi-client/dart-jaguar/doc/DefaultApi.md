# openapi.api.DefaultApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailById**](DefaultApi.md#getMailById) | **Get** /mail/:id | Gets mail order information by id
[**getMailOrders**](DefaultApi.md#getMailOrders) | **Get** /mail | displays a list of mail service orders
[**pingServer**](DefaultApi.md#pingServer) | **Get** /ping | Checks if the server is running
[**placeMailOrder**](DefaultApi.md#placeMailOrder) | **Post** /mail/order | places a mail order
[**sendMailById**](DefaultApi.md#sendMailById) | **Post** /mail/:id/send | Sends an Email
[**validateMailOrder**](DefaultApi.md#validateMailOrder) | **Get** /mail/order | validatess order details before placing an order
[**viewMailLogById**](DefaultApi.md#viewMailLogById) | **Get** /mail/:id/log | displays the mail log


# **getMailById**
> MailOrder getMailById(id)

Gets mail order information by id

returns information about a mail order in the system with the given id.

### Example 
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//openapi.api.Configuration.apiKey{'X-API-KEY'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//openapi.api.Configuration.apiKeyPrefix{'X-API-KEY'} = "Bearer";
// TODO Configure API key authorization: apiLoginAuth
//openapi.api.Configuration.apiKey{'X-API-LOGIN'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//openapi.api.Configuration.apiKeyPrefix{'X-API-LOGIN'} = "Bearer";
// TODO Configure API key authorization: apiPasswordAuth
//openapi.api.Configuration.apiKey{'X-API-PASS'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//openapi.api.Configuration.apiKeyPrefix{'X-API-PASS'} = "Bearer";

var api_instance = new DefaultApi();
var id = 789; // int | User ID

try { 
    var result = api_instance.getMailById(id);
    print(result);
} catch (e) {
    print("Exception when calling DefaultApi->getMailById: $e\n");
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| User ID | [default to null]

### Return type

[**MailOrder**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getMailOrders**
> List<MailOrder> getMailOrders()

displays a list of mail service orders

### Example 
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//openapi.api.Configuration.apiKey{'X-API-KEY'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//openapi.api.Configuration.apiKeyPrefix{'X-API-KEY'} = "Bearer";
// TODO Configure API key authorization: apiLoginAuth
//openapi.api.Configuration.apiKey{'X-API-LOGIN'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//openapi.api.Configuration.apiKeyPrefix{'X-API-LOGIN'} = "Bearer";
// TODO Configure API key authorization: apiPasswordAuth
//openapi.api.Configuration.apiKey{'X-API-PASS'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//openapi.api.Configuration.apiKeyPrefix{'X-API-PASS'} = "Bearer";

var api_instance = new DefaultApi();

try { 
    var result = api_instance.getMailOrders();
    print(result);
} catch (e) {
    print("Exception when calling DefaultApi->getMailOrders: $e\n");
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List<MailOrder>**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **pingServer**
> pingServer()

Checks if the server is running

### Example 
```dart
import 'package:openapi/api.dart';

var api_instance = new DefaultApi();

try { 
    api_instance.pingServer();
} catch (e) {
    print("Exception when calling DefaultApi->pingServer: $e\n");
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **placeMailOrder**
> placeMailOrder(mailOrder)

places a mail order

Adds an item to the system

### Example 
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//openapi.api.Configuration.apiKey{'X-API-KEY'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//openapi.api.Configuration.apiKeyPrefix{'X-API-KEY'} = "Bearer";
// TODO Configure API key authorization: apiLoginAuth
//openapi.api.Configuration.apiKey{'X-API-LOGIN'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//openapi.api.Configuration.apiKeyPrefix{'X-API-LOGIN'} = "Bearer";
// TODO Configure API key authorization: apiPasswordAuth
//openapi.api.Configuration.apiKey{'X-API-PASS'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//openapi.api.Configuration.apiKeyPrefix{'X-API-PASS'} = "Bearer";

var api_instance = new DefaultApi();
var mailOrder = new MailOrder(); // MailOrder | Inventory item to add

try { 
    api_instance.placeMailOrder(mailOrder);
} catch (e) {
    print("Exception when calling DefaultApi->placeMailOrder: $e\n");
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **mailOrder** | [**MailOrder**](MailOrder.md)| Inventory item to add | [optional] 

### Return type

void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **sendMailById**
> GenericResponse sendMailById(id, subject, body, to, from)

Sends an Email

Sends An email through one of your mail orders.

### Example 
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//openapi.api.Configuration.apiKey{'X-API-KEY'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//openapi.api.Configuration.apiKeyPrefix{'X-API-KEY'} = "Bearer";
// TODO Configure API key authorization: apiLoginAuth
//openapi.api.Configuration.apiKey{'X-API-LOGIN'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//openapi.api.Configuration.apiKeyPrefix{'X-API-LOGIN'} = "Bearer";
// TODO Configure API key authorization: apiPasswordAuth
//openapi.api.Configuration.apiKey{'X-API-PASS'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//openapi.api.Configuration.apiKeyPrefix{'X-API-PASS'} = "Bearer";

var api_instance = new DefaultApi();
var id = 789; // int | User ID
var subject = subject_example; // String | 
var body = body_example; // String | 
var to = to_example; // String | 
var from = from_example; // String | 

try { 
    var result = api_instance.sendMailById(id, subject, body, to, from);
    print(result);
} catch (e) {
    print("Exception when calling DefaultApi->sendMailById: $e\n");
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| User ID | [default to null]
 **subject** | **String**|  | [optional] [default to null]
 **body** | **String**|  | [optional] [default to null]
 **to** | **String**|  | [optional] [default to null]
 **from** | **String**|  | [optional] [default to null]

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **validateMailOrder**
> validateMailOrder()

validatess order details before placing an order

### Example 
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//openapi.api.Configuration.apiKey{'X-API-KEY'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//openapi.api.Configuration.apiKeyPrefix{'X-API-KEY'} = "Bearer";
// TODO Configure API key authorization: apiLoginAuth
//openapi.api.Configuration.apiKey{'X-API-LOGIN'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//openapi.api.Configuration.apiKeyPrefix{'X-API-LOGIN'} = "Bearer";
// TODO Configure API key authorization: apiPasswordAuth
//openapi.api.Configuration.apiKey{'X-API-PASS'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//openapi.api.Configuration.apiKeyPrefix{'X-API-PASS'} = "Bearer";

var api_instance = new DefaultApi();

try { 
    api_instance.validateMailOrder();
} catch (e) {
    print("Exception when calling DefaultApi->validateMailOrder: $e\n");
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **viewMailLogById**
> List<MailLog> viewMailLogById(id, searchString, skip, limit)

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Example 
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//openapi.api.Configuration.apiKey{'X-API-KEY'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//openapi.api.Configuration.apiKeyPrefix{'X-API-KEY'} = "Bearer";
// TODO Configure API key authorization: apiLoginAuth
//openapi.api.Configuration.apiKey{'X-API-LOGIN'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//openapi.api.Configuration.apiKeyPrefix{'X-API-LOGIN'} = "Bearer";
// TODO Configure API key authorization: apiPasswordAuth
//openapi.api.Configuration.apiKey{'X-API-PASS'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//openapi.api.Configuration.apiKeyPrefix{'X-API-PASS'} = "Bearer";

var api_instance = new DefaultApi();
var id = 789; // int | User ID
var searchString = searchString_example; // String | pass an optional search string for looking up inventory
var skip = 56; // int | number of records to skip for pagination
var limit = 56; // int | maximum number of records to return

try { 
    var result = api_instance.viewMailLogById(id, searchString, skip, limit);
    print(result);
} catch (e) {
    print("Exception when calling DefaultApi->viewMailLogById: $e\n");
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| User ID | [default to null]
 **searchString** | **String**| pass an optional search string for looking up inventory | [optional] [default to null]
 **skip** | **int**| number of records to skip for pagination | [optional] [default to null]
 **limit** | **int**| maximum number of records to return | [optional] [default to null]

### Return type

[**List<MailLog>**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

