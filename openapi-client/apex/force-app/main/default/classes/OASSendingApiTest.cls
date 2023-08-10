@isTest
private class OASSendingApiTest {
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
            'subject' => 'null',
            'body' => 'null',
            'r_from' => '',
            'to' => new List<OASEmailAddressName>{OASEmailAddressName.getExample()},
            'replyto' => new List<OASEmailAddressName>{OASEmailAddressName.getExample()},
            'cc' => new List<OASEmailAddressName>{OASEmailAddressName.getExample()},
            'bcc' => new List<OASEmailAddressName>{OASEmailAddressName.getExample()},
            'attachments' => new List<OASMailAttachment>{OASMailAttachment.getExample()},
            'id' => 2147483648L
        };

        OASClient client;
        OASSendingApi api;
        OASGenericResponse response;
        OASGenericResponse expectedResponse;
        String js = '';

        client = new OASClient();
        api = new OASSendingApi(client);
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
        OASSendingApi api;
        OASGenericResponse response;
        OASGenericResponse expectedResponse;
        String js = '';

        client = new OASClient();
        api = new OASSendingApi(client);
        ((OAS.ApiKeyAuth)client.getAuthentication('apiKeyAuth')).setApiKey('foo-bar-api-key');


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.sendMail(params);
        System.assertEquals(expectedResponse, response);
    }
}