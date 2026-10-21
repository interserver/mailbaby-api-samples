--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'SendMail' definition.
--


--
-- SELECT template for table `SendMail`
--
SELECT `to`, `from`, `subject`, `body`, `id` FROM `SendMail` WHERE 1;

--
-- INSERT template for table `SendMail`
--
INSERT INTO `SendMail`(`to`, `from`, `subject`, `body`, `id`) VALUES (?, ?, ?, ?, ?);

--
-- UPDATE template for table `SendMail`
--
UPDATE `SendMail` SET `to` = ?, `from` = ?, `subject` = ?, `body` = ?, `id` = ? WHERE 1;

--
-- DELETE template for table `SendMail`
--
DELETE FROM `SendMail` WHERE 0;

