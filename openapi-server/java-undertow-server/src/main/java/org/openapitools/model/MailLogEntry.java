/*
 * MailBaby Email Delivery and Management Service API
 *
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**  # Overview  This is the API interface to the [Mail Baby](https://mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).  # Mail Orders  Every sending account in MailBaby is backed by a **Mail Order** — a provisioned sending credential with a numeric `id` and a corresponding SMTP username (`mb<id>`).  Most calls accept an optional `id` parameter; when omitted the API automatically selects the first active order on your account. Use `GET /mail` to list all orders, and `GET /mail/{id}` to inspect a single order including its current SMTP password.  # Sending Email  Three sending methods are available depending on your use-case: | Endpoint | Best for | |----------|----------| | `POST /mail/send` | Simple single-recipient messages | | `POST /mail/advsend` | Multiple recipients, CC/BCC, attachments, named contacts | | `POST /mail/rawsend` | Pre-built RFC 822 messages (e.g. DKIM-signed payloads) |  After a successful send each endpoint returns a `GenericResponse` whose `text` field contains the **transaction ID** assigned by the relay.  This ID can later be matched against entries in `GET /mail/log` via the `mailid` query parameter.  # Filtering & Logs  `GET /mail/log` provides paginated access to every message accepted by the relay for your account. Combine any of the query parameters to narrow results — e.g. `from`, `to`, `subject`, `messageId`, `origin`, `mx`, `startDate`/`endDate`, and `delivered`.  # Blocking  Two independent mechanisms exist for suppressing unwanted email: - **Block lists** (`GET /mail/blocks`, `POST /mail/blocks/delete`) — addresses flagged by the   system spam filters (LOCAL_BL_RCPT / MBTRAP rules in rspamd, and suspicious subjects). - **Deny rules** (`GET /mail/rules`, `POST /mail/rules`, `DELETE /mail/rules/{ruleId}`) —   custom rules you configure to reject specific senders, domains, destination addresses, or   subject-line prefixes before a message is even attempted.   # Authentication  In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. Pass your key in the `X-API-KEY` HTTP request header for every protected call. 
 *
 * OpenAPI document version: 1.5.0
 * Maintained by: support@interserver.net
 *
 * AUTO-GENERATED FILE, DO NOT MODIFY!
 */
package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;



/**
 * A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The `id` field matches the `mailid` query parameter on `GET /mail/log` and   the `text` field of a successful send response. - The `from` address can be passed to `POST /mail/blocks/delete` to delist a   flagged sender. - The `user` field is the SMTP username (e.g. `mb5658`) corresponding to the   `username` field in `GET /mail` / `GET /mail/{id}`.
 */

