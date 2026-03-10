package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Canonical
class ErrorMessage {
    /* The HTTP-style status code associated with the error. */
    Integer code
    /* A human-readable description of the error. */
    String message
}
