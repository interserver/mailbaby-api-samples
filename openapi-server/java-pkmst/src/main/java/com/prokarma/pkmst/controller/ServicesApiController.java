package com.prokarma.pkmst.controller;

import com.prokarma.pkmst.model.ErrorMessage;
import java.util.List;
import com.prokarma.pkmst.model.MailOrder;
import com.prokarma.pkmst.model.MailOrderDetail;

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
public class ServicesApiController implements ServicesApi {
    private final ObjectMapper objectMapper;
@Autowired
    public ServicesApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<MailOrderDetail> getMailOrderById(@ApiParam(value = "The numeric ID of the mail order.",required=true ) @PathVariable("id") Long id,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<MailOrderDetail>(objectMapper.readValue("", MailOrderDetail.class), HttpStatus.OK);
        }


        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<MailOrderDetail>(objectMapper.readValue("", MailOrderDetail.class), HttpStatus.OK);
        }


        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<MailOrderDetail>(objectMapper.readValue("", MailOrderDetail.class), HttpStatus.OK);
        }


        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<MailOrderDetail>(objectMapper.readValue("", MailOrderDetail.class), HttpStatus.OK);
        }

        return new ResponseEntity<MailOrderDetail>(HttpStatus.OK);
    }

    public ResponseEntity<List<MailOrder>> getMailOrders(@RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<List<MailOrder>>(objectMapper.readValue("", List.class), HttpStatus.OK);
        }


        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<List<MailOrder>>(objectMapper.readValue("", List.class), HttpStatus.OK);
        }

        return new ResponseEntity<List<MailOrder>>(HttpStatus.OK);
    }

}
