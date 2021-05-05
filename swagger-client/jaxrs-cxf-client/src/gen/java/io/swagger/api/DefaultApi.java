package io.swagger.api;

import io.swagger.model.ErrorResponse;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailContact;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailOrders;
import io.swagger.model.SendMail;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.ext.multipart.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Mail Baby API
 *
 * <p>This is an API defintion for accesssing the Mail.Baby mail service.
 *
 */
@Path("/")
public interface DefaultApi  {

    /**
     * displays a list of mail service orders
     *
     */
    @GET
    @Path("/mail")
    @Produces({ "application/json", "application/xml", "text/plain" })
    @Operation(summary = "displays a list of mail service orders", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MailOrders.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public MailOrders getMailOrders(@QueryParam("id")Long id);

    /**
     * Checks if the server is running
     *
     */
    @GET
    @Path("/ping")
    @Operation(summary = "Checks if the server is running", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Server is up and running"),
        @ApiResponse(responseCode = "200", description = "Something is wrong") })
    public void pingServer();

    /**
     * places a mail order
     *
     * Adds an item to the system
     *
     */
    @POST
    @Path("/mail/order")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "places a mail order", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "list of mail orders"),
        @ApiResponse(responseCode = "400", description = "invalid input, object invalid"),
        @ApiResponse(responseCode = "409", description = "an existing item already exists"),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public void placeMailOrder(MailOrder body);

    /**
     * Sends an Email with Advanced Options
     *
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     *
     */
    @POST
    @Path("/mail/advsend")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email with Advanced Options", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        @ApiResponse(responseCode = "400", description = "bad input parameter"),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public GenericResponse sendAdvMailById(SendMail body);

    /**
     * Sends an Email
     *
     * Sends An email through one of your mail orders.
     *
     */
    @POST
    @Path("/mail/send")
    @Consumes({ "application/json", "application/x-www-form-urlencoded" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        @ApiResponse(responseCode = "400", description = "bad input parameter"),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public GenericResponse sendMailById(SendMail body);

    /**
     * Sends an Email
     *
     * Sends An email through one of your mail orders.
     *
     */
    @POST
    @Path("/mail/send")
    @Consumes({ "application/json", "application/x-www-form-urlencoded" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        @ApiResponse(responseCode = "400", description = "bad input parameter"),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public GenericResponse sendMailById(@Multipart(value = "subject")  String subject, @Multipart(value = "body")  String body, @Multipart(value = "from")  MailContact from, @Multipart(value = "to")  List<MailContact> to, @Multipart(value = "id")  Long id, @Multipart(value = "replyto")  List<MailContact> replyto, @Multipart(value = "cc")  List<MailContact> cc, @Multipart(value = "bcc")  List<MailContact> bcc, @Multipart(value = "attachments")  List<MailAttachment> attachments);

    /**
     * validatess order details before placing an order
     *
     */
    @GET
    @Path("/mail/order")
    @Produces({ "application/json" })
    @Operation(summary = "validatess order details before placing an order", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "list of mail orders"),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public void validateMailOrder();

    /**
     * displays the mail log
     *
     * By passing in the appropriate options, you can search for available inventory in the system 
     *
     */
    @GET
    @Path("/mail/log")
    @Produces({ "application/json" })
    @Operation(summary = "displays the mail log", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MailLog.class)))),
        @ApiResponse(responseCode = "400", description = "bad input parameter") })
    public List<MailLog> viewMailLogById(@QueryParam("id")Long id, @QueryParam("searchString")String searchString, @QueryParam("skip")Integer skip, @QueryParam("limit")Integer limit);
}
