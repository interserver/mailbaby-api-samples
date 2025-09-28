package org.openapitools.api;

import org.openapitools.model.DenyRuleRecord;
import org.openapitools.model.ErrorMessage;
import org.openapitools.model.GenericResponse;
import org.openapitools.model.MailBlocks;

import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import org.apache.cxf.jaxrs.ext.multipart.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.jaxrs.PATCH;

/**
 * MailBaby Email Delivery and Management Service API
 *
 * <p>**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 */
@Path("/mail")
@Api(value = "/", description = "")
public interface BlockingApi  {

    /**
     * Creates a new email deny rule.
     *
     * Adds a new email deny rule into the system to block new emails that match the given criteria
     *
     */
    @POST
    @Path("/rules")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Creates a new email deny rule.", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = GenericResponse.class),
        @ApiResponse(code = 400, message = "Error message when there was a problem with the input parameters.", response = ErrorMessage.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = ErrorMessage.class),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = ErrorMessage.class) })
    public GenericResponse addRule(@Multipart(value = "type")  String type, @Multipart(value = "data")  String data, @Multipart(value = "user", required = false)  String user);

    /**
     * Removes an deny mail rule.
     *
     * Removes one of the configured deny mail rules from the system.
     *
     */
    @DELETE
    @Path("/rules/{ruleId}")
    @Produces({ "application/json" })
    @ApiOperation(value = "Removes an deny mail rule.", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = GenericResponse.class),
        @ApiResponse(code = 400, message = "Error message when there was a problem with the input parameters.", response = ErrorMessage.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = ErrorMessage.class),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = ErrorMessage.class) })
    public GenericResponse deleteRule(@PathParam("ruleId") Integer ruleId);

    /**
     * Removes an email address from the blocked list
     *
     * Removes an email address from the various block lists. 
     *
     */
    @POST
    @Path("/blocks/delete")
    @Consumes({ "application/json", "multipart/form-data" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Removes an email address from the blocked list", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = GenericResponse.class),
        @ApiResponse(code = 400, message = "Error message when there was a problem with the input parameters.", response = ErrorMessage.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = ErrorMessage.class),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = ErrorMessage.class) })
    public GenericResponse delistBlock(String body);

    /**
     * displays a list of blocked email addresses
     *
     */
    @GET
    @Path("/blocks")
    @Produces({ "application/json" })
    @ApiOperation(value = "displays a list of blocked email addresses", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = MailBlocks.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = ErrorMessage.class),
        @ApiResponse(code = 404, message = "Unauthorized", response = ErrorMessage.class) })
    public MailBlocks getMailBlocks();

    /**
     * Displays a listing of deny email rules.
     *
     * Returns a listing of all the deny block rules you have configured.
     *
     */
    @GET
    @Path("/rules")
    @Produces({ "application/json" })
    @ApiOperation(value = "Displays a listing of deny email rules.", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = DenyRuleRecord.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized", response = ErrorMessage.class),
        @ApiResponse(code = 404, message = "Unauthorized", response = ErrorMessage.class) })
    public List<DenyRuleRecord> getRules();
}
