part of swagger.api;



class SendingApi {
  final ApiClient apiClient;

  SendingApi([ApiClient apiClient]) : apiClient = apiClient ?? defaultApiClient;

  /// Sends a raw RFC 822 email
  ///
  /// Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact.  If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The &#x60;From&#x60; and recipient addresses are parsed automatically from the message headers (&#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, &#x60;Bcc&#x60;).  You do **not** need to specify them separately.  If an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record. 
  Future<GenericResponse> rawMail(SendMailRaw body) async {
    Object postBody = body;

    // verify required params are set
    if(body == null) {
     throw new ApiException(400, "Missing required param: body");
    }

    // create path and map variables
    String path = "/mail/rawsend".replaceAll("{format}","json");

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
      if (rawEmail != null) {
        hasFields = true;
        mp.fields['raw_email'] = parameterToString(rawEmail);
      }
      if (id != null) {
        hasFields = true;
        mp.fields['id'] = parameterToString(id);
      }
      if(hasFields)
        postBody = mp;
    }
    else {
      if (rawEmail != null)
        formParams['raw_email'] = parameterToString(rawEmail);
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
  /// Sends an Email with Advanced Options
  ///
  /// Sends an email through one of your mail orders with full control over recipients, headers, and attachments.  Supports multiple To / CC / BCC addresses, named contacts, Reply-To overrides, and base64-encoded file attachments.  **Content-type flexibility** — the request body may be submitted as either &#x60;application/x-www-form-urlencoded&#x60; or &#x60;application/json&#x60;.  When using form encoding, address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) accept both a plain RFC 822 comma-separated string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;, jane@example.com\&quot;&#x60;) and the structured &#x60;[{\&quot;email\&quot;:\&quot;...\&quot;,\&quot;name\&quot;:\&quot;...\&quot;}]&#x60; array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if &#x60;body&#x60; contains HTML tags the &#x60;Content-Type&#x60; is set to &#x60;text/html&#x60;; otherwise &#x60;text/plain&#x60;.  **Attachments** must be base64-encoded.  Each attachment requires at least a &#x60;data&#x60; field; the optional &#x60;filename&#x60; field controls the attachment name shown to recipients.  If an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response &#x60;text&#x60; field contains the relay transaction ID which can be looked up in &#x60;GET /mail/log&#x60; via the &#x60;mailid&#x60; query parameter.  ## Examples  ### Form — basic string addresses &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\   -d &#x27;subject&#x3D;Welcome&#x27; \\   -d &#x27;body&#x3D;Hello&#x27; \\   -d from&#x3D;user@domain.com \\   -d to&#x3D;support@interserver.net &#x60;&#x60;&#x60; ### Form — RFC 822 named addresses &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\   -d &#x27;subject&#x3D;Welcome&#x27; \\   -d &#x27;body&#x3D;Hello&#x27; \\   -d &#x27;from&#x3D;Joe &lt;user@domain.com&gt;&#x27; \\   -d &#x27;to&#x3D;Jane &lt;support@interserver.net&gt;&#x27; &#x60;&#x60;&#x60; ### Form — multiple recipients as array &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\   -d &#x27;subject&#x3D;Welcome&#x27; -d &#x27;body&#x3D;Hello&#x27; \\   -d from&#x3D;user@domain.com \\   -d &#x27;to[0][name]&#x3D;Joe&#x27; -d &#x27;to[0][email]&#x3D;support@interserver.net&#x27; \\   -d &#x27;to[1][name]&#x3D;Jane&#x27; -d &#x27;to[1][email]&#x3D;jane@interserver.net&#x27; &#x60;&#x60;&#x60; ### JSON — structured objects &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -d &#x27;{     \&quot;subject\&quot;: \&quot;Welcome\&quot;,     \&quot;body\&quot;: \&quot;&lt;h1&gt;Hello&lt;/h1&gt;\&quot;,     \&quot;from\&quot;: {\&quot;email\&quot;: \&quot;user@domain.com\&quot;, \&quot;name\&quot;: \&quot;Sender Name\&quot;},     \&quot;to\&quot;: [{\&quot;email\&quot;: \&quot;joe@client.com\&quot;, \&quot;name\&quot;: \&quot;Joe Client\&quot;}],     \&quot;cc\&quot;: [{\&quot;email\&quot;: \&quot;manager@client.com\&quot;}],     \&quot;attachments\&quot;: [{\&quot;filename\&quot;: \&quot;report.pdf\&quot;, \&quot;data\&quot;: \&quot;BASE64_DATA\&quot;}]   }&#x27; &#x60;&#x60;&#x60; 
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
  /// Sends an email through one of your mail orders using a simple flat set of fields. This is the quickest way to send a single-recipient plain-text or HTML message.  **HTML detection** is automatic — if the &#x60;body&#x60; value contains any HTML tags the message will be sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is also automatically set as the &#x60;Reply-To&#x60; header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use &#x60;POST /mail/advsend&#x60; instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use &#x60;POST /mail/rawsend&#x60;.  On success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record. 
  Future<GenericResponse> sendMail(Object to, String from, String subject, String body, int id) async {
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
    if(id == null) {
     throw new ApiException(400, "Missing required param: id");
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
      if (id != null) {
        hasFields = true;
        mp.fields['id'] = parameterToString(id);
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
}
