package models

// EmailAddressName - An email contact with an optional display name.  Used in structured address fields (`from`, `to`, `cc`, `bcc`, `replyto`) in `SendMailAdv`.
type EmailAddressName struct {

	// The email address.
	Email string `json:"email"`

	// Optional display name shown to recipients (e.g. in the `From:` header).
	Name string `json:"name,omitempty"`
}
