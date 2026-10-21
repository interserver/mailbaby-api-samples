package io.interserver.spring.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.HashMap;
import java.util.Map;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
 */

@Schema(name = "MailStatsVolume", description = "Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.26.0")
public class MailStatsVolume {

  private Map<String, Integer> to = new HashMap<>();

  private Map<String, Integer> from = new HashMap<>();

  private Map<String, Integer> ip = new HashMap<>();

  public MailStatsVolume to(Map<String, Integer> to) {
    this.to = to;
    return this;
  }

  public MailStatsVolume putToItem(String key, Integer toItem) {
    if (this.to == null) {
      this.to = new HashMap<>();
    }
    this.to.put(key, toItem);
    return this;
  }

  /**
   * Message counts keyed by destination (envelope `to`) email address.
   * @return to
   */
  
  @Schema(name = "to", description = "Message counts keyed by destination (envelope `to`) email address.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("to")
  public Map<String, Integer> getTo() {
    return to;
  }

  @JsonProperty("to")
  public void setTo(Map<String, Integer> to) {
    this.to = to;
  }

  public MailStatsVolume from(Map<String, Integer> from) {
    this.from = from;
    return this;
  }

  public MailStatsVolume putFromItem(String key, Integer fromItem) {
    if (this.from == null) {
      this.from = new HashMap<>();
    }
    this.from.put(key, fromItem);
    return this;
  }

  /**
   * Message counts keyed by sender (envelope `from`) email address.
   * @return from
   */
  
  @Schema(name = "from", description = "Message counts keyed by sender (envelope `from`) email address.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("from")
  public Map<String, Integer> getFrom() {
    return from;
  }

  @JsonProperty("from")
  public void setFrom(Map<String, Integer> from) {
    this.from = from;
  }

  public MailStatsVolume ip(Map<String, Integer> ip) {
    this.ip = ip;
    return this;
  }

  public MailStatsVolume putIpItem(String key, Integer ipItem) {
    if (this.ip == null) {
      this.ip = new HashMap<>();
    }
    this.ip.put(key, ipItem);
    return this;
  }

  /**
   * Message counts keyed by originating client IP address.
   * @return ip
   */
  
  @Schema(name = "ip", description = "Message counts keyed by originating client IP address.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ip")
  public Map<String, Integer> getIp() {
    return ip;
  }

  @JsonProperty("ip")
  public void setIp(Map<String, Integer> ip) {
    this.ip = ip;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailStatsVolume mailStatsVolume = (MailStatsVolume) o;
    return Objects.equals(this.to, mailStatsVolume.to) &&
        Objects.equals(this.from, mailStatsVolume.from) &&
        Objects.equals(this.ip, mailStatsVolume.ip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(to, from, ip);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailStatsVolume {\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
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

