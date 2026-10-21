--
-- Schema objects for PostgreSQL
-- "MailBaby Email Delivery and Management Service API"
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--

--
-- DROP OBJECTS
-- (remove comment prefix to start using DROP commands)
--
-- TABLES
--
-- DROP TABLE IF EXISTS deny_rule_new;
-- DROP TABLE IF EXISTS deny_rule_record;
-- DROP TABLE IF EXISTS email_address_name;
-- DROP TABLE IF EXISTS email_address_param;
-- DROP TABLE IF EXISTS email_address_types;
-- DROP TABLE IF EXISTS error_message;
-- DROP TABLE IF EXISTS generic_response;
-- DROP TABLE IF EXISTS mail_attachment;
-- DROP TABLE IF EXISTS mail_block_click_house;
-- DROP TABLE IF EXISTS mail_block_rspamd;
-- DROP TABLE IF EXISTS mail_blocks;
-- DROP TABLE IF EXISTS mail_log;
-- DROP TABLE IF EXISTS mail_log_entry;
-- DROP TABLE IF EXISTS mail_order;
-- DROP TABLE IF EXISTS mail_order_detail;
-- DROP TABLE IF EXISTS mail_stats_type;
-- DROP TABLE IF EXISTS mail_stats_volume;
-- DROP TABLE IF EXISTS send_mail;
-- DROP TABLE IF EXISTS send_mail_adv;
-- DROP TABLE IF EXISTS send_mail_raw;

--
-- TYPES
--
-- DROP TYPE IF EXISTS deny_rule_new_type;
-- DROP TYPE IF EXISTS deny_rule_record_type;
-- DROP TYPE IF EXISTS mail_order_status;
-- DROP TYPE IF EXISTS mail_order_detail_status;
-- DROP TYPE IF EXISTS mail_stats_type_time;


--
-- CREATE OBJECTS
--
-- TYPES
--
CREATE TYPE deny_rule_new_type AS ENUM('domain', 'email', 'startswith', 'destination');
CREATE TYPE deny_rule_record_type AS ENUM('domain', 'email', 'startswith', 'destination');
CREATE TYPE mail_order_status AS ENUM('active', 'canceled');
CREATE TYPE mail_order_detail_status AS ENUM('active', 'canceled');
CREATE TYPE mail_stats_type_time AS ENUM('all', 'billing', 'month', '7d', '24h', 'day', '1h');

--
-- TABLES
--
--
-- Table 'deny_rule_new' generated from model 'DenyRuleNew'
-- The fields required to create a new email deny rule via &#x60;POST /mail/rules&#x60;. The &#x60;type&#x60; controls what &#x60;data&#x60; is matched against: - &#x60;email&#x60; — exact sender address match - &#x60;domain&#x60; — all senders from a domain - &#x60;destination&#x60; — exact recipient address match - &#x60;startswith&#x60; — sender local-part prefix match (alphanumeric + &#x60;+_.-&#x60; only)
--
CREATE TABLE IF NOT EXISTS deny_rule_new (
    "type" deny_rule_new_type NOT NULL,
    "data" TEXT NOT NULL,
    "user" TEXT DEFAULT NULL
);
COMMENT ON TABLE deny_rule_new IS 'The fields required to create a new email deny rule via &#x60;POST /mail/rules&#x60;. The &#x60;type&#x60; controls what &#x60;data&#x60; is matched against: - &#x60;email&#x60; — exact sender address match - &#x60;domain&#x60; — all senders from a domain - &#x60;destination&#x60; — exact recipient address match - &#x60;startswith&#x60; — sender local-part prefix match (alphanumeric + &#x60;+_.-&#x60; only). Original model name - DenyRuleNew.';
COMMENT ON COLUMN deny_rule_new."type" IS 'The matching strategy for this rule.  &#x60;email&#x60; blocks an exact sender address, &#x60;domain&#x60; blocks all senders at a domain, &#x60;destination&#x60; blocks an exact recipient address, and &#x60;startswith&#x60; blocks any sender whose local-part begins with the given prefix.';
COMMENT ON COLUMN deny_rule_new."data" IS 'The value to match against, interpreted according to &#x60;type&#x60;: a full email address for &#x60;email&#x60;/&#x60;destination&#x60;, a domain name for &#x60;domain&#x60;, or an alphanumeric prefix string for &#x60;startswith&#x60;.';
COMMENT ON COLUMN deny_rule_new."user" IS 'Optional SMTP username of the mail order to associate this rule with (e.g. &#x60;mb20682&#x60;).  If omitted the first active order is used.  Valid usernames are the &#x60;username&#x60; values returned by &#x60;GET /mail&#x60;.';

