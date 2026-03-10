goog.provide('API.Client.MailBlockRspamd');

/**
 * A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
 * @record
 */
API.Client.MailBlockRspamd = function() {}

/**
 * The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender.
 * @type {!string}
 * @export
 */
API.Client.MailBlockRspamd.prototype.from;

/**
 * The suspicious subject pattern that triggered the block.
 * @type {!string}
 * @export
 */
API.Client.MailBlockRspamd.prototype.subject;

