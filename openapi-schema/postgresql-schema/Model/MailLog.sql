--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'MailLog' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'mail_log'
--
SELECT total, "skip", "limit", emails FROM mail_log WHERE 1=1;

--
-- INSERT template for table 'mail_log'
--
INSERT INTO mail_log (total, "skip", "limit", emails) VALUES (?, ?, ?, ?);

--
-- UPDATE template for table 'mail_log'
--
UPDATE mail_log SET total = ?, "skip" = ?, "limit" = ?, emails = ? WHERE 1=2;

--
-- DELETE template for table 'mail_log'
--
DELETE FROM mail_log WHERE 1=2;

