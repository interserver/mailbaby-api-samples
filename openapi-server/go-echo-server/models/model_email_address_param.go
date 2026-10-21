package models

// EmailAddressParam - A single email address parameter used as the body of `POST /mail/blocks/delete`.
type EmailAddressParam struct {

	// The email address to delist from all block lists.
	Email string `json:"email"`
}
