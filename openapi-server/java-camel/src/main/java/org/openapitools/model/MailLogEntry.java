package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The &#x60;id&#x60; field matches the &#x60;mailid&#x60; query parameter on &#x60;GET /mail/log&#x60; and   the &#x60;text&#x60; field of a successful send response. - The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist a   flagged sender. - The &#x60;user&#x60; field is the SMTP username (e.g. &#x60;mb5658&#x60;) corresponding to the   &#x60;username&#x60; field in &#x60;GET /mail&#x60; / &#x60;GET /mail/{id}&#x60;.
 */

@Schema(name = "MailLogEntry", description = "A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The `id` field matches the `mailid` query parameter on `GET /mail/log` and   the `text` field of a successful send response. - The `from` address can be passed to `POST /mail/blocks/delete` to delist a   flagged sender. - The `user` field is the SMTP username (e.g. `mb5658`) corresponding to the   `username` field in `GET /mail` / `GET /mail/{id}`.")
@Generated(value = "org.openapitools.codegen.languages.JavaCamelServerCodegen", comments = "Generator version: 7.26.0")
public class MailLogEntry {

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

  private JsonNullable<String> subject = JsonNullable.<String>undefined();

  private JsonNullable<String> messageId = JsonNullable.<String>undefined();

  private JsonNullable<String> sendingZone = JsonNullable.<String>undefined();

  private JsonNullable<Integer> bodySize = JsonNullable.<Integer>undefined();

  private JsonNullable<Integer> seq = JsonNullable.<Integer>undefined();

  private JsonNullable<Integer> delivered = JsonNullable.<Integer>undefined();

  private JsonNullable<Integer> code = JsonNullable.<Integer>undefined();

  private JsonNullable<String> response = JsonNullable.<String>undefined();

  private JsonNullable<String> recipient = JsonNullable.<String>undefined();

  private JsonNullable<String> domain = JsonNullable.<String>undefined();

  private JsonNullable<Integer> locked = JsonNullable.<Integer>undefined();

  private JsonNullable<String> lockTime = JsonNullable.<String>undefined();

  private JsonNullable<String> assigned = JsonNullable.<String>undefined();

  private JsonNullable<String> queued = JsonNullable.<String>undefined();

  private JsonNullable<String> mxHostname = JsonNullable.<String>undefined();

  public MailLogEntry() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MailLogEntry(Integer id, String id, String from, String to, String created, Integer time, String user, String transtype, String origin, String _interface) {
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
  }

