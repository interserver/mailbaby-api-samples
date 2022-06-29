package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Canonical
class MailLogEntry {
    /* internal db id */
    Integer id
    /* mail id */
    String id
    /* from address */
    String from
    /* to address */
    String to
    /* email subject */
    String subject
    /* message id */
    String messageId
    /* creation date */
    String created
    /* creation timestamp */
    Integer time
    /* user account */
    String user
    /* transaction type */
    String transtype
    /* transaction host */
    String transhost
    /* origin host */
    String originhost
    /* origin ip */
    String origin
    /* interface name */
    String _interface
    /* date processed */
    String date
    /* sending zone */
    String sendingZone
    /* email body size in bytes */
    Integer bodySize
    /* md5 sum of the email */
    String sourceMd5
    /* delivery sequency */
    Integer seq
    /* to address domain */
    String domain
    /* email receiver address */
    String recipient
    /* locked status */
    Integer locked
    /* lock timestamp */
    Integer lockTime
    /* assigned server */
    String assigned
    /* queued timestamp */
    String queued
    /* lock id */
    String lock
    /* logger */
    String logger
    /* mx port number */
    Integer mxPort
    /* connection key */
    String connectionKey
    /* mx hostname */
    String mxHostname
    /* body hash */
    String sentBodyHash
    /* sent body size in bytes */
    Integer sentBodySize
    /* md5 checksum matching result */
    Integer md5Match
}
