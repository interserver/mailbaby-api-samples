--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'MailStatsVolume' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'mail_stats_volume'
--
SELECT "to", "from", ip FROM mail_stats_volume WHERE 1=1;

--
-- INSERT template for table 'mail_stats_volume'
--
INSERT INTO mail_stats_volume ("to", "from", ip) VALUES (?, ?, ?);

--
-- UPDATE template for table 'mail_stats_volume'
--
UPDATE mail_stats_volume SET "to" = ?, "from" = ?, ip = ? WHERE 1=2;

--
-- DELETE template for table 'mail_stats_volume'
--
DELETE FROM mail_stats_volume WHERE 1=2;

