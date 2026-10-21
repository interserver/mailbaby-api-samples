--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'MailAttachment' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'mail_attachment'
--
SELECT filename, "data" FROM mail_attachment WHERE 1=1;

--
-- INSERT template for table 'mail_attachment'
--
INSERT INTO mail_attachment (filename, "data") VALUES (?, ?);

--
-- UPDATE template for table 'mail_attachment'
--
UPDATE mail_attachment SET filename = ?, "data" = ? WHERE 1=2;

--
-- DELETE template for table 'mail_attachment'
--
DELETE FROM mail_attachment WHERE 1=2;

