# SendMailAdv
## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
| **subject** | **String** | The subject or title of the email | [default to null] |
| **body** | **String** | The main email contents. | [default to null] |
| **from** | [**EmailAddressTypes**](EmailAddressTypes.md) |  | [default to null] |
| **to** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [default to null] |
| **replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] [default to null] |
| **cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] [default to null] |
| **bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] [default to null] |
| **attachments** | [**List**](MailAttachment.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] [default to null] |
| **id** | **Long** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] [default to null] |

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

