package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Canonical
class MailOrderDetail {
    /* The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries. */
    Integer id
    /* The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send. */
    String status
    /* The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed. */
    String username
    /* The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`. */
    String password
    /* Optional human-readable note associated with the order. */
    String comment
}
