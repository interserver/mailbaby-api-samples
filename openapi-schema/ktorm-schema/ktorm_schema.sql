

-- --------------------------------------------------------------------------
-- Table structure for table `DenyRuleNew` generated from model 'denyRuleNew'
-- The fields required to create a new email deny rule via &#x60;POST /mail/rules&#x60;. The &#x60;type&#x60; controls what &#x60;data&#x60; is matched against: - &#x60;email&#x60; — exact sender address match - &#x60;domain&#x60; — all senders from a domain - &#x60;destination&#x60; — exact recipient address match - &#x60;startswith&#x60; — sender local-part prefix match (alphanumeric + &#x60;+_.-&#x60; only)
--

CREATE TABLE IF NOT EXISTS `DenyRuleNew` (
  `type` text NOT NULL /*The matching strategy for this rule.  &#x60;email&#x60; blocks an exact sender address, &#x60;domain&#x60; blocks all senders at a domain, &#x60;destination&#x60; blocks an exact recipient address, and &#x60;startswith&#x60; blocks any sender whose local-part begins with the given prefix.*/,
  `data` text NOT NULL /*The value to match against, interpreted according to &#x60;type&#x60;: a full email address for &#x60;email&#x60;/&#x60;destination&#x60;, a domain name for &#x60;domain&#x60;, or an alphanumeric prefix string for &#x60;startswith&#x60;.*/,
  `user` text /*Optional SMTP username of the mail order to associate this rule with (e.g. &#x60;mb20682&#x60;).  If omitted the first active order is used.  Valid usernames are the &#x60;username&#x60; values returned by &#x60;GET /mail&#x60;.*/
);  /*The fields required to create a new email deny rule via &#x60;POST /mail/rules&#x60;. The &#x60;type&#x60; controls what &#x60;data&#x60; is matched against: - &#x60;email&#x60; — exact sender address match - &#x60;domain&#x60; — all senders from a domain - &#x60;destination&#x60; — exact recipient address match - &#x60;startswith&#x60; — sender local-part prefix match (alphanumeric + &#x60;+_.-&#x60; only)*/


-- --------------------------------------------------------------------------
-- Table structure for table `DenyRuleRecord` generated from model 'denyRuleRecord'
-- A complete deny rule record as returned by &#x60;GET /mail/rules&#x60;.  Combines the rule definition fields (&#x60;DenyRuleNew&#x60;) with server-assigned metadata (&#x60;id&#x60; and &#x60;created&#x60;).  The &#x60;id&#x60; value is required by &#x60;DELETE /mail/rules/{ruleId}&#x60;.
--

CREATE TABLE IF NOT EXISTS `DenyRuleRecord` (
  `type` text NOT NULL /*The matching strategy for this rule.  &#x60;email&#x60; blocks an exact sender address, &#x60;domain&#x60; blocks all senders at a domain, &#x60;destination&#x60; blocks an exact recipient address, and &#x60;startswith&#x60; blocks any sender whose local-part begins with the given prefix.*/,
  `data` text NOT NULL /*The value to match against, interpreted according to &#x60;type&#x60;: a full email address for &#x60;email&#x60;/&#x60;destination&#x60;, a domain name for &#x60;domain&#x60;, or an alphanumeric prefix string for &#x60;startswith&#x60;.*/,
  `id` text NOT NULL PRIMARY KEY /*The numeric ID of the deny rule, as a string.  Pass this as &#x60;ruleId&#x60; to &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove the rule.*/,
  `created` datetime NOT NULL /*The timestamp when the rule was created.*/,
  `user` text /*Optional SMTP username of the mail order to associate this rule with (e.g. &#x60;mb20682&#x60;).  If omitted the first active order is used.  Valid usernames are the &#x60;username&#x60; values returned by &#x60;GET /mail&#x60;.*/
);  /*A complete deny rule record as returned by &#x60;GET /mail/rules&#x60;.  Combines the rule definition fields (&#x60;DenyRuleNew&#x60;) with server-assigned metadata (&#x60;id&#x60; and &#x60;created&#x60;).  The &#x60;id&#x60; value is required by &#x60;DELETE /mail/rules/{ruleId}&#x60;.*/