--
-- Table 'deny_rule_record' generated from model 'DenyRuleRecord'
-- A complete deny rule record as returned by &#x60;GET /mail/rules&#x60;.  Combines the rule definition fields (&#x60;DenyRuleNew&#x60;) with server-assigned metadata (&#x60;id&#x60; and &#x60;created&#x60;).  The &#x60;id&#x60; value is required by &#x60;DELETE /mail/rules/{ruleId}&#x60;.
--
CREATE TABLE IF NOT EXISTS deny_rule_record (
    "type" deny_rule_record_type NOT NULL,
    "data" TEXT NOT NULL,
    "id" TEXT NOT NULL,
    created TIMESTAMP NOT NULL,
    "user" TEXT DEFAULT NULL
);
COMMENT ON TABLE deny_rule_record IS 'A complete deny rule record as returned by &#x60;GET /mail/rules&#x60;.  Combines the rule definition fields (&#x60;DenyRuleNew&#x60;) with server-assigned metadata (&#x60;id&#x60; and &#x60;created&#x60;).  The &#x60;id&#x60; value is required by &#x60;DELETE /mail/rules/{ruleId}&#x60;.. Original model name - DenyRuleRecord.';
COMMENT ON COLUMN deny_rule_record."type" IS 'The matching strategy for this rule.  &#x60;email&#x60; blocks an exact sender address, &#x60;domain&#x60; blocks all senders at a domain, &#x60;destination&#x60; blocks an exact recipient address, and &#x60;startswith&#x60; blocks any sender whose local-part begins with the given prefix.';
COMMENT ON COLUMN deny_rule_record."data" IS 'The value to match against, interpreted according to &#x60;type&#x60;: a full email address for &#x60;email&#x60;/&#x60;destination&#x60;, a domain name for &#x60;domain&#x60;, or an alphanumeric prefix string for &#x60;startswith&#x60;.';
COMMENT ON COLUMN deny_rule_record."id" IS 'The numeric ID of the deny rule, as a string.  Pass this as &#x60;ruleId&#x60; to &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove the rule.';
COMMENT ON COLUMN deny_rule_record.created IS 'The timestamp when the rule was created.';
COMMENT ON COLUMN deny_rule_record."user" IS 'Optional SMTP username of the mail order to associate this rule with (e.g. &#x60;mb20682&#x60;).  If omitted the first active order is used.  Valid usernames are the &#x60;username&#x60; values returned by &#x60;GET /mail&#x60;.';

--
-- Table 'email_address_name' generated from model 'EmailAddressName'
-- An email contact with an optional display name.  Used in structured address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;, &#x60;replyto&#x60;) in &#x60;SendMailAdv&#x60;.
--
CREATE TABLE IF NOT EXISTS email_address_name (
    email TEXT NOT NULL,
    "name" TEXT DEFAULT NULL
);
COMMENT ON TABLE email_address_name IS 'An email contact with an optional display name.  Used in structured address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;, &#x60;replyto&#x60;) in &#x60;SendMailAdv&#x60;.. Original model name - EmailAddressName.';
COMMENT ON COLUMN email_address_name.email IS 'The email address.';
COMMENT ON COLUMN email_address_name."name" IS 'Optional display name shown to recipients (e.g. in the &#x60;From:&#x60; header).';

--
-- Table 'email_address_param' generated from model 'EmailAddressParam'
-- A single email address parameter used as the body of &#x60;POST /mail/blocks/delete&#x60;.
--
CREATE TABLE IF NOT EXISTS email_address_param (
    email TEXT NOT NULL
);
COMMENT ON TABLE email_address_param IS 'A single email address parameter used as the body of &#x60;POST /mail/blocks/delete&#x60;.. Original model name - EmailAddressParam.';
COMMENT ON COLUMN email_address_param.email IS 'The email address to delist from all block lists.';

