@isTest
private class OASHistoryApiTest {
    /**
     * Account usage statistics.
     *
     * Returns information about the usage on your mail accounts.
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


        js = JSON.serialize(OASMailStatsType.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASMailStatsType.getExample();
        response = (OASMailStatsType) api.getStats(params);
        System.assertEquals(expectedResponse, response);
    }

    /**
     * displays the mail log
     *
     * Get a listing of the emails sent through this system\n
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
            'subject' => Support,
            'mailid' => 185997065c60008840,
            'skip' => 1000,
            'r_limit' => 1000,
            'startDate' => 1641781008,
            'endDate' => 1673317008,
            'replyto' => 'null',
            'headerfrom' => 'null',
            'delivered' => 0
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
    }
}