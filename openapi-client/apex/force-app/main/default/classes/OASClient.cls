public class OASClient extends OAS.ApiClient {
    public OASClient() {
        basePath = 'http://mystage.interserver.net:8787';
        calloutName = 'Mail_Baby_API';
        authentications.put('apiKeyAuth', new OAS.ApiKeyHeaderAuth('X-API-KEY'));
    }
}
