# MailAttachment

A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**filename** | **str** | The filename shown to recipients (e.g. &#x60;report.pdf&#x60;, &#x60;invoice.xlsx&#x60;). | 
**data** | **bytes** | The file contents as a base64-encoded string.  Decode this to retrieve the original binary file. | 

## Example

```python
from openapi_client.models.mail_attachment import MailAttachment

# TODO update the JSON string below
json = "{}"
# create an instance of MailAttachment from a JSON string
mail_attachment_instance = MailAttachment.from_json(json)
# print the JSON string representation of the object
print(MailAttachment.to_json())

# convert the object into a dict
mail_attachment_dict = mail_attachment_instance.to_dict()
# create an instance of MailAttachment from a dict
mail_attachment_from_dict = MailAttachment.from_dict(mail_attachment_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


