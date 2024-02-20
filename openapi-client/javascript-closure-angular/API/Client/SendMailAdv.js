goog.provide('API.Client.SendMailAdv');

/**
 * Details for an Email
 * @record
 */
API.Client.SendMailAdv = function() {}

/**
 * The subject or title of the email
 * @type {!string}
 * @export
 */
API.Client.SendMailAdv.prototype.subject;

/**
 * The main email contents.
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
 * (optional) File attachments to include in the email.  The file contents must be base64 encoded!
 * @type {!Array<!API.Client.MailAttachment>}
 * @export
 */
API.Client.SendMailAdv.prototype.attachments;

/**
 * (optional)  ID of the Mail order within our system to use as the Mail Account.
 * @type {!number}
 * @export
 */
API.Client.SendMailAdv.prototype.id;

