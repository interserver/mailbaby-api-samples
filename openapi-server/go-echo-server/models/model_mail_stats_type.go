package models

// MailStatsType - Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
type MailStatsType struct {

	// The time window these `received`, `sent`, and `volume` statistics cover.
	Time string `json:"time,omitempty"`

	// Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
	Usage int32 `json:"usage,omitempty"`

	// The ISO 4217 currency code for this account (e.g. `USD`).
	Currency string `json:"currency,omitempty"`

	// Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
	Cost float64 `json:"cost,omitempty"`

	// Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
	Received int32 `json:"received,omitempty"`

	// Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
	Sent int32 `json:"sent,omitempty"`

	Volume MailStatsVolume `json:"volume,omitempty"`
}
