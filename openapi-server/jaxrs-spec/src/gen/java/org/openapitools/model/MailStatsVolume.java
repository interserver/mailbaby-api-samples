package org.openapitools.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.*;
import javax.validation.Valid;

import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
 **/
@ApiModel(description = "Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.")
@JsonTypeName("MailStatsVolume")
@JsonFormat(shape=JsonFormat.Shape.OBJECT)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", comments = "Generator version: 7.26.0")
public class MailStatsVolume   {
  private Map<String, Integer> to = new HashMap<>();
  private Map<String, Integer> from = new HashMap<>();
  private Map<String, Integer> ip = new HashMap<>();

  public MailStatsVolume() {
  }

  /**
   * Message counts keyed by destination (envelope &#x60;to&#x60;) email address.
   **/
  public MailStatsVolume to(Map<String, Integer> to) {
    this.to = to;
    return this;
  }

  
  @ApiModelProperty(value = "Message counts keyed by destination (envelope `to`) email address.")
  @JsonProperty("to")
  public Map<String, Integer> getTo() {
    return to;
  }

  @JsonProperty("to")
  public void setTo(Map<String, Integer> to) {
    this.to = to;
  }

  public MailStatsVolume putToItem(String key, Integer toItem) {
    if (this.to == null) {
      this.to = new HashMap<>();
    }

    this.to.put(key, toItem);
    return this;
  }

  public MailStatsVolume removeToItem(String key) {
    if (this.to != null) {
      this.to.remove(key);
    }

    return this;
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
  public Map<String, Integer> getFrom() {
    return from;
  }

  @JsonProperty("from")
  public void setFrom(Map<String, Integer> from) {
    this.from = from;
  }

  public MailStatsVolume putFromItem(String key, Integer fromItem) {
    if (this.from == null) {
      this.from = new HashMap<>();
    }

    this.from.put(key, fromItem);
    return this;
  }

  public MailStatsVolume removeFromItem(String key) {
    if (this.from != null) {
      this.from.remove(key);
    }

    return this;
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
  public Map<String, Integer> getIp() {
    return ip;
  }

  @JsonProperty("ip")
  public void setIp(Map<String, Integer> ip) {
    this.ip = ip;
  }

  public MailStatsVolume putIpItem(String key, Integer ipItem) {
    if (this.ip == null) {
      this.ip = new HashMap<>();
    }

    this.ip.put(key, ipItem);
    return this;
  }

  public MailStatsVolume removeIpItem(String key) {
    if (this.ip != null) {
      this.ip.remove(key);
    }

    return this;
  }
  /**
   * Set the additional (undeclared) property with the specified name and value.
   * Creates the property if it does not already exist, otherwise replaces it.
   * @param key the name of the property
   * @param value the value of the property
   * @return self reference
   */
  @JsonAnySetter
  public MailStatsVolume putAdditionalProperty(String key, Object value) {
    this.put(key, value);
    return this;
  }

  /**
   * Return the additional (undeclared) properties.
   * @return the additional (undeclared) properties
   */
  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this;
  }

  /**
   * Return the additional (undeclared) property with the specified name.
   * @param key the name of the property
   * @return the additional (undeclared) property with the specified name
   */
  public Object getAdditionalProperty(String key) {
    return this.get(key);
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
