# Org.OpenAPITools.Model.SendMailAdv
Details for an Email

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Subject** | **string** | The subject or title of the email | 
**Body** | **string** | The main email contents. | 
**From** | [**List&lt;SendMailAdvFrom&gt;**](SendMailAdvFrom.md) | The contact whom is the this email is from. | 
**To** | [**List&lt;MailContact&gt;**](MailContact.md) | The Contact whom is the primary recipient of this email. | 
**Id** | **long** | The ID of the Mail order within our system to use as the Mail Account. | 
**Replyto** | [**List&lt;MailContact&gt;**](MailContact.md) | Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
**Cc** | [**List&lt;MailContact&gt;**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
**Bcc** | [**List&lt;MailContact&gt;**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
**Attachments** | [**List&lt;MailAttachment&gt;**](MailAttachment.md) | Optional file attachments to include in the email | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

