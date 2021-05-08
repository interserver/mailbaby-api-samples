package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.MailAttachment;
import org.openapitools.model.MailContact;
import org.openapitools.model.SendMailAdvFrom;

@Canonical
class SendMailAdv {
    /* The subject or title of the email */
    String subject
    /* The main email contents. */
    String body
    /* The contact whom is the this email is from. */
    List<SendMailAdvFrom> from = new ArrayList<>()
    /* The Contact whom is the primary recipient of this email. */
    List<MailContact> to = new ArrayList<>()
    /* The ID of the Mail order within our system to use as the Mail Account. */
    Long id
    /* Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. */
    List<MailContact> replyto = new ArrayList<>()
    /* Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. */
    List<MailContact> cc = new ArrayList<>()
    /* Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. */
    List<MailContact> bcc = new ArrayList<>()
    /* Optional file attachments to include in the email */
    List<MailAttachment> attachments = new ArrayList<>()
}
