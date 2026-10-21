--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'EmailAddressTypes' definition.
--


--
-- SELECT template for table `EmailAddressTypes`
--
SELECT `email`, `name` FROM `EmailAddressTypes` WHERE 1;

--
-- INSERT template for table `EmailAddressTypes`
--
INSERT INTO `EmailAddressTypes`(`email`, `name`) VALUES (?, ?);

--
-- UPDATE template for table `EmailAddressTypes`
--
UPDATE `EmailAddressTypes` SET `email` = ?, `name` = ? WHERE 1;

--
-- DELETE template for table `EmailAddressTypes`
--
DELETE FROM `EmailAddressTypes` WHERE 0;