-- --------------------------------------------------------------------------
-- Table structure for table `EmailAddressName` generated from model 'emailAddressName'
-- An email contact with an optional display name.  Used in structured address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;, &#x60;replyto&#x60;) in &#x60;SendMailAdv&#x60;.
--

CREATE TABLE IF NOT EXISTS `EmailAddressName` (
  `email` text NOT NULL /*The email address.*/,
  `name` text /*Optional display name shown to recipients (e.g. in the &#x60;From:&#x60; header).*/
);  /*An email contact with an optional display name.  Used in structured address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;, &#x60;replyto&#x60;) in &#x60;SendMailAdv&#x60;.*/


-- --------------------------------------------------------------------------
-- Table structure for table `EmailAddressParam` generated from model 'emailAddressParam'
-- A single email address parameter used as the body of &#x60;POST /mail/blocks/delete&#x60;.
--

CREATE TABLE IF NOT EXISTS `EmailAddressParam` (
  `email` text NOT NULL /*The email address to delist from all block lists.*/
);  /*A single email address parameter used as the body of &#x60;POST /mail/blocks/delete&#x60;.*/


-- --------------------------------------------------------------------------
-- Table structure for table `EmailAddressTypes` generated from model 'emailAddressTypes'
-- A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a structured contact object.
--

CREATE TABLE IF NOT EXISTS `EmailAddressTypes` (
  `email` text NOT NULL /*The email address.*/,
  `name` text /*Optional display name shown to recipients (e.g. in the &#x60;From:&#x60; header).*/
);  /*A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a structured contact object.*/


-- --------------------------------------------------------------------------
-- Table structure for table `ErrorMessage` generated from model 'errorMessage'
-- The response body returned when an error occurs.
--

CREATE TABLE IF NOT EXISTS `ErrorMessage` (
  `code` int NOT NULL /*The HTTP-style status code associated with the error.*/,
  `message` text NOT NULL /*A human-readable description of the error.*/
);  /*The response body returned when an error occurs.*/


-- --------------------------------------------------------------------------
-- Table structure for table `GenericResponse` generated from model 'genericResponse'
-- Standard success response returned by write operations (send, add rule, delete, etc.).  The &#x60;status&#x60; field is always &#x60;\&quot;ok\&quot;&#x60; on success.  The &#x60;text&#x60; field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record&#39;s ID; for delete calls it contains a confirmation string.
--

CREATE TABLE IF NOT EXISTS `GenericResponse` (
  `status` text NOT NULL /*Always &#x60;\&quot;ok\&quot;&#x60; on success.*/,
  `text` text NOT NULL /*Operation-specific result string.  For send operations this is the relay transaction ID (e.g. &#x60;185caa69ff7000f47c&#x60;) which can be used as the &#x60;mailid&#x60; parameter in &#x60;GET /mail/log&#x60;.  For create operations this is the new record&#39;s numeric ID.  For delete operations this is a human-readable confirmation.*/
);  /*Standard success response returned by write operations (send, add rule, delete, etc.).  The &#x60;status&#x60; field is always &#x60;\&quot;ok\&quot;&#x60; on success.  The &#x60;text&#x60; field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record&#39;s ID; for delete calls it contains a confirmation string.*/


-- --------------------------------------------------------------------------
-- Table structure for table `MailAttachment` generated from model 'mailAttachment'
-- A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.
--

CREATE TABLE IF NOT EXISTS `MailAttachment` (
  `filename` text NOT NULL /*The filename shown to recipients (e.g. &#x60;report.pdf&#x60;, &#x60;invoice.xlsx&#x60;).*/,
  `data` blob NOT NULL /*The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.*/
);  /*A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.*/


-- --------------------------------------------------------------------------
-- Table structure for table `MailBlockClickHouse` generated from model 'mailBlockClickHouse'
-- A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
--

CREATE TABLE IF NOT EXISTS `MailBlockClickHouse` (
  `date` date NOT NULL /*The date the block event was recorded.*/,
  `from` text NOT NULL /*The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it.*/,
  `subject` text NOT NULL /*The &#x60;Subject&#x60; header of the blocked message.*/,
  `to` text NOT NULL /*The serialized list of recipients of the blocked message.*/,
  `messageId` text /*The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present.*/
);  /*A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.*/


-- --------------------------------------------------------------------------
-- Table structure for table `MailBlockRspamd` generated from model 'mailBlockRspamd'
-- A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
--

