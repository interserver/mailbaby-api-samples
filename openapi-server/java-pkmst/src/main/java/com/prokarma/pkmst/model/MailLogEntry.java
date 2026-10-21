package com.prokarma.pkmst.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
/**
 * Response class to be returned by Api
 * @author pkmst
 *
 */
/**
 * A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The &#x60;id&#x60; field matches the &#x60;mailid&#x60; query parameter on &#x60;GET /mail/log&#x60; and   the &#x60;text&#x60; field of a successful send response. - The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist a   flagged sender. - The &#x60;user&#x60; field is the SMTP username (e.g. &#x60;mb5658&#x60;) corresponding to the   &#x60;username&#x60; field in &#x60;GET /mail&#x60; / &#x60;GET /mail/{id}&#x60;.
 */
@ApiModel(description = "A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The `id` field matches the `mailid` query parameter on `GET /mail/log` and   the `text` field of a successful send response. - The `from` address can be passed to `POST /mail/blocks/delete` to delist a   flagged sender. - The `user` field is the SMTP username (e.g. `mb5658`) corresponding to the   `username` field in `GET /mail` / `GET /mail/{id}`.")

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaPKMSTServerCodegen", comments = "Generator version: 7.26.0")
public class MailLogEntry   {
  @JsonProperty("_id")
  private Integer id;

  @JsonProperty("id")
  private String id;

  @JsonProperty("from")
  private String from;

  @JsonProperty("to")
  private String to;

  @JsonProperty("created")
  private String created;

  @JsonProperty("time")
  private Integer time;

  @JsonProperty("user")
  private String user;

  @JsonProperty("transtype")
  private String transtype;

  @JsonProperty("origin")
  private String origin;

  @JsonProperty("interface")
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
   */
  @ApiModelProperty(example = "103172", required = true, value = "Internal auto-increment database row ID.  Not meaningful outside the API.")
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
   */
  @ApiModelProperty(example = "17c7eda538e0005d03", required = true, value = "The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.")
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
   */
  @ApiModelProperty(example = "person@mysite.com", required = true, value = "SMTP envelope `MAIL FROM` address (may differ from the `From:` header).")
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
   */
  @ApiModelProperty(example = "client@isp.com", required = true, value = "SMTP envelope `RCPT TO` address.")
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
   */
  @ApiModelProperty(example = "2021-10-14 08:50:10", required = true, value = "Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.")
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
   */
  @ApiModelProperty(example = "1634215809", required = true, value = "Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.")
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
   */
  @ApiModelProperty(example = "mb5658", required = true, value = "The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.")
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
   */
  @ApiModelProperty(example = "ESMTPSA", required = true, value = "SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).")
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
   */
  @ApiModelProperty(example = "199.231.189.154", required = true, value = "IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.")
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
   */
  @ApiModelProperty(example = "feeder", required = true, value = "Relay interface name that accepted the message (e.g. `feeder`).")
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
   */
  @ApiModelProperty(example = "sell 0.005 shares", value = "The `Subject` header value, if available.")
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
   */
  @ApiModelProperty(example = "<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>", value = "The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.")
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
   */
  @ApiModelProperty(example = "interserver", value = "The sending zone assigned by the relay for outbound delivery.")
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
   */
  @ApiModelProperty(example = "63", value = "Size of the message body in bytes.")
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
   */
  @ApiModelProperty(example = "1", value = "Sequence index of this recipient in a multi-recipient message. Starts at 1.")
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
   */
  @ApiModelProperty(example = "1", value = "Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.")
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
   */
  @ApiModelProperty(example = "250", value = "The SMTP response code from the destination MX server (e.g. `250` for success, `550` for permanent failure).")
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
   */
  @ApiModelProperty(example = "250 2.0.0 Ok queued as C91D83E128C", value = "The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).")
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
   */
  @ApiModelProperty(example = "client@isp.com", value = "The specific recipient address this delivery record is for.")
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
   */
  @ApiModelProperty(example = "interserver.net", value = "The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.")
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
   */
  @ApiModelProperty(example = "1", value = "Whether the queue entry is currently locked for delivery processing.")
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
   */
  @ApiModelProperty(example = "1634215818533", value = "Millisecond-precision timestamp of the last queue lock acquisition.")
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
   */
  @ApiModelProperty(example = "relay1", value = "The relay server node assigned to deliver this message.")
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
   */
  @ApiModelProperty(example = "2021-10-14T12:50:15.487Z", value = "ISO 8601 timestamp when the message was placed into the delivery queue.")
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
   */
  @ApiModelProperty(example = "mx.j.is.cc", value = "The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.")
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

