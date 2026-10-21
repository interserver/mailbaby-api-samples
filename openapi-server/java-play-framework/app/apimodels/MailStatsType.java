package apimodels;

import apimodels.MailStatsVolume;
import com.fasterxml.jackson.annotation.*;
import java.util.Set;
import javax.validation.*;
import java.util.Objects;
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * Account usage statistics returned by &#x60;GET /mail/stats&#x60;.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaPlayFrameworkCodegen", comments = "Generator version: 7.26.0")
@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
public class MailStatsType   {
  /**
   * The time window these `received`, `sent`, and `volume` statistics cover.
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

    private final String value;

    TimeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TimeEnum fromValue(String value) {
      for (TimeEnum b : TimeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("time")
  
  private TimeEnum time = TimeEnum.OneHour;

  @JsonProperty("usage")
  
  private Integer usage;

  @JsonProperty("currency")
  
  private String currency;

  @JsonProperty("cost")
  
  private Double cost;

  @JsonProperty("received")
  
  private Integer received;

  @JsonProperty("sent")
  
  private Integer sent;

  @JsonProperty("volume")
  @Valid

  private MailStatsVolume volume;

  public MailStatsType time(TimeEnum time) {
    this.time = time;
    return this;
  }

   /**
   * The time window these `received`, `sent`, and `volume` statistics cover.
   * @return time
  **/
  public TimeEnum getTime() {
    return time;
  }

  public void setTime(TimeEnum time) {
    this.time = time;
  }

  public MailStatsType usage(Integer usage) {
    this.usage = usage;
    return this;
  }

   /**
   * Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
   * @return usage
  **/
  public Integer getUsage() {
    return usage;
  }

  public void setUsage(Integer usage) {
    this.usage = usage;
  }

  public MailStatsType currency(String currency) {
    this.currency = currency;
    return this;
  }

   /**
   * The ISO 4217 currency code for this account (e.g. `USD`).
   * @return currency
  **/
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public MailStatsType cost(Double cost) {
    this.cost = cost;
    return this;
  }

   /**
   * Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
   * @return cost
  **/
  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public MailStatsType received(Integer received) {
    this.received = received;
    return this;
  }

   /**
   * Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
   * @return received
  **/
  public Integer getReceived() {
    return received;
  }

  public void setReceived(Integer received) {
    this.received = received;
  }

  public MailStatsType sent(Integer sent) {
    this.sent = sent;
    return this;
  }

   /**
   * Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
   * @return sent
  **/
  public Integer getSent() {
    return sent;
  }

  public void setSent(Integer sent) {
    this.sent = sent;
  }

  public MailStatsType volume(MailStatsVolume volume) {
    this.volume = volume;
    return this;
  }

   /**
   * Get volume
   * @return volume
  **/
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

  @SuppressWarnings("StringBufferReplaceableByString")
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

