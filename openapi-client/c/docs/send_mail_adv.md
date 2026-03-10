# send_mail_adv_t

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **char \*** | The subject line of the email. | 
**body** | **char \*** | The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | 
**from** | [**email_address_types_t**](email_address_types.md) \* |  | 
**to** | [**email_addresses_types_t**](email_addresses_types.md) \* |  | 
**replyto** | [**email_addresses_types_t**](email_addresses_types.md) \* |  | [optional] 
**cc** | [**email_addresses_types_t**](email_addresses_types.md) \* |  | [optional] 
**bcc** | [**email_addresses_types_t**](email_addresses_types.md) \* |  | [optional] 
**attachments** | [**list_t**](mail_attachment.md) \* | Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name. | [optional] 
**id** | **long** | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


