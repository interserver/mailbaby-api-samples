//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.18

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;


class HistoryApi {
  HistoryApi([ApiClient? apiClient]) : apiClient = apiClient ?? defaultApiClient;

  final ApiClient apiClient;

  /// Account usage, cost, and volume statistics for a time window
  ///
  /// **Use this for dashboards or billing-cycle reviews.** Returns aggregate sending statistics for your mail account(s). The `time` query param controls the window for `received`, `sent`, and `volume` (`1h`, `24h`, `7d`, `month`, `day`, `billing`, `all`). The `usage` and `cost` fields are always for the current billing cycle, regardless of `time`.  The response includes: - **`usage`** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **`cost`** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **`received`** / **`sent`** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected `time` window. - **`volume`** — top-500 breakdown of message counts grouped by source IP (`ip`),   destination address (`to`), and sender address (`from`) within the selected window.   **Time windows** (controlled by the `time` parameter): | Value | Window | |-------|--------| | `1h` | Last 1 hour (default) | | `24h` | Last 24 hours | | `7d` | Last 7 days | | `month` | Current calendar month (1st to now) | | `day` | Today (midnight to now) | | `billing` | Current billing cycle (last invoice date to next invoice date) | | `all` | All time | 
  ///
  /// Note: This method returns the HTTP [Response].
  ///
  /// Parameters:
  ///
  /// * [String] time:
  ///   The time window to scope `received`, `sent`, and `volume` statistics. Does not affect `usage` or `cost`, which are always calculated over the current billing cycle. Defaults to `1h`.
  Future<Response> getStatsWithHttpInfo({ String? time, }) async {
    // ignore: prefer_const_declarations
    final path = r'/mail/stats';

    // ignore: prefer_final_locals
    Object? postBody;

    final queryParams = <QueryParam>[];
    final headerParams = <String, String>{};
    final formParams = <String, String>{};

    if (time != null) {
      queryParams.addAll(_queryParams('', 'time', time));
    }

    const contentTypes = <String>[];


    return apiClient.invokeAPI(
      path,
      'GET',
      queryParams,
      postBody,
      headerParams,
      formParams,
      contentTypes.isEmpty ? null : contentTypes.first,
    );
  }

  /// Account usage, cost, and volume statistics for a time window
  ///
  /// **Use this for dashboards or billing-cycle reviews.** Returns aggregate sending statistics for your mail account(s). The `time` query param controls the window for `received`, `sent`, and `volume` (`1h`, `24h`, `7d`, `month`, `day`, `billing`, `all`). The `usage` and `cost` fields are always for the current billing cycle, regardless of `time`.  The response includes: - **`usage`** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **`cost`** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **`received`** / **`sent`** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected `time` window. - **`volume`** — top-500 breakdown of message counts grouped by source IP (`ip`),   destination address (`to`), and sender address (`from`) within the selected window.   **Time windows** (controlled by the `time` parameter): | Value | Window | |-------|--------| | `1h` | Last 1 hour (default) | | `24h` | Last 24 hours | | `7d` | Last 7 days | | `month` | Current calendar month (1st to now) | | `day` | Today (midnight to now) | | `billing` | Current billing cycle (last invoice date to next invoice date) | | `all` | All time | 
  ///
  /// Parameters:
  ///
  /// * [String] time:
  ///   The time window to scope `received`, `sent`, and `volume` statistics. Does not affect `usage` or `cost`, which are always calculated over the current billing cycle. Defaults to `1h`.
  Future<MailStatsType?> getStats({ String? time, }) async {
    final response = await getStatsWithHttpInfo( time: time, );
    if (response.statusCode >= HttpStatus.badRequest) {
      throw ApiException(response.statusCode, await _decodeBodyBytes(response));
    }
    // When a remote server returns no body with a status of 204, we shall not decode it.
    // At the time of writing this, `dart:convert` will throw an "Unexpected end of input"
    // FormatException when trying to decode an empty string.
    if (response.body.isNotEmpty && response.statusCode != HttpStatus.noContent) {
      return await apiClient.deserializeAsync(await _decodeBodyBytes(response), 'MailStatsType',) as MailStatsType;
    
    }
    return null;
  }

