--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'MailBlockRspamd' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'mail_block_rspamd'
--
SELECT "from", subject FROM mail_block_rspamd WHERE 1=1;

--
-- INSERT template for table 'mail_block_rspamd'
--
INSERT INTO mail_block_rspamd ("from", subject) VALUES (?, ?);

--
-- UPDATE template for table 'mail_block_rspamd'
--
UPDATE mail_block_rspamd SET "from" = ?, subject = ? WHERE 1=2;

--
-- DELETE template for table 'mail_block_rspamd'
--
DELETE FROM mail_block_rspamd WHERE 1=2;

