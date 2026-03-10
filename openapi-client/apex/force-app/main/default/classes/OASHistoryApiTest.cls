@isTest
private class OASHistoryApiTest {
    /**
     * Account usage statistics
     *
     * Returns aggregate sending statistics for your mail account(s) across a selectable time window.  Useful for dashboards, billing reviews, and detecting unusual traffic patterns.\n\nThe response includes:\n- **&#x60;usage&#x60;** — total messages accepted by the relay during the current billing\n  cycle (used for cost calculation).\n- **&#x60;cost&#x60;** — estimated cost for the billing cycle based on the base plan price\n  plus per-email charges.\n- **&#x60;received&#x60;** / **&#x60;sent&#x60;** — count of messages accepted by the relay /\n  successfully delivered to the destination MX within the selected &#x60;time&#x60; window.\n- **&#x60;volume&#x60;** — top-500 breakdown of message counts grouped by source IP (&#x60;ip&#x60;),\n  destination address (&#x60;to&#x60;), and sender address (&#x60;from&#x60;) within the selected window.\n\n\n**Time windows** (controlled by the &#x60;time&#x60; parameter):\n| Value | Window | |-------|--------| | &#x60;1h&#x60; | Last 1 hour (default) | | &#x60;24h&#x60; | Last 24 hours | | &#x60;7d&#x60; | Last 7 days | | &#x60;month&#x60; | Current calendar month (1st to now) | | &#x60;day&#x60; | Today (midnight to now) | | &#x60;billing&#x60; | Current billing cycle (last invoice date to next invoice date) | | &#x60;all&#x60; | All time |\n
     */
    @isTest
    private static void getStatsTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        Map<String, Object> params = new Map<String, Object>{
            'r_time' => all
        };

        OASClient client;
        OASHistoryApi api;
        OASMailStatsType response;
        OASMailStatsType expectedResponse;
        String js = '';

        client = new OASClient();
        api = new OASHistoryApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');


        js = JSON.serialize(OASMailStatsType.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASMailStatsType.getExample();
        response = (OASMailStatsType) api.getStats(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASMailStatsType.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASMailStatsType.getExample();
        response = (OASMailStatsType) api.getStats(params);
        System.assertEquals(expectedResponse, response);
    }

    /**
     * Displays the mail log
     *
     * Returns a paginated list of every email message accepted by the relay for your mail account(s).  All filter parameters are optional and combinable.\n\n**Pagination** is controlled by &#x60;skip&#x60; and &#x60;limit&#x60;.  The response includes a &#x60;total&#x60; count so clients can determine how many pages exist.\n\n**Date filtering** uses Unix timestamps (&#x60;startDate&#x60; / &#x60;endDate&#x60;).  For example, to retrieve emails sent in January 2024: &#x60;startDate&#x3D;1704067200&amp;endDate&#x3D;1706745599&#x60;.\n\n**Delivery status** can be filtered with the &#x60;delivered&#x60; parameter: &#x60;delivered&#x3D;1&#x60; returns only successfully delivered messages; &#x60;delivered&#x3D;0&#x60; returns messages still in queue or that failed.\n\n**Address filtering** distinguishes between the SMTP envelope address (&#x60;from&#x60;, &#x60;to&#x60;) and message headers (&#x60;headerfrom&#x60; for the &#x60;From:&#x60; header, &#x60;replyto&#x60; for &#x60;Reply-To:&#x60;). These may differ when a message is sent on behalf of another address.\n\nThe &#x60;mailid&#x60; parameter corresponds to the &#x60;id&#x60; field in the returned &#x60;MailLogEntry&#x60; objects, **not** the &#x60;_id&#x60; field.  It also matches the transaction ID returned in the &#x60;text&#x60; field of a successful send response from &#x60;/mail/send&#x60;, &#x60;/mail/advsend&#x60;, or &#x60;/mail/rawsend&#x60;.\n\nThe &#x60;messageId&#x60; parameter searches the &#x60;Message-ID&#x60; email header (case-insensitive substring match).\n
     */
    @isTest
    private static void viewMailLogTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        Map<String, Object> params = new Map<String, Object>{
            'id' => 2604,
            'origin' => 1.2.3.4,
            'mx' => mx.google.com,
            'r_from' => me@sender.com,
            'to' => you@receiver.com,
            'subject' => Your order has shipped,
            'mailid' => 185997065c60008840,
            'messageId' => <abc123@yourdomain.com>,
            'replyto' => replies@sender.com,
            'headerfrom' => newsletter@sender.com,
            'delivered' => 1,
            'skip' => 0,
            'r_limit' => 100,
            'startDate' => 1641781008,
            'endDate' => 1673317008
        };

        OASClient client;
        OASHistoryApi api;
        OASMailLog response;
        OASMailLog expectedResponse;
        String js = '';

        client = new OASClient();
        api = new OASHistoryApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');


        js = JSON.serialize(OASMailLog.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASMailLog.getExample();
        response = (OASMailLog) api.viewMailLog(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASMailLog.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASMailLog.getExample();
        response = (OASMailLog) api.viewMailLog(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASMailLog.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASMailLog.getExample();
        response = (OASMailLog) api.viewMailLog(params);
        System.assertEquals(expectedResponse, response);
    }
}