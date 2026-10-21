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
import java.util.HashMap;
import java.util.Map;



/**
 * Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
 */

@ApiModel(description = "Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaUndertowServerCodegen", comments = "Generator version: 7.26.0")
public class MailStatsVolume   {
  
  private Map<String, Integer> to = new HashMap<>();
  private Map<String, Integer> from = new HashMap<>();
  private Map<String, Integer> ip = new HashMap<>();

  /**
   * Message counts keyed by destination (envelope `to`) email address.
   */
  public MailStatsVolume to(Map<String, Integer> to) {
    this.to = to;
    return this;
  }

  
  @ApiModelProperty(value = "Message counts keyed by destination (envelope `to`) email address.")
  @JsonProperty("to")
  public Map<String, Integer> getTo() {
    return to;
  }
  public void setTo(Map<String, Integer> to) {
    this.to = to;
  }

  /**
   * Message counts keyed by sender (envelope `from`) email address.
   */
  public MailStatsVolume from(Map<String, Integer> from) {
    this.from = from;
    return this;
  }

  
  @ApiModelProperty(value = "Message counts keyed by sender (envelope `from`) email address.")
  @JsonProperty("from")
  public Map<String, Integer> getFrom() {
    return from;
  }
  public void setFrom(Map<String, Integer> from) {
    this.from = from;
  }

  /**
   * Message counts keyed by originating client IP address.
   */
  public MailStatsVolume ip(Map<String, Integer> ip) {
    this.ip = ip;
    return this;
  }

  
  @ApiModelProperty(value = "Message counts keyed by originating client IP address.")
  @JsonProperty("ip")
  public Map<String, Integer> getIp() {
    return ip;
  }
  public void setIp(Map<String, Integer> ip) {
    this.ip = ip;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailStatsVolume mailStatsVolume = (MailStatsVolume) o;
    return Objects.equals(to, mailStatsVolume.to) &&
        Objects.equals(from, mailStatsVolume.from) &&
        Objects.equals(ip, mailStatsVolume.ip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(to, from, ip);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailStatsVolume {\n");
    
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
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

