package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

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

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2025-07-19T04:18:49.767214635-04:00[America/New_York]")
public abstract class MailApiService {
    public abstract Response addRule(String user,String type,String data,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addRule(DenyRuleNew body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteRule(Integer ruleId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response delistBlock(String body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getMailBlocks(SecurityContext securityContext) throws NotFoundException;
    public abstract Response getMailOrders(SecurityContext securityContext) throws NotFoundException;
    public abstract Response getRules(SecurityContext securityContext) throws NotFoundException;
    public abstract Response getStats( String time,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendAdvMail(String subject,String body,EmailAddressTypes from,EmailAddressesTypes to,EmailAddressesTypes replyto,EmailAddressesTypes cc,EmailAddressesTypes bcc,List<MailAttachment> attachments,Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendAdvMail(SendMailAdv body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendMail(String to,String from,String subject,String body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendMail(SendMail body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response viewMailLog( Long id, String origin, String mx, String from, String to, String subject, String mailid, @Min(0) Integer skip, @Min(1) @Max(10000) Integer limit, @Min(0L) @Max(9999999999L) Long startDate, @Min(0L) @Max(9999999999L) Long endDate, String replyto, String headerfrom, String delivered,SecurityContext securityContext) throws NotFoundException;
}
