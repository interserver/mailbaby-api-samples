package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Arrays;
import org.openapitools.model.MailLogEntry;

@Canonical
class MailLog {
    /* Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`. */
    Integer total
    /* The `skip` value used for this page (echoed from the request). */
    Integer skip
    /* The `limit` value used for this page (echoed from the request). */
    Integer limit
    
    List<MailLogEntry> emails = new ArrayList<>()
}
