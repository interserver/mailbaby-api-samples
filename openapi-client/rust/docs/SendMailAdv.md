# SendMailAdv

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **String** | The subject or title of the email | 
**body** | **String** | The main email contents. | 
**from** | [**crate::models::EmailAddressTypes**](EmailAddressTypes.md) |  | 
**to** | [**crate::models::EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
**replyto** | Option<[**crate::models::EmailAddressesTypes**](EmailAddressesTypes.md)> |  | [optional]
**cc** | Option<[**crate::models::EmailAddressesTypes**](EmailAddressesTypes.md)> |  | [optional]
**bcc** | Option<[**crate::models::EmailAddressesTypes**](EmailAddressesTypes.md)> |  | [optional]
**attachments** | Option<[**Vec<crate::models::MailAttachment>**](MailAttachment.md)> | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional]
**id** | Option<**i64**> | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


