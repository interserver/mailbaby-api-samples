package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;

@Canonical
class MailBlockClickHouse {
    /* The date the block event was recorded. */
    Date date
    /* The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it. */
    String from
    /* The `Subject` header of the blocked message. */
    String subject
    /* The serialized list of recipients of the blocked message. */
    String to
    /* The `Message-ID` header of the blocked message, or `null` if not present. */
    String messageId
}
