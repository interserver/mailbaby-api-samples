@isTest
private class OASBlockingApiTest {
    /**
     * Creates a new email deny rule.
     *
     * Adds a new email deny rule into the system to block new emails that match the given criteria
     */
    @isTest
    private static void addRuleTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        Map<String, Object> params = new Map<String, Object>{
            'type' => 'null',
            'data' => 'null',
            'user' => 'null'
        };

        OASClient client;
        OASBlockingApi api;
        OASGenericResponse response;
        OASGenericResponse expectedResponse;
        String js = '';

        client = new OASClient();
        api = new OASBlockingApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.addRule(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.addRule(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.addRule(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.addRule(params);
        System.assertEquals(expectedResponse, response);
    }

    /**
     * Removes an deny mail rule.
     *
     * Removes one of the configured deny mail rules from the system.
     */
    @isTest
    private static void deleteRuleTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        Map<String, Object> params = new Map<String, Object>{
            'ruleId' => 34
        };

        OASClient client;
        OASBlockingApi api;
        OASGenericResponse response;
        OASGenericResponse expectedResponse;
        String js = '';

        client = new OASClient();
        api = new OASBlockingApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.deleteRule(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.deleteRule(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.deleteRule(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.deleteRule(params);
        System.assertEquals(expectedResponse, response);
    }

    /**
     * Removes an email address from the blocked list
     *
     * Removes an email address from the various block lists.\n
     */
    @isTest
    private static void delistBlockTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        Map<String, Object> params = new Map<String, Object>{
            'body' => {"email":"client@domain.com"}
        };

        OASClient client;
        OASBlockingApi api;
        OASGenericResponse response;
        OASGenericResponse expectedResponse;
        String js = '';

        client = new OASClient();
        api = new OASBlockingApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.delistBlock(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.delistBlock(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.delistBlock(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.delistBlock(params);
        System.assertEquals(expectedResponse, response);
    }

    /**
     * displays a list of blocked email addresses
     *
     * 
     */
    @isTest
    private static void getMailBlocksTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        OASClient client;
        OASBlockingApi api;
        OASMailBlocks response;
        OASMailBlocks expectedResponse;
        String js = '';

        client = new OASClient();
        api = new OASBlockingApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');


        js = JSON.serialize(OASMailBlocks.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASMailBlocks.getExample();
        response = (OASMailBlocks) api.getMailBlocks();
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASMailBlocks.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASMailBlocks.getExample();
        response = (OASMailBlocks) api.getMailBlocks();
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASMailBlocks.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASMailBlocks.getExample();
        response = (OASMailBlocks) api.getMailBlocks();
        System.assertEquals(expectedResponse, response);
    }

    /**
     * Displays a listing of deny email rules.
     *
     * Returns a listing of all the deny block rules you have configured.
     */
    @isTest
    private static void getRulesTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        OASClient client;
        OASBlockingApi api;
        List<OASDenyRuleRecord> response;
        List<OASDenyRuleRecord> expectedResponse;
        String js = '';

        client = new OASClient();
        api = new OASBlockingApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');


        js = JSON.serialize(new List<OASDenyRuleRecord>{OASDenyRuleRecord.getExample()});
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = new List<OASDenyRuleRecord>{OASDenyRuleRecord.getExample()};
        response = (List<OASDenyRuleRecord>) api.getRules();
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(new List<OASDenyRuleRecord>{OASDenyRuleRecord.getExample()});
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = new List<OASDenyRuleRecord>{OASDenyRuleRecord.getExample()};
        response = (List<OASDenyRuleRecord>) api.getRules();
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(new List<OASDenyRuleRecord>{OASDenyRuleRecord.getExample()});
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = new List<OASDenyRuleRecord>{OASDenyRuleRecord.getExample()};
        response = (List<OASDenyRuleRecord>) api.getRules();
        System.assertEquals(expectedResponse, response);
    }
}