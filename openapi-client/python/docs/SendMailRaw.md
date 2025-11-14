# SendMailRaw

Raw Email Object

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**raw_email** | **str** | The entire email contents | 
**id** | **int** | Optional order id | [optional] 

## Example

```python
from openapi_client.models.send_mail_raw import SendMailRaw

# TODO update the JSON string below
json = "{}"
# create an instance of SendMailRaw from a JSON string
send_mail_raw_instance = SendMailRaw.from_json(json)
# print the JSON string representation of the object
print(SendMailRaw.to_json())

# convert the object into a dict
send_mail_raw_dict = send_mail_raw_instance.to_dict()
# create an instance of SendMailRaw from a dict
send_mail_raw_from_dict = SendMailRaw.from_dict(send_mail_raw_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