CREATE TABLE IF NOT EXISTS `MailBlockRspamd` (
  `from` text NOT NULL /*The sender email address.  Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist the sender.*/,
  `subject` text NOT NULL /*The suspicious subject pattern that triggered the block.*/
);  /*A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.*/


-- --------------------------------------------------------------------------
-- Table structure for table `MailBlocks` generated from model 'mailBlocks'
-- The complete set of blocked addresses and message patterns returned by &#x60;GET /mail/blocks&#x60;. Three independent block sources are combined into one response. Use &#x60;POST /mail/blocks/delete&#x60; with a &#x60;from&#x60; address from any entry to delist it.
--

CREATE TABLE IF NOT EXISTS `MailBlocks` (
);  /*The complete set of blocked addresses and message patterns returned by &#x60;GET /mail/blocks&#x60;. Three independent block sources are combined into one response. Use &#x60;POST /mail/blocks/delete&#x60; with a &#x60;from&#x60; address from any entry to delist it.*/

-- --------------------------------------------------------------------------
-- Table structure for table `MailBlocksMailBlockClickHouse` generated from model 'MailBlocksMailBlockClickHouse'

CREATE TABLE IF NOT EXISTS `MailBlocksMailBlockClickHouse` (
  `mailBlocks` long NOT NULL
  `mailBlockClickHouse` long NOT NULL
);

-- --------------------------------------------------------------------------
-- Table structure for table `MailBlocksMailBlockClickHouse` generated from model 'MailBlocksMailBlockClickHouse'

CREATE TABLE IF NOT EXISTS `MailBlocksMailBlockClickHouse` (
  `mailBlocks` long NOT NULL
  `mailBlockClickHouse` long NOT NULL
);

-- --------------------------------------------------------------------------
-- Table structure for table `MailBlocksMailBlockRspamd` generated from model 'MailBlocksMailBlockRspamd'

CREATE TABLE IF NOT EXISTS `MailBlocksMailBlockRspamd` (
  `mailBlocks` long NOT NULL
  `mailBlockRspamd` long NOT NULL
);


-- --------------------------------------------------------------------------
-- Table structure for table `MailLog` generated from model 'mailLog'
-- Paginated mail log response returned by &#x60;GET /mail/log&#x60;.  Contains the full matched count (&#x60;total&#x60;) plus a page of &#x60;MailLogEntry&#x60; records.  Use &#x60;skip&#x60; and &#x60;limit&#x60; to page through large result sets.
--

CREATE TABLE IF NOT EXISTS `MailLog` (
  `total` int NOT NULL /*Total number of log entries that match the supplied filters, regardless of &#x60;skip&#x60; and &#x60;limit&#x60;.  Use this to calculate the number of pages: &#x60;ceil(total / limit)&#x60;.*/,
  `skip` int NOT NULL /*The &#x60;skip&#x60; value used for this page (echoed from the request).*/,
  `limit` int NOT NULL /*The &#x60;limit&#x60; value used for this page (echoed from the request).*/,
);  /*Paginated mail log response returned by &#x60;GET /mail/log&#x60;.  Contains the full matched count (&#x60;total&#x60;) plus a page of &#x60;MailLogEntry&#x60; records.  Use &#x60;skip&#x60; and &#x60;limit&#x60; to page through large result sets.*/

-- --------------------------------------------------------------------------
-- Table structure for table `MailLogMailLogEntry` generated from model 'MailLogMailLogEntry'

CREATE TABLE IF NOT EXISTS `MailLogMailLogEntry` (
  `mailLog` long NOT NULL
  `mailLogEntry` long NOT NULL
);


-- --------------------------------------------------------------------------
-- Table structure for table `MailLogEntry` generated from model 'mailLogEntry'
-- A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The &#x60;id&#x60; field matches the &#x60;mailid&#x60; query parameter on &#x60;GET /mail/log&#x60; and   the &#x60;text&#x60; field of a successful send response. - The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist a   flagged sender. - The &#x60;user&#x60; field is the SMTP username (e.g. &#x60;mb5658&#x60;) corresponding to the   &#x60;username&#x60; field in &#x60;GET /mail&#x60; / &#x60;GET /mail/{id}&#x60;.
--

