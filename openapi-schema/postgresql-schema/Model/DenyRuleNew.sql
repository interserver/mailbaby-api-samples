--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'DenyRuleNew' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'deny_rule_new'
--
SELECT "type", "data", "user" FROM deny_rule_new WHERE 1=1;

--
-- INSERT template for table 'deny_rule_new'
--
INSERT INTO deny_rule_new ("type", "data", "user") VALUES (?, ?, ?);

--
-- UPDATE template for table 'deny_rule_new'
--
UPDATE deny_rule_new SET "type" = ?, "data" = ?, "user" = ? WHERE 1=2;

--
-- DELETE template for table 'deny_rule_new'
--
DELETE FROM deny_rule_new WHERE 1=2;

