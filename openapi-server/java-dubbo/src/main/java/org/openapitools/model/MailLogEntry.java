package org.openapitools.model;

import org.openapitools.jackson.nullable.JsonNullable;
import java.util.Objects;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import java.time.*;
import java.math.*;
@Generated(value = "org.openapitools.codegen.languages.JavaDubboServerCodegen", comments = "Generator version: 7.26.0")

/**
 * A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The &#x60;id&#x60; field matches the &#x60;mailid&#x60; query parameter on &#x60;GET /mail/log&#x60; and   the &#x60;text&#x60; field of a successful send response. - The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist a   flagged sender. - The &#x60;user&#x60; field is the SMTP username (e.g. &#x60;mb5658&#x60;) corresponding to the   &#x60;username&#x60; field in &#x60;GET /mail&#x60; / &#x60;GET /mail/{id}&#x60;.
 */
public class MailLogEntry implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * Internal auto-increment database row ID.  Not meaningful outside the API.
   */
  @JsonProperty("_id")
  private Integer id;

  /**
   * The relay-assigned mail ID (18–19 hex characters).  This is the value returned as &#x60;text&#x60; by the sending endpoints and accepted as the &#x60;mailid&#x60; filter on &#x60;GET /mail/log&#x60;.
   */
  @JsonProperty("id")
  private String id;

  /**
   * SMTP envelope &#x60;MAIL FROM&#x60; address (may differ from the &#x60;From:&#x60; header).
   */
  @JsonProperty("from")
  private String from;

  /**
   * SMTP envelope &#x60;RCPT TO&#x60; address.
   */
  @JsonProperty("to")
  private String to;

  /**
   * Human-readable creation timestamp in &#x60;YYYY-MM-DD HH:MM:SS&#x60; format.
   */
  @JsonProperty("created")
  private String created;

  /**
   * Unix timestamp of message acceptance.  Corresponds to the &#x60;startDate&#x60; and &#x60;endDate&#x60; filter parameters on &#x60;GET /mail/log&#x60;.
   */
  @JsonProperty("time")
  private Integer time;

  /**
   * The SMTP AUTH username used to submit the message (e.g. &#x60;mb5658&#x60;). Corresponds to the &#x60;username&#x60; field in &#x60;GET /mail&#x60; orders.
   */
  @JsonProperty("user")
  private String user;

  /**
   * SMTP transaction type negotiated with the relay (e.g. &#x60;ESMTPSA&#x60;).
   */
  @JsonProperty("transtype")
  private String transtype;

  /**
   * IP address of the client that submitted the message to the relay. Corresponds to the &#x60;origin&#x60; filter parameter on &#x60;GET /mail/log&#x60;.
   */
  @JsonProperty("origin")
  private String origin;

  /**
   * Relay interface name that accepted the message (e.g. &#x60;feeder&#x60;).
   */
  @JsonProperty("interface")
  private String _interface;

  /**
   * The &#x60;Subject&#x60; header value, if available.
   */
  @JsonProperty("subject")
  private String subject;

  /**
   * The &#x60;Message-ID&#x60; header value, if present.  Can be used with the &#x60;messageId&#x60; filter on &#x60;GET /mail/log&#x60; for subsequent lookups.
   */
  @JsonProperty("messageId")
  private String messageId;

  /**
   * The sending zone assigned by the relay for outbound delivery.
   */
  @JsonProperty("sendingZone")
  private String sendingZone;

  /**
   * Size of the message body in bytes.
   */
  @JsonProperty("bodySize")
  private Integer bodySize;

  /**
   * Sequence index of this recipient in a multi-recipient message. Starts at 1.
   */
  @JsonProperty("seq")
  private Integer seq;

  /**
   * Delivery status flag.  &#x60;1&#x60; &#x3D; successfully delivered to destination MX. &#x60;0&#x60; &#x3D; queued, deferred, or failed.  &#x60;null&#x60; &#x3D; delivery not yet attempted. Corresponds to the &#x60;delivered&#x60; filter parameter on &#x60;GET /mail/log&#x60;.
   */
  @JsonProperty("delivered")
  private Integer delivered;

  /**
   * The SMTP response code from the destination MX server (e.g. &#x60;250&#x60; for success, &#x60;550&#x60; for permanent failure).
   */
  @JsonProperty("code")
  private Integer code;

  /**
   * The SMTP response string received from the destination MX server upon delivery attempt (e.g. &#x60;\&quot;250 2.0.0 Ok queued as C91D83E128C\&quot;&#x60;).
   */
  @JsonProperty("response")
  private String response;

  /**
   * The specific recipient address this delivery record is for.
   */
  @JsonProperty("recipient")
  private String recipient;

  /**
   * The destination domain.  Corresponds to the &#x60;mx&#x60; filter parameter (which matches &#x60;mxHostname&#x60;, not &#x60;domain&#x60;) on &#x60;GET /mail/log&#x60;.
   */
  @JsonProperty("domain")
  private String domain;

  /**
   * Whether the queue entry is currently locked for delivery processing.
   */
  @JsonProperty("locked")
  private Integer locked;

  /**
   * Millisecond-precision timestamp of the last queue lock acquisition.
   */
  @JsonProperty("lockTime")
  private String lockTime;

  /**
   * The relay server node assigned to deliver this message.
   */
  @JsonProperty("assigned")
  private String assigned;

  /**
   * ISO 8601 timestamp when the message was placed into the delivery queue.
   */
  @JsonProperty("queued")
  private String queued;

  /**
   * The MX hostname the relay connected to for delivery.  Corresponds to the &#x60;mx&#x60; filter parameter on &#x60;GET /mail/log&#x60;.
   */
  @JsonProperty("mxHostname")
  private String mxHostname;

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
   * The relay-assigned mail ID (18–19 hex characters).  This is the value returned as &#x60;text&#x60; by the sending endpoints and accepted as the &#x60;mailid&#x60; filter on &#x60;GET /mail/log&#x60;.
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  /**
   * SMTP envelope &#x60;MAIL FROM&#x60; address (may differ from the &#x60;From:&#x60; header).
   * @return from
   */
  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  /**
   * SMTP envelope &#x60;RCPT TO&#x60; address.
   * @return to
   */
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  /**
   * Human-readable creation timestamp in &#x60;YYYY-MM-DD HH:MM:SS&#x60; format.
   * @return created
   */
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  /**
   * Unix timestamp of message acceptance.  Corresponds to the &#x60;startDate&#x60; and &#x60;endDate&#x60; filter parameters on &#x60;GET /mail/log&#x60;.
   * @return time
   */
  public Integer getTime() {
    return time;
  }

  public void setTime(Integer time) {
    this.time = time;
  }

  /**
   * The SMTP AUTH username used to submit the message (e.g. &#x60;mb5658&#x60;). Corresponds to the &#x60;username&#x60; field in &#x60;GET /mail&#x60; orders.
   * @return user
   */
  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  /**
   * SMTP transaction type negotiated with the relay (e.g. &#x60;ESMTPSA&#x60;).
   * @return transtype
   */
  public String getTranstype() {
    return transtype;
  }

  public void setTranstype(String transtype) {
    this.transtype = transtype;
  }

  /**
   * IP address of the client that submitted the message to the relay. Corresponds to the &#x60;origin&#x60; filter parameter on &#x60;GET /mail/log&#x60;.
   * @return origin
   */
  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  /**
   * Relay interface name that accepted the message (e.g. &#x60;feeder&#x60;).
   * @return _interface
   */
  public String getInterface() {
    return _interface;
  }

  public void setInterface(String _interface) {
    this._interface = _interface;
  }

  /**
   * The &#x60;Subject&#x60; header value, if available.
   * @return subject
   */
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * The &#x60;Message-ID&#x60; header value, if present.  Can be used with the &#x60;messageId&#x60; filter on &#x60;GET /mail/log&#x60; for subsequent lookups.
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
   * Delivery status flag.  &#x60;1&#x60; &#x3D; successfully delivered to destination MX. &#x60;0&#x60; &#x3D; queued, deferred, or failed.  &#x60;null&#x60; &#x3D; delivery not yet attempted. Corresponds to the &#x60;delivered&#x60; filter parameter on &#x60;GET /mail/log&#x60;.
   * @return delivered
   */
  public Integer getDelivered() {
    return delivered;
  }

  public void setDelivered(Integer delivered) {
    this.delivered = delivered;
  }

  /**
   * The SMTP response code from the destination MX server (e.g. &#x60;250&#x60; for success, &#x60;550&#x60; for permanent failure).
   * @return code
   */
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  /**
   * The SMTP response string received from the destination MX server upon delivery attempt (e.g. &#x60;\&quot;250 2.0.0 Ok queued as C91D83E128C\&quot;&#x60;).
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
   * The destination domain.  Corresponds to the &#x60;mx&#x60; filter parameter (which matches &#x60;mxHostname&#x60;, not &#x60;domain&#x60;) on &#x60;GET /mail/log&#x60;.
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
   * The MX hostname the relay connected to for delivery.  Corresponds to the &#x60;mx&#x60; filter parameter on &#x60;GET /mail/log&#x60;.
   * @return mxHostname
   */
  public String getMxHostname() {
    return mxHostname;
  }

  public void setMxHostname(String mxHostname) {
    this.mxHostname = mxHostname;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailLogEntry mailLogEntry = (MailLogEntry) o;
    return Objects.equals(this.id, mailLogEntry.id) &&
        Objects.equals(this.id, mailLogEntry.id) &&
        Objects.equals(this.from, mailLogEntry.from) &&
        Objects.equals(this.to, mailLogEntry.to) &&
        Objects.equals(this.created, mailLogEntry.created) &&
        Objects.equals(this.time, mailLogEntry.time) &&
        Objects.equals(this.user, mailLogEntry.user) &&
        Objects.equals(this.transtype, mailLogEntry.transtype) &&
        Objects.equals(this.origin, mailLogEntry.origin) &&
        Objects.equals(this._interface, mailLogEntry._interface) &&
        Objects.equals(this.subject, mailLogEntry.subject) &&
        Objects.equals(this.messageId, mailLogEntry.messageId) &&
        Objects.equals(this.sendingZone, mailLogEntry.sendingZone) &&
        Objects.equals(this.bodySize, mailLogEntry.bodySize) &&
        Objects.equals(this.seq, mailLogEntry.seq) &&
        Objects.equals(this.delivered, mailLogEntry.delivered) &&
        Objects.equals(this.code, mailLogEntry.code) &&
        Objects.equals(this.response, mailLogEntry.response) &&
        Objects.equals(this.recipient, mailLogEntry.recipient) &&
        Objects.equals(this.domain, mailLogEntry.domain) &&
        Objects.equals(this.locked, mailLogEntry.locked) &&
        Objects.equals(this.lockTime, mailLogEntry.lockTime) &&
        Objects.equals(this.assigned, mailLogEntry.assigned) &&
        Objects.equals(this.queued, mailLogEntry.queued) &&
        Objects.equals(this.mxHostname, mailLogEntry.mxHostname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, id, from, to, created, time, user, transtype, origin, _interface, subject, messageId, sendingZone, bodySize, seq, delivered, code, response, recipient, domain, locked, lockTime, assigned, queued, mxHostname);
  }

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
  private String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}
