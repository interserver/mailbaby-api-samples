
# Table `MailStatsType`
(mapped from: MailStatsType)

## Properties
Name | Mapping | SQL Type | Default | Type | Description | Notes
---- | ------- | -------- | ------- | ---- | ----------- | -----
**time** | time | text |  | [**time**](#Time) | The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover. |  [optional]
**usage** | usage | int |  | **kotlin.Int** | Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value. |  [optional]
**currency** | currency | text |  | **kotlin.String** | The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;). |  [optional]
**cost** | cost | double |  | **kotlin.Double** | Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). |  [optional]
**received** | received | int |  | **kotlin.Int** | Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue. |  [optional]
**sent** | sent | int |  | **kotlin.Int** | Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;. |  [optional]
**volume** | volume | long |  | [**MailStatsVolume**](MailStatsVolume.md) |  |  [optional] [foreignkey]









