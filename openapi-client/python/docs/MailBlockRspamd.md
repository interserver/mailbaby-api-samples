# MailBlockRspamd

A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The `from` address can be passed to `POST /mail/blocks/delete` to delist it.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_from** | **str** | The sender email address.  Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist the sender. | 
**subject** | **str** | The suspicious subject pattern that triggered the block. | 

## Example

```python
from openapi_client.models.mail_block_rspamd import MailBlockRspamd

# TODO update the JSON string below
json = "{}"
# create an instance of MailBlockRspamd from a JSON string
mail_block_rspamd_instance = MailBlockRspamd.from_json(json)
# print the JSON string representation of the object
print(MailBlockRspamd.to_json())

# convert the object into a dict
mail_block_rspamd_dict = mail_block_rspamd_instance.to_dict()
# create an instance of MailBlockRspamd from a dict
mail_block_rspamd_from_dict = MailBlockRspamd.from_dict(mail_block_rspamd_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


