--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'MailStatsType' definition.
--


--
-- SELECT template for table `MailStatsType`
--
SELECT `time`, `usage`, `currency`, `cost`, `received`, `sent`, `volume` FROM `MailStatsType` WHERE 1;

--
-- INSERT template for table `MailStatsType`
--
INSERT INTO `MailStatsType`(`time`, `usage`, `currency`, `cost`, `received`, `sent`, `volume`) VALUES (?, ?, ?, ?, ?, ?, ?);

--
-- UPDATE template for table `MailStatsType`
--
UPDATE `MailStatsType` SET `time` = ?, `usage` = ?, `currency` = ?, `cost` = ?, `received` = ?, `sent` = ?, `volume` = ? WHERE 1;

--
-- DELETE template for table `MailStatsType`
--
DELETE FROM `MailStatsType` WHERE 0;

