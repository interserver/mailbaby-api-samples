package io.interserver.jaxrs.spec.api;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.io.InputStream;
import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
* Represents a collection of functions to interact with the API endpoints.
*/
@Path("/ping")
@Api(description = "the ping API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", comments = "Generator version: 7.26.0")
public class PingApi {

    @GET
    @Produces({ "text/plain", "application/json" })
    @ApiOperation(value = "Health check — verify the API is reachable", notes = "**No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. ", response = String.class, tags={ "Status" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Server is up and running", response = String.class),
        @ApiResponse(code = 200, message = "Something is wrong", response = Void.class)
    })
    public Response pingServer() {
        return Response.ok().entity("magic!").build();
    }
}
