part of swagger.api;



class HistoryApi {
  final ApiClient apiClient;

  HistoryApi([ApiClient apiClient]) : apiClient = apiClient ?? defaultApiClient;

  /// Account usage statistics.
  ///
  /// Returns information about the usage on your mail accounts.
  Future<List<InlineResponse200>> getStats() async {
    Object postBody = null;

    // verify required params are set

    // create path and map variables
    String path = "/mail/stats".replaceAll("{format}","json");

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
        (apiClient.deserialize(response.body, 'List<InlineResponse200>') as List).map((item) => item as InlineResponse200).toList();
    } else {
      return null;
    }
  }
  /// displays the mail log
  ///
  /// Get a listing of the emails sent through this system 
  Future<MailLog> viewMailLog({ int id, String origin, String mx, String from, String to, String subject, String mailid, int skip, int limit, int startDate, int endDate }) async {
    Object postBody = null;

    // verify required params are set

    // create path and map variables
    String path = "/mail/log".replaceAll("{format}","json");

    // query params
    List<QueryParam> queryParams = [];
    Map<String, String> headerParams = {};
    Map<String, String> formParams = {};
    if(id != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "id", id));
    }
    if(origin != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "origin", origin));
    }
    if(mx != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "mx", mx));
    }
    if(from != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "from", from));
    }
    if(to != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "to", to));
    }
    if(subject != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "subject", subject));
    }
    if(mailid != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "mailid", mailid));
    }
    if(skip != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "skip", skip));
    }
    if(limit != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "limit", limit));
    }
    if(startDate != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "startDate", startDate));
    }
    if(endDate != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "endDate", endDate));
    }
    
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
          apiClient.deserialize(response.body, 'MailLog') as MailLog ;
    } else {
      return null;
    }
  }
}
