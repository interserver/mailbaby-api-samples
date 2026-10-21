package io.interserver.inflector;

import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import java.io.File;
import java.util.List;

import io.interserver.inflector.model.*;

import io.interserver.inflector.model.DenyRuleNew;
import io.interserver.inflector.model.DenyRuleRecord;
import io.interserver.inflector.model.EmailAddressParam;
import io.interserver.inflector.model.ErrorMessage;
import io.interserver.inflector.model.GenericResponse;
import io.interserver.inflector.model.MailAttachment;
import io.interserver.inflector.model.MailBlocks;
import io.interserver.inflector.model.MailLog;
import io.interserver.inflector.model.MailOrder;
import io.interserver.inflector.model.MailOrderDetail;
import io.interserver.inflector.model.MailStatsType;
import io.interserver.inflector.model.SendMail;
import io.interserver.inflector.model.SendMailAdv;
import io.interserver.inflector.model.SendMailRaw;
import io.interserver.inflector.model.SendMailTo;


public class MailController  {
  /** 
   * Uncomment and implement as you see fit.  These operations will map
   * Directly to operation calls from the routing logic.  Because the inflector
   * Code allows you to implement logic incrementally, they are disabled.
   **/

  /*
    public ResponseContext addRule(RequestContext request ,  String user
,  String type
,  String data
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext addRule(RequestContext request , DenyRuleNew body 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext deleteRule(RequestContext request , Integer ruleId 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext delistBlock(RequestContext request , EmailAddressParam body 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext delistBlock(RequestContext request ,  String email
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext getMailBlocks(RequestContext request ) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext getMailOrderById(RequestContext request , Long id 
) {
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
    public ResponseContext getStats(RequestContext request , String time 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext rawMail(RequestContext request , SendMailRaw body 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext rawMail(RequestContext request ,  String rawEmail
,  Long id
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext sendAdvMail(RequestContext request ,  String subject
,  String body
,  Object from
,  Object to
,  Object replyto
,  Object cc
,  Object bcc
,  List<MailAttachment> attachments
,  Long id
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext sendAdvMail(RequestContext request , SendMailAdv body 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext sendMail(RequestContext request ,  SendMailTo to
,  String from
,  String subject
,  String body
,  Long id
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext sendMail(RequestContext request , SendMail body 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext viewMailLog(RequestContext request , Long id 
, String origin 
, String mx 
, String from 
, String to 
, String subject 
, String mailid 
, String messageId 
, String replyto 
, String headerfrom 
, Integer delivered 
, Integer skip 
, Integer limit 
, String startDate 
, String endDate 
, String sort 
, String dir 
, String groupby 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

}

