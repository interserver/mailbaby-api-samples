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

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyDIServerCodegen", date = "2021-05-04T15:55:27.761043-04:00[America/New_York]")public interface MailApiService {
    public Response getMailOrders( Long id,SecurityContext securityContext);
    public Response placeMailOrder(MailOrder body,SecurityContext securityContext);
    public Response sendAdvMailById(SendMail body,SecurityContext securityContext);
    public Response sendMailById( String subject, String body, String to, String from, Long id, String toName, String fromName,SecurityContext securityContext);
    public Response validateMailOrder(SecurityContext securityContext);
    public Response viewMailLogById( Long id, String searchString, @Min(0) Integer skip, @Min(0) @Max(50) Integer limit,SecurityContext securityContext);
}
