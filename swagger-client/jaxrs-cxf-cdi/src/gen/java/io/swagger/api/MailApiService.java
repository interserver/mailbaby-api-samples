package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import io.swagger.model.ErrorResponse;
import io.swagger.model.GenericResponse;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJAXRSCXFCDIServerCodegen", date = "2021-05-05T15:40:35.379870-04:00[America/New_York]")public interface MailApiService {
      public Response getMailOrders(SecurityContext securityContext);
      public Response placeMailOrder(MailOrder body, SecurityContext securityContext);
      public Response sendAdvMail(SendMailAdv body, SecurityContext securityContext);
      public Response sendAdvMail(String subject, String body, List<SendMailAdvFrom> from, List<MailContact> to, Long id, List<MailContact> replyto, List<MailContact> cc, List<MailContact> bcc, List<MailAttachment> attachments, SecurityContext securityContext);
      public Response sendMail(String to, String from, String subject, String body, SecurityContext securityContext);
      public Response sendMail(SendMail body, SecurityContext securityContext);
      public Response validateMailOrder(SecurityContext securityContext);
      public Response viewMailLog(Long id, String searchString, Integer skip, Integer limit, SecurityContext securityContext);
}
