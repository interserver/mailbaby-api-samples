goog.provide('API.Client.SendMail_from');

/**
 * An Email Contact
 * @record
 */
API.Client.SendMailFrom = function() {}

/**
 * The email address
 * @type {!string}
 * @export
 */
API.Client.SendMailFrom.prototype.email;

/**
 * Optional contact name
 * @type {!string}
 * @export
 */
API.Client.SendMailFrom.prototype.name;

