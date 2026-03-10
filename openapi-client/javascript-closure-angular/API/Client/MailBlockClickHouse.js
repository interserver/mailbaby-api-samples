goog.provide('API.Client.MailBlockClickHouse');

/**
 * A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
 * @record
 */
API.Client.MailBlockClickHouse = function() {}

/**
 * The date the block event was recorded.
 * @type {!API.Client.date}
 * @export
 */
API.Client.MailBlockClickHouse.prototype.date;

/**
 * The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
 * @type {!string}
 * @export
 */
API.Client.MailBlockClickHouse.prototype.from;

/**
 * The `Subject` header of the blocked message.
 * @type {!string}
 * @export
 */
API.Client.MailBlockClickHouse.prototype.subject;

/**
 * The serialized list of recipients of the blocked message.
 * @type {!string}
 * @export
 */
API.Client.MailBlockClickHouse.prototype.to;

/**
 * The `Message-ID` header of the blocked message, or `null` if not present.
 * @type {!string}
 * @export
 */
API.Client.MailBlockClickHouse.prototype.messageId;

