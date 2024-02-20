# send_mail_adv_t

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **char \*** | The subject or title of the email | 
**body** | **char \*** | The main email contents. | 
**from** | [**email_address_types_t**](email_address_types.md) \* |  | 
**to** | [**email_addresses_types_t**](email_addresses_types.md) \* |  | 
**replyto** | [**email_addresses_types_t**](email_addresses_types.md) \* |  | [optional] 
**cc** | [**email_addresses_types_t**](email_addresses_types.md) \* |  | [optional] 
**bcc** | [**email_addresses_types_t**](email_addresses_types.md) \* |  | [optional] 
**attachments** | [**list_t**](mail_attachment.md) \* | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
**id** | **long** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


