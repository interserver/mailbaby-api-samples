package org.openapitools.api;

import org.openapitools.model.EmailAddressName;
import org.openapitools.model.GenericResponse;
import org.openapitools.model.GetMailOrders401Response;
import org.openapitools.model.MailAttachment;

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
 * MailBaby Email Delivery and Management Service API
 *
 * <p>**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 */
@Path("/mail")
@Api(value = "/", description = "")
public interface SendingApi  {

    /**
     * Sends an Email with Advanced Options
     *
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     *
     */
    @POST
    @Path("/advsend")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Sends an Email with Advanced Options", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = GenericResponse.class),
        @ApiResponse(code = 400, message = "The specified resource was not found", response = GetMailOrders401Response.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = GetMailOrders401Response.class),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = GetMailOrders401Response.class) })
    public GenericResponse sendAdvMail(@Multipart(value = "subject")  String subject, @Multipart(value = "body")  String body, @Multipart(value = "from")  EmailAddressName from, @Multipart(value = "to")  List<EmailAddressName> to, @Multipart(value = "replyto", required = false)  List<EmailAddressName> replyto, @Multipart(value = "cc", required = false)  List<EmailAddressName> cc, @Multipart(value = "bcc", required = false)  List<EmailAddressName> bcc, @Multipart(value = "attachments", required = false)  List<MailAttachment> attachments, @Multipart(value = "id", required = false)  Long id);

    /**
     * Sends an Email
     *
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     *
     */
    @POST
    @Path("/send")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Sends an Email", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = GenericResponse.class),
        @ApiResponse(code = 400, message = "The specified resource was not found", response = GetMailOrders401Response.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = GetMailOrders401Response.class),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = GetMailOrders401Response.class) })
    public GenericResponse sendMail(@Multipart(value = "to")  String to, @Multipart(value = "from")  String from, @Multipart(value = "subject")  String subject, @Multipart(value = "body")  String body);
}
