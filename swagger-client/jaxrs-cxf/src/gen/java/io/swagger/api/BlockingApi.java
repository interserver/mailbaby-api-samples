package io.swagger.api;

import io.swagger.model.DenyRuleNew;
import io.swagger.model.DenyRuleRecord;
import io.swagger.model.ErrorMessage;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailBlocks;

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
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * MailBaby Email Delivery and Management Service API
 *
 * <p>**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 */
@Path("/")
public interface BlockingApi  {

    /**
     * Creates a new email deny rule.
     *
     * Adds a new email deny rule into the system to block new emails that match the given criteria
     *
     */
    @POST
    @Path("/mail/rules")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Creates a new email deny rule.", tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        @ApiResponse(responseCode = "400", description = "Error message when there was a problem with the input parameters.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public GenericResponse addRule(@Multipart(value = "user")  String user, @Multipart(value = "type")  String type, @Multipart(value = "data")  String data);

    /**
     * Creates a new email deny rule.
     *
     * Adds a new email deny rule into the system to block new emails that match the given criteria
     *
     */
    @POST
    @Path("/mail/rules")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Creates a new email deny rule.", tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        @ApiResponse(responseCode = "400", description = "Error message when there was a problem with the input parameters.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public GenericResponse addRule(@Valid DenyRuleNew body);

    /**
     * Removes an deny mail rule.
     *
     * Removes one of the configured deny mail rules from the system.
     *
     */
    @DELETE
    @Path("/mail/rules/{ruleId}")
    @Produces({ "application/json" })
    @Operation(summary = "Removes an deny mail rule.", tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        @ApiResponse(responseCode = "400", description = "Error message when there was a problem with the input parameters.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public GenericResponse deleteRule(@PathParam("ruleId") Integer ruleId);

    /**
     * Removes an email address from the blocked list
     *
     * Removes an email address from the various block lists. 
     *
     */
    @POST
    @Path("/mail/blocks/delete")
    @Consumes({ "application/json", "multipart/form-data" })
    @Produces({ "application/json" })
    @Operation(summary = "Removes an email address from the blocked list", tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        @ApiResponse(responseCode = "400", description = "Error message when there was a problem with the input parameters.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public GenericResponse delistBlock(@Valid String body);

    /**
     * displays a list of blocked email addresses
     *
     */
    @GET
    @Path("/mail/blocks")
    @Produces({ "application/json" })
    @Operation(summary = "displays a list of blocked email addresses", tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MailBlocks.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "404", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public MailBlocks getMailBlocks();

    /**
     * Displays a listing of deny email rules.
     *
     * Returns a listing of all the deny block rules you have configured.
     *
     */
    @GET
    @Path("/mail/rules")
    @Produces({ "application/json" })
    @Operation(summary = "Displays a listing of deny email rules.", tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DenyRuleRecord.class)))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "404", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public List<DenyRuleRecord> getRules();
}
