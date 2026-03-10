package io.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
 **/
import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
@Schema(description = "Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.")

public class MailStatsVolume   {

  private @Valid Map<String, Integer> to = new HashMap<String, Integer>();

  private @Valid Map<String, Integer> from = new HashMap<String, Integer>();

  private @Valid Map<String, Integer> ip = new HashMap<String, Integer>();

  /**
   * Message counts keyed by destination (envelope &#x60;to&#x60;) email address.
   **/
  public MailStatsVolume to(Map<String, Integer> to) {
    this.to = to;
    return this;
  }

  
  @ApiModelProperty(value = "Message counts keyed by destination (envelope `to`) email address.")
  @JsonProperty("to")
  @NotNull

  public Map<String, Integer> getTo() {
    return to;
  }
  public void setTo(Map<String, Integer> to) {
    this.to = to;
  }

  /**
   * Message counts keyed by sender (envelope &#x60;from&#x60;) email address.
   **/
  public MailStatsVolume from(Map<String, Integer> from) {
    this.from = from;
    return this;
  }

  
  @ApiModelProperty(value = "Message counts keyed by sender (envelope `from`) email address.")
  @JsonProperty("from")
  @NotNull

  public Map<String, Integer> getFrom() {
    return from;
  }
  public void setFrom(Map<String, Integer> from) {
    this.from = from;
  }

  /**
   * Message counts keyed by originating client IP address.
   **/
  public MailStatsVolume ip(Map<String, Integer> ip) {
    this.ip = ip;
    return this;
  }

  
  @ApiModelProperty(value = "Message counts keyed by originating client IP address.")
  @JsonProperty("ip")
  @NotNull

  public Map<String, Integer> getIp() {
    return ip;
  }
  public void setIp(Map<String, Integer> ip) {
    this.ip = ip;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailStatsVolume mailStatsVolume = (MailStatsVolume) o;
    return Objects.equals(to, mailStatsVolume.to) &&
        Objects.equals(from, mailStatsVolume.from) &&
        Objects.equals(ip, mailStatsVolume.ip);
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
