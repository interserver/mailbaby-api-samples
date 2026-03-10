package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;

@Canonical
class MailLogEntry {
    /* Internal auto-increment database row ID.  Not meaningful outside the API. */
    Integer id
    /* The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`. */
    String id
    /* SMTP envelope `MAIL FROM` address (may differ from the `From:` header). */
    String from
    /* SMTP envelope `RCPT TO` address. */
    String to
    /* Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format. */
    String created
    /* Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`. */
    Integer time
    /* The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders. */
    String user
    /* SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`). */
    String transtype
    /* IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`. */
    String origin
    /* Relay interface name that accepted the message (e.g. `feeder`). */
    String _interface
    /* The `Subject` header value, if available. */
    String subject
    /* The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups. */
    String messageId
    /* The sending zone assigned by the relay for outbound delivery. */
    String sendingZone
    /* Size of the message body in bytes. */
    Integer bodySize
    /* Sequence index of this recipient in a multi-recipient message. Starts at 1. */
    Integer seq
    /* Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`. */
    Integer delivered
    /* The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`). */
    String response
    /* The specific recipient address this delivery record is for. */
    String recipient
    /* The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`. */
    String domain
    /* Whether the queue entry is currently locked for delivery processing. */
    Integer locked
    /* Millisecond-precision timestamp of the last queue lock acquisition. */
    String lockTime
    /* The relay server node assigned to deliver this message. */
    String assigned
    /* ISO 8601 timestamp when the message was placed into the delivery queue. */
    String queued
    /* The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`. */
    String mxHostname
}
