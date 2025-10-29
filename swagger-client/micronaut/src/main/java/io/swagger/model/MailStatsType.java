package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.MailStatsTypeVolume;
import io.swagger.v3.oas.annotations.media.Schema;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.validation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Statistics about the mail usage including volume by IP, To address, and From address; as well as total sent / delivered counts and cost.
 */
@Schema(description = "Statistics about the mail usage including volume by IP, To address, and From address; as well as total sent / delivered counts and cost.")
@Validated
@Introspected
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.MicronautCodegen", date = "2025-10-29T13:38:04.648620498-04:00[America/New_York]")
public class MailStatsType   {
  /**
   * Gets or Sets time
   */
  public enum TimeEnum {
    ALL("all"),
    BILLING("billing"),
    MONTH("month"),
    _7D("7d"),
    _24H("24h"),
    TODAY("today"),
    _1H("1h");

    private String value;

    TimeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
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
  @JsonProperty("time")
  private TimeEnum time = TimeEnum._1H;

  @JsonProperty("usage")
  private Integer usage = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("currencySymbol")
  private String currencySymbol = null;

  @JsonProperty("cost")
  private Double cost = null;

  @JsonProperty("received")
  private Integer received = null;

  @JsonProperty("sent")
  private Integer sent = null;

  @JsonProperty("volume")
  private MailStatsTypeVolume volume = null;

  public MailStatsType time(TimeEnum time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
  **/
  @Schema(description = "")
  @NotNull

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
   * Get usage
   * @return usage
  **/
  @Schema(description = "")
  @NotNull

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
   * Get currency
   * @return currency
  **/
  @Schema(description = "")
  @NotNull

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public MailStatsType currencySymbol(String currencySymbol) {
    this.currencySymbol = currencySymbol;
    return this;
  }

  /**
   * Get currencySymbol
   * @return currencySymbol
  **/
  @Schema(description = "")
  @NotNull

  public String getCurrencySymbol() {
    return currencySymbol;
  }

  public void setCurrencySymbol(String currencySymbol) {
    this.currencySymbol = currencySymbol;
  }

  public MailStatsType cost(Double cost) {
    this.cost = cost;
    return this;
  }

  /**
   * Get cost
   * @return cost
  **/
  @Schema(description = "")
  @NotNull

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
   * Get received
   * @return received
  **/
  @Schema(description = "")
  @NotNull

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
   * Get sent
   * @return sent
  **/
  @Schema(description = "")
  @NotNull

  public Integer getSent() {
    return sent;
  }

  public void setSent(Integer sent) {
    this.sent = sent;
  }

  public MailStatsType volume(MailStatsTypeVolume volume) {
    this.volume = volume;
    return this;
  }

  /**
   * Get volume
   * @return volume
  **/
  @Schema(description = "")
  @NotNull

  @Valid
  public MailStatsTypeVolume getVolume() {
    return volume;
  }

  public void setVolume(MailStatsTypeVolume volume) {
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
    return Objects.equals(this.time, mailStatsType.time) &&
        Objects.equals(this.usage, mailStatsType.usage) &&
        Objects.equals(this.currency, mailStatsType.currency) &&
        Objects.equals(this.currencySymbol, mailStatsType.currencySymbol) &&
        Objects.equals(this.cost, mailStatsType.cost) &&
        Objects.equals(this.received, mailStatsType.received) &&
        Objects.equals(this.sent, mailStatsType.sent) &&
        Objects.equals(this.volume, mailStatsType.volume);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, usage, currency, currencySymbol, cost, received, sent, volume);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailStatsType {\n");
    
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    usage: ").append(toIndentedString(usage)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    currencySymbol: ").append(toIndentedString(currencySymbol)).append("\n");
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
