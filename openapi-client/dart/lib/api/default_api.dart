//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.0

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;


class DefaultApi {
  DefaultApi([ApiClient apiClient]) : apiClient = apiClient ?? defaultApiClient;

  final ApiClient apiClient;

  /// displays a list of mail service orders
  ///
  /// Note: This method returns the HTTP [Response].
  ///
  /// Parameters:
  ///
  /// * [int] id:
  ///   The ID of your mail order this will be sent through.
  Future<Response> getMailOrdersWithHttpInfo({ int id }) async {
    // Verify required params are set.

    final path = r'/mail';

    Object postBody;

    final queryParams = <QueryParam>[];
    final headerParams = <String, String>{};
    final formParams = <String, String>{};

    if (id != null) {
      queryParams.addAll(_convertParametersForCollectionFormat('', 'id', id));
    }

    final contentTypes = <String>[];
    final nullableContentType = contentTypes.isNotEmpty ? contentTypes[0] : null;
    final authNames = <String>['apiKeyAuth'];

    if (
      nullableContentType != null &&
      nullableContentType.toLowerCase().startsWith('multipart/form-data')
    ) {
      bool hasFields = false;
      final mp = MultipartRequest(null, null);
      if (hasFields) {
        postBody = mp;
      }
    } else {
    }

    return await apiClient.invokeAPI(
      path,
      'GET',
      queryParams,
      postBody,
      headerParams,
      formParams,
      nullableContentType,
      authNames,
    );
  }

  /// displays a list of mail service orders
  ///
  /// Parameters:
  ///
  /// * [int] id:
  ///   The ID of your mail order this will be sent through.
  Future<List<MailOrder>> getMailOrders({ int id }) async {
    final response = await getMailOrdersWithHttpInfo( id: id );
    if (response.statusCode >= HttpStatus.badRequest) {
      throw ApiException(response.statusCode, _decodeBodyBytes(response));
    }
    // When a remote server returns no body with a status of 204, we shall not decode it.
    // At the time of writing this, `dart:convert` will throw an "Unexpected end of input"
    // FormatException when trying to decode an empty string.
    if (response.body != null && response.statusCode != HttpStatus.noContent) {
      return (apiClient.deserialize(_decodeBodyBytes(response), 'List<MailOrder>') as List)
        .cast<MailOrder>()
        .toList(growable: false);
    }
    return Future<List<MailOrder>>.value(null);
  }

  /// Checks if the server is running
  ///
  /// Note: This method returns the HTTP [Response].
  Future<Response> pingServerWithHttpInfo() async {
    final path = r'/ping';

    Object postBody;

    final queryParams = <QueryParam>[];
    final headerParams = <String, String>{};
    final formParams = <String, String>{};

    final contentTypes = <String>[];
    final nullableContentType = contentTypes.isNotEmpty ? contentTypes[0] : null;
    final authNames = <String>[];

    if (
      nullableContentType != null &&
      nullableContentType.toLowerCase().startsWith('multipart/form-data')
    ) {
      bool hasFields = false;
      final mp = MultipartRequest(null, null);
      if (hasFields) {
        postBody = mp;
      }
    } else {
    }

    return await apiClient.invokeAPI(
      path,
      'GET',
      queryParams,
      postBody,
      headerParams,
      formParams,
      nullableContentType,
      authNames,
    );
  }

  /// Checks if the server is running
  Future<void> pingServer() async {
    final response = await pingServerWithHttpInfo();
    if (response.statusCode >= HttpStatus.badRequest) {
      throw ApiException(response.statusCode, _decodeBodyBytes(response));
    }
  }

  /// places a mail order
  ///
  /// Adds an item to the system
  ///
  /// Note: This method returns the HTTP [Response].
  ///
  /// Parameters:
  ///
  /// * [MailOrder] mailOrder:
  ///   Inventory item to add
  Future<Response> placeMailOrderWithHttpInfo({ MailOrder mailOrder }) async {
    // Verify required params are set.

    final path = r'/mail/order';

    Object postBody = mailOrder;

    final queryParams = <QueryParam>[];
    final headerParams = <String, String>{};
    final formParams = <String, String>{};

    final contentTypes = <String>['application/json'];
    final nullableContentType = contentTypes.isNotEmpty ? contentTypes[0] : null;
    final authNames = <String>['apiKeyAuth'];

    if (
      nullableContentType != null &&
      nullableContentType.toLowerCase().startsWith('multipart/form-data')
    ) {
      bool hasFields = false;
      final mp = MultipartRequest(null, null);
      if (hasFields) {
        postBody = mp;
      }
    } else {
    }

    return await apiClient.invokeAPI(
      path,
      'POST',
      queryParams,
      postBody,
      headerParams,
      formParams,
      nullableContentType,
      authNames,
    );
  }

