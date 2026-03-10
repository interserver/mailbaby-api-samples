//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'dart:async';

import 'package:built_value/json_object.dart';
import 'package:built_value/serializer.dart';
import 'package:dio/dio.dart';

import 'package:built_collection/built_collection.dart';
import 'package:openapi/src/api_util.dart';
import 'package:openapi/src/model/deny_rule_record.dart';
import 'package:openapi/src/model/email_address_param.dart';
import 'package:openapi/src/model/error_message.dart';
import 'package:openapi/src/model/generic_response.dart';
import 'package:openapi/src/model/mail_blocks.dart';

class BlockingApi {

  final Dio _dio;

  final Serializers _serializers;

  const BlockingApi(this._dio, this._serializers);

  /// Creates a new email deny rule
  /// Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The &#x60;type&#x60; field selects the matching strategy: - **&#x60;email&#x60;** — exact match against the SMTP envelope &#x60;MAIL FROM&#x60; address. - **&#x60;domain&#x60;** — matches any sender address at the specified domain. - **&#x60;destination&#x60;** — exact match against the SMTP envelope &#x60;RCPT TO&#x60; address. - **&#x60;startswith&#x60;** — matches any sender address whose local-part (the portion   before the &#x60;@&#x60;) starts with the given string.  Only alphanumeric characters   and &#x60;+&#x60;, &#x60;_&#x60;, &#x60;.&#x60;, &#x60;-&#x60; are permitted in the prefix.   If &#x60;username&#x60; is provided it must be the SMTP username of one of your active mail orders (e.g. &#x60;mb20682&#x60;).  If omitted the rule is associated with your first active order.  On success the response &#x60;text&#x60; field contains the newly created rule&#39;s &#x60;id&#x60;, which can later be passed to &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove it. 
  ///
  /// Parameters:
  /// * [type] - The type of deny rule.
  /// * [data] - The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
  /// * [user] - Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [GenericResponse] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<GenericResponse>> addRule({ 
    required String type,
    required String data,
    String? user,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/mail/rules';
    final _options = Options(
      method: r'POST',
      headers: <String, dynamic>{
        ...?headers,
      },
      extra: <String, dynamic>{
        'secure': <Map<String, String>>[
          {
            'type': 'apiKey',
            'name': 'apiKeyAuth',
            'keyName': 'X-API-KEY',
            'where': 'header',
          },
        ],
        ...?extra,
      },
      contentType: 'application/x-www-form-urlencoded',
      validateStatus: validateStatus,
    );

    dynamic _bodyData;

