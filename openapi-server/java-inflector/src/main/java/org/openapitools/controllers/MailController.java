package org.openapitools.controllers;

import io.swagger.inflector.models.RequestContext;
import io.swagger.inflector.models.ResponseContext;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import java.io.File;
import java.util.List;

import org.openapitools.model.*;

import org.openapitools.model.DateOrTimestamp;
import org.openapitools.model.DenyRuleRecord;
import org.openapitools.model.EmailAddressParam;
import org.openapitools.model.EmailAddressTypes;
import org.openapitools.model.EmailAddressesTypes;
import org.openapitools.model.ErrorMessage;
import org.openapitools.model.GenericResponse;
import java.util.List;
import org.openapitools.model.MailAttachment;
import org.openapitools.model.MailBlocks;
import org.openapitools.model.MailLog;
import org.openapitools.model.MailOrder;
import org.openapitools.model.MailOrderDetail;
import org.openapitools.model.MailStatsType;
import org.openapitools.model.SendMailRaw;
import org.openapitools.model.SendMailTo;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaInflectorServerCodegen", comments = "Generator version: 7.26.0")
public class MailController  {
  /**
   * Uncomment and implement as you see fit.  These operations will map
   * Directly to operation calls from the routing logic.  Because the inflector
   * Code allows you to implement logic incrementally, they are disabled.
   **/

  /*
    public ResponseContext addRule(RequestContext request , String type, String data, String user) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext deleteRule(RequestContext request , Integer ruleId) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext delistBlock(RequestContext request , EmailAddressParam emailAddressParam) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext getMailBlocks(RequestContext request ) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext getMailOrderById(RequestContext request , Long id) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext getMailOrders(RequestContext request ) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext getRules(RequestContext request ) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext getStats(RequestContext request , String time) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext rawMail(RequestContext request , SendMailRaw sendMailRaw) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext sendAdvMail(RequestContext request , String subject, String body, EmailAddressTypes from, EmailAddressesTypes to, EmailAddressesTypes replyto, EmailAddressesTypes cc, EmailAddressesTypes bcc, List<MailAttachment> attachments, Long id) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext sendMail(RequestContext request , SendMailTo to, String from, String subject, String body, Long id) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext viewMailLog(RequestContext request , Long id, String origin, String mx, String from, String to, String subject, String mailid, String messageId, String replyto, String headerfrom, Integer delivered, Integer skip, Integer limit, DateOrTimestamp startDate, DateOrTimestamp endDate, String sort, String dir, String groupby) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

}
