# MailBabyRuby::MailAttachment

## Properties

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **filename** | **String** | The filename shown to recipients (e.g. &#x60;report.pdf&#x60;, &#x60;invoice.xlsx&#x60;). |  |
| **data** | **String** | The file contents as a base64-encoded string.  Decode this to retrieve the original binary file. |  |

## Example

```ruby
require 'mailbaby_client_ruby'

instance = MailBabyRuby::MailAttachment.new(
  filename: message.txt,
  data: [B@3a2e9f5b
)
```

