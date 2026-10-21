package org.openapitools.api.impl;

import org.openapitools.api.*;
import org.openapitools.model.*;


import org.openapitools.model.DateOrTimestamp;
import org.openapitools.model.DenyRuleRecord;
import org.openapitools.model.EmailAddressParam;
import org.openapitools.model.EmailAddressTypes;
import org.openapitools.model.EmailAddressesTypes;
import org.openapitools.model.ErrorMessage;
import org.openapitools.model.GenericResponse;
import org.openapitools.model.MailAttachment;
import org.openapitools.model.MailBlocks;
import org.openapitools.model.MailLog;
import org.openapitools.model.MailOrder;
import org.openapitools.model.MailOrderDetail;
import org.openapitools.model.MailStatsType;
import org.openapitools.model.SendMailRaw;
import org.openapitools.model.SendMailTo;

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
      public Response viewMailLog(Long id,String origin,String mx,String from,String to,String subject,String mailid,String messageId,String replyto,String headerfrom,Integer delivered,Integer skip,Integer limit,DateOrTimestamp startDate,DateOrTimestamp endDate,String sort,String dir,String groupby,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
}
