
# MailBlockClickHouse

A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.

## Properties

Name | Type
------------ | -------------
`date` | Date
`from` | string
`subject` | string
`to` | string
`messageId` | string

## Example

```typescript
import type { MailBlockClickHouse } from ''

// TODO: Update the object below with actual values
const example = {
  "date": Sun Aug 06 20:00:00 EDT 2023,
  "from": user@domain.com,
  "subject": Test Email,
  "to": ['client@site.com'],
  "messageId": pFaRqFUEWkucjhTuIzYuoAgWU@domain.com,
} satisfies MailBlockClickHouse

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as MailBlockClickHouse
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


