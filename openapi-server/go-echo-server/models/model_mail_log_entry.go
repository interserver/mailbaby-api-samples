package models

// MailLogEntry - A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The `id` field matches the `mailid` query parameter on `GET /mail/log` and   the `text` field of a successful send response. - The `from` address can be passed to `POST /mail/blocks/delete` to delist a   flagged sender. - The `user` field is the SMTP username (e.g. `mb5658`) corresponding to the   `username` field in `GET /mail` / `GET /mail/{id}`.
type MailLogEntry struct {

	// Internal auto-increment database row ID.  Not meaningful outside the API.
	Id int32 `json:"_id"`

	// The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.
	Id string `json:"id"`

	// SMTP envelope `MAIL FROM` address (may differ from the `From:` header).
	From string `json:"from"`

	// SMTP envelope `RCPT TO` address.
	To string `json:"to"`

	// Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.
	Created string `json:"created"`

	// Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.
	Time int32 `json:"time"`

	// The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.
	User string `json:"user"`

	// SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).
	Transtype string `json:"transtype"`

	// IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.
	Origin string `json:"origin"`

	// Relay interface name that accepted the message (e.g. `feeder`).
	Interface string `json:"interface"`

	// The `Subject` header value, if available.
	Subject *string `json:"subject,omitempty"`

	// The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.
	MessageId *string `json:"messageId,omitempty"`

	// The sending zone assigned by the relay for outbound delivery.
	SendingZone *string `json:"sendingZone,omitempty"`

	// Size of the message body in bytes.
	BodySize *int32 `json:"bodySize,omitempty"`

	// Sequence index of this recipient in a multi-recipient message. Starts at 1.
	Seq *int32 `json:"seq,omitempty"`

	// Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.
	Delivered *int32 `json:"delivered,omitempty"`

	// The SMTP response code from the destination MX server (e.g. `250` for success, `550` for permanent failure).
	Code *int32 `json:"code,omitempty"`

	// The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).
	Response *string `json:"response,omitempty"`

	// The specific recipient address this delivery record is for.
	Recipient *string `json:"recipient,omitempty"`

	// The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.
	Domain *string `json:"domain,omitempty"`

	// Whether the queue entry is currently locked for delivery processing.
	Locked *int32 `json:"locked,omitempty"`

	// Millisecond-precision timestamp of the last queue lock acquisition.
	LockTime *string `json:"lockTime,omitempty"`

	// The relay server node assigned to deliver this message.
	Assigned *string `json:"assigned,omitempty"`

	// ISO 8601 timestamp when the message was placed into the delivery queue.
	Queued *string `json:"queued,omitempty"`

	// The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.
	MxHostname *string `json:"mxHostname,omitempty"`
}
