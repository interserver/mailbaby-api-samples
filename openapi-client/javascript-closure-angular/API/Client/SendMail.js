goog.provide('API.Client.SendMail');

/**
 * Details for an Email
 * @record
 */
API.Client.SendMail = function() {}

/**
 * The subject or title of the email
 * @type {!string}
 * @export
 */
API.Client.SendMail.prototype.subject;

/**
 * The main email contents.
 * @type {!string}
 * @export
 */
API.Client.SendMail.prototype.body;

/**
 * The contact whom is the this email is from.
 * @type {!Array<!API.Client.SendMail_from>}
 * @export
 */
API.Client.SendMail.prototype.from;

/**
 * The Contact whom is the primary recipient of this email.
 * @type {!Array<!API.Client.MailContact>}
 * @export
 */
API.Client.SendMail.prototype.to;

/**
 * The ID of the Mail order within our system to use as the Mail Account.
 * @type {!number}
 * @export
 */
API.Client.SendMail.prototype.id;

/**
 * Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.
 * @type {!Array<!API.Client.MailContact>}
 * @export
 */
API.Client.SendMail.prototype.replyto;

/**
 * Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
 * @type {!Array<!API.Client.MailContact>}
 * @export
 */
API.Client.SendMail.prototype.cc;

/**
 * Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
 * @type {!Array<!API.Client.MailContact>}
 * @export
 */
API.Client.SendMail.prototype.bcc;

/**
 * Optional file attachments to include in the email
 * @type {!Array<!API.Client.MailAttachment>}
 * @export
 */
API.Client.SendMail.prototype.attachments;