CREATE TABLE IF NOT EXISTS `MailLogEntry` (
  `_id` int NOT NULL /*Internal auto-increment database row ID.  Not meaningful outside the API.*/,
  `id` text NOT NULL PRIMARY KEY /*The relay-assigned mail ID (18–19 hex characters).  This is the value returned as &#x60;text&#x60; by the sending endpoints and accepted as the &#x60;mailid&#x60; filter on &#x60;GET /mail/log&#x60;.*/,
  `from` text NOT NULL /*SMTP envelope &#x60;MAIL FROM&#x60; address (may differ from the &#x60;From:&#x60; header).*/,
  `to` text NOT NULL /*SMTP envelope &#x60;RCPT TO&#x60; address.*/,
  `created` text NOT NULL /*Human-readable creation timestamp in &#x60;YYYY-MM-DD HH:MM:SS&#x60; format.*/,
  `time` int NOT NULL /*Unix timestamp of message acceptance.  Corresponds to the &#x60;startDate&#x60; and &#x60;endDate&#x60; filter parameters on &#x60;GET /mail/log&#x60;.*/,
  `user` text NOT NULL /*The SMTP AUTH username used to submit the message (e.g. &#x60;mb5658&#x60;). Corresponds to the &#x60;username&#x60; field in &#x60;GET /mail&#x60; orders.*/,
  `transtype` text NOT NULL /*SMTP transaction type negotiated with the relay (e.g. &#x60;ESMTPSA&#x60;).*/,
  `origin` text NOT NULL /*IP address of the client that submitted the message to the relay. Corresponds to the &#x60;origin&#x60; filter parameter on &#x60;GET /mail/log&#x60;.*/,
  `interface` text NOT NULL /*Relay interface name that accepted the message (e.g. &#x60;feeder&#x60;).*/,
  `subject` text /*The &#x60;Subject&#x60; header value, if available.*/,
  `messageId` text /*The &#x60;Message-ID&#x60; header value, if present.  Can be used with the &#x60;messageId&#x60; filter on &#x60;GET /mail/log&#x60; for subsequent lookups.*/,
  `sendingZone` text /*The sending zone assigned by the relay for outbound delivery.*/,
  `bodySize` int /*Size of the message body in bytes.*/,
  `seq` int /*Sequence index of this recipient in a multi-recipient message. Starts at 1.*/,
  `delivered` int /*Delivery status flag.  &#x60;1&#x60; &#x3D; successfully delivered to destination MX. &#x60;0&#x60; &#x3D; queued, deferred, or failed.  &#x60;null&#x60; &#x3D; delivery not yet attempted. Corresponds to the &#x60;delivered&#x60; filter parameter on &#x60;GET /mail/log&#x60;.*/,
  `code` int /*The SMTP response code from the destination MX server (e.g. &#x60;250&#x60; for success, &#x60;550&#x60; for permanent failure).*/,
  `response` text /*The SMTP response string received from the destination MX server upon delivery attempt (e.g. &#x60;\&quot;250 2.0.0 Ok queued as C91D83E128C\&quot;&#x60;).*/,
  `recipient` text /*The specific recipient address this delivery record is for.*/,
  `domain` text /*The destination domain.  Corresponds to the &#x60;mx&#x60; filter parameter (which matches &#x60;mxHostname&#x60;, not &#x60;domain&#x60;) on &#x60;GET /mail/log&#x60;.*/,
  `locked` int /*Whether the queue entry is currently locked for delivery processing.*/,
  `lockTime` text /*Millisecond-precision timestamp of the last queue lock acquisition.*/,
  `assigned` text /*The relay server node assigned to deliver this message.*/,
  `queued` text /*ISO 8601 timestamp when the message was placed into the delivery queue.*/,
  `mxHostname` text /*The MX hostname the relay connected to for delivery.  Corresponds to the &#x60;mx&#x60; filter parameter on &#x60;GET /mail/log&#x60;.*/
);  /*A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The &#x60;id&#x60; field matches the &#x60;mailid&#x60; query parameter on &#x60;GET /mail/log&#x60; and   the &#x60;text&#x60; field of a successful send response. - The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist a   flagged sender. - The &#x60;user&#x60; field is the SMTP username (e.g. &#x60;mb5658&#x60;) corresponding to the   &#x60;username&#x60; field in &#x60;GET /mail&#x60; / &#x60;GET /mail/{id}&#x60;.*/


