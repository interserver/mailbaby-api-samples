package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.GenericResponse;
import io.swagger.model.InlineResponse401;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailContact;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailOrders;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;
import io.swagger.model.SendMailAdvFrom;

import java.util.List;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2021-05-08T00:57:50.952079-04:00[America/New_York]")public class MailApiServiceImpl implements MailApi {
      public Response getMailOrders(SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response placeMailOrder(MailOrder body,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response sendAdvMail(SendMailAdv body,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response sendAdvMail(String subject,String body,List<SendMailAdvFrom> from,List<MailContact> to,Long id,List<MailContact> replyto,List<MailContact> cc,List<MailContact> bcc,List<MailAttachment> attachments,SecurityContext securityContext) {
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
      public Response validateMailOrder(SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response viewMailLog(Long id,String searchString,Integer skip,Integer limit,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
}
