//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.12

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;


class DefaultApi {
  DefaultApi([ApiClient? apiClient]) : apiClient = apiClient ?? defaultApiClient;

  final ApiClient apiClient;

  /// displays a list of mail service orders
  ///
  /// Note: This method returns the HTTP [Response].
  Future<Response> getMailOrdersWithHttpInfo() async {
    // ignore: prefer_const_declarations
    final path = r'/mail';

    // ignore: prefer_final_locals
    Object? postBody;

    final queryParams = <QueryParam>[];
    final headerParams = <String, String>{};
    final formParams = <String, String>{};

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

  /// displays a list of mail service orders
  Future<List<GetMailOrders200ResponseInner>?> getMailOrders() async {
    final response = await getMailOrdersWithHttpInfo();
    if (response.statusCode >= HttpStatus.badRequest) {
      throw ApiException(response.statusCode, await _decodeBodyBytes(response));
    }
    // When a remote server returns no body with a status of 204, we shall not decode it.
    // At the time of writing this, `dart:convert` will throw an "Unexpected end of input"
    // FormatException when trying to decode an empty string.
    if (response.body.isNotEmpty && response.statusCode != HttpStatus.noContent) {
      final responseBody = await _decodeBodyBytes(response);
      return (await apiClient.deserializeAsync(responseBody, 'List<GetMailOrders200ResponseInner>') as List)
        .cast<GetMailOrders200ResponseInner>()
        .toList();

    }
    return null;
  }

  /// Checks if the server is running
  ///
  /// Note: This method returns the HTTP [Response].
  Future<Response> pingServerWithHttpInfo() async {
    // ignore: prefer_const_declarations
    final path = r'/ping';

    // ignore: prefer_final_locals
    Object? postBody;

    final queryParams = <QueryParam>[];
    final headerParams = <String, String>{};
    final formParams = <String, String>{};

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

  /// Checks if the server is running
  Future<void> pingServer() async {
    final response = await pingServerWithHttpInfo();
    if (response.statusCode >= HttpStatus.badRequest) {
      throw ApiException(response.statusCode, await _decodeBodyBytes(response));
    }
  }

  /// Sends an Email with Advanced Options
  ///
  /// Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
  ///
  /// Note: This method returns the HTTP [Response].
  ///
  /// Parameters:
  ///
  /// * [SendMailAdv] sendMailAdv (required):
  Future<Response> sendAdvMailWithHttpInfo(SendMailAdv sendMailAdv,) async {
    // ignore: prefer_const_declarations
    final path = r'/mail/advsend';

    // ignore: prefer_final_locals
    Object? postBody = sendMailAdv;

    final queryParams = <QueryParam>[];
    final headerParams = <String, String>{};
    final formParams = <String, String>{};

    const contentTypes = <String>['application/json', 'application/x-www-form-urlencoded'];


    return apiClient.invokeAPI(
      path,
      'POST',
      queryParams,
      postBody,
      headerParams,
      formParams,
      contentTypes.isEmpty ? null : contentTypes.first,
    );
  }

  /// Sends an Email with Advanced Options
  ///
  /// Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
  ///
  /// Parameters:
  ///
  /// * [SendMailAdv] sendMailAdv (required):
  Future<GenericResponse?> sendAdvMail(SendMailAdv sendMailAdv,) async {
    final response = await sendAdvMailWithHttpInfo(sendMailAdv,);
    if (response.statusCode >= HttpStatus.badRequest) {
      throw ApiException(response.statusCode, await _decodeBodyBytes(response));
    }
    // When a remote server returns no body with a status of 204, we shall not decode it.
    // At the time of writing this, `dart:convert` will throw an "Unexpected end of input"
    // FormatException when trying to decode an empty string.
    if (response.body.isNotEmpty && response.statusCode != HttpStatus.noContent) {
      return await apiClient.deserializeAsync(await _decodeBodyBytes(response), 'GenericResponse',) as GenericResponse;
    
    }
    return null;
  }

  /// Sends an Email
  ///
  /// Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
  ///
  /// Note: This method returns the HTTP [Response].
  ///
  /// Parameters:
  ///
  /// * [String] to (required):
  ///   The Contact whom is the primary recipient of this email.
  ///
  /// * [String] from (required):
  ///   The contact whom is the this email is from.
  ///
  /// * [String] subject (required):
  ///   The subject or title of the email
  ///
  /// * [String] body (required):
  ///   The main email contents.
  Future<Response> sendMailWithHttpInfo(String to, String from, String subject, String body,) async {
    // ignore: prefer_const_declarations
    final path = r'/mail/send';

    // ignore: prefer_final_locals
    Object? postBody;

    final queryParams = <QueryParam>[];
    final headerParams = <String, String>{};
    final formParams = <String, String>{};

    const contentTypes = <String>['application/x-www-form-urlencoded', 'application/json'];

    if (to != null) {
      formParams[r'to'] = parameterToString(to);
    }
    if (from != null) {
      formParams[r'from'] = parameterToString(from);
    }
    if (subject != null) {
      formParams[r'subject'] = parameterToString(subject);
    }
    if (body != null) {
      formParams[r'body'] = parameterToString(body);
    }

    return apiClient.invokeAPI(
      path,
      'POST',
      queryParams,
      postBody,
      headerParams,
      formParams,
      contentTypes.isEmpty ? null : contentTypes.first,
    );
  }

  /// Sends an Email
  ///
  /// Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
  ///
  /// Parameters:
  ///
  /// * [String] to (required):
  ///   The Contact whom is the primary recipient of this email.
  ///
  /// * [String] from (required):
  ///   The contact whom is the this email is from.
  ///
  /// * [String] subject (required):
  ///   The subject or title of the email
  ///
  /// * [String] body (required):
  ///   The main email contents.
  Future<GenericResponse?> sendMail(String to, String from, String subject, String body,) async {
    final response = await sendMailWithHttpInfo(to, from, subject, body,);
    if (response.statusCode >= HttpStatus.badRequest) {
      throw ApiException(response.statusCode, await _decodeBodyBytes(response));
    }
    // When a remote server returns no body with a status of 204, we shall not decode it.
    // At the time of writing this, `dart:convert` will throw an "Unexpected end of input"
    // FormatException when trying to decode an empty string.
    if (response.body.isNotEmpty && response.statusCode != HttpStatus.noContent) {
      return await apiClient.deserializeAsync(await _decodeBodyBytes(response), 'GenericResponse',) as GenericResponse;
    
    }
    return null;
  }

  /// displays the mail log
  ///
  /// By passing in the appropriate options, you can search for available inventory in the system 
  ///
  /// Note: This method returns the HTTP [Response].
  ///
  /// Parameters:
  ///
  /// * [int] id:
  ///   The ID of your mail order this will be sent through.
  ///
  /// * [String] search:
  ///   pass an optional search string for looking up inventory
  ///
  /// * [int] skip:
  ///   number of records to skip for pagination
  ///
  /// * [int] limit:
  ///   maximum number of records to return
  Future<Response> viewMailLogWithHttpInfo({ int? id, String? search, int? skip, int? limit, }) async {
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
    if (search != null) {
      queryParams.addAll(_queryParams('', 'search', search));
    }
    if (skip != null) {
      queryParams.addAll(_queryParams('', 'skip', skip));
    }
    if (limit != null) {
      queryParams.addAll(_queryParams('', 'limit', limit));
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
  /// By passing in the appropriate options, you can search for available inventory in the system 
  ///
  /// Parameters:
  ///
  /// * [int] id:
  ///   The ID of your mail order this will be sent through.
  ///
  /// * [String] search:
  ///   pass an optional search string for looking up inventory
  ///
  /// * [int] skip:
  ///   number of records to skip for pagination
  ///
  /// * [int] limit:
  ///   maximum number of records to return
  Future<MailLog?> viewMailLog({ int? id, String? search, int? skip, int? limit, }) async {
    final response = await viewMailLogWithHttpInfo( id: id, search: search, skip: skip, limit: limit, );
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
