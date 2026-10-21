--
-- MailBaby Email Delivery and Management Service API.
-- Prepared SQL queries for 'DenyRuleNew' definition.
--


--
-- SELECT template for table `DenyRuleNew`
--
SELECT `type`, `data`, `user` FROM `DenyRuleNew` WHERE 1;

--
-- INSERT template for table `DenyRuleNew`
--
INSERT INTO `DenyRuleNew`(`type`, `data`, `user`) VALUES (?, ?, ?);

--
-- UPDATE template for table `DenyRuleNew`
--
UPDATE `DenyRuleNew` SET `type` = ?, `data` = ?, `user` = ? WHERE 1;

--
-- DELETE template for table `DenyRuleNew`
--
DELETE FROM `DenyRuleNew` WHERE 0;

