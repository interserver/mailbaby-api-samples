package apimodels;

import apimodels.MailLogEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.*;
import java.util.Set;
import javax.validation.*;
import java.util.Objects;
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * Paginated mail log response returned by &#x60;GET /mail/log&#x60;.  Contains the full matched count (&#x60;total&#x60;) plus a page of &#x60;MailLogEntry&#x60; records.  Use &#x60;skip&#x60; and &#x60;limit&#x60; to page through large result sets.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaPlayFrameworkCodegen", comments = "Generator version: 7.26.0")
@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
public class MailLog   {
  @JsonProperty("total")
  @NotNull

  private Integer total;

  @JsonProperty("skip")
  @NotNull

  private Integer skip;

  @JsonProperty("limit")
  @NotNull

  private Integer limit;

  @JsonProperty("emails")
  @NotNull
@Valid

  private List<@Valid MailLogEntry> emails = new ArrayList<>();

  public MailLog total(Integer total) {
    this.total = total;
    return this;
  }

   /**
   * Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.
   * @return total
  **/
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
  **/
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
  **/
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
  **/
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
    return Objects.equals(total, mailLog.total) &&
        Objects.equals(skip, mailLog.skip) &&
        Objects.equals(limit, mailLog.limit) &&
        Objects.equals(emails, mailLog.emails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, skip, limit, emails);
  }

  @SuppressWarnings("StringBufferReplaceableByString")
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

