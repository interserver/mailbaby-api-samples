# OpenapiClient::MailAttachment

## Properties

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **filename** | **String** | Optional filename to specify for the attachment. | [optional] |
| **data** | **File** | Contents of the attached file |  |

## Example

```ruby
require 'openapi_client'

instance = OpenapiClient::MailAttachment.new(
  filename: company_logo.png,
  data: null
)
```

