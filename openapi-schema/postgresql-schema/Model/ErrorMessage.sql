--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'ErrorMessage' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'error_message'
--
SELECT code, message FROM error_message WHERE 1=1;

--
-- INSERT template for table 'error_message'
--
INSERT INTO error_message (code, message) VALUES (?, ?);

--
-- UPDATE template for table 'error_message'
--
UPDATE error_message SET code = ?, message = ? WHERE 1=2;

--
-- DELETE template for table 'error_message'
--
DELETE FROM error_message WHERE 1=2;

