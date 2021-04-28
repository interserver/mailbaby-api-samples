goog.provide('API.Client.MailContact');

/**
 * An Email Contact
 * @record
 */
API.Client.MailContact = function() {}

/**
 * The email address
 * @type {!string}
 * @export
 */
API.Client.MailContact.prototype.email;

/**
 * Optional contact name
 * @type {!string}
 * @export
 */
API.Client.MailContact.prototype.name;