  /// Query the mail delivery log (filterable, paginated)
  ///
  /// **Use this to find or audit sent messages.** All filters are optional and combinable. The most useful filters: `mailid` (the transaction id returned by a send call), `from` / `to` (envelope addresses), `subject`, `messageId` (case-insensitive substring on the `Message-ID` header), `delivered` (`1`=delivered, `0`=queued/failed), and the `startDate`/`endDate` date range. Returns a paginated list of every email message accepted by the relay for your mail account(s).  **Row grouping** is controlled by the `groupby` parameter.  By default (`groupby=recipient`), the response contains one row per delivery attempt — so a single message sent to 4 recipients produces 4 rows, each with its own `recipient`, `delivered`, `response`, and `mxHostname` values.  Set `groupby=message` to collapse to one row per message (delivery fields will reflect one arbitrary recipient).  **Pagination** is controlled by `skip` and `limit`.  The `total` in the response reflects the row count **after** grouping, so it matches the number of pages you need to fetch.  **Date filtering** accepts either a Unix timestamp (integer) or a date string parseable by PHP `strtotime()` such as `2024-01-15`, `last monday`, or `2024-01-01 00:00:00`.  Examples: `startDate=1704067200&endDate=1706745599` or `startDate=2024-01-01&endDate=2024-01-31`.  **Sorting** is controlled by `sort` and `dir`.  Currently the only sort key is `time` (default), which orders by internal row ID.  **Delivery status** can be filtered with the `delivered` parameter: `delivered=1` returns only successfully delivered messages; `delivered=0` returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (`from`, `to`) and message headers (`headerfrom` for the `From:` header, `replyto` for `Reply-To:`). These may differ when a message is sent on behalf of another address.  The `mailid` parameter corresponds to the `id` field in the returned `MailLogEntry` objects, **not** the `_id` field.  It also matches the transaction ID returned in the `text` field of a successful send response from `/mail/send`, `/mail/advsend`, or `/mail/rawsend`.  The `messageId` parameter searches the `Message-ID` email header (case-insensitive substring match). 
  ///
  /// Note: This method returns the HTTP [Response].
  ///
  /// Parameters:
  ///
  /// * [int] id:
  ///   The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from `GET /mail` or `GET /mail/{id}`.
  ///
  /// * [String] origin:
  ///   Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address.
  ///
  /// * [String] mx:
  ///   Filter by the MX hostname the relay attempted delivery to.  For example `mx.google.com` would return messages destined for Gmail recipients. Maps to `mxHostname` in the `MailLogEntry` response.
  ///
  /// * [String] from:
  ///   Filter by SMTP envelope `MAIL FROM` address (exact match).  This is the address the relay used for bounce handling and may differ from the `From:` message header.  For header-level filtering use `headerfrom`.
  ///
  /// * [String] to:
  ///   Filter by SMTP envelope `RCPT TO` address (exact match).  This is the delivery address used by the relay and may differ from the `To:` header when BCC recipients are involved.
  ///
  /// * [String] subject:
  ///   Filter by email `Subject` header (exact match).  To search for a substring, include it in the full subject text.
  ///
  /// * [String] mailid:
  ///   Filter by the relay-assigned mail ID string (exact match).  This corresponds to the `id` field in `MailLogEntry` and to the `text` value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as `185997065c60008840`.
  ///
  /// * [String] messageId:
  ///   Filter by the `Message-ID` email header using a substring (case-insensitive) match. The `Message-ID` is assigned by the sending mail client and is visible in the `messageId` field of `MailLogEntry`.  Useful when you know the message ID generated by your application but not the relay `mailid`.
  ///
  /// * [String] replyto:
  ///   Filter by the `Reply-To` message header address (exact match).  Only returns messages where this header was explicitly set.
  ///
  /// * [String] headerfrom:
  ///   Filter by the `From` message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope `from` parameter when sending on behalf of another address.
  ///
  /// * [int] delivered:
  ///   Filter by delivery status.  `1` returns only messages that were successfully delivered to the destination MX.  `0` returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status.
  ///
  /// * [int] skip:
  ///   Number of records to skip for pagination.  Use in combination with `limit` to page through large result sets.  Defaults to `0` (no skip).
  ///
  /// * [int] limit:
  ///   Maximum number of records to return per page.  Defaults to `100`. Maximum allowed value is `10000`.  The response also includes a `total` field with the full matched count so you can calculate the number of pages.
  ///
  /// * [DateOrTimestamp] startDate:
  ///   Earliest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` such as `2024-01-15` or `last monday`.  Messages with a `time` value **greater than or equal to** this value will be included.
  ///
  /// * [DateOrTimestamp] endDate:
  ///   Latest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` such as `2024-01-31` or `yesterday`. Messages with a `time` value **less than or equal to** this value will be included.
  ///
  /// * [String] sort:
  ///   Field to sort results by.  Currently only `time` is supported (sorts by internal row ID which corresponds to chronological order).
  ///
  /// * [String] dir:
  ///   Sort direction.  `desc` returns newest first (default), `asc` returns oldest first.
  ///
  /// * [String] groupby:
  ///   Controls how results are grouped.  `recipient` (default) returns one row per delivery attempt — a message sent to 4 recipients produces 4 rows, each with its own `recipient`, `delivered`, `response`, and delivery metadata.  `message` collapses to one row per unique message ID; delivery-level fields will reflect one arbitrary recipient per message.  The `total` count in the response matches the grouping mode.
  Future<Response> viewMailLogWithHttpInfo({ int? id, String? origin, String? mx, String? from, String? to, String? subject, String? mailid, String? messageId, String? replyto, String? headerfrom, int? delivered, int? skip, int? limit, DateOrTimestamp? startDate, DateOrTimestamp? endDate, String? sort, String? dir, String? groupby, }) async {
    // ignore: prefer_const_declarations
    final path = r'/mail/log';

    // ignore: prefer_final_locals
    Object? postBody;

    final queryParams = <QueryParam>[];
    final headerParams = <String, String>{};
    final formParams = <String, String>{};

    if (id != null) {
      queryParams.addAll(_queryParams('', 'id', id));
    }
    if (origin != null) {
      queryParams.addAll(_queryParams('', 'origin', origin));
    }
    if (mx != null) {
      queryParams.addAll(_queryParams('', 'mx', mx));
    }
    if (from != null) {
      queryParams.addAll(_queryParams('', 'from', from));
    }
    if (to != null) {
      queryParams.addAll(_queryParams('', 'to', to));
    }
    if (subject != null) {
      queryParams.addAll(_queryParams('', 'subject', subject));
    }
    if (mailid != null) {
      queryParams.addAll(_queryParams('', 'mailid', mailid));
    }
    if (messageId != null) {
      queryParams.addAll(_queryParams('', 'messageId', messageId));
    }
    if (replyto != null) {
      queryParams.addAll(_queryParams('', 'replyto', replyto));
    }
    if (headerfrom != null) {
      queryParams.addAll(_queryParams('', 'headerfrom', headerfrom));
    }
    if (delivered != null) {
      queryParams.addAll(_queryParams('', 'delivered', delivered));
    }
    if (skip != null) {
      queryParams.addAll(_queryParams('', 'skip', skip));
    }
    if (limit != null) {
      queryParams.addAll(_queryParams('', 'limit', limit));
    }
    if (startDate != null) {
      queryParams.addAll(_queryParams('', 'startDate', startDate));
    }
    if (endDate != null) {
      queryParams.addAll(_queryParams('', 'endDate', endDate));
    }
    if (sort != null) {
      queryParams.addAll(_queryParams('', 'sort', sort));
    }
    if (dir != null) {
      queryParams.addAll(_queryParams('', 'dir', dir));
    }
    if (groupby != null) {
      queryParams.addAll(_queryParams('', 'groupby', groupby));
    }

    const contentTypes = <String>[];


    return apiClient.invokeAPI(
      path,
      'GET',
      queryParams,
      postBody,
      headerParams,
      formParams,
      contentTypes.isEmpty ? null : contentTypes.first,
    );
  }

