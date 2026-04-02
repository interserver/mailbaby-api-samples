
# MailStatsType

Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.

## Properties

Name | Type
------------ | -------------
`time` | string
`usage` | number
`currency` | string
`cost` | number
`received` | number
`sent` | number
`volume` | [MailStatsVolume](MailStatsVolume.md)

## Example

```typescript
import type { MailStatsType } from ''

// TODO: Update the object below with actual values
const example = {
  "time": null,
  "usage": null,
  "currency": null,
  "cost": null,
  "received": null,
  "sent": null,
  "volume": null,
} satisfies MailStatsType

console.log(example)

// Convert the instance to a JSON string
const exampleJSON: string = JSON.stringify(example)
console.log(exampleJSON)

// Parse the JSON string back to an object
const exampleParsed = JSON.parse(exampleJSON) as MailStatsType
console.log(exampleParsed)
```

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


