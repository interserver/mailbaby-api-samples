# IO.Swagger.Model.SendMailAdv
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Subject** | **string** | The subject line of the email. | 
**Body** | **string** | The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | 
**From** | [**EmailAddressTypes**](EmailAddressTypes.md) |  | 
**To** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
**Replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**Cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**Bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**Attachments** | [**List&lt;MailAttachment&gt;**](MailAttachment.md) | Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name. | [optional] 
**Id** | **long?** | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

