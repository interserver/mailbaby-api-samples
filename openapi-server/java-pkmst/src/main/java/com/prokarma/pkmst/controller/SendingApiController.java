package com.prokarma.pkmst.controller;

import com.prokarma.pkmst.model.EmailAddressTypes;
import com.prokarma.pkmst.model.EmailAddressesTypes;
import com.prokarma.pkmst.model.ErrorMessage;
import com.prokarma.pkmst.model.GenericResponse;
import com.prokarma.pkmst.model.MailAttachment;
import com.prokarma.pkmst.model.SendMailRaw;
import com.prokarma.pkmst.model.SendMailTo;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
/**
 * Api implementation
 * @author pkmst
 *
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaPKMSTServerCodegen", comments = "Generator version: 7.26.0")
@Controller
public class SendingApiController implements SendingApi {
    private final ObjectMapper objectMapper;
@Autowired
    public SendingApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<GenericResponse> rawMail(@ApiParam(value = "" ,required=true )   @RequestBody SendMailRaw sendMailRaw,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<GenericResponse>(objectMapper.readValue("", GenericResponse.class), HttpStatus.OK);
        }


        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<GenericResponse>(objectMapper.readValue("", GenericResponse.class), HttpStatus.OK);
        }


        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<GenericResponse>(objectMapper.readValue("", GenericResponse.class), HttpStatus.OK);
        }


        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<GenericResponse>(objectMapper.readValue("", GenericResponse.class), HttpStatus.OK);
        }

        return new ResponseEntity<GenericResponse>(HttpStatus.OK);
    }

    public ResponseEntity<GenericResponse> sendAdvMail(@ApiParam(value = "The subject line of the email.", required=true) @RequestPart(value="subject", required=true)  String subject,
        @ApiParam(value = "The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.", required=true) @RequestPart(value="body", required=true)  String body,
        @ApiParam(value = "The sender address.  Accepts a plain email string, an RFC 822 named string (`\\\"Name <email>\\\"`), or a `{\\\"email\\\": \\\"...\\\", \\\"name\\\": \\\"...\\\"}` object.", required=true) @RequestPart(value="from", required=true)  EmailAddressTypes from,
        @ApiParam(value = "One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.", required=true) @RequestPart(value="to", required=true)  EmailAddressesTypes to,
        @ApiParam(value = "Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.") @RequestPart(value="replyto", required=false)  EmailAddressesTypes replyto,
        @ApiParam(value = "Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.") @RequestPart(value="cc", required=false)  EmailAddressesTypes cc,
        @ApiParam(value = "Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.") @RequestPart(value="bcc", required=false)  EmailAddressesTypes bcc,
        @ApiParam(value = "Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.") @RequestPart(value="attachments", required=false)  List<MailAttachment> attachments,
        @ApiParam(value = "Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.") @RequestPart(value="id", required=false)  Long id,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<GenericResponse>(objectMapper.readValue("", GenericResponse.class), HttpStatus.OK);
        }


        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<GenericResponse>(objectMapper.readValue("", GenericResponse.class), HttpStatus.OK);
        }


        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<GenericResponse>(objectMapper.readValue("", GenericResponse.class), HttpStatus.OK);
        }


        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<GenericResponse>(objectMapper.readValue("", GenericResponse.class), HttpStatus.OK);
        }

        return new ResponseEntity<GenericResponse>(HttpStatus.OK);
    }

    public ResponseEntity<GenericResponse> sendMail(@ApiParam(value = "", required=true) @RequestPart(value="to", required=true)  SendMailTo to,
        @ApiParam(value = "The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.", required=true) @RequestPart(value="from", required=true)  String from,
        @ApiParam(value = "The subject line of the email.", required=true) @RequestPart(value="subject", required=true)  String subject,
        @ApiParam(value = "The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.", required=true) @RequestPart(value="body", required=true)  String body,
        @ApiParam(value = "Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.") @RequestPart(value="id", required=false)  Long id,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<GenericResponse>(objectMapper.readValue("", GenericResponse.class), HttpStatus.OK);
        }


        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<GenericResponse>(objectMapper.readValue("", GenericResponse.class), HttpStatus.OK);
        }


        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<GenericResponse>(objectMapper.readValue("", GenericResponse.class), HttpStatus.OK);
        }


        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<GenericResponse>(objectMapper.readValue("", GenericResponse.class), HttpStatus.OK);
        }

        return new ResponseEntity<GenericResponse>(HttpStatus.OK);
    }

}
