package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.DenyRuleNew;
import io.swagger.model.DenyRuleRecord;
import io.swagger.model.EmailAddressTypes;
import io.swagger.model.EmailAddressesTypes;
import io.swagger.model.ErrorMessage;
import io.swagger.model.GenericResponse;
import io.swagger.model.InlineResponse200;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailBlocks;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;

import java.util.List;
import java.util.Map;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2024-10-15T16:38:00.756098598-04:00[America/New_York]")
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
      public Response delistBlock(String body,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response getMailBlocks(SecurityContext securityContext) {
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
      public Response getStats(SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response sendAdvMail(String subject,String body,EmailAddressTypes from,EmailAddressesTypes to,EmailAddressesTypes replyto,EmailAddressesTypes cc,EmailAddressesTypes bcc,List<MailAttachment> attachments,Long id,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response sendAdvMail(SendMailAdv body,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response sendMail(String to,String from,String subject,String body,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response sendMail(SendMail body,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response viewMailLog(Long id,String origin,String mx,String from,String to,String subject,String mailid,Integer skip,Integer limit,Long startDate,Long endDate,String replyto,String headerfrom,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
}