  /// Query the mail delivery log (filterable, paginated)
  ///
  /// **Use this to find or audit sent messages.** All filters are optional and combinable. The most useful filters: `mailid` (the transaction id returned by a send call), `from` / `to` (envelope addresses), `subject`, `messageId` (case-insensitive substring on the `Message-ID` header), `delivered` (`1`=delivered, `0`=queued/failed), and the `startDate`/`endDate` date range. Returns a paginated list of every email message accepted by the relay for your mail account(s).  **Row grouping** is controlled by the `groupby` parameter.  By default (`groupby=recipient`), the response contains one row per delivery attempt — so a single message sent to 4 recipients produces 4 rows, each with its own `recipient`, `delivered`, `response`, and `mxHostname` values.  Set `groupby=message` to collapse to one row per message (delivery fields will reflect one arbitrary recipient).  **Pagination** is controlled by `skip` and `limit`.  The `total` in the response reflects the row count **after** grouping, so it matches the number of pages you need to fetch.  **Date filtering** accepts either a Unix timestamp (integer) or a date string parseable by PHP `strtotime()` such as `2024-01-15`, `last monday`, or `2024-01-01 00:00:00`.  Examples: `startDate=1704067200&endDate=1706745599` or `startDate=2024-01-01&endDate=2024-01-31`.  **Sorting** is controlled by `sort` and `dir`.  Currently the only sort key is `time` (default), which orders by internal row ID.  **Delivery status** can be filtered with the `delivered` parameter: `delivered=1` returns only successfully delivered messages; `delivered=0` returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (`from`, `to`) and message headers (`headerfrom` for the `From:` header, `replyto` for `Reply-To:`). These may differ when a message is sent on behalf of another address.  The `mailid` parameter corresponds to the `id` field in the returned `MailLogEntry` objects, **not** the `_id` field.  It also matches the transaction ID returned in the `text` field of a successful send response from `/mail/send`, `/mail/advsend`, or `/mail/rawsend`.  The `messageId` parameter searches the `Message-ID` email header (case-insensitive substring match). 
  ///
  /// Parameters:
  ///
  /// * [int] id:
  ///   The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from `GET /mail` or `GET /mail/{id}`.
  ///
  /// * [String] origin:
  ///   Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address.
  ///
  /// * [String] mx:
  ///   Filter by the MX hostname the relay attempted delivery to.  For example `mx.google.com` would return messages destined for Gmail recipients. Maps to `mxHostname` in the `MailLogEntry` response.
  ///
  /// * [String] from:
  ///   Filter by SMTP envelope `MAIL FROM` address (exact match).  This is the address the relay used for bounce handling and may differ from the `From:` message header.  For header-level filtering use `headerfrom`.
  ///
  /// * [String] to:
  ///   Filter by SMTP envelope `RCPT TO` address (exact match).  This is the delivery address used by the relay and may differ from the `To:` header when BCC recipients are involved.
  ///
  /// * [String] subject:
  ///   Filter by email `Subject` header (exact match).  To search for a substring, include it in the full subject text.
  ///
  /// * [String] mailid:
  ///   Filter by the relay-assigned mail ID string (exact match).  This corresponds to the `id` field in `MailLogEntry` and to the `text` value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as `185997065c60008840`.
  ///
  /// * [String] messageId:
  ///   Filter by the `Message-ID` email header using a substring (case-insensitive) match. The `Message-ID` is assigned by the sending mail client and is visible in the `messageId` field of `MailLogEntry`.  Useful when you know the message ID generated by your application but not the relay `mailid`.
  ///
  /// * [String] replyto:
  ///   Filter by the `Reply-To` message header address (exact match).  Only returns messages where this header was explicitly set.
  ///
  /// * [String] headerfrom:
  ///   Filter by the `From` message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope `from` parameter when sending on behalf of another address.
  ///
  /// * [int] delivered:
  ///   Filter by delivery status.  `1` returns only messages that were successfully delivered to the destination MX.  `0` returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status.
  ///
  /// * [int] skip:
  ///   Number of records to skip for pagination.  Use in combination with `limit` to page through large result sets.  Defaults to `0` (no skip).
  ///
  /// * [int] limit:
  ///   Maximum number of records to return per page.  Defaults to `100`. Maximum allowed value is `10000`.  The response also includes a `total` field with the full matched count so you can calculate the number of pages.
  ///
  /// * [DateOrTimestamp] startDate:
  ///   Earliest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` such as `2024-01-15` or `last monday`.  Messages with a `time` value **greater than or equal to** this value will be included.
  ///
  /// * [DateOrTimestamp] endDate:
  ///   Latest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` such as `2024-01-31` or `yesterday`. Messages with a `time` value **less than or equal to** this value will be included.
  ///
  /// * [String] sort:
  ///   Field to sort results by.  Currently only `time` is supported (sorts by internal row ID which corresponds to chronological order).
  ///
  /// * [String] dir:
  ///   Sort direction.  `desc` returns newest first (default), `asc` returns oldest first.
  ///
  /// * [String] groupby:
  ///   Controls how results are grouped.  `recipient` (default) returns one row per delivery attempt — a message sent to 4 recipients produces 4 rows, each with its own `recipient`, `delivered`, `response`, and delivery metadata.  `message` collapses to one row per unique message ID; delivery-level fields will reflect one arbitrary recipient per message.  The `total` count in the response matches the grouping mode.
  Future<MailLog?> viewMailLog({ int? id, String? origin, String? mx, String? from, String? to, String? subject, String? mailid, String? messageId, String? replyto, String? headerfrom, int? delivered, int? skip, int? limit, DateOrTimestamp? startDate, DateOrTimestamp? endDate, String? sort, String? dir, String? groupby, }) async {
    final response = await viewMailLogWithHttpInfo( id: id, origin: origin, mx: mx, from: from, to: to, subject: subject, mailid: mailid, messageId: messageId, replyto: replyto, headerfrom: headerfrom, delivered: delivered, skip: skip, limit: limit, startDate: startDate, endDate: endDate, sort: sort, dir: dir, groupby: groupby, );
    if (response.statusCode >= HttpStatus.badRequest) {
      throw ApiException(response.statusCode, await _decodeBodyBytes(response));
    }
    // When a remote server returns no body with a status of 204, we shall not decode it.
    // At the time of writing this, `dart:convert` will throw an "Unexpected end of input"
    // FormatException when trying to decode an empty string.
    if (response.body.isNotEmpty && response.statusCode != HttpStatus.noContent) {
      return await apiClient.deserializeAsync(await _decodeBodyBytes(response), 'MailLog',) as MailLog;
    
    }
    return null;
  }
}
