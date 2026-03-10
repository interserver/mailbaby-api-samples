# EmailAddressParam

A single email address parameter used as the body of `POST /mail/blocks/delete`.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**email** | **str** | The email address to delist from all block lists. | 

## Example

```python
from openapi_client.models.email_address_param import EmailAddressParam

# TODO update the JSON string below
json = "{}"
# create an instance of EmailAddressParam from a JSON string
email_address_param_instance = EmailAddressParam.from_json(json)
# print the JSON string representation of the object
print(EmailAddressParam.to_json())

# convert the object into a dict
email_address_param_dict = email_address_param_instance.to_dict()
# create an instance of EmailAddressParam from a dict
email_address_param_from_dict = EmailAddressParam.from_dict(email_address_param_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


