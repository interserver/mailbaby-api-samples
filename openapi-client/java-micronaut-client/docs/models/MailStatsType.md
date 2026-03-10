

# MailStatsType

Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.

The class is defined in **[MailStatsType.java](../../src/main/java/org/openapitools/model/MailStatsType.java)**

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**time** | [**TimeEnum**](#TimeEnum) | The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover. |  [optional property]
**usage** | `Integer` | Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value. |  [optional property]
**currency** | `String` | The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;). |  [optional property]
**cost** | `Double` | Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). |  [optional property]
**received** | `Integer` | Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue. |  [optional property]
**sent** | `Integer` | Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;. |  [optional property]
**volume** | [`MailStatsVolume`](MailStatsVolume.md) |  |  [optional property]

## TimeEnum

Name | Value
---- | -----
ALL | `"all"`
BILLING | `"billing"`
MONTH | `"month"`
_7D | `"7d"`
_24H | `"24h"`
DAY | `"day"`
_1H | `"1h"`








