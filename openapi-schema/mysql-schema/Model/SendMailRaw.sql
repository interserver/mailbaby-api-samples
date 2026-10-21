--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'SendMailRaw' definition.
--


--
-- SELECT template for table `SendMailRaw`
--
SELECT `raw_email`, `id` FROM `SendMailRaw` WHERE 1;

--
-- INSERT template for table `SendMailRaw`
--
INSERT INTO `SendMailRaw`(`raw_email`, `id`) VALUES (?, ?);

--
-- UPDATE template for table `SendMailRaw`
--
UPDATE `SendMailRaw` SET `raw_email` = ?, `id` = ? WHERE 1;

--
-- DELETE template for table `SendMailRaw`
--
DELETE FROM `SendMailRaw` WHERE 0;

