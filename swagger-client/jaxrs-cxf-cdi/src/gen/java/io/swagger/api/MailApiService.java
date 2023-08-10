package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import io.swagger.model.DenyRuleNew;
import io.swagger.model.DenyRuleRecord;
import io.swagger.model.EmailAddress;
import io.swagger.model.EmailAddressName;
import io.swagger.model.GenericResponse;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse401;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailBlocks;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;

import java.util.List;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJAXRSCXFCDIServerCodegen", date = "2023-08-10T12:38:00.023822-04:00[America/New_York]")
public interface MailApiService {
      public Response addRule(String user, String type, String data, SecurityContext securityContext);
      public Response addRule(DenyRuleNew body, SecurityContext securityContext);
      public Response deleteRule(Integer ruleId, SecurityContext securityContext);
      public Response delistBlock(EmailAddress body, SecurityContext securityContext);
      public Response delistBlock(String email, SecurityContext securityContext);
      public Response getMailBlocks(SecurityContext securityContext);
      public Response getMailOrders(SecurityContext securityContext);
      public Response getRules(SecurityContext securityContext);
      public Response getStats(SecurityContext securityContext);
      public Response sendAdvMail(String subject, String body, EmailAddressName from, List<EmailAddressName> to, List<EmailAddressName> replyto, List<EmailAddressName> cc, List<EmailAddressName> bcc, List<MailAttachment> attachments, Long id, SecurityContext securityContext);
      public Response sendAdvMail(SendMailAdv body, SecurityContext securityContext);
      public Response sendMail(String to, String from, String subject, String body, SecurityContext securityContext);
      public Response sendMail(SendMail body, SecurityContext securityContext);
      public Response viewMailLog(Long id, String origin, String mx, String from, String to, String subject, String mailid, Integer skip, Integer limit, Long startDate, Long endDate, SecurityContext securityContext);
}
