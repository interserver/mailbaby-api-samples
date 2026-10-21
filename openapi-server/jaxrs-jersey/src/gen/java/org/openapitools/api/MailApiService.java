package org.openapitools.api;

import org.openapitools.api.*;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;

import org.openapitools.model.DenyRuleRecord;
import org.openapitools.model.EmailAddressParam;
import org.openapitools.model.EmailAddressTypes;
import org.openapitools.model.EmailAddressesTypes;
import org.openapitools.model.ErrorMessage;
import org.openapitools.model.GenericResponse;
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

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", comments = "Generator version: 7.26.0")
public abstract class MailApiService {
    public abstract Response addRule(String type,String data,String user,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteRule(Integer ruleId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response delistBlock(EmailAddressParam emailAddressParam,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getMailBlocks(SecurityContext securityContext) throws NotFoundException;
    public abstract Response getMailOrderById(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getMailOrders(SecurityContext securityContext) throws NotFoundException;
    public abstract Response getRules(SecurityContext securityContext) throws NotFoundException;
    public abstract Response getStats(String time,SecurityContext securityContext) throws NotFoundException;
    public abstract Response rawMail(SendMailRaw sendMailRaw,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendAdvMail(String subject,String body,EmailAddressTypes from,EmailAddressesTypes to,EmailAddressesTypes replyto,EmailAddressesTypes cc,EmailAddressesTypes bcc,List<@Valid MailAttachment> attachments,Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendMail(SendMailTo to,String from,String subject,String body,Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response viewMailLog(Long id,String origin,String mx,String from,String to,String subject, @Size(min=18,max=19)String mailid,String messageId,String replyto,String headerfrom,Integer delivered, @Min(0)Integer skip, @Min(1) @Max(10000)Integer limit,String startDate,String endDate,String sort,String dir,String groupby,SecurityContext securityContext) throws NotFoundException;
}
