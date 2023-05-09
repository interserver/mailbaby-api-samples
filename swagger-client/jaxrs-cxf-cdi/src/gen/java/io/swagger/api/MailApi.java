package io.swagger.api;

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




@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJAXRSCXFCDIServerCodegen", date = "2023-05-09T00:51:32.660870-04:00[America/New_York]")

public class MailApi  {

  @Context SecurityContext securityContext;

  @Inject MailApiService delegate;


    @GET
    
    
    @Produces({ "application/json" })
    @Operation(summary = "displays a list of mail service orders", description = "", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = InlineResponse200.class)))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        @ApiResponse(responseCode = "404", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))) })
    public Response getMailOrders() {
        return delegate.getMailOrders(securityContext);
    }

    @POST
    @Path("/advsend")
    @Consumes({ "application/json", "application/x-www-form-urlencoded" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email with Advanced Options", description = "Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        @ApiResponse(responseCode = "400", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))) })
    public Response sendAdvMail(
@Parameter(description = "" ,required=true) SendMailAdv body
) {
        return delegate.sendAdvMail(body, securityContext);
    }

    @POST
    @Path("/advsend")
    @Consumes({ "application/json", "application/x-www-form-urlencoded" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email with Advanced Options", description = "Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        @ApiResponse(responseCode = "400", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))) })
    public Response sendAdvMail(@Multipart(value = "subject")  String subject, @Multipart(value = "body")  String body, @Multipart(value = "from")  SendMailAdvFrom from, @Multipart(value = "to")  List<SendMailAdvTo> to, @Multipart(value = "replyto")  List<SendMailAdvReplyto> replyto, @Multipart(value = "cc")  List<SendMailAdvCc> cc, @Multipart(value = "bcc")  List<SendMailAdvBcc> bcc, @Multipart(value = "attachments")  List<SendMailAdvAttachments> attachments, @Multipart(value = "id")  Long id) {
        return delegate.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id, securityContext);
    }

    @POST
    @Path("/send")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email", description = "Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        @ApiResponse(responseCode = "400", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))) })
    public Response sendMail(@Multipart(value = "to")  String to, @Multipart(value = "from")  String from, @Multipart(value = "subject")  String subject, @Multipart(value = "body")  String body) {
        return delegate.sendMail(to, from, subject, body, securityContext);
    }

    @POST
    @Path("/send")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email", description = "Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        @ApiResponse(responseCode = "400", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))) })
    public Response sendMail(
@Parameter(description = "" ,required=true) SendMail body
) {
        return delegate.sendMail(body, securityContext);
    }

    @GET
    @Path("/log")
    
    @Produces({ "application/json" })
    @Operation(summary = "displays the mail log", description = "Get a listing of the emails sent through this system ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MailLog.class))),
        @ApiResponse(responseCode = "400", description = "bad input parameter") })
    public Response viewMailLog( 
@Parameter(description = "The ID of your mail order this will be sent through.")  @QueryParam("id") Long id
,  
@Parameter(description = "originating ip address sending mail")  @QueryParam("origin") String origin
,  
@Parameter(description = "mx record mail was sent to")  @QueryParam("mx") String mx
,  
@Parameter(description = "from email address")  @QueryParam("from") String from
,  
@Parameter(description = "to/destination email address")  @QueryParam("to") String to
,  
@Parameter(description = "subject containing this string")  @QueryParam("subject") String subject
,  
@Parameter(description = "mail id")  @QueryParam("mailid") String mailid
,  @Min(0) 
@Parameter(description = "number of records to skip for pagination", schema=@Schema(allowableValues={  })
) @DefaultValue("0") @QueryParam("skip") Integer skip
,  @Min(1) @Max(10000) 
@Parameter(description = "maximum number of records to return", schema=@Schema(allowableValues={  }, minimum="1", maximum="10000")
) @DefaultValue("100") @QueryParam("limit") Integer limit
,  @Min(0L) @Max(9999999999L) 
@Parameter(description = "earliest date to get emails in unix timestamp format", schema=@Schema(allowableValues={  }, maximum="9999999999")
)  @QueryParam("startDate") Long startDate
,  @Min(0L) @Max(9999999999L) 
@Parameter(description = "earliest date to get emails in unix timestamp format", schema=@Schema(allowableValues={  }, maximum="9999999999")
)  @QueryParam("endDate") Long endDate
) {
        return delegate.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, securityContext);
    }
}
