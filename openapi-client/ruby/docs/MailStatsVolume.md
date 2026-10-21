# OpenapiClient::MailStatsVolume

## Properties

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **to** | **Hash&lt;String, Integer&gt;** | Message counts keyed by destination (envelope &#x60;to&#x60;) email address. | [optional] |
| **from** | **Hash&lt;String, Integer&gt;** | Message counts keyed by sender (envelope &#x60;from&#x60;) email address. | [optional] |
| **ip** | **Hash&lt;String, Integer&gt;** | Message counts keyed by originating client IP address. | [optional] |

## Example

```ruby
require 'openapi_client'

instance = OpenapiClient::MailStatsVolume.new(
  to: null,
  from: null,
  ip: null
)
```

