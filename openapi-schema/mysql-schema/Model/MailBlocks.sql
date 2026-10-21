--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'MailBlocks' definition.
--


--
-- SELECT template for table `MailBlocks`
--
SELECT `local`, `mbtrap`, `subject` FROM `MailBlocks` WHERE 1;

--
-- INSERT template for table `MailBlocks`
--
INSERT INTO `MailBlocks`(`local`, `mbtrap`, `subject`) VALUES (?, ?, ?);

--
-- UPDATE template for table `MailBlocks`
--
UPDATE `MailBlocks` SET `local` = ?, `mbtrap` = ?, `subject` = ? WHERE 1;

--
-- DELETE template for table `MailBlocks`
--
DELETE FROM `MailBlocks` WHERE 0;

