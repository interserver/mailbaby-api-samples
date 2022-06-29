
package org.openapitools.client.model


case class MailLogEntry (
    /* internal db id */
    _id: Integer,
    /* mail id */
    _id: String,
    /* from address */
    _from: String,
    /* to address */
    _to: String,
    /* email subject */
    _subject: String,
    /* message id */
    _messageId: String,
    /* creation date */
    _created: String,
    /* creation timestamp */
    _time: Integer,
    /* user account */
    _user: String,
    /* transaction type */
    _transtype: String,
    /* transaction host */
    _transhost: String,
    /* origin host */
    _originhost: String,
    /* origin ip */
    _origin: String,
    /* interface name */
    _interface: String,
    /* date processed */
    _date: String,
    /* sending zone */
    _sendingZone: String,
    /* email body size in bytes */
    _bodySize: Integer,
    /* md5 sum of the email */
    _sourceMd5: String,
    /* delivery sequency */
    _seq: Integer,
    /* to address domain */
    _domain: String,
    /* email receiver address */
    _recipient: String,
    /* locked status */
    _locked: Integer,
    /* lock timestamp */
    _lockTime: Integer,
    /* assigned server */
    _assigned: String,
    /* queued timestamp */
    _queued: String,
    /* lock id */
    _lock: String,
    /* logger */
    _logger: String,
    /* mx port number */
    _mxPort: Integer,
    /* connection key */
    _connectionKey: String,
    /* mx hostname */
    _mxHostname: String,
    /* body hash */
    _sentBodyHash: String,
    /* sent body size in bytes */
    _sentBodySize: Integer,
    /* md5 checksum matching result */
    _md5Match: Integer
)
object MailLogEntry {
    def toStringBody(var_id: Object, var_id: Object, var_from: Object, var_to: Object, var_subject: Object, var_messageId: Object, var_created: Object, var_time: Object, var_user: Object, var_transtype: Object, var_transhost: Object, var_originhost: Object, var_origin: Object, var_interface: Object, var_date: Object, var_sendingZone: Object, var_bodySize: Object, var_sourceMd5: Object, var_seq: Object, var_domain: Object, var_recipient: Object, var_locked: Object, var_lockTime: Object, var_assigned: Object, var_queued: Object, var_lock: Object, var_logger: Object, var_mxPort: Object, var_connectionKey: Object, var_mxHostname: Object, var_sentBodyHash: Object, var_sentBodySize: Object, var_md5Match: Object) =
        s"""
        | {
        | "id":$var_id,"id":$var_id,"from":$var_from,"to":$var_to,"subject":$var_subject,"messageId":$var_messageId,"created":$var_created,"time":$var_time,"user":$var_user,"transtype":$var_transtype,"transhost":$var_transhost,"originhost":$var_originhost,"origin":$var_origin,"interface":$var_interface,"date":$var_date,"sendingZone":$var_sendingZone,"bodySize":$var_bodySize,"sourceMd5":$var_sourceMd5,"seq":$var_seq,"domain":$var_domain,"recipient":$var_recipient,"locked":$var_locked,"lockTime":$var_lockTime,"assigned":$var_assigned,"queued":$var_queued,"lock":$var_lock,"logger":$var_logger,"mxPort":$var_mxPort,"connectionKey":$var_connectionKey,"mxHostname":$var_mxHostname,"sentBodyHash":$var_sentBodyHash,"sentBodySize":$var_sentBodySize,"md5Match":$var_md5Match
        | }
        """.stripMargin
}
