package io.swagger.api;

import io.swagger.model.GenericResponse;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse401;
import io.swagger.model.MailLog;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;
import io.swagger.model.SendMailAdvAttachments;
import io.swagger.model.SendMailAdvBcc;
import io.swagger.model.SendMailAdvCc;
import io.swagger.model.SendMailAdvFrom;
import io.swagger.model.SendMailAdvReplyto;
import io.swagger.model.SendMailAdvTo;
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

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-03T15:01:31.972382-05:00[America/New_York]")
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

    public ResponseEntity<List<InlineResponse200>> getMailOrders() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<InlineResponse200>>(objectMapper.readValue("[ {\n  \"password\" : \"guest123\",\n  \"comment\" : \"main mail account\",\n  \"id\" : 1234,\n  \"status\" : \"active\",\n  \"username\" : \"mb1234\"\n}, {\n  \"password\" : \"guest123\",\n  \"comment\" : \"main mail account\",\n  \"id\" : 1234,\n  \"status\" : \"active\",\n  \"username\" : \"mb1234\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<InlineResponse200>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<InlineResponse200>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GenericResponse> sendAdvMail(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody SendMailAdv body) {
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

    public ResponseEntity<GenericResponse> sendMail(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="to", required=true)  String to,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="from", required=true)  String from,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="subject", required=true)  String subject,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="body", required=true)  String body) {
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

    public ResponseEntity<MailLog> viewMailLog(@Parameter(in = ParameterIn.QUERY, description = "The ID of your mail order this will be sent through." ,schema=@Schema()) @Valid @RequestParam(value = "id", required = false) Long id,@Parameter(in = ParameterIn.QUERY, description = "pass an optional search string for looking up inventory" ,schema=@Schema()) @Valid @RequestParam(value = "search", required = false) String search,@Min(0)@Parameter(in = ParameterIn.QUERY, description = "number of records to skip for pagination" ,schema=@Schema(allowableValues={  }
, defaultValue="0")) @Valid @RequestParam(value = "skip", required = false, defaultValue="0") Integer skip,@Min(1) @Max(10000) @Parameter(in = ParameterIn.QUERY, description = "maximum number of records to return" ,schema=@Schema(allowableValues={  }, minimum="1", maximum="10000"
, defaultValue="100")) @Valid @RequestParam(value = "limit", required = false, defaultValue="100") Integer limit,@Min(0L) @Max(9999999999L) @Parameter(in = ParameterIn.QUERY, description = "earliest date to get emails in unix timestamp format" ,schema=@Schema(allowableValues={  }, maximum="9999999999"
)) @Valid @RequestParam(value = "startDate", required = false) Long startDate,@Min(0L) @Max(9999999999L) @Parameter(in = ParameterIn.QUERY, description = "earliest date to get emails in unix timestamp format" ,schema=@Schema(allowableValues={  }, maximum="9999999999"
)) @Valid @RequestParam(value = "endDate", required = false) Long endDate) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<MailLog>(objectMapper.readValue("{\n  \"emails\" : [ {\n    \"date\" : \"Thu, 14 Oct 2021 08:50:09 -0400\",\n    \"subject\" : \"sell 0.005 shares\",\n    \"origin\" : \"199.231.189.154\",\n    \"queued\" : \"2021-10-14T12:50:15.487Z\",\n    \"logger\" : \"logger\",\n    \"connectionKey\" : \"206.72.200.46:interserver.net:25\",\n    \"interface\" : \"feeder\",\n    \"md5Match\" : 1,\n    \"mxPort\" : 25,\n    \"sentBodySize\" : 63,\n    \"lockTime\" : 1634215818533,\n    \"from\" : \"person@mysite.com\",\n    \"id\" : \"17c7eda538e0005d03\",\n    \"locked\" : 1,\n    \"seq\" : 1,\n    \"sentBodyHash\" : \"1d7058e6a30369f200b0c34fab2fac92\",\n    \"created\" : \"2021-10-14 08:50:10\",\n    \"transtype\" : \"ESMTPSA\",\n    \"sourceMd5\" : \"1d7058e6a30369f200b0c34fab2fac92\",\n    \"_lock\" : \"lock 17c7eda538e0005d03 001\",\n    \"messageId\" : \"<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>\",\n    \"sendingZone\" : \"interserver\",\n    \"mxHostname\" : \"mx.j.is.cc\",\n    \"transhost\" : \"relay0.mailbaby.net\",\n    \"originhost\" : \"199.231.189.154\",\n    \"domain\" : \"interserver.net\",\n    \"bodySize\" : 63,\n    \"recipient\" : \"client@isp.com\",\n    \"assigned\" : \"relay1\",\n    \"_id\" : 103172,\n    \"to\" : \"client@isp.com\",\n    \"time\" : 1634215809,\n    \"user\" : \"mb5658\"\n  }, {\n    \"date\" : \"Thu, 14 Oct 2021 08:50:09 -0400\",\n    \"subject\" : \"sell 0.005 shares\",\n    \"origin\" : \"199.231.189.154\",\n    \"queued\" : \"2021-10-14T12:50:15.487Z\",\n    \"logger\" : \"logger\",\n    \"connectionKey\" : \"206.72.200.46:interserver.net:25\",\n    \"interface\" : \"feeder\",\n    \"md5Match\" : 1,\n    \"mxPort\" : 25,\n    \"sentBodySize\" : 63,\n    \"lockTime\" : 1634215818533,\n    \"from\" : \"person@mysite.com\",\n    \"id\" : \"17c7eda538e0005d03\",\n    \"locked\" : 1,\n    \"seq\" : 1,\n    \"sentBodyHash\" : \"1d7058e6a30369f200b0c34fab2fac92\",\n    \"created\" : \"2021-10-14 08:50:10\",\n    \"transtype\" : \"ESMTPSA\",\n    \"sourceMd5\" : \"1d7058e6a30369f200b0c34fab2fac92\",\n    \"_lock\" : \"lock 17c7eda538e0005d03 001\",\n    \"messageId\" : \"<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>\",\n    \"sendingZone\" : \"interserver\",\n    \"mxHostname\" : \"mx.j.is.cc\",\n    \"transhost\" : \"relay0.mailbaby.net\",\n    \"originhost\" : \"199.231.189.154\",\n    \"domain\" : \"interserver.net\",\n    \"bodySize\" : 63,\n    \"recipient\" : \"client@isp.com\",\n    \"assigned\" : \"relay1\",\n    \"_id\" : 103172,\n    \"to\" : \"client@isp.com\",\n    \"time\" : 1634215809,\n    \"user\" : \"mb5658\"\n  } ],\n  \"total\" : 10234,\n  \"limit\" : 100,\n  \"skip\" : 0\n}", MailLog.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<MailLog>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<MailLog>(HttpStatus.NOT_IMPLEMENTED);
    }

}
