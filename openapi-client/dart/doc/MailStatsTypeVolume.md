# openapi.model.MailStatsTypeVolume

## Load the model package
```dart
import 'package:openapi/api.dart';
```

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**to** | **Map<String, int>** | Message counts keyed by destination (envelope `to`) email address. | [optional] [default to const {}]
**from** | **Map<String, int>** | Message counts keyed by sender (envelope `from`) email address. | [optional] [default to const {}]
**ip** | **Map<String, int>** | Message counts keyed by originating client IP address. | [optional] [default to const {}]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


