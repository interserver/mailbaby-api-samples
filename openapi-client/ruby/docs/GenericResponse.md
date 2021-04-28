# OpenapiClient::GenericResponse

## Properties

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **status** | **String** |  | [optional] |
| **status_text** | **String** |  | [optional] |

## Example

```ruby
require 'openapi_client'

instance = OpenapiClient::GenericResponse.new(
  status: ok,
  status_text: The command completed successfully.
)
```

