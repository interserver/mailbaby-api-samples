package org.openapitools.model;

import org.openapitools.model.MailStatsTypeVolume;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
 */
@ApiModel(description="Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.")

public class MailStatsType  {
  
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
    public String toString() {
        return String.valueOf(value);
    }

    public static TimeEnum fromValue(String value) {
        for (TimeEnum b : TimeEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

 /**
  * The time window these `received`, `sent`, and `volume` statistics cover.
  */
  @ApiModelProperty(value = "The time window these `received`, `sent`, and `volume` statistics cover.")

  private TimeEnum time = TimeEnum._1H;

 /**
  * Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
  */
  @ApiModelProperty(value = "Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.")

  private Integer usage;

 /**
  * The ISO 4217 currency code for this account (e.g. `USD`).
  */
  @ApiModelProperty(value = "The ISO 4217 currency code for this account (e.g. `USD`).")

  private String currency;

 /**
  * Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
  */
  @ApiModelProperty(value = "Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).")

  private Double cost;

 /**
  * Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
  */
  @ApiModelProperty(value = "Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.")

  private Integer received;

 /**
  * Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
  */
  @ApiModelProperty(value = "Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.")

  private Integer sent;

  @ApiModelProperty(value = "")

  private MailStatsTypeVolume volume;
 /**
   * The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover.
   * @return time
  **/
  @JsonProperty("time")
  public String getTime() {
    if (time == null) {
      return null;
    }
    return time.value();
  }

  public void setTime(TimeEnum time) {
    this.time = time;
  }

  public MailStatsType time(TimeEnum time) {
    this.time = time;
    return this;
  }

 /**
   * Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value.
   * @return usage
  **/
  @JsonProperty("usage")
  public Integer getUsage() {
    return usage;
  }

  public void setUsage(Integer usage) {
    this.usage = usage;
  }

  public MailStatsType usage(Integer usage) {
    this.usage = usage;
    return this;
  }

 /**
   * The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;).
   * @return currency
  **/
  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public MailStatsType currency(String currency) {
    this.currency = currency;
    return this;
  }

 /**
   * Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
   * @return cost
  **/
  @JsonProperty("cost")
  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public MailStatsType cost(Double cost) {
    this.cost = cost;
    return this;
  }

 /**
   * Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue.
   * @return received
  **/
  @JsonProperty("received")
  public Integer getReceived() {
    return received;
  }

  public void setReceived(Integer received) {
    this.received = received;
  }

  public MailStatsType received(Integer received) {
    this.received = received;
    return this;
  }

 /**
   * Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;.
   * @return sent
  **/
  @JsonProperty("sent")
  public Integer getSent() {
    return sent;
  }

  public void setSent(Integer sent) {
    this.sent = sent;
  }

  public MailStatsType sent(Integer sent) {
    this.sent = sent;
    return this;
  }

 /**
   * Get volume
   * @return volume
  **/
  @JsonProperty("volume")
  public MailStatsTypeVolume getVolume() {
    return volume;
  }

  public void setVolume(MailStatsTypeVolume volume) {
    this.volume = volume;
  }

  public MailStatsType volume(MailStatsTypeVolume volume) {
    this.volume = volume;
    return this;
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
    return Objects.equals(this.time, mailStatsType.time) &&
        Objects.equals(this.usage, mailStatsType.usage) &&
        Objects.equals(this.currency, mailStatsType.currency) &&
        Objects.equals(this.cost, mailStatsType.cost) &&
        Objects.equals(this.received, mailStatsType.received) &&
        Objects.equals(this.sent, mailStatsType.sent) &&
        Objects.equals(this.volume, mailStatsType.volume);
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
  private static String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

