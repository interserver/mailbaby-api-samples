package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import io.swagger.model.ErrorResponse;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailOrders;
import io.swagger.model.SendMail;

import java.util.List;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJAXRSCXFCDIServerCodegen", date = "2021-04-28T17:21:13.803401-04:00[America/New_York]")public interface MailApiService {
      public Response getMailById(Long id, SecurityContext securityContext);
      public Response getMailOrders(SecurityContext securityContext);
      public Response placeMailOrder(MailOrder body, SecurityContext securityContext);
      public Response sendAdvMailById(SendMail body, Long id, SecurityContext securityContext);
      public Response sendAdvMailById(Long id2, Long id, SecurityContext securityContext);
      public Response sendAdvMailById(SendMail body, Long id, SecurityContext securityContext);
      public Response sendMailById(Long id, String subject, String body, String to, String toName, String from, String fromName, SecurityContext securityContext);
      public Response validateMailOrder(SecurityContext securityContext);
      public Response viewMailLogById(Long id, String searchString, Integer skip, Integer limit, SecurityContext securityContext);
}
