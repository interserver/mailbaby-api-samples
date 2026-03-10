package io.swagger.api;

import io.swagger.model.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


import java.util.List;
import java.util.Map;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;
@Path("/ping")



public interface PingApi  {
   
    @GET
    
    
    
    @Operation(summary = "Checks if the server is running", description = "A lightweight health-check endpoint.  Returns a plain-text `200 OK` when the API server is reachable.  No authentication is required.  Useful for monitoring and uptime checks. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Status" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Server is up and running"),
                @ApiResponse(responseCode = "200", description = "Something is wrong")
         })
    Response pingServer(@Context SecurityContext securityContext);

}
