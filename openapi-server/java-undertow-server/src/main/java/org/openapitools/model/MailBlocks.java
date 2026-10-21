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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.MailBlockClickHouse;
import org.openapitools.model.MailBlockRspamd;



/**
 * The complete set of blocked addresses and message patterns returned by `GET /mail/blocks`. Three independent block sources are combined into one response. Use `POST /mail/blocks/delete` with a `from` address from any entry to delist it.
 */

@ApiModel(description = "The complete set of blocked addresses and message patterns returned by `GET /mail/blocks`. Three independent block sources are combined into one response. Use `POST /mail/blocks/delete` with a `from` address from any entry to delist it.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaUndertowServerCodegen", comments = "Generator version: 7.26.0")
public class MailBlocks   {
  
  private List<MailBlockClickHouse> local = new ArrayList<>();
  private List<MailBlockClickHouse> mbtrap = new ArrayList<>();
  private List<MailBlockRspamd> subject = new ArrayList<>();

  /**
   * Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
   */
  public MailBlocks local(List<MailBlockClickHouse> local) {
    this.local = local;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.")
  @JsonProperty("local")
  public List<MailBlockClickHouse> getLocal() {
    return local;
  }
  public void setLocal(List<MailBlockClickHouse> local) {
    this.local = local;
  }

  /**
   * Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.
   */
  public MailBlocks mbtrap(List<MailBlockClickHouse> mbtrap) {
    this.mbtrap = mbtrap;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.")
  @JsonProperty("mbtrap")
  public List<MailBlockClickHouse> getMbtrap() {
    return mbtrap;
  }
  public void setMbtrap(List<MailBlockClickHouse> mbtrap) {
    this.mbtrap = mbtrap;
  }

  /**
   * Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.
   */
  public MailBlocks subject(List<MailBlockRspamd> subject) {
    this.subject = subject;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.")
  @JsonProperty("subject")
  public List<MailBlockRspamd> getSubject() {
    return subject;
  }
  public void setSubject(List<MailBlockRspamd> subject) {
    this.subject = subject;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailBlocks mailBlocks = (MailBlocks) o;
    return Objects.equals(local, mailBlocks.local) &&
        Objects.equals(mbtrap, mailBlocks.mbtrap) &&
        Objects.equals(subject, mailBlocks.subject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(local, mbtrap, subject);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailBlocks {\n");
    
    sb.append("    local: ").append(toIndentedString(local)).append("\n");
    sb.append("    mbtrap: ").append(toIndentedString(mbtrap)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
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

