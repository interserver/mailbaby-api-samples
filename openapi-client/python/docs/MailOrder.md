# MailOrder

A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The `id` is the numeric identifier used across most API calls.  The `username` is always `mb<id>` and is the SMTP AUTH username for `relay.mailbaby.net`.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **int** | The unique numeric ID of the mail order.  Used as the &#x60;id&#x60; parameter on sending calls, log queries, and stats queries. | 
**status** | **str** | The current order status.  Only &#x60;active&#x60; orders can be used for sending. &#x60;canceled&#x60; orders are retained for history but cannot send. | 
**username** | **str** | The SMTP AUTH username for this order, always in the format &#x60;mb&lt;id&gt;&#x60;. Use together with the password from &#x60;GET /mail/{id}&#x60; to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; if needed. | 
**comment** | **str** | Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment. | [optional] 

## Example

```python
from openapi_client.models.mail_order import MailOrder

# TODO update the JSON string below
json = "{}"
# create an instance of MailOrder from a JSON string
mail_order_instance = MailOrder.from_json(json)
# print the JSON string representation of the object
print(MailOrder.to_json())

# convert the object into a dict
mail_order_dict = mail_order_instance.to_dict()
# create an instance of MailOrder from a dict
mail_order_from_dict = MailOrder.from_dict(mail_order_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


