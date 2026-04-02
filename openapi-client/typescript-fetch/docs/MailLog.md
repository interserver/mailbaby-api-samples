
# MailLog

Paginated mail log response returned by `GET /mail/log`.  Contains the full matched count (`total`) plus a page of `MailLogEntry` records.  Use `skip` and `limit` to page through large result sets.

## Properties

Name | Type
------------ | -------------
`total` | number
`skip` | number
`limit` | number
`emails` | [Array&lt;MailLogEntry&gt;](MailLogEntry.md)

## Example

```typescript
import type { MailLog } from ''

// TODO: Update the object below with actual values
const example = {
  "total": 10234,
  "skip": 0,
  "limit": 100,
  "emails": null,
} satisfies MailLog

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as MailLog
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


