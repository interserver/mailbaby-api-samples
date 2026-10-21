package models

// MailOrderDetail - Extended mail order record including the current SMTP password.  Returned by `GET /mail/{id}`.  The `username` and `password` fields can be used to authenticate directly against `relay.mailbaby.net:25` via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
type MailOrderDetail struct {

	// The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
	Id int32 `json:"id"`

	// The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
	Status string `json:"status"`

	// The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
	Username string `json:"username" validate:"regexp=^mb\\d+$"`

	// The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.
	Password string `json:"password"`

	// Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
	Comment string `json:"comment,omitempty"`
}
