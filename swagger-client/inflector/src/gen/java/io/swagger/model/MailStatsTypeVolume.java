package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Top-500 breakdown of message counts grouped by source IP, destination address, and sender address within the selected &#x60;time&#x60; window.
 **/
@Schema(description = "Top-500 breakdown of message counts grouped by source IP, destination address, and sender address within the selected `time` window.")


public class MailStatsTypeVolume   {
  @JsonProperty("to")
  private Map<String, Integer> to = null;
  @JsonProperty("from")
  private Map<String, Integer> from = null;
  @JsonProperty("ip")
  private Map<String, Integer> ip = null;
  /**
   * Message counts keyed by destination (envelope `to`) email address.
   **/
  public MailStatsTypeVolume to(Map<String, Integer> to) {
    this.to = to;
    return this;
  }

  
  @Schema(description = "Message counts keyed by destination (envelope `to`) email address.")
  @JsonProperty("to")
  public Map<String, Integer> getTo() {
    return to;
  }
  public void setTo(Map<String, Integer> to) {
    this.to = to;
  }

  /**
   * Message counts keyed by sender (envelope `from`) email address.
   **/
  public MailStatsTypeVolume from(Map<String, Integer> from) {
    this.from = from;
    return this;
  }

  
  @Schema(description = "Message counts keyed by sender (envelope `from`) email address.")
  @JsonProperty("from")
  public Map<String, Integer> getFrom() {
    return from;
  }
  public void setFrom(Map<String, Integer> from) {
    this.from = from;
  }

  /**
   * Message counts keyed by originating client IP address.
   **/
  public MailStatsTypeVolume ip(Map<String, Integer> ip) {
    this.ip = ip;
    return this;
  }

  
  @Schema(description = "Message counts keyed by originating client IP address.")
  @JsonProperty("ip")
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
    MailStatsTypeVolume mailStatsTypeVolume = (MailStatsTypeVolume) o;
    return Objects.equals(to, mailStatsTypeVolume.to) &&
        Objects.equals(from, mailStatsTypeVolume.from) &&
        Objects.equals(ip, mailStatsTypeVolume.ip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(to, from, ip);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailStatsTypeVolume {\n");
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
