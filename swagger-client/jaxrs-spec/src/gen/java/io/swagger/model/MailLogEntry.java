package io.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * An email record
 **/
import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
@Schema(description = "An email record")

public class MailLogEntry   {

  private @Valid Integer _id = null;

  private @Valid String id = null;

  private @Valid String from = null;

  private @Valid String to = null;

  private @Valid String subject = null;

  private @Valid String messageId = null;

  private @Valid String created = null;

  private @Valid Integer time = null;

  private @Valid String user = null;

  private @Valid String transtype = null;

  private @Valid String transhost = null;

  private @Valid String originhost = null;

  private @Valid String origin = null;

  private @Valid String _interface = null;

  private @Valid String date = null;

  private @Valid String sendingZone = null;

  private @Valid Integer bodySize = null;

  private @Valid String sourceMd5 = null;

  private @Valid Integer seq = null;

  private @Valid String domain = null;

  private @Valid String recipient = null;

  private @Valid Integer locked = null;

  private @Valid Integer lockTime = null;

  private @Valid String assigned = null;

  private @Valid String queued = null;

  private @Valid String _lock = null;

  private @Valid String logger = null;

  private @Valid Integer mxPort = null;

  private @Valid String connectionKey = null;

  private @Valid String mxHostname = null;

  private @Valid String sentBodyHash = null;

  private @Valid Integer sentBodySize = null;

  private @Valid Integer md5Match = null;

  /**
   * internal db id
   **/
  public MailLogEntry _id(Integer _id) {
    this._id = _id;
    return this;
  }

  
  @ApiModelProperty(example = "103172", required = true, value = "internal db id")
  @JsonProperty("_id")
  @NotNull

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

  
  @ApiModelProperty(example = "17c7eda538e0005d03", required = true, value = "mail id")
  @JsonProperty("id")
  @NotNull

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

  
  @ApiModelProperty(example = "person@mysite.com", required = true, value = "from address")
  @JsonProperty("from")
  @NotNull

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

  
  @ApiModelProperty(example = "client@isp.com", required = true, value = "to address")
  @JsonProperty("to")
  @NotNull

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

  
  @ApiModelProperty(example = "sell 0.005 shares", required = true, value = "email subject")
  @JsonProperty("subject")
  @NotNull

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

  
  @ApiModelProperty(example = "<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>", required = true, value = "message id")
  @JsonProperty("messageId")
  @NotNull

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

  
  @ApiModelProperty(example = "2021-10-14 08:50:10", required = true, value = "creation date")
  @JsonProperty("created")
  @NotNull

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

  
  @ApiModelProperty(example = "1634215809", required = true, value = "creation timestamp")
  @JsonProperty("time")
  @NotNull

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

  
  @ApiModelProperty(example = "mb5658", required = true, value = "user account")
  @JsonProperty("user")
  @NotNull

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

  
  @ApiModelProperty(example = "ESMTPSA", required = true, value = "transaction type")
  @JsonProperty("transtype")
  @NotNull

  public String getTranstype() {
    return transtype;
  }
  public void setTranstype(String transtype) {
    this.transtype = transtype;
  }

  /**
   * transaction host
   **/
  public MailLogEntry transhost(String transhost) {
    this.transhost = transhost;
    return this;
  }

  
  @ApiModelProperty(example = "relay0.mailbaby.net", required = true, value = "transaction host")
  @JsonProperty("transhost")
  @NotNull

  public String getTranshost() {
    return transhost;
  }
  public void setTranshost(String transhost) {
    this.transhost = transhost;
  }

  /**
   * origin host
   **/
  public MailLogEntry originhost(String originhost) {
    this.originhost = originhost;
    return this;
  }

  
  @ApiModelProperty(example = "199.231.189.154", required = true, value = "origin host")
  @JsonProperty("originhost")
  @NotNull

  public String getOriginhost() {
    return originhost;
  }
  public void setOriginhost(String originhost) {
    this.originhost = originhost;
  }

  /**
   * origin ip
   **/
  public MailLogEntry origin(String origin) {
    this.origin = origin;
    return this;
  }

  
  @ApiModelProperty(example = "199.231.189.154", required = true, value = "origin ip")
  @JsonProperty("origin")
  @NotNull

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

  
  @ApiModelProperty(example = "feeder", required = true, value = "interface name")
  @JsonProperty("interface")
  @NotNull

  public String getInterface() {
    return _interface;
  }
  public void setInterface(String _interface) {
    this._interface = _interface;
  }

  /**
   * date processed
   **/
  public MailLogEntry date(String date) {
    this.date = date;
    return this;
  }

  
  @ApiModelProperty(example = "Thu, 14 Oct 2021 08:50:09 -0400", required = true, value = "date processed")
  @JsonProperty("date")
  @NotNull

  public String getDate() {
    return date;
  }
  public void setDate(String date) {
    this.date = date;
  }

