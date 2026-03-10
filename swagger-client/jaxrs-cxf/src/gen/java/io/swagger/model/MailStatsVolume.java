package io.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
  * Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
 **/
@Schema(description="Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.")
public class MailStatsVolume   {
  
  @Schema(description = "Message counts keyed by destination (envelope `to`) email address.")
 /**
   * Message counts keyed by destination (envelope `to`) email address.  
  **/
  private Map<String, Integer> to = null;
  
  @Schema(description = "Message counts keyed by sender (envelope `from`) email address.")
 /**
   * Message counts keyed by sender (envelope `from`) email address.  
  **/
  private Map<String, Integer> from = null;
  
  @Schema(description = "Message counts keyed by originating client IP address.")
 /**
   * Message counts keyed by originating client IP address.  
  **/
  private Map<String, Integer> ip = null;
 /**
   * Message counts keyed by destination (envelope &#x60;to&#x60;) email address.
   * @return to
  **/
  @JsonProperty("to")
  @NotNull
  public Map<String, Integer> getTo() {
    return to;
  }

  public void setTo(Map<String, Integer> to) {
    this.to = to;
  }

  public MailStatsVolume to(Map<String, Integer> to) {
    this.to = to;
    return this;
  }

  public MailStatsVolume putToItem(String key, Integer toItem) {
    this.to.put(key, toItem);
    return this;
  }

 /**
   * Message counts keyed by sender (envelope &#x60;from&#x60;) email address.
   * @return from
  **/
  @JsonProperty("from")
  @NotNull
  public Map<String, Integer> getFrom() {
    return from;
  }

  public void setFrom(Map<String, Integer> from) {
    this.from = from;
  }

  public MailStatsVolume from(Map<String, Integer> from) {
    this.from = from;
    return this;
  }

  public MailStatsVolume putFromItem(String key, Integer fromItem) {
    this.from.put(key, fromItem);
    return this;
  }

 /**
   * Message counts keyed by originating client IP address.
   * @return ip
  **/
  @JsonProperty("ip")
  @NotNull
  public Map<String, Integer> getIp() {
    return ip;
  }

  public void setIp(Map<String, Integer> ip) {
    this.ip = ip;
  }

  public MailStatsVolume ip(Map<String, Integer> ip) {
    this.ip = ip;
    return this;
  }

  public MailStatsVolume putIpItem(String key, Integer ipItem) {
    this.ip.put(key, ipItem);
    return this;
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
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
