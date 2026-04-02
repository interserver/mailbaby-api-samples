# SendMailAdv

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Subject** | **string** | The subject line of the email. | [default to null]
**Body** | **string** | The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | [default to null]
**From** | [***AllOfSendMailAdvFrom**](AllOfSendMailAdvFrom.md) | The sender address.  Accepts a plain email string, an RFC 822 named string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; object. | [default to null]
**To** | [***AllOfSendMailAdvTo**](AllOfSendMailAdvTo.md) | One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects. | [default to null]
**Replyto** | [***AllOfSendMailAdvReplyto**](AllOfSendMailAdvReplyto.md) | Optional.  One or more addresses to set as the &#x60;Reply-To&#x60; header. When recipients reply to the message their email client will address the reply to these addresses instead of &#x60;from&#x60;. | [optional] [default to null]
**Cc** | [***AllOfSendMailAdvCc**](AllOfSendMailAdvCc.md) | Optional.  Carbon-copy recipients.  These addresses are listed in the &#x60;Cc&#x60; header and are visible to all recipients. | [optional] [default to null]
**Bcc** | [***AllOfSendMailAdvBcc**](AllOfSendMailAdvBcc.md) | Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header. | [optional] [default to null]
**Attachments** | [**[]MailAttachment**](MailAttachment.md) | Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name. | [optional] [default to null]
**Id** | **int64** | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] [default to null]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

