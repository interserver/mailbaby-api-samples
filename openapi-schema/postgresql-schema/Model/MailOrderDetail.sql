--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'MailOrderDetail' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'mail_order_detail'
--
SELECT "id", status, username, "password", "comment" FROM mail_order_detail WHERE 1=1;

--
-- INSERT template for table 'mail_order_detail'
--
INSERT INTO mail_order_detail ("id", status, username, "password", "comment") VALUES (?, ?, ?, ?, ?);

--
-- UPDATE template for table 'mail_order_detail'
--
UPDATE mail_order_detail SET "id" = ?, status = ?, username = ?, "password" = ?, "comment" = ? WHERE 1=2;

--
-- DELETE template for table 'mail_order_detail'
--
DELETE FROM mail_order_detail WHERE 1=2;

