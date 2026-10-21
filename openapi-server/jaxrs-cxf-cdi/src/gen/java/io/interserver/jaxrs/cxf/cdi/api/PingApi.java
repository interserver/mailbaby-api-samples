package io.interserver.jaxrs.cxf.cdi.api;

import io.interserver.jaxrs.cxf.cdi.api.PingApiService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import io.swagger.annotations.*;
import java.io.InputStream;

import org.apache.cxf.jaxrs.ext.PATCH;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
@Path("/ping")
@RequestScoped

@Api


@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSCXFCDIServerCodegen", comments = "Generator version: 7.26.0")

public class PingApi  {

  @Context SecurityContext securityContext;

  @Inject PingApiService delegate;


    @GET
    
    
    @Produces({ "text/plain", "application/json" })
    @ApiOperation(value = "Health check — verify the API is reachable", notes = "**No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. ", response = String.class, tags={ "Status" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Server is up and running", response = String.class),
        @ApiResponse(code = 200, message = "Something is wrong", response = Void.class) })
    public Response pingServer() {
        return delegate.pingServer(securityContext);
    }
}
