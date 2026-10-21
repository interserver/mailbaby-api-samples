--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'SendMail' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'send_mail'
--
SELECT "to", "from", subject, body, "id" FROM send_mail WHERE 1=1;

--
-- INSERT template for table 'send_mail'
--
INSERT INTO send_mail ("to", "from", subject, body, "id") VALUES (?, ?, ?, ?, ?);

--
-- UPDATE template for table 'send_mail'
--
UPDATE send_mail SET "to" = ?, "from" = ?, subject = ?, body = ?, "id" = ? WHERE 1=2;

--
-- DELETE template for table 'send_mail'
--
DELETE FROM send_mail WHERE 1=2;

