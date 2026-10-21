--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'MailAttachment' definition.
--


--
-- SELECT template for table `MailAttachment`
--
SELECT `filename`, `data` FROM `MailAttachment` WHERE 1;

--
-- INSERT template for table `MailAttachment`
--
INSERT INTO `MailAttachment`(`filename`, `data`) VALUES (?, ?);

--
-- UPDATE template for table `MailAttachment`
--
UPDATE `MailAttachment` SET `filename` = ?, `data` = ? WHERE 1;

--
-- DELETE template for table `MailAttachment`
--
DELETE FROM `MailAttachment` WHERE 0;

