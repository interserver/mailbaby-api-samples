part of swagger.api;



class SendingApi {
  final ApiClient apiClient;

  SendingApi([ApiClient apiClient]) : apiClient = apiClient ?? defaultApiClient;

  /// Sends an Email with Advanced Options
  ///
  /// Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ --data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ --data \&quot;to[1][name]&#x3D;Joe\&quot; \\ --data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#x27; &#x60;&#x60;&#x60; 
  Future<GenericResponse> sendAdvMail(String subject, String body, EmailAddressTypes from, EmailAddressesTypes to, EmailAddressesTypes replyto, EmailAddressesTypes cc, EmailAddressesTypes bcc, List<MailAttachment> attachments, int id) async {
    Object postBody = body;

    // verify required params are set
    if(subject == null) {
     throw new ApiException(400, "Missing required param: subject");
    }
    if(body == null) {
     throw new ApiException(400, "Missing required param: body");
    }
    if(from == null) {
     throw new ApiException(400, "Missing required param: from");
    }
    if(to == null) {
     throw new ApiException(400, "Missing required param: to");
    }
    if(replyto == null) {
     throw new ApiException(400, "Missing required param: replyto");
    }
    if(cc == null) {
     throw new ApiException(400, "Missing required param: cc");
    }
    if(bcc == null) {
     throw new ApiException(400, "Missing required param: bcc");
    }
    if(attachments == null) {
     throw new ApiException(400, "Missing required param: attachments");
    }
    if(id == null) {
     throw new ApiException(400, "Missing required param: id");
    }

    // create path and map variables
    String path = "/mail/advsend".replaceAll("{format}","json");

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
      if (id != null) {
        hasFields = true;
        mp.fields['id'] = parameterToString(id);
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
if (replyto != null)
        formParams['replyto'] = parameterToString(replyto);
if (cc != null)
        formParams['cc'] = parameterToString(cc);
if (bcc != null)
        formParams['bcc'] = parameterToString(bcc);
if (attachments != null)
        formParams['attachments'] = parameterToString(attachments);
if (id != null)
        formParams['id'] = parameterToString(id);
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
  /// Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
  Future<GenericResponse> sendMail(String to, String from, String subject, String body) async {
    Object postBody = body;

    // verify required params are set
    if(to == null) {
     throw new ApiException(400, "Missing required param: to");
    }
    if(from == null) {
     throw new ApiException(400, "Missing required param: from");
    }
    if(subject == null) {
     throw new ApiException(400, "Missing required param: subject");
    }
    if(body == null) {
     throw new ApiException(400, "Missing required param: body");
    }

    // create path and map variables
    String path = "/mail/send".replaceAll("{format}","json");

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
}
