package io.swagger.model;

import io.swagger.model.MailStatsVolume;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Account usage statistics returned by &#x60;GET /mail/stats&#x60;.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
 **/
import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
@Schema(description = "Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.")

public class MailStatsType   {

public enum TimeEnum {

    ALL(String.valueOf("all")), BILLING(String.valueOf("billing")), MONTH(String.valueOf("month")), _7D(String.valueOf("7d")), _24H(String.valueOf("24h")), DAY(String.valueOf("day")), _1H(String.valueOf("1h"));


    private String value;

    TimeEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static TimeEnum fromValue(String v) {
        for (TimeEnum b : TimeEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid TimeEnum time = TimeEnum._1H;

  private @Valid Integer usage = null;

  private @Valid String currency = null;

  private @Valid Double cost = null;

  private @Valid Integer received = null;

  private @Valid Integer sent = null;

  private @Valid MailStatsVolume volume = null;

  /**
   * The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover.
   **/
  public MailStatsType time(TimeEnum time) {
    this.time = time;
    return this;
  }

  
  @ApiModelProperty(value = "The time window these `received`, `sent`, and `volume` statistics cover.")
  @JsonProperty("time")
  @NotNull

  public TimeEnum getTime() {
    return time;
  }
  public void setTime(TimeEnum time) {
    this.time = time;
  }

  /**
   * Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value.
   **/
  public MailStatsType usage(Integer usage) {
    this.usage = usage;
    return this;
  }

  
  @ApiModelProperty(value = "Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.")
  @JsonProperty("usage")
  @NotNull

  public Integer getUsage() {
    return usage;
  }
  public void setUsage(Integer usage) {
    this.usage = usage;
  }

  /**
   * The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;).
   **/
  public MailStatsType currency(String currency) {
    this.currency = currency;
    return this;
  }

  
  @ApiModelProperty(value = "The ISO 4217 currency code for this account (e.g. `USD`).")
  @JsonProperty("currency")
  @NotNull

  public String getCurrency() {
    return currency;
  }
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  /**
   * Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
   **/
  public MailStatsType cost(Double cost) {
    this.cost = cost;
    return this;
  }

  
  @ApiModelProperty(value = "Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).")
  @JsonProperty("cost")
  @NotNull

  public Double getCost() {
    return cost;
  }
  public void setCost(Double cost) {
    this.cost = cost;
  }

  /**
   * Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue.
   **/
  public MailStatsType received(Integer received) {
    this.received = received;
    return this;
  }

  
  @ApiModelProperty(value = "Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.")
  @JsonProperty("received")
  @NotNull

  public Integer getReceived() {
    return received;
  }
  public void setReceived(Integer received) {
    this.received = received;
  }

  /**
   * Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;.
   **/
  public MailStatsType sent(Integer sent) {
    this.sent = sent;
    return this;
  }

  
  @ApiModelProperty(value = "Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.")
  @JsonProperty("sent")
  @NotNull

  public Integer getSent() {
    return sent;
  }
  public void setSent(Integer sent) {
    this.sent = sent;
  }

  /**
   **/
  public MailStatsType volume(MailStatsVolume volume) {
    this.volume = volume;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("volume")
  @NotNull

  public MailStatsVolume getVolume() {
    return volume;
  }
  public void setVolume(MailStatsVolume volume) {
    this.volume = volume;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
