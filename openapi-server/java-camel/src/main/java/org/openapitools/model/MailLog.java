package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.MailLogEntry;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Paginated mail log response returned by &#x60;GET /mail/log&#x60;.  Contains the full matched count (&#x60;total&#x60;) plus a page of &#x60;MailLogEntry&#x60; records.  Use &#x60;skip&#x60; and &#x60;limit&#x60; to page through large result sets.
 */

@Schema(name = "MailLog", description = "Paginated mail log response returned by `GET /mail/log`.  Contains the full matched count (`total`) plus a page of `MailLogEntry` records.  Use `skip` and `limit` to page through large result sets.")
@Generated(value = "org.openapitools.codegen.languages.JavaCamelServerCodegen", comments = "Generator version: 7.26.0")
public class MailLog {

  private Integer total;

  private Integer skip;

  private Integer limit;

  private List<@Valid MailLogEntry> emails = new ArrayList<>();

  public MailLog() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MailLog(Integer total, Integer skip, Integer limit, List<@Valid MailLogEntry> emails) {
    this.total = total;
    this.skip = skip;
    this.limit = limit;
    this.emails = emails;
  }

  public MailLog total(Integer total) {
    this.total = total;
    return this;
  }

  /**
   * Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.
   * @return total
   */
  @NotNull 
  @Schema(name = "total", example = "10234", description = "Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("total")
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
  @NotNull 
  @Schema(name = "skip", example = "0", description = "The `skip` value used for this page (echoed from the request).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("skip")
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
  @NotNull 
  @Schema(name = "limit", example = "100", description = "The `limit` value used for this page (echoed from the request).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("limit")
  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public MailLog emails(List<@Valid MailLogEntry> emails) {
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
  @NotNull 
  @Schema(name = "emails", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("emails")
  public List<@Valid MailLogEntry> getEmails() {
    return emails;
  }

  public void setEmails(List<@Valid MailLogEntry> emails) {
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

