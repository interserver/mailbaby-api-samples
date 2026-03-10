
# MailStatsVolume

Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.

## Properties

Name | Type
------------ | -------------
`to` | { [key: string]: number; }
`from` | { [key: string]: number; }
`ip` | { [key: string]: number; }

## Example

```typescript
import type { MailStatsVolume } from ''

// TODO: Update the object below with actual values
const example = {
  "to": null,
  "from": null,
  "ip": null,
} satisfies MailStatsVolume

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as MailStatsVolume
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


