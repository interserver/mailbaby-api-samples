package models

import (
	"time"
)

// DenyRuleRecord - A complete deny rule record as returned by `GET /mail/rules`.  Combines the rule definition fields (`DenyRuleNew`) with server-assigned metadata (`id` and `created`).  The `id` value is required by `DELETE /mail/rules/{ruleId}`.
type DenyRuleRecord struct {

	// The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
	Type string `json:"type"`

	// The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
	Data string `json:"data"`

	// The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule.
	Id string `json:"id"`

	// The timestamp when the rule was created.
	Created time.Time `json:"created"`

	// Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
	User string `json:"user,omitempty"`
}
