--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'GenericResponse' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'generic_response'
--
SELECT status, "text" FROM generic_response WHERE 1=1;

--
-- INSERT template for table 'generic_response'
--
INSERT INTO generic_response (status, "text") VALUES (?, ?);

--
-- UPDATE template for table 'generic_response'
--
UPDATE generic_response SET status = ?, "text" = ? WHERE 1=2;

--
-- DELETE template for table 'generic_response'
--
DELETE FROM generic_response WHERE 1=2;

