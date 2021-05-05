package io.swagger.api;

import io.swagger.model.ErrorResponse;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailOrders;
import io.swagger.model.SendMail;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-04T21:12:45.159448-04:00[America/New_York]")
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

    public ResponseEntity<MailOrders> getMailOrders(@Parameter(in = ParameterIn.QUERY, description = "The ID of your mail order this will be sent through." ,schema=@Schema()) @Valid @RequestParam(value = "id", required = false) Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<MailOrders>(objectMapper.readValue("[ {\n  \"password\" : \"guest123\",\n  \"comment\" : \"main mail account\",\n  \"id\" : 1234,\n  \"status\" : \"active\",\n  \"username\" : \"mb1234\"\n}, {\n  \"password\" : \"guest123\",\n  \"comment\" : \"main mail account\",\n  \"id\" : 1234,\n  \"status\" : \"active\",\n  \"username\" : \"mb1234\"\n} ]", MailOrders.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<MailOrders>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<MailOrders>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> placeMailOrder(@Parameter(in = ParameterIn.DEFAULT, description = "Inventory item to add", schema=@Schema()) @Valid @RequestBody MailOrder body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GenericResponse> sendAdvMailById(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody SendMail body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GenericResponse>(objectMapper.readValue("{\n  \"status_text\" : \"The command completed successfully.\",\n  \"status\" : \"ok\"\n}", GenericResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GenericResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GenericResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GenericResponse> sendMailById(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="subject", required=true)  String subject,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="body", required=true)  String body,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="from", required=true)  String from,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="to", required=true)  String to,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="id", required=true)  Integer id,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="toName", required=true)  String toName,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="fromName", required=true)  String fromName) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GenericResponse>(objectMapper.readValue("{\n  \"status_text\" : \"The command completed successfully.\",\n  \"status\" : \"ok\"\n}", GenericResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GenericResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GenericResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> validateMailOrder() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<MailLog>> viewMailLogById(@Parameter(in = ParameterIn.QUERY, description = "The ID of your mail order this will be sent through." ,schema=@Schema()) @Valid @RequestParam(value = "id", required = false) Long id,@Parameter(in = ParameterIn.QUERY, description = "pass an optional search string for looking up inventory" ,schema=@Schema()) @Valid @RequestParam(value = "searchString", required = false) String searchString,@Min(0)@Parameter(in = ParameterIn.QUERY, description = "number of records to skip for pagination" ,schema=@Schema(allowableValues={  }
)) @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @Parameter(in = ParameterIn.QUERY, description = "maximum number of records to return" ,schema=@Schema(allowableValues={  }, maximum="50"
)) @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<MailLog>>(objectMapper.readValue("[ {\n  \"id\" : 0\n}, {\n  \"id\" : 0\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<MailLog>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<MailLog>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
