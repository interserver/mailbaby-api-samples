# openapi.api.DefaultApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailById**](DefaultApi.md#getmailbyid) | **GET** /mail/{id} | Gets mail order information by id
[**getMailOrders**](DefaultApi.md#getmailorders) | **GET** /mail | displays a list of mail service orders
[**pingServer**](DefaultApi.md#pingserver) | **GET** /ping | Checks if the server is running
[**placeMailOrder**](DefaultApi.md#placemailorder) | **POST** /mail/order | places a mail order
[**sendMailById**](DefaultApi.md#sendmailbyid) | **POST** /mail/{id}/send | Sends an Email
[**validateMailOrder**](DefaultApi.md#validatemailorder) | **GET** /mail/order | validatess order details before placing an order
[**viewMailLogById**](DefaultApi.md#viewmaillogbyid) | **GET** /mail/{id}/log | displays the mail log


# **getMailById**
> MailOrder getMailById(id)

Gets mail order information by id

returns information about a mail order in the system with the given id.

### Example 
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';
// TODO Configure API key authorization: apiLoginAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiLoginAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiLoginAuth').apiKeyPrefix = 'Bearer';
// TODO Configure API key authorization: apiPasswordAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiPasswordAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiPasswordAuth').apiKeyPrefix = 'Bearer';

final api_instance = DefaultApi();
final id = 789; // int | User ID

try { 
    final result = api_instance.getMailById(id);
    print(result);
} catch (e) {
    print('Exception when calling DefaultApi->getMailById: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| User ID | 

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
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';
// TODO Configure API key authorization: apiLoginAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiLoginAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiLoginAuth').apiKeyPrefix = 'Bearer';
// TODO Configure API key authorization: apiPasswordAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiPasswordAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiPasswordAuth').apiKeyPrefix = 'Bearer';

final api_instance = DefaultApi();

try { 
    final result = api_instance.getMailOrders();
    print(result);
} catch (e) {
    print('Exception when calling DefaultApi->getMailOrders: $e\n');
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

final api_instance = DefaultApi();

try { 
    api_instance.pingServer();
} catch (e) {
    print('Exception when calling DefaultApi->pingServer: $e\n');
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
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';
// TODO Configure API key authorization: apiLoginAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiLoginAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiLoginAuth').apiKeyPrefix = 'Bearer';
// TODO Configure API key authorization: apiPasswordAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiPasswordAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiPasswordAuth').apiKeyPrefix = 'Bearer';

final api_instance = DefaultApi();
final mailOrder = MailOrder(); // MailOrder | Inventory item to add

try { 
    api_instance.placeMailOrder(mailOrder);
} catch (e) {
    print('Exception when calling DefaultApi->placeMailOrder: $e\n');
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
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';
// TODO Configure API key authorization: apiLoginAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiLoginAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiLoginAuth').apiKeyPrefix = 'Bearer';
// TODO Configure API key authorization: apiPasswordAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiPasswordAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiPasswordAuth').apiKeyPrefix = 'Bearer';

final api_instance = DefaultApi();
final id = 789; // int | User ID
final subject = subject_example; // String | 
final body = body_example; // String | 
final to = to_example; // String | 
final from = from_example; // String | 

try { 
    final result = api_instance.sendMailById(id, subject, body, to, from);
    print(result);
} catch (e) {
    print('Exception when calling DefaultApi->sendMailById: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| User ID | 
 **subject** | **String**|  | [optional] 
 **body** | **String**|  | [optional] 
 **to** | **String**|  | [optional] 
 **from** | **String**|  | [optional] 

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
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';
// TODO Configure API key authorization: apiLoginAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiLoginAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiLoginAuth').apiKeyPrefix = 'Bearer';
// TODO Configure API key authorization: apiPasswordAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiPasswordAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiPasswordAuth').apiKeyPrefix = 'Bearer';

final api_instance = DefaultApi();

try { 
    api_instance.validateMailOrder();
} catch (e) {
    print('Exception when calling DefaultApi->validateMailOrder: $e\n');
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
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';
// TODO Configure API key authorization: apiLoginAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiLoginAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiLoginAuth').apiKeyPrefix = 'Bearer';
// TODO Configure API key authorization: apiPasswordAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiPasswordAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiPasswordAuth').apiKeyPrefix = 'Bearer';

final api_instance = DefaultApi();
final id = 789; // int | User ID
final searchString = searchString_example; // String | pass an optional search string for looking up inventory
final skip = 56; // int | number of records to skip for pagination
final limit = 56; // int | maximum number of records to return

try { 
    final result = api_instance.viewMailLogById(id, searchString, skip, limit);
    print(result);
} catch (e) {
    print('Exception when calling DefaultApi->viewMailLogById: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| User ID | 
 **searchString** | **String**| pass an optional search string for looking up inventory | [optional] 
 **skip** | **int**| number of records to skip for pagination | [optional] 
 **limit** | **int**| maximum number of records to return | [optional] 

### Return type

[**List<MailLog>**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
