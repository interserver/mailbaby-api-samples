//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.12

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;


class ServicesApi {
  ServicesApi([ApiClient? apiClient]) : apiClient = apiClient ?? defaultApiClient;

  final ApiClient apiClient;

  /// displays a list of mail service orders
  ///
  /// This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
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
  ///
  /// This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
  Future<List<MailOrder>?> getMailOrders() async {
    final response = await getMailOrdersWithHttpInfo();
    if (response.statusCode >= HttpStatus.badRequest) {
      throw ApiException(response.statusCode, await _decodeBodyBytes(response));
    }
    // When a remote server returns no body with a status of 204, we shall not decode it.
    // At the time of writing this, `dart:convert` will throw an "Unexpected end of input"
    // FormatException when trying to decode an empty string.
    if (response.body.isNotEmpty && response.statusCode != HttpStatus.noContent) {
      final responseBody = await _decodeBodyBytes(response);
      return (await apiClient.deserializeAsync(responseBody, 'List<MailOrder>') as List)
        .cast<MailOrder>()
        .toList();

    }
    return null;
  }
}
