package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.SendMailAdvAttachmentsInner;
import org.openapitools.model.SendMailAdvBccInner;
import org.openapitools.model.SendMailAdvCcInner;
import org.openapitools.model.SendMailAdvFrom;
import org.openapitools.model.SendMailAdvReplytoInner;
import org.openapitools.model.SendMailAdvToInner;

@Canonical
class SendMailAdv {
    /* The subject or title of the email */
    String subject
    /* The main email contents. */
    String body
    
    SendMailAdvFrom from
    /* A list of destionation email addresses to send this to */
    List<SendMailAdvToInner> to = new ArrayList<>()
    /* (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. */
    List<SendMailAdvReplytoInner> replyto = new ArrayList<>()
    /* (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. */
    List<SendMailAdvCcInner> cc = new ArrayList<>()
    /* (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. */
    List<SendMailAdvBccInner> bcc = new ArrayList<>()
    /* (optional) File attachments to include in the email.  The file contents must be base64 encoded! */
    List<SendMailAdvAttachmentsInner> attachments = new ArrayList<>()
    /* (optional)  ID of the Mail order within our system to use as the Mail Account. */
    Long id
}
