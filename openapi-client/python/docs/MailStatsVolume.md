# MailStatsVolume

Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**to** | **Dict[str, int]** | Message counts keyed by destination (envelope &#x60;to&#x60;) email address. | [optional] 
**var_from** | **Dict[str, int]** | Message counts keyed by sender (envelope &#x60;from&#x60;) email address. | [optional] 
**ip** | **Dict[str, int]** | Message counts keyed by originating client IP address. | [optional] 

## Example

```python
from openapi_client.models.mail_stats_volume import MailStatsVolume

# TODO update the JSON string below
json = "{}"
# create an instance of MailStatsVolume from a JSON string
mail_stats_volume_instance = MailStatsVolume.from_json(json)
# print the JSON string representation of the object
print(MailStatsVolume.to_json())

# convert the object into a dict
mail_stats_volume_dict = mail_stats_volume_instance.to_dict()
# create an instance of MailStatsVolume from a dict
mail_stats_volume_from_dict = MailStatsVolume.from_dict(mail_stats_volume_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


