package com.prokarma.pkmst.controller;

import com.prokarma.pkmst.model.DenyRuleRecord;
import com.prokarma.pkmst.model.EmailAddressParam;
import com.prokarma.pkmst.model.ErrorMessage;
import com.prokarma.pkmst.model.GenericResponse;
import java.util.List;
import com.prokarma.pkmst.model.MailBlocks;

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
public class BlockingApiController implements BlockingApi {
    private final ObjectMapper objectMapper;
@Autowired
    public BlockingApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<GenericResponse> addRule(@ApiParam(value = "The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.", required=true, allowableValues="domain, email, startswith, destination") @RequestPart(value="type", required=true)  String type,
        @ApiParam(value = "The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.", required=true) @RequestPart(value="data", required=true)  String data,
        @ApiParam(value = "Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.") @RequestPart(value="user", required=false)  String user,
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

    public ResponseEntity<GenericResponse> deleteRule(@ApiParam(value = "The numeric ID of the deny rule to delete.  Obtain this from the `id` field in `GET /mail/rules` or the `text` field of a `POST /mail/rules` response.",required=true ) @PathVariable("ruleId") Integer ruleId,
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

    public ResponseEntity<GenericResponse> delistBlock(@ApiParam(value = "" ,required=true )   @RequestBody EmailAddressParam emailAddressParam,
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

    public ResponseEntity<MailBlocks> getMailBlocks(@RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<MailBlocks>(objectMapper.readValue("", MailBlocks.class), HttpStatus.OK);
        }


        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<MailBlocks>(objectMapper.readValue("", MailBlocks.class), HttpStatus.OK);
        }

        return new ResponseEntity<MailBlocks>(HttpStatus.OK);
    }

    public ResponseEntity<List<DenyRuleRecord>> getRules(@RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<List<DenyRuleRecord>>(objectMapper.readValue("", List.class), HttpStatus.OK);
        }


        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<List<DenyRuleRecord>>(objectMapper.readValue("", List.class), HttpStatus.OK);
        }

        return new ResponseEntity<List<DenyRuleRecord>>(HttpStatus.OK);
    }

}
