goog.provide('API.Client.GenericResponse');

/**
 * Standard success response returned by write operations (send, add rule, delete, etc.).  The `status` field is always `\"ok\"` on success.  The `text` field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record's ID; for delete calls it contains a confirmation string.
 * @record
 */
API.Client.GenericResponse = function() {}

/**
 * Always `\"ok\"` on success.
 * @type {!string}
 * @export
 */
API.Client.GenericResponse.prototype.status;

/**
 * Operation-specific result string.  For send operations this is the relay transaction ID (e.g. `185caa69ff7000f47c`) which can be used as the `mailid` parameter in `GET /mail/log`.  For create operations this is the new record's numeric ID.  For delete operations this is a human-readable confirmation.
 * @type {!string}
 * @export
 */
API.Client.GenericResponse.prototype.text;

