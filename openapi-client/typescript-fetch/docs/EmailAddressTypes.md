
# EmailAddressTypes



## Properties

Name | Type
------------ | -------------
`email` | string
`name` | string

## Example

```typescript
import type { EmailAddressTypes } from ''

// TODO: Update the object below with actual values
const example = {
  "email": user@domain.com,
  "name": John Smith,
} satisfies EmailAddressTypes

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as EmailAddressTypes
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


