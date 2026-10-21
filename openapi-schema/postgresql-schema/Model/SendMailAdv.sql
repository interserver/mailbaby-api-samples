--
-- "MailBaby Email Delivery and Management Service API"
-- Prepared SQL queries for 'SendMailAdv' definition.
-- Created using 'openapi-generator' ('postgresql-schema' generator)
-- (https://openapi-generator.tech/docs/generators/postgresql-schema)
--


--
-- SELECT template for table 'send_mail_adv'
--
SELECT subject, body, "from", "to", replyto, cc, bcc, attachments, "id" FROM send_mail_adv WHERE 1=1;

--
-- INSERT template for table 'send_mail_adv'
--
INSERT INTO send_mail_adv (subject, body, "from", "to", replyto, cc, bcc, attachments, "id") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);

--
-- UPDATE template for table 'send_mail_adv'
--
UPDATE send_mail_adv SET subject = ?, body = ?, "from" = ?, "to" = ?, replyto = ?, cc = ?, bcc = ?, attachments = ?, "id" = ? WHERE 1=2;

--
-- DELETE template for table 'send_mail_adv'
--
DELETE FROM send_mail_adv WHERE 1=2;

