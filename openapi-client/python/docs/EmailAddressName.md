# EmailAddressName

An email contact with an optional display name.  Used in structured address fields (`from`, `to`, `cc`, `bcc`, `replyto`) in `SendMailAdv`.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**email** | **str** | The email address. | 
**name** | **str** | Optional display name shown to recipients (e.g. in the &#x60;From:&#x60; header). | [optional] 

## Example

```python
from openapi_client.models.email_address_name import EmailAddressName

# TODO update the JSON string below
json = "{}"
# create an instance of EmailAddressName from a JSON string
email_address_name_instance = EmailAddressName.from_json(json)
# print the JSON string representation of the object
print(EmailAddressName.to_json())

# convert the object into a dict
email_address_name_dict = email_address_name_instance.to_dict()
# create an instance of EmailAddressName from a dict
email_address_name_from_dict = EmailAddressName.from_dict(email_address_name_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


