goog.provide('API.Client.MailLogEntry');

/**
 * A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The `id` field matches the `mailid` query parameter on `GET /mail/log` and   the `text` field of a successful send response. - The `from` address can be passed to `POST /mail/blocks/delete` to delist a   flagged sender. - The `user` field is the SMTP username (e.g. `mb5658`) corresponding to the   `username` field in `GET /mail` / `GET /mail/{id}`.
 * @record
 */
API.Client.MailLogEntry = function() {}

/**
 * Internal auto-increment database row ID.  Not meaningful outside the API.
 * @type {!number}
 * @export
 */
API.Client.MailLogEntry.prototype.id;

/**
 * The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.id;

/**
 * SMTP envelope `MAIL FROM` address (may differ from the `From:` header).
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.from;

/**
 * SMTP envelope `RCPT TO` address.
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.to;

/**
 * Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.created;

/**
 * Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.
 * @type {!number}
 * @export
 */
API.Client.MailLogEntry.prototype.time;

/**
 * The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.user;

/**
 * SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.transtype;

/**
 * IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.origin;

/**
 * Relay interface name that accepted the message (e.g. `feeder`).
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype._interface;

/**
 * The `Subject` header value, if available.
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.subject;

/**
 * The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.messageId;

/**
 * The sending zone assigned by the relay for outbound delivery.
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.sendingZone;

/**
 * Size of the message body in bytes.
 * @type {!number}
 * @export
 */
API.Client.MailLogEntry.prototype.bodySize;

/**
 * Sequence index of this recipient in a multi-recipient message. Starts at 1.
 * @type {!number}
 * @export
 */
API.Client.MailLogEntry.prototype.seq;

/**
 * Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.
 * @type {!number}
 * @export
 */
API.Client.MailLogEntry.prototype.delivered;

/**
 * The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.response;

/**
 * The specific recipient address this delivery record is for.
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.recipient;

/**
 * The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.domain;

/**
 * Whether the queue entry is currently locked for delivery processing.
 * @type {!number}
 * @export
 */
API.Client.MailLogEntry.prototype.locked;

/**
 * Millisecond-precision timestamp of the last queue lock acquisition.
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.lockTime;

/**
 * The relay server node assigned to deliver this message.
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.assigned;

/**
 * ISO 8601 timestamp when the message was placed into the delivery queue.
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.queued;

/**
 * The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.
 * @type {!string}
 * @export
 */
API.Client.MailLogEntry.prototype.mxHostname;

