goog.provide('API.Client.DenyRuleNew');

/**
 * The fields required to create a new email deny rule via `POST /mail/rules`. The `type` controls what `data` is matched against: - `email` — exact sender address match - `domain` — all senders from a domain - `destination` — exact recipient address match - `startswith` — sender local-part prefix match (alphanumeric + `+_.-` only)
 * @record
 */
API.Client.DenyRuleNew = function() {}

/**
 * The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
 * @type {!string}
 * @export
 */
API.Client.DenyRuleNew.prototype.type;

/**
 * The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
 * @type {!string}
 * @export
 */
API.Client.DenyRuleNew.prototype.data;

/**
 * Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
 * @type {!string}
 * @export
 */
API.Client.DenyRuleNew.prototype.user;

/** @enum {string} */
API.Client.DenyRuleNew.TypeEnum = { 
  domain: 'domain',
  email: 'email',
  startswith: 'startswith',
  destination: 'destination',
}
