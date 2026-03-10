@isTest
private class OASBlockingApiTest {
    /**
     * Creates a new email deny rule
     *
     * Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.\n\nThe &#x60;type&#x60; field selects the matching strategy:\n- **&#x60;email&#x60;** — exact match against the SMTP envelope &#x60;MAIL FROM&#x60; address. - **&#x60;domain&#x60;** — matches any sender address at the specified domain. - **&#x60;destination&#x60;** — exact match against the SMTP envelope &#x60;RCPT TO&#x60; address. - **&#x60;startswith&#x60;** — matches any sender address whose local-part (the portion\n  before the &#x60;@&#x60;) starts with the given string.  Only alphanumeric characters\n  and &#x60;+&#x60;, &#x60;_&#x60;, &#x60;.&#x60;, &#x60;-&#x60; are permitted in the prefix.\n\n\nIf &#x60;username&#x60; is provided it must be the SMTP username of one of your active mail orders (e.g. &#x60;mb20682&#x60;).  If omitted the rule is associated with your first active order.\n\nOn success the response &#x60;text&#x60; field contains the newly created rule\&#39;s &#x60;id&#x60;, which can later be passed to &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove it.\n
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
     * Removes a deny mail rule
     *
     * Permanently removes a single deny rule identified by its numeric &#x60;ruleId&#x60;.\n\nThe &#x60;ruleId&#x60; is the &#x60;id&#x60; field returned by &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field from a successful &#x60;POST /mail/rules&#x60; response.\n\nOnly rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account.\n
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
     * Removes an email address from the block lists
     *
     * Delists an email address from all three block list stores:\n1. The rspamd spam-filter database (&#x60;fromemail&#x60; / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.\n\nUse &#x60;GET /mail/blocks&#x60; to discover which addresses are currently blocked.  The &#x60;from&#x60; field in any returned block entry is a valid input for this call.\n\n**Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules.\n
     */
    @isTest
    private static void delistBlockTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        Map<String, Object> params = new Map<String, Object>{
            'oaSEmailAddressParam' => {"email":"client@domain.com"}
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
     * Displays a list of blocked email addresses
     *
     * Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s).  Three categories are returned:\n\n- **&#x60;local&#x60;** — messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule.  These are\n  messages sent to recipients on your account\&#39;s local block list.\n- **&#x60;mbtrap&#x60;** — messages flagged by the &#x60;MBTRAP&#x60; rspamd rule.  These are messages\n  that triggered MailBaby\&#39;s internal trap / honeypot detection.\n- **&#x60;subject&#x60;** — senders whose recent messages contain spam-indicative subjects\n  (strings containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with high repetition\n  (more than 4 identical subjects from the same sender in the last 3 days).\n\n\nThe &#x60;local&#x60; and &#x60;mbtrap&#x60; results cover the last 5 days.  The &#x60;subject&#x60; results cover the last 3 days.\n\nA sender address returned in any of these lists can be delisted using &#x60;POST /mail/blocks/delete&#x60; with the &#x60;email&#x60; field set to that address.\n
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
    }

    /**
     * Displays a listing of deny email rules
     *
     * Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.\n\nFour rule types are supported:\n| &#x60;type&#x60; | &#x60;data&#x60; format | Effect | |--------|---------------|--------| | &#x60;email&#x60; | &#x60;user@domain.com&#x60; | Rejects any message from this exact sender address | | &#x60;domain&#x60; | &#x60;domain.com&#x60; | Rejects any message from any address at this domain | | &#x60;destination&#x60; | &#x60;user@domain.com&#x60; | Rejects any message addressed to this recipient | | &#x60;startswith&#x60; | &#x60;prefix&#x60; | Rejects any message whose sender address begins with this string (alphanumeric, &#x60;+&#x60;, &#x60;_&#x60;, &#x60;.&#x60;, &#x60;-&#x60; only) |\n\nUse &#x60;POST /mail/rules&#x60; to add new rules and &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove them.  The &#x60;id&#x60; field in each returned record is the value needed for the delete call.\n
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
    }
}