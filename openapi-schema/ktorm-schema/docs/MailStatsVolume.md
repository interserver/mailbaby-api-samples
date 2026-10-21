
# Table `MailStatsVolume`
(mapped from: MailStatsVolume)

## Properties
Name | Mapping | SQL Type | Default | Type | Description | Notes
---- | ------- | -------- | ------- | ---- | ----------- | -----
**to** | to | blob |  | **kotlin.collections.Map&lt;kotlin.String, kotlin.Int&gt;** | Message counts keyed by destination (envelope &#x60;to&#x60;) email address. |  [optional]
**from** | from | blob |  | **kotlin.collections.Map&lt;kotlin.String, kotlin.Int&gt;** | Message counts keyed by sender (envelope &#x60;from&#x60;) email address. |  [optional]
**ip** | ip | blob |  | **kotlin.collections.Map&lt;kotlin.String, kotlin.Int&gt;** | Message counts keyed by originating client IP address. |  [optional]





