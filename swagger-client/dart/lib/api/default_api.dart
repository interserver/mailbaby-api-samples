part of swagger.api;



class DefaultApi {
  final ApiClient apiClient;

  DefaultApi([ApiClient apiClient]) : apiClient = apiClient ?? defaultApiClient;

  /// displays a list of mail service orders
  ///
  /// 
  Future<MailOrders> getMailOrders({ int id }) async {
    Object postBody = null;

    // verify required params are set

    // create path and map variables
    String path = "/mail".replaceAll("{format}","json");

    // query params
    List<QueryParam> queryParams = [];
    Map<String, String> headerParams = {};
    Map<String, String> formParams = {};
    if(id != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "id", id));
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
          apiClient.deserialize(response.body, 'MailOrders') as MailOrders ;
    } else {
      return null;
    }
  }
  /// Checks if the server is running
  ///
  /// 
  Future pingServer() async {
    Object postBody = null;

    // verify required params are set

    // create path and map variables
    String path = "/ping".replaceAll("{format}","json");

    // query params
    List<QueryParam> queryParams = [];
    Map<String, String> headerParams = {};
    Map<String, String> formParams = {};
    
    List<String> contentTypes = [];

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";
    List<String> authNames = [];

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
          ;
    } else {
      return ;
    }
  }
  /// places a mail order
  ///
  /// Adds an item to the system
  @deprecated
  Future placeMailOrder({ MailOrder body }) async {
    Object postBody = body;

    // verify required params are set

    // create path and map variables
    String path = "/mail/order".replaceAll("{format}","json");

    // query params
    List<QueryParam> queryParams = [];
    Map<String, String> headerParams = {};
    Map<String, String> formParams = {};
    
    List<String> contentTypes = ["application/json"];

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
          ;
    } else {
      return ;
    }
  }
  /// Sends an Email with Advanced Options
  ///
  /// Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
  Future<GenericResponse> sendAdvMail(SendMailAdv body) async {
    Object postBody = body;

    // verify required params are set
    if(body == null) {
     throw new ApiException(400, "Missing required param: body");
    }

    // create path and map variables
    String path = "/mail/advsend".replaceAll("{format}","json");

    // query params
    List<QueryParam> queryParams = [];
    Map<String, String> headerParams = {};
    Map<String, String> formParams = {};
    
    List<String> contentTypes = ["application/json","application/x-www-form-urlencoded"];

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";
    List<String> authNames = ["apiKeyAuth"];

    if(contentType.startsWith("multipart/form-data")) {
      bool hasFields = false;
      MultipartRequest mp = new MultipartRequest(null, null);
      if (subject != null) {
        hasFields = true;
        mp.fields['subject'] = parameterToString(subject);
      }
      if (body != null) {
        hasFields = true;
        mp.fields['body'] = parameterToString(body);
      }
      if (from != null) {
        hasFields = true;
        mp.fields['from'] = parameterToString(from);
      }
      if (to != null) {
        hasFields = true;
        mp.fields['to'] = parameterToString(to);
      }
      if (id != null) {
        hasFields = true;
        mp.fields['id'] = parameterToString(id);
      }
      if (replyto != null) {
        hasFields = true;
        mp.fields['replyto'] = parameterToString(replyto);
      }
      if (cc != null) {
        hasFields = true;
        mp.fields['cc'] = parameterToString(cc);
      }
      if (bcc != null) {
        hasFields = true;
        mp.fields['bcc'] = parameterToString(bcc);
      }
      if (attachments != null) {
        hasFields = true;
        mp.fields['attachments'] = parameterToString(attachments);
      }
      if(hasFields)
        postBody = mp;
    }
    else {
      if (subject != null)
        formParams['subject'] = parameterToString(subject);
if (body != null)
        formParams['body'] = parameterToString(body);
if (from != null)
        formParams['from'] = parameterToString(from);
if (to != null)
        formParams['to'] = parameterToString(to);
if (id != null)
        formParams['id'] = parameterToString(id);
if (replyto != null)
        formParams['replyto'] = parameterToString(replyto);
if (cc != null)
        formParams['cc'] = parameterToString(cc);
if (bcc != null)
        formParams['bcc'] = parameterToString(bcc);
if (attachments != null)
        formParams['attachments'] = parameterToString(attachments);
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
  /// Sends an Email
  ///
  /// Sends An email through one of your mail orders.
  Future<GenericResponse> sendMail(Body body) async {
    Object postBody = body;

    // verify required params are set
    if(body == null) {
     throw new ApiException(400, "Missing required param: body");
    }

    // create path and map variables
    String path = "/mail/send".replaceAll("{format}","json");

    // query params
    List<QueryParam> queryParams = [];
    Map<String, String> headerParams = {};
    Map<String, String> formParams = {};
    
    List<String> contentTypes = ["application/json","application/x-www-form-urlencoded"];

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";
    List<String> authNames = ["apiKeyAuth"];

    if(contentType.startsWith("multipart/form-data")) {
      bool hasFields = false;
      MultipartRequest mp = new MultipartRequest(null, null);
      if (to != null) {
        hasFields = true;
        mp.fields['to'] = parameterToString(to);
      }
      if (from != null) {
        hasFields = true;
        mp.fields['from'] = parameterToString(from);
      }
      if (subject != null) {
        hasFields = true;
        mp.fields['subject'] = parameterToString(subject);
      }
      if (body != null) {
        hasFields = true;
        mp.fields['body'] = parameterToString(body);
      }
      if(hasFields)
        postBody = mp;
    }
    else {
      if (to != null)
        formParams['to'] = parameterToString(to);
if (from != null)
        formParams['from'] = parameterToString(from);
if (subject != null)
        formParams['subject'] = parameterToString(subject);
if (body != null)
        formParams['body'] = parameterToString(body);
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
  /// validatess order details before placing an order
  ///
  /// 
  @deprecated
  Future validateMailOrder() async {
    Object postBody = null;

    // verify required params are set

    // create path and map variables
    String path = "/mail/order".replaceAll("{format}","json");

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
          ;
    } else {
      return ;
    }
  }
  /// displays the mail log
  ///
  /// By passing in the appropriate options, you can search for available inventory in the system 
  Future<List<MailLog>> viewMailLogById({ int id, String searchString, int skip, int limit }) async {
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
    if(searchString != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "searchString", searchString));
    }
    if(skip != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "skip", skip));
    }
    if(limit != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "limit", limit));
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
        (apiClient.deserialize(response.body, 'List<MailLog>') as List).map((item) => item as MailLog).toList();
    } else {
      return null;
    }
  }
}
