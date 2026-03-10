goog.provide('API.Client.EmailAddressTypes');

/**
 * A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (`\"Name <email>\"`), or a structured contact object.
 * @record
 */
API.Client.EmailAddressTypes = function() {}

/**
 * The email address.
 * @type {!string}
 * @export
 */
API.Client.EmailAddressTypes.prototype.email;

/**
 * Optional display name shown to recipients (e.g. in the `From:` header).
 * @type {!string}
 * @export
 */
API.Client.EmailAddressTypes.prototype.name;

