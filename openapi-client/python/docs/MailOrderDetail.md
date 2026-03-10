# MailOrderDetail

Extended mail order record including the current SMTP password.  Returned by `GET /mail/{id}`.  The `username` and `password` fields can be used to authenticate directly against `relay.mailbaby.net:25` via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **int** | The unique numeric ID of the mail order.  Used as the &#x60;id&#x60; parameter on sending calls, log queries, and stats queries. | 
**status** | **str** | The current order status.  Only &#x60;active&#x60; orders can be used for sending. &#x60;canceled&#x60; orders are retained for history but cannot send. | 
**username** | **str** | The SMTP AUTH username for this order, always in the format &#x60;mb&lt;id&gt;&#x60;. Use together with the password from &#x60;GET /mail/{id}&#x60; to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; if needed. | 
**comment** | **str** | Optional human-readable note associated with the order. | [optional] 
**password** | **str** | The current SMTP AUTH password for this mail order.  Use with the &#x60;username&#x60; field to authenticate against &#x60;relay.mailbaby.net:25&#x60;. | 

## Example

```python
from openapi_client.models.mail_order_detail import MailOrderDetail

# TODO update the JSON string below
json = "{}"
# create an instance of MailOrderDetail from a JSON string
mail_order_detail_instance = MailOrderDetail.from_json(json)
# print the JSON string representation of the object
print(MailOrderDetail.to_json())

# convert the object into a dict
mail_order_detail_dict = mail_order_detail_instance.to_dict()
# create an instance of MailOrderDetail from a dict
mail_order_detail_from_dict = MailOrderDetail.from_dict(mail_order_detail_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


