package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2021-05-05T04:03:22.653793-04:00[America/New_York]")public class MailApiServiceImpl implements MailApi {
      public Response getMailOrders(Long id,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response placeMailOrder(MailOrder body,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response sendAdvMailById(SendMail body,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response sendMailById(SendMail body,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response sendMailById(SendMail payload,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response validateMailOrder(SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      public Response viewMailLogById(Long id,String searchString,Integer skip,Integer limit,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
}
