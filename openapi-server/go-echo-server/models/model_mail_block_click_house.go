package models

// MailBlockClickHouse - A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
type MailBlockClickHouse struct {

	// The date the block event was recorded.
	Date string `json:"date"`

	// The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
	From string `json:"from"`

	// The `Subject` header of the blocked message.
	Subject string `json:"subject"`

	// The serialized list of recipients of the blocked message.
	To string `json:"to"`

	// The `Message-ID` header of the blocked message, or `null` if not present.
	MessageId *string `json:"messageId,omitempty"`
}
