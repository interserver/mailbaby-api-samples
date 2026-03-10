# MailBlockClickHouse

A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_date** | **date** | The date the block event was recorded. | 
**var_from** | **str** | The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it. | 
**message_id** | **str** | The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present. | [optional] 
**subject** | **str** | The &#x60;Subject&#x60; header of the blocked message. | 
**to** | **str** | The serialized list of recipients of the blocked message. | 

## Example

```python
from openapi_client.models.mail_block_click_house import MailBlockClickHouse

# TODO update the JSON string below
json = "{}"
# create an instance of MailBlockClickHouse from a JSON string
mail_block_click_house_instance = MailBlockClickHouse.from_json(json)
# print the JSON string representation of the object
print(MailBlockClickHouse.to_json())

# convert the object into a dict
mail_block_click_house_dict = mail_block_click_house_instance.to_dict()
# create an instance of MailBlockClickHouse from a dict
mail_block_click_house_from_dict = MailBlockClickHouse.from_dict(mail_block_click_house_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


