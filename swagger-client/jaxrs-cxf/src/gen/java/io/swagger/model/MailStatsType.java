package io.swagger.model;

import io.swagger.model.MailStatsTypeVolume;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
  * Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
 **/
@Schema(description="Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.")
public class MailStatsType   {
  public enum TimeEnum {
    ALL("all"),
    BILLING("billing"),
    MONTH("month"),
    _7D("7d"),
    _24H("24h"),
    DAY("day"),
    _1H("1h");

    private String value;

    TimeEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static TimeEnum fromValue(String text) {
      for (TimeEnum b : TimeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }  
  @Schema(description = "The time window these `received`, `sent`, and `volume` statistics cover.")
 /**
   * The time window these `received`, `sent`, and `volume` statistics cover.  
  **/
  private TimeEnum time = TimeEnum._1H;
  
  @Schema(description = "Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.")
 /**
   * Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.  
  **/
  private Integer usage = null;
  
  @Schema(description = "The ISO 4217 currency code for this account (e.g. `USD`).")
 /**
   * The ISO 4217 currency code for this account (e.g. `USD`).  
  **/
  private String currency = null;
  
  @Schema(description = "Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).")
 /**
   * Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).  
  **/
  private Double cost = null;
  
  @Schema(description = "Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.")
 /**
   * Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.  
  **/
  private Integer received = null;
  
  @Schema(description = "Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.")
 /**
   * Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.  
  **/
  private Integer sent = null;
  
  @Schema(description = "")
  private MailStatsTypeVolume volume = null;
 /**
   * The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover.
   * @return time
  **/
  @JsonProperty("time")
  @NotNull
  public String getTime() {
    if (time == null) {
      return null;
    }
    return time.getValue();
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
  @NotNull
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
  @NotNull
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
  @NotNull
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
  @NotNull
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
  @NotNull
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
  @NotNull
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
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
