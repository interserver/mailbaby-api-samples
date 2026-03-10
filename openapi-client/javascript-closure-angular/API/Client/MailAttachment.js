goog.provide('API.Client.MailAttachment');

/**
 * A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.
 * @record
 */
API.Client.MailAttachment = function() {}

/**
 * The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).
 * @type {!string}
 * @export
 */
API.Client.MailAttachment.prototype.filename;

/**
 * The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
 * @type {!API.Client.ByteArray}
 * @export
 */
API.Client.MailAttachment.prototype.data;

