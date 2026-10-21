--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'MailOrder' definition.
--


--
-- SELECT template for table `MailOrder`
--
SELECT `id`, `status`, `username`, `comment` FROM `MailOrder` WHERE 1;

--
-- INSERT template for table `MailOrder`
--
INSERT INTO `MailOrder`(`id`, `status`, `username`, `comment`) VALUES (?, ?, ?, ?);

--
-- UPDATE template for table `MailOrder`
--
UPDATE `MailOrder` SET `id` = ?, `status` = ?, `username` = ?, `comment` = ? WHERE 1;

--
-- DELETE template for table `MailOrder`
--
DELETE FROM `MailOrder` WHERE 0;

