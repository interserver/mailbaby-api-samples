package org.openapitools.model;

import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Top-500 breakdown of message counts grouped by source IP, destination address, and sender address within the selected `time` window.
 */
@ApiModel(description="Top-500 breakdown of message counts grouped by source IP, destination address, and sender address within the selected `time` window.")

public class MailStatsTypeVolume  {
  
 /**
  * Message counts keyed by destination (envelope `to`) email address.
  */
  @ApiModelProperty(value = "Message counts keyed by destination (envelope `to`) email address.")

  private Map<String, Integer> to = new HashMap<>();

 /**
  * Message counts keyed by sender (envelope `from`) email address.
  */
  @ApiModelProperty(value = "Message counts keyed by sender (envelope `from`) email address.")

  private Map<String, Integer> from = new HashMap<>();

 /**
  * Message counts keyed by originating client IP address.
  */
  @ApiModelProperty(value = "Message counts keyed by originating client IP address.")

  private Map<String, Integer> ip = new HashMap<>();
 /**
   * Message counts keyed by destination (envelope &#x60;to&#x60;) email address.
   * @return to
  **/
  @JsonProperty("to")
  public Map<String, Integer> getTo() {
    return to;
  }

  public void setTo(Map<String, Integer> to) {
    this.to = to;
  }

  public MailStatsTypeVolume to(Map<String, Integer> to) {
    this.to = to;
    return this;
  }

  public MailStatsTypeVolume putToItem(String key, Integer toItem) {
    this.to.put(key, toItem);
    return this;
  }

 /**
   * Message counts keyed by sender (envelope &#x60;from&#x60;) email address.
   * @return from
  **/
  @JsonProperty("from")
  public Map<String, Integer> getFrom() {
    return from;
  }

  public void setFrom(Map<String, Integer> from) {
    this.from = from;
  }

  public MailStatsTypeVolume from(Map<String, Integer> from) {
    this.from = from;
    return this;
  }

  public MailStatsTypeVolume putFromItem(String key, Integer fromItem) {
    this.from.put(key, fromItem);
    return this;
  }

 /**
   * Message counts keyed by originating client IP address.
   * @return ip
  **/
  @JsonProperty("ip")
  public Map<String, Integer> getIp() {
    return ip;
  }

  public void setIp(Map<String, Integer> ip) {
    this.ip = ip;
  }

  public MailStatsTypeVolume ip(Map<String, Integer> ip) {
    this.ip = ip;
    return this;
  }

  public MailStatsTypeVolume putIpItem(String key, Integer ipItem) {
    this.ip.put(key, ipItem);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailStatsTypeVolume mailStatsTypeVolume = (MailStatsTypeVolume) o;
    return Objects.equals(this.to, mailStatsTypeVolume.to) &&
        Objects.equals(this.from, mailStatsTypeVolume.from) &&
        Objects.equals(this.ip, mailStatsTypeVolume.ip);
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
  private static String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

