package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * An email record
 **/
@Schema(description = "An email record")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2023-08-10T12:37:57.566505-04:00[America/New_York]")

public class MailLogEntry   {
  @JsonProperty("_id")
  private Integer _id = null;
  @JsonProperty("id")
  private String id = null;
  @JsonProperty("from")
  private String from = null;
  @JsonProperty("to")
  private String to = null;
  @JsonProperty("subject")
  private String subject = null;
  @JsonProperty("messageId")
  private String messageId = null;
  @JsonProperty("created")
  private String created = null;
  @JsonProperty("time")
  private Integer time = null;
  @JsonProperty("user")
  private String user = null;
  @JsonProperty("transtype")
  private String transtype = null;
  @JsonProperty("origin")
  private String origin = null;
  @JsonProperty("interface")
  private String _interface = null;
  @JsonProperty("sendingZone")
  private String sendingZone = null;
  @JsonProperty("bodySize")
  private Integer bodySize = null;
  @JsonProperty("seq")
  private Integer seq = null;
  @JsonProperty("recipient")
  private String recipient = null;
  @JsonProperty("domain")
  private String domain = null;
  @JsonProperty("locked")
  private Integer locked = null;
  @JsonProperty("lockTime")
  private Integer lockTime = null;
  @JsonProperty("assigned")
  private String assigned = null;
  @JsonProperty("queued")
  private String queued = null;
  @JsonProperty("mxHostname")
  private String mxHostname = null;
  @JsonProperty("response")
  private String response = null;
  /**
   * internal db id
   **/
  public MailLogEntry _id(Integer _id) {
    this._id = _id;
    return this;
  }

  
  @Schema(example = "103172", required = true, description = "internal db id")
  @JsonProperty("_id")
  public Integer getId() {
    return _id;
  }
  public void setId(Integer _id) {
    this._id = _id;
  }

  /**
   * mail id
   **/
  public MailLogEntry id(String id) {
    this.id = id;
    return this;
  }

  
  @Schema(example = "17c7eda538e0005d03", required = true, description = "mail id")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  /**
   * from address
   **/
  public MailLogEntry from(String from) {
    this.from = from;
    return this;
  }

  
  @Schema(example = "person@mysite.com", required = true, description = "from address")
  @JsonProperty("from")
  public String getFrom() {
    return from;
  }
  public void setFrom(String from) {
    this.from = from;
  }

  /**
   * to address
   **/
  public MailLogEntry to(String to) {
    this.to = to;
    return this;
  }

  
  @Schema(example = "client@isp.com", required = true, description = "to address")
  @JsonProperty("to")
  public String getTo() {
    return to;
  }
  public void setTo(String to) {
    this.to = to;
  }

  /**
   * email subject
   **/
  public MailLogEntry subject(String subject) {
    this.subject = subject;
    return this;
  }

  
  @Schema(example = "sell 0.005 shares", required = true, description = "email subject")
  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * message id
   **/
  public MailLogEntry messageId(String messageId) {
    this.messageId = messageId;
    return this;
  }

  
  @Schema(example = "<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>", description = "message id")
  @JsonProperty("messageId")
  public String getMessageId() {
    return messageId;
  }
  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  /**
   * creation date
   **/
  public MailLogEntry created(String created) {
    this.created = created;
    return this;
  }

  
  @Schema(example = "2021-10-14 08:50:10", required = true, description = "creation date")
  @JsonProperty("created")
  public String getCreated() {
    return created;
  }
  public void setCreated(String created) {
    this.created = created;
  }

  /**
   * creation timestamp
   **/
  public MailLogEntry time(Integer time) {
    this.time = time;
    return this;
  }

  
  @Schema(example = "1634215809", required = true, description = "creation timestamp")
  @JsonProperty("time")
  public Integer getTime() {
    return time;
  }
  public void setTime(Integer time) {
    this.time = time;
  }

  /**
   * user account
   **/
  public MailLogEntry user(String user) {
    this.user = user;
    return this;
  }

  
  @Schema(example = "mb5658", required = true, description = "user account")
  @JsonProperty("user")
  public String getUser() {
    return user;
  }
  public void setUser(String user) {
    this.user = user;
  }

