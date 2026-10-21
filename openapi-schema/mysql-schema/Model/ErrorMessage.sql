--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'ErrorMessage' definition.
--


--
-- SELECT template for table `ErrorMessage`
--
SELECT `code`, `message` FROM `ErrorMessage` WHERE 1;

--
-- INSERT template for table `ErrorMessage`
--
INSERT INTO `ErrorMessage`(`code`, `message`) VALUES (?, ?);

--
-- UPDATE template for table `ErrorMessage`
--
UPDATE `ErrorMessage` SET `code` = ?, `message` = ? WHERE 1;

--
-- DELETE template for table `ErrorMessage`
--
DELETE FROM `ErrorMessage` WHERE 0;

