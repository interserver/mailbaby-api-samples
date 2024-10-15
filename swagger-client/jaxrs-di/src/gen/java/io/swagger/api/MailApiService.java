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
import io.swagger.model.InlineResponse200;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailBlocks;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;

import java.util.Map;
import java.util.List;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyDIServerCodegen", date = "2024-10-15T16:37:57.631374075-04:00[America/New_York]")
public interface MailApiService {
    public Response addRule(String user,String type,String data,SecurityContext securityContext);
    public Response addRule(DenyRuleNew body,SecurityContext securityContext);
    public Response deleteRule(Integer ruleId,SecurityContext securityContext);
    public Response delistBlock(String body,SecurityContext securityContext);
    public Response getMailBlocks(SecurityContext securityContext);
    public Response getMailOrders(SecurityContext securityContext);
    public Response getRules(SecurityContext securityContext);
    public Response getStats(SecurityContext securityContext);
    public Response sendAdvMail(String subject,String body,EmailAddressTypes from,EmailAddressesTypes to,EmailAddressesTypes replyto,EmailAddressesTypes cc,EmailAddressesTypes bcc,List<MailAttachment> attachments,Long id,SecurityContext securityContext);
    public Response sendAdvMail(SendMailAdv body,SecurityContext securityContext);
    public Response sendMail(String to,String from,String subject,String body,SecurityContext securityContext);
    public Response sendMail(SendMail body,SecurityContext securityContext);
    public Response viewMailLog( Long id, String origin, String mx, String from, String to, String subject, String mailid, @Min(0) Integer skip, @Min(1) @Max(10000) Integer limit, @Min(0L) @Max(9999999999L) Long startDate, @Min(0L) @Max(9999999999L) Long endDate, String replyto, String headerfrom,SecurityContext securityContext);
}
