package org.openapitools.api;

import org.openapitools.model.ErrorMessage;
import org.openapitools.model.MailLog;
import org.openapitools.model.MailStatsType;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import jakarta.inject.Inject;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashSet;

/**
 * API tests for HistoryApi
 */
@MicronautTest
public class HistoryApiTest {

    @Inject
    HistoryApi api;

    
    /**
     * Account usage statistics
     *
     * Returns aggregate sending statistics for your mail account(s) across a selectable time window.  Useful for dashboards, billing reviews, and detecting unusual traffic patterns.  The response includes: - **&#x60;usage&#x60;** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **&#x60;cost&#x60;** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **&#x60;received&#x60;** / **&#x60;sent&#x60;** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected &#x60;time&#x60; window. - **&#x60;volume&#x60;** — top-500 breakdown of message counts grouped by source IP (&#x60;ip&#x60;),   destination address (&#x60;to&#x60;), and sender address (&#x60;from&#x60;) within the selected window.   **Time windows** (controlled by the &#x60;time&#x60; parameter): | Value | Window | |-------|--------| | &#x60;1h&#x60; | Last 1 hour (default) | | &#x60;24h&#x60; | Last 24 hours | | &#x60;7d&#x60; | Last 7 days | | &#x60;month&#x60; | Current calendar month (1st to now) | | &#x60;day&#x60; | Today (midnight to now) | | &#x60;billing&#x60; | Current billing cycle (last invoice date to next invoice date) | | &#x60;all&#x60; | All time | 
     */
    @Test
    @Disabled("Not Implemented")
    public void getStatsTest() {
        // given
        String time = "1h";

        // when
        MailStatsType body = api.getStats(time).block();

        // then
        // TODO implement the getStatsTest()
    }

    
    /**
     * Displays the mail log
     *
     * Returns a paginated list of every email message accepted by the relay for your mail account(s).  All filter parameters are optional and combinable.  **Pagination** is controlled by &#x60;skip&#x60; and &#x60;limit&#x60;.  The response includes a &#x60;total&#x60; count so clients can determine how many pages exist.  **Date filtering** uses Unix timestamps (&#x60;startDate&#x60; / &#x60;endDate&#x60;).  For example, to retrieve emails sent in January 2024: &#x60;startDate&#x3D;1704067200&amp;endDate&#x3D;1706745599&#x60;.  **Delivery status** can be filtered with the &#x60;delivered&#x60; parameter: &#x60;delivered&#x3D;1&#x60; returns only successfully delivered messages; &#x60;delivered&#x3D;0&#x60; returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (&#x60;from&#x60;, &#x60;to&#x60;) and message headers (&#x60;headerfrom&#x60; for the &#x60;From:&#x60; header, &#x60;replyto&#x60; for &#x60;Reply-To:&#x60;). These may differ when a message is sent on behalf of another address.  The &#x60;mailid&#x60; parameter corresponds to the &#x60;id&#x60; field in the returned &#x60;MailLogEntry&#x60; objects, **not** the &#x60;_id&#x60; field.  It also matches the transaction ID returned in the &#x60;text&#x60; field of a successful send response from &#x60;/mail/send&#x60;, &#x60;/mail/advsend&#x60;, or &#x60;/mail/rawsend&#x60;.  The &#x60;messageId&#x60; parameter searches the &#x60;Message-ID&#x60; email header (case-insensitive substring match). 
     */
    @Test
    @Disabled("Not Implemented")
    public void viewMailLogTest() {
        // given
        Long id = 2604L;
        String origin = "1.2.3.4";
        String mx = "mx.google.com";
        String from = "me@sender.com";
        String to = "you@receiver.com";
        String subject = "Your order has shipped";
        String mailid = "185997065c60008840";
        String messageId = "<abc123@yourdomain.com>";
        String replyto = "replies@sender.com";
        String headerfrom = "newsletter@sender.com";
        Integer delivered = 1;
        Integer skip = 0;
        Integer limit = 100;
        Long startDate = 1641781008L;
        Long endDate = 1673317008L;

        // when
        MailLog body = api.viewMailLog(id, origin, mx, from, to, subject, mailid, messageId, replyto, headerfrom, delivered, skip, limit, startDate, endDate).block();

        // then
        // TODO implement the viewMailLogTest()
    }

    
}
