package io.interserver.jaxrs.spec.model;

import io.interserver.jaxrs.spec.model.MailLogEntry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * Paginated mail log response returned by &#x60;GET /mail/log&#x60;.  Contains the full matched count (&#x60;total&#x60;) plus a page of &#x60;MailLogEntry&#x60; records.  Use &#x60;skip&#x60; and &#x60;limit&#x60; to page through large result sets.
 **/
@ApiModel(description = "Paginated mail log response returned by `GET /mail/log`.  Contains the full matched count (`total`) plus a page of `MailLogEntry` records.  Use `skip` and `limit` to page through large result sets.")
@JsonTypeName("MailLog")
@JsonFormat(shape=JsonFormat.Shape.OBJECT)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", comments = "Generator version: 7.26.0")
public class MailLog   {
  private Integer total;
  private Integer skip;
  private Integer limit;
  private List<@Valid MailLogEntry> emails = new ArrayList<>();

  public MailLog() {
  }

  @JsonCreator
  public MailLog(
    @JsonProperty(required = true, value = "total") Integer total,
    @JsonProperty(required = true, value = "skip") Integer skip,
    @JsonProperty(required = true, value = "limit") Integer limit,
    @JsonProperty(required = true, value = "emails") List<@Valid MailLogEntry> emails
  ) {
    this.total = total;
    this.skip = skip;
    this.limit = limit;
    this.emails = emails;
  }

  /**
   * Total number of log entries that match the supplied filters, regardless of &#x60;skip&#x60; and &#x60;limit&#x60;.  Use this to calculate the number of pages: &#x60;ceil(total / limit)&#x60;.
   **/
  public MailLog total(Integer total) {
    this.total = total;
    return this;
  }

  
  @ApiModelProperty(example = "10234", required = true, value = "Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.")
  @JsonProperty(required = true, value = "total")
  @NotNull public Integer getTotal() {
    return total;
  }

  @JsonProperty(required = true, value = "total")
  public void setTotal(Integer total) {
    this.total = total;
  }

  /**
   * The &#x60;skip&#x60; value used for this page (echoed from the request).
   **/
  public MailLog skip(Integer skip) {
    this.skip = skip;
    return this;
  }

  
  @ApiModelProperty(example = "0", required = true, value = "The `skip` value used for this page (echoed from the request).")
  @JsonProperty(required = true, value = "skip")
  @NotNull public Integer getSkip() {
    return skip;
  }

  @JsonProperty(required = true, value = "skip")
  public void setSkip(Integer skip) {
    this.skip = skip;
  }

  /**
   * The &#x60;limit&#x60; value used for this page (echoed from the request).
   **/
  public MailLog limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  
  @ApiModelProperty(example = "100", required = true, value = "The `limit` value used for this page (echoed from the request).")
  @JsonProperty(required = true, value = "limit")
  @NotNull public Integer getLimit() {
    return limit;
  }

  @JsonProperty(required = true, value = "limit")
  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  /**
   **/
  public MailLog emails(List<@Valid MailLogEntry> emails) {
    this.emails = emails;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(required = true, value = "emails")
  @NotNull public List<@Valid MailLogEntry> getEmails() {
    return emails;
  }

  @JsonProperty(required = true, value = "emails")
  public void setEmails(List<@Valid MailLogEntry> emails) {
    this.emails = emails;
  }

  public MailLog addEmailsItem(MailLogEntry emailsItem) {
    if (this.emails == null) {
      this.emails = new ArrayList<>();
    }

    this.emails.add(emailsItem);
    return this;
  }

  public MailLog removeEmailsItem(MailLogEntry emailsItem) {
    if (emailsItem != null && this.emails != null) {
      this.emails.remove(emailsItem);
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
  public MailLog putAdditionalProperty(String key, Object value) {
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
    MailLog mailLog = (MailLog) o;
    return Objects.equals(this.total, mailLog.total) &&
        Objects.equals(this.skip, mailLog.skip) &&
        Objects.equals(this.limit, mailLog.limit) &&
        Objects.equals(this.emails, mailLog.emails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, skip, limit, emails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailLog {\n");
    
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    skip: ").append(toIndentedString(skip)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    emails: ").append(toIndentedString(emails)).append("\n");
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
