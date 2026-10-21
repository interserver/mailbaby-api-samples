--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'MailBlocks' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'mail_blocks'
--
SELECT "local", mbtrap, subject FROM mail_blocks WHERE 1=1;

--
-- INSERT template for table 'mail_blocks'
--
INSERT INTO mail_blocks ("local", mbtrap, subject) VALUES (?, ?, ?);

--
-- UPDATE template for table 'mail_blocks'
--
UPDATE mail_blocks SET "local" = ?, mbtrap = ?, subject = ? WHERE 1=2;

--
-- DELETE template for table 'mail_blocks'
--
DELETE FROM mail_blocks WHERE 1=2;

