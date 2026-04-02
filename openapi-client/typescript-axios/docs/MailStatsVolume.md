# MailStatsVolume

Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**to** | **{ [key: string]: number; }** | Message counts keyed by destination (envelope &#x60;to&#x60;) email address. | [optional] [default to undefined]
**from** | **{ [key: string]: number; }** | Message counts keyed by sender (envelope &#x60;from&#x60;) email address. | [optional] [default to undefined]
**ip** | **{ [key: string]: number; }** | Message counts keyed by originating client IP address. | [optional] [default to undefined]

## Example

```typescript
import { MailStatsVolume } from './api';

const instance: MailStatsVolume = {
    to,
    from,
    ip,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
