//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'dart:async';

import 'package:built_value/json_object.dart';
import 'package:built_value/serializer.dart';
import 'package:dio/dio.dart';

import 'package:built_collection/built_collection.dart';
import 'package:openapi/src/api_util.dart';
import 'package:openapi/src/model/error_message.dart';
import 'package:openapi/src/model/get_stats200_response_inner.dart';
import 'package:openapi/src/model/mail_log.dart';

class HistoryApi {

  final Dio _dio;

  final Serializers _serializers;

  const HistoryApi(this._dio, this._serializers);

  /// Account usage statistics.
  /// Returns information about the usage on your mail accounts.
  ///
  /// Parameters:
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [BuiltList<GetStats200ResponseInner>] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<BuiltList<GetStats200ResponseInner>>> getStats({ 
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/mail/stats';
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

    BuiltList<GetStats200ResponseInner>? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(BuiltList, [FullType(GetStats200ResponseInner)]),
      ) as BuiltList<GetStats200ResponseInner>;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<BuiltList<GetStats200ResponseInner>>(
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

  /// displays the mail log
  /// Get a listing of the emails sent through this system 
  ///
  /// Parameters:
  /// * [id] - The ID of your mail order this will be sent through.
  /// * [origin] - originating ip address sending mail
  /// * [mx] - mx record mail was sent to
  /// * [from] - from email address
  /// * [to] - to/destination email address
  /// * [subject] - subject containing this string
  /// * [mailid] - mail id
  /// * [skip] - number of records to skip for pagination
  /// * [limit] - maximum number of records to return
  /// * [startDate] - earliest date to get emails in unix timestamp format
  /// * [endDate] - earliest date to get emails in unix timestamp format
  /// * [replyto] - Reply-To Email Address
  /// * [headerfrom] - Header From Email Address
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [MailLog] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<MailLog>> viewMailLog({ 
    int? id,
    String? origin,
    String? mx,
    String? from,
    String? to,
    String? subject,
    String? mailid,
    int? skip = 0,
    int? limit = 100,
    int? startDate,
    int? endDate,
    String? replyto,
    String? headerfrom,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/mail/log';
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

    final _queryParameters = <String, dynamic>{
      if (id != null) r'id': encodeQueryParameter(_serializers, id, const FullType(int)),
      if (origin != null) r'origin': encodeQueryParameter(_serializers, origin, const FullType(String)),
      if (mx != null) r'mx': encodeQueryParameter(_serializers, mx, const FullType(String)),
      if (from != null) r'from': encodeQueryParameter(_serializers, from, const FullType(String)),
      if (to != null) r'to': encodeQueryParameter(_serializers, to, const FullType(String)),
      if (subject != null) r'subject': encodeQueryParameter(_serializers, subject, const FullType(String)),
      if (mailid != null) r'mailid': encodeQueryParameter(_serializers, mailid, const FullType(String)),
      if (skip != null) r'skip': encodeQueryParameter(_serializers, skip, const FullType(int)),
      if (limit != null) r'limit': encodeQueryParameter(_serializers, limit, const FullType(int)),
      if (startDate != null) r'startDate': encodeQueryParameter(_serializers, startDate, const FullType(int)),
      if (endDate != null) r'endDate': encodeQueryParameter(_serializers, endDate, const FullType(int)),
      if (replyto != null) r'replyto': encodeQueryParameter(_serializers, replyto, const FullType(String)),
      if (headerfrom != null) r'headerfrom': encodeQueryParameter(_serializers, headerfrom, const FullType(String)),
    };

    final _response = await _dio.request<Object>(
      _path,
      options: _options,
      queryParameters: _queryParameters,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    MailLog? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(MailLog),
      ) as MailLog;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<MailLog>(
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
