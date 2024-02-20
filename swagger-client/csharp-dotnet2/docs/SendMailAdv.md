# IO.Swagger.Model.SendMailAdv
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Subject** | **string** | The subject or title of the email | 
**Body** | **string** | The main email contents. | 
**From** | [**EmailAddressTypes**](EmailAddressTypes.md) |  | 
**To** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
**Replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**Cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**Bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**Attachments** | [**List&lt;MailAttachment&gt;**](MailAttachment.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
**Id** | **long?** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

