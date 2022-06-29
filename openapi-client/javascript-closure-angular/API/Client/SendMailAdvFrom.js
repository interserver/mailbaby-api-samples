goog.provide('API.Client.SendMailAdv_from');

/**
 * The information to use for the From address in the email. from.
 * @record
 */
API.Client.SendMailAdvFrom = function() {}

/**
 * The email address
 * @type {!string}
 * @export
 */
API.Client.SendMailAdvFrom.prototype.email;

/**
 * (optional) Name to use for the sending contact.
 * @type {!string}
 * @export
 */
API.Client.SendMailAdvFrom.prototype.name;

