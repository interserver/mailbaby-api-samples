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
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Extended mail order record including the current SMTP password.  Returned by `GET /mail/{id}`.  The `username` and `password` fields can be used to authenticate directly against `relay.mailbaby.net:25` via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
 */

@ApiModel(description = "Extended mail order record including the current SMTP password.  Returned by `GET /mail/{id}`.  The `username` and `password` fields can be used to authenticate directly against `relay.mailbaby.net:25` via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaUndertowServerCodegen", comments = "Generator version: 7.26.0")
public class MailOrderDetail   {
  
  private Integer id;


  public enum StatusEnum {
    ACTIVE("active"),
    CANCELED("canceled"),
    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }

  private StatusEnum status;
  private String username;
  private String password;
  private String comment;

  /**
   * The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
   */
  public MailOrderDetail id(Integer id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "21472", required = true, value = "The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.")
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
   */
  public MailOrderDetail status(StatusEnum status) {
    this.status = status;
    return this;
  }

  
  @ApiModelProperty(example = "active", required = true, value = "The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.")
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  /**
   * The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
   */
  public MailOrderDetail username(String username) {
    this.username = username;
    return this;
  }

  
  @ApiModelProperty(example = "mb21472", required = true, value = "The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.")
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.
   */
  public MailOrderDetail password(String password) {
    this.password = password;
    return this;
  }

  
  @ApiModelProperty(example = "s3cr3tpassword", required = true, value = "The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.")
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
   */
  public MailOrderDetail comment(String comment) {
    this.comment = comment;
    return this;
  }

  
  @ApiModelProperty(value = "Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.")
  @JsonProperty("comment")
  public String getComment() {
    return comment;
  }
  public void setComment(String comment) {
    this.comment = comment;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailOrderDetail mailOrderDetail = (MailOrderDetail) o;
    return Objects.equals(id, mailOrderDetail.id) &&
        Objects.equals(status, mailOrderDetail.status) &&
        Objects.equals(username, mailOrderDetail.username) &&
        Objects.equals(password, mailOrderDetail.password) &&
        Objects.equals(comment, mailOrderDetail.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, username, password, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailOrderDetail {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
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

