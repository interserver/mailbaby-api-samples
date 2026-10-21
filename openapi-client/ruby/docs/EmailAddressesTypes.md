# MailBabyRuby::EmailAddressesTypes

## Class instance methods

### `openapi_one_of`

Returns the list of classes defined in oneOf.

#### Example

```ruby
require 'mailbaby_client_ruby'

MailBabyRuby::EmailAddressesTypes.openapi_one_of
# =>
# [
#   :'Array<EmailAddressName>',
#   :'String'
# ]
```

### build

Find the appropriate object from the `openapi_one_of` list and casts the data into it.

#### Example

```ruby
require 'mailbaby_client_ruby'

MailBabyRuby::EmailAddressesTypes.build(data)
# => #<Array<EmailAddressName>:0x00007fdd4aab02a0>

MailBabyRuby::EmailAddressesTypes.build(data_that_doesnt_match)
# => nil
```

#### Parameters

| Name | Type | Description |
| ---- | ---- | ----------- |
| **data** | **Mixed** | data to be matched against the list of oneOf items |

#### Return type

- `Array<EmailAddressName>`
- `String`
- `nil` (if no type matches)

