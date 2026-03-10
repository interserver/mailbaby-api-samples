package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Canonical
class MailAttachment {
    /* The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`). */
    String filename
    /* The file contents as a base64-encoded string.  Decode this to retrieve the original binary file. */
    byte[] data
}
