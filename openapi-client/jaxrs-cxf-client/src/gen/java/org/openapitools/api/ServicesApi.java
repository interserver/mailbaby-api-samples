package org.openapitools.api;

import org.openapitools.model.GetMailOrders401Response;
import org.openapitools.model.MailOrder;

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
public interface ServicesApi  {

    /**
     * displays a list of mail service orders
     *
     * This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
     *
     */
    @GET
    
    @Produces({ "application/json" })
    @ApiOperation(value = "displays a list of mail service orders", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = MailOrder.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized", response = GetMailOrders401Response.class),
        @ApiResponse(code = 404, message = "Unauthorized", response = GetMailOrders401Response.class) })
    public List<MailOrder> getMailOrders();
}
