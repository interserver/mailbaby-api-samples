package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.ErrorResponse;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailOrders;
import io.swagger.model.SendMail;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-04-28T16:58:37.263778-04:00[America/New_York]")public abstract class MailApiService {
    public abstract Response getMailById(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getMailOrders(SecurityContext securityContext) throws NotFoundException;
    public abstract Response placeMailOrder(MailOrder body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendAdvMailById(SendMail body,Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendAdvMailById(Long id2,Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendAdvMailById(SendMail body,Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendMailById(Long id, String subject, String body, String to, String toName, String from, String fromName,SecurityContext securityContext) throws NotFoundException;
    public abstract Response validateMailOrder(SecurityContext securityContext) throws NotFoundException;
    public abstract Response viewMailLogById(Long id, String searchString, @Min(0) Integer skip, @Min(0) @Max(50) Integer limit,SecurityContext securityContext) throws NotFoundException;
}
