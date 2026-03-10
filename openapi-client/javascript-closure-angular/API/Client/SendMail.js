goog.provide('API.Client.SendMail');

/**
 * Request body for `POST /mail/send`.  Sends a simple single-recipient message. HTML detection is automatic — if `body` contains HTML tags the message is sent as `text/html`; otherwise as `text/plain`.  The `from` address is automatically set as both the `From` and `Reply-To` headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use `POST /mail/advsend` instead.
 * @record
 */
API.Client.SendMail = function() {}

/**
 * @type {!API.Client.SendMailTo}
 * @export
 */
API.Client.SendMail.prototype.to;

/**
 * The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.
 * @type {!string}
 * @export
 */
API.Client.SendMail.prototype.from;

/**
 * The subject line of the email.
 * @type {!string}
 * @export
 */
API.Client.SendMail.prototype.subject;

/**
 * The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
 * @type {!string}
 * @export
 */
API.Client.SendMail.prototype.body;

/**
 * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
 * @type {!number}
 * @export
 */
API.Client.SendMail.prototype.id;