--
-- Table 'email_address_types' generated from model 'EmailAddressTypes'
-- A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a structured contact object.
--
CREATE TABLE IF NOT EXISTS email_address_types (
    email TEXT NOT NULL,
    "name" TEXT DEFAULT NULL
);
COMMENT ON TABLE email_address_types IS 'A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a structured contact object.. Original model name - EmailAddressTypes.';
COMMENT ON COLUMN email_address_types.email IS 'The email address.';
COMMENT ON COLUMN email_address_types."name" IS 'Optional display name shown to recipients (e.g. in the &#x60;From:&#x60; header).';

--
-- Table 'error_message' generated from model 'ErrorMessage'
-- The response body returned when an error occurs.
--
CREATE TABLE IF NOT EXISTS error_message (
    code INTEGER NOT NULL,
    message TEXT NOT NULL
);
COMMENT ON TABLE error_message IS 'The response body returned when an error occurs.. Original model name - ErrorMessage.';
COMMENT ON COLUMN error_message.code IS 'The HTTP-style status code associated with the error.';
COMMENT ON COLUMN error_message.message IS 'A human-readable description of the error.';

--
-- Table 'generic_response' generated from model 'GenericResponse'
-- Standard success response returned by write operations (send, add rule, delete, etc.).  The &#x60;status&#x60; field is always &#x60;\&quot;ok\&quot;&#x60; on success.  The &#x60;text&#x60; field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record&#39;s ID; for delete calls it contains a confirmation string.
--
CREATE TABLE IF NOT EXISTS generic_response (
    status TEXT NOT NULL,
    "text" TEXT NOT NULL
);
COMMENT ON TABLE generic_response IS 'Standard success response returned by write operations (send, add rule, delete, etc.).  The &#x60;status&#x60; field is always &#x60;\&quot;ok\&quot;&#x60; on success.  The &#x60;text&#x60; field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record&#39;s ID; for delete calls it contains a confirmation string.. Original model name - GenericResponse.';
COMMENT ON COLUMN generic_response.status IS 'Always &#x60;\&quot;ok\&quot;&#x60; on success.';
COMMENT ON COLUMN generic_response."text" IS 'Operation-specific result string.  For send operations this is the relay transaction ID (e.g. &#x60;185caa69ff7000f47c&#x60;) which can be used as the &#x60;mailid&#x60; parameter in &#x60;GET /mail/log&#x60;.  For create operations this is the new record&#39;s numeric ID.  For delete operations this is a human-readable confirmation.';

--
-- Table 'mail_attachment' generated from model 'MailAttachment'
-- A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.
--
CREATE TABLE IF NOT EXISTS mail_attachment (
    filename TEXT NOT NULL,
    "data" BYTEA NOT NULL
);
COMMENT ON TABLE mail_attachment IS 'A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.. Original model name - MailAttachment.';
COMMENT ON COLUMN mail_attachment.filename IS 'The filename shown to recipients (e.g. &#x60;report.pdf&#x60;, &#x60;invoice.xlsx&#x60;).';
COMMENT ON COLUMN mail_attachment."data" IS 'The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.';

--
-- Table 'mail_block_click_house' generated from model 'MailBlockClickHouse'
-- A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
--
CREATE TABLE IF NOT EXISTS mail_block_click_house (
    "date" DATE NOT NULL,
    "from" TEXT NOT NULL,
    subject TEXT NOT NULL,
    "to" TEXT NOT NULL,
    message_id TEXT DEFAULT NULL
);
COMMENT ON TABLE mail_block_click_house IS 'A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.. Original model name - MailBlockClickHouse.';
COMMENT ON COLUMN mail_block_click_house."date" IS 'The date the block event was recorded.';
COMMENT ON COLUMN mail_block_click_house."from" IS 'The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it.';
COMMENT ON COLUMN mail_block_click_house.subject IS 'The &#x60;Subject&#x60; header of the blocked message.';
COMMENT ON COLUMN mail_block_click_house."to" IS 'The serialized list of recipients of the blocked message.';
COMMENT ON COLUMN mail_block_click_house.message_id IS 'The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present.. Original param name - messageId.';

