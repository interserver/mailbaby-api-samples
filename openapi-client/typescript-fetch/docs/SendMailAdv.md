
# SendMailAdv

Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.

## Properties

Name | Type
------------ | -------------
`subject` | string
`body` | string
`from` | [EmailAddressTypes](EmailAddressTypes.md)
`to` | [EmailAddressesTypes](EmailAddressesTypes.md)
`replyto` | [EmailAddressesTypes](EmailAddressesTypes.md)
`cc` | [EmailAddressesTypes](EmailAddressesTypes.md)
`bcc` | [EmailAddressesTypes](EmailAddressesTypes.md)
`attachments` | [Array&lt;MailAttachment&gt;](MailAttachment.md)
`id` | number

## Example

```typescript
import type { SendMailAdv } from ''

// TODO: Update the object below with actual values
const example = {
  "subject": Your Package has been Delivered!,
  "body": The package you ordered on 2021-01-23 has been delivered.,
  "from": null,
  "to": null,
  "replyto": null,
  "cc": null,
  "bcc": null,
  "attachments": null,
  "id": 5000,
} satisfies SendMailAdv

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as SendMailAdv
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


