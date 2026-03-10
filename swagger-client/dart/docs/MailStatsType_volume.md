# swagger.model.MailStatsTypeVolume

## Load the model package
```dart
import 'package:swagger/api.dart';
```

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**to** | **Map&lt;String, int&gt;** | Message counts keyed by destination (envelope &#x60;to&#x60;) email address. | [optional] [default to {}]
**from** | **Map&lt;String, int&gt;** | Message counts keyed by sender (envelope &#x60;from&#x60;) email address. | [optional] [default to {}]
**ip** | **Map&lt;String, int&gt;** | Message counts keyed by originating client IP address. | [optional] [default to {}]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

