@isTest
private class OASSendingApiTest {
    /**
     * Sends a raw email
     *
     * This call will let you pass the raw / complete email contents (including headers) as a string and have it get sent as-is.  This is useful for things like DKIM signed messages.
     */
    @isTest
    private static void rawMailTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        Map<String, Object> params = new Map<String, Object>{
            'oaSSendMailRaw' => ''
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
        response = (OASGenericResponse) api.rawMail(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.rawMail(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.rawMail(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.rawMail(params);
        System.assertEquals(expectedResponse, response);
    }

    /**
     * Sends an Email with Advanced Options
     *
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.\n\nHere are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.\n\n&#x60;&#x60;&#x60;BasicForm\ncurl -i --request POST --url https://api.mailbaby.net/mail/advsend \\n--header \&#39;Accept: application/json\&#39; \\n--header \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\n--header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n--data \&#39;subject&#x3D;Welcome\&#39; \\n--data \&#39;body&#x3D;Hello\&#39; \\n--data from&#x3D;user@domain.com \\n--data to&#x3D;support@interserver.net\n&#x60;&#x60;&#x60;\n\n&#x60;&#x60;&#x60;ArrayForm\ncurl -i --request POST --url https://api.mailbaby.net/mail/advsend \\n--header \&#39;Accept: application/json\&#39; \\n--header \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\n--header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n--data \&#39;subject&#x3D;Welcome\&#39; \\n--data \&#39;body&#x3D;Hello\&#39; \\n--data from&#x3D;user@domain.com \\n--data &quot;to[0][name]&#x3D;Joe&quot; \\n--data &quot;to[0][email]&#x3D;support@interserver.net&quot;\n&#x60;&#x60;&#x60;\n\n&#x60;&#x60;&#x60;NameEmailForm\ncurl -i --request POST --url https://api.mailbaby.net/mail/advsend \\n--header \&#39;Accept: application/json\&#39; \\n--header \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\n--header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n--data \&#39;subject&#x3D;Welcome\&#39; \\n--data \&#39;body&#x3D;Hello\&#39; \\n--data from&#x3D;&quot;Joe &lt;user@domain.com&gt;&quot; \\n--data to&#x3D;&quot;Joe &lt;support@interserver.net&gt;&quot;\n&#x60;&#x60;&#x60;\n\n&#x60;&#x60;&#x60;MultToForm\ncurl -i --request POST --url https://api.mailbaby.net/mail/advsend \\n--header \&#39;Accept: application/json\&#39; \\n--header \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\n--header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n--data \&#39;subject&#x3D;Welcome\&#39; \\n--data \&#39;body&#x3D;Hello\&#39; \\n--data from&#x3D;user@domain.com \\n--data &quot;to&#x3D;support@interserver.net, support@interserver.net&quot;\n&#x60;&#x60;&#x60;\n\n&#x60;&#x60;&#x60;MultToFullForm\ncurl -i --request POST --url https://api.mailbaby.net/mail/advsend \\n--header \&#39;Accept: application/json\&#39; \\n--header \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\n--header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n--data \&#39;subject&#x3D;Welcome\&#39; \\n--data \&#39;body&#x3D;Hello\&#39; \\n--data from&#x3D;user@domain.com \\n--data &quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;&quot;\n&#x60;&#x60;&#x60;\n\n&#x60;&#x60;&#x60;MultToArrayForm\ncurl -i --request POST --url https://api.mailbaby.net/mail/advsend \\n--header \&#39;Accept: application/json\&#39; \\n--header \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\n--header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n--data \&#39;subject&#x3D;Welcome\&#39; \\n--data \&#39;body&#x3D;Hello\&#39; \\n--data from&#x3D;user@domain.com \\n--data &quot;to[0][name]&#x3D;Joe&quot; \\n--data &quot;to[0][email]&#x3D;support@interserver.net&quot; \\n--data &quot;to[1][name]&#x3D;Joe&quot; \\n--data &quot;to[1][email]&#x3D;support@interserver.net&quot;\n&#x60;&#x60;&#x60;\n\n&#x60;&#x60;&#x60;BasicJson\ncurl -i --request POST --url https://api.mailbaby.net/mail/advsend \\n--header \&#39;Accept: application/json\&#39; \\n--header \&#39;Content-Type: application/json\&#39; \\n--header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n--data \&#39;{\n&quot;subject&quot;: &quot;Welcome&quot;,\n&quot;body&quot;: &quot;Hello&quot;,\n&quot;from&quot;: &quot;user@domain.com&quot;,\n&quot;to&quot;: &quot;support@interserver.net&quot;\n}\&#39;\n&#x60;&#x60;&#x60;\n\n&#x60;&#x60;&#x60;ArrayJson\ncurl -i --request POST --url https://api.mailbaby.net/mail/advsend \\n--header \&#39;Accept: application/json\&#39; \\n--header \&#39;Content-Type: application/json\&#39; \\n--header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n--data \&#39;{\n&quot;subject&quot;: &quot;Welcome&quot;,\n&quot;body&quot;: &quot;Hello&quot;,\n&quot;from&quot;: {&quot;name&quot;: &quot;Joe&quot;, &quot;email&quot;: &quot;user@domain.com&quot;},\n&quot;to&quot;: [{&quot;name&quot;: &quot;Joe&quot;, &quot;email&quot;: &quot;support@interserver.net&quot;}]\n}\&#39;\n&#x60;&#x60;&#x60;\n\n&#x60;&#x60;&#x60;NameEmailJson\ncurl -i --request POST --url https://api.mailbaby.net/mail/advsend \\n--header \&#39;Accept: application/json\&#39; \\n--header \&#39;Content-Type: application/json\&#39; \\n--header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n--data \&#39;{\n&quot;subject&quot;: &quot;Welcome&quot;,\n&quot;body&quot;: &quot;Hello&quot;,\n&quot;from&quot;: &quot;Joe &lt;user@domain.com&gt;&quot;,\n&quot;to&quot;: &quot;Joe &lt;support@interserver.net&gt;&quot;\n}\&#39;\n&#x60;&#x60;&#x60;\n
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
            'to' => '',
            'replyto' => '',
            'cc' => '',
            'bcc' => '',
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


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.sendAdvMail(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.sendAdvMail(params);
        System.assertEquals(expectedResponse, response);


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
            'body' => 'null',
            'id' => ''
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


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.sendMail(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.sendMail(params);
        System.assertEquals(expectedResponse, response);


        js = JSON.serialize(OASGenericResponse.getExample());
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = OASGenericResponse.getExample();
        response = (OASGenericResponse) api.sendMail(params);
        System.assertEquals(expectedResponse, response);
    }
}