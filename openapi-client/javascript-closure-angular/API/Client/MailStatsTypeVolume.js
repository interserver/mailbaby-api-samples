goog.provide('API.Client.MailStatsType_volume');

/**
 * Top-500 breakdown of message counts grouped by source IP, destination address, and sender address within the selected `time` window.
 * @record
 */
API.Client.MailStatsTypeVolume = function() {}

/**
 * Message counts keyed by destination (envelope `to`) email address.
 * @type {!Object<!string, number>}
 * @export
 */
API.Client.MailStatsTypeVolume.prototype.to;

/**
 * Message counts keyed by sender (envelope `from`) email address.
 * @type {!Object<!string, number>}
 * @export
 */
API.Client.MailStatsTypeVolume.prototype.from;

/**
 * Message counts keyed by originating client IP address.
 * @type {!Object<!string, number>}
 * @export
 */
API.Client.MailStatsTypeVolume.prototype.ip;

