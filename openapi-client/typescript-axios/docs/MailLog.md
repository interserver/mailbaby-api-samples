# MailLog

Mail log records

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**total** | **number** | total number of mail log entries | [default to undefined]
**skip** | **number** | number of emails skipped in listing | [default to undefined]
**limit** | **number** | number of emails to return | [default to undefined]
**emails** | [**Array&lt;MailLogEntry&gt;**](MailLogEntry.md) |  | [default to undefined]

## Example

```typescript
import { MailLog } from './api';

const instance: MailLog = {
    total,
    skip,
    limit,
    emails,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
