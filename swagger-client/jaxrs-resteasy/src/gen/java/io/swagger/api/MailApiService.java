package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.ErrorResponse;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailOrders;
import io.swagger.model.SendMail;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyServerCodegen", date = "2021-04-28T16:58:46.388835-04:00[America/New_York]")public interface MailApiService {
      Response getMailById(Long id,SecurityContext securityContext)
      throws NotFoundException;
      Response getMailOrders(SecurityContext securityContext)
      throws NotFoundException;
      Response placeMailOrder(MailOrder body,SecurityContext securityContext)
      throws NotFoundException;
      Response sendAdvMailById(SendMail body,Long id,SecurityContext securityContext)
      throws NotFoundException;
      Response sendAdvMailById(Long id2,Long id,SecurityContext securityContext)
      throws NotFoundException;
      Response sendAdvMailById(SendMail body,Long id,SecurityContext securityContext)
      throws NotFoundException;
      Response sendMailById(Long id,String subject,String body,String to,String toName,String from,String fromName,SecurityContext securityContext)
      throws NotFoundException;
      Response validateMailOrder(SecurityContext securityContext)
      throws NotFoundException;
      Response viewMailLogById(Long id,String searchString,Integer skip,Integer limit,SecurityContext securityContext)
      throws NotFoundException;
}