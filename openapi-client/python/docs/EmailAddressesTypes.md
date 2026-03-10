# EmailAddressesTypes

A flexible email address list that accepts either a plain RFC 822 string or a structured array of contact objects.  When a string is provided it is parsed as a comma-separated list of RFC 822 addresses (supporting the `\"Name <email>\"` and bare `email` formats).  When an array is provided each entry must have at least an `email` field with an optional `name` field.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------

## Example

```python
from openapi_client.models.email_addresses_types import EmailAddressesTypes

# TODO update the JSON string below
json = "{}"
# create an instance of EmailAddressesTypes from a JSON string
email_addresses_types_instance = EmailAddressesTypes.from_json(json)
# print the JSON string representation of the object
print(EmailAddressesTypes.to_json())

# convert the object into a dict
email_addresses_types_dict = email_addresses_types_instance.to_dict()
# create an instance of EmailAddressesTypes from a dict
email_addresses_types_from_dict = EmailAddressesTypes.from_dict(email_addresses_types_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


