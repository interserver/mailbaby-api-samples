package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Arrays;
import org.openapitools.model.EmailAddressTypes;
import org.openapitools.model.EmailAddressesTypes;
import org.openapitools.model.MailAttachment;

@Canonical
class SendMailAdv {
    /* The subject line of the email. */
    String subject
    /* The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`. */
    String body
    
    EmailAddressTypes from
    
    EmailAddressesTypes to
    
    EmailAddressesTypes replyto
    
    EmailAddressesTypes cc
    
    EmailAddressesTypes bcc
    /* Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name. */
    List<MailAttachment> attachments = new ArrayList<>()
    /* Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. */
    Long id
}
