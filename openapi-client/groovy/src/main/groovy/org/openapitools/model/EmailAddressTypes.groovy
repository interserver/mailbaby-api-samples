package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.model.EmailAddressName;

@Canonical
class EmailAddressTypes {
    /* The email address. */
    String email
    /* Optional display name shown to recipients (e.g. in the `From:` header). */
    String name
}
