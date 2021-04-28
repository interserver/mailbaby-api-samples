public class OASClient extends OAS.ApiClient {
    public OASClient() {
        basePath = 'https://api.mailbaby.net';
        calloutName = 'Mail_Baby_API';
        authentications.put('apiKeyAuth', new OAS.ApiKeyHeaderAuth('X-API-KEY'));
        authentications.put('apiLoginAuth', new OAS.ApiKeyHeaderAuth('X-API-LOGIN'));
        authentications.put('apiPasswordAuth', new OAS.ApiKeyHeaderAuth('X-API-PASS'));
    }
}
