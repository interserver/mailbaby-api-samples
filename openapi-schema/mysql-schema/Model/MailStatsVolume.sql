--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'MailStatsVolume' definition.
--


--
-- SELECT template for table `MailStatsVolume`
--
SELECT `to`, `from`, `ip` FROM `MailStatsVolume` WHERE 1;

--
-- INSERT template for table `MailStatsVolume`
--
INSERT INTO `MailStatsVolume`(`to`, `from`, `ip`) VALUES (?, ?, ?);

--
-- UPDATE template for table `MailStatsVolume`
--
UPDATE `MailStatsVolume` SET `to` = ?, `from` = ?, `ip` = ? WHERE 1;

--
-- DELETE template for table `MailStatsVolume`
--
DELETE FROM `MailStatsVolume` WHERE 0;

