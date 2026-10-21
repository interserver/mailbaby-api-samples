package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.model.MailStatsVolume;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Account usage statistics returned by &#x60;GET /mail/stats&#x60;.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
 */

@Schema(name = "MailStatsType", description = "Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.26.0")
public class MailStatsType {

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

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
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
      return UNKNOWN_DEFAULT_OPEN_API;
    }
  }

  private TimeEnum time = TimeEnum.OneHour;

  private @Nullable Integer usage;

  private @Nullable String currency;

  private @Nullable Double cost;

  private @Nullable Integer received;

  private @Nullable Integer sent;

  private @Nullable MailStatsVolume volume;

  public MailStatsType time(TimeEnum time) {
    this.time = time;
    return this;
  }

  /**
   * The time window these `received`, `sent`, and `volume` statistics cover.
   * @return time
   */
  
  @Schema(name = "time", description = "The time window these `received`, `sent`, and `volume` statistics cover.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("time")
  public TimeEnum getTime() {
    return time;
  }

  @JsonProperty("time")
  public void setTime(TimeEnum time) {
    this.time = time;
  }

  public MailStatsType usage(@Nullable Integer usage) {
    this.usage = usage;
    return this;
  }

  /**
   * Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
   * @return usage
   */
  
  @Schema(name = "usage", description = "Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("usage")
  public @Nullable Integer getUsage() {
    return usage;
  }

  @JsonProperty("usage")
  public void setUsage(@Nullable Integer usage) {
    this.usage = usage;
  }

  public MailStatsType currency(@Nullable String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * The ISO 4217 currency code for this account (e.g. `USD`).
   * @return currency
   */
  
  @Schema(name = "currency", description = "The ISO 4217 currency code for this account (e.g. `USD`).", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currency")
  public @Nullable String getCurrency() {
    return currency;
  }

  @JsonProperty("currency")
  public void setCurrency(@Nullable String currency) {
    this.currency = currency;
  }

  public MailStatsType cost(@Nullable Double cost) {
    this.cost = cost;
    return this;
  }

  /**
   * Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
   * @return cost
   */
  
  @Schema(name = "cost", description = "Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cost")
  public @Nullable Double getCost() {
    return cost;
  }

  @JsonProperty("cost")
  public void setCost(@Nullable Double cost) {
    this.cost = cost;
  }

  public MailStatsType received(@Nullable Integer received) {
    this.received = received;
    return this;
  }

  /**
   * Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
   * @return received
   */
  
  @Schema(name = "received", description = "Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("received")
  public @Nullable Integer getReceived() {
    return received;
  }

  @JsonProperty("received")
  public void setReceived(@Nullable Integer received) {
    this.received = received;
  }

  public MailStatsType sent(@Nullable Integer sent) {
    this.sent = sent;
    return this;
  }

  /**
   * Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
   * @return sent
   */
  
  @Schema(name = "sent", description = "Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sent")
  public @Nullable Integer getSent() {
    return sent;
  }

  @JsonProperty("sent")
  public void setSent(@Nullable Integer sent) {
    this.sent = sent;
  }

  public MailStatsType volume(@Nullable MailStatsVolume volume) {
    this.volume = volume;
    return this;
  }

  /**
   * Get volume
   * @return volume
   */
  @Valid 
  @Schema(name = "volume", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("volume")
  public @Nullable MailStatsVolume getVolume() {
    return volume;
  }

  @JsonProperty("volume")
  public void setVolume(@Nullable MailStatsVolume volume) {
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
  private String toIndentedString(@Nullable Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

