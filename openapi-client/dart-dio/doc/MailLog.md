# openapi.model.MailLog

## Load the model package
```dart
import 'package:openapi/api.dart';
```

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**total** | **int** | Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`. | 
**skip** | **int** | The `skip` value used for this page (echoed from the request). | 
**limit** | **int** | The `limit` value used for this page (echoed from the request). | 
**emails** | [**BuiltList&lt;MailLogEntry&gt;**](MailLogEntry.md) |  | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


