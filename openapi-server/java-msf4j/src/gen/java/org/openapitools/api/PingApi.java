package org.openapitools.api;

import org.openapitools.model.*;
import org.openapitools.api.PingApiService;
import org.openapitools.api.factories.PingApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;


import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import org.wso2.msf4j.formparam.FormDataParam;
import org.wso2.msf4j.formparam.FileInfo;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/ping")


@io.swagger.annotations.Api(description = "the ping API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaMSF4JServerCodegen", comments = "Generator version: 7.26.0")
public class PingApi  {
   private final PingApiService delegate = PingApiServiceFactory.getPingApi();

    @GET
    
    
    @Produces({ "text/plain", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Health check — verify the API is reachable", notes = "**No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. ", response = String.class, tags={ "Status", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Server is up and running", response = String.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Something is wrong", response = String.class) })
    public Response pingServer()
    throws NotFoundException {
        return delegate.pingServer();
    }
}
