package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import io.swagger.model.GenericResponse;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse401;
import io.swagger.model.MailLog;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;
import io.swagger.model.SendMailAdvAttachments;
import io.swagger.model.SendMailAdvBcc;
import io.swagger.model.SendMailAdvCc;
import io.swagger.model.SendMailAdvFrom;
import io.swagger.model.SendMailAdvReplyto;
import io.swagger.model.SendMailAdvTo;

import java.util.List;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJAXRSCXFCDIServerCodegen", date = "2023-05-09T00:51:32.660870-04:00[America/New_York]")
public interface MailApiService {
      public Response getMailOrders(SecurityContext securityContext);
      public Response sendAdvMail(SendMailAdv body, SecurityContext securityContext);
      public Response sendAdvMail(String subject, String body, SendMailAdvFrom from, List<SendMailAdvTo> to, List<SendMailAdvReplyto> replyto, List<SendMailAdvCc> cc, List<SendMailAdvBcc> bcc, List<SendMailAdvAttachments> attachments, Long id, SecurityContext securityContext);
      public Response sendMail(String to, String from, String subject, String body, SecurityContext securityContext);
      public Response sendMail(SendMail body, SecurityContext securityContext);
      public Response viewMailLog(Long id, String origin, String mx, String from, String to, String subject, String mailid, Integer skip, Integer limit, Long startDate, Long endDate, SecurityContext securityContext);
}
