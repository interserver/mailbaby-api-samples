goog.provide('API.Client.SendMailAdv');

/**
 * Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.
 * @record
 */
API.Client.SendMailAdv = function() {}

/**
 * The subject line of the email.
 * @type {!string}
 * @export
 */
API.Client.SendMailAdv.prototype.subject;

/**
 * The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
 * @type {!string}
 * @export
 */
API.Client.SendMailAdv.prototype.body;

/**
 * @type {!API.Client.EmailAddressTypes}
 * @export
 */
API.Client.SendMailAdv.prototype.from;

/**
 * @type {!API.Client.EmailAddressesTypes}
 * @export
 */
API.Client.SendMailAdv.prototype.to;

/**
 * @type {!API.Client.EmailAddressesTypes}
 * @export
 */
API.Client.SendMailAdv.prototype.replyto;

/**
 * @type {!API.Client.EmailAddressesTypes}
 * @export
 */
API.Client.SendMailAdv.prototype.cc;

/**
 * @type {!API.Client.EmailAddressesTypes}
 * @export
 */
API.Client.SendMailAdv.prototype.bcc;

/**
 * Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
 * @type {!Array<!API.Client.MailAttachment>}
 * @export
 */
API.Client.SendMailAdv.prototype.attachments;

/**
 * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
 * @type {!number}
 * @export
 */
API.Client.SendMailAdv.prototype.id;

