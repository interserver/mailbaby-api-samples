goog.provide('API.Client.SendMailAdv_to_inner');

/**
 * An Email Contact
 * @record
 */
API.Client.SendMailAdvToInner = function() {}

/**
 * The email address
 * @type {!string}
 * @export
 */
API.Client.SendMailAdvToInner.prototype.email;

/**
 * (optional) Name to use for the destination contact.
 * @type {!string}
 * @export
 */
API.Client.SendMailAdvToInner.prototype.name;

