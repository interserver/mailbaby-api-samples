# MailStatsVolume

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**to** | **std::collections::HashMap<String, i32>** | Message counts keyed by destination (envelope `to`) email address. | [optional] [default to None]
**from** | **std::collections::HashMap<String, i32>** | Message counts keyed by sender (envelope `from`) email address. | [optional] [default to None]
**ip** | **std::collections::HashMap<String, i32>** | Message counts keyed by originating client IP address. | [optional] [default to None]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


