goog.provide('API.Client.MailLogEntry');

/**
 * An email record
 * @record
 */
API.Client.MailLogEntry = function() {}

/**
 * internal db id
 * @type {!number}
 * @export
 */
API.Client.MailLogEntry.prototype.id;

/**
 * mail id
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.id;

/**
 * from address
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.from;

/**
 * to address
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.to;

/**
 * email subject
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.subject;

/**
 * message id
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.messageId;

/**
 * creation date
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.created;

/**
 * creation timestamp
 * @type {!number}
 * @export
 */
API.Client.MailLogEntry.prototype.time;

/**
 * user account
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.user;

/**
 * transaction type
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.transtype;

/**
 * transaction host
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.transhost;

/**
 * origin host
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.originhost;

/**
 * origin ip
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.origin;

/**
 * interface name
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype._interface;

/**
 * date processed
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.date;

/**
 * sending zone
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.sendingZone;

/**
 * email body size in bytes
 * @type {!number}
 * @export
 */
API.Client.MailLogEntry.prototype.bodySize;

/**
 * md5 sum of the email
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.sourceMd5;

/**
 * delivery sequency
 * @type {!number}
 * @export
 */
API.Client.MailLogEntry.prototype.seq;

/**
 * to address domain
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.domain;

/**
 * email receiver address
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.recipient;

/**
 * locked status
 * @type {!number}
 * @export
 */
API.Client.MailLogEntry.prototype.locked;

/**
 * lock timestamp
 * @type {!number}
 * @export
 */
API.Client.MailLogEntry.prototype.lockTime;

/**
 * assigned server
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.assigned;

/**
 * queued timestamp
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.queued;

/**
 * lock id
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.lock;

/**
 * logger
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.logger;

/**
 * mx port number
 * @type {!number}
 * @export
 */
API.Client.MailLogEntry.prototype.mxPort;

/**
 * connection key
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.connectionKey;

/**
 * mx hostname
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.mxHostname;

/**
 * body hash
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.sentBodyHash;

/**
 * sent body size in bytes
 * @type {!number}
 * @export
 */
API.Client.MailLogEntry.prototype.sentBodySize;

/**
 * md5 checksum matching result
 * @type {!number}
 * @export
 */
API.Client.MailLogEntry.prototype.md5Match;

