@isTest
private class OASStatusApiTest {
    /**
     * Health check — verify the API is reachable
     *
     * **No authentication required.** Returns the plain-text string &#x60;Server is up and running&#x60; with a &#x60;200&#x60; status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests.\n
     */
    @isTest
    private static void pingServerTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        OASClient client;
        OASStatusApi api;
        String response;
        String expectedResponse;
        String js = '';

        api = new OASStatusApi(new OASClient());

        js = JSON.serialize('Server is up and running');
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = 'Server is up and running';
        response = (String) api.pingServer();
        System.assertEquals(expectedResponse, response);
    }
}