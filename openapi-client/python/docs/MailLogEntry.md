# MailLogEntry

An email record

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **int** | internal db id | 
**id** | **str** | mail id | 
**var_from** | **str** | from address | 
**to** | **str** | to address | 
**subject** | **str** | email subject | 
**message_id** | **str** | message id | [optional] 
**created** | **str** | creation date | 
**time** | **int** | creation timestamp | 
**user** | **str** | user account | 
**transtype** | **str** | transaction type | 
**origin** | **str** | origin ip | 
**interface** | **str** | interface name | 
**sending_zone** | **str** | sending zone | 
**body_size** | **int** | email body size in bytes | 
**seq** | **int** | index of email in the to adderess list | 
**recipient** | **str** | to address this email is being sent to | 
**domain** | **str** | to address domain | 
**locked** | **int** | locked status | 
**lock_time** | **int** | lock timestamp | 
**assigned** | **str** | assigned server | 
**queued** | **str** | queued timestamp | 
**mx_hostname** | **str** | mx hostname | 
**response** | **str** | mail delivery response | 

## Example

```python
from openapi_client.models.mail_log_entry import MailLogEntry

# TODO update the JSON string below
json = "{}"
# create an instance of MailLogEntry from a JSON string
mail_log_entry_instance = MailLogEntry.from_json(json)
# print the JSON string representation of the object
print MailLogEntry.to_json()

# convert the object into a dict
mail_log_entry_dict = mail_log_entry_instance.to_dict()
# create an instance of MailLogEntry from a dict
mail_log_entry_form_dict = mail_log_entry.from_dict(mail_log_entry_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


