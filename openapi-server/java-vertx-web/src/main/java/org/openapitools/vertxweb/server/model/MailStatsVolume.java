package org.openapitools.vertxweb.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

/**
 * Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MailStatsVolume   {
  
  private Map<String, Integer> to = new HashMap<>();
  private Map<String, Integer> from = new HashMap<>();
  private Map<String, Integer> ip = new HashMap<>();

  public MailStatsVolume () {

  }

  public MailStatsVolume (Map<String, Integer> to, Map<String, Integer> from, Map<String, Integer> ip) {
    this.to = to;
    this.from = from;
    this.ip = ip;
  }

    
  @JsonProperty("to")
  public Map<String, Integer> getTo() {
    return to;
  }
  public void setTo(Map<String, Integer> to) {
    this.to = to;
  }

    
  @JsonProperty("from")
  public Map<String, Integer> getFrom() {
    return from;
  }
  public void setFrom(Map<String, Integer> from) {
    this.from = from;
  }

    
  @JsonProperty("ip")
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
  private String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}
