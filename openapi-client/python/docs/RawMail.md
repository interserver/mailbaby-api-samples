# RawMail

Raw Email Object

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**raw_email** | **str** | The entire email contents | 

## Example

```python
from openapi_client.models.raw_mail import RawMail

# TODO update the JSON string below
json = "{}"
# create an instance of RawMail from a JSON string
raw_mail_instance = RawMail.from_json(json)
# print the JSON string representation of the object
print(RawMail.to_json())

# convert the object into a dict
raw_mail_dict = raw_mail_instance.to_dict()
# create an instance of RawMail from a dict
raw_mail_from_dict = RawMail.from_dict(raw_mail_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


