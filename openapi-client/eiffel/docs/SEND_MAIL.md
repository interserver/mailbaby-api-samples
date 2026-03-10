# SEND_MAIL

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**to** | [**SEND_MAIL_TO**](SendMailTo.md) |  | [default to null]
**var_from** | [**STRING_32**](STRING_32.md) | The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order. | [default to null]
**subject** | [**STRING_32**](STRING_32.md) | The subject line of the email. | [default to null]
**body** | [**STRING_32**](STRING_32.md) | The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | [default to null]
**id** | **INTEGER_64** | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] [default to null]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


