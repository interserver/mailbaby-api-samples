--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'DenyRuleRecord' definition.
--


--
-- SELECT template for table `DenyRuleRecord`
--
SELECT `type`, `data`, `id`, `created`, `user` FROM `DenyRuleRecord` WHERE 1;

--
-- INSERT template for table `DenyRuleRecord`
--
INSERT INTO `DenyRuleRecord`(`type`, `data`, `id`, `created`, `user`) VALUES (?, ?, ?, ?, ?);

--
-- UPDATE template for table `DenyRuleRecord`
--
UPDATE `DenyRuleRecord` SET `type` = ?, `data` = ?, `id` = ?, `created` = ?, `user` = ? WHERE 1;

--
-- DELETE template for table `DenyRuleRecord`
--
DELETE FROM `DenyRuleRecord` WHERE 0;

