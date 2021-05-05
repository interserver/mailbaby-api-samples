goog.provide('API.Client.body');

/**
 * Details for an Email
 * @record
 */
API.Client.Body = function() {}

/**
 * The Contact whom is the primary recipient of this email.
 * @type {!string}
 * @export
 */
API.Client.Body.prototype.to;

/**
 * The contact whom is the this email is from.
 * @type {!string}
 * @export
 */
API.Client.Body.prototype.from;

/**
 * The subject or title of the email
 * @type {!string}
 * @export
 */
API.Client.Body.prototype.subject;

/**
 * The main email contents.
 * @type {!string}
 * @export
 */
API.Client.Body.prototype.body;

