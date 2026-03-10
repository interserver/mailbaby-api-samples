# MailStatsType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**time** | [**inline**](#Time) | The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover. |  [optional]
**usage** | [**kotlin.Int**](.md) | Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value. |  [optional]
**currency** | [**kotlin.String**](.md) | The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;). |  [optional]
**cost** | [**kotlin.Double**](.md) | Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). |  [optional]
**received** | [**kotlin.Int**](.md) | Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue. |  [optional]
**sent** | [**kotlin.Int**](.md) | Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;. |  [optional]
**volume** | [**MailStatsVolume**](MailStatsVolume.md) |  |  [optional]

<a name="Time"></a>
## Enum: time
Name | Value
---- | -----
time | all, billing, month, 7d, 24h, day, 1h
