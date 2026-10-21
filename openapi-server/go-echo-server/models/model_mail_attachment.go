package models

// MailAttachment - A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.
type MailAttachment struct {

	// The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).
	Filename string `json:"filename"`

	// The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
	Data string `json:"data"`
}
