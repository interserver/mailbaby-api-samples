--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'MailBlockClickHouse' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'mail_block_click_house'
--
SELECT "date", "from", subject, "to", message_id FROM mail_block_click_house WHERE 1=1;

--
-- INSERT template for table 'mail_block_click_house'
--
INSERT INTO mail_block_click_house ("date", "from", subject, "to", message_id) VALUES (?, ?, ?, ?, ?);

--
-- UPDATE template for table 'mail_block_click_house'
--
UPDATE mail_block_click_house SET "date" = ?, "from" = ?, subject = ?, "to" = ?, message_id = ? WHERE 1=2;

--
-- DELETE template for table 'mail_block_click_house'
--
DELETE FROM mail_block_click_house WHERE 1=2;

