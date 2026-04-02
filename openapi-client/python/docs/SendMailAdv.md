# SendMailAdv

Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **str** | The subject line of the email. | 
**body** | **str** | The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | 
**var_from** | [**EmailAddressTypes**](EmailAddressTypes.md) | The sender address.  Accepts a plain email string, an RFC 822 named string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; object. | 
**to** | [**EmailAddressesTypes**](EmailAddressesTypes.md) | One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects. | 
**replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) | Optional.  One or more addresses to set as the &#x60;Reply-To&#x60; header. When recipients reply to the message their email client will address the reply to these addresses instead of &#x60;from&#x60;. | [optional] 
**cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) | Optional.  Carbon-copy recipients.  These addresses are listed in the &#x60;Cc&#x60; header and are visible to all recipients. | [optional] 
**bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) | Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header. | [optional] 
**attachments** | [**List[MailAttachment]**](MailAttachment.md) | Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name. | [optional] 
**id** | **int** | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] 

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


