goog.provide('API.Client.MailAttachment');

/**
 * A File attachment for an email
 * @record
 */
API.Client.MailAttachment = function() {}

/**
 * Optional filename to specify for the attachment.
 * @type {!string}
 * @export
 */
API.Client.MailAttachment.prototype.filename;

/**
 * Contents of the attached file
 * @type {!Object}
 * @export
 */
API.Client.MailAttachment.prototype.data;