  /**
   * transaction type
   **/
  public MailLogEntry transtype(String transtype) {
    this.transtype = transtype;
    return this;
  }

  
  @Schema(example = "ESMTPSA", required = true, description = "transaction type")
  @JsonProperty("transtype")
  public String getTranstype() {
    return transtype;
  }
  public void setTranstype(String transtype) {
    this.transtype = transtype;
  }

  /**
   * origin ip
   **/
  public MailLogEntry origin(String origin) {
    this.origin = origin;
    return this;
  }

  
  @Schema(example = "199.231.189.154", required = true, description = "origin ip")
  @JsonProperty("origin")
  public String getOrigin() {
    return origin;
  }
  public void setOrigin(String origin) {
    this.origin = origin;
  }

  /**
   * interface name
   **/
  public MailLogEntry _interface(String _interface) {
    this._interface = _interface;
    return this;
  }

  
  @Schema(example = "feeder", required = true, description = "interface name")
  @JsonProperty("interface")
  public String getInterface() {
    return _interface;
  }
  public void setInterface(String _interface) {
    this._interface = _interface;
  }

  /**
   * sending zone
   **/
  public MailLogEntry sendingZone(String sendingZone) {
    this.sendingZone = sendingZone;
    return this;
  }

  
  @Schema(example = "interserver", required = true, description = "sending zone")
  @JsonProperty("sendingZone")
  public String getSendingZone() {
    return sendingZone;
  }
  public void setSendingZone(String sendingZone) {
    this.sendingZone = sendingZone;
  }

  /**
   * email body size in bytes
   **/
  public MailLogEntry bodySize(Integer bodySize) {
    this.bodySize = bodySize;
    return this;
  }

  
  @Schema(example = "63", required = true, description = "email body size in bytes")
  @JsonProperty("bodySize")
  public Integer getBodySize() {
    return bodySize;
  }
  public void setBodySize(Integer bodySize) {
    this.bodySize = bodySize;
  }

  /**
   * index of email in the to adderess list
   **/
  public MailLogEntry seq(Integer seq) {
    this.seq = seq;
    return this;
  }

  
  @Schema(example = "1", required = true, description = "index of email in the to adderess list")
  @JsonProperty("seq")
  public Integer getSeq() {
    return seq;
  }
  public void setSeq(Integer seq) {
    this.seq = seq;
  }

  /**
   * to address this email is being sent to
   **/
  public MailLogEntry recipient(String recipient) {
    this.recipient = recipient;
    return this;
  }

  
  @Schema(example = "client@isp.com", required = true, description = "to address this email is being sent to")
  @JsonProperty("recipient")
  public String getRecipient() {
    return recipient;
  }
  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  /**
   * to address domain
   **/
  public MailLogEntry domain(String domain) {
    this.domain = domain;
    return this;
  }

  
  @Schema(example = "interserver.net", required = true, description = "to address domain")
  @JsonProperty("domain")
  public String getDomain() {
    return domain;
  }
  public void setDomain(String domain) {
    this.domain = domain;
  }

  /**
   * locked status
   **/
  public MailLogEntry locked(Integer locked) {
    this.locked = locked;
    return this;
  }

  
  @Schema(example = "1", required = true, description = "locked status")
  @JsonProperty("locked")
  public Integer getLocked() {
    return locked;
  }
  public void setLocked(Integer locked) {
    this.locked = locked;
  }

  /**
   * lock timestamp
   **/
  public MailLogEntry lockTime(Integer lockTime) {
    this.lockTime = lockTime;
    return this;
  }

  
  @Schema(example = "1634215818533", required = true, description = "lock timestamp")
  @JsonProperty("lockTime")
  public Integer getLockTime() {
    return lockTime;
  }
  public void setLockTime(Integer lockTime) {
    this.lockTime = lockTime;
  }