--
-- Table 'mail_block_rspamd' generated from model 'MailBlockRspamd'
-- A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
--
CREATE TABLE IF NOT EXISTS mail_block_rspamd (
    "from" TEXT NOT NULL,
    subject TEXT NOT NULL
);
COMMENT ON TABLE mail_block_rspamd IS 'A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.. Original model name - MailBlockRspamd.';
COMMENT ON COLUMN mail_block_rspamd."from" IS 'The sender email address.  Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist the sender.';
COMMENT ON COLUMN mail_block_rspamd.subject IS 'The suspicious subject pattern that triggered the block.';

--
-- Table 'mail_blocks' generated from model 'MailBlocks'
-- The complete set of blocked addresses and message patterns returned by &#x60;GET /mail/blocks&#x60;. Three independent block sources are combined into one response. Use &#x60;POST /mail/blocks/delete&#x60; with a &#x60;from&#x60; address from any entry to delist it.
--
CREATE TABLE IF NOT EXISTS mail_blocks (
    "local" JSON NOT NULL,
    mbtrap JSON NOT NULL,
    subject JSON NOT NULL
);
COMMENT ON TABLE mail_blocks IS 'The complete set of blocked addresses and message patterns returned by &#x60;GET /mail/blocks&#x60;. Three independent block sources are combined into one response. Use &#x60;POST /mail/blocks/delete&#x60; with a &#x60;from&#x60; address from any entry to delist it.. Original model name - MailBlocks.';
COMMENT ON COLUMN mail_blocks."local" IS 'Messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.';
COMMENT ON COLUMN mail_blocks.mbtrap IS 'Messages flagged by the &#x60;MBTRAP&#x60; rspamd rule in the last 5 days. These triggered MailBaby&#39;s honeypot / trap address detection.';
COMMENT ON COLUMN mail_blocks.subject IS 'Senders whose messages contained spam-indicative subjects (containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with more than 4 occurrences of the same subject in the last 3 days.';

--
-- Table 'mail_log' generated from model 'MailLog'
-- Paginated mail log response returned by &#x60;GET /mail/log&#x60;.  Contains the full matched count (&#x60;total&#x60;) plus a page of &#x60;MailLogEntry&#x60; records.  Use &#x60;skip&#x60; and &#x60;limit&#x60; to page through large result sets.
--
CREATE TABLE IF NOT EXISTS mail_log (
    total INTEGER NOT NULL,
    "skip" INTEGER NOT NULL,
    "limit" INTEGER NOT NULL,
    emails JSON NOT NULL
);
COMMENT ON TABLE mail_log IS 'Paginated mail log response returned by &#x60;GET /mail/log&#x60;.  Contains the full matched count (&#x60;total&#x60;) plus a page of &#x60;MailLogEntry&#x60; records.  Use &#x60;skip&#x60; and &#x60;limit&#x60; to page through large result sets.. Original model name - MailLog.';
COMMENT ON COLUMN mail_log.total IS 'Total number of log entries that match the supplied filters, regardless of &#x60;skip&#x60; and &#x60;limit&#x60;.  Use this to calculate the number of pages: &#x60;ceil(total / limit)&#x60;.';
COMMENT ON COLUMN mail_log."skip" IS 'The &#x60;skip&#x60; value used for this page (echoed from the request).';
COMMENT ON COLUMN mail_log."limit" IS 'The &#x60;limit&#x60; value used for this page (echoed from the request).';

