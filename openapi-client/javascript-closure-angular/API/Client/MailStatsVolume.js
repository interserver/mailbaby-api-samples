goog.provide('API.Client.MailStatsVolume');

/**
 * Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
 * @record
 */
API.Client.MailStatsVolume = function() {}

/**
 * Message counts keyed by destination (envelope `to`) email address.
 * @type {!Object<!string, number>}
 * @export
 */
API.Client.MailStatsVolume.prototype.to;

/**
 * Message counts keyed by sender (envelope `from`) email address.
 * @type {!Object<!string, number>}
 * @export
 */
API.Client.MailStatsVolume.prototype.from;

/**
 * Message counts keyed by originating client IP address.
 * @type {!Object<!string, number>}
 * @export
 */
API.Client.MailStatsVolume.prototype.ip;

