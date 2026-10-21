--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'MailLog' definition.
--


--
-- SELECT template for table `MailLog`
--
SELECT `total`, `skip`, `limit`, `emails` FROM `MailLog` WHERE 1;

--
-- INSERT template for table `MailLog`
--
INSERT INTO `MailLog`(`total`, `skip`, `limit`, `emails`) VALUES (?, ?, ?, ?);

--
-- UPDATE template for table `MailLog`
--
UPDATE `MailLog` SET `total` = ?, `skip` = ?, `limit` = ?, `emails` = ? WHERE 1;

--
-- DELETE template for table `MailLog`
--
DELETE FROM `MailLog` WHERE 0;

