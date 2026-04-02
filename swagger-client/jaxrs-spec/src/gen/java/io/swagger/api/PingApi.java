package io.swagger.api;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/ping")


public class PingApi {

    @GET
    @Produces({ "text/plain" })
    @Operation(summary = "Checks if the server is running", description = "A lightweight health-check endpoint.  Returns the plain-text string `Server is up and running` with a `200` status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Status" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Server is up and running", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "200", description = "Something is wrong")
    })
    public Response pingServer() {
        return Response.ok().entity("magic!").build();
    }}
