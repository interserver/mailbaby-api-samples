--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'SendMailAdv' definition.
--


--
-- SELECT template for table `SendMailAdv`
--
SELECT `subject`, `body`, `from`, `to`, `replyto`, `cc`, `bcc`, `attachments`, `id` FROM `SendMailAdv` WHERE 1;

--
-- INSERT template for table `SendMailAdv`
--
INSERT INTO `SendMailAdv`(`subject`, `body`, `from`, `to`, `replyto`, `cc`, `bcc`, `attachments`, `id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);

--
-- UPDATE template for table `SendMailAdv`
--
UPDATE `SendMailAdv` SET `subject` = ?, `body` = ?, `from` = ?, `to` = ?, `replyto` = ?, `cc` = ?, `bcc` = ?, `attachments` = ?, `id` = ? WHERE 1;

--
-- DELETE template for table `SendMailAdv`
--
DELETE FROM `SendMailAdv` WHERE 0;

