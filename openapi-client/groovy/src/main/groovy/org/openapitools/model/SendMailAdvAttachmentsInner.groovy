package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Canonical
class SendMailAdvAttachmentsInner {
    /* Contents of the attached file (must be base64 encoded) */
    File data
    /* (optional) Filename to specify for the attachment. */
    String filename
}
