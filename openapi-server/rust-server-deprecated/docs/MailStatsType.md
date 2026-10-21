# MailStatsType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**time** | [***models::MailStatsTypeTime**](MailStatsType_time.md) |  | [optional] [default to None]
**usage** | **i32** | Total messages accepted during the current billing cycle.  Used to calculate the `cost` value. | [optional] [default to None]
**currency** | **String** | The ISO 4217 currency code for this account (e.g. `USD`). | [optional] [default to None]
**cost** | **f64** | Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). | [optional] [default to None]
**received** | **i32** | Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue. | [optional] [default to None]
**sent** | **i32** | Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`. | [optional] [default to None]
**volume** | [***models::MailStatsVolume**](MailStatsVolume.md) |  | [optional] [default to None]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


