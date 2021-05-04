package org.openapitools.api;

import org.openapitools.model.ErrorResponse;
import org.openapitools.model.GenericResponse;
import org.openapitools.model.MailLog;
import org.openapitools.model.MailOrder;
import org.openapitools.model.SendMail;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.ext.multipart.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.jaxrs.PATCH;

/**
 * Mail Baby API
 *
 * <p>This is an API defintion for accesssing the Mail.Baby mail service.
 *
 */
@Path("")
@Api(value = "/", description = "")
public interface DefaultApi  {

    /**
     * displays a list of mail service orders
     *
     */
    @GET
    @Path("/mail")
    @Produces({ "application/json", "application/xml", "text/plain" })
    @ApiOperation(value = "displays a list of mail service orders", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = MailOrder.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class) })
    public List<MailOrder> getMailOrders(@QueryParam("id") Long id);

    /**
     * Checks if the server is running
     *
     */
    @GET
    @Path("/ping")
    @ApiOperation(value = "Checks if the server is running", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Server is up and running"),
        @ApiResponse(code = 200, message = "Something is wrong") })
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
    @ApiOperation(value = "places a mail order", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "list of mail orders"),
        @ApiResponse(code = 400, message = "invalid input, object invalid"),
        @ApiResponse(code = 409, message = "an existing item already exists"),
        @ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class) })
    public void placeMailOrder(MailOrder mailOrder);

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
    @ApiOperation(value = "Sends an Email with Advanced Options", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = GenericResponse.class),
        @ApiResponse(code = 400, message = "bad input parameter"),
        @ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = ErrorResponse.class) })
    public GenericResponse sendAdvMailById(SendMail sendMail);

    /**
     * Sends an Email
     *
     * Sends An email through one of your mail orders.
     *
     */
    @POST
    @Path("/mail/send")
    @Produces({ "application/json" })
    @ApiOperation(value = "Sends an Email", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = GenericResponse.class),
        @ApiResponse(code = 400, message = "bad input parameter"),
        @ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = ErrorResponse.class) })
    public GenericResponse sendMailById(@QueryParam("subject") String subject, @QueryParam("body") String body, @QueryParam("to") String to, @QueryParam("from") String from, @QueryParam("id") Long id, @QueryParam("toName") String toName, @QueryParam("fromName") String fromName);

    /**
     * validatess order details before placing an order
     *
     */
    @GET
    @Path("/mail/order")
    @Produces({ "application/json" })
    @ApiOperation(value = "validatess order details before placing an order", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "list of mail orders"),
        @ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class) })
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
    @ApiOperation(value = "displays the mail log", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = MailLog.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad input parameter") })
    public List<MailLog> viewMailLogById(@QueryParam("id") Long id, @QueryParam("searchString") String searchString, @QueryParam("skip") Integer skip, @QueryParam("limit") Integer limit);
}

