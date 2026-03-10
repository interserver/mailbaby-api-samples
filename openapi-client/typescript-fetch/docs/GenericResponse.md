
# GenericResponse

Standard success response returned by write operations (send, add rule, delete, etc.).  The `status` field is always `\"ok\"` on success.  The `text` field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record\'s ID; for delete calls it contains a confirmation string.

## Properties

Name | Type
------------ | -------------
`status` | string
`text` | string

## Example

```typescript
import type { GenericResponse } from ''

// TODO: Update the object below with actual values
const example = {
  "status": ok,
  "text": 185caa69ff7000f47c,
} satisfies GenericResponse

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as GenericResponse
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


