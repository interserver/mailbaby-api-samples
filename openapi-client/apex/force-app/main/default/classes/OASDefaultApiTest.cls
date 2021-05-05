@isTest
private class OASDefaultApiTest {
    /**
     * displays a list of mail service orders
     *
     * 
     */
    @isTest
    private static void getMailOrdersTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        Map<String, Object> params = new Map<String, Object>{
            'id' => 2147483648L
        };

        OASClient client;
        OASDefaultApi api;
        List<OASMailOrder> response;
        List<OASMailOrder> expectedResponse;
        String js = '';

        client = new OASClient();
        api = new OASDefaultApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');


        js = JSON.serialize(List.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = List.getExample();
        response = (List<OASMailOrder>) api.getMailOrders(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(List.getExample());
        res.setHeader('Content-Type', 'application/xml');
        res.setBody(js);
        expectedResponse = List.getExample();
        response = (List<OASMailOrder>) api.getMailOrders(params);
        System.assertEquals(expectedResponse, response);
    }

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
        OASDefaultApi api;
        String js = '';

        api = new OASDefaultApi(new OASClient());

        api.pingServer();
    }

    /**
     * places a mail order
     *
     * Adds an item to the system
     */
    @isTest
    private static void placeMailOrderTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        Map<String, Object> params = new Map<String, Object>{
            'oaSMailOrder' => ''
        };

        OASClient client;
        OASDefaultApi api;
        String js = '';

        client = new OASClient();
        api = new OASDefaultApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');

        api.placeMailOrder(params);
    }

    /**
     * Sends an Email with Advanced Options
     *
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     */
    @isTest
    private static void sendAdvMailTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        Map<String, Object> params = new Map<String, Object>{
            'oaSSendMailAdv' => ''
        };

        OASClient client;
        OASDefaultApi api;
        OASGenericResponse response;
        OASGenericResponse expectedResponse;
        String js = '';

        client = new OASClient();
        api = new OASDefaultApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.sendAdvMail(params);
        System.assertEquals(expectedResponse, response);
    }

    /**
     * Sends an Email
     *
     * Sends An email through one of your mail orders.
     */
    @isTest
    private static void sendMailTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        Map<String, Object> params = new Map<String, Object>{
            'to' => 'null',
            'r_from' => 'null',
            'subject' => 'null',
            'body' => 'null'
        };

        OASClient client;
        OASDefaultApi api;
        OASGenericResponse response;
        OASGenericResponse expectedResponse;
        String js = '';

        client = new OASClient();
        api = new OASDefaultApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.sendMail(params);
        System.assertEquals(expectedResponse, response);
    }

    /**
     * validatess order details before placing an order
     *
     * 
     */
    @isTest
    private static void validateMailOrderTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        OASClient client;
        OASDefaultApi api;
        String js = '';

        client = new OASClient();
        api = new OASDefaultApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');

        api.validateMailOrder();
    }

    /**
     * displays the mail log
     *
     * By passing in the appropriate options, you can search for\navailable inventory in the system\n
     */
    @isTest
    private static void viewMailLogTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        Map<String, Object> params = new Map<String, Object>{
            'id' => 2147483648L,
            'searchString' => 'null',
            'skip' => '',
            'r_limit' => ''
        };

        OASClient client;
        OASDefaultApi api;
        List<OASMailLog> response;
        List<OASMailLog> expectedResponse;
        String js = '';

        client = new OASClient();
        api = new OASDefaultApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');


        js = JSON.serialize(new List<OASMailLog>{OASMailLog.getExample()});
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = new List<OASMailLog>{OASMailLog.getExample()};
        response = (List<OASMailLog>) api.viewMailLog(params);
        System.assertEquals(expectedResponse, response);
    }
}