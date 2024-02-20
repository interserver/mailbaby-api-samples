package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Canonical
class ErrorMessage {
    /* The response code associated with the error. */
    Integer code
    /* The details or description of the error. */
    String message
}
