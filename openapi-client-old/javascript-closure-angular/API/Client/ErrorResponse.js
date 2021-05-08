goog.provide('API.Client.ErrorResponse');

/**
 * @record
 */
API.Client.ErrorResponse = function() {}

/**
 * @type {!string}
 * @export
 */
API.Client.ErrorResponse.prototype.code;

/**
 * @type {!string}
 * @export
 */
API.Client.ErrorResponse.prototype.message;

