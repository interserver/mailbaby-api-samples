--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'MailLogEntry' definition.
--


--
-- SELECT template for table `MailLogEntry`
--
SELECT `_id`, `id`, `from`, `to`, `created`, `time`, `user`, `transtype`, `origin`, `interface`, `subject`, `messageId`, `sendingZone`, `bodySize`, `seq`, `delivered`, `code`, `response`, `recipient`, `domain`, `locked`, `lockTime`, `assigned`, `queued`, `mxHostname` FROM `MailLogEntry` WHERE 1;

--
-- INSERT template for table `MailLogEntry`
--
INSERT INTO `MailLogEntry`(`_id`, `id`, `from`, `to`, `created`, `time`, `user`, `transtype`, `origin`, `interface`, `subject`, `messageId`, `sendingZone`, `bodySize`, `seq`, `delivered`, `code`, `response`, `recipient`, `domain`, `locked`, `lockTime`, `assigned`, `queued`, `mxHostname`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);

--
-- UPDATE template for table `MailLogEntry`
--
UPDATE `MailLogEntry` SET `_id` = ?, `id` = ?, `from` = ?, `to` = ?, `created` = ?, `time` = ?, `user` = ?, `transtype` = ?, `origin` = ?, `interface` = ?, `subject` = ?, `messageId` = ?, `sendingZone` = ?, `bodySize` = ?, `seq` = ?, `delivered` = ?, `code` = ?, `response` = ?, `recipient` = ?, `domain` = ?, `locked` = ?, `lockTime` = ?, `assigned` = ?, `queued` = ?, `mxHostname` = ? WHERE 1;

--
-- DELETE template for table `MailLogEntry`
--
DELETE FROM `MailLogEntry` WHERE 0;

