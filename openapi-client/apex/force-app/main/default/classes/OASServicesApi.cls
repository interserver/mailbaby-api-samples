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

public class OASServicesApi {
    OASClient client;

    public OASServicesApi(OASClient client) {
        this.client = client;
    }

    public OASServicesApi() {
        this.client = new OASClient();
    }

    public OASClient getClient() {
        return this.client;
    }

    /**
     * displays a list of mail service orders
     * This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
     * @return List<OASMailOrder>
     * @throws OAS.ApiException if fails to make API call
     */
    public List<OASMailOrder> getMailOrders() {
        List<OAS.Param> query = new List<OAS.Param>();
        List<OAS.Param> form = new List<OAS.Param>();

        return (List<OASMailOrder>) client.invoke(
            'GET', '/mail', '',
            query, form,
            new Map<String, Object>(),
            new Map<String, Object>(),
            new List<String>{ 'application/json' },
            new List<String>(),
            new List<String> { 'apiKeyAuth' },
            List<OASMailOrder>.class
        );
    }
}