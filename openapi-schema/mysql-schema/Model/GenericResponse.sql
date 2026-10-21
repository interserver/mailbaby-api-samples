--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'GenericResponse' definition.
--


--
-- SELECT template for table `GenericResponse`
--
SELECT `status`, `text` FROM `GenericResponse` WHERE 1;

--
-- INSERT template for table `GenericResponse`
--
INSERT INTO `GenericResponse`(`status`, `text`) VALUES (?, ?);

--
-- UPDATE template for table `GenericResponse`
--
UPDATE `GenericResponse` SET `status` = ?, `text` = ? WHERE 1;

--
-- DELETE template for table `GenericResponse`
--
DELETE FROM `GenericResponse` WHERE 0;

