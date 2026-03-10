package io.swagger.api;

import io.swagger.model.DenyRuleNew;
import io.swagger.model.DenyRuleRecord;
import io.swagger.model.EmailAddressParam;
import io.swagger.model.EmailAddressTypes;
import io.swagger.model.EmailAddressesTypes;
import io.swagger.model.ErrorMessage;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailBlocks;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailOrderDetail;
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
                return new ResponseEntity<GenericResponse>(objectMapper.readValue("{\n  \"text\" : \"185caa69ff7000f47c\",\n  \"status\" : \"ok\"\n}", GenericResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GenericResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GenericResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GenericResponse> deleteRule(@Parameter(in = ParameterIn.PATH, description = "The numeric ID of the deny rule to delete.  Obtain this from the `id` field in `GET /mail/rules` or the `text` field of a `POST /mail/rules` response.", required=true, schema=@Schema()) @PathVariable("ruleId") Integer ruleId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GenericResponse>(objectMapper.readValue("{\n  \"text\" : \"185caa69ff7000f47c\",\n  \"status\" : \"ok\"\n}", GenericResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GenericResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GenericResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GenericResponse> delistBlock(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody EmailAddressParam body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GenericResponse>(objectMapper.readValue("{\n  \"text\" : \"185caa69ff7000f47c\",\n  \"status\" : \"ok\"\n}", GenericResponse.class), HttpStatus.NOT_IMPLEMENTED);
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
                return new ResponseEntity<MailBlocks>(objectMapper.readValue("{\n  \"subject\" : [ {\n    \"from\" : \"user@domain.com\",\n    \"subject\" : \"Test email\"\n  }, {\n    \"from\" : \"user@domain.com\",\n    \"subject\" : \"Test email\"\n  } ],\n  \"mbtrap\" : [ null, null ],\n  \"local\" : [ {\n    \"date\" : \"2023-08-07\",\n    \"from\" : \"user@domain.com\",\n    \"messageId\" : \"pFaRqFUEWkucjhTuIzYuoAgWU@domain.com\",\n    \"subject\" : \"Test Email\",\n    \"to\" : \"['client@site.com']\"\n  }, {\n    \"date\" : \"2023-08-07\",\n    \"from\" : \"user@domain.com\",\n    \"messageId\" : \"pFaRqFUEWkucjhTuIzYuoAgWU@domain.com\",\n    \"subject\" : \"Test Email\",\n    \"to\" : \"['client@site.com']\"\n  } ]\n}", MailBlocks.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<MailBlocks>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<MailBlocks>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<MailOrderDetail> getMailOrderById(@Parameter(in = ParameterIn.PATH, description = "The numeric ID of the mail order.", required=true, schema=@Schema()) @PathVariable("id") Long id
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<MailOrderDetail>(objectMapper.readValue("{\n  \"id\" : 21472,\n  \"status\" : \"active\",\n  \"username\" : \"mb21472\",\n  \"password\" : \"s3cr3tpassword\"\n}", MailOrderDetail.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<MailOrderDetail>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<MailOrderDetail>(HttpStatus.NOT_IMPLEMENTED);
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
                return new ResponseEntity<List<DenyRuleRecord>>(objectMapper.readValue("[ {\n  \"id\" : \"14\",\n  \"user\" : \"mb20682\",\n  \"type\" : \"email\",\n  \"data\" : \"domeinwo@server.guesshost.net\",\n  \"created\" : \"2022-03-22 19:16:35\"\n}, {\n  \"id\" : \"14\",\n  \"user\" : \"mb20682\",\n  \"type\" : \"email\",\n  \"data\" : \"domeinwo@server.guesshost.net\",\n  \"created\" : \"2022-03-22 19:16:35\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<DenyRuleRecord>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<DenyRuleRecord>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<MailStatsType> getStats(@Parameter(in = ParameterIn.QUERY, description = "The time window to scope `received`, `sent`, and `volume` statistics. Does not affect `usage` or `cost`, which are always calculated over the current billing cycle.  Defaults to `1h`." ,schema=@Schema(allowableValues={ "all", "billing", "month", "7d", "24h", "day", "1h" }
, defaultValue="1h")) @Valid @RequestParam(value = "time", required = false, defaultValue="1h") String time
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<MailStatsType>(objectMapper.readValue("{\n  \"time\" : \"all\",\n  \"usage\" : 55,\n  \"currency\" : \"USD\",\n  \"cost\" : 1.02,\n  \"received\" : 508,\n  \"sent\" : 495,\n  \"volume\" : {\n    \"to\" : {\n      \"client@domain.com\" : 395,\n      \"user@site.net\" : 57,\n      \"sales@company.com\" : 47\n    },\n    \"from\" : {\n      \"billing@somedomain.com\" : 369,\n      \"sales@somedomain.com\" : 139\n    },\n    \"ip\" : {\n      \"1.1.1.1\" : 142,\n      \"2.2.2.2\" : 132,\n      \"3.3.3.3\" : 129\n    }\n  }\n}", MailStatsType.class), HttpStatus.NOT_IMPLEMENTED);
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
                return new ResponseEntity<GenericResponse>(objectMapper.readValue("{\n  \"text\" : \"185caa69ff7000f47c\",\n  \"status\" : \"ok\"\n}", GenericResponse.class), HttpStatus.NOT_IMPLEMENTED);
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
                return new ResponseEntity<GenericResponse>(objectMapper.readValue("{\n  \"text\" : \"185caa69ff7000f47c\",\n  \"status\" : \"ok\"\n}", GenericResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GenericResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GenericResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GenericResponse> sendMail(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="to", required=true)  Object to
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="from", required=true)  String from
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="subject", required=true)  String subject
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="body", required=true)  String body
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="id", required=true)  Long id
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GenericResponse>(objectMapper.readValue("{\n  \"text\" : \"185caa69ff7000f47c\",\n  \"status\" : \"ok\"\n}", GenericResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GenericResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GenericResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<MailLog> viewMailLog(@Parameter(in = ParameterIn.QUERY, description = "The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from `GET /mail` or `GET /mail/{id}`." ,schema=@Schema()) @Valid @RequestParam(value = "id", required = false) Long id
,@Parameter(in = ParameterIn.QUERY, description = "Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address." ,schema=@Schema()) @Valid @RequestParam(value = "origin", required = false) String origin
,@Parameter(in = ParameterIn.QUERY, description = "Filter by the MX hostname the relay attempted delivery to.  For example `mx.google.com` would return messages destined for Gmail recipients. Maps to `mxHostname` in the `MailLogEntry` response." ,schema=@Schema()) @Valid @RequestParam(value = "mx", required = false) String mx
,@Parameter(in = ParameterIn.QUERY, description = "Filter by SMTP envelope `MAIL FROM` address (exact match).  This is the address the relay used for bounce handling and may differ from the `From:` message header.  For header-level filtering use `headerfrom`." ,schema=@Schema()) @Valid @RequestParam(value = "from", required = false) String from
,@Parameter(in = ParameterIn.QUERY, description = "Filter by SMTP envelope `RCPT TO` address (exact match).  This is the delivery address used by the relay and may differ from the `To:` header when BCC recipients are involved." ,schema=@Schema()) @Valid @RequestParam(value = "to", required = false) String to
,@Parameter(in = ParameterIn.QUERY, description = "Filter by email `Subject` header (exact match).  To search for a substring, include it in the full subject text." ,schema=@Schema()) @Valid @RequestParam(value = "subject", required = false) String subject
,@Size(min=18,max=19) @Parameter(in = ParameterIn.QUERY, description = "Filter by the relay-assigned mail ID string (exact match).  This corresponds to the `id` field in `MailLogEntry` and to the `text` value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as `185997065c60008840`." ,schema=@Schema()) @Valid @RequestParam(value = "mailid", required = false) String mailid
,@Parameter(in = ParameterIn.QUERY, description = "Filter by the `Message-ID` email header using a substring (case-insensitive) match.  The `Message-ID` is assigned by the sending mail client and is visible in the `messageId` field of `MailLogEntry`.  Useful when you know the message ID generated by your application but not the relay `mailid`." ,schema=@Schema()) @Valid @RequestParam(value = "messageId", required = false) String messageId
,@Parameter(in = ParameterIn.QUERY, description = "Filter by the `Reply-To` message header address (exact match).  Only returns messages where this header was explicitly set." ,schema=@Schema()) @Valid @RequestParam(value = "replyto", required = false) String replyto
,@Parameter(in = ParameterIn.QUERY, description = "Filter by the `From` message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope `from` parameter when sending on behalf of another address." ,schema=@Schema()) @Valid @RequestParam(value = "headerfrom", required = false) String headerfrom
,@Parameter(in = ParameterIn.QUERY, description = "Filter by delivery status.  `1` returns only messages that were successfully delivered to the destination MX.  `0` returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status." ,schema=@Schema(allowableValues={ "0", "1" }
)) @Valid @RequestParam(value = "delivered", required = false) Integer delivered
,@Min(0)@Parameter(in = ParameterIn.QUERY, description = "Number of records to skip for pagination.  Use in combination with `limit` to page through large result sets.  Defaults to `0` (no skip)." ,schema=@Schema(allowableValues={ "0" }
, defaultValue="0")) @Valid @RequestParam(value = "skip", required = false, defaultValue="0") Integer skip
,@Min(1) @Max(10000) @Parameter(in = ParameterIn.QUERY, description = "Maximum number of records to return per page.  Defaults to `100`. Maximum allowed value is `10000`.  The response also includes a `total` field with the full matched count so you can calculate the number of pages." ,schema=@Schema(allowableValues={ "1", "10000" }, minimum="1", maximum="10000"
, defaultValue="100")) @Valid @RequestParam(value = "limit", required = false, defaultValue="100") Integer limit
,@Min(0L) @Max(9999999999L) @Parameter(in = ParameterIn.QUERY, description = "Earliest date to include, as a Unix timestamp (seconds since epoch). Messages with a `time` value **greater than or equal to** this value will be included." ,schema=@Schema(allowableValues={ "0", "9999999999" }, maximum="9999999999"
)) @Valid @RequestParam(value = "startDate", required = false) Long startDate
,@Min(0L) @Max(9999999999L) @Parameter(in = ParameterIn.QUERY, description = "Latest date to include, as a Unix timestamp (seconds since epoch). Messages with a `time` value **less than or equal to** this value will be included." ,schema=@Schema(allowableValues={ "0", "9999999999" }, maximum="9999999999"
)) @Valid @RequestParam(value = "endDate", required = false) Long endDate
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<MailLog>(objectMapper.readValue("{\n  \"emails\" : [ {\n    \"_id\" : 103172,\n    \"id\" : \"17c7eda538e0005d03\",\n    \"from\" : \"person@mysite.com\",\n    \"to\" : \"client@isp.com\",\n    \"subject\" : \"sell 0.005 shares\",\n    \"messageId\" : \"<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>\",\n    \"created\" : \"2021-10-14 08:50:10\",\n    \"time\" : 1634215809,\n    \"user\" : \"mb5658\",\n    \"transtype\" : \"ESMTPSA\",\n    \"origin\" : \"199.231.189.154\",\n    \"interface\" : \"feeder\",\n    \"sendingZone\" : \"interserver\",\n    \"bodySize\" : 63,\n    \"seq\" : 1,\n    \"delivered\" : 1,\n    \"recipient\" : \"client@isp.com\",\n    \"domain\" : \"interserver.net\",\n    \"locked\" : 1,\n    \"lockTime\" : \"1634215818533\",\n    \"assigned\" : \"relay1\",\n    \"queued\" : \"2021-10-14T12:50:15.487Z\",\n    \"mxHostname\" : \"mx.j.is.cc\",\n    \"response\" : \"250 2.0.0 Ok queued as C91D83E128C\"\n  }, {\n    \"_id\" : 103172,\n    \"id\" : \"17c7eda538e0005d03\",\n    \"from\" : \"person@mysite.com\",\n    \"to\" : \"client@isp.com\",\n    \"subject\" : \"sell 0.005 shares\",\n    \"messageId\" : \"<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>\",\n    \"created\" : \"2021-10-14 08:50:10\",\n    \"time\" : 1634215809,\n    \"user\" : \"mb5658\",\n    \"transtype\" : \"ESMTPSA\",\n    \"origin\" : \"199.231.189.154\",\n    \"interface\" : \"feeder\",\n    \"sendingZone\" : \"interserver\",\n    \"bodySize\" : 63,\n    \"seq\" : 1,\n    \"delivered\" : 1,\n    \"recipient\" : \"client@isp.com\",\n    \"domain\" : \"interserver.net\",\n    \"locked\" : 1,\n    \"lockTime\" : \"1634215818533\",\n    \"assigned\" : \"relay1\",\n    \"queued\" : \"2021-10-14T12:50:15.487Z\",\n    \"mxHostname\" : \"mx.j.is.cc\",\n    \"response\" : \"250 2.0.0 Ok queued as C91D83E128C\"\n  } ],\n  \"total\" : 10234,\n  \"limit\" : 100,\n  \"skip\" : 0\n}", MailLog.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<MailLog>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<MailLog>(HttpStatus.NOT_IMPLEMENTED);
    }

}
