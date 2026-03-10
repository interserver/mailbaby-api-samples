goog.provide('API.Client.EmailAddressParam');

/**
 * A single email address parameter used as the body of `POST /mail/blocks/delete`.
 * @record
 */
API.Client.EmailAddressParam = function() {}

/**
 * The email address to delist from all block lists.
 * @type {!string}
 * @export
 */
API.Client.EmailAddressParam.prototype.email;

