package io.interserver.jaxrs.resteasy.eap.api;

import io.interserver.jaxrs.resteasy.eap.model.*;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;


import java.util.List;
import java.util.Map;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/ping")


@io.swagger.annotations.Api(description = "the ping API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyEapServerCodegen", comments = "Generator version: 7.26.0")
public interface PingApi  {

    @GET
    
    
    @Produces({ "text/plain", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Health check — verify the API is reachable", notes = "**No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. ", response = String.class, tags={ "Status", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Server is up and running", response = String.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Something is wrong", response = Void.class) })
    public Response pingServer(@Context SecurityContext securityContext);
}
