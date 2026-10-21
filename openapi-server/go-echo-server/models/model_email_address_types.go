package models

// EmailAddressTypes - A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (`\"Name <email>\"`), or a structured contact object.
type EmailAddressTypes struct {

	// The email address.
	Email string `json:"email"`

	// Optional display name shown to recipients (e.g. in the `From:` header).
	Name string `json:"name,omitempty"`
}
