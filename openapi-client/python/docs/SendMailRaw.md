# SendMailRaw

Request body for `POST /mail/rawsend`.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing `DKIM-Signature` header intact.  The `From`, `To`, `Cc`, and `Bcc` addresses are extracted from the message headers automatically — you do not need to specify them separately.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**raw_email** | **str** | The complete RFC 822 email message including all headers and the body. Must include at minimum &#x60;From&#x60;, &#x60;To&#x60;, &#x60;Subject&#x60;, &#x60;Date&#x60;, and &#x60;MIME-Version&#x60; headers.  DKIM signatures in the &#x60;DKIM-Signature&#x60; header are transmitted verbatim and will pass verification at the destination. | 
**id** | **int** | Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] 

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


