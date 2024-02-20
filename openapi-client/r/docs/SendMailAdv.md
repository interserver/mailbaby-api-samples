# openapi::SendMailAdv

Details for an Email

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **character** | The subject or title of the email | 
**body** | **character** | The main email contents. | 
**from** | [**EmailAddressTypes**](EmailAddressTypes.md) |  | 
**to** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
**replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**attachments** | [**array[MailAttachment]**](MailAttachment.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
**id** | **integer** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] 