@ApiModel(description = "A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The `id` field matches the `mailid` query parameter on `GET /mail/log` and   the `text` field of a successful send response. - The `from` address can be passed to `POST /mail/blocks/delete` to delist a   flagged sender. - The `user` field is the SMTP username (e.g. `mb5658`) corresponding to the   `username` field in `GET /mail` / `GET /mail/{id}`.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaUndertowServerCodegen", comments = "Generator version: 7.26.0")
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
   * Internal auto-increment database row ID.  Not meaningful outside the API.
   */
  public MailLogEntry id(Integer id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "103172", required = true, value = "Internal auto-increment database row ID.  Not meaningful outside the API.")
  @JsonProperty("_id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.
   */
  public MailLogEntry id(String id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "17c7eda538e0005d03", required = true, value = "The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  /**
   * SMTP envelope `MAIL FROM` address (may differ from the `From:` header).
   */
  public MailLogEntry from(String from) {
    this.from = from;
    return this;
  }

  
  @ApiModelProperty(example = "person@mysite.com", required = true, value = "SMTP envelope `MAIL FROM` address (may differ from the `From:` header).")
  @JsonProperty("from")
  public String getFrom() {
    return from;
  }
  public void setFrom(String from) {
    this.from = from;
  }

  /**
   * SMTP envelope `RCPT TO` address.
   */
  public MailLogEntry to(String to) {
    this.to = to;
    return this;
  }

  
  @ApiModelProperty(example = "client@isp.com", required = true, value = "SMTP envelope `RCPT TO` address.")
  @JsonProperty("to")
  public String getTo() {
    return to;
  }
  public void setTo(String to) {
    this.to = to;
  }

  /**
   * Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.
   */
  public MailLogEntry created(String created) {
    this.created = created;
    return this;
  }

  
  @ApiModelProperty(example = "2021-10-14 08:50:10", required = true, value = "Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.")
  @JsonProperty("created")
  public String getCreated() {
    return created;
  }
  public void setCreated(String created) {
    this.created = created;
  }

  /**
   * Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.
   */
  public MailLogEntry time(Integer time) {
    this.time = time;
    return this;
  }

  
  @ApiModelProperty(example = "1634215809", required = true, value = "Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.")
  @JsonProperty("time")
  public Integer getTime() {
    return time;
  }
  public void setTime(Integer time) {
    this.time = time;
  }

  /**
   * The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.
   */
  public MailLogEntry user(String user) {
    this.user = user;
    return this;
  }

  
  @ApiModelProperty(example = "mb5658", required = true, value = "The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.")
  @JsonProperty("user")
  public String getUser() {
    return user;
  }
  public void setUser(String user) {
    this.user = user;
  }

  /**
   * SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).
   */
  public MailLogEntry transtype(String transtype) {
    this.transtype = transtype;
    return this;
  }

  
  @ApiModelProperty(example = "ESMTPSA", required = true, value = "SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).")
  @JsonProperty("transtype")
  public String getTranstype() {
    return transtype;
  }
  public void setTranstype(String transtype) {
    this.transtype = transtype;
  }

  /**
   * IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.
   */
  public MailLogEntry origin(String origin) {
    this.origin = origin;
    return this;
  }

  
  @ApiModelProperty(example = "199.231.189.154", required = true, value = "IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.")
  @JsonProperty("origin")
  public String getOrigin() {
    return origin;
  }
  public void setOrigin(String origin) {
    this.origin = origin;
  }

  /**
   * Relay interface name that accepted the message (e.g. `feeder`).
   */
  public MailLogEntry _interface(String _interface) {
    this._interface = _interface;
    return this;
  }

  
  @ApiModelProperty(example = "feeder", required = true, value = "Relay interface name that accepted the message (e.g. `feeder`).")
  @JsonProperty("interface")
  public String getInterface() {
    return _interface;
  }
  public void setInterface(String _interface) {
    this._interface = _interface;
  }

  /**
   * The `Subject` header value, if available.
   */
  public MailLogEntry subject(String subject) {
    this.subject = subject;
    return this;
  }

  
  @ApiModelProperty(example = "sell 0.005 shares", value = "The `Subject` header value, if available.")
  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.
   */
  public MailLogEntry messageId(String messageId) {
    this.messageId = messageId;
    return this;
  }

  
  @ApiModelProperty(example = "<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>", value = "The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.")
  @JsonProperty("messageId")
  public String getMessageId() {
    return messageId;
  }
  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  /**
   * The sending zone assigned by the relay for outbound delivery.
   */
  public MailLogEntry sendingZone(String sendingZone) {
    this.sendingZone = sendingZone;
    return this;
  }

  
  @ApiModelProperty(example = "interserver", value = "The sending zone assigned by the relay for outbound delivery.")
  @JsonProperty("sendingZone")
  public String getSendingZone() {
    return sendingZone;
  }
  public void setSendingZone(String sendingZone) {
    this.sendingZone = sendingZone;
  }

  /**
   * Size of the message body in bytes.
   */
  public MailLogEntry bodySize(Integer bodySize) {
    this.bodySize = bodySize;
    return this;
  }

  
  @ApiModelProperty(example = "63", value = "Size of the message body in bytes.")
  @JsonProperty("bodySize")
  public Integer getBodySize() {
    return bodySize;
  }
  public void setBodySize(Integer bodySize) {
    this.bodySize = bodySize;
  }

  /**
   * Sequence index of this recipient in a multi-recipient message. Starts at 1.
   */
  public MailLogEntry seq(Integer seq) {
    this.seq = seq;
    return this;
  }

  
  @ApiModelProperty(example = "1", value = "Sequence index of this recipient in a multi-recipient message. Starts at 1.")
  @JsonProperty("seq")
  public Integer getSeq() {
    return seq;
  }
  public void setSeq(Integer seq) {
    this.seq = seq;
  }

  /**
   * Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.
   */
  public MailLogEntry delivered(Integer delivered) {
    this.delivered = delivered;
    return this;
  }

  
  @ApiModelProperty(example = "1", value = "Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.")
  @JsonProperty("delivered")
  public Integer getDelivered() {
    return delivered;
  }
  public void setDelivered(Integer delivered) {
    this.delivered = delivered;
  }

  /**
   * The SMTP response code from the destination MX server (e.g. `250` for success, `550` for permanent failure).
   */
  public MailLogEntry code(Integer code) {
    this.code = code;
    return this;
  }

  
  @ApiModelProperty(example = "250", value = "The SMTP response code from the destination MX server (e.g. `250` for success, `550` for permanent failure).")
  @JsonProperty("code")
  public Integer getCode() {
    return code;
  }
  public void setCode(Integer code) {
    this.code = code;
  }

  /**
   * The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).
   */
  public MailLogEntry response(String response) {
    this.response = response;
    return this;
  }

  
  @ApiModelProperty(example = "250 2.0.0 Ok queued as C91D83E128C", value = "The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).")
  @JsonProperty("response")
  public String getResponse() {
    return response;
  }
  public void setResponse(String response) {
    this.response = response;
  }

  /**
   * The specific recipient address this delivery record is for.
   */
  public MailLogEntry recipient(String recipient) {
    this.recipient = recipient;
    return this;
  }

  
  @ApiModelProperty(example = "client@isp.com", value = "The specific recipient address this delivery record is for.")
  @JsonProperty("recipient")
  public String getRecipient() {
    return recipient;
  }
  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  /**
   * The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.
   */
  public MailLogEntry domain(String domain) {
    this.domain = domain;
    return this;
  }

  
  @ApiModelProperty(example = "interserver.net", value = "The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.")
  @JsonProperty("domain")
  public String getDomain() {
    return domain;
  }
  public void setDomain(String domain) {
    this.domain = domain;
  }

  /**
   * Whether the queue entry is currently locked for delivery processing.
   */
  public MailLogEntry locked(Integer locked) {
    this.locked = locked;
    return this;
  }

  
  @ApiModelProperty(example = "1", value = "Whether the queue entry is currently locked for delivery processing.")
  @JsonProperty("locked")
  public Integer getLocked() {
    return locked;
  }
  public void setLocked(Integer locked) {
    this.locked = locked;
  }

  /**
   * Millisecond-precision timestamp of the last queue lock acquisition.
   */
  public MailLogEntry lockTime(String lockTime) {
    this.lockTime = lockTime;
    return this;
  }

  
  @ApiModelProperty(example = "1634215818533", value = "Millisecond-precision timestamp of the last queue lock acquisition.")
  @JsonProperty("lockTime")
  public String getLockTime() {
    return lockTime;
  }
  public void setLockTime(String lockTime) {
    this.lockTime = lockTime;
  }

  /**
   * The relay server node assigned to deliver this message.
   */
  public MailLogEntry assigned(String assigned) {
    this.assigned = assigned;
    return this;
  }

  
  @ApiModelProperty(example = "relay1", value = "The relay server node assigned to deliver this message.")
  @JsonProperty("assigned")
  public String getAssigned() {
    return assigned;
  }
  public void setAssigned(String assigned) {
    this.assigned = assigned;
  }

  /**
   * ISO 8601 timestamp when the message was placed into the delivery queue.
   */
  public MailLogEntry queued(String queued) {
    this.queued = queued;
    return this;
  }

  
  @ApiModelProperty(example = "2021-10-14T12:50:15.487Z", value = "ISO 8601 timestamp when the message was placed into the delivery queue.")
  @JsonProperty("queued")
  public String getQueued() {
    return queued;
  }
  public void setQueued(String queued) {
    this.queued = queued;
  }

  /**
   * The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.
   */
  public MailLogEntry mxHostname(String mxHostname) {
    this.mxHostname = mxHostname;
    return this;
  }

  
  @ApiModelProperty(example = "mx.j.is.cc", value = "The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.")
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

