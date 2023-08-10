part of swagger.api;



class BlockingApi {
  final ApiClient apiClient;

  BlockingApi([ApiClient apiClient]) : apiClient = apiClient ?? defaultApiClient;

  /// Creates a new email deny rule.
  ///
  /// Adds a new email deny rule into the system to block new emails that match the given criteria
  Future<GenericResponse> addRule(String user, String type, String data) async {
    Object postBody = body;

    // verify required params are set
    if(user == null) {
     throw new ApiException(400, "Missing required param: user");
    }
    if(type == null) {
     throw new ApiException(400, "Missing required param: type");
    }
    if(data == null) {
     throw new ApiException(400, "Missing required param: data");
    }

    // create path and map variables
    String path = "/mail/rules".replaceAll("{format}","json");

    // query params
    List<QueryParam> queryParams = [];
    Map<String, String> headerParams = {};
    Map<String, String> formParams = {};
    
    List<String> contentTypes = ["application/x-www-form-urlencoded","application/json"];

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";
    List<String> authNames = ["apiKeyAuth"];

    if(contentType.startsWith("multipart/form-data")) {
      bool hasFields = false;
      MultipartRequest mp = new MultipartRequest(null, null);
      if (user != null) {
        hasFields = true;
        mp.fields['user'] = parameterToString(user);
      }
      if (type != null) {
        hasFields = true;
        mp.fields['type'] = parameterToString(type);
      }
      if (data != null) {
        hasFields = true;
        mp.fields['data'] = parameterToString(data);
      }
      if(hasFields)
        postBody = mp;
    }
    else {
      if (user != null)
        formParams['user'] = parameterToString(user);
if (type != null)
        formParams['type'] = parameterToString(type);
if (data != null)
        formParams['data'] = parameterToString(data);
    }

    var response = await apiClient.invokeAPI(path,
                                             'POST',
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
          apiClient.deserialize(response.body, 'GenericResponse') as GenericResponse ;
    } else {
      return null;
    }
  }
  /// Removes an deny mail rule.
  ///
  /// Removes one of the configured deny mail rules from the system.
  Future<GenericResponse> deleteRule(int ruleId) async {
    Object postBody = null;

    // verify required params are set
    if(ruleId == null) {
     throw new ApiException(400, "Missing required param: ruleId");
    }

    // create path and map variables
    String path = "/mail/rules/{ruleId}".replaceAll("{format}","json").replaceAll("{" + "ruleId" + "}", ruleId.toString());

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
                                             'DELETE',
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
          apiClient.deserialize(response.body, 'GenericResponse') as GenericResponse ;
    } else {
      return null;
    }
  }
  /// Removes an email address from the blocked list
  ///
  /// Removes an email address from the various block lists. 
  Future<GenericResponse> delistBlock(EmailAddress body) async {
    Object postBody = body;

    // verify required params are set
    if(body == null) {
     throw new ApiException(400, "Missing required param: body");
    }

    // create path and map variables
    String path = "/mail/blocks/delete".replaceAll("{format}","json");

    // query params
    List<QueryParam> queryParams = [];
    Map<String, String> headerParams = {};
    Map<String, String> formParams = {};
    
    List<String> contentTypes = ["application/json","multipart/form-data"];

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";
    List<String> authNames = ["apiKeyAuth"];

    if(contentType.startsWith("multipart/form-data")) {
      bool hasFields = false;
      MultipartRequest mp = new MultipartRequest(null, null);
      if (email != null) {
        hasFields = true;
        mp.fields['email'] = parameterToString(email);
      }
      if(hasFields)
        postBody = mp;
    }
    else {
      if (email != null)
        formParams['email'] = parameterToString(email);
    }

    var response = await apiClient.invokeAPI(path,
                                             'POST',
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
          apiClient.deserialize(response.body, 'GenericResponse') as GenericResponse ;
    } else {
      return null;
    }
  }
  /// displays a list of blocked email addresses
  ///
  /// 
  Future<MailBlocks> getMailBlocks() async {
    Object postBody = null;

    // verify required params are set

    // create path and map variables
    String path = "/mail/blocks".replaceAll("{format}","json");

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
          apiClient.deserialize(response.body, 'MailBlocks') as MailBlocks ;
    } else {
      return null;
    }
  }
  /// Displays a listing of deny email rules.
  ///
  /// Returns a listing of all the deny block rules you have configured.
  Future<List<DenyRuleRecord>> getRules() async {
    Object postBody = null;

    // verify required params are set

    // create path and map variables
    String path = "/mail/rules".replaceAll("{format}","json");

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
        (apiClient.deserialize(response.body, 'List<DenyRuleRecord>') as List).map((item) => item as DenyRuleRecord).toList();
    } else {
      return null;
    }
  }
}
