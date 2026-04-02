

# MailStatsVolume

Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**to** | **Map&lt;String, Int&gt;** | Message counts keyed by destination (envelope &#x60;to&#x60;) email address. |  [optional]
**from** | **Map&lt;String, Int&gt;** | Message counts keyed by sender (envelope &#x60;from&#x60;) email address. |  [optional]
**ip** | **Map&lt;String, Int&gt;** | Message counts keyed by originating client IP address. |  [optional]



