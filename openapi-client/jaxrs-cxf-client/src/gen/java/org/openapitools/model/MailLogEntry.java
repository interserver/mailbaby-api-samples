package org.openapitools.model;

import io.swagger.annotations.ApiModel;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
  * An email record
 **/
@ApiModel(description="An email record")

public class MailLogEntry  {
  
  @ApiModelProperty(example = "103172", required = true, value = "internal db id")
 /**
   * internal db id
  **/
  private Integer id;

  @ApiModelProperty(example = "17c7eda538e0005d03", required = true, value = "mail id")
 /**
   * mail id
  **/
  private String id;

  @ApiModelProperty(example = "person@mysite.com", required = true, value = "from address")
 /**
   * from address
  **/
  private String from;

  @ApiModelProperty(example = "client@isp.com", required = true, value = "to address")
 /**
   * to address
  **/
  private String to;

  @ApiModelProperty(example = "sell 0.005 shares", required = true, value = "email subject")
 /**
   * email subject
  **/
  private String subject;

  @ApiModelProperty(example = "<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>", required = true, value = "message id")
 /**
   * message id
  **/
  private String messageId;

  @ApiModelProperty(example = "2021-10-14 08:50:10", required = true, value = "creation date")
 /**
   * creation date
  **/
  private String created;

  @ApiModelProperty(example = "1634215809", required = true, value = "creation timestamp")
 /**
   * creation timestamp
  **/
  private Integer time;

  @ApiModelProperty(example = "mb5658", required = true, value = "user account")
 /**
   * user account
  **/
  private String user;

  @ApiModelProperty(example = "ESMTPSA", required = true, value = "transaction type")
 /**
   * transaction type
  **/
  private String transtype;

  @ApiModelProperty(example = "relay0.mailbaby.net", required = true, value = "transaction host")
 /**
   * transaction host
  **/
  private String transhost;

  @ApiModelProperty(example = "199.231.189.154", required = true, value = "origin host")
 /**
   * origin host
  **/
  private String originhost;

  @ApiModelProperty(example = "199.231.189.154", required = true, value = "origin ip")
 /**
   * origin ip
  **/
  private String origin;

  @ApiModelProperty(example = "feeder", required = true, value = "interface name")
 /**
   * interface name
  **/
  private String _interface;

  @ApiModelProperty(example = "Thu, 14 Oct 2021 08:50:09 -0400", required = true, value = "date processed")
 /**
   * date processed
  **/
  private String date;

  @ApiModelProperty(example = "interserver", required = true, value = "sending zone")
 /**
   * sending zone
  **/
  private String sendingZone;

  @ApiModelProperty(example = "63", required = true, value = "email body size in bytes")
 /**
   * email body size in bytes
  **/
  private Integer bodySize;

  @ApiModelProperty(example = "1d7058e6a30369f200b0c34fab2fac92", required = true, value = "md5 sum of the email")
 /**
   * md5 sum of the email
  **/
  private String sourceMd5;

  @ApiModelProperty(example = "1", required = true, value = "delivery sequency")
 /**
   * delivery sequency
  **/
  private Integer seq;

  @ApiModelProperty(example = "interserver.net", required = true, value = "to address domain")
 /**
   * to address domain
  **/
  private String domain;

  @ApiModelProperty(example = "client@isp.com", required = true, value = "email receiver address")
 /**
   * email receiver address
  **/
  private String recipient;

  @ApiModelProperty(example = "1", required = true, value = "locked status")
 /**
   * locked status
  **/
  private Integer locked;

  @ApiModelProperty(example = "1634215818533", required = true, value = "lock timestamp")
 /**
   * lock timestamp
  **/
  private Integer lockTime;

  @ApiModelProperty(example = "relay1", required = true, value = "assigned server")
 /**
   * assigned server
  **/
  private String assigned;

  @ApiModelProperty(example = "2021-10-14T12:50:15.487Z", required = true, value = "queued timestamp")
 /**
   * queued timestamp
  **/
  private String queued;

  @ApiModelProperty(example = "lock 17c7eda538e0005d03 001", required = true, value = "lock id")
 /**
   * lock id
  **/
  private String lock;

  @ApiModelProperty(required = true, value = "logger")
 /**
   * logger
  **/
  private String logger;

  @ApiModelProperty(example = "25", required = true, value = "mx port number")
 /**
   * mx port number
  **/
  private Integer mxPort;

  @ApiModelProperty(example = "206.72.200.46:interserver.net:25", required = true, value = "connection key")
 /**
   * connection key
  **/
  private String connectionKey;

  @ApiModelProperty(example = "mx.j.is.cc", required = true, value = "mx hostname")
 /**
   * mx hostname
  **/
  private String mxHostname;

  @ApiModelProperty(example = "1d7058e6a30369f200b0c34fab2fac92", required = true, value = "body hash")
 /**
   * body hash
  **/
  private String sentBodyHash;

