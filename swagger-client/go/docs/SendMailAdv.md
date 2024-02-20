# SendMailAdv

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Subject** | **string** | The subject or title of the email | [default to null]
**Body** | **string** | The main email contents. | [default to null]
**From** | [***EmailAddressTypes**](EmailAddressTypes.md) |  | [default to null]
**To** | [***EmailAddressesTypes**](EmailAddressesTypes.md) |  | [default to null]
**Replyto** | [***EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] [default to null]
**Cc** | [***EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] [default to null]
**Bcc** | [***EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] [default to null]
**Attachments** | [**[]MailAttachment**](MailAttachment.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] [default to null]
**Id** | **int64** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] [default to null]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

