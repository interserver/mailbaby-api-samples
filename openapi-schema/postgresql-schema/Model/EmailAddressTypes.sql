--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'EmailAddressTypes' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'email_address_types'
--
SELECT email, "name" FROM email_address_types WHERE 1=1;

--
-- INSERT template for table 'email_address_types'
--
INSERT INTO email_address_types (email, "name") VALUES (?, ?);

--
-- UPDATE template for table 'email_address_types'
--
UPDATE email_address_types SET email = ?, "name" = ? WHERE 1=2;

--
-- DELETE template for table 'email_address_types'
--
DELETE FROM email_address_types WHERE 1=2;

