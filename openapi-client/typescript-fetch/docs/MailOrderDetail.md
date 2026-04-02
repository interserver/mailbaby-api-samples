
# MailOrderDetail

Extended mail order record including the current SMTP password.  Returned by `GET /mail/{id}`.  The `username` and `password` fields can be used to authenticate directly against `relay.mailbaby.net:25` via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.

## Properties

Name | Type
------------ | -------------
`id` | number
`status` | string
`username` | string
`password` | string
`comment` | string

## Example

```typescript
import type { MailOrderDetail } from ''

// TODO: Update the object below with actual values
const example = {
  "id": 21472,
  "status": active,
  "username": mb21472,
  "password": s3cr3tpassword,
  "comment": null,
} satisfies MailOrderDetail

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as MailOrderDetail
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


