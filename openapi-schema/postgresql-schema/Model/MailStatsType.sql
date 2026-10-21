--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'MailStatsType' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'mail_stats_type'
--
SELECT "time", "usage", currency, "cost", received, sent, volume FROM mail_stats_type WHERE 1=1;

--
-- INSERT template for table 'mail_stats_type'
--
INSERT INTO mail_stats_type ("time", "usage", currency, "cost", received, sent, volume) VALUES (?, ?, ?, ?, ?, ?, ?);

--
-- UPDATE template for table 'mail_stats_type'
--
UPDATE mail_stats_type SET "time" = ?, "usage" = ?, currency = ?, "cost" = ?, received = ?, sent = ?, volume = ? WHERE 1=2;

--
-- DELETE template for table 'mail_stats_type'
--
DELETE FROM mail_stats_type WHERE 1=2;

