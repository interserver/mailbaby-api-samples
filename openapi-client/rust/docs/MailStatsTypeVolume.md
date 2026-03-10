# MailStatsTypeVolume

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**to** | Option<**std::collections::HashMap<String, i32>**> | Message counts keyed by destination (envelope `to`) email address. | [optional]
**from** | Option<**std::collections::HashMap<String, i32>**> | Message counts keyed by sender (envelope `from`) email address. | [optional]
**ip** | Option<**std::collections::HashMap<String, i32>**> | Message counts keyed by originating client IP address. | [optional]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


