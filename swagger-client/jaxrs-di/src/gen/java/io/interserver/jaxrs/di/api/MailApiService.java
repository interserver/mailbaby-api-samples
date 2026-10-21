package io.interserver.jaxrs.di.api;

import io.interserver.jaxrs.di.api.*;
import io.interserver.jaxrs.di.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.interserver.jaxrs.di.model.DenyRuleNew;
import io.interserver.jaxrs.di.model.DenyRuleRecord;
import io.interserver.jaxrs.di.model.EmailAddressParam;
import io.interserver.jaxrs.di.model.ErrorMessage;
import io.interserver.jaxrs.di.model.GenericResponse;
import io.interserver.jaxrs.di.model.MailAttachment;
import io.interserver.jaxrs.di.model.MailBlocks;
import io.interserver.jaxrs.di.model.MailLog;
import io.interserver.jaxrs.di.model.MailOrder;
import io.interserver.jaxrs.di.model.MailOrderDetail;
import io.interserver.jaxrs.di.model.MailStatsType;
import io.interserver.jaxrs.di.model.SendMail;
import io.interserver.jaxrs.di.model.SendMailAdv;
import io.interserver.jaxrs.di.model.SendMailRaw;
import io.interserver.jaxrs.di.model.SendMailTo;

import java.util.Map;
import java.util.List;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;

public interface MailApiService {
    public Response addRule(String user,String type,String data,SecurityContext securityContext);
    public Response addRule(DenyRuleNew body,SecurityContext securityContext);
    public Response deleteRule(Integer ruleId,SecurityContext securityContext);
    public Response delistBlock(EmailAddressParam body,SecurityContext securityContext);
    public Response delistBlock(String email,SecurityContext securityContext);
    public Response getMailBlocks(SecurityContext securityContext);
    public Response getMailOrderById(Long id,SecurityContext securityContext);
    public Response getMailOrders(SecurityContext securityContext);
    public Response getRules(SecurityContext securityContext);
    public Response getStats( String time,SecurityContext securityContext);
    public Response rawMail(SendMailRaw body,SecurityContext securityContext);
    public Response rawMail(String rawEmail,Long id,SecurityContext securityContext);
    public Response sendAdvMail(String subject,String body,Object from,Object to,Object replyto,Object cc,Object bcc,List<MailAttachment> attachments,Long id,SecurityContext securityContext);
    public Response sendAdvMail(SendMailAdv body,SecurityContext securityContext);
    public Response sendMail(SendMailTo to,String from,String subject,String body,Long id,SecurityContext securityContext);
    public Response sendMail(SendMail body,SecurityContext securityContext);
    public Response viewMailLog( Long id, String origin, String mx, String from, String to, String subject, @Size(min=18,max=19) String mailid, String messageId, String replyto, String headerfrom, Integer delivered, @Min(0) Integer skip, @Min(1) @Max(10000) Integer limit, String startDate, String endDate, String sort, String dir, String groupby,SecurityContext securityContext);
}
