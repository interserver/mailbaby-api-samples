@isTest
private class OASStatusApiTest {
    /**
     * Checks if the server is running
     *
     * A lightweight health-check endpoint.  Returns the plain-text string &#x60;Server is up and running&#x60; with a &#x60;200&#x60; status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests.\n
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

        client = new OASClient();
        api = new OASStatusApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');


        js = JSON.serialize('Server is up and running');
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = 'Server is up and running';
        response = (String) api.pingServer();
        System.assertEquals(expectedResponse, response);
    }
}