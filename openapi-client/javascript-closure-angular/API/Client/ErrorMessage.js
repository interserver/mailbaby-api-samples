goog.provide('API.Client.ErrorMessage');

/**
 * The resposne when an error occurs.
 * @record
 */
API.Client.ErrorMessage = function() {}

/**
 * The response code associated with the error.
 * @type {!number}
 * @export
 */
API.Client.ErrorMessage.prototype.code;

/**
 * The details or description of the error.
 * @type {!string}
 * @export
 */
API.Client.ErrorMessage.prototype.message;

