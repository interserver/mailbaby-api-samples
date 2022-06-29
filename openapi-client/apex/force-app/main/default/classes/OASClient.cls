public class OASClient extends OAS.ApiClient {
    public OASClient() {
        basePath = 'https://api.mailbaby.net';
        calloutName = 'MailBaby_Email_Delivery_API';
        authentications.put('apiKeyAuth', new OAS.ApiKeyHeaderAuth('X-API-KEY'));
    }
}
