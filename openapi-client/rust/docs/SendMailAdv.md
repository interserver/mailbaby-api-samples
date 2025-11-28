# SendMailAdv

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **String** | The subject or title of the email | 
**body** | **String** | The main email contents. | 
**from** | [**models::EmailAddressTypes**](EmailAddressTypes.md) |  | 
**to** | [**models::EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
**replyto** | Option<[**models::EmailAddressesTypes**](EmailAddressesTypes.md)> |  | [optional]
**cc** | Option<[**models::EmailAddressesTypes**](EmailAddressesTypes.md)> |  | [optional]
**bcc** | Option<[**models::EmailAddressesTypes**](EmailAddressesTypes.md)> |  | [optional]
**attachments** | Option<[**Vec<models::MailAttachment>**](MailAttachment.md)> | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional]
**id** | Option<**i64**> | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


