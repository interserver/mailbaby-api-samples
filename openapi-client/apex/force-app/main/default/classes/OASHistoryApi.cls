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

public class OASHistoryApi {
    OASClient client;

    public OASHistoryApi(OASClient client) {
        this.client = client;
    }

    public OASHistoryApi() {
        this.client = new OASClient();
    }

    public OASClient getClient() {
        return this.client;
    }

    /**
     * displays a list of blocked email addresses
     * 
     * @return List<OASGetStats200ResponseInner>
     * @throws OAS.ApiException if fails to make API call
     */
    public List<OASGetStats200ResponseInner> getStats() {
        List<OAS.Param> query = new List<OAS.Param>();
        List<OAS.Param> form = new List<OAS.Param>();

        return (List<OASGetStats200ResponseInner>) client.invoke(
            'GET', '/mail/stats', '',
            query, form,
            new Map<String, Object>(),
            new Map<String, Object>(),
            new List<String>{ 'application/json' },
            new List<String>(),
            new List<String> { 'apiKeyAuth' },
            List<OASGetStats200ResponseInner>.class
        );
    }
    /**
     * displays the mail log
     * Get a listing of the emails sent through this system\n
     * @param id The ID of your mail order this will be sent through. (optional)
     * @param origin originating ip address sending mail (optional)
     * @param mx mx record mail was sent to (optional)
     * @param r_from from email address (optional)
     * @param to to/destination email address (optional)
     * @param subject subject containing this string (optional)
     * @param mailid mail id (optional)
     * @param skip number of records to skip for pagination (optional, default to 0)
     * @param r_limit maximum number of records to return (optional, default to 100)
     * @param startDate earliest date to get emails in unix timestamp format (optional)
     * @param endDate earliest date to get emails in unix timestamp format (optional)
     * @return OASMailLog
     * @throws OAS.ApiException if fails to make API call
     */
    public OASMailLog viewMailLog(Map<String, Object> params) {
        List<OAS.Param> query = new List<OAS.Param>();

        // cast query params to verify their expected type
        query.addAll(client.makeParam('id', (Long) params.get('id')));
        query.addAll(client.makeParam('origin', (String) params.get('origin')));
        query.addAll(client.makeParam('mx', (String) params.get('mx')));
        query.addAll(client.makeParam('from', (String) params.get('r_from')));
        query.addAll(client.makeParam('to', (String) params.get('to')));
        query.addAll(client.makeParam('subject', (String) params.get('subject')));
        query.addAll(client.makeParam('mailid', (String) params.get('mailid')));
        query.addAll(client.makeParam('skip', (Integer) params.get('skip')));
        query.addAll(client.makeParam('limit', (Integer) params.get('r_limit')));
        query.addAll(client.makeParam('startDate', (Long) params.get('startDate')));
        query.addAll(client.makeParam('endDate', (Long) params.get('endDate')));

        List<OAS.Param> form = new List<OAS.Param>();

        return (OASMailLog) client.invoke(
            'GET', '/mail/log', '',
            query, form,
            new Map<String, Object>(),
            new Map<String, Object>(),
            new List<String>{ 'application/json' },
            new List<String>(),
            new List<String> { 'apiKeyAuth' },
            OASMailLog.class
        );
    }
}