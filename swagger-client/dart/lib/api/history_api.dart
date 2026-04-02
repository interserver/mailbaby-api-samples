part of swagger.api;



class HistoryApi {
  final ApiClient apiClient;

  HistoryApi([ApiClient apiClient]) : apiClient = apiClient ?? defaultApiClient;

  /// Account usage statistics
  ///
  /// Returns aggregate sending statistics for your mail account(s) across a selectable time window.  Useful for dashboards, billing reviews, and detecting unusual traffic patterns.  The response includes: - **&#x60;usage&#x60;** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **&#x60;cost&#x60;** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **&#x60;received&#x60;** / **&#x60;sent&#x60;** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected &#x60;time&#x60; window. - **&#x60;volume&#x60;** — top-500 breakdown of message counts grouped by source IP (&#x60;ip&#x60;),   destination address (&#x60;to&#x60;), and sender address (&#x60;from&#x60;) within the selected window.   **Time windows** (controlled by the &#x60;time&#x60; parameter): | Value | Window | |-------|--------| | &#x60;1h&#x60; | Last 1 hour (default) | | &#x60;24h&#x60; | Last 24 hours | | &#x60;7d&#x60; | Last 7 days | | &#x60;month&#x60; | Current calendar month (1st to now) | | &#x60;day&#x60; | Today (midnight to now) | | &#x60;billing&#x60; | Current billing cycle (last invoice date to next invoice date) | | &#x60;all&#x60; | All time | 
  Future<MailStatsType> getStats({ String time }) async {
    Object postBody = null;

    // verify required params are set

    // create path and map variables
    String path = "/mail/stats".replaceAll("{format}","json");

    // query params
    List<QueryParam> queryParams = [];
    Map<String, String> headerParams = {};
    Map<String, String> formParams = {};
    if(time != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "time", time));
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
          apiClient.deserialize(response.body, 'MailStatsType') as MailStatsType ;
    } else {
      return null;
    }
  }
  /// Displays the mail log
  ///
  /// Returns a paginated list of every email message accepted by the relay for your mail account(s).  All filter parameters are optional and combinable.  **Row grouping** is controlled by the &#x60;groupby&#x60; parameter.  By default (&#x60;groupby&#x3D;recipient&#x60;), the response contains one row per delivery attempt — so a single message sent to 4 recipients produces 4 rows, each with its own &#x60;recipient&#x60;, &#x60;delivered&#x60;, &#x60;response&#x60;, and &#x60;mxHostname&#x60; values.  Set &#x60;groupby&#x3D;message&#x60; to collapse to one row per message (delivery fields will reflect one arbitrary recipient).  **Pagination** is controlled by &#x60;skip&#x60; and &#x60;limit&#x60;.  The &#x60;total&#x60; in the response reflects the row count **after** grouping, so it matches the number of pages you need to fetch.  **Date filtering** accepts either a Unix timestamp (integer) or a date string parseable by PHP &#x60;strtotime()&#x60; such as &#x60;2024-01-15&#x60;, &#x60;last monday&#x60;, or &#x60;2024-01-01 00:00:00&#x60;.  Examples: &#x60;startDate&#x3D;1704067200&amp;endDate&#x3D;1706745599&#x60; or &#x60;startDate&#x3D;2024-01-01&amp;endDate&#x3D;2024-01-31&#x60;.  **Sorting** is controlled by &#x60;sort&#x60; and &#x60;dir&#x60;.  Currently the only sort key is &#x60;time&#x60; (default), which orders by internal row ID.  **Delivery status** can be filtered with the &#x60;delivered&#x60; parameter: &#x60;delivered&#x3D;1&#x60; returns only successfully delivered messages; &#x60;delivered&#x3D;0&#x60; returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (&#x60;from&#x60;, &#x60;to&#x60;) and message headers (&#x60;headerfrom&#x60; for the &#x60;From:&#x60; header, &#x60;replyto&#x60; for &#x60;Reply-To:&#x60;). These may differ when a message is sent on behalf of another address.  The &#x60;mailid&#x60; parameter corresponds to the &#x60;id&#x60; field in the returned &#x60;MailLogEntry&#x60; objects, **not** the &#x60;_id&#x60; field.  It also matches the transaction ID returned in the &#x60;text&#x60; field of a successful send response from &#x60;/mail/send&#x60;, &#x60;/mail/advsend&#x60;, or &#x60;/mail/rawsend&#x60;.  The &#x60;messageId&#x60; parameter searches the &#x60;Message-ID&#x60; email header (case-insensitive substring match). 
  Future<MailLog> viewMailLog({ int id, String origin, String mx, String from, String to, String subject, String mailid, String messageId, String replyto, String headerfrom, int delivered, int skip, int limit, StartDate startDate, EndDate endDate, String sort, String dir, String groupby }) async {
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
    if(messageId != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "messageId", messageId));
    }
    if(replyto != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "replyto", replyto));
    }
    if(headerfrom != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "headerfrom", headerfrom));
    }
    if(delivered != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "delivered", delivered));
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
    if(sort != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "sort", sort));
    }
    if(dir != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "dir", dir));
    }
    if(groupby != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "groupby", groupby));
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
