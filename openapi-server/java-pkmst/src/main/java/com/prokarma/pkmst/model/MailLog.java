package com.prokarma.pkmst.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.prokarma.pkmst.model.MailLogEntry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Response class to be returned by Api
 * @author pkmst
 *
 */
/**
 * Paginated mail log response returned by &#x60;GET /mail/log&#x60;.  Contains the full matched count (&#x60;total&#x60;) plus a page of &#x60;MailLogEntry&#x60; records.  Use &#x60;skip&#x60; and &#x60;limit&#x60; to page through large result sets.
 */
@ApiModel(description = "Paginated mail log response returned by `GET /mail/log`.  Contains the full matched count (`total`) plus a page of `MailLogEntry` records.  Use `skip` and `limit` to page through large result sets.")

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaPKMSTServerCodegen", comments = "Generator version: 7.26.0")
public class MailLog   {
  @JsonProperty("total")
  private Integer total;

  @JsonProperty("skip")
  private Integer skip;

  @JsonProperty("limit")
  private Integer limit;

  @JsonProperty("emails")
  
  private List<MailLogEntry> emails = new ArrayList<>();

  public MailLog total(Integer total) {
    this.total = total;
    return this;
  }

  /**
   * Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.
   * @return total
   */
  @ApiModelProperty(example = "10234", required = true, value = "Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.")
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public MailLog skip(Integer skip) {
    this.skip = skip;
    return this;
  }

  /**
   * The `skip` value used for this page (echoed from the request).
   * @return skip
   */
  @ApiModelProperty(example = "0", required = true, value = "The `skip` value used for this page (echoed from the request).")
  public Integer getSkip() {
    return skip;
  }

  public void setSkip(Integer skip) {
    this.skip = skip;
  }

  public MailLog limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * The `limit` value used for this page (echoed from the request).
   * @return limit
   */
  @ApiModelProperty(example = "100", required = true, value = "The `limit` value used for this page (echoed from the request).")
  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public MailLog emails(List<MailLogEntry> emails) {
    this.emails = emails;
    return this;
  }

  public MailLog addEmailsItem(MailLogEntry emailsItem) {
    if (this.emails == null) {
      this.emails = new ArrayList<>();
    }
    this.emails.add(emailsItem);
    return this;
  }

  /**
   * Get emails
   * @return emails
   */
  @ApiModelProperty(required = true, value = "")
  public List<MailLogEntry> getEmails() {
    return emails;
  }

  public void setEmails(List<MailLogEntry> emails) {
    this.emails = emails;
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

