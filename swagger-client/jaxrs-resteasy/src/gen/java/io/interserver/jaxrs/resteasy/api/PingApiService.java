package io.interserver.jaxrs.resteasy.api;

import io.interserver.jaxrs.resteasy.api.*;
import io.interserver.jaxrs.resteasy.model.*;


import java.util.List;
import java.util.Map;
import io.interserver.jaxrs.resteasy.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


public interface PingApiService {
      Response pingServer(SecurityContext securityContext) throws NotFoundException;
}
