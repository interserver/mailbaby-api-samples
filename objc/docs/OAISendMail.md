# OAISendMail

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**_id** | **NSNumber*** | The ID of the Mail order within our system to use as the Mail Account. | 
**from** | [**OAIMailContact***](OAIMailContact.md) |  | 
**to** | [**NSArray&lt;OAIMailContact&gt;***](OAIMailContact.md) | The Contact whom is the primary recipient of this email. | 
**subject** | **NSString*** | The subject or title of the email | 
**body** | **NSString*** | The main email contents. | 
**replyto** | [**NSArray&lt;OAIMailContact&gt;***](OAIMailContact.md) | Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
**cc** | [**NSArray&lt;OAIMailContact&gt;***](OAIMailContact.md) | Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
**bcc** | [**NSArray&lt;OAIMailContact&gt;***](OAIMailContact.md) | Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
**attachments** | [**NSArray&lt;OAIMailAttachment&gt;***](OAIMailAttachment.md) | Optional file attachments to include in the email | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


