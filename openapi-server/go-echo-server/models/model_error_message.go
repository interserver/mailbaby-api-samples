package models

// ErrorMessage - The response body returned when an error occurs.
type ErrorMessage struct {

	// The HTTP-style status code associated with the error.
	Code int32 `json:"code"`

	// A human-readable description of the error.
	Message string `json:"message"`
}
