package io.interserver.jaxrs.cxf.cdi.api;

import io.interserver.jaxrs.cxf.cdi.api.*;
import io.interserver.jaxrs.cxf.cdi.model.*;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import io.interserver.jaxrs.cxf.cdi.model.DenyRuleRecord;
import io.interserver.jaxrs.cxf.cdi.model.EmailAddressParam;
import io.interserver.jaxrs.cxf.cdi.model.EmailAddressTypes;
import io.interserver.jaxrs.cxf.cdi.model.EmailAddressesTypes;
import io.interserver.jaxrs.cxf.cdi.model.ErrorMessage;
import io.interserver.jaxrs.cxf.cdi.model.GenericResponse;
import io.interserver.jaxrs.cxf.cdi.model.MailAttachment;
import io.interserver.jaxrs.cxf.cdi.model.MailBlocks;
import io.interserver.jaxrs.cxf.cdi.model.MailLog;
import io.interserver.jaxrs.cxf.cdi.model.MailOrder;
import io.interserver.jaxrs.cxf.cdi.model.MailOrderDetail;
import io.interserver.jaxrs.cxf.cdi.model.MailStatsType;
import io.interserver.jaxrs.cxf.cdi.model.SendMailRaw;
import io.interserver.jaxrs.cxf.cdi.model.SendMailTo;

import java.util.List;

import java.io.InputStream;

import javax.validation.constraints.*;
import javax.validation.Valid;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSCXFCDIServerCodegen", comments = "Generator version: 7.26.0")
public interface MailApiService {
      public Response addRule(String type, String data, String user, SecurityContext securityContext);
      public Response deleteRule(Integer ruleId, SecurityContext securityContext);
      public Response delistBlock(EmailAddressParam emailAddressParam, SecurityContext securityContext);
      public Response getMailBlocks(SecurityContext securityContext);
      public Response getMailOrderById(Long id, SecurityContext securityContext);
      public Response getMailOrders(SecurityContext securityContext);
      public Response getRules(SecurityContext securityContext);
      public Response getStats(String time, SecurityContext securityContext);
      public Response rawMail(SendMailRaw sendMailRaw, SecurityContext securityContext);
      public Response sendAdvMail(String subject, String body, EmailAddressTypes from, EmailAddressesTypes to, EmailAddressesTypes replyto, EmailAddressesTypes cc, EmailAddressesTypes bcc, List<@Valid MailAttachment> attachments, Long id, SecurityContext securityContext);
      public Response sendMail(SendMailTo to, String from, String subject, String body, Long id, SecurityContext securityContext);
      public Response viewMailLog(Long id, String origin, String mx, String from, String to, String subject, String mailid, String messageId, String replyto, String headerfrom, Integer delivered, Integer skip, Integer limit, String startDate, String endDate, String sort, String dir, String groupby, SecurityContext securityContext);
}
