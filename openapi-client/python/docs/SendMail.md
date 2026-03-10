# SendMail

Request body for `POST /mail/send`.  Sends a simple single-recipient message. HTML detection is automatic — if `body` contains HTML tags the message is sent as `text/html`; otherwise as `text/plain`.  The `from` address is automatically set as both the `From` and `Reply-To` headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use `POST /mail/advsend` instead.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**to** | [**SendMailTo**](SendMailTo.md) |  | 
**var_from** | **str** | The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order. | 
**subject** | **str** | The subject line of the email. | 
**body** | **str** | The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | 
**id** | **int** | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] 

## Example

```python
from openapi_client.models.send_mail import SendMail

# TODO update the JSON string below
json = "{}"
# create an instance of SendMail from a JSON string
send_mail_instance = SendMail.from_json(json)
# print the JSON string representation of the object
print(SendMail.to_json())

# convert the object into a dict
send_mail_dict = send_mail_instance.to_dict()
# create an instance of SendMail from a dict
send_mail_from_dict = SendMail.from_dict(send_mail_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


