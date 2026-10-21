--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'EmailAddressParam' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'email_address_param'
--
SELECT email FROM email_address_param WHERE 1=1;

--
-- INSERT template for table 'email_address_param'
--
INSERT INTO email_address_param (email) VALUES (?);

--
-- UPDATE template for table 'email_address_param'
--
UPDATE email_address_param SET email = ? WHERE 1=2;

--
-- DELETE template for table 'email_address_param'
--
DELETE FROM email_address_param WHERE 1=2;

