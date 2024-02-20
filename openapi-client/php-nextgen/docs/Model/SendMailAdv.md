# # SendMailAdv

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **string** | The subject or title of the email |
**body** | **string** | The main email contents. |
**from** | [**\OpenAPI\Client\Model\EmailAddressTypes**](EmailAddressTypes.md) |  |
**to** | [**\OpenAPI\Client\Model\EmailAddressesTypes**](EmailAddressesTypes.md) |  |
**replyto** | [**\OpenAPI\Client\Model\EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional]
**cc** | [**\OpenAPI\Client\Model\EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional]
**bcc** | [**\OpenAPI\Client\Model\EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional]
**attachments** | [**\OpenAPI\Client\Model\MailAttachment[]**](MailAttachment.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional]
**id** | **int** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
