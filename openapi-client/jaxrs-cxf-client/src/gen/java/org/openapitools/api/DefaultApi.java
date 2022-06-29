package org.openapitools.api;

import org.openapitools.model.GenericResponse;
import org.openapitools.model.GetMailOrders200ResponseInner;
import org.openapitools.model.GetMailOrders401Response;
import org.openapitools.model.MailLog;
import org.openapitools.model.SendMailAdv;

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
 * MailBaby Email Delivery API
 *
 * <p>**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**   # 📌 Overview  This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).   # 🔐 Authentication  In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.    We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
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
    @Produces({ "application/json" })
    @ApiOperation(value = "displays a list of mail service orders", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = GetMailOrders200ResponseInner.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized", response = GetMailOrders401Response.class),
        @ApiResponse(code = 404, message = "Unauthorized", response = GetMailOrders401Response.class) })
    public List<GetMailOrders200ResponseInner> getMailOrders();

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
     * Sends an Email with Advanced Options
     *
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     *
     */
    @POST
    @Path("/mail/advsend")
    @Consumes({ "application/json", "application/x-www-form-urlencoded" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Sends an Email with Advanced Options", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = GenericResponse.class),
        @ApiResponse(code = 400, message = "The specified resource was not found", response = GetMailOrders401Response.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = GetMailOrders401Response.class),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = GetMailOrders401Response.class) })
    public GenericResponse sendAdvMail(SendMailAdv sendMailAdv);

    /**
     * Sends an Email
     *
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     *
     */
    @POST
    @Path("/mail/send")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Sends an Email", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = GenericResponse.class),
        @ApiResponse(code = 400, message = "The specified resource was not found", response = GetMailOrders401Response.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = GetMailOrders401Response.class),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = GetMailOrders401Response.class) })
    public GenericResponse sendMail(@Multipart(value = "to")  String to, @Multipart(value = "from")  String from, @Multipart(value = "subject")  String subject, @Multipart(value = "body")  String body);

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
        @ApiResponse(code = 200, message = "search results matching criteria", response = MailLog.class),
        @ApiResponse(code = 400, message = "bad input parameter") })
    public MailLog viewMailLog(@QueryParam("id") Long id, @QueryParam("search") String search, @QueryParam("skip") @DefaultValue("0")Integer skip, @QueryParam("limit") @DefaultValue("100")Integer limit);
}
