
# SendMail

Request body for `POST /mail/send`.  Sends a simple single-recipient message. HTML detection is automatic — if `body` contains HTML tags the message is sent as `text/html`; otherwise as `text/plain`.  The `from` address is automatically set as both the `From` and `Reply-To` headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use `POST /mail/advsend` instead.

## Properties

Name | Type
------------ | -------------
`to` | [SendMailTo](SendMailTo.md)
`from` | string
`subject` | string
`body` | string
`id` | number

## Example

```typescript
import type { SendMail } from ''

// TODO: Update the object below with actual values
const example = {
  "to": null,
  "from": janedoe@company.com,
  "subject": Attention Client,
  "body": This is an email to inform you that something noteworthy happened.,
  "id": 2604,
} satisfies SendMail

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as SendMail
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


