# MailOrderDetail

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **i32** | The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries. | 
**status** | **String** | The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send. | 
**username** | **String** | The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed. | 
**comment** | Option<**String**> | Optional human-readable note associated with the order. | [optional]
**password** | **String** | The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`. | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


