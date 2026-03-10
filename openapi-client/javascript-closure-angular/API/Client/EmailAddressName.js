goog.provide('API.Client.EmailAddressName');

/**
 * An email contact with an optional display name.  Used in structured address fields (`from`, `to`, `cc`, `bcc`, `replyto`) in `SendMailAdv`.
 * @record
 */
API.Client.EmailAddressName = function() {}

/**
 * The email address.
 * @type {!string}
 * @export
 */
API.Client.EmailAddressName.prototype.email;

/**
 * Optional display name shown to recipients (e.g. in the `From:` header).
 * @type {!string}
 * @export
 */
API.Client.EmailAddressName.prototype.name;

