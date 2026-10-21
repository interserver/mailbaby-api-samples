package io.interserver.jaxrs.resteasy.api.impl;

import io.interserver.jaxrs.resteasy.api.*;
import io.interserver.jaxrs.resteasy.model.*;


import java.util.List;
import java.util.Map;
import io.interserver.jaxrs.resteasy.api.NotFoundException;

import java.io.InputStream;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@RequestScoped

public class PingApiServiceImpl implements PingApiService {
      public Response pingServer(SecurityContext securityContext)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }
}
