# openapi.model.MailBlockClickHouse

## Load the model package
```dart
import 'package:openapi/api.dart';
```

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**date** | [**Date**](Date.md) | The date the block event was recorded. | 
**from** | **String** | The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it. | 
**subject** | **String** | The `Subject` header of the blocked message. | 
**to** | **String** | The serialized list of recipients of the blocked message. | 
**messageId** | **String** | The `Message-ID` header of the blocked message, or `null` if not present. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


