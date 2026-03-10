# SEND_MAIL_ADV

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | [**STRING_32**](STRING_32.md) | The subject line of the email. | [default to null]
**body** | [**STRING_32**](STRING_32.md) | The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | [default to null]
**var_from** | [**EMAIL_ADDRESS_TYPES**](EmailAddressTypes.md) |  | [default to null]
**to** | [**EMAIL_ADDRESSES_TYPES**](EmailAddressesTypes.md) |  | [default to null]
**replyto** | [**EMAIL_ADDRESSES_TYPES**](EmailAddressesTypes.md) |  | [optional] [default to null]
**cc** | [**EMAIL_ADDRESSES_TYPES**](EmailAddressesTypes.md) |  | [optional] [default to null]
**bcc** | [**EMAIL_ADDRESSES_TYPES**](EmailAddressesTypes.md) |  | [optional] [default to null]
**attachments** | [**LIST [MAIL_ATTACHMENT]**](MailAttachment.md) | Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name. | [optional] [default to null]
**id** | **INTEGER_64** | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] [default to null]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


