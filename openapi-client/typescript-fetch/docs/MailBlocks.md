
# MailBlocks

The complete set of blocked addresses and message patterns returned by `GET /mail/blocks`.  Three independent block sources are combined into one response. Use `POST /mail/blocks/delete` with a `from` address from any entry to delist it.

## Properties

Name | Type
------------ | -------------
`local` | [Array&lt;MailBlockClickHouse&gt;](MailBlockClickHouse.md)
`mbtrap` | [Array&lt;MailBlockClickHouse&gt;](MailBlockClickHouse.md)
`subject` | [Array&lt;MailBlockRspamd&gt;](MailBlockRspamd.md)

## Example

```typescript
import type { MailBlocks } from ''

// TODO: Update the object below with actual values
const example = {
  "local": null,
  "mbtrap": null,
  "subject": null,
} satisfies MailBlocks

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as MailBlocks
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


