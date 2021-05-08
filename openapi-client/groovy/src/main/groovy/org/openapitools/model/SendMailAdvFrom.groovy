package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Canonical
class SendMailAdvFrom {
    /* The email address */
    String email
    /* Optional contact name */
    String name
}
