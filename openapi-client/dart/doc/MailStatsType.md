# openapi.model.MailStatsType

## Load the model package
```dart
import 'package:openapi/api.dart';
```

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**time** | **String** | The time window these `received`, `sent`, and `volume` statistics cover. | [optional] [default to '1h']
**usage** | **int** | Total messages accepted during the current billing cycle.  Used to calculate the `cost` value. | [optional] 
**currency** | **String** | The ISO 4217 currency code for this account (e.g. `USD`). | [optional] 
**cost** | **double** | Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). | [optional] 
**received** | **int** | Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue. | [optional] 
**sent** | **int** | Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`. | [optional] 
**volume** | [**MailStatsTypeVolume**](MailStatsTypeVolume.md) |  | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


