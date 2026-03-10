package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Canonical
class MailBlockRspamd {
    /* The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender. */
    String from
    /* The suspicious subject pattern that triggered the block. */
    String subject
}
