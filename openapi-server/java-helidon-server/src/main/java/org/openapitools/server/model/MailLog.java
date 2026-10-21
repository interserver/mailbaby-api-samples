package org.openapitools.server.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.server.model.MailLogEntry;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


/**
 * Paginated mail log response returned by `GET /mail/log`.  Contains the full matched count (`total`) plus a page of `MailLogEntry` records.  Use `skip` and `limit` to page through large result sets.
 */
public class MailLog   {

    private Integer total;
    private Integer skip;
    private Integer limit;
    private List<@Valid MailLogEntry> emails = new ArrayList<>();

    /**
     * Default constructor.
     */
    public MailLog() {
    // JSON-B / Jackson
    }

    /**
     * Create MailLog.
     *
     * @param total Total number of log entries that match the supplied filters, regardless of &#x60;skip&#x60; and &#x60;limit&#x60;.  Use this to calculate the number of pages: &#x60;ceil(total / limit)&#x60;.
     * @param skip The &#x60;skip&#x60; value used for this page (echoed from the request).
     * @param limit The &#x60;limit&#x60; value used for this page (echoed from the request).
     * @param emails emails
     */
    public MailLog(
        Integer total, 
        Integer skip, 
        Integer limit, 
        List<@Valid MailLogEntry> emails
    ) {
        this.total = total;
        this.skip = skip;
        this.limit = limit;
        this.emails = emails;
    }



    /**
     * Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.
     * @return total
     */
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * The `skip` value used for this page (echoed from the request).
     * @return skip
     */
    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    /**
     * The `limit` value used for this page (echoed from the request).
     * @return limit
     */
    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * Get emails
     * @return emails
     */
    public List<@Valid MailLogEntry> getEmails() {
        return emails;
    }

    public void setEmails(List<@Valid MailLogEntry> emails) {
        this.emails = emails;
    }

    /**
      * Create a string representation of this pojo.
    **/
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
    private static String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}

