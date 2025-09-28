package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;


import java.util.List;
import java.util.Map;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2025-09-28T16:28:57.253729770-04:00[America/New_York]")
public class PingApiServiceImpl implements PingApi {
      public Response pingServer(SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
}
