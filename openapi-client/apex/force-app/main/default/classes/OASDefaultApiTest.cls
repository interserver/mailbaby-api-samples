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

        OASClient client;
        OASDefaultApi api;
        List<OASGetMailOrders200ResponseInner> response;
        List<OASGetMailOrders200ResponseInner> expectedResponse;
        String js = '';

        client = new OASClient();
        api = new OASDefaultApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');


        js = JSON.serialize(new List<OASGetMailOrders200ResponseInner>{OASGetMailOrders200ResponseInner.getExample()});
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = new List<OASGetMailOrders200ResponseInner>{OASGetMailOrders200ResponseInner.getExample()};
        response = (List<OASGetMailOrders200ResponseInner>) api.getMailOrders();
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
     * Sends an email through one of your mail orders.\n\n*Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead.\n
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
            'search' => 'null',
            'skip' => '',
            'r_limit' => '',
            'startDate' => 2147483648L,
            'endDate' => 2147483648L
        };

        OASClient client;
        OASDefaultApi api;
        OASMailLog response;
        OASMailLog expectedResponse;
        String js = '';

        client = new OASClient();
        api = new OASDefaultApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');


        js = JSON.serialize(OASMailLog.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASMailLog.getExample();
        response = (OASMailLog) api.viewMailLog(params);
        System.assertEquals(expectedResponse, response);
    }
}