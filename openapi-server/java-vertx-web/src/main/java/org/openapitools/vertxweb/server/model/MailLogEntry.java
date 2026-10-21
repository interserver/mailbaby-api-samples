package org.openapitools.vertxweb.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The &#x60;id&#x60; field matches the &#x60;mailid&#x60; query parameter on &#x60;GET /mail/log&#x60; and   the &#x60;text&#x60; field of a successful send response. - The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist a   flagged sender. - The &#x60;user&#x60; field is the SMTP username (e.g. &#x60;mb5658&#x60;) corresponding to the   &#x60;username&#x60; field in &#x60;GET /mail&#x60; / &#x60;GET /mail/{id}&#x60;.
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
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

  public MailLogEntry () {

  }

  public MailLogEntry (Integer id, String id, String from, String to, String created, Integer time, String user, String transtype, String origin, String _interface, String subject, String messageId, String sendingZone, Integer bodySize, Integer seq, Integer delivered, Integer code, String response, String recipient, String domain, Integer locked, String lockTime, String assigned, String queued, String mxHostname) {
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

    
  @JsonProperty("_id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

    
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

    
  @JsonProperty("from")
  public String getFrom() {
    return from;
  }
  public void setFrom(String from) {
    this.from = from;
  }

    
  @JsonProperty("to")
  public String getTo() {
    return to;
  }
  public void setTo(String to) {
    this.to = to;
  }

    
  @JsonProperty("created")
  public String getCreated() {
    return created;
  }
  public void setCreated(String created) {
    this.created = created;
  }

    
  @JsonProperty("time")
  public Integer getTime() {
    return time;
  }
  public void setTime(Integer time) {
    this.time = time;
  }

    
  @JsonProperty("user")
  public String getUser() {
    return user;
  }
  public void setUser(String user) {
    this.user = user;
  }

    
  @JsonProperty("transtype")
  public String getTranstype() {
    return transtype;
  }
  public void setTranstype(String transtype) {
    this.transtype = transtype;
  }

    
  @JsonProperty("origin")
  public String getOrigin() {
    return origin;
  }
  public void setOrigin(String origin) {
    this.origin = origin;
  }

    
  @JsonProperty("interface")
  public String getInterface() {
    return _interface;
  }
  public void setInterface(String _interface) {
    this._interface = _interface;
  }

    
  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }

    
  @JsonProperty("messageId")
  public String getMessageId() {
    return messageId;
  }
  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

    
  @JsonProperty("sendingZone")
  public String getSendingZone() {
    return sendingZone;
  }
  public void setSendingZone(String sendingZone) {
    this.sendingZone = sendingZone;
  }

    
  @JsonProperty("bodySize")
  public Integer getBodySize() {
    return bodySize;
  }
  public void setBodySize(Integer bodySize) {
    this.bodySize = bodySize;
  }

    
  @JsonProperty("seq")
  public Integer getSeq() {
    return seq;
  }
  public void setSeq(Integer seq) {
    this.seq = seq;
  }

    
  @JsonProperty("delivered")
  public Integer getDelivered() {
    return delivered;
  }
  public void setDelivered(Integer delivered) {
    this.delivered = delivered;
  }

    
  @JsonProperty("code")
  public Integer getCode() {
    return code;
  }
  public void setCode(Integer code) {
    this.code = code;
  }

    
  @JsonProperty("response")
  public String getResponse() {
    return response;
  }
  public void setResponse(String response) {
    this.response = response;
  }

    
  @JsonProperty("recipient")
  public String getRecipient() {
    return recipient;
  }
  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

    
  @JsonProperty("domain")
  public String getDomain() {
    return domain;
  }
  public void setDomain(String domain) {
    this.domain = domain;
  }

    
  @JsonProperty("locked")
  public Integer getLocked() {
    return locked;
  }
  public void setLocked(Integer locked) {
    this.locked = locked;
  }

    
  @JsonProperty("lockTime")
  public String getLockTime() {
    return lockTime;
  }
  public void setLockTime(String lockTime) {
    this.lockTime = lockTime;
  }

    
  @JsonProperty("assigned")
  public String getAssigned() {
    return assigned;
  }
  public void setAssigned(String assigned) {
    this.assigned = assigned;
  }

    
  @JsonProperty("queued")
  public String getQueued() {
    return queued;
  }
  public void setQueued(String queued) {
    this.queued = queued;
  }

    
  @JsonProperty("mxHostname")
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
    return Objects.equals(id, mailLogEntry.id) &&
        Objects.equals(id, mailLogEntry.id) &&
        Objects.equals(from, mailLogEntry.from) &&
        Objects.equals(to, mailLogEntry.to) &&
        Objects.equals(created, mailLogEntry.created) &&
        Objects.equals(time, mailLogEntry.time) &&
        Objects.equals(user, mailLogEntry.user) &&
        Objects.equals(transtype, mailLogEntry.transtype) &&
        Objects.equals(origin, mailLogEntry.origin) &&
        Objects.equals(_interface, mailLogEntry._interface) &&
        Objects.equals(subject, mailLogEntry.subject) &&
        Objects.equals(messageId, mailLogEntry.messageId) &&
        Objects.equals(sendingZone, mailLogEntry.sendingZone) &&
        Objects.equals(bodySize, mailLogEntry.bodySize) &&
        Objects.equals(seq, mailLogEntry.seq) &&
        Objects.equals(delivered, mailLogEntry.delivered) &&
        Objects.equals(code, mailLogEntry.code) &&
        Objects.equals(response, mailLogEntry.response) &&
        Objects.equals(recipient, mailLogEntry.recipient) &&
        Objects.equals(domain, mailLogEntry.domain) &&
        Objects.equals(locked, mailLogEntry.locked) &&
        Objects.equals(lockTime, mailLogEntry.lockTime) &&
        Objects.equals(assigned, mailLogEntry.assigned) &&
        Objects.equals(queued, mailLogEntry.queued) &&
        Objects.equals(mxHostname, mailLogEntry.mxHostname);
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
