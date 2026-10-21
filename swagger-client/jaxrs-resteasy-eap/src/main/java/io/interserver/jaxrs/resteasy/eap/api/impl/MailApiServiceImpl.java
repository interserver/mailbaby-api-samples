package io.interserver.jaxrs.resteasy.eap.api.impl;

import io.interserver.jaxrs.resteasy.eap.api.*;
import io.interserver.jaxrs.resteasy.eap.model.*;

import io.interserver.jaxrs.resteasy.eap.model.DenyRuleNew;
import io.interserver.jaxrs.resteasy.eap.model.DenyRuleRecord;
import io.interserver.jaxrs.resteasy.eap.model.EmailAddressParam;
import io.interserver.jaxrs.resteasy.eap.model.ErrorMessage;
import io.interserver.jaxrs.resteasy.eap.model.GenericResponse;
import io.interserver.jaxrs.resteasy.eap.model.MailAttachment;
import io.interserver.jaxrs.resteasy.eap.model.MailBlocks;
import io.interserver.jaxrs.resteasy.eap.model.MailLog;
import io.interserver.jaxrs.resteasy.eap.model.MailOrder;
import io.interserver.jaxrs.resteasy.eap.model.MailOrderDetail;
import io.interserver.jaxrs.resteasy.eap.model.MailStatsType;
import io.interserver.jaxrs.resteasy.eap.model.SendMail;
import io.interserver.jaxrs.resteasy.eap.model.SendMailAdv;
import io.interserver.jaxrs.resteasy.eap.model.SendMailRaw;
import io.interserver.jaxrs.resteasy.eap.model.SendMailTo;

import java.util.List;
import java.util.Map;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


public class MailApiServiceImpl implements MailApi {
      public Response addRule(String user,String type,String data,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response addRule(DenyRuleNew body,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response deleteRule(Integer ruleId,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response delistBlock(EmailAddressParam body,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response delistBlock(String email,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response getMailBlocks(SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response getMailOrderById(Long id,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response getMailOrders(SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response getRules(SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response getStats(String time,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response rawMail(SendMailRaw body,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response rawMail(String rawEmail,Long id,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response sendAdvMail(String subject,String body,Object from,Object to,Object replyto,Object cc,Object bcc,List<MailAttachment> attachments,Long id,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response sendAdvMail(SendMailAdv body,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response sendMail(SendMailTo to,String from,String subject,String body,Long id,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response sendMail(SendMail body,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response viewMailLog(Long id,String origin,String mx,String from,String to,String subject,String mailid,String messageId,String replyto,String headerfrom,Integer delivered,Integer skip,Integer limit,String startDate,String endDate,String sort,String dir,String groupby,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
}