--
-- Table 'mail_log_entry' generated from model 'MailLogEntry'
-- A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The &#x60;id&#x60; field matches the &#x60;mailid&#x60; query parameter on &#x60;GET /mail/log&#x60; and   the &#x60;text&#x60; field of a successful send response. - The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist a   flagged sender. - The &#x60;user&#x60; field is the SMTP username (e.g. &#x60;mb5658&#x60;) corresponding to the   &#x60;username&#x60; field in &#x60;GET /mail&#x60; / &#x60;GET /mail/{id}&#x60;.
--
CREATE TABLE IF NOT EXISTS mail_log_entry (
    _id INTEGER NOT NULL,
    "id" VARCHAR(19) NOT NULL,
    "from" TEXT NOT NULL,
    "to" TEXT NOT NULL,
    created TEXT NOT NULL,
    "time" INTEGER NOT NULL,
    "user" TEXT NOT NULL,
    transtype TEXT NOT NULL,
    origin TEXT NOT NULL,
    interface TEXT NOT NULL,
    subject TEXT DEFAULT NULL,
    message_id TEXT DEFAULT NULL,
    sending_zone TEXT DEFAULT NULL,
    body_size INTEGER DEFAULT NULL,
    seq INTEGER DEFAULT NULL,
    delivered INTEGER DEFAULT NULL,
    code INTEGER DEFAULT NULL,
    response TEXT DEFAULT NULL,
    recipient TEXT DEFAULT NULL,
    "domain" TEXT DEFAULT NULL,
    "locked" INTEGER DEFAULT NULL,
    lock_time TEXT DEFAULT NULL,
    assigned TEXT DEFAULT NULL,
    queued TEXT DEFAULT NULL,
    mx_hostname TEXT DEFAULT NULL
);
COMMENT ON TABLE mail_log_entry IS 'A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The &#x60;id&#x60; field matches the &#x60;mailid&#x60; query parameter on &#x60;GET /mail/log&#x60; and   the &#x60;text&#x60; field of a successful send response. - The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist a   flagged sender. - The &#x60;user&#x60; field is the SMTP username (e.g. &#x60;mb5658&#x60;) corresponding to the   &#x60;username&#x60; field in &#x60;GET /mail&#x60; / &#x60;GET /mail/{id}&#x60;.. Original model name - MailLogEntry.';
COMMENT ON COLUMN mail_log_entry._id IS 'Internal auto-increment database row ID.  Not meaningful outside the API.';
COMMENT ON COLUMN mail_log_entry."id" IS 'The relay-assigned mail ID (18–19 hex characters).  This is the value returned as &#x60;text&#x60; by the sending endpoints and accepted as the &#x60;mailid&#x60; filter on &#x60;GET /mail/log&#x60;.';
COMMENT ON COLUMN mail_log_entry."from" IS 'SMTP envelope &#x60;MAIL FROM&#x60; address (may differ from the &#x60;From:&#x60; header).';
COMMENT ON COLUMN mail_log_entry."to" IS 'SMTP envelope &#x60;RCPT TO&#x60; address.';
COMMENT ON COLUMN mail_log_entry.created IS 'Human-readable creation timestamp in &#x60;YYYY-MM-DD HH:MM:SS&#x60; format.';
COMMENT ON COLUMN mail_log_entry."time" IS 'Unix timestamp of message acceptance.  Corresponds to the &#x60;startDate&#x60; and &#x60;endDate&#x60; filter parameters on &#x60;GET /mail/log&#x60;.';
COMMENT ON COLUMN mail_log_entry."user" IS 'The SMTP AUTH username used to submit the message (e.g. &#x60;mb5658&#x60;). Corresponds to the &#x60;username&#x60; field in &#x60;GET /mail&#x60; orders.';
COMMENT ON COLUMN mail_log_entry.transtype IS 'SMTP transaction type negotiated with the relay (e.g. &#x60;ESMTPSA&#x60;).';
COMMENT ON COLUMN mail_log_entry.origin IS 'IP address of the client that submitted the message to the relay. Corresponds to the &#x60;origin&#x60; filter parameter on &#x60;GET /mail/log&#x60;.';
COMMENT ON COLUMN mail_log_entry.interface IS 'Relay interface name that accepted the message (e.g. &#x60;feeder&#x60;).';
COMMENT ON COLUMN mail_log_entry.subject IS 'The &#x60;Subject&#x60; header value, if available.';
COMMENT ON COLUMN mail_log_entry.message_id IS 'The &#x60;Message-ID&#x60; header value, if present.  Can be used with the &#x60;messageId&#x60; filter on &#x60;GET /mail/log&#x60; for subsequent lookups.. Original param name - messageId.';
COMMENT ON COLUMN mail_log_entry.sending_zone IS 'The sending zone assigned by the relay for outbound delivery.. Original param name - sendingZone.';
COMMENT ON COLUMN mail_log_entry.body_size IS 'Size of the message body in bytes.. Original param name - bodySize.';
COMMENT ON COLUMN mail_log_entry.seq IS 'Sequence index of this recipient in a multi-recipient message. Starts at 1.';
COMMENT ON COLUMN mail_log_entry.delivered IS 'Delivery status flag.  &#x60;1&#x60; &#x3D; successfully delivered to destination MX. &#x60;0&#x60; &#x3D; queued, deferred, or failed.  &#x60;null&#x60; &#x3D; delivery not yet attempted. Corresponds to the &#x60;delivered&#x60; filter parameter on &#x60;GET /mail/log&#x60;.';
COMMENT ON COLUMN mail_log_entry.code IS 'The SMTP response code from the destination MX server (e.g. &#x60;250&#x60; for success, &#x60;550&#x60; for permanent failure).';
COMMENT ON COLUMN mail_log_entry.response IS 'The SMTP response string received from the destination MX server upon delivery attempt (e.g. &#x60;\&quot;250 2.0.0 Ok queued as C91D83E128C\&quot;&#x60;).';
COMMENT ON COLUMN mail_log_entry.recipient IS 'The specific recipient address this delivery record is for.';
COMMENT ON COLUMN mail_log_entry."domain" IS 'The destination domain.  Corresponds to the &#x60;mx&#x60; filter parameter (which matches &#x60;mxHostname&#x60;, not &#x60;domain&#x60;) on &#x60;GET /mail/log&#x60;.';
COMMENT ON COLUMN mail_log_entry."locked" IS 'Whether the queue entry is currently locked for delivery processing.';
COMMENT ON COLUMN mail_log_entry.lock_time IS 'Millisecond-precision timestamp of the last queue lock acquisition.. Original param name - lockTime.';
COMMENT ON COLUMN mail_log_entry.assigned IS 'The relay server node assigned to deliver this message.';
COMMENT ON COLUMN mail_log_entry.queued IS 'ISO 8601 timestamp when the message was placed into the delivery queue.';
COMMENT ON COLUMN mail_log_entry.mx_hostname IS 'The MX hostname the relay connected to for delivery.  Corresponds to the &#x60;mx&#x60; filter parameter on &#x60;GET /mail/log&#x60;.. Original param name - mxHostname.';

