goog.provide('API.Client.SendMailAdv_bcc_inner');

/**
 * An Email Contact
 * @record
 */
API.Client.SendMailAdvBccInner = function() {}

/**
 * The email address
 * @type {!string}
 * @export
 */
API.Client.SendMailAdvBccInner.prototype.email;

/**
 * (optional) Name to use for the BCC contact.
 * @type {!string}
 * @export
 */
API.Client.SendMailAdvBccInner.prototype.name;

