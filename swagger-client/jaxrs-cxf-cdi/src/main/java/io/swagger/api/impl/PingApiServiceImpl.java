package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;


import java.util.List;

import java.io.InputStream;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@RequestScoped
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJAXRSCXFCDIServerCodegen", date = "2025-07-19T04:18:43.584578570-04:00[America/New_York]")
public class PingApiServiceImpl implements PingApiService {
      @Override
      public Response pingServer(SecurityContext securityContext) {
      // do some magic!
      return Response.ok().entity("magic!").build();
  }
}
