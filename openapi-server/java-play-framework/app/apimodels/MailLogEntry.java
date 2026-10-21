package apimodels;

import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.*;
import java.util.Set;
import javax.validation.*;
import java.util.Objects;
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The &#x60;id&#x60; field matches the &#x60;mailid&#x60; query parameter on &#x60;GET /mail/log&#x60; and   the &#x60;text&#x60; field of a successful send response. - The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist a   flagged sender. - The &#x60;user&#x60; field is the SMTP username (e.g. &#x60;mb5658&#x60;) corresponding to the   &#x60;username&#x60; field in &#x60;GET /mail&#x60; / &#x60;GET /mail/{id}&#x60;.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaPlayFrameworkCodegen", comments = "Generator version: 7.26.0")
@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
public class MailLogEntry   {
  @JsonProperty("_id")
  @NotNull

  private Integer id;

  @JsonProperty("id")
  @NotNull
@Size(min=18,max=19)

  private String id;

  @JsonProperty("from")
  @NotNull

  private String from;

  @JsonProperty("to")
  @NotNull

  private String to;

  @JsonProperty("created")
  @NotNull

  private String created;

  @JsonProperty("time")
  @NotNull

  private Integer time;

  @JsonProperty("user")
  @NotNull

  private String user;

  @JsonProperty("transtype")
  @NotNull

  private String transtype;

  @JsonProperty("origin")
  @NotNull

  private String origin;

  @JsonProperty("interface")
  @NotNull

  private String _interface;

  @JsonProperty("subject")
  
  private String subject;

  @JsonProperty("messageId")
  
  private String messageId;

  @JsonProperty("sendingZone")
  
  private String sendingZone;

  @JsonProperty("bodySize")
  
  private Integer bodySize;

  @JsonProperty("seq")
  
  private Integer seq;

  @JsonProperty("delivered")
  
  private Integer delivered;

  @JsonProperty("code")
  
  private Integer code;

  @JsonProperty("response")
  
  private String response;

  @JsonProperty("recipient")
  
  private String recipient;

  @JsonProperty("domain")
  
  private String domain;

  @JsonProperty("locked")
  
  private Integer locked;

  @JsonProperty("lockTime")
  
  private String lockTime;

  @JsonProperty("assigned")
  
  private String assigned;

  @JsonProperty("queued")
  
  private String queued;

  @JsonProperty("mxHostname")
  
  private String mxHostname;

  public MailLogEntry id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Internal auto-increment database row ID.  Not meaningful outside the API.
   * @return id
  **/
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public MailLogEntry id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.
   * @return id
  **/
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public MailLogEntry from(String from) {
    this.from = from;
    return this;
  }

   /**
   * SMTP envelope `MAIL FROM` address (may differ from the `From:` header).
   * @return from
  **/
  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public MailLogEntry to(String to) {
    this.to = to;
    return this;
  }

   /**
   * SMTP envelope `RCPT TO` address.
   * @return to
  **/
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public MailLogEntry created(String created) {
    this.created = created;
    return this;
  }

   /**
   * Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.
   * @return created
  **/
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public MailLogEntry time(Integer time) {
    this.time = time;
    return this;
  }

   /**
   * Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.
   * @return time
  **/
  public Integer getTime() {
    return time;
  }

  public void setTime(Integer time) {
    this.time = time;
  }

  public MailLogEntry user(String user) {
    this.user = user;
    return this;
  }

   /**
   * The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.
   * @return user
  **/
  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public MailLogEntry transtype(String transtype) {
    this.transtype = transtype;
    return this;
  }

   /**
   * SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).
   * @return transtype
  **/
  public String getTranstype() {
    return transtype;
  }

  public void setTranstype(String transtype) {
    this.transtype = transtype;
  }

  public MailLogEntry origin(String origin) {
    this.origin = origin;
    return this;
  }

   /**
   * IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.
   * @return origin
  **/
  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public MailLogEntry _interface(String _interface) {
    this._interface = _interface;
    return this;
  }

   /**
   * Relay interface name that accepted the message (e.g. `feeder`).
   * @return _interface
  **/
  public String getInterface() {
    return _interface;
  }

