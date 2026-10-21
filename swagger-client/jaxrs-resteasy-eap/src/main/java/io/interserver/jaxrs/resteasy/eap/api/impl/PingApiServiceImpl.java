package io.interserver.jaxrs.resteasy.eap.api.impl;

import io.interserver.jaxrs.resteasy.eap.api.*;
import io.interserver.jaxrs.resteasy.eap.model.*;


import java.util.List;
import java.util.Map;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


public class PingApiServiceImpl implements PingApi {
      public Response pingServer(SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
}
