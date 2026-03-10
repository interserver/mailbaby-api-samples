@isTest
private class OASSendingApiTest {
    /**
     * Sends a raw RFC 822 email
     *
     * Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.\n\nThis endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact.  If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.\n\nThe &#x60;From&#x60; and recipient addresses are parsed automatically from the message headers (&#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, &#x60;Bcc&#x60;).  You do **not** need to specify them separately.\n\nIf an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.\n\nOn success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record.\n
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
     * Sends an email through one of your mail orders with full control over recipients, headers, and attachments.  Supports multiple To / CC / BCC addresses, named contacts, Reply-To overrides, and base64-encoded file attachments.\n\n**Content-type flexibility** — the request body may be submitted as either &#x60;application/x-www-form-urlencoded&#x60; or &#x60;application/json&#x60;.  When using form encoding, address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) accept both a plain RFC 822 comma-separated string (e.g. &#x60;&quot;Joe &lt;joe@example.com&gt;, jane@example.com&quot;&#x60;) and the structured &#x60;[{&quot;email&quot;:&quot;...&quot;,&quot;name&quot;:&quot;...&quot;}]&#x60; array format.  When using JSON, both formats are equally supported.\n\n**HTML detection** is automatic — if &#x60;body&#x60; contains HTML tags the &#x60;Content-Type&#x60; is set to &#x60;text/html&#x60;; otherwise &#x60;text/plain&#x60;.\n\n**Attachments** must be base64-encoded.  Each attachment requires at least a &#x60;data&#x60; field; the optional &#x60;filename&#x60; field controls the attachment name shown to recipients.\n\nIf an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.\n\nOn success the response &#x60;text&#x60; field contains the relay transaction ID which can be looked up in &#x60;GET /mail/log&#x60; via the &#x60;mailid&#x60; query parameter.\n\n## Examples\n\n### Form — basic string addresses\n&#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\n  -H \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n  -H \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\n  -d \&#39;subject&#x3D;Welcome\&#39; \\n  -d \&#39;body&#x3D;Hello\&#39; \\n  -d from&#x3D;user@domain.com \\n  -d to&#x3D;support@interserver.net\n&#x60;&#x60;&#x60;\n### Form — RFC 822 named addresses\n&#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\n  -H \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n  -H \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\n  -d \&#39;subject&#x3D;Welcome\&#39; \\n  -d \&#39;body&#x3D;Hello\&#39; \\n  -d \&#39;from&#x3D;Joe &lt;user@domain.com&gt;\&#39; \\n  -d \&#39;to&#x3D;Jane &lt;support@interserver.net&gt;\&#39;\n&#x60;&#x60;&#x60;\n### Form — multiple recipients as array\n&#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\n  -H \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n  -H \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\n  -d \&#39;subject&#x3D;Welcome\&#39; -d \&#39;body&#x3D;Hello\&#39; \\n  -d from&#x3D;user@domain.com \\n  -d \&#39;to[0][name]&#x3D;Joe\&#39; -d \&#39;to[0][email]&#x3D;support@interserver.net\&#39; \\n  -d \&#39;to[1][name]&#x3D;Jane\&#39; -d \&#39;to[1][email]&#x3D;jane@interserver.net\&#39;\n&#x60;&#x60;&#x60;\n### JSON — structured objects\n&#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\n  -H \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n  -H \&#39;Content-Type: application/json\&#39; \\n  -d \&#39;{\n    &quot;subject&quot;: &quot;Welcome&quot;,\n    &quot;body&quot;: &quot;&lt;h1&gt;Hello&lt;/h1&gt;&quot;,\n    &quot;from&quot;: {&quot;email&quot;: &quot;user@domain.com&quot;, &quot;name&quot;: &quot;Sender Name&quot;},\n    &quot;to&quot;: [{&quot;email&quot;: &quot;joe@client.com&quot;, &quot;name&quot;: &quot;Joe Client&quot;}],\n    &quot;cc&quot;: [{&quot;email&quot;: &quot;manager@client.com&quot;}],\n    &quot;attachments&quot;: [{&quot;filename&quot;: &quot;report.pdf&quot;, &quot;data&quot;: &quot;BASE64_DATA&quot;}]\n  }\&#39;\n&#x60;&#x60;&#x60;\n
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
     * Sends an email through one of your mail orders using a simple flat set of fields. This is the quickest way to send a single-recipient plain-text or HTML message.\n\n**HTML detection** is automatic — if the &#x60;body&#x60; value contains any HTML tags the message will be sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.\n\nThe &#x60;from&#x60; address is also automatically set as the &#x60;Reply-To&#x60; header.\n\n*Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use &#x60;POST /mail/advsend&#x60; instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use &#x60;POST /mail/rawsend&#x60;.\n\nOn success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record.\n
     */
    @isTest
    private static void sendMailTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        Map<String, Object> params = new Map<String, Object>{
            'to' => '',
            'r_from' => 'null',
            'subject' => 'null',
            'body' => 'null',
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