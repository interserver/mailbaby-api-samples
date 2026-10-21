package org.openapitools.vertxweb.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.vertxweb.server.model.MailStatsVolume;

/**
 * Account usage statistics returned by &#x60;GET /mail/stats&#x60;.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
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

  public MailStatsType () {

  }

  public MailStatsType (TimeEnum time, Integer usage, String currency, Double cost, Integer received, Integer sent, MailStatsVolume volume) {
    this.time = time;
    this.usage = usage;
    this.currency = currency;
    this.cost = cost;
    this.received = received;
    this.sent = sent;
    this.volume = volume;
  }

    
  @JsonProperty("time")
  public TimeEnum getTime() {
    return time;
  }
  public void setTime(TimeEnum time) {
    this.time = time;
  }

    
  @JsonProperty("usage")
  public Integer getUsage() {
    return usage;
  }
  public void setUsage(Integer usage) {
    this.usage = usage;
  }

    
  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }
  public void setCurrency(String currency) {
    this.currency = currency;
  }

    
  @JsonProperty("cost")
  public Double getCost() {
    return cost;
  }
  public void setCost(Double cost) {
    this.cost = cost;
  }

    
  @JsonProperty("received")
  public Integer getReceived() {
    return received;
  }
  public void setReceived(Integer received) {
    this.received = received;
  }

    
  @JsonProperty("sent")
  public Integer getSent() {
    return sent;
  }
  public void setSent(Integer sent) {
    this.sent = sent;
  }

    
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
