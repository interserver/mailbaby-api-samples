
# EmailAddressesTypes

A flexible email address list that accepts either a plain RFC 822 string or a structured array of contact objects.  When a string is provided it is parsed as a comma-separated list of RFC 822 addresses (supporting the `\"Name <email>\"` and bare `email` formats).  When an array is provided each entry must have at least an `email` field with an optional `name` field.

## Properties

Name | Type
------------ | -------------

## Example

```typescript
import type { EmailAddressesTypes } from ''

// TODO: Update the object below with actual values
const example = {
} satisfies EmailAddressesTypes

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as EmailAddressesTypes
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


