# openapi.model.MailBlocks

## Load the model package
```dart
import 'package:openapi/api.dart';
```

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**local** | [**List<MailBlockClickHouse>**](MailBlockClickHouse.md) | Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list. | [default to const []]
**mbtrap** | [**List<MailBlockClickHouse>**](MailBlockClickHouse.md) | Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection. | [default to const []]
**subject** | [**List<MailBlockRspamd>**](MailBlockRspamd.md) | Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days. | [default to const []]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


