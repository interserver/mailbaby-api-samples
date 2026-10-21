# MailBabyRuby::MailBlockClickHouse

## Properties

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **date** | **Date** | The date the block event was recorded. |  |
| **from** | **String** | The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it. |  |
| **subject** | **String** | The &#x60;Subject&#x60; header of the blocked message. |  |
| **to** | **String** | The serialized list of recipients of the blocked message. |  |
| **message_id** | **String** | The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present. | [optional] |

## Example

```ruby
require 'mailbaby_client_ruby'

instance = MailBabyRuby::MailBlockClickHouse.new(
  date: Sun Aug 06 20:00:00 EDT 2023,
  from: user@domain.com,
  subject: Test Email,
  to: [&#39;client@site.com&#39;],
  message_id: pFaRqFUEWkucjhTuIzYuoAgWU@domain.com
)
```

