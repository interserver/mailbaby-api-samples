--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'SendMailRaw' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'send_mail_raw'
--
SELECT raw_email, "id" FROM send_mail_raw WHERE 1=1;

--
-- INSERT template for table 'send_mail_raw'
--
INSERT INTO send_mail_raw (raw_email, "id") VALUES (?, ?);

--
-- UPDATE template for table 'send_mail_raw'
--
UPDATE send_mail_raw SET raw_email = ?, "id" = ? WHERE 1=2;

--
-- DELETE template for table 'send_mail_raw'
--
DELETE FROM send_mail_raw WHERE 1=2;