  /**
   * sending zone
   **/
  public MailLogEntry sendingZone(String sendingZone) {
    this.sendingZone = sendingZone;
    return this;
  }

  
  @ApiModelProperty(example = "interserver", required = true, value = "sending zone")
  @JsonProperty("sendingZone")
  @NotNull

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

  
  @ApiModelProperty(example = "63", required = true, value = "email body size in bytes")
  @JsonProperty("bodySize")
  @NotNull

  public Integer getBodySize() {
    return bodySize;
  }
  public void setBodySize(Integer bodySize) {
    this.bodySize = bodySize;
  }

  /**
   * md5 sum of the email
   **/
  public MailLogEntry sourceMd5(String sourceMd5) {
    this.sourceMd5 = sourceMd5;
    return this;
  }

  
  @ApiModelProperty(example = "1d7058e6a30369f200b0c34fab2fac92", required = true, value = "md5 sum of the email")
  @JsonProperty("sourceMd5")
  @NotNull

  public String getSourceMd5() {
    return sourceMd5;
  }
  public void setSourceMd5(String sourceMd5) {
    this.sourceMd5 = sourceMd5;
  }

  /**
   * delivery sequency
   **/
  public MailLogEntry seq(Integer seq) {
    this.seq = seq;
    return this;
  }

  
  @ApiModelProperty(example = "1", required = true, value = "delivery sequency")
  @JsonProperty("seq")
  @NotNull

  public Integer getSeq() {
    return seq;
  }
  public void setSeq(Integer seq) {
    this.seq = seq;
  }

  /**
   * to address domain
   **/
  public MailLogEntry domain(String domain) {
    this.domain = domain;
    return this;
  }

  
  @ApiModelProperty(example = "interserver.net", required = true, value = "to address domain")
  @JsonProperty("domain")
  @NotNull

  public String getDomain() {
    return domain;
  }
  public void setDomain(String domain) {
    this.domain = domain;
  }

  /**
   * email receiver address
   **/
  public MailLogEntry recipient(String recipient) {
    this.recipient = recipient;
    return this;
  }

  
  @ApiModelProperty(example = "client@isp.com", required = true, value = "email receiver address")
  @JsonProperty("recipient")
  @NotNull

  public String getRecipient() {
    return recipient;
  }
  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  /**
   * locked status
   **/
  public MailLogEntry locked(Integer locked) {
    this.locked = locked;
    return this;
  }

  
  @ApiModelProperty(example = "1", required = true, value = "locked status")
  @JsonProperty("locked")
  @NotNull

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

  
  @ApiModelProperty(example = "1634215818533", required = true, value = "lock timestamp")
  @JsonProperty("lockTime")
  @NotNull

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

  
  @ApiModelProperty(example = "relay1", required = true, value = "assigned server")
  @JsonProperty("assigned")
  @NotNull

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

  
  @ApiModelProperty(example = "2021-10-14T12:50:15.487Z", required = true, value = "queued timestamp")
  @JsonProperty("queued")
  @NotNull

  public String getQueued() {
    return queued;
  }
  public void setQueued(String queued) {
    this.queued = queued;
  }

  /**
   * lock id
   **/
  public MailLogEntry _lock(String _lock) {
    this._lock = _lock;
    return this;
  }

  
  @ApiModelProperty(example = "lock 17c7eda538e0005d03 001", required = true, value = "lock id")
  @JsonProperty("_lock")
  @NotNull

  public String getLock() {
    return _lock;
  }
  public void setLock(String _lock) {
    this._lock = _lock;
  }

  /**
   * logger
   **/
  public MailLogEntry logger(String logger) {
    this.logger = logger;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "logger")
  @JsonProperty("logger")
  @NotNull

  public String getLogger() {
    return logger;
  }
  public void setLogger(String logger) {
    this.logger = logger;
  }

  /**
   * mx port number
   **/
  public MailLogEntry mxPort(Integer mxPort) {
    this.mxPort = mxPort;
    return this;
  }

  
  @ApiModelProperty(example = "25", required = true, value = "mx port number")
  @JsonProperty("mxPort")
  @NotNull

  public Integer getMxPort() {
    return mxPort;
  }
  public void setMxPort(Integer mxPort) {
    this.mxPort = mxPort;
  }

  /**
   * connection key
   **/
  public MailLogEntry connectionKey(String connectionKey) {
    this.connectionKey = connectionKey;
    return this;
  }

  
  @ApiModelProperty(example = "206.72.200.46:interserver.net:25", required = true, value = "connection key")
  @JsonProperty("connectionKey")
  @NotNull

  public String getConnectionKey() {
    return connectionKey;
  }
  public void setConnectionKey(String connectionKey) {
    this.connectionKey = connectionKey;
  }

  /**
   * mx hostname
   **/
  public MailLogEntry mxHostname(String mxHostname) {
    this.mxHostname = mxHostname;
    return this;
  }

  
  @ApiModelProperty(example = "mx.j.is.cc", required = true, value = "mx hostname")
  @JsonProperty("mxHostname")
  @NotNull

  public String getMxHostname() {
    return mxHostname;
  }
  public void setMxHostname(String mxHostname) {
    this.mxHostname = mxHostname;
  }

