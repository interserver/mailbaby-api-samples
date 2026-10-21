package org.openapitools.server.model;

import org.openapitools.jackson.nullable.JsonNullable;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


/**
 * A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The `id` field matches the `mailid` query parameter on `GET /mail/log` and   the `text` field of a successful send response. - The `from` address can be passed to `POST /mail/blocks/delete` to delist a   flagged sender. - The `user` field is the SMTP username (e.g. `mb5658`) corresponding to the   `username` field in `GET /mail` / `GET /mail/{id}`.
 */
public class MailLogEntry   {

    private Integer id;
    private String id;
    private String from;
    private String to;
    private String created;
    private Integer time;
    private String user;
    private String transtype;
    private String origin;
    private String _interface;
    private String subject;
    private String messageId;
    private String sendingZone;
    private Integer bodySize;
    private Integer seq;
    private Integer delivered;
    private Integer code;
    private String response;
    private String recipient;
    private String domain;
    private Integer locked;
    private String lockTime;
    private String assigned;
    private String queued;
    private String mxHostname;

    /**
     * Default constructor.
     */
    public MailLogEntry() {
    // JSON-B / Jackson
    }

    /**
     * Create MailLogEntry.
     *
     * @param id Internal auto-increment database row ID.  Not meaningful outside the API.
     * @param id The relay-assigned mail ID (18–19 hex characters).  This is the value returned as &#x60;text&#x60; by the sending endpoints and accepted as the &#x60;mailid&#x60; filter on &#x60;GET /mail/log&#x60;.
     * @param from SMTP envelope &#x60;MAIL FROM&#x60; address (may differ from the &#x60;From:&#x60; header).
     * @param to SMTP envelope &#x60;RCPT TO&#x60; address.
     * @param created Human-readable creation timestamp in &#x60;YYYY-MM-DD HH:MM:SS&#x60; format.
     * @param time Unix timestamp of message acceptance.  Corresponds to the &#x60;startDate&#x60; and &#x60;endDate&#x60; filter parameters on &#x60;GET /mail/log&#x60;.
     * @param user The SMTP AUTH username used to submit the message (e.g. &#x60;mb5658&#x60;). Corresponds to the &#x60;username&#x60; field in &#x60;GET /mail&#x60; orders.
     * @param transtype SMTP transaction type negotiated with the relay (e.g. &#x60;ESMTPSA&#x60;).
     * @param origin IP address of the client that submitted the message to the relay. Corresponds to the &#x60;origin&#x60; filter parameter on &#x60;GET /mail/log&#x60;.
     * @param _interface Relay interface name that accepted the message (e.g. &#x60;feeder&#x60;).
     * @param subject The &#x60;Subject&#x60; header value, if available.
     * @param messageId The &#x60;Message-ID&#x60; header value, if present.  Can be used with the &#x60;messageId&#x60; filter on &#x60;GET /mail/log&#x60; for subsequent lookups.
     * @param sendingZone The sending zone assigned by the relay for outbound delivery.
     * @param bodySize Size of the message body in bytes.
     * @param seq Sequence index of this recipient in a multi-recipient message. Starts at 1.
     * @param delivered Delivery status flag.  &#x60;1&#x60; &#x3D; successfully delivered to destination MX. &#x60;0&#x60; &#x3D; queued, deferred, or failed.  &#x60;null&#x60; &#x3D; delivery not yet attempted. Corresponds to the &#x60;delivered&#x60; filter parameter on &#x60;GET /mail/log&#x60;.
     * @param code The SMTP response code from the destination MX server (e.g. &#x60;250&#x60; for success, &#x60;550&#x60; for permanent failure).
     * @param response The SMTP response string received from the destination MX server upon delivery attempt (e.g. &#x60;\&quot;250 2.0.0 Ok queued as C91D83E128C\&quot;&#x60;).
     * @param recipient The specific recipient address this delivery record is for.
     * @param domain The destination domain.  Corresponds to the &#x60;mx&#x60; filter parameter (which matches &#x60;mxHostname&#x60;, not &#x60;domain&#x60;) on &#x60;GET /mail/log&#x60;.
     * @param locked Whether the queue entry is currently locked for delivery processing.
     * @param lockTime Millisecond-precision timestamp of the last queue lock acquisition.
     * @param assigned The relay server node assigned to deliver this message.
     * @param queued ISO 8601 timestamp when the message was placed into the delivery queue.
     * @param mxHostname The MX hostname the relay connected to for delivery.  Corresponds to the &#x60;mx&#x60; filter parameter on &#x60;GET /mail/log&#x60;.
     */
    public MailLogEntry(
        Integer id, 
        String id, 
        String from, 
        String to, 
        String created, 
        Integer time, 
        String user, 
        String transtype, 
        String origin, 
        String _interface, 
        String subject, 
        String messageId, 
        String sendingZone, 
        Integer bodySize, 
        Integer seq, 
        Integer delivered, 
        Integer code, 
        String response, 
        String recipient, 
        String domain, 
        Integer locked, 
        String lockTime, 
        String assigned, 
        String queued, 
        String mxHostname
    ) {
        this.id = id;
        this.id = id;
        this.from = from;
        this.to = to;
        this.created = created;
        this.time = time;
        this.user = user;
        this.transtype = transtype;
        this.origin = origin;
        this._interface = _interface;
        this.subject = subject;
        this.messageId = messageId;
        this.sendingZone = sendingZone;
        this.bodySize = bodySize;
        this.seq = seq;
        this.delivered = delivered;
        this.code = code;
        this.response = response;
        this.recipient = recipient;
        this.domain = domain;
        this.locked = locked;
        this.lockTime = lockTime;
        this.assigned = assigned;
        this.queued = queued;
        this.mxHostname = mxHostname;
    }



