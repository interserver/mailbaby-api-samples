--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'MailBlockClickHouse' definition.
--


--
-- SELECT template for table `MailBlockClickHouse`
--
SELECT `date`, `from`, `subject`, `to`, `messageId` FROM `MailBlockClickHouse` WHERE 1;

--
-- INSERT template for table `MailBlockClickHouse`
--
INSERT INTO `MailBlockClickHouse`(`date`, `from`, `subject`, `to`, `messageId`) VALUES (?, ?, ?, ?, ?);

--
-- UPDATE template for table `MailBlockClickHouse`
--
UPDATE `MailBlockClickHouse` SET `date` = ?, `from` = ?, `subject` = ?, `to` = ?, `messageId` = ? WHERE 1;

--
-- DELETE template for table `MailBlockClickHouse`
--
DELETE FROM `MailBlockClickHouse` WHERE 0;

