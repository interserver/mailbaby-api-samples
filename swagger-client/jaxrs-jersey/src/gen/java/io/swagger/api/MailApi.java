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

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;


@Path("/mail")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2023-01-10T22:49:59.262341-05:00[America/New_York]")public class MailApi  {
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
    
    
    @Produces({ "application/json" })
    @Operation(summary = "displays a list of mail service orders", description = "", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = InlineResponse200.class)))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        
        @ApiResponse(responseCode = "404", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))) })
    public Response getMailOrders(@Context SecurityContext securityContext)
    throws NotFoundException {
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
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))) })
    public Response sendMail(@Parameter(description = "", required=true)  @FormParam("to")  String to
,@Parameter(description = "", required=true)  @FormParam("from")  String from
,@Parameter(description = "", required=true)  @FormParam("subject")  String subject
,@Parameter(description = "", required=true)  @FormParam("body")  String body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendMail(to,from,subject,body,securityContext);
    }
    @GET
    @Path("/log")
    
    @Produces({ "application/json" })
    @Operation(summary = "displays the mail log", description = "Get a listing of the emails sent through this system ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MailLog.class))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter") })
    public Response viewMailLog(@Parameter(in = ParameterIn.QUERY, description = "The ID of your mail order this will be sent through.") @QueryParam("id") Long id
,@Parameter(in = ParameterIn.QUERY, description = "originating ip address sending mail") @QueryParam("origin") String origin
,@Parameter(in = ParameterIn.QUERY, description = "mx record mail was sent to") @QueryParam("mx") String mx
,@Parameter(in = ParameterIn.QUERY, description = "from email address") @QueryParam("from") String from
,@Parameter(in = ParameterIn.QUERY, description = "to/destination email address") @QueryParam("to") String to
,@Parameter(in = ParameterIn.QUERY, description = "subject containing this string") @QueryParam("subject") String subject
,@Parameter(in = ParameterIn.QUERY, description = "mail id") @QueryParam("mailid") String mailid
,@Parameter(in = ParameterIn.QUERY, description = "number of records to skip for pagination", schema=@Schema(allowableValues={  })
) @DefaultValue("0") @QueryParam("skip") Integer skip
,@Parameter(in = ParameterIn.QUERY, description = "maximum number of records to return", schema=@Schema(allowableValues={  }, minimum="1", maximum="10000")
) @DefaultValue("100") @QueryParam("limit") Integer limit
,@Parameter(in = ParameterIn.QUERY, description = "earliest date to get emails in unix timestamp format", schema=@Schema(allowableValues={  }, maximum="9999999999")
) @QueryParam("startDate") Long startDate
,@Parameter(in = ParameterIn.QUERY, description = "earliest date to get emails in unix timestamp format", schema=@Schema(allowableValues={  }, maximum="9999999999")
) @QueryParam("endDate") Long endDate
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.viewMailLog(id,origin,mx,from,to,subject,mailid,skip,limit,startDate,endDate,securityContext);
    }
}
