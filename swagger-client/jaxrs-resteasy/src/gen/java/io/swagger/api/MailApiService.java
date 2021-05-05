package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

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
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyServerCodegen", date = "2021-05-05T08:15:42.581130-04:00[America/New_York]")public interface MailApiService {
      Response getMailOrders(Long id,SecurityContext securityContext)
      throws NotFoundException;
      Response placeMailOrder(MailOrder body,SecurityContext securityContext)
      throws NotFoundException;
      Response sendAdvMail(SendMailAdv body,SecurityContext securityContext)
      throws NotFoundException;
      Response sendAdvMail(String subject,String body,List<SendMailAdvFrom> from,List<MailContact> to,Long id,List<MailContact> replyto,List<MailContact> cc,List<MailContact> bcc,List<MailAttachment> attachments,SecurityContext securityContext)
      throws NotFoundException;
      Response sendMail(String to,String from,String subject,String body,SecurityContext securityContext)
      throws NotFoundException;
      Response sendMail(SendMail body,SecurityContext securityContext)
      throws NotFoundException;
      Response validateMailOrder(SecurityContext securityContext)
      throws NotFoundException;
      Response viewMailLogById(Long id,String searchString,Integer skip,Integer limit,SecurityContext securityContext)
      throws NotFoundException;
}
