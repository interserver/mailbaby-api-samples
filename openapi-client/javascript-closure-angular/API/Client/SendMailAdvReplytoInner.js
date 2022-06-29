goog.provide('API.Client.SendMailAdv_replyto_inner');

/**
 * An Email Contact
 * @record
 */
API.Client.SendMailAdvReplytoInner = function() {}

/**
 * The email address
 * @type {!string}
 * @export
 */
API.Client.SendMailAdvReplytoInner.prototype.email;

/**
 * (optional) Name to use for the sending contact.
 * @type {!string}
 * @export
 */
API.Client.SendMailAdvReplytoInner.prototype.name;

