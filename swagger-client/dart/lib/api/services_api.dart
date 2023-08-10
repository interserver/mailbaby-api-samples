part of swagger.api;



class ServicesApi {
  final ApiClient apiClient;

  ServicesApi([ApiClient apiClient]) : apiClient = apiClient ?? defaultApiClient;

  /// displays a list of mail service orders
  ///
  /// This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
  Future<List<MailOrder>> getMailOrders() async {
    Object postBody = null;

    // verify required params are set

    // create path and map variables
    String path = "/mail".replaceAll("{format}","json");

    // query params
    List<QueryParam> queryParams = [];
    Map<String, String> headerParams = {};
    Map<String, String> formParams = {};
    
    List<String> contentTypes = [];

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";
    List<String> authNames = ["apiKeyAuth"];

    if(contentType.startsWith("multipart/form-data")) {
      bool hasFields = false;
      MultipartRequest mp = new MultipartRequest(null, null);
      if(hasFields)
        postBody = mp;
    }
    else {
          }

    var response = await apiClient.invokeAPI(path,
                                             'GET',
                                             queryParams,
                                             postBody,
                                             headerParams,
                                             formParams,
                                             contentType,
                                             authNames);

    if(response.statusCode >= 400) {
      throw new ApiException(response.statusCode, response.body);
    } else if(response.body != null) {
      return
        (apiClient.deserialize(response.body, 'List<MailOrder>') as List).map((item) => item as MailOrder).toList();
    } else {
      return null;
    }
  }
}
