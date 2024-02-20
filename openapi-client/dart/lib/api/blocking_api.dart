//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.12

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;


class BlockingApi {
  BlockingApi([ApiClient? apiClient]) : apiClient = apiClient ?? defaultApiClient;

  final ApiClient apiClient;

  /// Creates a new email deny rule.
  ///
  /// Adds a new email deny rule into the system to block new emails that match the given criteria
  ///
  /// Note: This method returns the HTTP [Response].
  ///
  /// Parameters:
  ///
  /// * [String] type (required):
  ///   The type of deny rule.
  ///
  /// * [String] data (required):
  ///   The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
  ///
  /// * [String] user:
  ///   Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
  Future<Response> addRuleWithHttpInfo(String type, String data, { String? user, }) async {
    // ignore: prefer_const_declarations
    final path = r'/mail/rules';

    // ignore: prefer_final_locals
    Object? postBody;

    final queryParams = <QueryParam>[];
    final headerParams = <String, String>{};
    final formParams = <String, String>{};

    const contentTypes = <String>['application/x-www-form-urlencoded', 'application/json'];

    if (user != null) {
      formParams[r'user'] = parameterToString(user);
    }
    if (type != null) {
      formParams[r'type'] = parameterToString(type);
    }
    if (data != null) {
      formParams[r'data'] = parameterToString(data);
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

  /// Creates a new email deny rule.
  ///
  /// Adds a new email deny rule into the system to block new emails that match the given criteria
  ///
  /// Parameters:
  ///
  /// * [String] type (required):
  ///   The type of deny rule.
  ///
  /// * [String] data (required):
  ///   The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
  ///
  /// * [String] user:
  ///   Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
  Future<GenericResponse?> addRule(String type, String data, { String? user, }) async {
    final response = await addRuleWithHttpInfo(type, data,  user: user, );
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

  /// Removes an deny mail rule.
  ///
  /// Removes one of the configured deny mail rules from the system.
  ///
  /// Note: This method returns the HTTP [Response].
  ///
  /// Parameters:
  ///
  /// * [int] ruleId (required):
  ///   The ID of the Rules entry.
  Future<Response> deleteRuleWithHttpInfo(int ruleId,) async {
    // ignore: prefer_const_declarations
    final path = r'/mail/rules/{ruleId}'
      .replaceAll('{ruleId}', ruleId.toString());

    // ignore: prefer_final_locals
    Object? postBody;

    final queryParams = <QueryParam>[];
    final headerParams = <String, String>{};
    final formParams = <String, String>{};

    const contentTypes = <String>[];


    return apiClient.invokeAPI(
      path,
      'DELETE',
      queryParams,
      postBody,
      headerParams,
      formParams,
      contentTypes.isEmpty ? null : contentTypes.first,
    );
  }

  /// Removes an deny mail rule.
  ///
  /// Removes one of the configured deny mail rules from the system.
  ///
  /// Parameters:
  ///
  /// * [int] ruleId (required):
  ///   The ID of the Rules entry.
  Future<GenericResponse?> deleteRule(int ruleId,) async {
    final response = await deleteRuleWithHttpInfo(ruleId,);
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

  /// Removes an email address from the blocked list
  ///
  /// Removes an email address from the various block lists. 
  ///
  /// Note: This method returns the HTTP [Response].
  ///
  /// Parameters:
  ///
  /// * [String] body (required):
  Future<Response> delistBlockWithHttpInfo(String body,) async {
    // ignore: prefer_const_declarations
    final path = r'/mail/blocks/delete';

    // ignore: prefer_final_locals
    Object? postBody = body;

    final queryParams = <QueryParam>[];
    final headerParams = <String, String>{};
    final formParams = <String, String>{};

    const contentTypes = <String>['application/json', 'multipart/form-data'];


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

  /// Removes an email address from the blocked list
  ///
  /// Removes an email address from the various block lists. 
  ///
  /// Parameters:
  ///
  /// * [String] body (required):
  Future<GenericResponse?> delistBlock(String body,) async {
    final response = await delistBlockWithHttpInfo(body,);
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

  /// displays a list of blocked email addresses
  ///
  /// Note: This method returns the HTTP [Response].
  Future<Response> getMailBlocksWithHttpInfo() async {
    // ignore: prefer_const_declarations
    final path = r'/mail/blocks';

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

  /// displays a list of blocked email addresses
  Future<MailBlocks?> getMailBlocks() async {
    final response = await getMailBlocksWithHttpInfo();
    if (response.statusCode >= HttpStatus.badRequest) {
      throw ApiException(response.statusCode, await _decodeBodyBytes(response));
    }
    // When a remote server returns no body with a status of 204, we shall not decode it.
    // At the time of writing this, `dart:convert` will throw an "Unexpected end of input"
    // FormatException when trying to decode an empty string.
    if (response.body.isNotEmpty && response.statusCode != HttpStatus.noContent) {
      return await apiClient.deserializeAsync(await _decodeBodyBytes(response), 'MailBlocks',) as MailBlocks;
    
    }
    return null;
  }

  /// Displays a listing of deny email rules.
  ///
  /// Returns a listing of all the deny block rules you have configured.
  ///
  /// Note: This method returns the HTTP [Response].
  Future<Response> getRulesWithHttpInfo() async {
    // ignore: prefer_const_declarations
    final path = r'/mail/rules';

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

  /// Displays a listing of deny email rules.
  ///
  /// Returns a listing of all the deny block rules you have configured.
  Future<List<DenyRuleRecord>?> getRules() async {
    final response = await getRulesWithHttpInfo();
    if (response.statusCode >= HttpStatus.badRequest) {
      throw ApiException(response.statusCode, await _decodeBodyBytes(response));
    }
    // When a remote server returns no body with a status of 204, we shall not decode it.
    // At the time of writing this, `dart:convert` will throw an "Unexpected end of input"
    // FormatException when trying to decode an empty string.
    if (response.body.isNotEmpty && response.statusCode != HttpStatus.noContent) {
      final responseBody = await _decodeBodyBytes(response);
      return (await apiClient.deserializeAsync(responseBody, 'List<DenyRuleRecord>') as List)
        .cast<DenyRuleRecord>()
        .toList(growable: false);

    }
    return null;
  }
}
