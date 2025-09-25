package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.DenyRuleNew;
import io.swagger.model.DenyRuleRecord;
import io.swagger.model.EmailAddressTypes;
import io.swagger.model.EmailAddressesTypes;
import io.swagger.model.ErrorMessage;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailBlocks;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailStatsType;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;

import java.util.List;
import java.util.Map;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyServerCodegen", date = "2025-09-24T20:31:33.990973012-04:00[America/New_York]")
public interface MailApiService {
      Response addRule(String user,String type,String data,SecurityContext securityContext) throws NotFoundException;
      Response addRule(DenyRuleNew body,SecurityContext securityContext) throws NotFoundException;
      Response deleteRule(Integer ruleId,SecurityContext securityContext) throws NotFoundException;
      Response delistBlock(String body,SecurityContext securityContext) throws NotFoundException;
      Response getMailBlocks(SecurityContext securityContext) throws NotFoundException;
      Response getMailOrders(SecurityContext securityContext) throws NotFoundException;
      Response getRules(SecurityContext securityContext) throws NotFoundException;
      Response getStats(String time,SecurityContext securityContext) throws NotFoundException;
      Response sendAdvMail(String subject,String body,EmailAddressTypes from,EmailAddressesTypes to,EmailAddressesTypes replyto,EmailAddressesTypes cc,EmailAddressesTypes bcc,List<MailAttachment> attachments,Long id,SecurityContext securityContext) throws NotFoundException;
      Response sendAdvMail(SendMailAdv body,SecurityContext securityContext) throws NotFoundException;
      Response sendMail(String to,String from,String subject,String body,SecurityContext securityContext) throws NotFoundException;
      Response sendMail(SendMail body,SecurityContext securityContext) throws NotFoundException;
      Response viewMailLog(Long id,String origin,String mx,String from,String to,String subject,String mailid,Integer skip,Integer limit,Long startDate,Long endDate,String replyto,String headerfrom,String delivered,SecurityContext securityContext) throws NotFoundException;
}
