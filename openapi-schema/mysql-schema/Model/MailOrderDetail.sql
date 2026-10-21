--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'MailOrderDetail' definition.
--


--
-- SELECT template for table `MailOrderDetail`
--
SELECT `id`, `status`, `username`, `password`, `comment` FROM `MailOrderDetail` WHERE 1;

--
-- INSERT template for table `MailOrderDetail`
--
INSERT INTO `MailOrderDetail`(`id`, `status`, `username`, `password`, `comment`) VALUES (?, ?, ?, ?, ?);

--
-- UPDATE template for table `MailOrderDetail`
--
UPDATE `MailOrderDetail` SET `id` = ?, `status` = ?, `username` = ?, `password` = ?, `comment` = ? WHERE 1;

--
-- DELETE template for table `MailOrderDetail`
--
DELETE FROM `MailOrderDetail` WHERE 0;

