package models

// MailOrder - A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The `id` is the numeric identifier used across most API calls.  The `username` is always `mb<id>` and is the SMTP AUTH username for `relay.mailbaby.net`.
type MailOrder struct {

	// The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
	Id int32 `json:"id"`

	// The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
	Status string `json:"status"`

	// The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
	Username string `json:"username" validate:"regexp=^mb\\d+$"`

	// Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
	Comment string `json:"comment,omitempty"`
}
