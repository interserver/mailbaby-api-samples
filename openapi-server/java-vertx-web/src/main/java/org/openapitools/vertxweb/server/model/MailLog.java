package org.openapitools.vertxweb.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.vertxweb.server.model.MailLogEntry;

/**
 * Paginated mail log response returned by &#x60;GET /mail/log&#x60;.  Contains the full matched count (&#x60;total&#x60;) plus a page of &#x60;MailLogEntry&#x60; records.  Use &#x60;skip&#x60; and &#x60;limit&#x60; to page through large result sets.
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MailLog   {
  
  private Integer total;
  private Integer skip;
  private Integer limit;
  private List<MailLogEntry> emails = new ArrayList<>();

  public MailLog () {

  }

  public MailLog (Integer total, Integer skip, Integer limit, List<MailLogEntry> emails) {
    this.total = total;
    this.skip = skip;
    this.limit = limit;
    this.emails = emails;
  }

    
  @JsonProperty("total")
  public Integer getTotal() {
    return total;
  }
  public void setTotal(Integer total) {
    this.total = total;
  }

    
  @JsonProperty("skip")
  public Integer getSkip() {
    return skip;
  }
  public void setSkip(Integer skip) {
    this.skip = skip;
  }

    
  @JsonProperty("limit")
  public Integer getLimit() {
    return limit;
  }
  public void setLimit(Integer limit) {
    this.limit = limit;
  }

    
  @JsonProperty("emails")
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
    return Objects.equals(total, mailLog.total) &&
        Objects.equals(skip, mailLog.skip) &&
        Objects.equals(limit, mailLog.limit) &&
        Objects.equals(emails, mailLog.emails);
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
