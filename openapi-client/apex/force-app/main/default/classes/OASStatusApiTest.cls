@isTest
private class OASStatusApiTest {
    /**
     * Checks if the server is running
     *
     * 
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