# OpenAPIClient::Object::MailStatsTypeVolume

## Load the model package
```perl
use OpenAPIClient::Object::MailStatsTypeVolume;
```

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**to** | **HASH[string,int]** | Message counts keyed by destination (envelope &#x60;to&#x60;) email address. | [optional] 
**from** | **HASH[string,int]** | Message counts keyed by sender (envelope &#x60;from&#x60;) email address. | [optional] 
**ip** | **HASH[string,int]** | Message counts keyed by originating client IP address. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