  public void setInterface(String _interface) {
    this._interface = _interface;
  }

  public MailLogEntry subject(String subject) {
    this.subject = subject;
    return this;
  }

   /**
   * The `Subject` header value, if available.
   * @return subject
  **/
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public MailLogEntry messageId(String messageId) {
    this.messageId = messageId;
    return this;
  }

   /**
   * The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.
   * @return messageId
  **/
  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public MailLogEntry sendingZone(String sendingZone) {
    this.sendingZone = sendingZone;
    return this;
  }

   /**
   * The sending zone assigned by the relay for outbound delivery.
   * @return sendingZone
  **/
  public String getSendingZone() {
    return sendingZone;
  }

  public void setSendingZone(String sendingZone) {
    this.sendingZone = sendingZone;
  }

  public MailLogEntry bodySize(Integer bodySize) {
    this.bodySize = bodySize;
    return this;
  }

   /**
   * Size of the message body in bytes.
   * @return bodySize
  **/
  public Integer getBodySize() {
    return bodySize;
  }

  public void setBodySize(Integer bodySize) {
    this.bodySize = bodySize;
  }

  public MailLogEntry seq(Integer seq) {
    this.seq = seq;
    return this;
  }

   /**
   * Sequence index of this recipient in a multi-recipient message. Starts at 1.
   * @return seq
  **/
  public Integer getSeq() {
    return seq;
  }

  public void setSeq(Integer seq) {
    this.seq = seq;
  }

  public MailLogEntry delivered(Integer delivered) {
    this.delivered = delivered;
    return this;
  }

   /**
   * Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.
   * @return delivered
  **/
  public Integer getDelivered() {
    return delivered;
  }

  public void setDelivered(Integer delivered) {
    this.delivered = delivered;
  }

  public MailLogEntry code(Integer code) {
    this.code = code;
    return this;
  }

   /**
   * The SMTP response code from the destination MX server (e.g. `250` for success, `550` for permanent failure).
   * @return code
  **/
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public MailLogEntry response(String response) {
    this.response = response;
    return this;
  }

   /**
   * The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).
   * @return response
  **/
  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public MailLogEntry recipient(String recipient) {
    this.recipient = recipient;
    return this;
  }

   /**
   * The specific recipient address this delivery record is for.
   * @return recipient
  **/
  public String getRecipient() {
    return recipient;
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  public MailLogEntry domain(String domain) {
    this.domain = domain;
    return this;
  }

   /**
   * The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.
   * @return domain
  **/
  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public MailLogEntry locked(Integer locked) {
    this.locked = locked;
    return this;
  }

   /**
   * Whether the queue entry is currently locked for delivery processing.
   * @return locked
  **/
  public Integer getLocked() {
    return locked;
  }

  public void setLocked(Integer locked) {
    this.locked = locked;
  }

  public MailLogEntry lockTime(String lockTime) {
    this.lockTime = lockTime;
    return this;
  }

   /**
   * Millisecond-precision timestamp of the last queue lock acquisition.
   * @return lockTime
  **/
  public String getLockTime() {
    return lockTime;
  }

  public void setLockTime(String lockTime) {
    this.lockTime = lockTime;
  }

  public MailLogEntry assigned(String assigned) {
    this.assigned = assigned;
    return this;
  }

   /**
   * The relay server node assigned to deliver this message.
   * @return assigned
  **/
  public String getAssigned() {
    return assigned;
  }

  public void setAssigned(String assigned) {
    this.assigned = assigned;
  }

  public MailLogEntry queued(String queued) {
    this.queued = queued;
    return this;
  }

   /**
   * ISO 8601 timestamp when the message was placed into the delivery queue.
   * @return queued
  **/
  public String getQueued() {
    return queued;
  }

  public void setQueued(String queued) {
    this.queued = queued;
  }

  public MailLogEntry mxHostname(String mxHostname) {
    this.mxHostname = mxHostname;
    return this;
  }

   /**
   * The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.
   * @return mxHostname
  **/
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

  @SuppressWarnings("StringBufferReplaceableByString")
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

