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
    /* The subject or title of the email */
    String subject
    /* The main email contents. */
    String body
    
    EmailAddressTypes from
    
    EmailAddressesTypes to
    
    EmailAddressesTypes replyto
    
    EmailAddressesTypes cc
    
    EmailAddressesTypes bcc
    /* (optional) File attachments to include in the email.  The file contents must be base64 encoded! */
    List<MailAttachment> attachments
    /* (optional)  ID of the Mail order within our system to use as the Mail Account. */
    Long id
}
