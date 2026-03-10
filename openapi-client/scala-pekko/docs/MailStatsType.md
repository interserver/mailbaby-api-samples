

# MailStatsType

Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**time** | [**Time**](#Time) | The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover. |  [optional]
**usage** | **Int** | Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value. |  [optional]
**currency** | **String** | The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;). |  [optional]
**cost** | **Double** | Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). |  [optional]
**received** | **Int** | Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue. |  [optional]
**sent** | **Int** | Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;. |  [optional]
**volume** | [**MailStatsVolume**](MailStatsVolume.md) |  |  [optional]


## Enum: Time
Allowed values: [all, billing, month, 7d, 24h, day, 1h]




