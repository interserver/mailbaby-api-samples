# MailBlocks

The complete set of blocked addresses and message patterns returned by `GET /mail/blocks`.  Three independent block sources are combined into one response. Use `POST /mail/blocks/delete` with a `from` address from any entry to delist it.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**local** | [**List[MailBlockClickHouse]**](MailBlockClickHouse.md) | Messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule in the last 5 days. These are messages sent to recipients on a local block list. | 
**mbtrap** | [**List[MailBlockClickHouse]**](MailBlockClickHouse.md) | Messages flagged by the &#x60;MBTRAP&#x60; rspamd rule in the last 5 days. These triggered MailBaby&#39;s honeypot / trap address detection. | 
**subject** | [**List[MailBlockRspamd]**](MailBlockRspamd.md) | Senders whose messages contained spam-indicative subjects (containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with more than 4 occurrences of the same subject in the last 3 days. | 

## Example

```python
from openapi_client.models.mail_blocks import MailBlocks

# TODO update the JSON string below
json = "{}"
# create an instance of MailBlocks from a JSON string
mail_blocks_instance = MailBlocks.from_json(json)
# print the JSON string representation of the object
print(MailBlocks.to_json())

# convert the object into a dict
mail_blocks_dict = mail_blocks_instance.to_dict()
# create an instance of MailBlocks from a dict
mail_blocks_from_dict = MailBlocks.from_dict(mail_blocks_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


