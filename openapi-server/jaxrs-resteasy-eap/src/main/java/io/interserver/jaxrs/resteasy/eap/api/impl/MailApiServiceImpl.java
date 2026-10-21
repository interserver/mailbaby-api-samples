package io.interserver.jaxrs.resteasy.eap.api.impl;

import io.interserver.jaxrs.resteasy.eap.api.*;
import io.interserver.jaxrs.resteasy.eap.model.*;


import io.interserver.jaxrs.resteasy.eap.model.DenyRuleRecord;
import io.interserver.jaxrs.resteasy.eap.model.EmailAddressParam;
import io.interserver.jaxrs.resteasy.eap.model.EmailAddressTypes;
import io.interserver.jaxrs.resteasy.eap.model.EmailAddressesTypes;
import io.interserver.jaxrs.resteasy.eap.model.ErrorMessage;
import io.interserver.jaxrs.resteasy.eap.model.GenericResponse;
import io.interserver.jaxrs.resteasy.eap.model.MailAttachment;
import io.interserver.jaxrs.resteasy.eap.model.MailBlocks;
import io.interserver.jaxrs.resteasy.eap.model.MailLog;
import io.interserver.jaxrs.resteasy.eap.model.MailOrder;
import io.interserver.jaxrs.resteasy.eap.model.MailOrderDetail;
import io.interserver.jaxrs.resteasy.eap.model.MailStatsType;
import io.interserver.jaxrs.resteasy.eap.model.SendMailRaw;
import io.interserver.jaxrs.resteasy.eap.model.SendMailTo;

import java.util.List;

import java.io.InputStream;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyEapServerCodegen", comments = "Generator version: 7.26.0")
public class MailApiServiceImpl implements MailApi {
      public Response addRule(String type,String data,String user,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response deleteRule(Integer ruleId,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response delistBlock(EmailAddressParam emailAddressParam,SecurityContext securityContext) {
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
      public Response rawMail(SendMailRaw sendMailRaw,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response sendAdvMail(String subject,String body,EmailAddressTypes from,EmailAddressesTypes to,EmailAddressesTypes replyto,EmailAddressesTypes cc,EmailAddressesTypes bcc,List<@Valid MailAttachment> attachments,Long id,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response sendMail(SendMailTo to,String from,String subject,String body,Long id,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response viewMailLog(Long id,String origin,String mx,String from,String to,String subject,String mailid,String messageId,String replyto,String headerfrom,Integer delivered,Integer skip,Integer limit,String startDate,String endDate,String sort,String dir,String groupby,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
}