  /**
   * assigned server
   **/
  public MailLogEntry assigned(String assigned) {
    this.assigned = assigned;
    return this;
  }

  
  @Schema(example = "relay1", required = true, description = "assigned server")
  @JsonProperty("assigned")
  public String getAssigned() {
    return assigned;
  }
  public void setAssigned(String assigned) {
    this.assigned = assigned;
  }

  /**
   * queued timestamp
   **/
  public MailLogEntry queued(String queued) {
    this.queued = queued;
    return this;
  }

  
  @Schema(example = "2021-10-14T12:50:15.487Z", required = true, description = "queued timestamp")
  @JsonProperty("queued")
  public String getQueued() {
    return queued;
  }
  public void setQueued(String queued) {
    this.queued = queued;
  }

  /**
   * mx hostname
   **/
  public MailLogEntry mxHostname(String mxHostname) {
    this.mxHostname = mxHostname;
    return this;
  }

  
  @Schema(example = "mx.j.is.cc", required = true, description = "mx hostname")
  @JsonProperty("mxHostname")
  public String getMxHostname() {
    return mxHostname;
  }
  public void setMxHostname(String mxHostname) {
    this.mxHostname = mxHostname;
  }

  /**
   * mail delivery response
   **/
  public MailLogEntry response(String response) {
    this.response = response;
    return this;
  }

  
  @Schema(example = "250 2.0.0 Ok queued as C91D83E128C", required = true, description = "mail delivery response")
  @JsonProperty("response")
  public String getResponse() {
    return response;
  }
  public void setResponse(String response) {
    this.response = response;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailLogEntry mailLogEntry = (MailLogEntry) o;
    return Objects.equals(_id, mailLogEntry._id) &&
        Objects.equals(id, mailLogEntry.id) &&
        Objects.equals(from, mailLogEntry.from) &&
        Objects.equals(to, mailLogEntry.to) &&
        Objects.equals(subject, mailLogEntry.subject) &&
        Objects.equals(messageId, mailLogEntry.messageId) &&
        Objects.equals(created, mailLogEntry.created) &&
        Objects.equals(time, mailLogEntry.time) &&
        Objects.equals(user, mailLogEntry.user) &&
        Objects.equals(transtype, mailLogEntry.transtype) &&
        Objects.equals(origin, mailLogEntry.origin) &&
        Objects.equals(_interface, mailLogEntry._interface) &&
        Objects.equals(sendingZone, mailLogEntry.sendingZone) &&
        Objects.equals(bodySize, mailLogEntry.bodySize) &&
        Objects.equals(seq, mailLogEntry.seq) &&
        Objects.equals(recipient, mailLogEntry.recipient) &&
        Objects.equals(domain, mailLogEntry.domain) &&
        Objects.equals(locked, mailLogEntry.locked) &&
        Objects.equals(lockTime, mailLogEntry.lockTime) &&
        Objects.equals(assigned, mailLogEntry.assigned) &&
        Objects.equals(queued, mailLogEntry.queued) &&
        Objects.equals(mxHostname, mailLogEntry.mxHostname) &&
        Objects.equals(response, mailLogEntry.response);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_id, id, from, to, subject, messageId, created, time, user, transtype, origin, _interface, sendingZone, bodySize, seq, recipient, domain, locked, lockTime, assigned, queued, mxHostname, response);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailLogEntry {\n");
    sb.append("    _id: ").append(toIndentedString(_id)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    transtype: ").append(toIndentedString(transtype)).append("\n");
    sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
    sb.append("    _interface: ").append(toIndentedString(_interface)).append("\n");
    sb.append("    sendingZone: ").append(toIndentedString(sendingZone)).append("\n");
    sb.append("    bodySize: ").append(toIndentedString(bodySize)).append("\n");
    sb.append("    seq: ").append(toIndentedString(seq)).append("\n");
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
    sb.append("    locked: ").append(toIndentedString(locked)).append("\n");
    sb.append("    lockTime: ").append(toIndentedString(lockTime)).append("\n");
    sb.append("    assigned: ").append(toIndentedString(assigned)).append("\n");
    sb.append("    queued: ").append(toIndentedString(queued)).append("\n");
    sb.append("    mxHostname: ").append(toIndentedString(mxHostname)).append("\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
