# EmailAddressTypes

A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (`\"Name <email>\"`), or a structured contact object.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**email** | **str** | The email address. | 
**name** | **str** | Optional display name shown to recipients (e.g. in the &#x60;From:&#x60; header). | [optional] 

## Example

```python
from openapi_client.models.email_address_types import EmailAddressTypes

# TODO update the JSON string below
json = "{}"
# create an instance of EmailAddressTypes from a JSON string
email_address_types_instance = EmailAddressTypes.from_json(json)
# print the JSON string representation of the object
print(EmailAddressTypes.to_json())

# convert the object into a dict
email_address_types_dict = email_address_types_instance.to_dict()
# create an instance of EmailAddressTypes from a dict
email_address_types_from_dict = EmailAddressTypes.from_dict(email_address_types_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


