package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.GenericResponse;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse401;
import io.swagger.model.MailLog;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;
import io.swagger.model.SendMailAdvAttachments;
import io.swagger.model.SendMailAdvBcc;
import io.swagger.model.SendMailAdvCc;
import io.swagger.model.SendMailAdvFrom;
import io.swagger.model.SendMailAdvReplyto;
import io.swagger.model.SendMailAdvTo;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2023-01-10T22:49:59.262341-05:00[America/New_York]")public abstract class MailApiService {
    public abstract Response getMailOrders(SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendAdvMail(SendMailAdv body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendAdvMail(String subject,String body,SendMailAdvFrom from,List<SendMailAdvTo> to,List<SendMailAdvReplyto> replyto,List<SendMailAdvCc> cc,List<SendMailAdvBcc> bcc,List<SendMailAdvAttachments> attachments,Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendMail(String to,String from,String subject,String body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendMail(SendMail body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response viewMailLog( Long id, String origin, String mx, String from, String to, String subject, String mailid, @Min(0) Integer skip, @Min(1) @Max(10000) Integer limit, @Min(0L) @Max(9999999999L) Long startDate, @Min(0L) @Max(9999999999L) Long endDate,SecurityContext securityContext) throws NotFoundException;
}
