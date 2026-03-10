
# MailBlockRspamd

A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The `from` address can be passed to `POST /mail/blocks/delete` to delist it.

## Properties

Name | Type
------------ | -------------
`from` | string
`subject` | string

## Example

```typescript
import type { MailBlockRspamd } from ''

// TODO: Update the object below with actual values
const example = {
  "from": user@domain.com,
  "subject": Test email,
} satisfies MailBlockRspamd

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as MailBlockRspamd
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


