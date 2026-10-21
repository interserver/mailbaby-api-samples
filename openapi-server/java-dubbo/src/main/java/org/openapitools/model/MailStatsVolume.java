package org.openapitools.model;

import java.util.*;
import java.util.Objects;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import java.time.*;
import java.math.*;
@Generated(value = "org.openapitools.codegen.languages.JavaDubboServerCodegen", comments = "Generator version: 7.26.0")

/**
 * Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
 */
public class MailStatsVolume implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * Message counts keyed by destination (envelope &#x60;to&#x60;) email address.
   */
  @JsonProperty("to")
  private Map<String, Integer> to = new HashMap<>();

  /**
   * Message counts keyed by sender (envelope &#x60;from&#x60;) email address.
   */
  @JsonProperty("from")
  private Map<String, Integer> from = new HashMap<>();

  /**
   * Message counts keyed by originating client IP address.
   */
  @JsonProperty("ip")
  private Map<String, Integer> ip = new HashMap<>();

  /**
   * Message counts keyed by destination (envelope &#x60;to&#x60;) email address.
   * @return to
   */
  public Map<String, Integer> getTo() {
    return to;
  }

  public void setTo(Map<String, Integer> to) {
    this.to = to;
  }

  /**
   * Message counts keyed by sender (envelope &#x60;from&#x60;) email address.
   * @return from
   */
  public Map<String, Integer> getFrom() {
    return from;
  }

  public void setFrom(Map<String, Integer> from) {
    this.from = from;
  }

  /**
   * Message counts keyed by originating client IP address.
   * @return ip
   */
  public Map<String, Integer> getIp() {
    return ip;
  }

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
  private String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}
