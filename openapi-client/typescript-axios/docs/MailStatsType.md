# MailStatsType

Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**time** | **string** | The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover. | [optional] [default to TimeEnum__1h]
**usage** | **number** | Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value. | [optional] [default to undefined]
**currency** | **string** | The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;). | [optional] [default to undefined]
**cost** | **number** | Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). | [optional] [default to undefined]
**received** | **number** | Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue. | [optional] [default to undefined]
**sent** | **number** | Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;. | [optional] [default to undefined]
**volume** | [**MailStatsTypeVolume**](MailStatsTypeVolume.md) |  | [optional] [default to undefined]

## Example

```typescript
import { MailStatsType } from './api';

const instance: MailStatsType = {
    time,
    usage,
    currency,
    cost,
    received,
    sent,
    volume,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
