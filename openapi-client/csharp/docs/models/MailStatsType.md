# MailBabyCsharp.Model.MailStatsType
Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Time** | **string** | The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover. | [optional] [default to TimeEnum.OneHour]
**Usage** | **int** | Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value. | [optional] 
**Currency** | **string** | The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;). | [optional] 
**Cost** | **double** | Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). | [optional] 
**Received** | **int** | Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue. | [optional] 
**Sent** | **int** | Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;. | [optional] 
**Volume** | [**MailStatsVolume**](MailStatsVolume.md) |  | [optional] 

[[Back to Model list]](../../README.md#documentation-for-models) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to README]](../../README.md)