    try {
      _bodyData = <String, dynamic>{
        if (user != null) r'user': encodeQueryParameter(_serializers, user, const FullType(String)),
        r'type': encodeQueryParameter(_serializers, type, const FullType(String)),
        r'data': encodeQueryParameter(_serializers, data, const FullType(String)),
      };

    } catch(error, stackTrace) {
      throw DioException(
         requestOptions: _options.compose(
          _dio.options,
          _path,
        ),
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    final _response = await _dio.request<Object>(
      _path,
      data: _bodyData,
      options: _options,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    GenericResponse? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(GenericResponse),
      ) as GenericResponse;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<GenericResponse>(
      data: _responseData,
      headers: _response.headers,
      isRedirect: _response.isRedirect,
      requestOptions: _response.requestOptions,
      redirects: _response.redirects,
      statusCode: _response.statusCode,
      statusMessage: _response.statusMessage,
      extra: _response.extra,
    );
  }

  /// Removes a deny mail rule
  /// Permanently removes a single deny rule identified by its numeric &#x60;ruleId&#x60;.  The &#x60;ruleId&#x60; is the &#x60;id&#x60; field returned by &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field from a successful &#x60;POST /mail/rules&#x60; response.  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account. 
  ///
  /// Parameters:
  /// * [ruleId] - The numeric ID of the deny rule to delete.  Obtain this from the `id` field in `GET /mail/rules` or the `text` field of a `POST /mail/rules` response.
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [GenericResponse] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<GenericResponse>> deleteRule({ 
    required int ruleId,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/mail/rules/{ruleId}'.replaceAll('{' r'ruleId' '}', encodeQueryParameter(_serializers, ruleId, const FullType(int)).toString());
    final _options = Options(
      method: r'DELETE',
      headers: <String, dynamic>{
        ...?headers,
      },
      extra: <String, dynamic>{
        'secure': <Map<String, String>>[
          {
            'type': 'apiKey',
            'name': 'apiKeyAuth',
            'keyName': 'X-API-KEY',
            'where': 'header',
          },
        ],
        ...?extra,
      },
      validateStatus: validateStatus,
    );

    final _response = await _dio.request<Object>(
      _path,
      options: _options,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    GenericResponse? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(GenericResponse),
      ) as GenericResponse;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<GenericResponse>(
      data: _responseData,
      headers: _response.headers,
      isRedirect: _response.isRedirect,
      requestOptions: _response.requestOptions,
      redirects: _response.redirects,
      statusCode: _response.statusCode,
      statusMessage: _response.statusMessage,
      extra: _response.extra,
    );
  }

  /// Removes an email address from the block lists
  /// Delists an email address from all three block list stores: 1. The rspamd spam-filter database (&#x60;fromemail&#x60; / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use &#x60;GET /mail/blocks&#x60; to discover which addresses are currently blocked.  The &#x60;from&#x60; field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules. 
  ///
  /// Parameters:
  /// * [emailAddressParam] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [GenericResponse] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<GenericResponse>> delistBlock({ 
    required EmailAddressParam emailAddressParam,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/mail/blocks/delete';
    final _options = Options(
      method: r'POST',
      headers: <String, dynamic>{
        ...?headers,
      },
      extra: <String, dynamic>{
        'secure': <Map<String, String>>[
          {
            'type': 'apiKey',
            'name': 'apiKeyAuth',
            'keyName': 'X-API-KEY',
            'where': 'header',
          },
        ],
        ...?extra,
      },
      contentType: 'application/json',
      validateStatus: validateStatus,
    );

    dynamic _bodyData;

    try {
      const _type = FullType(EmailAddressParam);
      _bodyData = _serializers.serialize(emailAddressParam, specifiedType: _type);

    } catch(error, stackTrace) {
      throw DioException(
         requestOptions: _options.compose(
          _dio.options,
          _path,
        ),
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    final _response = await _dio.request<Object>(
      _path,
      data: _bodyData,
      options: _options,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    GenericResponse? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(GenericResponse),
      ) as GenericResponse;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<GenericResponse>(
      data: _responseData,
      headers: _response.headers,
      isRedirect: _response.isRedirect,
      requestOptions: _response.requestOptions,
      redirects: _response.redirects,
      statusCode: _response.statusCode,
      statusMessage: _response.statusMessage,
      extra: _response.extra,
    );
  }

  /// Displays a list of blocked email addresses
  /// Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s).  Three categories are returned:  - **&#x60;local&#x60;** — messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule.  These are   messages sent to recipients on your account&#39;s local block list. - **&#x60;mbtrap&#x60;** — messages flagged by the &#x60;MBTRAP&#x60; rspamd rule.  These are messages   that triggered MailBaby&#39;s internal trap / honeypot detection. - **&#x60;subject&#x60;** — senders whose recent messages contain spam-indicative subjects   (strings containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with high repetition   (more than 4 identical subjects from the same sender in the last 3 days).   The &#x60;local&#x60; and &#x60;mbtrap&#x60; results cover the last 5 days.  The &#x60;subject&#x60; results cover the last 3 days.  A sender address returned in any of these lists can be delisted using &#x60;POST /mail/blocks/delete&#x60; with the &#x60;email&#x60; field set to that address. 
  ///
  /// Parameters:
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [MailBlocks] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<MailBlocks>> getMailBlocks({ 
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/mail/blocks';
    final _options = Options(
      method: r'GET',
      headers: <String, dynamic>{
        ...?headers,
      },
      extra: <String, dynamic>{
        'secure': <Map<String, String>>[
          {
            'type': 'apiKey',
            'name': 'apiKeyAuth',
            'keyName': 'X-API-KEY',
            'where': 'header',
          },
        ],
        ...?extra,
      },
      validateStatus: validateStatus,
    );

    final _response = await _dio.request<Object>(
      _path,
      options: _options,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    MailBlocks? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(MailBlocks),
      ) as MailBlocks;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<MailBlocks>(
      data: _responseData,
      headers: _response.headers,
      isRedirect: _response.isRedirect,
      requestOptions: _response.requestOptions,
      redirects: _response.redirects,
      statusCode: _response.statusCode,
      statusMessage: _response.statusMessage,
      extra: _response.extra,
    );
  }

  /// Displays a listing of deny email rules
  /// Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.  Four rule types are supported: | &#x60;type&#x60; | &#x60;data&#x60; format | Effect | |--------|---------------|--------| | &#x60;email&#x60; | &#x60;user@domain.com&#x60; | Rejects any message from this exact sender address | | &#x60;domain&#x60; | &#x60;domain.com&#x60; | Rejects any message from any address at this domain | | &#x60;destination&#x60; | &#x60;user@domain.com&#x60; | Rejects any message addressed to this recipient | | &#x60;startswith&#x60; | &#x60;prefix&#x60; | Rejects any message whose sender address begins with this string (alphanumeric, &#x60;+&#x60;, &#x60;_&#x60;, &#x60;.&#x60;, &#x60;-&#x60; only) |  Use &#x60;POST /mail/rules&#x60; to add new rules and &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove them.  The &#x60;id&#x60; field in each returned record is the value needed for the delete call. 
  ///
  /// Parameters:
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [BuiltList<DenyRuleRecord>] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<BuiltList<DenyRuleRecord>>> getRules({ 
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/mail/rules';
    final _options = Options(
      method: r'GET',
      headers: <String, dynamic>{
        ...?headers,
      },
      extra: <String, dynamic>{
        'secure': <Map<String, String>>[
          {
            'type': 'apiKey',
            'name': 'apiKeyAuth',
            'keyName': 'X-API-KEY',
            'where': 'header',
          },
        ],
        ...?extra,
      },
      validateStatus: validateStatus,
    );

    final _response = await _dio.request<Object>(
      _path,
      options: _options,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    BuiltList<DenyRuleRecord>? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(BuiltList, [FullType(DenyRuleRecord)]),
      ) as BuiltList<DenyRuleRecord>;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<BuiltList<DenyRuleRecord>>(
      data: _responseData,
      headers: _response.headers,
      isRedirect: _response.isRedirect,
      requestOptions: _response.requestOptions,
      redirects: _response.redirects,
      statusCode: _response.statusCode,
      statusMessage: _response.statusMessage,
      extra: _response.extra,
    );
  }

}
