goog.provide('API.Client.SendMailRaw');

/**
 * Raw Email Object
 * @record
 */
API.Client.SendMailRaw = function() {}

/**
 * The entire email contents
 * @type {!string}
 * @export
 */
API.Client.SendMailRaw.prototype.rawEmail;

/**
 * Optional order id
 * @type {!number}
 * @export
 */
API.Client.SendMailRaw.prototype.id;

