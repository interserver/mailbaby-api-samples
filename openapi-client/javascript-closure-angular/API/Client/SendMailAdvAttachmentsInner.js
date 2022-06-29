goog.provide('API.Client.SendMailAdv_attachments_inner');

/**
 * A File attachment for an email
 * @record
 */
API.Client.SendMailAdvAttachmentsInner = function() {}

/**
 * Contents of the attached file (must be base64 encoded)
 * @type {!Object}
 * @export
 */
API.Client.SendMailAdvAttachmentsInner.prototype.data;

/**
 * (optional) Filename to specify for the attachment.
 * @type {!string}
 * @export
 */
API.Client.SendMailAdvAttachmentsInner.prototype.filename;

