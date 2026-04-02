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
    /* The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object. */
    EmailAddressTypes from
    /* One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects. */
    EmailAddressesTypes to
    /* Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`. */
    EmailAddressesTypes replyto
    /* Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients. */
    EmailAddressesTypes cc
    /* Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header. */
    EmailAddressesTypes bcc
    /* Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name. */
    List<MailAttachment> attachments = new ArrayList<>()
    /* Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. */
    Long id
}
