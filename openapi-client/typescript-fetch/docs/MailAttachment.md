
# MailAttachment

A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.

## Properties

Name | Type
------------ | -------------
`filename` | string
`data` | string

## Example

```typescript
import type { MailAttachment } from ''

// TODO: Update the object below with actual values
const example = {
  "filename": message.txt,
  "data": [B@59bbb974,
} satisfies MailAttachment

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as MailAttachment
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


