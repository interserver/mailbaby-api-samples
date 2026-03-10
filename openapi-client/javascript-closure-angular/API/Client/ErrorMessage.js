goog.provide('API.Client.ErrorMessage');

/**
 * The response body returned when an error occurs.
 * @record
 */
API.Client.ErrorMessage = function() {}

/**
 * The HTTP-style status code associated with the error.
 * @type {!number}
 * @export
 */
API.Client.ErrorMessage.prototype.code;

/**
 * A human-readable description of the error.
 * @type {!string}
 * @export
 */
API.Client.ErrorMessage.prototype.message;