  @ApiModelProperty(example = "63", required = true, value = "sent body size in bytes")
 /**
   * sent body size in bytes
  **/
  private Integer sentBodySize;

  @ApiModelProperty(example = "1", required = true, value = "md5 checksum matching result")
 /**
   * md5 checksum matching result
  **/
  private Integer md5Match;
 /**
   * internal db id
   * @return id
  **/
  @JsonProperty("_id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public MailLogEntry id(Integer id) {
    this.id = id;
    return this;
  }

 /**
   * mail id
   * @return id
  **/
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public MailLogEntry id(String id) {
    this.id = id;
    return this;
  }

 /**
   * from address
   * @return from
  **/
  @JsonProperty("from")
  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public MailLogEntry from(String from) {
    this.from = from;
    return this;
  }

 /**
   * to address
   * @return to
  **/
  @JsonProperty("to")
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public MailLogEntry to(String to) {
    this.to = to;
    return this;
  }

 /**
   * email subject
   * @return subject
  **/
  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public MailLogEntry subject(String subject) {
    this.subject = subject;
    return this;
  }

 /**
   * message id
   * @return messageId
  **/
  @JsonProperty("messageId")
  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public MailLogEntry messageId(String messageId) {
    this.messageId = messageId;
    return this;
  }

 /**
   * creation date
   * @return created
  **/
  @JsonProperty("created")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public MailLogEntry created(String created) {
    this.created = created;
    return this;
  }

 /**
   * creation timestamp
   * @return time
  **/
  @JsonProperty("time")
  public Integer getTime() {
    return time;
  }

  public void setTime(Integer time) {
    this.time = time;
  }

  public MailLogEntry time(Integer time) {
    this.time = time;
    return this;
  }

 /**
   * user account
   * @return user
  **/
  @JsonProperty("user")
  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public MailLogEntry user(String user) {
    this.user = user;
    return this;
  }

 /**
   * transaction type
   * @return transtype
  **/
  @JsonProperty("transtype")
  public String getTranstype() {
    return transtype;
  }

  public void setTranstype(String transtype) {
    this.transtype = transtype;
  }

  public MailLogEntry transtype(String transtype) {
    this.transtype = transtype;
    return this;
  }

 /**
   * transaction host
   * @return transhost
  **/
  @JsonProperty("transhost")
  public String getTranshost() {
    return transhost;
  }

  public void setTranshost(String transhost) {
    this.transhost = transhost;
  }

  public MailLogEntry transhost(String transhost) {
    this.transhost = transhost;
    return this;
  }

 /**
   * origin host
   * @return originhost
  **/
  @JsonProperty("originhost")
  public String getOriginhost() {
    return originhost;
  }

  public void setOriginhost(String originhost) {
    this.originhost = originhost;
  }

  public MailLogEntry originhost(String originhost) {
    this.originhost = originhost;
    return this;
  }

 /**
   * origin ip
   * @return origin
  **/
  @JsonProperty("origin")
  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public MailLogEntry origin(String origin) {
    this.origin = origin;
    return this;
  }

 /**
   * interface name
   * @return _interface
  **/
  @JsonProperty("interface")
  public String getInterface() {
    return _interface;
  }

  public void setInterface(String _interface) {
    this._interface = _interface;
  }

  public MailLogEntry _interface(String _interface) {
    this._interface = _interface;
    return this;
  }

 /**
   * date processed
   * @return date
  **/
  @JsonProperty("date")
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public MailLogEntry date(String date) {
    this.date = date;
    return this;
  }

 /**
   * sending zone
   * @return sendingZone
  **/
  @JsonProperty("sendingZone")
  public String getSendingZone() {
    return sendingZone;
  }

  public void setSendingZone(String sendingZone) {
    this.sendingZone = sendingZone;
  }

  public MailLogEntry sendingZone(String sendingZone) {
    this.sendingZone = sendingZone;
    return this;
  }

 /**
   * email body size in bytes
   * @return bodySize
  **/
  @JsonProperty("bodySize")
  public Integer getBodySize() {
    return bodySize;
  }

  public void setBodySize(Integer bodySize) {
    this.bodySize = bodySize;
  }

  public MailLogEntry bodySize(Integer bodySize) {
    this.bodySize = bodySize;
    return this;
  }

 /**
   * md5 sum of the email
   * @return sourceMd5
  **/
  @JsonProperty("sourceMd5")
  public String getSourceMd5() {
    return sourceMd5;
  }

  public void setSourceMd5(String sourceMd5) {
    this.sourceMd5 = sourceMd5;
  }

  public MailLogEntry sourceMd5(String sourceMd5) {
    this.sourceMd5 = sourceMd5;
    return this;
  }

 /**
   * delivery sequency
   * @return seq
  **/
  @JsonProperty("seq")
  public Integer getSeq() {
    return seq;
  }

  public void setSeq(Integer seq) {
    this.seq = seq;
  }

