goog.provide('API.Client.MailLog');

/**
 * Paginated mail log response returned by `GET /mail/log`.  Contains the full matched count (`total`) plus a page of `MailLogEntry` records.  Use `skip` and `limit` to page through large result sets.
 * @record
 */
API.Client.MailLog = function() {}

/**
 * Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.
 * @type {!number}
 * @export
 */
API.Client.MailLog.prototype.total;

/**
 * The `skip` value used for this page (echoed from the request).
 * @type {!number}
 * @export
 */
API.Client.MailLog.prototype.skip;

/**
 * The `limit` value used for this page (echoed from the request).
 * @type {!number}
 * @export
 */
API.Client.MailLog.prototype.limit;

/**
 * @type {!Array<!API.Client.MailLogEntry>}
 * @export
 */
API.Client.MailLog.prototype.emails;

