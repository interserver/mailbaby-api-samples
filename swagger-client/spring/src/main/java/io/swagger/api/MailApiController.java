package io.swagger.api;

import io.swagger.model.DenyRuleNew;
import io.swagger.model.DenyRuleRecord;
import io.swagger.model.EmailAddressTypes;
import io.swagger.model.EmailAddressesTypes;
import io.swagger.model.ErrorMessage;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailBlocks;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailStatsType;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;
import io.swagger.model.SendMailRaw;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2026-01-21T17:25:50.770732117-05:00[America/New_York]")
@RestController
public class MailApiController implements MailApi {

    private static final Logger log = LoggerFactory.getLogger(MailApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public MailApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<GenericResponse> addRule(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="user", required=true)  String user
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema(allowableValues={ "domain", "email", "startswith", "destination" }
)) @RequestParam(value="type", required=true)  String type
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="data", required=true)  String data
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GenericResponse>(objectMapper.readValue("{\n  \"text\" : \"The command completed successfully.\",\n  \"status\" : \"ok\"\n}", GenericResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GenericResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GenericResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GenericResponse> deleteRule(@Parameter(in = ParameterIn.PATH, description = "The ID of the Rules entry.", required=true, schema=@Schema()) @PathVariable("ruleId") Integer ruleId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GenericResponse>(objectMapper.readValue("{\n  \"text\" : \"The command completed successfully.\",\n  \"status\" : \"ok\"\n}", GenericResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GenericResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GenericResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GenericResponse> delistBlock(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody String body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GenericResponse>(objectMapper.readValue("{\n  \"text\" : \"The command completed successfully.\",\n  \"status\" : \"ok\"\n}", GenericResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GenericResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GenericResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<MailBlocks> getMailBlocks() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<MailBlocks>(objectMapper.readValue("{\n  \"local\" : [ {\n    \"date\" : \"2023-08-07\",\n    \"from\" : \"user@domain.com\",\n    \"messageId\" : \"pFaRqFUEWkucjhTuIzYuoAgWU@domain.com\",\n    \"subject\" : \"Test Email\",\n    \"to\" : \"['client@site.com']\"\n  } ],\n  \"mbtrap\" : [ {\n    \"date\" : \"2023-08-07\",\n    \"from\" : \"user@domain.com\",\n    \"messageId\" : \"pFaRqFUEWkucjhTuIzYuoAgWU@domain.com\",\n    \"subject\" : \"Test Email\",\n    \"to\" : \"['client@site.com']\"\n  } ],\n  \"subject\" : [ {\n    \"from\" : \"user@domain.com\",\n    \"subject\" : \"Test Email\"\n  } ]\n}", MailBlocks.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<MailBlocks>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<MailBlocks>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<MailOrder>> getMailOrders() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<MailOrder>>(objectMapper.readValue("[ {\n  \"id\" : 21472,\n  \"status\" : \"active\",\n  \"username\" : \"mb21472\"\n}, {\n  \"id\" : 21472,\n  \"status\" : \"active\",\n  \"username\" : \"mb21472\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<MailOrder>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<MailOrder>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<DenyRuleRecord>> getRules() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<DenyRuleRecord>>(objectMapper.readValue("[ {\n  \"id\" : 14,\n  \"user\" : \"mb20682\",\n  \"type\" : \"email\",\n  \"data\" : \"domeinwo@server.guesshost.net\",\n  \"created\" : \"2022-03-22 19:16:35\"\n}, {\n  \"id\" : 14,\n  \"user\" : \"mb20682\",\n  \"type\" : \"email\",\n  \"data\" : \"domeinwo@server.guesshost.net\",\n  \"created\" : \"2022-03-22 19:16:35\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<DenyRuleRecord>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<DenyRuleRecord>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<MailStatsType> getStats(@Parameter(in = ParameterIn.QUERY, description = "The timeframe for the statistics." ,schema=@Schema(allowableValues={ "all", "billing", "month", "7d", "24h", "1d", "1h" }
)) @Valid @RequestParam(value = "time", required = false) String time
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<MailStatsType>(objectMapper.readValue("{\n  \"time\" : \"all\",\n  \"usage\" : 55,\n  \"currency\" : \"USD\",\n  \"currencySymbol\" : \"$\",\n  \"cost\" : 1.02,\n  \"received\" : 508,\n  \"sent\" : 495,\n  \"volume\" : {\n    \"to\" : {\n      \"client@domain.com\" : 395,\n      \"user@site.net\" : 57,\n      \"sales@company.com\" : 47,\n      \"client@anothersite.com\" : 9\n    },\n    \"from\" : {\n      \"billing@somedomain.com\" : 369,\n      \"sales@somedomain.com\" : 139\n    },\n    \"ip\" : {\n      \"1.1.1.1\" : 142,\n      \"2.2.2.2\" : 132,\n      \"3.3.3.3\" : 129,\n      \"4.4.4.4\" : 105\n    }\n  }\n}", MailStatsType.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<MailStatsType>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<MailStatsType>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GenericResponse> rawMail(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody SendMailRaw body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GenericResponse>(objectMapper.readValue("{\n  \"text\" : \"The command completed successfully.\",\n  \"status\" : \"ok\"\n}", GenericResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GenericResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GenericResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GenericResponse> sendAdvMail(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="subject", required=true)  String subject
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="body", required=true)  String body
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="from", required=true)  EmailAddressTypes from
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="to", required=true)  EmailAddressesTypes to
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="replyto", required=true)  EmailAddressesTypes replyto
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="cc", required=true)  EmailAddressesTypes cc
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="bcc", required=true)  EmailAddressesTypes bcc
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="attachments", required=true)  List<MailAttachment> attachments
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="id", required=true)  Long id
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GenericResponse>(objectMapper.readValue("{\n  \"text\" : \"The command completed successfully.\",\n  \"status\" : \"ok\"\n}", GenericResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GenericResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GenericResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GenericResponse> sendMail(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="to", required=true)  String to
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="from", required=true)  String from
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="subject", required=true)  String subject
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="body", required=true)  String body
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="id", required=true)  Integer id
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GenericResponse>(objectMapper.readValue("{\n  \"text\" : \"The command completed successfully.\",\n  \"status\" : \"ok\"\n}", GenericResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GenericResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GenericResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<MailLog> viewMailLog(@Parameter(in = ParameterIn.QUERY, description = "The ID of your mail order this will be sent through." ,schema=@Schema()) @Valid @RequestParam(value = "id", required = false) Long id
,@Parameter(in = ParameterIn.QUERY, description = "originating ip address sending mail" ,schema=@Schema()) @Valid @RequestParam(value = "origin", required = false) String origin
,@Parameter(in = ParameterIn.QUERY, description = "mx record mail was sent to" ,schema=@Schema()) @Valid @RequestParam(value = "mx", required = false) String mx
,@Parameter(in = ParameterIn.QUERY, description = "from email address" ,schema=@Schema()) @Valid @RequestParam(value = "from", required = false) String from
,@Parameter(in = ParameterIn.QUERY, description = "to/destination email address" ,schema=@Schema()) @Valid @RequestParam(value = "to", required = false) String to
,@Parameter(in = ParameterIn.QUERY, description = "subject containing this string" ,schema=@Schema()) @Valid @RequestParam(value = "subject", required = false) String subject
,@Parameter(in = ParameterIn.QUERY, description = "mail id" ,schema=@Schema()) @Valid @RequestParam(value = "mailid", required = false) String mailid
,@Min(0)@Parameter(in = ParameterIn.QUERY, description = "number of records to skip for pagination" ,schema=@Schema(allowableValues={ "0" }
, defaultValue="0")) @Valid @RequestParam(value = "skip", required = false, defaultValue="0") Integer skip
,@Min(1) @Max(10000) @Parameter(in = ParameterIn.QUERY, description = "maximum number of records to return" ,schema=@Schema(allowableValues={ "1", "10000" }, minimum="1", maximum="10000"
, defaultValue="100")) @Valid @RequestParam(value = "limit", required = false, defaultValue="100") Integer limit
,@Min(0L) @Max(9999999999L) @Parameter(in = ParameterIn.QUERY, description = "earliest date to get emails in unix timestamp format" ,schema=@Schema(allowableValues={ "0", "9999999999" }, maximum="9999999999"
)) @Valid @RequestParam(value = "startDate", required = false) Long startDate
,@Min(0L) @Max(9999999999L) @Parameter(in = ParameterIn.QUERY, description = "earliest date to get emails in unix timestamp format" ,schema=@Schema(allowableValues={ "0", "9999999999" }, maximum="9999999999"
)) @Valid @RequestParam(value = "endDate", required = false) Long endDate
,@Parameter(in = ParameterIn.QUERY, description = "Reply-To Email Address" ,schema=@Schema()) @Valid @RequestParam(value = "replyto", required = false) String replyto
,@Parameter(in = ParameterIn.QUERY, description = "Header From Email Address" ,schema=@Schema()) @Valid @RequestParam(value = "headerfrom", required = false) String headerfrom
,@Parameter(in = ParameterIn.QUERY, description = "Limiting the emails to wether or not they were delivered." ,schema=@Schema(allowableValues={ "0", "1" }
)) @Valid @RequestParam(value = "delivered", required = false) String delivered
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<MailLog>(objectMapper.readValue("{\n  \"total\" : 1,\n  \"skip\" : 0,\n  \"limit\" : 100,\n  \"emails\" : [ {\n    \"_id\" : 103172,\n    \"id\" : \"17c7eda538e0005d03\",\n    \"from\" : \"person@mysite.com\",\n    \"to\" : \"client@isp.com\",\n    \"subject\" : \"sell 0.005 shares\",\n    \"messageId\" : \"<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>\",\n    \"created\" : \"2021-10-14T08:50:10.000Z\",\n    \"time\" : 1634215809,\n    \"user\" : \"mb5658\",\n    \"transtype\" : \"ESMTPSA\",\n    \"origin\" : \"199.231.189.154\",\n    \"interface\" : \"feeder\",\n    \"sendingZone\" : \"interserver\",\n    \"bodySize\" : 63,\n    \"seq\" : 1,\n    \"delivered\" : 1,\n    \"recipient\" : \"client@isp.com\",\n    \"domain\" : \"interserver.net\",\n    \"locked\" : 1,\n    \"lockTime\" : \"1634215818533\",\n    \"assigned\" : \"relay1\",\n    \"queued\" : \"2021-10-14T12:50:15.487Z\",\n    \"mxHostname\" : \"mx.j.is.cc\",\n    \"response\" : \"250 2.0.0 Ok queued as C91D83E128C\"\n  } ]\n}", MailLog.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<MailLog>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<MailLog>(HttpStatus.NOT_IMPLEMENTED);
    }

}
