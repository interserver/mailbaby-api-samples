@isTest
private class OASServicesApiTest {
    /**
     * displays a list of mail service orders
     *
     * This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
     */
    @isTest
    private static void getMailOrdersTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        OASClient client;
        OASServicesApi api;
        List<OASMailOrder> response;
        List<OASMailOrder> expectedResponse;
        String js = '';

        client = new OASClient();
        api = new OASServicesApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');


        js = JSON.serialize(new List<OASMailOrder>{OASMailOrder.getExample()});
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = new List<OASMailOrder>{OASMailOrder.getExample()};
        response = (List<OASMailOrder>) api.getMailOrders();
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(new List<OASMailOrder>{OASMailOrder.getExample()});
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = new List<OASMailOrder>{OASMailOrder.getExample()};
        response = (List<OASMailOrder>) api.getMailOrders();
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(new List<OASMailOrder>{OASMailOrder.getExample()});
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = new List<OASMailOrder>{OASMailOrder.getExample()};
        response = (List<OASMailOrder>) api.getMailOrders();
        System.assertEquals(expectedResponse, response);
    }
}