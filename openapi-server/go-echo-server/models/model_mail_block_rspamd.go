package models

// MailBlockRspamd - A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
type MailBlockRspamd struct {

	// The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender.
	From string `json:"from"`

	// The suspicious subject pattern that triggered the block.
	Subject string `json:"subject"`
}
