--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'MailLogEntry' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'mail_log_entry'
--
SELECT _id, "id", "from", "to", created, "time", "user", transtype, origin, interface, subject, message_id, sending_zone, body_size, seq, delivered, code, response, recipient, "domain", "locked", lock_time, assigned, queued, mx_hostname FROM mail_log_entry WHERE 1=1;

--
-- INSERT template for table 'mail_log_entry'
--
INSERT INTO mail_log_entry (_id, "id", "from", "to", created, "time", "user", transtype, origin, interface, subject, message_id, sending_zone, body_size, seq, delivered, code, response, recipient, "domain", "locked", lock_time, assigned, queued, mx_hostname) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);

--
-- UPDATE template for table 'mail_log_entry'
--
UPDATE mail_log_entry SET _id = ?, "id" = ?, "from" = ?, "to" = ?, created = ?, "time" = ?, "user" = ?, transtype = ?, origin = ?, interface = ?, subject = ?, message_id = ?, sending_zone = ?, body_size = ?, seq = ?, delivered = ?, code = ?, response = ?, recipient = ?, "domain" = ?, "locked" = ?, lock_time = ?, assigned = ?, queued = ?, mx_hostname = ? WHERE 1=2;

--
-- DELETE template for table 'mail_log_entry'
--
DELETE FROM mail_log_entry WHERE 1=2;

