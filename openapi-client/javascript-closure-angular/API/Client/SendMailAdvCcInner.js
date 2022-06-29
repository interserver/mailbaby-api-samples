goog.provide('API.Client.SendMailAdv_cc_inner');

/**
 * An Email Contact
 * @record
 */
API.Client.SendMailAdvCcInner = function() {}

/**
 * The email address
 * @type {!string}
 * @export
 */
API.Client.SendMailAdvCcInner.prototype.email;

/**
 * (optional) Name to use for the CC contact.
 * @type {!string}
 * @export
 */
API.Client.SendMailAdvCcInner.prototype.name;

