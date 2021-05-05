package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.MailApiService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.model.ErrorResponse;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailContact;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailOrders;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;
import io.swagger.model.SendMailAdvFrom;

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

@Path("/mail")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyDIServerCodegen", date = "2021-05-05T08:03:49.418617-04:00[America/New_York]")public class MailApi  {

   private MailApiService delegate;

   protected MailApi() {
   }

   @javax.inject.Inject
   public MailApi(MailApiService delegate) {
      this.delegate = delegate;
   }

    @GET
    
    
    @Produces({ "application/json", "application/xml", "text/plain" })
    @Operation(summary = "displays a list of mail service orders", description = "", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MailOrders.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public Response getMailOrders(@Parameter(in = ParameterIn.QUERY, description = "The ID of your mail order this will be sent through.") @QueryParam("id") Long id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getMailOrders(id,securityContext);
    }
    @POST
    @Path("/order")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "places a mail order", description = "Adds an item to the system", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "list of mail orders"),
        
        @ApiResponse(responseCode = "400", description = "invalid input, object invalid"),
        
        @ApiResponse(responseCode = "409", description = "an existing item already exists"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public Response placeMailOrder(@Parameter(in = ParameterIn.DEFAULT, description = "Inventory item to add" ) MailOrder body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.placeMailOrder(body,securityContext);
    }
    @POST
    @Path("/advsend")
    @Consumes({ "application/json", "application/x-www-form-urlencoded" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email with Advanced Options", description = "Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public Response sendAdvMail(@Parameter(in = ParameterIn.DEFAULT, description = "" ,required=true) SendMailAdv body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendAdvMail(body,securityContext);
    }
    @POST
    @Path("/advsend")
    @Consumes({ "application/json", "application/x-www-form-urlencoded" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email with Advanced Options", description = "Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public Response sendAdvMail(@Parameter(description = "", required=true)  @FormParam("subject")  String subject
,@Parameter(description = "", required=true)  @FormParam("body")  String body
,@Parameter(description = "", required=true)  @FormParam("from")  List<SendMailAdvFrom> from
,@Parameter(description = "", required=true)  @FormParam("to")  List<MailContact> to
,@Parameter(description = "", required=true)  @FormParam("id")  Long id
,@Parameter(description = "", required=true)  @FormParam("replyto")  List<MailContact> replyto
,@Parameter(description = "", required=true)  @FormParam("cc")  List<MailContact> cc
,@Parameter(description = "", required=true)  @FormParam("bcc")  List<MailContact> bcc
,@Parameter(description = "", required=true)  @FormParam("attachments")  List<MailAttachment> attachments
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendAdvMail(subject,body,from,to,id,replyto,cc,bcc,attachments,securityContext);
    }
    @POST
    @Path("/send")
    @Consumes({ "application/json", "application/x-www-form-urlencoded" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email", description = "Sends An email through one of your mail orders.", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public Response sendMail(@Parameter(in = ParameterIn.DEFAULT, description = "" ,required=true) SendMail body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendMail(body,securityContext);
    }
    @POST
    @Path("/send")
    @Consumes({ "application/json", "application/x-www-form-urlencoded" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email", description = "Sends An email through one of your mail orders.", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public Response sendMail(@Parameter(description = "", required=true)  @FormParam("to")  String to
,@Parameter(description = "", required=true)  @FormParam("from")  String from
,@Parameter(description = "", required=true)  @FormParam("subject")  String subject
,@Parameter(description = "", required=true)  @FormParam("body")  String body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendMail(to,from,subject,body,securityContext);
    }
    @GET
    @Path("/order")
    
    @Produces({ "application/json" })
    @Operation(summary = "validatess order details before placing an order", description = "", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "list of mail orders"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public Response validateMailOrder(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.validateMailOrder(securityContext);
    }
    @GET
    @Path("/log")
    
    @Produces({ "application/json" })
    @Operation(summary = "displays the mail log", description = "By passing in the appropriate options, you can search for available inventory in the system ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MailLog.class)))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter") })
    public Response viewMailLogById(@Parameter(in = ParameterIn.QUERY, description = "The ID of your mail order this will be sent through.") @QueryParam("id") Long id
,@Parameter(in = ParameterIn.QUERY, description = "pass an optional search string for looking up inventory") @QueryParam("searchString") String searchString
,@Parameter(in = ParameterIn.QUERY, description = "number of records to skip for pagination", schema=@Schema(allowableValues={  })
) @QueryParam("skip") Integer skip
,@Parameter(in = ParameterIn.QUERY, description = "maximum number of records to return", schema=@Schema(allowableValues={  }, maximum="50")
) @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.viewMailLogById(id,searchString,skip,limit,securityContext);
    }
}
