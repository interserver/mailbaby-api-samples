--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'EmailAddressParam' definition.
--


--
-- SELECT template for table `EmailAddressParam`
--
SELECT `email` FROM `EmailAddressParam` WHERE 1;

--
-- INSERT template for table `EmailAddressParam`
--
INSERT INTO `EmailAddressParam`(`email`) VALUES (?);

--
-- UPDATE template for table `EmailAddressParam`
--
UPDATE `EmailAddressParam` SET `email` = ? WHERE 1;

--
-- DELETE template for table `EmailAddressParam`
--
DELETE FROM `EmailAddressParam` WHERE 0;

