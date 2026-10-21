package io.interserver.jaxrs.resteasy.api;

import io.interserver.jaxrs.resteasy.api.*;
import io.interserver.jaxrs.resteasy.model.*;



import io.interserver.jaxrs.resteasy.model.DenyRuleRecord;
import io.interserver.jaxrs.resteasy.model.EmailAddressParam;
import io.interserver.jaxrs.resteasy.model.EmailAddressTypes;
import io.interserver.jaxrs.resteasy.model.EmailAddressesTypes;
import io.interserver.jaxrs.resteasy.model.ErrorMessage;
import io.interserver.jaxrs.resteasy.model.GenericResponse;
import io.interserver.jaxrs.resteasy.model.MailAttachment;
import io.interserver.jaxrs.resteasy.model.MailBlocks;
import io.interserver.jaxrs.resteasy.model.MailLog;
import io.interserver.jaxrs.resteasy.model.MailOrder;
import io.interserver.jaxrs.resteasy.model.MailOrderDetail;
import io.interserver.jaxrs.resteasy.model.MailStatsType;
import io.interserver.jaxrs.resteasy.model.SendMailRaw;
import io.interserver.jaxrs.resteasy.model.SendMailTo;

import java.util.List;
import io.interserver.jaxrs.resteasy.api.NotFoundException;

import java.io.InputStream;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", comments = "Generator version: 7.26.0")
public interface MailApiService {
      Response addRule(String type,String data,String user,SecurityContext securityContext)
      throws NotFoundException;
      Response deleteRule(Integer ruleId,SecurityContext securityContext)
      throws NotFoundException;
      Response delistBlock(EmailAddressParam emailAddressParam,SecurityContext securityContext)
      throws NotFoundException;
      Response getMailBlocks(SecurityContext securityContext)
      throws NotFoundException;
      Response getMailOrderById(Long id,SecurityContext securityContext)
      throws NotFoundException;
      Response getMailOrders(SecurityContext securityContext)
      throws NotFoundException;
      Response getRules(SecurityContext securityContext)
      throws NotFoundException;
      Response getStats(String time,SecurityContext securityContext)
      throws NotFoundException;
      Response rawMail(SendMailRaw sendMailRaw,SecurityContext securityContext)
      throws NotFoundException;
      Response sendAdvMail(String subject,String body,EmailAddressTypes from,EmailAddressesTypes to,EmailAddressesTypes replyto,EmailAddressesTypes cc,EmailAddressesTypes bcc,List<@Valid MailAttachment> attachments,Long id,SecurityContext securityContext)
      throws NotFoundException;
      Response sendMail(SendMailTo to,String from,String subject,String body,Long id,SecurityContext securityContext)
      throws NotFoundException;
      Response viewMailLog(Long id,String origin,String mx,String from,String to,String subject,String mailid,String messageId,String replyto,String headerfrom,Integer delivered,Integer skip,Integer limit,String startDate,String endDate,String sort,String dir,String groupby,SecurityContext securityContext)
      throws NotFoundException;


}
