# MAIL_STATS_TYPE

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**time** | [**STRING_32**](STRING_32.md) | The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover. | [optional] [default to 1h]
**usage** | **INTEGER_32** | Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value. | [optional] [default to null]
**currency** | [**STRING_32**](STRING_32.md) | The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;). | [optional] [default to null]
**cost** | **REAL_64** | Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). | [optional] [default to null]
**received** | **INTEGER_32** | Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue. | [optional] [default to null]
**sent** | **INTEGER_32** | Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;. | [optional] [default to null]
**volume** | [**MAIL_STATS_TYPE_VOLUME**](MailStatsType_volume.md) |  | [optional] [default to null]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


