# MailLogEntry

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**_id** | **i32** | Internal auto-increment database row ID.  Not meaningful outside the API. | 
**id** | **String** | The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`. | 
**from** | **String** | SMTP envelope `MAIL FROM` address (may differ from the `From:` header). | 
**to** | **String** | SMTP envelope `RCPT TO` address. | 
**subject** | Option<**String**> | The `Subject` header value, if available. | [optional]
**message_id** | Option<**String**> | The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups. | [optional]
**created** | **String** | Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format. | 
**time** | **i32** | Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`. | 
**user** | **String** | The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders. | 
**transtype** | **String** | SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`). | 
**origin** | **String** | IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`. | 
**interface** | **String** | Relay interface name that accepted the message (e.g. `feeder`). | 
**sending_zone** | Option<**String**> | The sending zone assigned by the relay for outbound delivery. | [optional]
**body_size** | Option<**i32**> | Size of the message body in bytes. | [optional]
**seq** | Option<**i32**> | Sequence index of this recipient in a multi-recipient message. Starts at 1. | [optional]
**delivered** | Option<**i32**> | Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`. | [optional]
**response** | Option<**String**> | The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`). | [optional]
**recipient** | Option<**String**> | The specific recipient address this delivery record is for. | [optional]
**domain** | Option<**String**> | The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`. | [optional]
**locked** | Option<**i32**> | Whether the queue entry is currently locked for delivery processing. | [optional]
**lock_time** | Option<**String**> | Millisecond-precision timestamp of the last queue lock acquisition. | [optional]
**assigned** | Option<**String**> | The relay server node assigned to deliver this message. | [optional]
**queued** | Option<**String**> | ISO 8601 timestamp when the message was placed into the delivery queue. | [optional]
**mx_hostname** | Option<**String**> | The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`. | [optional]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


