package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.model.EmailAddressName;

@Canonical
class EmailAddressTypes {
    /* The email address. */
    String email
    /* Name to use for the sending contact. */
    String name
}
