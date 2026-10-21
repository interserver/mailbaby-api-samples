package org.openapitools.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.MailBlockClickHouse;
import org.openapitools.model.MailBlockRspamd;
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
 * The complete set of blocked addresses and message patterns returned by &#x60;GET /mail/blocks&#x60;. Three independent block sources are combined into one response. Use &#x60;POST /mail/blocks/delete&#x60; with a &#x60;from&#x60; address from any entry to delist it.
 **/
@ApiModel(description = "The complete set of blocked addresses and message patterns returned by `GET /mail/blocks`. Three independent block sources are combined into one response. Use `POST /mail/blocks/delete` with a `from` address from any entry to delist it.")
@JsonTypeName("MailBlocks")
@JsonFormat(shape=JsonFormat.Shape.OBJECT)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", comments = "Generator version: 7.26.0")
public class MailBlocks   {
  private List<@Valid MailBlockClickHouse> local = new ArrayList<>();
  private List<@Valid MailBlockClickHouse> mbtrap = new ArrayList<>();
  private List<@Valid MailBlockRspamd> subject = new ArrayList<>();

  public MailBlocks() {
  }

  @JsonCreator
  public MailBlocks(
    @JsonProperty(required = true, value = "local") List<@Valid MailBlockClickHouse> local,
    @JsonProperty(required = true, value = "mbtrap") List<@Valid MailBlockClickHouse> mbtrap,
    @JsonProperty(required = true, value = "subject") List<@Valid MailBlockRspamd> subject
  ) {
    this.local = local;
    this.mbtrap = mbtrap;
    this.subject = subject;
  }

  /**
   * Messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
   **/
  public MailBlocks local(List<@Valid MailBlockClickHouse> local) {
    this.local = local;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.")
  @JsonProperty(required = true, value = "local")
  @NotNull public List<@Valid MailBlockClickHouse> getLocal() {
    return local;
  }

  @JsonProperty(required = true, value = "local")
  public void setLocal(List<@Valid MailBlockClickHouse> local) {
    this.local = local;
  }

  public MailBlocks addLocalItem(MailBlockClickHouse localItem) {
    if (this.local == null) {
      this.local = new ArrayList<>();
    }

    this.local.add(localItem);
    return this;
  }

  public MailBlocks removeLocalItem(MailBlockClickHouse localItem) {
    if (localItem != null && this.local != null) {
      this.local.remove(localItem);
    }

    return this;
  }
  /**
   * Messages flagged by the &#x60;MBTRAP&#x60; rspamd rule in the last 5 days. These triggered MailBaby&#39;s honeypot / trap address detection.
   **/
  public MailBlocks mbtrap(List<@Valid MailBlockClickHouse> mbtrap) {
    this.mbtrap = mbtrap;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.")
  @JsonProperty(required = true, value = "mbtrap")
  @NotNull public List<@Valid MailBlockClickHouse> getMbtrap() {
    return mbtrap;
  }

  @JsonProperty(required = true, value = "mbtrap")
  public void setMbtrap(List<@Valid MailBlockClickHouse> mbtrap) {
    this.mbtrap = mbtrap;
  }

  public MailBlocks addMbtrapItem(MailBlockClickHouse mbtrapItem) {
    if (this.mbtrap == null) {
      this.mbtrap = new ArrayList<>();
    }

    this.mbtrap.add(mbtrapItem);
    return this;
  }

  public MailBlocks removeMbtrapItem(MailBlockClickHouse mbtrapItem) {
    if (mbtrapItem != null && this.mbtrap != null) {
      this.mbtrap.remove(mbtrapItem);
    }

    return this;
  }
  /**
   * Senders whose messages contained spam-indicative subjects (containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with more than 4 occurrences of the same subject in the last 3 days.
   **/
  public MailBlocks subject(List<@Valid MailBlockRspamd> subject) {
    this.subject = subject;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.")
  @JsonProperty(required = true, value = "subject")
  @NotNull public List<@Valid MailBlockRspamd> getSubject() {
    return subject;
  }

  @JsonProperty(required = true, value = "subject")
  public void setSubject(List<@Valid MailBlockRspamd> subject) {
    this.subject = subject;
  }

  public MailBlocks addSubjectItem(MailBlockRspamd subjectItem) {
    if (this.subject == null) {
      this.subject = new ArrayList<>();
    }

    this.subject.add(subjectItem);
    return this;
  }

  public MailBlocks removeSubjectItem(MailBlockRspamd subjectItem) {
    if (subjectItem != null && this.subject != null) {
      this.subject.remove(subjectItem);
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
  public MailBlocks putAdditionalProperty(String key, Object value) {
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
    MailBlocks mailBlocks = (MailBlocks) o;
    return Objects.equals(this.local, mailBlocks.local) &&
        Objects.equals(this.mbtrap, mailBlocks.mbtrap) &&
        Objects.equals(this.subject, mailBlocks.subject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(local, mbtrap, subject);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailBlocks {\n");
    
    sb.append("    local: ").append(toIndentedString(local)).append("\n");
    sb.append("    mbtrap: ").append(toIndentedString(mbtrap)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
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
