package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.DenyRuleNew;
import io.swagger.model.DenyRuleRecord;
import io.swagger.model.EmailAddressParam;
import io.swagger.model.EmailAddressTypes;
import io.swagger.model.EmailAddressesTypes;
import io.swagger.model.ErrorMessage;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailBlocks;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailOrderDetail;
import io.swagger.model.MailStatsType;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;
import io.swagger.model.SendMailRaw;

import java.util.List;
import java.util.Map;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


public interface MailApiService {
      Response addRule(String user,String type,String data,SecurityContext securityContext) throws NotFoundException;
      Response addRule(DenyRuleNew body,SecurityContext securityContext) throws NotFoundException;
      Response deleteRule(Integer ruleId,SecurityContext securityContext) throws NotFoundException;
      Response delistBlock(EmailAddressParam body,SecurityContext securityContext) throws NotFoundException;
      Response delistBlock(String email,SecurityContext securityContext) throws NotFoundException;
      Response getMailBlocks(SecurityContext securityContext) throws NotFoundException;
      Response getMailOrderById(Long id,SecurityContext securityContext) throws NotFoundException;
      Response getMailOrders(SecurityContext securityContext) throws NotFoundException;
      Response getRules(SecurityContext securityContext) throws NotFoundException;
      Response getStats(String time,SecurityContext securityContext) throws NotFoundException;
      Response rawMail(SendMailRaw body,SecurityContext securityContext) throws NotFoundException;
      Response rawMail(String rawEmail,Long id,SecurityContext securityContext) throws NotFoundException;
      Response sendAdvMail(String subject,String body,EmailAddressTypes from,EmailAddressesTypes to,EmailAddressesTypes replyto,EmailAddressesTypes cc,EmailAddressesTypes bcc,List<MailAttachment> attachments,Long id,SecurityContext securityContext) throws NotFoundException;
      Response sendAdvMail(SendMailAdv body,SecurityContext securityContext) throws NotFoundException;
      Response sendMail(Object to,String from,String subject,String body,Long id,SecurityContext securityContext) throws NotFoundException;
      Response sendMail(SendMail body,SecurityContext securityContext) throws NotFoundException;
      Response viewMailLog(Long id,String origin,String mx,String from,String to,String subject,String mailid,String messageId,String replyto,String headerfrom,Integer delivered,Integer skip,Integer limit,Long startDate,Long endDate,SecurityContext securityContext) throws NotFoundException;
}
