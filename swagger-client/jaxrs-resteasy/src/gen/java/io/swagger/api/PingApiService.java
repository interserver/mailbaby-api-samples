package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;


import java.util.List;
import java.util.Map;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyServerCodegen", date = "2024-10-15T16:38:03.834066472-04:00[America/New_York]")
public interface PingApiService {
      Response pingServer(SecurityContext securityContext) throws NotFoundException;
}