-- --------------------------------------------------------------------------
-- Table structure for table `MailOrder` generated from model 'mailOrder'
-- A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The &#x60;id&#x60; is the numeric identifier used across most API calls.  The &#x60;username&#x60; is always &#x60;mb&lt;id&gt;&#x60; and is the SMTP AUTH username for &#x60;relay.mailbaby.net&#x60;.
--

CREATE TABLE IF NOT EXISTS `MailOrder` (
  `id` int NOT NULL PRIMARY KEY AUTOINCREMENT /*The unique numeric ID of the mail order.  Used as the &#x60;id&#x60; parameter on sending calls, log queries, and stats queries.*/,
  `status` text NOT NULL /*The current order status.  Only &#x60;active&#x60; orders can be used for sending. &#x60;canceled&#x60; orders are retained for history but cannot send.*/,
  `username` text NOT NULL /*The SMTP AUTH username for this order, always in the format &#x60;mb&lt;id&gt;&#x60;. Use together with the password from &#x60;GET /mail/{id}&#x60; to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; if needed.*/,
  `comment` text /*Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.*/
);  /*A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The &#x60;id&#x60; is the numeric identifier used across most API calls.  The &#x60;username&#x60; is always &#x60;mb&lt;id&gt;&#x60; and is the SMTP AUTH username for &#x60;relay.mailbaby.net&#x60;.*/


-- --------------------------------------------------------------------------
-- Table structure for table `MailOrderDetail` generated from model 'mailOrderDetail'
-- Extended mail order record including the current SMTP password.  Returned by &#x60;GET /mail/{id}&#x60;.  The &#x60;username&#x60; and &#x60;password&#x60; fields can be used to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
--

CREATE TABLE IF NOT EXISTS `MailOrderDetail` (
  `id` int NOT NULL PRIMARY KEY AUTOINCREMENT /*The unique numeric ID of the mail order.  Used as the &#x60;id&#x60; parameter on sending calls, log queries, and stats queries.*/,
  `status` text NOT NULL /*The current order status.  Only &#x60;active&#x60; orders can be used for sending. &#x60;canceled&#x60; orders are retained for history but cannot send.*/,
  `username` text NOT NULL /*The SMTP AUTH username for this order, always in the format &#x60;mb&lt;id&gt;&#x60;. Use together with the password from &#x60;GET /mail/{id}&#x60; to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; if needed.*/,
  `password` text NOT NULL /*The current SMTP AUTH password for this mail order.  Use with the &#x60;username&#x60; field to authenticate against &#x60;relay.mailbaby.net:25&#x60;.*/,
  `comment` text /*Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.*/
);  /*Extended mail order record including the current SMTP password.  Returned by &#x60;GET /mail/{id}&#x60;.  The &#x60;username&#x60; and &#x60;password&#x60; fields can be used to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.*/


-- --------------------------------------------------------------------------
-- Table structure for table `MailStatsType` generated from model 'mailStatsType'
-- Account usage statistics returned by &#x60;GET /mail/stats&#x60;.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
--

CREATE TABLE IF NOT EXISTS `MailStatsType` (
  `time` text /*The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover.*/,
  `usage` int /*Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value.*/,
  `currency` text /*The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;).*/,
  `cost` double /*Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).*/,
  `received` int /*Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue.*/,
  `sent` int /*Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;.*/,
  `volume` long
);  /*Account usage statistics returned by &#x60;GET /mail/stats&#x60;.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.*/


-- --------------------------------------------------------------------------
-- Table structure for table `MailStatsVolume` generated from model 'mailStatsVolume'
-- Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
--

CREATE TABLE IF NOT EXISTS `MailStatsVolume` (
  `to` blob /*Message counts keyed by destination (envelope &#x60;to&#x60;) email address.*/,
  `from` blob /*Message counts keyed by sender (envelope &#x60;from&#x60;) email address.*/,
  `ip` blob /*Message counts keyed by originating client IP address.*/
);  /*Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.*/


