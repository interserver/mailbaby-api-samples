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

import io.swagger.model.DenyRuleNew;
import io.swagger.model.DenyRuleRecord;
import io.swagger.model.EmailAddressTypes;
import io.swagger.model.EmailAddressesTypes;
import io.swagger.model.ErrorMessage;
import io.swagger.model.GenericResponse;
import io.swagger.model.InlineResponse200;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailBlocks;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;

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


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyDIServerCodegen", date = "2024-02-20T06:54:30.505529-05:00[America/New_York]")
public class MailApi  {

   private MailApiService delegate;

   protected MailApi() {
   }

   @javax.inject.Inject
   public MailApi(MailApiService delegate) {
      this.delegate = delegate;
   }

    @POST
    @Path("/rules")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Creates a new email deny rule.", description = "Adds a new email deny rule into the system to block new emails that match the given criteria", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Error message when there was a problem with the input parameters.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response addRule(@Parameter(description = "", required=true)  @FormParam("user")  String user,@Parameter(description = "", required=true, schema=@Schema(allowableValues={ "domain", "email", "startswith", "destination" })
)  @FormParam("type")  String type,@Parameter(description = "", required=true)  @FormParam("data")  String data,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addRule(user,type,data,securityContext);
    }
    @POST
    @Path("/rules")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Creates a new email deny rule.", description = "Adds a new email deny rule into the system to block new emails that match the given criteria", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Error message when there was a problem with the input parameters.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response addRule(@Parameter(in = ParameterIn.DEFAULT, description = "These are the fields needed to create a new email deny rule." ,required=true) DenyRuleNew body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addRule(body,securityContext);
    }
    @DELETE
    @Path("/rules/{ruleId}")
    
    @Produces({ "application/json" })
    @Operation(summary = "Removes an deny mail rule.", description = "Removes one of the configured deny mail rules from the system.", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Error message when there was a problem with the input parameters.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response deleteRule(@Parameter(in = ParameterIn.PATH, description = "The ID of the Rules entry.",required=true) @PathParam("ruleId") Integer ruleId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteRule(ruleId,securityContext);
    }
    @POST
    @Path("/blocks/delete")
    @Consumes({ "application/json", "multipart/form-data" })
    @Produces({ "application/json" })
    @Operation(summary = "Removes an email address from the blocked list", description = "Removes an email address from the various block lists. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Error message when there was a problem with the input parameters.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response delistBlock(@Parameter(in = ParameterIn.DEFAULT, description = "" ,required=true) String body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.delistBlock(body,securityContext);
    }
    @GET
    @Path("/blocks")
    
    @Produces({ "application/json" })
    @Operation(summary = "displays a list of blocked email addresses", description = "", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MailBlocks.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response getMailBlocks(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getMailBlocks(securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @Operation(summary = "displays a list of mail service orders", description = "This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Services" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MailOrder.class)))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response getMailOrders(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getMailOrders(securityContext);
    }
    @GET
    @Path("/rules")
    
    @Produces({ "application/json" })
    @Operation(summary = "Displays a listing of deny email rules.", description = "Returns a listing of all the deny block rules you have configured.", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DenyRuleRecord.class)))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response getRules(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getRules(securityContext);
    }
    @GET
    @Path("/stats")
    
    @Produces({ "application/json" })
    @Operation(summary = "Account usage statistics.", description = "Returns information about the usage on your mail accounts.", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "History" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = InlineResponse200.class)))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response getStats(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getStats(securityContext);
    }
    @POST
    @Path("/advsend")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email with Advanced Options", description = "Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }' ``` ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Sending" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Error message when there was a problem with the input parameters.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response sendAdvMail(@Parameter(description = "", required=true)  @FormParam("subject")  String subject,@Parameter(description = "", required=true)  @FormParam("body")  String body,@Parameter(description = "", required=true)  @FormParam("from")  EmailAddressTypes from,@Parameter(description = "", required=true)  @FormParam("to")  EmailAddressesTypes to,@Parameter(description = "", required=true)  @FormParam("replyto")  EmailAddressesTypes replyto,@Parameter(description = "", required=true)  @FormParam("cc")  EmailAddressesTypes cc,@Parameter(description = "", required=true)  @FormParam("bcc")  EmailAddressesTypes bcc,@Parameter(description = "", required=true)  @FormParam("attachments")  List<MailAttachment> attachments,@Parameter(description = "", required=true)  @FormParam("id")  Long id,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendAdvMail(subject,body,from,to,replyto,cc,bcc,attachments,id,securityContext);
    }
    @POST
    @Path("/advsend")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email with Advanced Options", description = "Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }' ``` ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Sending" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Error message when there was a problem with the input parameters.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response sendAdvMail(@Parameter(in = ParameterIn.DEFAULT, description = "" ,required=true) SendMailAdv body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendAdvMail(body,securityContext);
    }
    @POST
    @Path("/send")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email", description = "Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Sending" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Error message when there was a problem with the input parameters.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response sendMail(@Parameter(description = "", required=true)  @FormParam("to")  String to,@Parameter(description = "", required=true)  @FormParam("from")  String from,@Parameter(description = "", required=true)  @FormParam("subject")  String subject,@Parameter(description = "", required=true)  @FormParam("body")  String body,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendMail(to,from,subject,body,securityContext);
    }
    @POST
    @Path("/send")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email", description = "Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Sending" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Error message when there was a problem with the input parameters.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response sendMail(@Parameter(in = ParameterIn.DEFAULT, description = "" ,required=true) SendMail body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendMail(body,securityContext);
    }
    @GET
    @Path("/log")
    
    @Produces({ "application/json" })
    @Operation(summary = "displays the mail log", description = "Get a listing of the emails sent through this system ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "History" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MailLog.class))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter") })
    public Response viewMailLog(@Parameter(in = ParameterIn.QUERY, description = "The ID of your mail order this will be sent through.") @QueryParam("id") Long id,@Parameter(in = ParameterIn.QUERY, description = "originating ip address sending mail") @QueryParam("origin") String origin,@Parameter(in = ParameterIn.QUERY, description = "mx record mail was sent to") @QueryParam("mx") String mx,@Parameter(in = ParameterIn.QUERY, description = "from email address") @QueryParam("from") String from,@Parameter(in = ParameterIn.QUERY, description = "to/destination email address") @QueryParam("to") String to,@Parameter(in = ParameterIn.QUERY, description = "subject containing this string") @QueryParam("subject") String subject,@Parameter(in = ParameterIn.QUERY, description = "mail id") @QueryParam("mailid") String mailid,@Parameter(in = ParameterIn.QUERY, description = "number of records to skip for pagination", schema=@Schema(allowableValues={  })
) @DefaultValue("0") @QueryParam("skip") Integer skip,@Parameter(in = ParameterIn.QUERY, description = "maximum number of records to return", schema=@Schema(allowableValues={  }, minimum="1", maximum="10000")
) @DefaultValue("100") @QueryParam("limit") Integer limit,@Parameter(in = ParameterIn.QUERY, description = "earliest date to get emails in unix timestamp format", schema=@Schema(allowableValues={  }, maximum="9999999999")
) @QueryParam("startDate") Long startDate,@Parameter(in = ParameterIn.QUERY, description = "earliest date to get emails in unix timestamp format", schema=@Schema(allowableValues={  }, maximum="9999999999")
) @QueryParam("endDate") Long endDate,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.viewMailLog(id,origin,mx,from,to,subject,mailid,skip,limit,startDate,endDate,securityContext);
    }
}