--
-- Table 'mail_order' generated from model 'MailOrder'
-- A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The &#x60;id&#x60; is the numeric identifier used across most API calls.  The &#x60;username&#x60; is always &#x60;mb&lt;id&gt;&#x60; and is the SMTP AUTH username for &#x60;relay.mailbaby.net&#x60;.
--
CREATE TABLE IF NOT EXISTS mail_order (
    "id" INTEGER NOT NULL,
    status mail_order_status NOT NULL,
    username TEXT NOT NULL,
    "comment" TEXT DEFAULT NULL
);
COMMENT ON TABLE mail_order IS 'A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The &#x60;id&#x60; is the numeric identifier used across most API calls.  The &#x60;username&#x60; is always &#x60;mb&lt;id&gt;&#x60; and is the SMTP AUTH username for &#x60;relay.mailbaby.net&#x60;.. Original model name - MailOrder.';
COMMENT ON COLUMN mail_order."id" IS 'The unique numeric ID of the mail order.  Used as the &#x60;id&#x60; parameter on sending calls, log queries, and stats queries.';
COMMENT ON COLUMN mail_order.status IS 'The current order status.  Only &#x60;active&#x60; orders can be used for sending. &#x60;canceled&#x60; orders are retained for history but cannot send.';
COMMENT ON COLUMN mail_order.username IS 'The SMTP AUTH username for this order, always in the format &#x60;mb&lt;id&gt;&#x60;. Use together with the password from &#x60;GET /mail/{id}&#x60; to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; if needed.';
COMMENT ON COLUMN mail_order."comment" IS 'Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.';

