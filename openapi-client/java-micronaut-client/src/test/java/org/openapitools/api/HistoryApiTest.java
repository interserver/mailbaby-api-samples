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
     * Account usage statistics.
     *
     * Returns information about the usage on your mail accounts.
     */
    @Test
    @Disabled("Not Implemented")
    public void getStatsTest() {
        // given
        String time = "example";

        // when
        MailStatsType body = api.getStats(time).block();

        // then
        // TODO implement the getStatsTest()
    }

    
    /**
     * displays the mail log
     *
     * Get a listing of the emails sent through this system 
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
        String subject = "Support";
        String mailid = "185997065c60008840";
        Integer skip = 0;
        Integer limit = 100;
        Long startDate = 1641781008L;
        Long endDate = 1673317008L;
        String replyto = "example";
        String headerfrom = "example";
        String delivered = "example";

        // when
        MailLog body = api.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered).block();

        // then
        // TODO implement the viewMailLogTest()
    }

    
}
