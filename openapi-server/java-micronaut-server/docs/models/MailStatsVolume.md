

# MailStatsVolume

Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.

The class is defined in **[MailStatsVolume.java](../../src/main/java/org/openapitools/model/MailStatsVolume.java)**

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**to** | `Map&lt;String, Integer&gt;` | Message counts keyed by destination (envelope &#x60;to&#x60;) email address. |  [optional property]
**from** | `Map&lt;String, Integer&gt;` | Message counts keyed by sender (envelope &#x60;from&#x60;) email address. |  [optional property]
**ip** | `Map&lt;String, Integer&gt;` | Message counts keyed by originating client IP address. |  [optional property]





