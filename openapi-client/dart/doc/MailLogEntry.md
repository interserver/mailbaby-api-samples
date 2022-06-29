# openapi.model.MailLogEntry

## Load the model package
```dart
import 'package:openapi/api.dart';
```

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **int** | internal db id | 
**id** | **String** | mail id | 
**from** | **String** | from address | 
**to** | **String** | to address | 
**subject** | **String** | email subject | 
**messageId** | **String** | message id | 
**created** | **String** | creation date | 
**time** | **int** | creation timestamp | 
**user** | **String** | user account | 
**transtype** | **String** | transaction type | 
**transhost** | **String** | transaction host | 
**originhost** | **String** | origin host | 
**origin** | **String** | origin ip | 
**interface_** | **String** | interface name | 
**date** | **String** | date processed | 
**sendingZone** | **String** | sending zone | 
**bodySize** | **int** | email body size in bytes | 
**sourceMd5** | **String** | md5 sum of the email | 
**seq** | **int** | delivery sequency | 
**domain** | **String** | to address domain | 
**recipient** | **String** | email receiver address | 
**locked** | **int** | locked status | 
**lockTime** | **int** | lock timestamp | 
**assigned** | **String** | assigned server | 
**queued** | **String** | queued timestamp | 
**lock** | **String** | lock id | 
**logger** | **String** | logger | 
**mxPort** | **int** | mx port number | 
**connectionKey** | **String** | connection key | 
**mxHostname** | **String** | mx hostname | 
**sentBodyHash** | **String** | body hash | 
**sentBodySize** | **int** | sent body size in bytes | 
**md5Match** | **int** | md5 checksum matching result | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


