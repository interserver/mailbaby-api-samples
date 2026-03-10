# MailStatsType

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**time** | Option<**Time**> | The time window these `received`, `sent`, and `volume` statistics cover. (enum: all, billing, month, 7d, 24h, day, 1h) | [optional][default to Variant1h]
**usage** | Option<**i32**> | Total messages accepted during the current billing cycle.  Used to calculate the `cost` value. | [optional]
**currency** | Option<**String**> | The ISO 4217 currency code for this account (e.g. `USD`). | [optional]
**cost** | Option<**f64**> | Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). | [optional]
**received** | Option<**i32**> | Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue. | [optional]
**sent** | Option<**i32**> | Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`. | [optional]
**volume** | Option<[**models::MailStatsVolume**](MailStatsVolume.md)> |  | [optional]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


