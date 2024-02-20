# SEND_MAIL_ADV

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | [**STRING_32**](STRING_32.md) | The subject or title of the email | [default to null]
**body** | [**STRING_32**](STRING_32.md) | The main email contents. | [default to null]
**var_from** | [**EMAIL_ADDRESS_TYPES**](EmailAddressTypes.md) |  | [default to null]
**to** | [**EMAIL_ADDRESSES_TYPES**](EmailAddressesTypes.md) |  | [default to null]
**replyto** | [**EMAIL_ADDRESSES_TYPES**](EmailAddressesTypes.md) |  | [optional] [default to null]
**cc** | [**EMAIL_ADDRESSES_TYPES**](EmailAddressesTypes.md) |  | [optional] [default to null]
**bcc** | [**EMAIL_ADDRESSES_TYPES**](EmailAddressesTypes.md) |  | [optional] [default to null]
**attachments** | [**LIST [MAIL_ATTACHMENT]**](MailAttachment.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] [default to null]
**id** | **INTEGER_64** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] [default to null]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