  public MailLogEntry id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Internal auto-increment database row ID.  Not meaningful outside the API.
   * @return id
   */
  @NotNull 
  @Schema(name = "_id", example = "103172", description = "Internal auto-increment database row ID.  Not meaningful outside the API.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("_id")
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
  @NotNull @Size(min = 18, max = 19) 
  @Schema(name = "id", example = "17c7eda538e0005d03", description = "The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
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
  @NotNull 
  @Schema(name = "from", example = "person@mysite.com", description = "SMTP envelope `MAIL FROM` address (may differ from the `From:` header).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("from")
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
  @NotNull 
  @Schema(name = "to", example = "client@isp.com", description = "SMTP envelope `RCPT TO` address.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("to")
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
  @NotNull 
  @Schema(name = "created", example = "2021-10-14 08:50:10", description = "Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("created")
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
  @NotNull 
  @Schema(name = "time", example = "1634215809", description = "Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("time")
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
  @NotNull 
  @Schema(name = "user", example = "mb5658", description = "The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("user")
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
  @NotNull 
  @Schema(name = "transtype", example = "ESMTPSA", description = "SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("transtype")
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
  @NotNull 
  @Schema(name = "origin", example = "199.231.189.154", description = "IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("origin")
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
  @NotNull 
  @Schema(name = "interface", example = "feeder", description = "Relay interface name that accepted the message (e.g. `feeder`).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("interface")
  public String getInterface() {
    return _interface;
  }

  public void setInterface(String _interface) {
    this._interface = _interface;
  }

  public MailLogEntry subject(String subject) {
    this.subject = JsonNullable.of(subject);
    return this;
  }

  /**
   * The `Subject` header value, if available.
   * @return subject
   */
  
  @Schema(name = "subject", example = "sell 0.005 shares", description = "The `Subject` header value, if available.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("subject")
  public JsonNullable<String> getSubject() {
    return subject;
  }

  public void setSubject(JsonNullable<String> subject) {
    this.subject = subject;
  }

  public MailLogEntry messageId(String messageId) {
    this.messageId = JsonNullable.of(messageId);
    return this;
  }

  /**
   * The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.
   * @return messageId
   */
  
  @Schema(name = "messageId", example = "<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>", description = "The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("messageId")
  public JsonNullable<String> getMessageId() {
    return messageId;
  }

  public void setMessageId(JsonNullable<String> messageId) {
    this.messageId = messageId;
  }

  public MailLogEntry sendingZone(String sendingZone) {
    this.sendingZone = JsonNullable.of(sendingZone);
    return this;
  }

  /**
   * The sending zone assigned by the relay for outbound delivery.
   * @return sendingZone
   */
  
  @Schema(name = "sendingZone", example = "interserver", description = "The sending zone assigned by the relay for outbound delivery.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sendingZone")
  public JsonNullable<String> getSendingZone() {
    return sendingZone;
  }

  public void setSendingZone(JsonNullable<String> sendingZone) {
    this.sendingZone = sendingZone;
  }

  public MailLogEntry bodySize(Integer bodySize) {
    this.bodySize = JsonNullable.of(bodySize);
    return this;
  }

  /**
   * Size of the message body in bytes.
   * @return bodySize
   */
  
  @Schema(name = "bodySize", example = "63", description = "Size of the message body in bytes.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bodySize")
  public JsonNullable<Integer> getBodySize() {
    return bodySize;
  }

  public void setBodySize(JsonNullable<Integer> bodySize) {
    this.bodySize = bodySize;
  }

  public MailLogEntry seq(Integer seq) {
    this.seq = JsonNullable.of(seq);
    return this;
  }

  /**
   * Sequence index of this recipient in a multi-recipient message. Starts at 1.
   * @return seq
   */
  
  @Schema(name = "seq", example = "1", description = "Sequence index of this recipient in a multi-recipient message. Starts at 1.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("seq")
  public JsonNullable<Integer> getSeq() {
    return seq;
  }

  public void setSeq(JsonNullable<Integer> seq) {
    this.seq = seq;
  }

  public MailLogEntry delivered(Integer delivered) {
    this.delivered = JsonNullable.of(delivered);
    return this;
  }

  /**
   * Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.
   * @return delivered
   */
  
  @Schema(name = "delivered", example = "1", description = "Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("delivered")
  public JsonNullable<Integer> getDelivered() {
    return delivered;
  }

  public void setDelivered(JsonNullable<Integer> delivered) {
    this.delivered = delivered;
  }

  public MailLogEntry code(Integer code) {
    this.code = JsonNullable.of(code);
    return this;
  }

  /**
   * The SMTP response code from the destination MX server (e.g. `250` for success, `550` for permanent failure).
   * @return code
   */
  
  @Schema(name = "code", example = "250", description = "The SMTP response code from the destination MX server (e.g. `250` for success, `550` for permanent failure).", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("code")
  public JsonNullable<Integer> getCode() {
    return code;
  }

  public void setCode(JsonNullable<Integer> code) {
    this.code = code;
  }

  public MailLogEntry response(String response) {
    this.response = JsonNullable.of(response);
    return this;
  }

  /**
   * The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).
   * @return response
   */
  
  @Schema(name = "response", example = "250 2.0.0 Ok queued as C91D83E128C", description = "The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("response")
  public JsonNullable<String> getResponse() {
    return response;
  }

  public void setResponse(JsonNullable<String> response) {
    this.response = response;
  }

  public MailLogEntry recipient(String recipient) {
    this.recipient = JsonNullable.of(recipient);
    return this;
  }

  /**
   * The specific recipient address this delivery record is for.
   * @return recipient
   */
  
  @Schema(name = "recipient", example = "client@isp.com", description = "The specific recipient address this delivery record is for.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("recipient")
  public JsonNullable<String> getRecipient() {
    return recipient;
  }

  public void setRecipient(JsonNullable<String> recipient) {
    this.recipient = recipient;
  }

  public MailLogEntry domain(String domain) {
    this.domain = JsonNullable.of(domain);
    return this;
  }

  /**
   * The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.
   * @return domain
   */
  
  @Schema(name = "domain", example = "interserver.net", description = "The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("domain")
  public JsonNullable<String> getDomain() {
    return domain;
  }

  public void setDomain(JsonNullable<String> domain) {
    this.domain = domain;
  }

  public MailLogEntry locked(Integer locked) {
    this.locked = JsonNullable.of(locked);
    return this;
  }

  /**
   * Whether the queue entry is currently locked for delivery processing.
   * @return locked
   */
  
  @Schema(name = "locked", example = "1", description = "Whether the queue entry is currently locked for delivery processing.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("locked")
  public JsonNullable<Integer> getLocked() {
    return locked;
  }

  public void setLocked(JsonNullable<Integer> locked) {
    this.locked = locked;
  }

  public MailLogEntry lockTime(String lockTime) {
    this.lockTime = JsonNullable.of(lockTime);
    return this;
  }

  /**
   * Millisecond-precision timestamp of the last queue lock acquisition.
   * @return lockTime
   */
  
  @Schema(name = "lockTime", example = "1634215818533", description = "Millisecond-precision timestamp of the last queue lock acquisition.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lockTime")
  public JsonNullable<String> getLockTime() {
    return lockTime;
  }

  public void setLockTime(JsonNullable<String> lockTime) {
    this.lockTime = lockTime;
  }

  public MailLogEntry assigned(String assigned) {
    this.assigned = JsonNullable.of(assigned);
    return this;
  }

  /**
   * The relay server node assigned to deliver this message.
   * @return assigned
   */
  
  @Schema(name = "assigned", example = "relay1", description = "The relay server node assigned to deliver this message.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("assigned")
  public JsonNullable<String> getAssigned() {
    return assigned;
  }

  public void setAssigned(JsonNullable<String> assigned) {
    this.assigned = assigned;
  }

  public MailLogEntry queued(String queued) {
    this.queued = JsonNullable.of(queued);
    return this;
  }

  /**
   * ISO 8601 timestamp when the message was placed into the delivery queue.
   * @return queued
   */
  
  @Schema(name = "queued", example = "2021-10-14T12:50:15.487Z", description = "ISO 8601 timestamp when the message was placed into the delivery queue.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("queued")
  public JsonNullable<String> getQueued() {
    return queued;
  }

  public void setQueued(JsonNullable<String> queued) {
    this.queued = queued;
  }

  public MailLogEntry mxHostname(String mxHostname) {
    this.mxHostname = JsonNullable.of(mxHostname);
    return this;
  }

  /**
   * The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.
   * @return mxHostname
   */
  
  @Schema(name = "mxHostname", example = "mx.j.is.cc", description = "The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mxHostname")
  public JsonNullable<String> getMxHostname() {
    return mxHostname;
  }

  public void setMxHostname(JsonNullable<String> mxHostname) {
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
        equalsNullable(this.subject, mailLogEntry.subject) &&
        equalsNullable(this.messageId, mailLogEntry.messageId) &&
        equalsNullable(this.sendingZone, mailLogEntry.sendingZone) &&
        equalsNullable(this.bodySize, mailLogEntry.bodySize) &&
        equalsNullable(this.seq, mailLogEntry.seq) &&
        equalsNullable(this.delivered, mailLogEntry.delivered) &&
        equalsNullable(this.code, mailLogEntry.code) &&
        equalsNullable(this.response, mailLogEntry.response) &&
        equalsNullable(this.recipient, mailLogEntry.recipient) &&
        equalsNullable(this.domain, mailLogEntry.domain) &&
        equalsNullable(this.locked, mailLogEntry.locked) &&
        equalsNullable(this.lockTime, mailLogEntry.lockTime) &&
        equalsNullable(this.assigned, mailLogEntry.assigned) &&
        equalsNullable(this.queued, mailLogEntry.queued) &&
        equalsNullable(this.mxHostname, mailLogEntry.mxHostname);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, id, from, to, created, time, user, transtype, origin, _interface, hashCodeNullable(subject), hashCodeNullable(messageId), hashCodeNullable(sendingZone), hashCodeNullable(bodySize), hashCodeNullable(seq), hashCodeNullable(delivered), hashCodeNullable(code), hashCodeNullable(response), hashCodeNullable(recipient), hashCodeNullable(domain), hashCodeNullable(locked), hashCodeNullable(lockTime), hashCodeNullable(assigned), hashCodeNullable(queued), hashCodeNullable(mxHostname));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
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

