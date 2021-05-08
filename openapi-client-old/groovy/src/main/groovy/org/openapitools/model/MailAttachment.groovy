package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Canonical
class MailAttachment {
    /* Contents of the attached file */
    File data
    /* Optional filename to specify for the attachment. */
    String filename
}
