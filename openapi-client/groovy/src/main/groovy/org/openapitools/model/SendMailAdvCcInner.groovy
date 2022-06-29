package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Canonical
class SendMailAdvCcInner {
    /* The email address */
    String email
    /* (optional) Name to use for the CC contact. */
    String name
}
