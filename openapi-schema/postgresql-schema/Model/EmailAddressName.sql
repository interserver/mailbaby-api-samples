--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'EmailAddressName' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'email_address_name'
--
SELECT email, "name" FROM email_address_name WHERE 1=1;

--
-- INSERT template for table 'email_address_name'
--
INSERT INTO email_address_name (email, "name") VALUES (?, ?);

--
-- UPDATE template for table 'email_address_name'
--
UPDATE email_address_name SET email = ?, "name" = ? WHERE 1=2;

--
-- DELETE template for table 'email_address_name'
--
DELETE FROM email_address_name WHERE 1=2;