  /// places a mail order
  ///
  /// Adds an item to the system
  ///
  /// Parameters:
  ///
  /// * [MailOrder] mailOrder:
  ///   Inventory item to add
  Future<void> placeMailOrder({ MailOrder mailOrder }) async {
    final response = await placeMailOrderWithHttpInfo( mailOrder: mailOrder );
    if (response.statusCode >= HttpStatus.badRequest) {
      throw ApiException(response.statusCode, _decodeBodyBytes(response));
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
  /// * [SendMail] sendMail (required):
  Future<Response> sendAdvMailByIdWithHttpInfo(SendMail sendMail) async {
    // Verify required params are set.
    if (sendMail == null) {
     throw ApiException(HttpStatus.badRequest, 'Missing required param: sendMail');
    }

    final path = r'/mail/advsend';

    Object postBody = sendMail;

    final queryParams = <QueryParam>[];
    final headerParams = <String, String>{};
    final formParams = <String, String>{};

    final contentTypes = <String>['application/json'];
    final nullableContentType = contentTypes.isNotEmpty ? contentTypes[0] : null;
    final authNames = <String>['apiKeyAuth'];

    if (
      nullableContentType != null &&
      nullableContentType.toLowerCase().startsWith('multipart/form-data')
    ) {
      bool hasFields = false;
      final mp = MultipartRequest(null, null);
      if (hasFields) {
        postBody = mp;
      }
    } else {
    }

    return await apiClient.invokeAPI(
      path,
      'POST',
      queryParams,
      postBody,
      headerParams,
      formParams,
      nullableContentType,
      authNames,
    );
  }

  /// Sends an Email with Advanced Options
  ///
  /// Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
  ///
  /// Parameters:
  ///
  /// * [SendMail] sendMail (required):
  Future<GenericResponse> sendAdvMailById(SendMail sendMail) async {
    final response = await sendAdvMailByIdWithHttpInfo(sendMail);
    if (response.statusCode >= HttpStatus.badRequest) {
      throw ApiException(response.statusCode, _decodeBodyBytes(response));
    }
    // When a remote server returns no body with a status of 204, we shall not decode it.
    // At the time of writing this, `dart:convert` will throw an "Unexpected end of input"
    // FormatException when trying to decode an empty string.
    if (response.body != null && response.statusCode != HttpStatus.noContent) {
      return apiClient.deserialize(_decodeBodyBytes(response), 'GenericResponse') as GenericResponse;
        }
    return Future<GenericResponse>.value(null);
  }

  /// Sends an Email
  ///
  /// Sends An email through one of your mail orders.
  ///
  /// Note: This method returns the HTTP [Response].
  ///
  /// Parameters:
  ///
  /// * [String] subject:
  ///   The Subject of the email
  ///
  /// * [String] body:
  ///   The contents of the email
  ///
  /// * [String] to:
  ///   The email address of who this email will be sent to.
  ///
  /// * [String] from:
  ///   The email address of who this email will be sent from.
  ///
  /// * [int] id:
  ///   The ID of your mail order this will be sent through.
  ///
  /// * [String] toName:
  ///   The name or title of who this email is being sent to.
  ///
  /// * [String] fromName:
  ///   The name or title of who this email is being sent from.
  Future<Response> sendMailByIdWithHttpInfo({ String subject, String body, String to, String from, int id, String toName, String fromName }) async {
    // Verify required params are set.

    final path = r'/mail/send';

    Object postBody;

    final queryParams = <QueryParam>[];
    final headerParams = <String, String>{};
    final formParams = <String, String>{};

    if (subject != null) {
      queryParams.addAll(_convertParametersForCollectionFormat('', 'subject', subject));
    }
    if (body != null) {
      queryParams.addAll(_convertParametersForCollectionFormat('', 'body', body));
    }
    if (to != null) {
      queryParams.addAll(_convertParametersForCollectionFormat('', 'to', to));
    }
    if (from != null) {
      queryParams.addAll(_convertParametersForCollectionFormat('', 'from', from));
    }
    if (id != null) {
      queryParams.addAll(_convertParametersForCollectionFormat('', 'id', id));
    }
    if (toName != null) {
      queryParams.addAll(_convertParametersForCollectionFormat('', 'toName', toName));
    }
    if (fromName != null) {
      queryParams.addAll(_convertParametersForCollectionFormat('', 'fromName', fromName));
    }

    final contentTypes = <String>[];
    final nullableContentType = contentTypes.isNotEmpty ? contentTypes[0] : null;
    final authNames = <String>['apiKeyAuth'];

    if (
      nullableContentType != null &&
      nullableContentType.toLowerCase().startsWith('multipart/form-data')
    ) {
      bool hasFields = false;
      final mp = MultipartRequest(null, null);
      if (hasFields) {
        postBody = mp;
      }
    } else {
    }

    return await apiClient.invokeAPI(
      path,
      'POST',
      queryParams,
      postBody,
      headerParams,
      formParams,
      nullableContentType,
      authNames,
    );
  }

  /// Sends an Email
  ///
  /// Sends An email through one of your mail orders.
  ///
  /// Parameters:
  ///
  /// * [String] subject:
  ///   The Subject of the email
  ///
  /// * [String] body:
  ///   The contents of the email
  ///
  /// * [String] to:
  ///   The email address of who this email will be sent to.
  ///
  /// * [String] from:
  ///   The email address of who this email will be sent from.
  ///
  /// * [int] id:
  ///   The ID of your mail order this will be sent through.
  ///
  /// * [String] toName:
  ///   The name or title of who this email is being sent to.
  ///
  /// * [String] fromName:
  ///   The name or title of who this email is being sent from.
  Future<GenericResponse> sendMailById({ String subject, String body, String to, String from, int id, String toName, String fromName }) async {
    final response = await sendMailByIdWithHttpInfo( subject: subject, body: body, to: to, from: from, id: id, toName: toName, fromName: fromName );
    if (response.statusCode >= HttpStatus.badRequest) {
      throw ApiException(response.statusCode, _decodeBodyBytes(response));
    }
    // When a remote server returns no body with a status of 204, we shall not decode it.
    // At the time of writing this, `dart:convert` will throw an "Unexpected end of input"
    // FormatException when trying to decode an empty string.
    if (response.body != null && response.statusCode != HttpStatus.noContent) {
      return apiClient.deserialize(_decodeBodyBytes(response), 'GenericResponse') as GenericResponse;
        }
    return Future<GenericResponse>.value(null);
  }

  /// validatess order details before placing an order
  ///
  /// Note: This method returns the HTTP [Response].
  Future<Response> validateMailOrderWithHttpInfo() async {
    final path = r'/mail/order';

    Object postBody;

    final queryParams = <QueryParam>[];
    final headerParams = <String, String>{};
    final formParams = <String, String>{};

    final contentTypes = <String>[];
    final nullableContentType = contentTypes.isNotEmpty ? contentTypes[0] : null;
    final authNames = <String>['apiKeyAuth'];

    if (
      nullableContentType != null &&
      nullableContentType.toLowerCase().startsWith('multipart/form-data')
    ) {
      bool hasFields = false;
      final mp = MultipartRequest(null, null);
      if (hasFields) {
        postBody = mp;
      }
    } else {
    }

    return await apiClient.invokeAPI(
      path,
      'GET',
      queryParams,
      postBody,
      headerParams,
      formParams,
      nullableContentType,
      authNames,
    );
  }

  /// validatess order details before placing an order
  Future<void> validateMailOrder() async {
    final response = await validateMailOrderWithHttpInfo();
    if (response.statusCode >= HttpStatus.badRequest) {
      throw ApiException(response.statusCode, _decodeBodyBytes(response));
    }
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
  /// * [String] searchString:
  ///   pass an optional search string for looking up inventory
  ///
  /// * [int] skip:
  ///   number of records to skip for pagination
  ///
  /// * [int] limit:
  ///   maximum number of records to return
  Future<Response> viewMailLogByIdWithHttpInfo({ int id, String searchString, int skip, int limit }) async {
    // Verify required params are set.

    final path = r'/mail/log';

    Object postBody;

    final queryParams = <QueryParam>[];
    final headerParams = <String, String>{};
    final formParams = <String, String>{};

    if (id != null) {
      queryParams.addAll(_convertParametersForCollectionFormat('', 'id', id));
    }
    if (searchString != null) {
      queryParams.addAll(_convertParametersForCollectionFormat('', 'searchString', searchString));
    }
    if (skip != null) {
      queryParams.addAll(_convertParametersForCollectionFormat('', 'skip', skip));
    }
    if (limit != null) {
      queryParams.addAll(_convertParametersForCollectionFormat('', 'limit', limit));
    }

    final contentTypes = <String>[];
    final nullableContentType = contentTypes.isNotEmpty ? contentTypes[0] : null;
    final authNames = <String>['apiKeyAuth'];

    if (
      nullableContentType != null &&
      nullableContentType.toLowerCase().startsWith('multipart/form-data')
    ) {
      bool hasFields = false;
      final mp = MultipartRequest(null, null);
      if (hasFields) {
        postBody = mp;
      }
    } else {
    }

    return await apiClient.invokeAPI(
      path,
      'GET',
      queryParams,
      postBody,
      headerParams,
      formParams,
      nullableContentType,
      authNames,
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
  /// * [String] searchString:
  ///   pass an optional search string for looking up inventory
  ///
  /// * [int] skip:
  ///   number of records to skip for pagination
  ///
  /// * [int] limit:
  ///   maximum number of records to return
  Future<List<MailLog>> viewMailLogById({ int id, String searchString, int skip, int limit }) async {
    final response = await viewMailLogByIdWithHttpInfo( id: id, searchString: searchString, skip: skip, limit: limit );
    if (response.statusCode >= HttpStatus.badRequest) {
      throw ApiException(response.statusCode, _decodeBodyBytes(response));
    }
    // When a remote server returns no body with a status of 204, we shall not decode it.
    // At the time of writing this, `dart:convert` will throw an "Unexpected end of input"
    // FormatException when trying to decode an empty string.
    if (response.body != null && response.statusCode != HttpStatus.noContent) {
      return (apiClient.deserialize(_decodeBodyBytes(response), 'List<MailLog>') as List)
        .cast<MailLog>()
        .toList(growable: false);
    }
    return Future<List<MailLog>>.value(null);
  }
}
