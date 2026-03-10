
# MailLogEntry

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.Int** | Internal auto-increment database row ID.  Not meaningful outside the API. |  |
| **id** | **kotlin.String** | The relay-assigned mail ID (18–19 hex characters).  This is the value returned as &#x60;text&#x60; by the sending endpoints and accepted as the &#x60;mailid&#x60; filter on &#x60;GET /mail/log&#x60;. |  |
| **from** | **kotlin.String** | SMTP envelope &#x60;MAIL FROM&#x60; address (may differ from the &#x60;From:&#x60; header). |  |
| **to** | **kotlin.String** | SMTP envelope &#x60;RCPT TO&#x60; address. |  |
| **created** | **kotlin.String** | Human-readable creation timestamp in &#x60;YYYY-MM-DD HH:MM:SS&#x60; format. |  |
| **time** | **kotlin.Int** | Unix timestamp of message acceptance.  Corresponds to the &#x60;startDate&#x60; and &#x60;endDate&#x60; filter parameters on &#x60;GET /mail/log&#x60;. |  |
| **user** | **kotlin.String** | The SMTP AUTH username used to submit the message (e.g. &#x60;mb5658&#x60;). Corresponds to the &#x60;username&#x60; field in &#x60;GET /mail&#x60; orders. |  |
| **transtype** | **kotlin.String** | SMTP transaction type negotiated with the relay (e.g. &#x60;ESMTPSA&#x60;). |  |
| **origin** | **kotlin.String** | IP address of the client that submitted the message to the relay. Corresponds to the &#x60;origin&#x60; filter parameter on &#x60;GET /mail/log&#x60;. |  |
| **&#x60;interface&#x60;** | **kotlin.String** | Relay interface name that accepted the message (e.g. &#x60;feeder&#x60;). |  |
| **subject** | **kotlin.String** | The &#x60;Subject&#x60; header value, if available. |  [optional] |
| **messageId** | **kotlin.String** | The &#x60;Message-ID&#x60; header value, if present.  Can be used with the &#x60;messageId&#x60; filter on &#x60;GET /mail/log&#x60; for subsequent lookups. |  [optional] |
| **sendingZone** | **kotlin.String** | The sending zone assigned by the relay for outbound delivery. |  [optional] |
| **bodySize** | **kotlin.Int** | Size of the message body in bytes. |  [optional] |
| **seq** | **kotlin.Int** | Sequence index of this recipient in a multi-recipient message. Starts at 1. |  [optional] |
| **delivered** | **kotlin.Int** | Delivery status flag.  &#x60;1&#x60; &#x3D; successfully delivered to destination MX. &#x60;0&#x60; &#x3D; queued, deferred, or failed.  &#x60;null&#x60; &#x3D; delivery not yet attempted. Corresponds to the &#x60;delivered&#x60; filter parameter on &#x60;GET /mail/log&#x60;. |  [optional] |
| **response** | **kotlin.String** | The SMTP response string received from the destination MX server upon delivery attempt (e.g. &#x60;\&quot;250 2.0.0 Ok queued as C91D83E128C\&quot;&#x60;). |  [optional] |
| **recipient** | **kotlin.String** | The specific recipient address this delivery record is for. |  [optional] |
| **domain** | **kotlin.String** | The destination domain.  Corresponds to the &#x60;mx&#x60; filter parameter (which matches &#x60;mxHostname&#x60;, not &#x60;domain&#x60;) on &#x60;GET /mail/log&#x60;. |  [optional] |
| **locked** | **kotlin.Int** | Whether the queue entry is currently locked for delivery processing. |  [optional] |
| **lockTime** | **kotlin.String** | Millisecond-precision timestamp of the last queue lock acquisition. |  [optional] |
| **assigned** | **kotlin.String** | The relay server node assigned to deliver this message. |  [optional] |
| **queued** | **kotlin.String** | ISO 8601 timestamp when the message was placed into the delivery queue. |  [optional] |
| **mxHostname** | **kotlin.String** | The MX hostname the relay connected to for delivery.  Corresponds to the &#x60;mx&#x60; filter parameter on &#x60;GET /mail/log&#x60;. |  [optional] |



