# mailbaby_client_dart_dio.api.StatusApi

## Load the API package
```dart
import 'package:mailbaby_client_dart_dio/api.dart';
```

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**pingServer**](StatusApi.md#pingserver) | **GET** /ping | Health check — verify the API is reachable


# **pingServer**
> String pingServer()

Health check — verify the API is reachable

**No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 

### Example
```dart
import 'package:mailbaby_client_dart_dio/api.dart';

final api = MailbabyClientDartDio().getStatusApi();

try {
    final response = api.pingServer();
    print(response);
} on DioException catch (e) {
    print('Exception when calling StatusApi->pingServer: $e\n');
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

