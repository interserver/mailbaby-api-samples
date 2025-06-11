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

  /// Account usage statistics.
  ///
  /// Returns information about the usage on your mail accounts.
  ///
  /// Note: This method returns the HTTP [Response].
  ///
  /// Parameters:
  ///
  /// * [String] time:
  ///   The timeframe for the statistics.
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

  /// Account usage statistics.
  ///
  /// Returns information about the usage on your mail accounts.
  ///
  /// Parameters:
  ///
  /// * [String] time:
  ///   The timeframe for the statistics.
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

  /// displays the mail log
  ///
  /// Get a listing of the emails sent through this system 
  ///
  /// Note: This method returns the HTTP [Response].
  ///
  /// Parameters:
  ///
  /// * [int] id:
  ///   The ID of your mail order this will be sent through.
  ///
  /// * [String] origin:
  ///   originating ip address sending mail
  ///
  /// * [String] mx:
  ///   mx record mail was sent to
  ///
  /// * [String] from:
  ///   from email address
  ///
  /// * [String] to:
  ///   to/destination email address
  ///
  /// * [String] subject:
  ///   subject containing this string
  ///
  /// * [String] mailid:
  ///   mail id
  ///
  /// * [int] skip:
  ///   number of records to skip for pagination
  ///
  /// * [int] limit:
  ///   maximum number of records to return
  ///
  /// * [int] startDate:
  ///   earliest date to get emails in unix timestamp format
  ///
  /// * [int] endDate:
  ///   earliest date to get emails in unix timestamp format
  ///
  /// * [String] replyto:
  ///   Reply-To Email Address
  ///
  /// * [String] headerfrom:
  ///   Header From Email Address
  ///
  /// * [String] delivered:
  ///   Limiting the emails to wether or not they were delivered.
  Future<Response> viewMailLogWithHttpInfo({ int? id, String? origin, String? mx, String? from, String? to, String? subject, String? mailid, int? skip, int? limit, int? startDate, int? endDate, String? replyto, String? headerfrom, String? delivered, }) async {
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
    if (replyto != null) {
      queryParams.addAll(_queryParams('', 'replyto', replyto));
    }
    if (headerfrom != null) {
      queryParams.addAll(_queryParams('', 'headerfrom', headerfrom));
    }
    if (delivered != null) {
      queryParams.addAll(_queryParams('', 'delivered', delivered));
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

  /// displays the mail log
  ///
  /// Get a listing of the emails sent through this system 
  ///
  /// Parameters:
  ///
  /// * [int] id:
  ///   The ID of your mail order this will be sent through.
  ///
  /// * [String] origin:
  ///   originating ip address sending mail
  ///
  /// * [String] mx:
  ///   mx record mail was sent to
  ///
  /// * [String] from:
  ///   from email address
  ///
  /// * [String] to:
  ///   to/destination email address
  ///
  /// * [String] subject:
  ///   subject containing this string
  ///
  /// * [String] mailid:
  ///   mail id
  ///
  /// * [int] skip:
  ///   number of records to skip for pagination
  ///
  /// * [int] limit:
  ///   maximum number of records to return
  ///
  /// * [int] startDate:
  ///   earliest date to get emails in unix timestamp format
  ///
  /// * [int] endDate:
  ///   earliest date to get emails in unix timestamp format
  ///
  /// * [String] replyto:
  ///   Reply-To Email Address
  ///
  /// * [String] headerfrom:
  ///   Header From Email Address
  ///
  /// * [String] delivered:
  ///   Limiting the emails to wether or not they were delivered.
  Future<MailLog?> viewMailLog({ int? id, String? origin, String? mx, String? from, String? to, String? subject, String? mailid, int? skip, int? limit, int? startDate, int? endDate, String? replyto, String? headerfrom, String? delivered, }) async {
    final response = await viewMailLogWithHttpInfo( id: id, origin: origin, mx: mx, from: from, to: to, subject: subject, mailid: mailid, skip: skip, limit: limit, startDate: startDate, endDate: endDate, replyto: replyto, headerfrom: headerfrom, delivered: delivered, );
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
