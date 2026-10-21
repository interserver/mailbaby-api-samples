package models

// MailStatsVolume - Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
type MailStatsVolume struct {

	// Message counts keyed by destination (envelope `to`) email address.
	To map[string]int32 `json:"to,omitempty"`

	// Message counts keyed by sender (envelope `from`) email address.
	From map[string]int32 `json:"from,omitempty"`

	// Message counts keyed by originating client IP address.
	Ip map[string]int32 `json:"ip,omitempty"`
}
