# OpenapiClient::ErrorMessage

## Properties

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **code** | **Integer** | The HTTP-style status code associated with the error. |  |
| **message** | **String** | A human-readable description of the error. |  |

## Example

```ruby
require 'openapi_client'

instance = OpenapiClient::ErrorMessage.new(
  code: 400,
  message: The specified ID was invalid.
)
```

