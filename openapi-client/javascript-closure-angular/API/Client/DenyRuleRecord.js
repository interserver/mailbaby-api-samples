goog.provide('API.Client.DenyRuleRecord');

/**
 * A complete deny rule record as returned by `GET /mail/rules`.  Combines the rule definition fields (`DenyRuleNew`) with server-assigned metadata (`id` and `created`).  The `id` value is required by `DELETE /mail/rules/{ruleId}`.
 * @record
 */
API.Client.DenyRuleRecord = function() {}

/**
 * The type of deny rule.
 * @type {!string}
 * @export
 */
API.Client.DenyRuleRecord.prototype.type;

/**
 * The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
 * @type {!string}
 * @export
 */
API.Client.DenyRuleRecord.prototype.data;

/**
 * The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule.
 * @type {!string}
 * @export
 */
API.Client.DenyRuleRecord.prototype.id;

/**
 * The timestamp when the rule was created.
 * @type {!Date}
 * @export
 */
API.Client.DenyRuleRecord.prototype.created;

/**
 * Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
 * @type {!string}
 * @export
 */
API.Client.DenyRuleRecord.prototype.user;

/** @enum {string} */
API.Client.DenyRuleRecord.TypeEnum = { 
  domain: 'domain',
  email: 'email',
  startswith: 'startswith',
  destination: 'destination',
}
