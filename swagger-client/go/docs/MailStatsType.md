# MailStatsType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Time** | **string** | The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover. | [optional] [default to TIME.1H_]
**Usage** | **int32** | Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value. | [optional] [default to null]
**Currency** | **string** | The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;). | [optional] [default to null]
**Cost** | **float64** | Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). | [optional] [default to null]
**Received** | **int32** | Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue. | [optional] [default to null]
**Sent** | **int32** | Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;. | [optional] [default to null]
**Volume** | [***MailStatsTypeVolume**](MailStatsType_volume.md) |  | [optional] [default to null]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

