# SwaggerClient::MailStatsType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**time** | **String** | The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover. | [optional] [default to &#x27;1h&#x27;]
**usage** | **Integer** | Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value. | [optional] 
**currency** | **String** | The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;). | [optional] 
**cost** | **Float** | Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). | [optional] 
**received** | **Integer** | Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue. | [optional] 
**sent** | **Integer** | Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;. | [optional] 
**volume** | [**MailStatsVolume**](MailStatsVolume.md) |  | [optional] 

