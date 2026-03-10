goog.provide('API.Client.MailOrderDetail');

/**
 * Extended mail order record including the current SMTP password.  Returned by `GET /mail/{id}`.  The `username` and `password` fields can be used to authenticate directly against `relay.mailbaby.net:25` via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
 * @record
 */
API.Client.MailOrderDetail = function() {}

/**
 * The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
 * @type {!number}
 * @export
 */
API.Client.MailOrderDetail.prototype.id;

/**
 * The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
 * @type {!string}
 * @export
 */
API.Client.MailOrderDetail.prototype.status;

/**
 * The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
 * @type {!string}
 * @export
 */
API.Client.MailOrderDetail.prototype.username;

/**
 * The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.
 * @type {!string}
 * @export
 */
API.Client.MailOrderDetail.prototype.password;

/**
 * Optional human-readable note associated with the order.
 * @type {!string}
 * @export
 */
API.Client.MailOrderDetail.prototype.comment;

