package org.openapitools.api;

import org.openapitools.api.*;
import org.openapitools.model.*;

import org.wso2.msf4j.formparam.FormDataParam;
import org.wso2.msf4j.formparam.FileInfo;

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

import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaMSF4JServerCodegen", comments = "Generator version: 7.26.0")
public abstract class MailApiService {
    public abstract Response addRule(String type
 ,String data
 ,String user
 ) throws NotFoundException;
    public abstract Response deleteRule(Integer ruleId
 ) throws NotFoundException;
    public abstract Response delistBlock(EmailAddressParam emailAddressParam
 ) throws NotFoundException;
    public abstract Response getMailBlocks() throws NotFoundException;
    public abstract Response getMailOrderById(Long id
 ) throws NotFoundException;
    public abstract Response getMailOrders() throws NotFoundException;
    public abstract Response getRules() throws NotFoundException;
    public abstract Response getStats(String time
 ) throws NotFoundException;
    public abstract Response rawMail(SendMailRaw sendMailRaw
 ) throws NotFoundException;
    public abstract Response sendAdvMail(String subject
 ,String body
 ,EmailAddressTypes from
 ,EmailAddressesTypes to
 ,EmailAddressesTypes replyto
 ,EmailAddressesTypes cc
 ,EmailAddressesTypes bcc
 ,List<@Valid MailAttachment> attachments
 ,Long id
 ) throws NotFoundException;
    public abstract Response sendMail(SendMailTo to
 ,String from
 ,String subject
 ,String body
 ,Long id
 ) throws NotFoundException;
    public abstract Response viewMailLog(Long id
 ,String origin
 ,String mx
 ,String from
 ,String to
 ,String subject
 ,String mailid
 ,String messageId
 ,String replyto
 ,String headerfrom
 ,Integer delivered
 ,Integer skip
 ,Integer limit
 ,DateOrTimestamp startDate
 ,DateOrTimestamp endDate
 ,String sort
 ,String dir
 ,String groupby
 ) throws NotFoundException;
}
