package io.swagger.api;

import io.swagger.api.PingApiService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.io.InputStream;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
@Path("/ping")
@RequestScoped






public class PingApi  {

  @Context SecurityContext securityContext;

  @Inject PingApiService delegate;


    @GET
    
    
    @Produces({ "text/plain" })
    @Operation(summary = "Checks if the server is running", description = "A lightweight health-check endpoint.  Returns the plain-text string `Server is up and running` with a `200` status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Status" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Server is up and running", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "200", description = "Something is wrong") })
    public Response pingServer() {
        return delegate.pingServer(securityContext);
    }
}
