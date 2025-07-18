/*
 * MailBaby Email Delivery and Management Service API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**\n# Overview\nThis is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).\n# Authentication\nIn order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.\nWe support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page.\n
 *
 * The version of the OpenAPI document: 1.1.0
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by the OAS code generator program.
 * https://github.com/OpenAPITools/openapi-generator
 * Do not edit the class manually.
 */

public class OASSendingApi {
    OASClient client;

    public OASSendingApi(OASClient client) {
        this.client = client;
    }

    public OASSendingApi() {
        this.client = new OASClient();
    }

    public OASClient getClient() {
        return this.client;
    }

    /**
     * Sends an Email with Advanced Options
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.\n\nHere are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.\n\n&#x60;&#x60;&#x60;BasicForm\ncurl -i --request POST --url https://api.mailbaby.net/mail/advsend \\n--header \&#39;Accept: application/json\&#39; \\n--header \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\n--header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n--data \&#39;subject&#x3D;Welcome\&#39; \\n--data \&#39;body&#x3D;Hello\&#39; \\n--data from&#x3D;user@domain.com \\n--data to&#x3D;support@interserver.net\n&#x60;&#x60;&#x60;\n\n&#x60;&#x60;&#x60;ArrayForm\ncurl -i --request POST --url https://api.mailbaby.net/mail/advsend \\n--header \&#39;Accept: application/json\&#39; \\n--header \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\n--header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n--data \&#39;subject&#x3D;Welcome\&#39; \\n--data \&#39;body&#x3D;Hello\&#39; \\n--data from&#x3D;user@domain.com \\n--data &quot;to[0][name]&#x3D;Joe&quot; \\n--data &quot;to[0][email]&#x3D;support@interserver.net&quot;\n&#x60;&#x60;&#x60;\n\n&#x60;&#x60;&#x60;NameEmailForm\ncurl -i --request POST --url https://api.mailbaby.net/mail/advsend \\n--header \&#39;Accept: application/json\&#39; \\n--header \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\n--header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n--data \&#39;subject&#x3D;Welcome\&#39; \\n--data \&#39;body&#x3D;Hello\&#39; \\n--data from&#x3D;&quot;Joe &lt;user@domain.com&gt;&quot; \\n--data to&#x3D;&quot;Joe &lt;support@interserver.net&gt;&quot;\n&#x60;&#x60;&#x60;\n\n&#x60;&#x60;&#x60;MultToForm\ncurl -i --request POST --url https://api.mailbaby.net/mail/advsend \\n--header \&#39;Accept: application/json\&#39; \\n--header \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\n--header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n--data \&#39;subject&#x3D;Welcome\&#39; \\n--data \&#39;body&#x3D;Hello\&#39; \\n--data from&#x3D;user@domain.com \\n--data &quot;to&#x3D;support@interserver.net, support@interserver.net&quot;\n&#x60;&#x60;&#x60;\n\n&#x60;&#x60;&#x60;MultToFullForm\ncurl -i --request POST --url https://api.mailbaby.net/mail/advsend \\n--header \&#39;Accept: application/json\&#39; \\n--header \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\n--header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n--data \&#39;subject&#x3D;Welcome\&#39; \\n--data \&#39;body&#x3D;Hello\&#39; \\n--data from&#x3D;user@domain.com \\n--data &quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;&quot;\n&#x60;&#x60;&#x60;\n\n&#x60;&#x60;&#x60;MultToArrayForm\ncurl -i --request POST --url https://api.mailbaby.net/mail/advsend \\n--header \&#39;Accept: application/json\&#39; \\n--header \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\n--header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n--data \&#39;subject&#x3D;Welcome\&#39; \\n--data \&#39;body&#x3D;Hello\&#39; \\n--data from&#x3D;user@domain.com \\n--data &quot;to[0][name]&#x3D;Joe&quot; \\n--data &quot;to[0][email]&#x3D;support@interserver.net&quot; \\n--data &quot;to[1][name]&#x3D;Joe&quot; \\n--data &quot;to[1][email]&#x3D;support@interserver.net&quot;\n&#x60;&#x60;&#x60;\n\n&#x60;&#x60;&#x60;BasicJson\ncurl -i --request POST --url https://api.mailbaby.net/mail/advsend \\n--header \&#39;Accept: application/json\&#39; \\n--header \&#39;Content-Type: application/json\&#39; \\n--header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n--data \&#39;{\n&quot;subject&quot;: &quot;Welcome&quot;,\n&quot;body&quot;: &quot;Hello&quot;,\n&quot;from&quot;: &quot;user@domain.com&quot;,\n&quot;to&quot;: &quot;support@interserver.net&quot;\n}\&#39;\n&#x60;&#x60;&#x60;\n\n&#x60;&#x60;&#x60;ArrayJson\ncurl -i --request POST --url https://api.mailbaby.net/mail/advsend \\n--header \&#39;Accept: application/json\&#39; \\n--header \&#39;Content-Type: application/json\&#39; \\n--header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n--data \&#39;{\n&quot;subject&quot;: &quot;Welcome&quot;,\n&quot;body&quot;: &quot;Hello&quot;,\n&quot;from&quot;: {&quot;name&quot;: &quot;Joe&quot;, &quot;email&quot;: &quot;user@domain.com&quot;},\n&quot;to&quot;: [{&quot;name&quot;: &quot;Joe&quot;, &quot;email&quot;: &quot;support@interserver.net&quot;}]\n}\&#39;\n&#x60;&#x60;&#x60;\n\n&#x60;&#x60;&#x60;NameEmailJson\ncurl -i --request POST --url https://api.mailbaby.net/mail/advsend \\n--header \&#39;Accept: application/json\&#39; \\n--header \&#39;Content-Type: application/json\&#39; \\n--header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\n--data \&#39;{\n&quot;subject&quot;: &quot;Welcome&quot;,\n&quot;body&quot;: &quot;Hello&quot;,\n&quot;from&quot;: &quot;Joe &lt;user@domain.com&gt;&quot;,\n&quot;to&quot;: &quot;Joe &lt;support@interserver.net&gt;&quot;\n}\&#39;\n&#x60;&#x60;&#x60;\n
     * @param subject The subject or title of the email (required)
     * @param body The main email contents. (required)
     * @param r_from  (required)
     * @param to  (required)
     * @param replyto  (optional)
     * @param cc  (optional)
     * @param bcc  (optional)
     * @param attachments (optional) File attachments to include in the email.  The file contents must be base64 encoded! (optional)
     * @param id (optional)  ID of the Mail order within our system to use as the Mail Account. (optional)
     * @return OASGenericResponse
     * @throws OAS.ApiException if fails to make API call
     */
    public OASGenericResponse sendAdvMail(Map<String, Object> params) {
        client.assertNotNull(params.get('subject'), 'subject');
        client.assertNotNull(params.get('body'), 'body');
        client.assertNotNull(params.get('r_from'), 'r_from');
        client.assertNotNull(params.get('to'), 'to');
        List<OAS.Param> query = new List<OAS.Param>();
        List<OAS.Param> form = new List<OAS.Param>();

        // cast form params to verify their expected type
        form.addAll(client.makeParam('subject', (String) params.get('subject')));
        form.addAll(client.makeParam('body', (String) params.get('body')));
        form.addAll(client.makeParam('from', (OASEmailAddressTypes) params.get('r_from')));
        form.addAll(client.makeParam('to', (OASEmailAddressesTypes) params.get('to')));
        form.addAll(client.makeParam('replyto', (OASEmailAddressesTypes) params.get('replyto')));
        form.addAll(client.makeParam('cc', (OASEmailAddressesTypes) params.get('cc')));
        form.addAll(client.makeParam('bcc', (OASEmailAddressesTypes) params.get('bcc')));
        form.addAll(client.makeParam('attachments', (List<OASMailAttachment>) params.get('attachments'), 'csv'));
        form.addAll(client.makeParam('id', (Long) params.get('id')));

        return (OASGenericResponse) client.invoke(
            'POST', '/mail/advsend', '',
            query, form,
            new Map<String, Object>(),
            new Map<String, Object>(),
            new List<String>{ 'application/json' },
            new List<String>{ 'application/x-www-form-urlencoded', 'application/json' },
            new List<String> { 'apiKeyAuth' },
            OASGenericResponse.class
        );
    }
    /**
     * Sends an Email
     * Sends an email through one of your mail orders.\n\n*Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead.\n
     * @param to The Contact whom is the primary recipient of this email. (required)
     * @param r_from The contact whom is the this email is from. (required)
     * @param subject The subject or title of the email (required)
     * @param body The main email contents. (required)
     * @return OASGenericResponse
     * @throws OAS.ApiException if fails to make API call
     */
    public OASGenericResponse sendMail(Map<String, Object> params) {
        client.assertNotNull(params.get('to'), 'to');
        client.assertNotNull(params.get('r_from'), 'r_from');
        client.assertNotNull(params.get('subject'), 'subject');
        client.assertNotNull(params.get('body'), 'body');
        List<OAS.Param> query = new List<OAS.Param>();
        List<OAS.Param> form = new List<OAS.Param>();

        // cast form params to verify their expected type
        form.addAll(client.makeParam('to', (String) params.get('to')));
        form.addAll(client.makeParam('from', (String) params.get('r_from')));
        form.addAll(client.makeParam('subject', (String) params.get('subject')));
        form.addAll(client.makeParam('body', (String) params.get('body')));

        return (OASGenericResponse) client.invoke(
            'POST', '/mail/send', '',
            query, form,
            new Map<String, Object>(),
            new Map<String, Object>(),
            new List<String>{ 'application/json' },
            new List<String>{ 'application/x-www-form-urlencoded', 'application/json' },
            new List<String> { 'apiKeyAuth' },
            OASGenericResponse.class
        );
    }
}
