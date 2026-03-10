goog.provide('API.Client.MailStatsType');

/**
 * Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
 * @record
 */
API.Client.MailStatsType = function() {}

/**
 * The time window these `received`, `sent`, and `volume` statistics cover.
 * @type {!string}
 * @export
 */
API.Client.MailStatsType.prototype.time;

/**
 * Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
 * @type {!number}
 * @export
 */
API.Client.MailStatsType.prototype.usage;

/**
 * The ISO 4217 currency code for this account (e.g. `USD`).
 * @type {!string}
 * @export
 */
API.Client.MailStatsType.prototype.currency;

/**
 * Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
 * @type {!number}
 * @export
 */
API.Client.MailStatsType.prototype.cost;

/**
 * Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
 * @type {!number}
 * @export
 */
API.Client.MailStatsType.prototype.received;

/**
 * Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
 * @type {!number}
 * @export
 */
API.Client.MailStatsType.prototype.sent;

/**
 * @type {!API.Client.MailStatsType_volume}
 * @export
 */
API.Client.MailStatsType.prototype.volume;

/** @enum {string} */
API.Client.MailStatsType.TimeEnum = { 
  all: 'all',
  billing: 'billing',
  month: 'month',
  7d: '7d',
  24h: '24h',
  day: 'day',
  1h: '1h',
}
