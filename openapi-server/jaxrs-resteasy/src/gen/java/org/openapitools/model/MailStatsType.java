package org.openapitools.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.model.MailStatsVolume;
import javax.validation.constraints.*;
import javax.validation.Valid;
import io.swagger.annotations.*;

@ApiModel(description="Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.")@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", comments = "Generator version: 7.26.0")
public class MailStatsType   {
  

  /**
   * The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover.
   */
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
      return String.valueOf(value);
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
   * The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover.
   **/
  
  @ApiModelProperty(value = "The time window these `received`, `sent`, and `volume` statistics cover.")
  @JsonProperty("time")
  public TimeEnum getTime() {
    return time;
  }
  public void setTime(TimeEnum time) {
    this.time = time;
  }

  /**
   * Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value.
   **/
  
  @ApiModelProperty(value = "Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.")
  @JsonProperty("usage")
  public Integer getUsage() {
    return usage;
  }
  public void setUsage(Integer usage) {
    this.usage = usage;
  }

  /**
   * The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;).
   **/
  
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
   **/
  
  @ApiModelProperty(value = "Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).")
  @JsonProperty("cost")
  public Double getCost() {
    return cost;
  }
  public void setCost(Double cost) {
    this.cost = cost;
  }

  /**
   * Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue.
   **/
  
  @ApiModelProperty(value = "Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.")
  @JsonProperty("received")
  public Integer getReceived() {
    return received;
  }
  public void setReceived(Integer received) {
    this.received = received;
  }

  /**
   * Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;.
   **/
  
  @ApiModelProperty(value = "Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.")
  @JsonProperty("sent")
  public Integer getSent() {
    return sent;
  }
  public void setSent(Integer sent) {
    this.sent = sent;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("volume")
  @Valid
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
  private String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

