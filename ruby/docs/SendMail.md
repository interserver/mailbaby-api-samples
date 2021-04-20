# OpenapiClient::SendMail

## Properties

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **id** | **Integer** | The ID of the Mail order within our system to use as the Mail Account. |  |
| **from** | [**MailContact**](MailContact.md) |  |  |
| **to** | [**Array&lt;MailContact&gt;**](MailContact.md) | The Contact whom is the primary recipient of this email. |  |
| **subject** | **String** | The subject or title of the email |  |
| **body** | **String** | The main email contents. |  |
| **replyto** | [**Array&lt;MailContact&gt;**](MailContact.md) | Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. | [optional] |
| **cc** | [**Array&lt;MailContact&gt;**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] |
| **bcc** | [**Array&lt;MailContact&gt;**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] |
| **attachments** | [**Array&lt;MailAttachment&gt;**](MailAttachment.md) | Optional file attachments to include in the email | [optional] |

## Example

```ruby
require 'openapi_client'

instance = OpenapiClient::SendMail.new(
  id: null,
  from: null,
  to: null,
  subject: Your Package has been Delivered!,
  body: The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.
,
  replyto: null,
  cc: null,
  bcc: null,
  attachments: null
)
```

