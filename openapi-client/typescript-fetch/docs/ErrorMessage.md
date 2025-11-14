
# ErrorMessage

The resposne when an error occurs.

## Properties

Name | Type
------------ | -------------
`code` | number
`message` | string

## Example

```typescript
import type { ErrorMessage } from ''

// TODO: Update the object below with actual values
const example = {
  "code": 400,
  "message": There was an error.,
} satisfies ErrorMessage

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as ErrorMessage
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


