# SendMailAdv

Details for an Email

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **str** | The subject or title of the email | 
**body** | **str** | The main email contents. | 
**var_from** | [**EmailAddressTypes**](EmailAddressTypes.md) |  | 
**to** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
**replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**attachments** | [**List[MailAttachment]**](MailAttachment.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
**id** | **int** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] 

## Example

```python
from openapi_client.models.send_mail_adv import SendMailAdv

# TODO update the JSON string below
json = "{}"
# create an instance of SendMailAdv from a JSON string
send_mail_adv_instance = SendMailAdv.from_json(json)
# print the JSON string representation of the object
print(SendMailAdv.to_json())

# convert the object into a dict
send_mail_adv_dict = send_mail_adv_instance.to_dict()
# create an instance of SendMailAdv from a dict
send_mail_adv_from_dict = SendMailAdv.from_dict(send_mail_adv_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


