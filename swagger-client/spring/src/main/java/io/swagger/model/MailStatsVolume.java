package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
 */
@Schema(description = "Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.")
@Validated
@NotUndefined



public class MailStatsVolume   {
  @JsonProperty("to")
  @Valid
  private Map<String, Integer> to = null;
  @JsonProperty("from")
  @Valid
  private Map<String, Integer> from = null;
  @JsonProperty("ip")
  @Valid
  private Map<String, Integer> ip = null;

  public MailStatsVolume to(Map<String, Integer> to) { 

    this.to = to;
    return this;
  }

  public MailStatsVolume putToItem(String key, Integer toItem) {
    if (this.to == null) {
      this.to = new HashMap<String, Integer>();
    }
    this.to.put(key, toItem);
    return this;
  }

  /**
   * Message counts keyed by destination (envelope `to`) email address.
   * @return to
   **/
  
  @Schema(description = "Message counts keyed by destination (envelope `to`) email address.")
  
  public Map<String, Integer> getTo() {  
    return to;
  }



  public void setTo(Map<String, Integer> to) { 
    this.to = to;
  }

  public MailStatsVolume from(Map<String, Integer> from) { 

    this.from = from;
    return this;
  }

  public MailStatsVolume putFromItem(String key, Integer fromItem) {
    if (this.from == null) {
      this.from = new HashMap<String, Integer>();
    }
    this.from.put(key, fromItem);
    return this;
  }

  /**
   * Message counts keyed by sender (envelope `from`) email address.
   * @return from
   **/
  
  @Schema(description = "Message counts keyed by sender (envelope `from`) email address.")
  
  public Map<String, Integer> getFrom() {  
    return from;
  }



  public void setFrom(Map<String, Integer> from) { 
    this.from = from;
  }

  public MailStatsVolume ip(Map<String, Integer> ip) { 

    this.ip = ip;
    return this;
  }

  public MailStatsVolume putIpItem(String key, Integer ipItem) {
    if (this.ip == null) {
      this.ip = new HashMap<String, Integer>();
    }
    this.ip.put(key, ipItem);
    return this;
  }

  /**
   * Message counts keyed by originating client IP address.
   * @return ip
   **/
  
  @Schema(description = "Message counts keyed by originating client IP address.")
  
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
