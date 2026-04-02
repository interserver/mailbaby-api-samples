# DateOrTimestamp

A date/time value accepted as either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` (e.g. `2024-01-15`, `last monday`).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------

## Example

```python
from openapi_client.models.date_or_timestamp import DateOrTimestamp

# TODO update the JSON string below
json = "{}"
# create an instance of DateOrTimestamp from a JSON string
date_or_timestamp_instance = DateOrTimestamp.from_json(json)
# print the JSON string representation of the object
print(DateOrTimestamp.to_json())

# convert the object into a dict
date_or_timestamp_dict = date_or_timestamp_instance.to_dict()
# create an instance of DateOrTimestamp from a dict
date_or_timestamp_from_dict = DateOrTimestamp.from_dict(date_or_timestamp_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


