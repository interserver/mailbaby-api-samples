goog.provide('API.Client.MailOrder');

/**
 * A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The `id` is the numeric identifier used across most API calls.  The `username` is always `mb<id>` and is the SMTP AUTH username for `relay.mailbaby.net`.
 * @record
 */
API.Client.MailOrder = function() {}

/**
 * The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
 * @type {!number}
 * @export
 */
API.Client.MailOrder.prototype.id;

/**
 * The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
 * @type {!string}
 * @export
 */
API.Client.MailOrder.prototype.status;

/**
 * The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
 * @type {!string}
 * @export
 */
API.Client.MailOrder.prototype.username;

/**
 * Optional human-readable note associated with the order.
 * @type {!string}
 * @export
 */
API.Client.MailOrder.prototype.comment;

