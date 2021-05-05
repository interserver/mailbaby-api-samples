goog.provide('API.Client.body_1');

/**
 * Details for an Email
 * @record
 */
API.Client.Body1 = function() {}

/**
 * The Contact whom is the primary recipient of this email.
 * @type {!string}
 * @export
 */
API.Client.Body1.prototype.to;

/**
 * The contact whom is the this email is from.
 * @type {!string}
 * @export
 */
API.Client.Body1.prototype.from;

/**
 * The subject or title of the email
 * @type {!string}
 * @export
 */
API.Client.Body1.prototype.subject;

/**
 * The main email contents.
 * @type {!string}
 * @export
 */
API.Client.Body1.prototype.body;

