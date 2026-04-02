# MailBabyEmailDeliveryAndManagementServiceApi.MailStatsType

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**time** | **String** | The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover. | [optional] [default to &#39;1h&#39;]
**usage** | **Number** | Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value. | [optional] 
**currency** | **String** | The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;). | [optional] 
**cost** | **Number** | Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). | [optional] 
**received** | **Number** | Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue. | [optional] 
**sent** | **Number** | Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;. | [optional] 
**volume** | [**MailStatsVolume**](MailStatsVolume.md) |  | [optional] 



## Enum: TimeEnum


* `All` (value: `"all"`)

* `Billing` (value: `"billing"`)

* `Month` (value: `"month"`)

* `SevenDays` (value: `"7d"`)

* `TwentyFourHours` (value: `"24h"`)

* `Day` (value: `"day"`)

* `OneHour` (value: `"1h"`)




