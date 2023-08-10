# EmailAddress

an email address

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**email** | **str** | an email address | [optional] 

## Example

```python
from openapi_client.models.email_address import EmailAddress

# TODO update the JSON string below
json = "{}"
# create an instance of EmailAddress from a JSON string
email_address_instance = EmailAddress.from_json(json)
# print the JSON string representation of the object
print EmailAddress.to_json()

# convert the object into a dict
email_address_dict = email_address_instance.to_dict()
# create an instance of EmailAddress from a dict
email_address_form_dict = email_address.from_dict(email_address_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


