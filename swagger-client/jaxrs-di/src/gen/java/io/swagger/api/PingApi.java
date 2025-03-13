package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.PingApiService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


import java.util.Map;
import java.util.List;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/ping")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyDIServerCodegen", date = "2025-03-13T09:47:59.015081732-04:00[America/New_York]")
public class PingApi  {

   private PingApiService delegate;

   protected PingApi() {
   }

   @javax.inject.Inject
   public PingApi(PingApiService delegate) {
      this.delegate = delegate;
   }

    @GET
    
    
    
    @Operation(summary = "Checks if the server is running", description = "", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Status" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Server is up and running"),
        
        @ApiResponse(responseCode = "200", description = "Something is wrong") })
    public Response pingServer(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.pingServer(securityContext);
    }
}