--
-- Table 'mail_order_detail' generated from model 'MailOrderDetail'
-- Extended mail order record including the current SMTP password.  Returned by &#x60;GET /mail/{id}&#x60;.  The &#x60;username&#x60; and &#x60;password&#x60; fields can be used to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
--
CREATE TABLE IF NOT EXISTS mail_order_detail (
    "id" INTEGER NOT NULL,
    status mail_order_detail_status NOT NULL,
    username TEXT NOT NULL,
    "password" TEXT NOT NULL,
    "comment" TEXT DEFAULT NULL
);
COMMENT ON TABLE mail_order_detail IS 'Extended mail order record including the current SMTP password.  Returned by &#x60;GET /mail/{id}&#x60;.  The &#x60;username&#x60; and &#x60;password&#x60; fields can be used to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.. Original model name - MailOrderDetail.';
COMMENT ON COLUMN mail_order_detail."id" IS 'The unique numeric ID of the mail order.  Used as the &#x60;id&#x60; parameter on sending calls, log queries, and stats queries.';
COMMENT ON COLUMN mail_order_detail.status IS 'The current order status.  Only &#x60;active&#x60; orders can be used for sending. &#x60;canceled&#x60; orders are retained for history but cannot send.';
COMMENT ON COLUMN mail_order_detail.username IS 'The SMTP AUTH username for this order, always in the format &#x60;mb&lt;id&gt;&#x60;. Use together with the password from &#x60;GET /mail/{id}&#x60; to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; if needed.';
COMMENT ON COLUMN mail_order_detail."password" IS 'The current SMTP AUTH password for this mail order.  Use with the &#x60;username&#x60; field to authenticate against &#x60;relay.mailbaby.net:25&#x60;.';
COMMENT ON COLUMN mail_order_detail."comment" IS 'Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.';

--
-- Table 'mail_stats_type' generated from model 'MailStatsType'
-- Account usage statistics returned by &#x60;GET /mail/stats&#x60;.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
--
CREATE TABLE IF NOT EXISTS mail_stats_type (
    "time" mail_stats_type_time DEFAULT '1h',
    "usage" INTEGER DEFAULT NULL,
    currency TEXT DEFAULT NULL,
    "cost" DECIMAL(20, 9) DEFAULT NULL,
    received INTEGER DEFAULT NULL,
    sent INTEGER DEFAULT NULL,
    volume TEXT DEFAULT NULL
);
COMMENT ON TABLE mail_stats_type IS 'Account usage statistics returned by &#x60;GET /mail/stats&#x60;.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.. Original model name - MailStatsType.';
COMMENT ON COLUMN mail_stats_type."time" IS 'The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover.';
COMMENT ON COLUMN mail_stats_type."usage" IS 'Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value.';
COMMENT ON COLUMN mail_stats_type.currency IS 'The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;).';
COMMENT ON COLUMN mail_stats_type."cost" IS 'Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).';
COMMENT ON COLUMN mail_stats_type.received IS 'Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue.';
COMMENT ON COLUMN mail_stats_type.sent IS 'Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;.';

--
-- Table 'mail_stats_volume' generated from model 'MailStatsVolume'
-- Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
--
CREATE TABLE IF NOT EXISTS mail_stats_volume (
    "to" JSON DEFAULT NULL,
    "from" JSON DEFAULT NULL,
    ip JSON DEFAULT NULL
);
COMMENT ON TABLE mail_stats_volume IS 'Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.. Original model name - MailStatsVolume.';
COMMENT ON COLUMN mail_stats_volume."to" IS 'Message counts keyed by destination (envelope &#x60;to&#x60;) email address.';
COMMENT ON COLUMN mail_stats_volume."from" IS 'Message counts keyed by sender (envelope &#x60;from&#x60;) email address.';
COMMENT ON COLUMN mail_stats_volume.ip IS 'Message counts keyed by originating client IP address.';

--
-- Table 'send_mail' generated from model 'SendMail'
-- Request body for &#x60;POST /mail/send&#x60;.  Sends a simple single-recipient message. HTML detection is automatic — if &#x60;body&#x60; contains HTML tags the message is sent as &#x60;text/html&#x60;; otherwise as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is automatically set as both the &#x60;From&#x60; and &#x60;Reply-To&#x60; headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use &#x60;POST /mail/advsend&#x60; instead.
--
CREATE TABLE IF NOT EXISTS send_mail (
    "to" TEXT NOT NULL,
    "from" TEXT NOT NULL,
    subject TEXT NOT NULL,
    body TEXT NOT NULL,
    "id" BIGINT DEFAULT NULL
);
COMMENT ON TABLE send_mail IS 'Request body for &#x60;POST /mail/send&#x60;.  Sends a simple single-recipient message. HTML detection is automatic — if &#x60;body&#x60; contains HTML tags the message is sent as &#x60;text/html&#x60;; otherwise as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is automatically set as both the &#x60;From&#x60; and &#x60;Reply-To&#x60; headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use &#x60;POST /mail/advsend&#x60; instead.. Original model name - SendMail.';
COMMENT ON COLUMN send_mail."from" IS 'The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order.';
COMMENT ON COLUMN send_mail.subject IS 'The subject line of the email.';
COMMENT ON COLUMN send_mail.body IS 'The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.';
COMMENT ON COLUMN send_mail."id" IS 'Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.';

