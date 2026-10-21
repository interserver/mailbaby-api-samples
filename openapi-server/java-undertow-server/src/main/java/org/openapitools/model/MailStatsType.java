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
import org.openapitools.model.MailStatsVolume;



/**
 * Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
 */

@ApiModel(description = "Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaUndertowServerCodegen", comments = "Generator version: 7.26.0")
public class MailStatsType   {
  


  public enum TimeEnum {
    All("all"),
    Billing("billing"),
    Month("month"),
    SevenDays("7d"),
    TwentyFourHours("24h"),
    Day("day"),
    OneHour("1h"),
    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private String value;

    TimeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }

  private TimeEnum time = TimeEnum.OneHour;
  private Integer usage;
  private String currency;
  private Double cost;
  private Integer received;
  private Integer sent;
  private MailStatsVolume volume;

  /**
   * The time window these `received`, `sent`, and `volume` statistics cover.
   */
  public MailStatsType time(TimeEnum time) {
    this.time = time;
    return this;
  }

  
  @ApiModelProperty(value = "The time window these `received`, `sent`, and `volume` statistics cover.")
  @JsonProperty("time")
  public TimeEnum getTime() {
    return time;
  }
  public void setTime(TimeEnum time) {
    this.time = time;
  }

  /**
   * Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
   */
  public MailStatsType usage(Integer usage) {
    this.usage = usage;
    return this;
  }

  
  @ApiModelProperty(value = "Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.")
  @JsonProperty("usage")
  public Integer getUsage() {
    return usage;
  }
  public void setUsage(Integer usage) {
    this.usage = usage;
  }

  /**
   * The ISO 4217 currency code for this account (e.g. `USD`).
   */
  public MailStatsType currency(String currency) {
    this.currency = currency;
    return this;
  }

  
  @ApiModelProperty(value = "The ISO 4217 currency code for this account (e.g. `USD`).")
  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  /**
   * Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
   */
  public MailStatsType cost(Double cost) {
    this.cost = cost;
    return this;
  }

  
  @ApiModelProperty(value = "Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).")
  @JsonProperty("cost")
  public Double getCost() {
    return cost;
  }
  public void setCost(Double cost) {
    this.cost = cost;
  }

  /**
   * Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
   */
  public MailStatsType received(Integer received) {
    this.received = received;
    return this;
  }

  
  @ApiModelProperty(value = "Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.")
  @JsonProperty("received")
  public Integer getReceived() {
    return received;
  }
  public void setReceived(Integer received) {
    this.received = received;
  }

  /**
   * Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
   */
  public MailStatsType sent(Integer sent) {
    this.sent = sent;
    return this;
  }

  
  @ApiModelProperty(value = "Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.")
  @JsonProperty("sent")
  public Integer getSent() {
    return sent;
  }
  public void setSent(Integer sent) {
    this.sent = sent;
  }

  /**
   */
  public MailStatsType volume(MailStatsVolume volume) {
    this.volume = volume;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("volume")
  public MailStatsVolume getVolume() {
    return volume;
  }
  public void setVolume(MailStatsVolume volume) {
    this.volume = volume;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailStatsType mailStatsType = (MailStatsType) o;
    return Objects.equals(time, mailStatsType.time) &&
        Objects.equals(usage, mailStatsType.usage) &&
        Objects.equals(currency, mailStatsType.currency) &&
        Objects.equals(cost, mailStatsType.cost) &&
        Objects.equals(received, mailStatsType.received) &&
        Objects.equals(sent, mailStatsType.sent) &&
        Objects.equals(volume, mailStatsType.volume);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, usage, currency, cost, received, sent, volume);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailStatsType {\n");
    
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    usage: ").append(toIndentedString(usage)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
    sb.append("    received: ").append(toIndentedString(received)).append("\n");
    sb.append("    sent: ").append(toIndentedString(sent)).append("\n");
    sb.append("    volume: ").append(toIndentedString(volume)).append("\n");
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

