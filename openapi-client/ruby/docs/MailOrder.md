# OpenapiClient::MailOrder

## Properties

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **id** | **Integer** |  |  |
| **status** | **String** |  |  |
| **username** | **String** |  |  |
| **password** | **String** |  | [optional] |
| **comment** | **String** |  | [optional] |

## Example

```ruby
require 'openapi_client'

instance = OpenapiClient::MailOrder.new(
  id: 1234,
  status: active,
  username: mb1234,
  password: guest123,
  comment: main mail account
)
```

