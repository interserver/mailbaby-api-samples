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

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyServerCodegen", date = "2021-05-05T04:12:07.432157-04:00[America/New_York]")public interface MailApiService {
      Response getMailOrders(Long id,SecurityContext securityContext)
      throws NotFoundException;
      Response placeMailOrder(MailOrder body,SecurityContext securityContext)
      throws NotFoundException;
      Response sendAdvMailById(SendMail body,SecurityContext securityContext)
      throws NotFoundException;
      Response sendMailById(SendMail body,SecurityContext securityContext)
      throws NotFoundException;
      Response sendMailById(String subject,String body,MailContact from,List<MailContact> to,Long id,List<MailContact> replyto,List<MailContact> cc,List<MailContact> bcc,List<MailAttachment> attachments,SecurityContext securityContext)
      throws NotFoundException;
      Response validateMailOrder(SecurityContext securityContext)
      throws NotFoundException;
      Response viewMailLogById(Long id,String searchString,Integer skip,Integer limit,SecurityContext securityContext)
      throws NotFoundException;
}
