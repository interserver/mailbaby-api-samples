package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.MailApiService;
import io.swagger.api.factories.MailApiServiceFactory;

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
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailOrders;
import io.swagger.model.SendMail;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;


@Path("/mail")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-04T15:55:24.498290-04:00[America/New_York]")public class MailApi  {
   private final MailApiService delegate;

   public MailApi(@Context ServletConfig servletContext) {
      MailApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("MailApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (MailApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = MailApiServiceFactory.getMailApi();
      }

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
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email with Advanced Options", description = "Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public Response sendAdvMailById(@Parameter(in = ParameterIn.DEFAULT, description = "" ,required=true) SendMail body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendAdvMailById(body,securityContext);
    }
    @POST
    @Path("/send")
    
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email", description = "Sends An email through one of your mail orders.", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public Response sendMailById(@Parameter(in = ParameterIn.QUERY, description = "The Subject of the email") @QueryParam("subject") String subject
,@Parameter(in = ParameterIn.QUERY, description = "The contents of the email") @QueryParam("body") String body
,@Parameter(in = ParameterIn.QUERY, description = "The email address of who this email will be sent to.") @QueryParam("to") String to
,@Parameter(in = ParameterIn.QUERY, description = "The email address of who this email will be sent from.") @QueryParam("from") String from
,@Parameter(in = ParameterIn.QUERY, description = "The ID of your mail order this will be sent through.") @QueryParam("id") Long id
,@Parameter(in = ParameterIn.QUERY, description = "The name or title of who this email is being sent to.") @QueryParam("toName") String toName
,@Parameter(in = ParameterIn.QUERY, description = "The name or title of who this email is being sent from.") @QueryParam("fromName") String fromName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendMailById(subject,body,to,from,id,toName,fromName,securityContext);
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
