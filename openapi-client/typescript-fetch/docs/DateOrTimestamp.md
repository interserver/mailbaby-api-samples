
# DateOrTimestamp

A date/time value accepted as either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` (e.g. `2024-01-15`, `last monday`).

## Properties

Name | Type
------------ | -------------

## Example

```typescript
import type { DateOrTimestamp } from ''

// TODO: Update the object below with actual values
const example = {
} satisfies DateOrTimestamp

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as DateOrTimestamp
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