-- --------------------------------------------------------------------------
-- Table structure for table `SendMail` generated from model 'sendMail'
-- Request body for &#x60;POST /mail/send&#x60;.  Sends a simple single-recipient message. HTML detection is automatic — if &#x60;body&#x60; contains HTML tags the message is sent as &#x60;text/html&#x60;; otherwise as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is automatically set as both the &#x60;From&#x60; and &#x60;Reply-To&#x60; headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use &#x60;POST /mail/advsend&#x60; instead.
--

CREATE TABLE IF NOT EXISTS `SendMail` (
  `to` long NOT NULL,
  `from` text NOT NULL /*The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order.*/,
  `subject` text NOT NULL /*The subject line of the email.*/,
  `body` text NOT NULL /*The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.*/,
  `id` long PRIMARY KEY AUTOINCREMENT /*Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.*/
);  /*Request body for &#x60;POST /mail/send&#x60;.  Sends a simple single-recipient message. HTML detection is automatic — if &#x60;body&#x60; contains HTML tags the message is sent as &#x60;text/html&#x60;; otherwise as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is automatically set as both the &#x60;From&#x60; and &#x60;Reply-To&#x60; headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use &#x60;POST /mail/advsend&#x60; instead.*/


-- --------------------------------------------------------------------------
-- Table structure for table `SendMailAdv` generated from model 'sendMailAdv'
-- Request body for &#x60;POST /mail/advsend&#x60;.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) each accept either a plain RFC 822 string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;\&quot;&#x60; or a comma-separated list) or a structured array of &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; objects.  HTML detection is automatic based on whether &#x60;body&#x60; contains HTML tags.
--

CREATE TABLE IF NOT EXISTS `SendMailAdv` (
  `subject` text NOT NULL /*The subject line of the email.*/,
  `body` text NOT NULL /*The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.*/,
  `from` long NOT NULL /*The sender address.  Accepts a plain email string, an RFC 822 named string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; object.*/,
  `to` long NOT NULL /*One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.*/,
  `replyto` long /*Optional.  One or more addresses to set as the &#x60;Reply-To&#x60; header. When recipients reply to the message their email client will address the reply to these addresses instead of &#x60;from&#x60;.*/,
  `cc` long /*Optional.  Carbon-copy recipients.  These addresses are listed in the &#x60;Cc&#x60; header and are visible to all recipients.*/,
  `bcc` long /*Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.*/,
  `id` long PRIMARY KEY AUTOINCREMENT /*Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.*/
);  /*Request body for &#x60;POST /mail/advsend&#x60;.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) each accept either a plain RFC 822 string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;\&quot;&#x60; or a comma-separated list) or a structured array of &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; objects.  HTML detection is automatic based on whether &#x60;body&#x60; contains HTML tags.*/

-- --------------------------------------------------------------------------
-- Table structure for table `SendMailAdvMailAttachment` generated from model 'SendMailAdvMailAttachment'

CREATE TABLE IF NOT EXISTS `SendMailAdvMailAttachment` (
  `sendMailAdv` long NOT NULL
  `mailAttachment` long NOT NULL
);


-- --------------------------------------------------------------------------
-- Table structure for table `SendMailRaw` generated from model 'sendMailRaw'
-- Request body for &#x60;POST /mail/rawsend&#x60;.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing &#x60;DKIM-Signature&#x60; header intact.  The &#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, and &#x60;Bcc&#x60; addresses are extracted from the message headers automatically — you do not need to specify them separately.
--

CREATE TABLE IF NOT EXISTS `SendMailRaw` (
  `raw_email` text NOT NULL /*The complete RFC 822 email message including all headers and the body. Must include at minimum &#x60;From&#x60;, &#x60;To&#x60;, &#x60;Subject&#x60;, &#x60;Date&#x60;, and &#x60;MIME-Version&#x60; headers.  DKIM signatures in the &#x60;DKIM-Signature&#x60; header are transmitted verbatim and will pass verification at the destination.*/,
  `id` long PRIMARY KEY AUTOINCREMENT /*Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by &#x60;GET /mail&#x60;.*/
);  /*Request body for &#x60;POST /mail/rawsend&#x60;.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing &#x60;DKIM-Signature&#x60; header intact.  The &#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, and &#x60;Bcc&#x60; addresses are extracted from the message headers automatically — you do not need to specify them separately.*/



--
-- Table structure for table `_db_version`
--
CREATE TABLE IF NOT EXISTS `_db_version` (
  `version`    LONG    DEFAULT 1
);
