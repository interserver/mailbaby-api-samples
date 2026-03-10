@isTest
private class OASStatusApiTest {
    /**
     * Checks if the server is running
     *
     * A lightweight health-check endpoint.  Returns a plain-text &#x60;200 OK&#x60; when the API server is reachable.  No authentication is required.  Useful for monitoring and uptime checks.\n
     */
    @isTest
    private static void pingServerTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        OASClient client;
        OASStatusApi api;
        String js = '';

        client = new OASClient();
        api = new OASStatusApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');

        api.pingServer();
    }
}