package io.interserver.jaxrs.jersey.api.impl;

import io.interserver.jaxrs.jersey.api.*;
import io.interserver.jaxrs.jersey.model.*;

import io.interserver.jaxrs.jersey.model.DenyRuleNew;
import io.interserver.jaxrs.jersey.model.DenyRuleRecord;
import io.interserver.jaxrs.jersey.model.EmailAddressParam;
import io.interserver.jaxrs.jersey.model.ErrorMessage;
import io.interserver.jaxrs.jersey.model.GenericResponse;
import io.interserver.jaxrs.jersey.model.MailAttachment;
import io.interserver.jaxrs.jersey.model.MailBlocks;
import io.interserver.jaxrs.jersey.model.MailLog;
import io.interserver.jaxrs.jersey.model.MailOrder;
import io.interserver.jaxrs.jersey.model.MailOrderDetail;
import io.interserver.jaxrs.jersey.model.MailStatsType;
import io.interserver.jaxrs.jersey.model.SendMail;
import io.interserver.jaxrs.jersey.model.SendMailAdv;
import io.interserver.jaxrs.jersey.model.SendMailRaw;
import io.interserver.jaxrs.jersey.model.SendMailTo;

import java.util.Map;
import java.util.List;
import io.interserver.jaxrs.jersey.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;

public class MailApiServiceImpl extends MailApiService {
    @Override
    public Response addRule(String user, String type, String data, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response addRule(DenyRuleNew body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteRule(Integer ruleId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response delistBlock(EmailAddressParam body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response delistBlock(String email, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getMailBlocks(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getMailOrderById(Long id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getMailOrders(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getRules(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getStats( String time, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response rawMail(SendMailRaw body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response rawMail(String rawEmail, Long id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response sendAdvMail(String subject, String body, Object from, Object to, Object replyto, Object cc, Object bcc, List<MailAttachment> attachments, Long id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response sendAdvMail(SendMailAdv body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response sendMail(SendMailTo to, String from, String subject, String body, Long id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response sendMail(SendMail body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response viewMailLog( Long id,  String origin,  String mx,  String from,  String to,  String subject,  @Size(min=18,max=19) String mailid,  String messageId,  String replyto,  String headerfrom,  Integer delivered,  @Min(0) Integer skip,  @Min(1) @Max(10000) Integer limit,  String startDate,  String endDate,  String sort,  String dir,  String groupby, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
