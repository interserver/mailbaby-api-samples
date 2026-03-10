package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;

@Canonical
class MailStatsVolume {
    /* Message counts keyed by destination (envelope `to`) email address. */
    Map<String, Integer> to = new HashMap<>()
    /* Message counts keyed by sender (envelope `from`) email address. */
    Map<String, Integer> from = new HashMap<>()
    /* Message counts keyed by originating client IP address. */
    Map<String, Integer> ip = new HashMap<>()
}
