--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'EmailAddressName' definition.
--


--
-- SELECT template for table `EmailAddressName`
--
SELECT `email`, `name` FROM `EmailAddressName` WHERE 1;

--
-- INSERT template for table `EmailAddressName`
--
INSERT INTO `EmailAddressName`(`email`, `name`) VALUES (?, ?);

--
-- UPDATE template for table `EmailAddressName`
--
UPDATE `EmailAddressName` SET `email` = ?, `name` = ? WHERE 1;

--
-- DELETE template for table `EmailAddressName`
--
DELETE FROM `EmailAddressName` WHERE 0;

