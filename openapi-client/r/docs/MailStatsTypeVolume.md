# openapi::MailStatsTypeVolume

Top-500 breakdown of message counts grouped by source IP, destination address, and sender address within the selected `time` window.

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**to** | **map(integer)** | Message counts keyed by destination (envelope &#x60;to&#x60;) email address. | [optional] 
**from** | **map(integer)** | Message counts keyed by sender (envelope &#x60;from&#x60;) email address. | [optional] 
**ip** | **map(integer)** | Message counts keyed by originating client IP address. | [optional] 


