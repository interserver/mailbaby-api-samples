# MailBabyRuby::SendMail

## Properties

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **to** | [**SendMailTo**](SendMailTo.md) |  |  |
| **from** | **String** | The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order. |  |
| **subject** | **String** | The subject line of the email. |  |
| **body** | **String** | The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. |  |
| **id** | **Integer** | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] |

## Example

```ruby
require 'mailbaby_client_ruby'

instance = MailBabyRuby::SendMail.new(
  to: null,
  from: janedoe@company.com,
  subject: Attention Client,
  body: This is an email to inform you that something noteworthy happened.,
  id: 2604
)
```

