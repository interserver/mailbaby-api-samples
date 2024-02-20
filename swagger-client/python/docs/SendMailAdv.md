# SendMailAdv

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **str** | The subject or title of the email | 
**body** | **str** | The main email contents. | 
**_from** | [**EmailAddressTypes**](EmailAddressTypes.md) |  | 
**to** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
**replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**attachments** | [**list[MailAttachment]**](MailAttachment.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
**id** | **int** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

