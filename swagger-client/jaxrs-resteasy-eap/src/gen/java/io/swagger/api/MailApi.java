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

import io.swagger.model.DenyRuleNew;
import io.swagger.model.DenyRuleRecord;
import io.swagger.model.EmailAddress;
import io.swagger.model.EmailAddressName;
import io.swagger.model.GenericResponse;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse401;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailBlocks;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;

import java.util.List;
import java.util.Map;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;
@Path("/mail")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2023-08-10T12:38:12.366705-04:00[America/New_York]")
public interface MailApi  {
   
    @POST
    @Path("/rules")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Creates a new email deny rule.", description = "Adds a new email deny rule into the system to block new emails that match the given criteria", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
                @ApiResponse(responseCode = "400", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class)))
         })
    Response addRule(@Parameter(description = "", required=true)@FormParam("user")  String user,@Parameter(description = "", required=true, schema=@Schema(allowableValues={ "domain", "email", "startswith" })
)@FormParam("type")  String type,@Parameter(description = "", required=true)@FormParam("data")  String data,@Context SecurityContext securityContext);

    @POST
    @Path("/rules")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Creates a new email deny rule.", description = "Adds a new email deny rule into the system to block new emails that match the given criteria", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
                @ApiResponse(responseCode = "400", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class)))
         })
    Response addRule(@Parameter(description = "These are the fields needed to create a new email deny rule." ,required=true) DenyRuleNew body,@Context SecurityContext securityContext);

    @DELETE
    @Path("/rules/{ruleId}")
    
    @Produces({ "application/json" })
    @Operation(summary = "Removes an deny mail rule.", description = "Removes one of the configured deny mail rules from the system.", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
                @ApiResponse(responseCode = "400", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class)))
         })
    Response deleteRule( @PathParam("ruleId") Integer ruleId,@Context SecurityContext securityContext);

    @POST
    @Path("/blocks/delete")
    @Consumes({ "application/json", "multipart/form-data" })
    @Produces({ "application/json" })
    @Operation(summary = "Removes an email address from the blocked list", description = "Removes an email address from the various block lists. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
                @ApiResponse(responseCode = "400", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class)))
         })
    Response delistBlock(@Parameter(description = "" ,required=true) EmailAddress body,@Context SecurityContext securityContext);

    @POST
    @Path("/blocks/delete")
    @Consumes({ "application/json", "multipart/form-data" })
    @Produces({ "application/json" })
    @Operation(summary = "Removes an email address from the blocked list", description = "Removes an email address from the various block lists. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
                @ApiResponse(responseCode = "400", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class)))
         })
    Response delistBlock(@Parameter(description = "", required=true)@FormParam("email")  String email,@Context SecurityContext securityContext);

    @GET
    @Path("/blocks")
    
    @Produces({ "application/json" })
    @Operation(summary = "displays a list of blocked email addresses", description = "", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MailBlocks.class))),
                @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "404", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class)))
         })
    Response getMailBlocks(@Context SecurityContext securityContext);

    @GET
    
    
    @Produces({ "application/json" })
    @Operation(summary = "displays a list of mail service orders", description = "This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Services" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MailOrder.class)))),
                @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "404", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class)))
         })
    Response getMailOrders(@Context SecurityContext securityContext);

    @GET
    @Path("/rules")
    
    @Produces({ "application/json" })
    @Operation(summary = "Displays a listing of deny email rules.", description = "Returns a listing of all the deny block rules you have configured.", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DenyRuleRecord.class)))),
                @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "404", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class)))
         })
    Response getRules(@Context SecurityContext securityContext);

    @GET
    @Path("/stats")
    
    @Produces({ "application/json" })
    @Operation(summary = "displays a list of blocked email addresses", description = "", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "History" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = InlineResponse200.class)))),
                @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "404", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class)))
         })
    Response getStats(@Context SecurityContext securityContext);

    @POST
    @Path("/advsend")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email with Advanced Options", description = "Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Sending" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
                @ApiResponse(responseCode = "400", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class)))
         })
    Response sendAdvMail(@Parameter(description = "", required=true)@FormParam("subject")  String subject,@Parameter(description = "", required=true)@FormParam("body")  String body,@Parameter(description = "", required=true)@FormParam("from")  EmailAddressName from,@Parameter(description = "", required=true)@FormParam("to")  List<EmailAddressName> to,@Parameter(description = "", required=true)@FormParam("replyto")  List<EmailAddressName> replyto,@Parameter(description = "", required=true)@FormParam("cc")  List<EmailAddressName> cc,@Parameter(description = "", required=true)@FormParam("bcc")  List<EmailAddressName> bcc,@Parameter(description = "", required=true)@FormParam("attachments")  List<MailAttachment> attachments,@Parameter(description = "", required=true)@FormParam("id")  Long id,@Context SecurityContext securityContext);

    @POST
    @Path("/advsend")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email with Advanced Options", description = "Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Sending" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
                @ApiResponse(responseCode = "400", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class)))
         })
    Response sendAdvMail(@Parameter(description = "" ,required=true) SendMailAdv body,@Context SecurityContext securityContext);

    @POST
    @Path("/send")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email", description = "Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Sending" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
                @ApiResponse(responseCode = "400", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class)))
         })
    Response sendMail(@Parameter(description = "", required=true)@FormParam("to")  String to,@Parameter(description = "", required=true)@FormParam("from")  String from,@Parameter(description = "", required=true)@FormParam("subject")  String subject,@Parameter(description = "", required=true)@FormParam("body")  String body,@Context SecurityContext securityContext);

    @POST
    @Path("/send")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email", description = "Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Sending" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
                @ApiResponse(responseCode = "400", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
                @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class)))
         })
    Response sendMail(@Parameter(description = "" ,required=true) SendMail body,@Context SecurityContext securityContext);

    @GET
    @Path("/log")
    
    @Produces({ "application/json" })
    @Operation(summary = "displays the mail log", description = "Get a listing of the emails sent through this system ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "History" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MailLog.class))),
                @ApiResponse(responseCode = "400", description = "bad input parameter")
         })
    Response viewMailLog( @QueryParam("id") Long id, @QueryParam("origin") String origin, @QueryParam("mx") String mx, @QueryParam("from") String from, @QueryParam("to") String to, @QueryParam("subject") String subject, @QueryParam("mailid") String mailid, @Min(0) @QueryParam("skip") Integer skip, @Min(1) @Max(10000) @QueryParam("limit") Integer limit, @Min(0) @Max(9999999999) @QueryParam("startDate") Long startDate, @Min(0) @Max(9999999999) @QueryParam("endDate") Long endDate,@Context SecurityContext securityContext);

}
