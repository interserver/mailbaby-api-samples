package io.swagger.api;

import io.swagger.model.ErrorResponse;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailOrders;
import io.swagger.model.SendMail;
import io.swagger.api.MailApiService;

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
@Path("/mail")
@RequestScoped




@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJAXRSCXFCDIServerCodegen", date = "2021-04-28T17:31:55.541822-04:00[America/New_York]")
public class MailApi  {

  @Context SecurityContext securityContext;

  @Inject MailApiService delegate;


    @GET
    @Path("/{id}")
    
    @Produces({ "application/json" })
    @Operation(summary = "Gets mail order information by id", description = "returns information about a mail order in the system with the given id.", security = {
        @SecurityRequirement(name = "apiKeyAuth"),
@SecurityRequirement(name = "apiLoginAuth"),
@SecurityRequirement(name = "apiPasswordAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = MailOrder.class))) })
    public Response getMailById(
@Parameter(description = "User ID",required=true) @PathParam("id") Long id
) {
        return delegate.getMailById(id, securityContext);
    }

    @GET
    
    
    @Produces({ "application/json", "application/xml", "text/plain" })
    @Operation(summary = "displays a list of mail service orders", description = "", security = {
        @SecurityRequirement(name = "apiKeyAuth"),
@SecurityRequirement(name = "apiLoginAuth"),
@SecurityRequirement(name = "apiPasswordAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = MailOrders.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })
    public Response getMailOrders() {
        return delegate.getMailOrders(securityContext);
    }

    @POST
    @Path("/order")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "places a mail order", description = "Adds an item to the system", security = {
        @SecurityRequirement(name = "apiKeyAuth"),
@SecurityRequirement(name = "apiLoginAuth"),
@SecurityRequirement(name = "apiPasswordAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "list of mail orders"),
        @ApiResponse(responseCode = "400", description = "invalid input, object invalid"),
        @ApiResponse(responseCode = "409", description = "an existing item already exists"),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })
    public Response placeMailOrder(
@Parameter(description = "Inventory item to add" ) MailOrder body
) {
        return delegate.placeMailOrder(body, securityContext);
    }

    @POST
    @Path("/{id}/advsend")
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded", "text/plain" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email with Advanced Options", description = "Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.", security = {
        @SecurityRequirement(name = "apiKeyAuth"),
@SecurityRequirement(name = "apiLoginAuth"),
@SecurityRequirement(name = "apiPasswordAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
        @ApiResponse(responseCode = "400", description = "bad input parameter"),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })
    public Response sendAdvMailById(
@Parameter(description = "" ,required=true) SendMail body
, 
@Parameter(description = "User ID",required=true) @PathParam("id") Long id
) {
        return delegate.sendAdvMailById(body, id, securityContext);
    }

    @POST
    @Path("/{id}/advsend")
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded", "text/plain" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email with Advanced Options", description = "Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.", security = {
        @SecurityRequirement(name = "apiKeyAuth"),
@SecurityRequirement(name = "apiLoginAuth"),
@SecurityRequirement(name = "apiPasswordAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
        @ApiResponse(responseCode = "400", description = "bad input parameter"),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })
    public Response sendAdvMailById(@Multipart(value = "id")  Long id2, 
@Parameter(description = "User ID",required=true) @PathParam("id") Long id
) {
        return delegate.sendAdvMailById(id2, id, securityContext);
    }

    @POST
    @Path("/{id}/advsend")
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded", "text/plain" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email with Advanced Options", description = "Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.", security = {
        @SecurityRequirement(name = "apiKeyAuth"),
@SecurityRequirement(name = "apiLoginAuth"),
@SecurityRequirement(name = "apiPasswordAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
        @ApiResponse(responseCode = "400", description = "bad input parameter"),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })
    public Response sendAdvMailById(
@Parameter(description = "" ,required=true) SendMail body
, 
@Parameter(description = "User ID",required=true) @PathParam("id") Long id
) {
        return delegate.sendAdvMailById(body, id, securityContext);
    }

    @POST
    @Path("/{id}/send")
    
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email", description = "Sends An email through one of your mail orders.", security = {
        @SecurityRequirement(name = "apiKeyAuth"),
@SecurityRequirement(name = "apiLoginAuth"),
@SecurityRequirement(name = "apiPasswordAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
        @ApiResponse(responseCode = "400", description = "bad input parameter"),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })
    public Response sendMailById(
@Parameter(description = "User ID",required=true) @PathParam("id") Long id
,  
@Parameter(description = "")  @QueryParam("subject") String subject
,  
@Parameter(description = "")  @QueryParam("body") String body
,  
@Parameter(description = "")  @QueryParam("to") String to
,  
@Parameter(description = "")  @QueryParam("toName") String toName
,  
@Parameter(description = "")  @QueryParam("from") String from
,  
@Parameter(description = "")  @QueryParam("fromName") String fromName
) {
        return delegate.sendMailById(id, subject, body, to, toName, from, fromName, securityContext);
    }

    @GET
    @Path("/order")
    
    @Produces({ "application/json" })
    @Operation(summary = "validatess order details before placing an order", description = "", security = {
        @SecurityRequirement(name = "apiKeyAuth"),
@SecurityRequirement(name = "apiLoginAuth"),
@SecurityRequirement(name = "apiPasswordAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "list of mail orders"),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })
    public Response validateMailOrder() {
        return delegate.validateMailOrder(securityContext);
    }

    @GET
    @Path("/{id}/log")
    
    @Produces({ "application/json" })
    @Operation(summary = "displays the mail log", description = "By passing in the appropriate options, you can search for available inventory in the system ", security = {
        @SecurityRequirement(name = "apiKeyAuth"),
@SecurityRequirement(name = "apiLoginAuth"),
@SecurityRequirement(name = "apiPasswordAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(array = @ArraySchema(schema = @Schema(implementation = MailLog.class)))),
        @ApiResponse(responseCode = "400", description = "bad input parameter") })
    public Response viewMailLogById(
@Parameter(description = "User ID",required=true) @PathParam("id") Long id
,  
@Parameter(description = "pass an optional search string for looking up inventory")  @QueryParam("searchString") String searchString
,  @Min(0) 
@Parameter(description = "number of records to skip for pagination", schema=@Schema(allowableValues={  })
)  @QueryParam("skip") Integer skip
,  @Min(0) @Max(50) 
@Parameter(description = "maximum number of records to return", schema=@Schema(allowableValues={  }, maximum="50")
)  @QueryParam("limit") Integer limit
) {
        return delegate.viewMailLogById(id, searchString, skip, limit, securityContext);
    }
}
