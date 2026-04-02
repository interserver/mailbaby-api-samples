# MailStatsType

Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**time** | **str** | The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover. | [optional] [default to OneHour]
**usage** | **int** | Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value. | [optional] 
**currency** | **str** | The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;). | [optional] 
**cost** | **float** | Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). | [optional] 
**received** | **int** | Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue. | [optional] 
**sent** | **int** | Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;. | [optional] 
**volume** | [**MailStatsVolume**](MailStatsVolume.md) |  | [optional] 

## Example

```python
from openapi_client.models.mail_stats_type import MailStatsType

# TODO update the JSON string below
json = "{}"
# create an instance of MailStatsType from a JSON string
mail_stats_type_instance = MailStatsType.from_json(json)
# print the JSON string representation of the object
print(MailStatsType.to_json())

# convert the object into a dict
mail_stats_type_dict = mail_stats_type_instance.to_dict()
# create an instance of MailStatsType from a dict
mail_stats_type_from_dict = MailStatsType.from_dict(mail_stats_type_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


