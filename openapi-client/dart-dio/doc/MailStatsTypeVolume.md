# openapi.model.MailStatsTypeVolume

## Load the model package
```dart
import 'package:openapi/api.dart';
```

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**to** | **BuiltMap&lt;String, int&gt;** | Message counts keyed by destination (envelope `to`) email address. | [optional] 
**from** | **BuiltMap&lt;String, int&gt;** | Message counts keyed by sender (envelope `from`) email address. | [optional] 
**ip** | **BuiltMap&lt;String, int&gt;** | Message counts keyed by originating client IP address. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


