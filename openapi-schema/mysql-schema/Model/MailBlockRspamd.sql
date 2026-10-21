--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'MailBlockRspamd' definition.
--


--
-- SELECT template for table `MailBlockRspamd`
--
SELECT `from`, `subject` FROM `MailBlockRspamd` WHERE 1;

--
-- INSERT template for table `MailBlockRspamd`
--
INSERT INTO `MailBlockRspamd`(`from`, `subject`) VALUES (?, ?);

--
-- UPDATE template for table `MailBlockRspamd`
--
UPDATE `MailBlockRspamd` SET `from` = ?, `subject` = ? WHERE 1;

--
-- DELETE template for table `MailBlockRspamd`
--
DELETE FROM `MailBlockRspamd` WHERE 0;

