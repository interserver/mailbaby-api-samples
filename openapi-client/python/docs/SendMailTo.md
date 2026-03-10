# SendMailTo

The primary recipient address for a simple send request. Accepts a single email address string or an array of email address strings for multiple recipients.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------

## Example

```python
from openapi_client.models.send_mail_to import SendMailTo

# TODO update the JSON string below
json = "{}"
# create an instance of SendMailTo from a JSON string
send_mail_to_instance = SendMailTo.from_json(json)
# print the JSON string representation of the object
print(SendMailTo.to_json())

# convert the object into a dict
send_mail_to_dict = send_mail_to_instance.to_dict()
# create an instance of SendMailTo from a dict
send_mail_to_from_dict = SendMailTo.from_dict(send_mail_to_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


