package io.swagger.api;

import io.swagger.model.ErrorMessage;
import io.swagger.model.MailLog;
import io.swagger.model.MailStatsType;

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
 * MailBaby Email Delivery and Management Service API
 *
 * <p>**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 */
@Path("/")
public interface HistoryApi  {

    /**
     * Account usage statistics.
     *
     * Returns information about the usage on your mail accounts.
     *
     */
    @GET
    @Path("/mail/stats")
    @Produces({ "application/json" })
    @Operation(summary = "Account usage statistics.", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MailStatsType.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "404", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public MailStatsType getStats(@QueryParam("time")String time);

    /**
     * displays the mail log
     *
     * Get a listing of the emails sent through this system 
     *
     */
    @GET
    @Path("/mail/log")
    @Produces({ "application/json" })
    @Operation(summary = "displays the mail log", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MailLog.class))),
        @ApiResponse(responseCode = "400", description = "bad input parameter") })
    public MailLog viewMailLog(@QueryParam("id")Long id, @QueryParam("origin")String origin, @QueryParam("mx")String mx, @QueryParam("from")String from, @QueryParam("to")String to, @QueryParam("subject")String subject, @QueryParam("mailid")String mailid, @QueryParam("skip")@DefaultValue("0") Integer skip, @QueryParam("limit")@DefaultValue("100") Integer limit, @QueryParam("startDate")Long startDate, @QueryParam("endDate")Long endDate, @QueryParam("replyto")String replyto, @QueryParam("headerfrom")String headerfrom, @QueryParam("delivered")String delivered);
}
