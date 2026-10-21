package models

// MailLog - Paginated mail log response returned by `GET /mail/log`.  Contains the full matched count (`total`) plus a page of `MailLogEntry` records.  Use `skip` and `limit` to page through large result sets.
type MailLog struct {

	// Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.
	Total int32 `json:"total"`

	// The `skip` value used for this page (echoed from the request).
	Skip int32 `json:"skip"`

	// The `limit` value used for this page (echoed from the request).
	Limit int32 `json:"limit"`

	Emails []MailLogEntry `json:"emails"`
}
