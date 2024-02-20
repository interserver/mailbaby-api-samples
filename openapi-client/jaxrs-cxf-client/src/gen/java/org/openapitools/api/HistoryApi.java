package org.openapitools.api;

import org.openapitools.model.ErrorMessage;
import org.openapitools.model.GetStats200ResponseInner;
import org.openapitools.model.MailLog;

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
public interface HistoryApi  {

    /**
     * Account usage statistics.
     *
     * Returns information about the usage on your mail accounts.
     *
     */
    @GET
    @Path("/stats")
    @Produces({ "application/json" })
    @ApiOperation(value = "Account usage statistics.", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = GetStats200ResponseInner.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized", response = ErrorMessage.class),
        @ApiResponse(code = 404, message = "Unauthorized", response = ErrorMessage.class) })
    public List<GetStats200ResponseInner> getStats();

    /**
     * displays the mail log
     *
     * Get a listing of the emails sent through this system 
     *
     */
    @GET
    @Path("/log")
    @Produces({ "application/json" })
    @ApiOperation(value = "displays the mail log", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = MailLog.class),
        @ApiResponse(code = 400, message = "bad input parameter") })
    public MailLog viewMailLog(@QueryParam("id") Long id, @QueryParam("origin") String origin, @QueryParam("mx") String mx, @QueryParam("from") String from, @QueryParam("to") String to, @QueryParam("subject") String subject, @QueryParam("mailid") String mailid, @QueryParam("skip") @DefaultValue("0")Integer skip, @QueryParam("limit") @DefaultValue("100")Integer limit, @QueryParam("startDate") Long startDate, @QueryParam("endDate") Long endDate);
}