  /**
   * body hash
   **/
  public MailLogEntry sentBodyHash(String sentBodyHash) {
    this.sentBodyHash = sentBodyHash;
    return this;
  }

  
  @ApiModelProperty(example = "1d7058e6a30369f200b0c34fab2fac92", required = true, value = "body hash")
  @JsonProperty("sentBodyHash")
  @NotNull

  public String getSentBodyHash() {
    return sentBodyHash;
  }
  public void setSentBodyHash(String sentBodyHash) {
    this.sentBodyHash = sentBodyHash;
  }

  /**
   * sent body size in bytes
   **/
  public MailLogEntry sentBodySize(Integer sentBodySize) {
    this.sentBodySize = sentBodySize;
    return this;
  }

  
  @ApiModelProperty(example = "63", required = true, value = "sent body size in bytes")
  @JsonProperty("sentBodySize")
  @NotNull

  public Integer getSentBodySize() {
    return sentBodySize;
  }
  public void setSentBodySize(Integer sentBodySize) {
    this.sentBodySize = sentBodySize;
  }

  /**
   * md5 checksum matching result
   **/
  public MailLogEntry md5Match(Integer md5Match) {
    this.md5Match = md5Match;
    return this;
  }

  
  @ApiModelProperty(example = "1", required = true, value = "md5 checksum matching result")
  @JsonProperty("md5Match")
  @NotNull

  public Integer getMd5Match() {
    return md5Match;
  }
  public void setMd5Match(Integer md5Match) {
    this.md5Match = md5Match;
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
        Objects.equals(transhost, mailLogEntry.transhost) &&
        Objects.equals(originhost, mailLogEntry.originhost) &&
        Objects.equals(origin, mailLogEntry.origin) &&
        Objects.equals(_interface, mailLogEntry._interface) &&
        Objects.equals(date, mailLogEntry.date) &&
        Objects.equals(sendingZone, mailLogEntry.sendingZone) &&
        Objects.equals(bodySize, mailLogEntry.bodySize) &&
        Objects.equals(sourceMd5, mailLogEntry.sourceMd5) &&
        Objects.equals(seq, mailLogEntry.seq) &&
        Objects.equals(domain, mailLogEntry.domain) &&
        Objects.equals(recipient, mailLogEntry.recipient) &&
        Objects.equals(locked, mailLogEntry.locked) &&
        Objects.equals(lockTime, mailLogEntry.lockTime) &&
        Objects.equals(assigned, mailLogEntry.assigned) &&
        Objects.equals(queued, mailLogEntry.queued) &&
        Objects.equals(_lock, mailLogEntry._lock) &&
        Objects.equals(logger, mailLogEntry.logger) &&
        Objects.equals(mxPort, mailLogEntry.mxPort) &&
        Objects.equals(connectionKey, mailLogEntry.connectionKey) &&
        Objects.equals(mxHostname, mailLogEntry.mxHostname) &&
        Objects.equals(sentBodyHash, mailLogEntry.sentBodyHash) &&
        Objects.equals(sentBodySize, mailLogEntry.sentBodySize) &&
        Objects.equals(md5Match, mailLogEntry.md5Match);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_id, id, from, to, subject, messageId, created, time, user, transtype, transhost, originhost, origin, _interface, date, sendingZone, bodySize, sourceMd5, seq, domain, recipient, locked, lockTime, assigned, queued, _lock, logger, mxPort, connectionKey, mxHostname, sentBodyHash, sentBodySize, md5Match);
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
    sb.append("    transhost: ").append(toIndentedString(transhost)).append("\n");
    sb.append("    originhost: ").append(toIndentedString(originhost)).append("\n");
    sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
    sb.append("    _interface: ").append(toIndentedString(_interface)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    sendingZone: ").append(toIndentedString(sendingZone)).append("\n");
    sb.append("    bodySize: ").append(toIndentedString(bodySize)).append("\n");
    sb.append("    sourceMd5: ").append(toIndentedString(sourceMd5)).append("\n");
    sb.append("    seq: ").append(toIndentedString(seq)).append("\n");
    sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    locked: ").append(toIndentedString(locked)).append("\n");
    sb.append("    lockTime: ").append(toIndentedString(lockTime)).append("\n");
    sb.append("    assigned: ").append(toIndentedString(assigned)).append("\n");
    sb.append("    queued: ").append(toIndentedString(queued)).append("\n");
    sb.append("    _lock: ").append(toIndentedString(_lock)).append("\n");
    sb.append("    logger: ").append(toIndentedString(logger)).append("\n");
    sb.append("    mxPort: ").append(toIndentedString(mxPort)).append("\n");
    sb.append("    connectionKey: ").append(toIndentedString(connectionKey)).append("\n");
    sb.append("    mxHostname: ").append(toIndentedString(mxHostname)).append("\n");
    sb.append("    sentBodyHash: ").append(toIndentedString(sentBodyHash)).append("\n");
    sb.append("    sentBodySize: ").append(toIndentedString(sentBodySize)).append("\n");
    sb.append("    md5Match: ").append(toIndentedString(md5Match)).append("\n");
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
