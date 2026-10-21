package io.interserver.jaxrs.resteasy.api;

import io.interserver.jaxrs.resteasy.api.*;
import io.interserver.jaxrs.resteasy.model.*;

import io.interserver.jaxrs.resteasy.model.DenyRuleNew;
import io.interserver.jaxrs.resteasy.model.DenyRuleRecord;
import io.interserver.jaxrs.resteasy.model.EmailAddressParam;
import io.interserver.jaxrs.resteasy.model.ErrorMessage;
import io.interserver.jaxrs.resteasy.model.GenericResponse;
import io.interserver.jaxrs.resteasy.model.MailAttachment;
import io.interserver.jaxrs.resteasy.model.MailBlocks;
import io.interserver.jaxrs.resteasy.model.MailLog;
import io.interserver.jaxrs.resteasy.model.MailOrder;
import io.interserver.jaxrs.resteasy.model.MailOrderDetail;
import io.interserver.jaxrs.resteasy.model.MailStatsType;
import io.interserver.jaxrs.resteasy.model.SendMail;
import io.interserver.jaxrs.resteasy.model.SendMailAdv;
import io.interserver.jaxrs.resteasy.model.SendMailRaw;
import io.interserver.jaxrs.resteasy.model.SendMailTo;

import java.util.List;
import java.util.Map;
import io.interserver.jaxrs.resteasy.api.NotFoundException;

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
      Response sendAdvMail(String subject,String body,Object from,Object to,Object replyto,Object cc,Object bcc,List<MailAttachment> attachments,Long id,SecurityContext securityContext) throws NotFoundException;
      Response sendAdvMail(SendMailAdv body,SecurityContext securityContext) throws NotFoundException;
      Response sendMail(SendMailTo to,String from,String subject,String body,Long id,SecurityContext securityContext) throws NotFoundException;
      Response sendMail(SendMail body,SecurityContext securityContext) throws NotFoundException;
      Response viewMailLog(Long id,String origin,String mx,String from,String to,String subject,String mailid,String messageId,String replyto,String headerfrom,Integer delivered,Integer skip,Integer limit,String startDate,String endDate,String sort,String dir,String groupby,SecurityContext securityContext) throws NotFoundException;
}
