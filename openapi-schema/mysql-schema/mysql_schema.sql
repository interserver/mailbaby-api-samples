/* SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO"; */
/* SET AUTOCOMMIT = 0; */
/* START TRANSACTION; */
/* SET time_zone = "+00:00"; */

-- --------------------------------------------------------

--
-- Table structure for table `DenyRuleNew` generated from model 'DenyRuleNew'
-- The fields required to create a new email deny rule via &#x60;POST /mail/rules&#x60;. The &#x60;type&#x60; controls what &#x60;data&#x60; is matched against: - &#x60;email&#x60; — exact sender address match - &#x60;domain&#x60; — all senders from a domain - &#x60;destination&#x60; — exact recipient address match - &#x60;startswith&#x60; — sender local-part prefix match (alphanumeric + &#x60;+_.-&#x60; only)
--

CREATE TABLE IF NOT EXISTS `DenyRuleNew` (
  `type` ENUM('domain', 'email', 'startswith', 'destination') NOT NULL COMMENT 'The matching strategy for this rule.  &#x60;email&#x60; blocks an exact sender address, &#x60;domain&#x60; blocks all senders at a domain, &#x60;destination&#x60; blocks an exact recipient address, and &#x60;startswith&#x60; blocks any sender whose local-part begins with the given prefix.',
  `data` TEXT NOT NULL COMMENT 'The value to match against, interpreted according to &#x60;type&#x60;: a full email address for &#x60;email&#x60;/&#x60;destination&#x60;, a domain name for &#x60;domain&#x60;, or an alphanumeric prefix string for &#x60;startswith&#x60;.',
  `user` TEXT DEFAULT NULL COMMENT 'Optional SMTP username of the mail order to associate this rule with (e.g. &#x60;mb20682&#x60;).  If omitted the first active order is used.  Valid usernames are the &#x60;username&#x60; values returned by &#x60;GET /mail&#x60;.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='The fields required to create a new email deny rule via &#x60;POST /mail/rules&#x60;. The &#x60;type&#x60; controls what &#x60;data&#x60; is matched against: - &#x60;email&#x60; — exact sender address match - &#x60;domain&#x60; — all senders from a domain - &#x60;destination&#x60; — exact recipient address match - &#x60;startswith&#x60; — sender local-part prefix match (alphanumeric + &#x60;+_.-&#x60; only)';

--
-- Table structure for table `DenyRuleRecord` generated from model 'DenyRuleRecord'
-- A complete deny rule record as returned by &#x60;GET /mail/rules&#x60;.  Combines the rule definition fields (&#x60;DenyRuleNew&#x60;) with server-assigned metadata (&#x60;id&#x60; and &#x60;created&#x60;).  The &#x60;id&#x60; value is required by &#x60;DELETE /mail/rules/{ruleId}&#x60;.
--

CREATE TABLE IF NOT EXISTS `DenyRuleRecord` (
  `type` ENUM('domain', 'email', 'startswith', 'destination') NOT NULL COMMENT 'The matching strategy for this rule.  &#x60;email&#x60; blocks an exact sender address, &#x60;domain&#x60; blocks all senders at a domain, &#x60;destination&#x60; blocks an exact recipient address, and &#x60;startswith&#x60; blocks any sender whose local-part begins with the given prefix.',
  `data` TEXT NOT NULL COMMENT 'The value to match against, interpreted according to &#x60;type&#x60;: a full email address for &#x60;email&#x60;/&#x60;destination&#x60;, a domain name for &#x60;domain&#x60;, or an alphanumeric prefix string for &#x60;startswith&#x60;.',
  `id` TEXT NOT NULL COMMENT 'The numeric ID of the deny rule, as a string.  Pass this as &#x60;ruleId&#x60; to &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove the rule.',
  `created` DATETIME NOT NULL COMMENT 'The timestamp when the rule was created.',
  `user` TEXT DEFAULT NULL COMMENT 'Optional SMTP username of the mail order to associate this rule with (e.g. &#x60;mb20682&#x60;).  If omitted the first active order is used.  Valid usernames are the &#x60;username&#x60; values returned by &#x60;GET /mail&#x60;.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='A complete deny rule record as returned by &#x60;GET /mail/rules&#x60;.  Combines the rule definition fields (&#x60;DenyRuleNew&#x60;) with server-assigned metadata (&#x60;id&#x60; and &#x60;created&#x60;).  The &#x60;id&#x60; value is required by &#x60;DELETE /mail/rules/{ruleId}&#x60;.';

--
-- Table structure for table `EmailAddressName` generated from model 'EmailAddressName'
-- An email contact with an optional display name.  Used in structured address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;, &#x60;replyto&#x60;) in &#x60;SendMailAdv&#x60;.
--

CREATE TABLE IF NOT EXISTS `EmailAddressName` (
  `email` TEXT NOT NULL COMMENT 'The email address.',
  `name` TEXT DEFAULT NULL COMMENT 'Optional display name shown to recipients (e.g. in the &#x60;From:&#x60; header).'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='An email contact with an optional display name.  Used in structured address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;, &#x60;replyto&#x60;) in &#x60;SendMailAdv&#x60;.';

--
-- Table structure for table `EmailAddressParam` generated from model 'EmailAddressParam'
-- A single email address parameter used as the body of &#x60;POST /mail/blocks/delete&#x60;.
--

CREATE TABLE IF NOT EXISTS `EmailAddressParam` (
  `email` TEXT NOT NULL COMMENT 'The email address to delist from all block lists.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='A single email address parameter used as the body of &#x60;POST /mail/blocks/delete&#x60;.';

--
-- Table structure for table `EmailAddressTypes` generated from model 'EmailAddressTypes'
-- A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a structured contact object.
--

CREATE TABLE IF NOT EXISTS `EmailAddressTypes` (
  `email` TEXT NOT NULL COMMENT 'The email address.',
  `name` TEXT DEFAULT NULL COMMENT 'Optional display name shown to recipients (e.g. in the &#x60;From:&#x60; header).'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a structured contact object.';

--
-- Table structure for table `ErrorMessage` generated from model 'ErrorMessage'
-- The response body returned when an error occurs.
--

CREATE TABLE IF NOT EXISTS `ErrorMessage` (
  `code` INT NOT NULL COMMENT 'The HTTP-style status code associated with the error.',
  `message` TEXT NOT NULL COMMENT 'A human-readable description of the error.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='The response body returned when an error occurs.';

--
-- Table structure for table `GenericResponse` generated from model 'GenericResponse'
-- Standard success response returned by write operations (send, add rule, delete, etc.).  The &#x60;status&#x60; field is always &#x60;\&quot;ok\&quot;&#x60; on success.  The &#x60;text&#x60; field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record&#39;s ID; for delete calls it contains a confirmation string.
--

CREATE TABLE IF NOT EXISTS `GenericResponse` (
  `status` TEXT NOT NULL COMMENT 'Always &#x60;\&quot;ok\&quot;&#x60; on success.',
  `text` TEXT NOT NULL COMMENT 'Operation-specific result string.  For send operations this is the relay transaction ID (e.g. &#x60;185caa69ff7000f47c&#x60;) which can be used as the &#x60;mailid&#x60; parameter in &#x60;GET /mail/log&#x60;.  For create operations this is the new record&#39;s numeric ID.  For delete operations this is a human-readable confirmation.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Standard success response returned by write operations (send, add rule, delete, etc.).  The &#x60;status&#x60; field is always &#x60;\&quot;ok\&quot;&#x60; on success.  The &#x60;text&#x60; field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record&#39;s ID; for delete calls it contains a confirmation string.';

--
-- Table structure for table `MailAttachment` generated from model 'MailAttachment'
-- A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.
--

CREATE TABLE IF NOT EXISTS `MailAttachment` (
  `filename` TEXT NOT NULL COMMENT 'The filename shown to recipients (e.g. &#x60;report.pdf&#x60;, &#x60;invoice.xlsx&#x60;).',
  `data` MEDIUMBLOB NOT NULL COMMENT 'The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.';

--
-- Table structure for table `MailBlockClickHouse` generated from model 'MailBlockClickHouse'
-- A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
--

CREATE TABLE IF NOT EXISTS `MailBlockClickHouse` (
  `date` DATE NOT NULL COMMENT 'The date the block event was recorded.',
  `from` TEXT NOT NULL COMMENT 'The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it.',
  `subject` TEXT NOT NULL COMMENT 'The &#x60;Subject&#x60; header of the blocked message.',
  `to` TEXT NOT NULL COMMENT 'The serialized list of recipients of the blocked message.',
  `messageId` TEXT DEFAULT NULL COMMENT 'The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.';

--
-- Table structure for table `MailBlockRspamd` generated from model 'MailBlockRspamd'
-- A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
--

CREATE TABLE IF NOT EXISTS `MailBlockRspamd` (
  `from` TEXT NOT NULL COMMENT 'The sender email address.  Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist the sender.',
  `subject` TEXT NOT NULL COMMENT 'The suspicious subject pattern that triggered the block.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.';

--
-- Table structure for table `MailBlocks` generated from model 'MailBlocks'
-- The complete set of blocked addresses and message patterns returned by &#x60;GET /mail/blocks&#x60;. Three independent block sources are combined into one response. Use &#x60;POST /mail/blocks/delete&#x60; with a &#x60;from&#x60; address from any entry to delist it.
--

CREATE TABLE IF NOT EXISTS `MailBlocks` (
  `local` JSON NOT NULL COMMENT 'Messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.',
  `mbtrap` JSON NOT NULL COMMENT 'Messages flagged by the &#x60;MBTRAP&#x60; rspamd rule in the last 5 days. These triggered MailBaby&#39;s honeypot / trap address detection.',
  `subject` JSON NOT NULL COMMENT 'Senders whose messages contained spam-indicative subjects (containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with more than 4 occurrences of the same subject in the last 3 days.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='The complete set of blocked addresses and message patterns returned by &#x60;GET /mail/blocks&#x60;. Three independent block sources are combined into one response. Use &#x60;POST /mail/blocks/delete&#x60; with a &#x60;from&#x60; address from any entry to delist it.';

--
-- Table structure for table `MailLog` generated from model 'MailLog'
-- Paginated mail log response returned by &#x60;GET /mail/log&#x60;.  Contains the full matched count (&#x60;total&#x60;) plus a page of &#x60;MailLogEntry&#x60; records.  Use &#x60;skip&#x60; and &#x60;limit&#x60; to page through large result sets.
--

CREATE TABLE IF NOT EXISTS `MailLog` (
  `total` INT NOT NULL COMMENT 'Total number of log entries that match the supplied filters, regardless of &#x60;skip&#x60; and &#x60;limit&#x60;.  Use this to calculate the number of pages: &#x60;ceil(total / limit)&#x60;.',
  `skip` INT NOT NULL COMMENT 'The &#x60;skip&#x60; value used for this page (echoed from the request).',
  `limit` INT NOT NULL COMMENT 'The &#x60;limit&#x60; value used for this page (echoed from the request).',
  `emails` JSON NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Paginated mail log response returned by &#x60;GET /mail/log&#x60;.  Contains the full matched count (&#x60;total&#x60;) plus a page of &#x60;MailLogEntry&#x60; records.  Use &#x60;skip&#x60; and &#x60;limit&#x60; to page through large result sets.';

--
-- Table structure for table `MailLogEntry` generated from model 'MailLogEntry'
-- A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The &#x60;id&#x60; field matches the &#x60;mailid&#x60; query parameter on &#x60;GET /mail/log&#x60; and   the &#x60;text&#x60; field of a successful send response. - The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist a   flagged sender. - The &#x60;user&#x60; field is the SMTP username (e.g. &#x60;mb5658&#x60;) corresponding to the   &#x60;username&#x60; field in &#x60;GET /mail&#x60; / &#x60;GET /mail/{id}&#x60;.
--

CREATE TABLE IF NOT EXISTS `MailLogEntry` (
  `_id` INT NOT NULL COMMENT 'Internal auto-increment database row ID.  Not meaningful outside the API.',
  `id` VARCHAR(19) NOT NULL COMMENT 'The relay-assigned mail ID (18–19 hex characters).  This is the value returned as &#x60;text&#x60; by the sending endpoints and accepted as the &#x60;mailid&#x60; filter on &#x60;GET /mail/log&#x60;.',
  `from` TEXT NOT NULL COMMENT 'SMTP envelope &#x60;MAIL FROM&#x60; address (may differ from the &#x60;From:&#x60; header).',
  `to` TEXT NOT NULL COMMENT 'SMTP envelope &#x60;RCPT TO&#x60; address.',
  `created` TEXT NOT NULL COMMENT 'Human-readable creation timestamp in &#x60;YYYY-MM-DD HH:MM:SS&#x60; format.',
  `time` INT NOT NULL COMMENT 'Unix timestamp of message acceptance.  Corresponds to the &#x60;startDate&#x60; and &#x60;endDate&#x60; filter parameters on &#x60;GET /mail/log&#x60;.',
  `user` TEXT NOT NULL COMMENT 'The SMTP AUTH username used to submit the message (e.g. &#x60;mb5658&#x60;). Corresponds to the &#x60;username&#x60; field in &#x60;GET /mail&#x60; orders.',
  `transtype` TEXT NOT NULL COMMENT 'SMTP transaction type negotiated with the relay (e.g. &#x60;ESMTPSA&#x60;).',
  `origin` TEXT NOT NULL COMMENT 'IP address of the client that submitted the message to the relay. Corresponds to the &#x60;origin&#x60; filter parameter on &#x60;GET /mail/log&#x60;.',
  `interface` TEXT NOT NULL COMMENT 'Relay interface name that accepted the message (e.g. &#x60;feeder&#x60;).',
  `subject` TEXT DEFAULT NULL COMMENT 'The &#x60;Subject&#x60; header value, if available.',
  `messageId` TEXT DEFAULT NULL COMMENT 'The &#x60;Message-ID&#x60; header value, if present.  Can be used with the &#x60;messageId&#x60; filter on &#x60;GET /mail/log&#x60; for subsequent lookups.',
  `sendingZone` TEXT DEFAULT NULL COMMENT 'The sending zone assigned by the relay for outbound delivery.',
  `bodySize` INT DEFAULT NULL COMMENT 'Size of the message body in bytes.',
  `seq` INT DEFAULT NULL COMMENT 'Sequence index of this recipient in a multi-recipient message. Starts at 1.',
  `delivered` INT DEFAULT NULL COMMENT 'Delivery status flag.  &#x60;1&#x60; &#x3D; successfully delivered to destination MX. &#x60;0&#x60; &#x3D; queued, deferred, or failed.  &#x60;null&#x60; &#x3D; delivery not yet attempted. Corresponds to the &#x60;delivered&#x60; filter parameter on &#x60;GET /mail/log&#x60;.',
  `code` INT DEFAULT NULL COMMENT 'The SMTP response code from the destination MX server (e.g. &#x60;250&#x60; for success, &#x60;550&#x60; for permanent failure).',
  `response` TEXT DEFAULT NULL COMMENT 'The SMTP response string received from the destination MX server upon delivery attempt (e.g. &#x60;\&quot;250 2.0.0 Ok queued as C91D83E128C\&quot;&#x60;).',
  `recipient` TEXT DEFAULT NULL COMMENT 'The specific recipient address this delivery record is for.',
  `domain` TEXT DEFAULT NULL COMMENT 'The destination domain.  Corresponds to the &#x60;mx&#x60; filter parameter (which matches &#x60;mxHostname&#x60;, not &#x60;domain&#x60;) on &#x60;GET /mail/log&#x60;.',
  `locked` INT DEFAULT NULL COMMENT 'Whether the queue entry is currently locked for delivery processing.',
  `lockTime` TEXT DEFAULT NULL COMMENT 'Millisecond-precision timestamp of the last queue lock acquisition.',
  `assigned` TEXT DEFAULT NULL COMMENT 'The relay server node assigned to deliver this message.',
  `queued` TEXT DEFAULT NULL COMMENT 'ISO 8601 timestamp when the message was placed into the delivery queue.',
  `mxHostname` TEXT DEFAULT NULL COMMENT 'The MX hostname the relay connected to for delivery.  Corresponds to the &#x60;mx&#x60; filter parameter on &#x60;GET /mail/log&#x60;.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The &#x60;id&#x60; field matches the &#x60;mailid&#x60; query parameter on &#x60;GET /mail/log&#x60; and   the &#x60;text&#x60; field of a successful send response. - The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist a   flagged sender. - The &#x60;user&#x60; field is the SMTP username (e.g. &#x60;mb5658&#x60;) corresponding to the   &#x60;username&#x60; field in &#x60;GET /mail&#x60; / &#x60;GET /mail/{id}&#x60;.';

--
-- Table structure for table `MailOrder` generated from model 'MailOrder'
-- A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The &#x60;id&#x60; is the numeric identifier used across most API calls.  The &#x60;username&#x60; is always &#x60;mb&lt;id&gt;&#x60; and is the SMTP AUTH username for &#x60;relay.mailbaby.net&#x60;.
--

CREATE TABLE IF NOT EXISTS `MailOrder` (
  `id` INT NOT NULL COMMENT 'The unique numeric ID of the mail order.  Used as the &#x60;id&#x60; parameter on sending calls, log queries, and stats queries.',
  `status` ENUM('active', 'canceled') NOT NULL COMMENT 'The current order status.  Only &#x60;active&#x60; orders can be used for sending. &#x60;canceled&#x60; orders are retained for history but cannot send.',
  `username` TEXT NOT NULL COMMENT 'The SMTP AUTH username for this order, always in the format &#x60;mb&lt;id&gt;&#x60;. Use together with the password from &#x60;GET /mail/{id}&#x60; to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; if needed.',
  `comment` TEXT DEFAULT NULL COMMENT 'Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The &#x60;id&#x60; is the numeric identifier used across most API calls.  The &#x60;username&#x60; is always &#x60;mb&lt;id&gt;&#x60; and is the SMTP AUTH username for &#x60;relay.mailbaby.net&#x60;.';

--
-- Table structure for table `MailOrderDetail` generated from model 'MailOrderDetail'
-- Extended mail order record including the current SMTP password.  Returned by &#x60;GET /mail/{id}&#x60;.  The &#x60;username&#x60; and &#x60;password&#x60; fields can be used to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
--

CREATE TABLE IF NOT EXISTS `MailOrderDetail` (
  `id` INT NOT NULL COMMENT 'The unique numeric ID of the mail order.  Used as the &#x60;id&#x60; parameter on sending calls, log queries, and stats queries.',
  `status` ENUM('active', 'canceled') NOT NULL COMMENT 'The current order status.  Only &#x60;active&#x60; orders can be used for sending. &#x60;canceled&#x60; orders are retained for history but cannot send.',
  `username` TEXT NOT NULL COMMENT 'The SMTP AUTH username for this order, always in the format &#x60;mb&lt;id&gt;&#x60;. Use together with the password from &#x60;GET /mail/{id}&#x60; to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; if needed.',
  `password` TEXT NOT NULL COMMENT 'The current SMTP AUTH password for this mail order.  Use with the &#x60;username&#x60; field to authenticate against &#x60;relay.mailbaby.net:25&#x60;.',
  `comment` TEXT DEFAULT NULL COMMENT 'Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Extended mail order record including the current SMTP password.  Returned by &#x60;GET /mail/{id}&#x60;.  The &#x60;username&#x60; and &#x60;password&#x60; fields can be used to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.';

--
-- Table structure for table `MailStatsType` generated from model 'MailStatsType'
-- Account usage statistics returned by &#x60;GET /mail/stats&#x60;.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
--

CREATE TABLE IF NOT EXISTS `MailStatsType` (
  `time` ENUM('all', 'billing', 'month', '7d', '24h', 'day', '1h') DEFAULT '1h' COMMENT 'The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover.',
  `usage` INT DEFAULT NULL COMMENT 'Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value.',
  `currency` TEXT DEFAULT NULL COMMENT 'The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;).',
  `cost` DECIMAL(20, 9) DEFAULT NULL COMMENT 'Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).',
  `received` INT DEFAULT NULL COMMENT 'Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue.',
  `sent` INT DEFAULT NULL COMMENT 'Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;.',
  `volume` TEXT DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Account usage statistics returned by &#x60;GET /mail/stats&#x60;.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.';

--
-- Table structure for table `MailStatsVolume` generated from model 'MailStatsVolume'
-- Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
--

CREATE TABLE IF NOT EXISTS `MailStatsVolume` (
  `to` JSON DEFAULT NULL COMMENT 'Message counts keyed by destination (envelope &#x60;to&#x60;) email address.',
  `from` JSON DEFAULT NULL COMMENT 'Message counts keyed by sender (envelope &#x60;from&#x60;) email address.',
  `ip` JSON DEFAULT NULL COMMENT 'Message counts keyed by originating client IP address.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.';

--
-- Table structure for table `SendMail` generated from model 'SendMail'
-- Request body for &#x60;POST /mail/send&#x60;.  Sends a simple single-recipient message. HTML detection is automatic — if &#x60;body&#x60; contains HTML tags the message is sent as &#x60;text/html&#x60;; otherwise as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is automatically set as both the &#x60;From&#x60; and &#x60;Reply-To&#x60; headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use &#x60;POST /mail/advsend&#x60; instead.
--

CREATE TABLE IF NOT EXISTS `SendMail` (
  `to` TEXT NOT NULL,
  `from` TEXT NOT NULL COMMENT 'The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order.',
  `subject` TEXT NOT NULL COMMENT 'The subject line of the email.',
  `body` TEXT NOT NULL COMMENT 'The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.',
  `id` BIGINT DEFAULT NULL COMMENT 'Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Request body for &#x60;POST /mail/send&#x60;.  Sends a simple single-recipient message. HTML detection is automatic — if &#x60;body&#x60; contains HTML tags the message is sent as &#x60;text/html&#x60;; otherwise as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is automatically set as both the &#x60;From&#x60; and &#x60;Reply-To&#x60; headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use &#x60;POST /mail/advsend&#x60; instead.';

--
-- Table structure for table `SendMailAdv` generated from model 'SendMailAdv'
-- Request body for &#x60;POST /mail/advsend&#x60;.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) each accept either a plain RFC 822 string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;\&quot;&#x60; or a comma-separated list) or a structured array of &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; objects.  HTML detection is automatic based on whether &#x60;body&#x60; contains HTML tags.
--

CREATE TABLE IF NOT EXISTS `SendMailAdv` (
  `subject` TEXT NOT NULL COMMENT 'The subject line of the email.',
  `body` TEXT NOT NULL COMMENT 'The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.',
  `from` TEXT NOT NULL COMMENT 'The sender address.  Accepts a plain email string, an RFC 822 named string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; object.',
  `to` TEXT NOT NULL COMMENT 'One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.',
  `replyto` TEXT DEFAULT NULL COMMENT 'Optional.  One or more addresses to set as the &#x60;Reply-To&#x60; header. When recipients reply to the message their email client will address the reply to these addresses instead of &#x60;from&#x60;.',
  `cc` TEXT DEFAULT NULL COMMENT 'Optional.  Carbon-copy recipients.  These addresses are listed in the &#x60;Cc&#x60; header and are visible to all recipients.',
  `bcc` TEXT DEFAULT NULL COMMENT 'Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.',
  `attachments` JSON DEFAULT NULL COMMENT 'Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name.',
  `id` BIGINT DEFAULT NULL COMMENT 'Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Request body for &#x60;POST /mail/advsend&#x60;.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) each accept either a plain RFC 822 string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;\&quot;&#x60; or a comma-separated list) or a structured array of &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; objects.  HTML detection is automatic based on whether &#x60;body&#x60; contains HTML tags.';

--
-- Table structure for table `SendMailRaw` generated from model 'SendMailRaw'
-- Request body for &#x60;POST /mail/rawsend&#x60;.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing &#x60;DKIM-Signature&#x60; header intact.  The &#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, and &#x60;Bcc&#x60; addresses are extracted from the message headers automatically — you do not need to specify them separately.
--

CREATE TABLE IF NOT EXISTS `SendMailRaw` (
  `raw_email` TEXT NOT NULL COMMENT 'The complete RFC 822 email message including all headers and the body. Must include at minimum &#x60;From&#x60;, &#x60;To&#x60;, &#x60;Subject&#x60;, &#x60;Date&#x60;, and &#x60;MIME-Version&#x60; headers.  DKIM signatures in the &#x60;DKIM-Signature&#x60; header are transmitted verbatim and will pass verification at the destination.',
  `id` BIGINT DEFAULT NULL COMMENT 'Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by &#x60;GET /mail&#x60;.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Request body for &#x60;POST /mail/rawsend&#x60;.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing &#x60;DKIM-Signature&#x60; header intact.  The &#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, and &#x60;Bcc&#x60; addresses are extracted from the message headers automatically — you do not need to specify them separately.';