--
-- Table 'send_mail_adv' generated from model 'SendMailAdv'
-- Request body for &#x60;POST /mail/advsend&#x60;.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) each accept either a plain RFC 822 string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;\&quot;&#x60; or a comma-separated list) or a structured array of &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; objects.  HTML detection is automatic based on whether &#x60;body&#x60; contains HTML tags.
--
CREATE TABLE IF NOT EXISTS send_mail_adv (
    subject TEXT NOT NULL,
    body TEXT NOT NULL,
    "from" TEXT NOT NULL,
    "to" TEXT NOT NULL,
    replyto TEXT DEFAULT NULL,
    cc TEXT DEFAULT NULL,
    bcc TEXT DEFAULT NULL,
    attachments JSON DEFAULT NULL,
    "id" BIGINT DEFAULT NULL
);
COMMENT ON TABLE send_mail_adv IS 'Request body for &#x60;POST /mail/advsend&#x60;.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) each accept either a plain RFC 822 string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;\&quot;&#x60; or a comma-separated list) or a structured array of &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; objects.  HTML detection is automatic based on whether &#x60;body&#x60; contains HTML tags.. Original model name - SendMailAdv.';
COMMENT ON COLUMN send_mail_adv.subject IS 'The subject line of the email.';
COMMENT ON COLUMN send_mail_adv.body IS 'The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.';
COMMENT ON COLUMN send_mail_adv."from" IS 'The sender address.  Accepts a plain email string, an RFC 822 named string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; object.';
COMMENT ON COLUMN send_mail_adv."to" IS 'One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.';
COMMENT ON COLUMN send_mail_adv.replyto IS 'Optional.  One or more addresses to set as the &#x60;Reply-To&#x60; header. When recipients reply to the message their email client will address the reply to these addresses instead of &#x60;from&#x60;.';
COMMENT ON COLUMN send_mail_adv.cc IS 'Optional.  Carbon-copy recipients.  These addresses are listed in the &#x60;Cc&#x60; header and are visible to all recipients.';
COMMENT ON COLUMN send_mail_adv.bcc IS 'Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.';
COMMENT ON COLUMN send_mail_adv.attachments IS 'Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name.';
COMMENT ON COLUMN send_mail_adv."id" IS 'Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.';

--
-- Table 'send_mail_raw' generated from model 'SendMailRaw'
-- Request body for &#x60;POST /mail/rawsend&#x60;.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing &#x60;DKIM-Signature&#x60; header intact.  The &#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, and &#x60;Bcc&#x60; addresses are extracted from the message headers automatically — you do not need to specify them separately.
--
CREATE TABLE IF NOT EXISTS send_mail_raw (
    raw_email TEXT NOT NULL,
    "id" BIGINT DEFAULT NULL
);
COMMENT ON TABLE send_mail_raw IS 'Request body for &#x60;POST /mail/rawsend&#x60;.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing &#x60;DKIM-Signature&#x60; header intact.  The &#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, and &#x60;Bcc&#x60; addresses are extracted from the message headers automatically — you do not need to specify them separately.. Original model name - SendMailRaw.';
COMMENT ON COLUMN send_mail_raw.raw_email IS 'The complete RFC 822 email message including all headers and the body. Must include at minimum &#x60;From&#x60;, &#x60;To&#x60;, &#x60;Subject&#x60;, &#x60;Date&#x60;, and &#x60;MIME-Version&#x60; headers.  DKIM signatures in the &#x60;DKIM-Signature&#x60; header are transmitted verbatim and will pass verification at the destination.';
COMMENT ON COLUMN send_mail_raw."id" IS 'Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by &#x60;GET /mail&#x60;.';

