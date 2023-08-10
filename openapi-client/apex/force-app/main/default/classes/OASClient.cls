public class OASClient extends OAS.ApiClient {
    public OASClient() {
        basePath = 'https://api.mailbaby.net';
        calloutName = 'MailBaby_Email_Delivery_and_Management_Service_API';
        authentications.put('apiKeyAuth', new OAS.ApiKeyHeaderAuth('X-API-KEY'));
    }
}
