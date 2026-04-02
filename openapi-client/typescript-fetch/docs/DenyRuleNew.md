
# DenyRuleNew

The fields required to create a new email deny rule via `POST /mail/rules`. The `type` controls what `data` is matched against: - `email` — exact sender address match - `domain` — all senders from a domain - `destination` — exact recipient address match - `startswith` — sender local-part prefix match (alphanumeric + `+_.-` only)

## Properties

Name | Type
------------ | -------------
`type` | string
`data` | string
`user` | string

## Example

```typescript
import type { DenyRuleNew } from ''

// TODO: Update the object below with actual values
const example = {
  "type": email,
  "data": domeinwo@server.guesshost.net,
  "user": mb20682,
} satisfies DenyRuleNew

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as DenyRuleNew
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


