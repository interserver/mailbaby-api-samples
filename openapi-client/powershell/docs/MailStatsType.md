# MailStatsType
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Time** | **String** | The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover. | [optional] [default to "1h"]
**Usage** | **Int32** | Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value. | [optional] 
**Currency** | **String** | The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;). | [optional] 
**Cost** | **Double** | Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). | [optional] 
**Received** | **Int32** | Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue. | [optional] 
**Sent** | **Int32** | Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;. | [optional] 
**Volume** | [**MailStatsTypeVolume**](MailStatsTypeVolume.md) |  | [optional] 

## Examples

- Prepare the resource
```powershell
$MailStatsType = Initialize-PSOpenAPIToolsMailStatsType  -Time null `
 -Usage null `
 -Currency null `
 -Cost null `
 -Received null `
 -Sent null `
 -Volume null
```

- Convert the resource to JSON
```powershell
$MailStatsType | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

