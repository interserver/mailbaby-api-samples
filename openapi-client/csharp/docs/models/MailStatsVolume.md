# MailBabyCsharp.Model.MailStatsVolume
Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**To** | **Dictionary&lt;string, int&gt;** | Message counts keyed by destination (envelope &#x60;to&#x60;) email address. | [optional] 
**From** | **Dictionary&lt;string, int&gt;** | Message counts keyed by sender (envelope &#x60;from&#x60;) email address. | [optional] 
**Ip** | **Dictionary&lt;string, int&gt;** | Message counts keyed by originating client IP address. | [optional] 

[[Back to Model list]](../../README.md#documentation-for-models) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to README]](../../README.md)

