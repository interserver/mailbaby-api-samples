# mail_stats_type_t

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**time** | **mailbaby_email_delivery_and_management_service_api_mail_stats_type_TIME_e** | The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover. | [optional] [default to '1h']
**usage** | **int** | Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value. | [optional] 
**currency** | **char \*** | The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;). | [optional] 
**cost** | **double** | Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). | [optional] 
**received** | **int** | Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue. | [optional] 
**sent** | **int** | Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;. | [optional] 
**volume** | [**mail_stats_volume_t**](mail_stats_volume.md) \* |  | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