  public MailLogEntry seq(Integer seq) {
    this.seq = seq;
    return this;
  }

 /**
   * to address domain
   * @return domain
  **/
  @JsonProperty("domain")
  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public MailLogEntry domain(String domain) {
    this.domain = domain;
    return this;
  }

 /**
   * email receiver address
   * @return recipient
  **/
  @JsonProperty("recipient")
  public String getRecipient() {
    return recipient;
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  public MailLogEntry recipient(String recipient) {
    this.recipient = recipient;
    return this;
  }

 /**
   * locked status
   * @return locked
  **/
  @JsonProperty("locked")
  public Integer getLocked() {
    return locked;
  }

  public void setLocked(Integer locked) {
    this.locked = locked;
  }

  public MailLogEntry locked(Integer locked) {
    this.locked = locked;
    return this;
  }

 /**
   * lock timestamp
   * @return lockTime
  **/
  @JsonProperty("lockTime")
  public Integer getLockTime() {
    return lockTime;
  }

  public void setLockTime(Integer lockTime) {
    this.lockTime = lockTime;
  }

  public MailLogEntry lockTime(Integer lockTime) {
    this.lockTime = lockTime;
    return this;
  }

 /**
   * assigned server
   * @return assigned
  **/
  @JsonProperty("assigned")
  public String getAssigned() {
    return assigned;
  }

  public void setAssigned(String assigned) {
    this.assigned = assigned;
  }

  public MailLogEntry assigned(String assigned) {
    this.assigned = assigned;
    return this;
  }

 /**
   * queued timestamp
   * @return queued
  **/
  @JsonProperty("queued")
  public String getQueued() {
    return queued;
  }

  public void setQueued(String queued) {
    this.queued = queued;
  }

  public MailLogEntry queued(String queued) {
    this.queued = queued;
    return this;
  }

 /**
   * lock id
   * @return lock
  **/
  @JsonProperty("_lock")
  public String getLock() {
    return lock;
  }

  public void setLock(String lock) {
    this.lock = lock;
  }

  public MailLogEntry lock(String lock) {
    this.lock = lock;
    return this;
  }

 /**
   * logger
   * @return logger
  **/
  @JsonProperty("logger")
  public String getLogger() {
    return logger;
  }

  public void setLogger(String logger) {
    this.logger = logger;
  }

  public MailLogEntry logger(String logger) {
    this.logger = logger;
    return this;
  }

 /**
   * mx port number
   * @return mxPort
  **/
  @JsonProperty("mxPort")
  public Integer getMxPort() {
    return mxPort;
  }

  public void setMxPort(Integer mxPort) {
    this.mxPort = mxPort;
  }

  public MailLogEntry mxPort(Integer mxPort) {
    this.mxPort = mxPort;
    return this;
  }

 /**
   * connection key
   * @return connectionKey
  **/
  @JsonProperty("connectionKey")
  public String getConnectionKey() {
    return connectionKey;
  }

  public void setConnectionKey(String connectionKey) {
    this.connectionKey = connectionKey;
  }

  public MailLogEntry connectionKey(String connectionKey) {
    this.connectionKey = connectionKey;
    return this;
  }

 /**
   * mx hostname
   * @return mxHostname
  **/
  @JsonProperty("mxHostname")
  public String getMxHostname() {
    return mxHostname;
  }

  public void setMxHostname(String mxHostname) {
    this.mxHostname = mxHostname;
  }

  public MailLogEntry mxHostname(String mxHostname) {
    this.mxHostname = mxHostname;
    return this;
  }

 /**
   * body hash
   * @return sentBodyHash
  **/
  @JsonProperty("sentBodyHash")
  public String getSentBodyHash() {
    return sentBodyHash;
  }

  public void setSentBodyHash(String sentBodyHash) {
    this.sentBodyHash = sentBodyHash;
  }

  public MailLogEntry sentBodyHash(String sentBodyHash) {
    this.sentBodyHash = sentBodyHash;
    return this;
  }

 /**
   * sent body size in bytes
   * @return sentBodySize
  **/
  @JsonProperty("sentBodySize")
  public Integer getSentBodySize() {
    return sentBodySize;
  }

  public void setSentBodySize(Integer sentBodySize) {
    this.sentBodySize = sentBodySize;
  }

  public MailLogEntry sentBodySize(Integer sentBodySize) {
    this.sentBodySize = sentBodySize;
    return this;
  }

 /**
   * md5 checksum matching result
   * @return md5Match
  **/
  @JsonProperty("md5Match")
  public Integer getMd5Match() {
    return md5Match;
  }

  public void setMd5Match(Integer md5Match) {
    this.md5Match = md5Match;
  }

  public MailLogEntry md5Match(Integer md5Match) {
    this.md5Match = md5Match;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailLogEntry {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
    sb.append("    lock: ").append(toIndentedString(lock)).append("\n");
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
  private static String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

