package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Canonical
class SendMailAdvToInner {
    /* The email address */
    String email
    /* (optional) Name to use for the destination contact. */
    String name
}
