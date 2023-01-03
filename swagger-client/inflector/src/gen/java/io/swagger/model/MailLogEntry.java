package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * An email record
 **/
@Schema(description = "An email record")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2023-01-03T15:07:45.411866-05:00[America/New_York]")
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
  @JsonProperty("transhost")
  private String transhost = null;
  @JsonProperty("originhost")
  private String originhost = null;
  @JsonProperty("origin")
  private String origin = null;
  @JsonProperty("interface")
  private String _interface = null;
  @JsonProperty("date")
  private String date = null;
  @JsonProperty("sendingZone")
  private String sendingZone = null;
  @JsonProperty("bodySize")
  private Integer bodySize = null;
  @JsonProperty("sourceMd5")
  private String sourceMd5 = null;
  @JsonProperty("seq")
  private Integer seq = null;
  @JsonProperty("domain")
  private String domain = null;
  @JsonProperty("recipient")
  private String recipient = null;
  @JsonProperty("locked")
  private Integer locked = null;
  @JsonProperty("lockTime")
  private Integer lockTime = null;
  @JsonProperty("assigned")
  private String assigned = null;
  @JsonProperty("queued")
  private String queued = null;
  @JsonProperty("_lock")
  private String _lock = null;
  @JsonProperty("logger")
  private String logger = null;
  @JsonProperty("mxPort")
  private Integer mxPort = null;
  @JsonProperty("connectionKey")
  private String connectionKey = null;
  @JsonProperty("mxHostname")
  private String mxHostname = null;
  @JsonProperty("sentBodyHash")
  private String sentBodyHash = null;
  @JsonProperty("sentBodySize")
  private Integer sentBodySize = null;
  @JsonProperty("md5Match")
  private Integer md5Match = null;
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

  
  @Schema(example = "<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>", required = true, description = "message id")
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
   * transaction host
   **/
  public MailLogEntry transhost(String transhost) {
    this.transhost = transhost;
    return this;
  }

  
  @Schema(example = "relay0.mailbaby.net", required = true, description = "transaction host")
  @JsonProperty("transhost")
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

  
  @Schema(example = "199.231.189.154", required = true, description = "origin host")
  @JsonProperty("originhost")
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
   * date processed
   **/
  public MailLogEntry date(String date) {
    this.date = date;
    return this;
  }

  
  @Schema(example = "Thu, 14 Oct 2021 08:50:09 -0400", required = true, description = "date processed")
  @JsonProperty("date")
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
   * md5 sum of the email
   **/
  public MailLogEntry sourceMd5(String sourceMd5) {
    this.sourceMd5 = sourceMd5;
    return this;
  }

  
  @Schema(example = "1d7058e6a30369f200b0c34fab2fac92", required = true, description = "md5 sum of the email")
  @JsonProperty("sourceMd5")
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

  
  @Schema(example = "1", required = true, description = "delivery sequency")
  @JsonProperty("seq")
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

  
  @Schema(example = "interserver.net", required = true, description = "to address domain")
  @JsonProperty("domain")
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

  
  @Schema(example = "client@isp.com", required = true, description = "email receiver address")
  @JsonProperty("recipient")
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
   * lock id
   **/
  public MailLogEntry _lock(String _lock) {
    this._lock = _lock;
    return this;
  }

  
  @Schema(example = "lock 17c7eda538e0005d03 001", required = true, description = "lock id")
  @JsonProperty("_lock")
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

  
  @Schema(required = true, description = "logger")
  @JsonProperty("logger")
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

  
  @Schema(example = "25", required = true, description = "mx port number")
  @JsonProperty("mxPort")
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

  
  @Schema(example = "206.72.200.46:interserver.net:25", required = true, description = "connection key")
  @JsonProperty("connectionKey")
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

  
  @Schema(example = "mx.j.is.cc", required = true, description = "mx hostname")
  @JsonProperty("mxHostname")
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

  
  @Schema(example = "1d7058e6a30369f200b0c34fab2fac92", required = true, description = "body hash")
  @JsonProperty("sentBodyHash")
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

  
  @Schema(example = "63", required = true, description = "sent body size in bytes")
  @JsonProperty("sentBodySize")
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

  
  @Schema(example = "1", required = true, description = "md5 checksum matching result")
  @JsonProperty("md5Match")
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
