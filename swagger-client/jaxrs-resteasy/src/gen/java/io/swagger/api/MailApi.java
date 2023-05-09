package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.MailApiService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.model.GenericResponse;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse401;
import io.swagger.model.MailLog;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;
import io.swagger.model.SendMailAdvAttachments;
import io.swagger.model.SendMailAdvBcc;
import io.swagger.model.SendMailAdvCc;
import io.swagger.model.SendMailAdvFrom;
import io.swagger.model.SendMailAdvReplyto;
import io.swagger.model.SendMailAdvTo;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.inject.Inject;

import javax.validation.constraints.*;
@Path("/mail")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyServerCodegen", date = "2023-05-09T00:51:44.319867-04:00[America/New_York]")
public class MailApi  {

    @Inject MailApiService service;

    @GET
    
    
    @Produces({ "application/json" })
    @Operation(summary = "displays a list of mail service orders", description = "", security = {
        @SecurityRequirement(name = "apiKeyAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = InlineResponse200.class)))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        
        @ApiResponse(responseCode = "404", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))) })
    public Response getMailOrders(@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getMailOrders(securityContext);
    }
    @POST
    @Path("/advsend")
    @Consumes({ "application/json", "application/x-www-form-urlencoded" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email with Advanced Options", description = "Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.", security = {
        @SecurityRequirement(name = "apiKeyAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))) })
    public Response sendAdvMail(@Parameter(description = "" ,required=true) SendMailAdv body,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.sendAdvMail(body,securityContext);
    }
    @POST
    @Path("/advsend")
    @Consumes({ "application/json", "application/x-www-form-urlencoded" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email with Advanced Options", description = "Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.", security = {
        @SecurityRequirement(name = "apiKeyAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))) })
    public Response sendAdvMail(@Parameter(description = "", required=true)@FormParam("subject")  String subject,@Parameter(description = "", required=true)@FormParam("body")  String body,@Parameter(description = "", required=true)@FormParam("from")  SendMailAdvFrom from,@Parameter(description = "", required=true)@FormParam("to")  List<SendMailAdvTo> to,@Parameter(description = "", required=true)@FormParam("replyto")  List<SendMailAdvReplyto> replyto,@Parameter(description = "", required=true)@FormParam("cc")  List<SendMailAdvCc> cc,@Parameter(description = "", required=true)@FormParam("bcc")  List<SendMailAdvBcc> bcc,@Parameter(description = "", required=true)@FormParam("attachments")  List<SendMailAdvAttachments> attachments,@Parameter(description = "", required=true)@FormParam("id")  Long id,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.sendAdvMail(subject,body,from,to,replyto,cc,bcc,attachments,id,securityContext);
    }
    @POST
    @Path("/send")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email", description = "Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))) })
    public Response sendMail(@Parameter(description = "", required=true)@FormParam("to")  String to,@Parameter(description = "", required=true)@FormParam("from")  String from,@Parameter(description = "", required=true)@FormParam("subject")  String subject,@Parameter(description = "", required=true)@FormParam("body")  String body,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.sendMail(to,from,subject,body,securityContext);
    }
    @POST
    @Path("/send")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email", description = "Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))) })
    public Response sendMail(@Parameter(description = "" ,required=true) SendMail body,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.sendMail(body,securityContext);
    }
    @GET
    @Path("/log")
    
    @Produces({ "application/json" })
    @Operation(summary = "displays the mail log", description = "Get a listing of the emails sent through this system ", security = {
        @SecurityRequirement(name = "apiKeyAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MailLog.class))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter") })
    public Response viewMailLog(  @QueryParam("id") Long id,  @QueryParam("origin") String origin,  @QueryParam("mx") String mx,  @QueryParam("from") String from,  @QueryParam("to") String to,  @QueryParam("subject") String subject,  @QueryParam("mailid") String mailid, @Min(0)  @DefaultValue("0") @QueryParam("skip") Integer skip, @Min(1) @Max(10000)  @DefaultValue("100") @QueryParam("limit") Integer limit, @Min(0L) @Max(9999999999L)  @QueryParam("startDate") Long startDate, @Min(0L) @Max(9999999999L)  @QueryParam("endDate") Long endDate,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.viewMailLog(id,origin,mx,from,to,subject,mailid,skip,limit,startDate,endDate,securityContext);
    }
}
