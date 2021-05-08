package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.ErrorResponse;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailContact;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailOrders;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;
import io.swagger.model.SendMailAdvFrom;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-07T20:02:06.777341-04:00[America/New_York]")public abstract class MailApiService {
    public abstract Response getMailOrders(SecurityContext securityContext) throws NotFoundException;
    public abstract Response placeMailOrder(MailOrder body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendAdvMail(SendMailAdv body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendAdvMail(String subject,String body,List<SendMailAdvFrom> from,List<MailContact> to,Long id,List<MailContact> replyto,List<MailContact> cc,List<MailContact> bcc,List<MailAttachment> attachments,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendMail(String to,String from,String subject,String body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendMail(SendMail body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response validateMailOrder(SecurityContext securityContext) throws NotFoundException;
    public abstract Response viewMailLog( Long id, String searchString, @Min(0) Integer skip, @Min(0) @Max(50) Integer limit,SecurityContext securityContext) throws NotFoundException;
}
