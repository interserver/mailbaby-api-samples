package org.openapitools.api.impl;

import org.openapitools.api.*;
import org.openapitools.model.*;

import org.openapitools.model.DateOrTimestamp;
import org.openapitools.model.DenyRuleRecord;
import org.openapitools.model.EmailAddressParam;
import org.openapitools.model.EmailAddressTypes;
import org.openapitools.model.EmailAddressesTypes;
import org.openapitools.model.ErrorMessage;
import org.openapitools.model.GenericResponse;
import java.util.List;
import org.openapitools.model.MailAttachment;
import org.openapitools.model.MailBlocks;
import org.openapitools.model.MailLog;
import org.openapitools.model.MailOrder;
import org.openapitools.model.MailOrderDetail;
import org.openapitools.model.MailStatsType;
import org.openapitools.model.SendMailRaw;
import org.openapitools.model.SendMailTo;

import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import org.wso2.msf4j.formparam.FormDataParam;
import org.wso2.msf4j.formparam.FileInfo;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaMSF4JServerCodegen", comments = "Generator version: 7.26.0")
public class MailApiServiceImpl extends MailApiService {
    @Override
    public Response addRule(String type
, String data
, String user
 ) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteRule(Integer ruleId
 ) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response delistBlock(EmailAddressParam emailAddressParam
 ) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getMailBlocks() throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getMailOrderById(Long id
 ) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getMailOrders() throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getRules() throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getStats(String time
 ) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response rawMail(SendMailRaw sendMailRaw
 ) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response sendAdvMail(String subject
, String body
, EmailAddressTypes from
, EmailAddressesTypes to
, EmailAddressesTypes replyto
, EmailAddressesTypes cc
, EmailAddressesTypes bcc
, List<@Valid MailAttachment> attachments
, Long id
 ) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response sendMail(SendMailTo to
, String from
, String subject
, String body
, Long id
 ) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response viewMailLog(Long id
, String origin
, String mx
, String from
, String to
, String subject
, String mailid
, String messageId
, String replyto
, String headerfrom
, Integer delivered
, Integer skip
, Integer limit
, DateOrTimestamp startDate
, DateOrTimestamp endDate
, String sort
, String dir
, String groupby
 ) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
