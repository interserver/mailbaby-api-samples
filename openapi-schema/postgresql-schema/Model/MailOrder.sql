--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'MailOrder' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'mail_order'
--
SELECT "id", status, username, "comment" FROM mail_order WHERE 1=1;

--
-- INSERT template for table 'mail_order'
--
INSERT INTO mail_order ("id", status, username, "comment") VALUES (?, ?, ?, ?);

--
-- UPDATE template for table 'mail_order'
--
UPDATE mail_order SET "id" = ?, status = ?, username = ?, "comment" = ? WHERE 1=2;

--
-- DELETE template for table 'mail_order'
--
DELETE FROM mail_order WHERE 1=2;