    /**
     * Internal auto-increment database row ID.  Not meaningful outside the API.
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.
     * @return id
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * SMTP envelope `MAIL FROM` address (may differ from the `From:` header).
     * @return from
     */
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * SMTP envelope `RCPT TO` address.
     * @return to
     */
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.
     * @return created
     */
    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.
     * @return time
     */
    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    /**
     * The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.
     * @return user
     */
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    /**
     * SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).
     * @return transtype
     */
    public String getTranstype() {
        return transtype;
    }

    public void setTranstype(String transtype) {
        this.transtype = transtype;
    }

    /**
     * IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.
     * @return origin
     */
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Relay interface name that accepted the message (e.g. `feeder`).
     * @return _interface
     */
    public String getInterface() {
        return _interface;
    }

    public void setInterface(String _interface) {
        this._interface = _interface;
    }

    /**
     * The `Subject` header value, if available.
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.
     * @return messageId
     */
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * The sending zone assigned by the relay for outbound delivery.
     * @return sendingZone
     */
    public String getSendingZone() {
        return sendingZone;
    }

    public void setSendingZone(String sendingZone) {
        this.sendingZone = sendingZone;
    }

    /**
     * Size of the message body in bytes.
     * @return bodySize
     */
    public Integer getBodySize() {
        return bodySize;
    }

    public void setBodySize(Integer bodySize) {
        this.bodySize = bodySize;
    }

    /**
     * Sequence index of this recipient in a multi-recipient message. Starts at 1.
     * @return seq
     */
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.
     * @return delivered
     */
    public Integer getDelivered() {
        return delivered;
    }

    public void setDelivered(Integer delivered) {
        this.delivered = delivered;
    }

    /**
     * The SMTP response code from the destination MX server (e.g. `250` for success, `550` for permanent failure).
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).
     * @return response
     */
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * The specific recipient address this delivery record is for.
     * @return recipient
     */
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.
     * @return domain
     */
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * Whether the queue entry is currently locked for delivery processing.
     * @return locked
     */
    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    /**
     * Millisecond-precision timestamp of the last queue lock acquisition.
     * @return lockTime
     */
    public String getLockTime() {
        return lockTime;
    }

    public void setLockTime(String lockTime) {
        this.lockTime = lockTime;
    }

    /**
     * The relay server node assigned to deliver this message.
     * @return assigned
     */
    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    /**
     * ISO 8601 timestamp when the message was placed into the delivery queue.
     * @return queued
     */
    public String getQueued() {
        return queued;
    }

    public void setQueued(String queued) {
        this.queued = queued;
    }

    /**
     * The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.
     * @return mxHostname
     */
    public String getMxHostname() {
        return mxHostname;
    }

    public void setMxHostname(String mxHostname) {
        this.mxHostname = mxHostname;
    }

    /**
      * Create a string representation of this pojo.
    **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MailLogEntry {\n");
        
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    from: ").append(toIndentedString(from)).append("\n");
        sb.append("    to: ").append(toIndentedString(to)).append("\n");
        sb.append("    created: ").append(toIndentedString(created)).append("\n");
        sb.append("    time: ").append(toIndentedString(time)).append("\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
        sb.append("    transtype: ").append(toIndentedString(transtype)).append("\n");
        sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
        sb.append("    _interface: ").append(toIndentedString(_interface)).append("\n");
        sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
        sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
        sb.append("    sendingZone: ").append(toIndentedString(sendingZone)).append("\n");
        sb.append("    bodySize: ").append(toIndentedString(bodySize)).append("\n");
        sb.append("    seq: ").append(toIndentedString(seq)).append("\n");
        sb.append("    delivered: ").append(toIndentedString(delivered)).append("\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    response: ").append(toIndentedString(response)).append("\n");
        sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
        sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
        sb.append("    locked: ").append(toIndentedString(locked)).append("\n");
        sb.append("    lockTime: ").append(toIndentedString(lockTime)).append("\n");
        sb.append("    assigned: ").append(toIndentedString(assigned)).append("\n");
        sb.append("    queued: ").append(toIndentedString(queued)).append("\n");
        sb.append("    mxHostname: ").append(toIndentedString(mxHostname)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
    */
    private static String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}

