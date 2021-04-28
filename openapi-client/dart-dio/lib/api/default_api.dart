//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.7

// ignore_for_file: unused_import

import 'dart:async';
import 'package:dio/dio.dart';
import 'package:built_value/serializer.dart';

import 'package:openapi/model/generic_response.dart';
import 'package:openapi/model/mail_log.dart';
import 'package:openapi/model/error_response.dart';
import 'package:openapi/model/send_mail.dart';
import 'package:openapi/model/mail_order.dart';
import 'package:built_collection/built_collection.dart';

class DefaultApi {

  final Dio _dio;

  final Serializers _serializers;

  const DefaultApi(this._dio, this._serializers);

  /// Gets mail order information by id
  ///
  /// returns information about a mail order in the system with the given id.
  Future<Response<MailOrder>> getMailById(
    int id, { 
    CancelToken cancelToken,
    Map<String, dynamic> headers,
    Map<String, dynamic> extra,
    ValidateStatus validateStatus,
    ProgressCallback onSendProgress,
    ProgressCallback onReceiveProgress,
  }) async {
    final _request = RequestOptions(
      path: r'/mail/{id}'.replaceAll('{' r'id' '}', id.toString()),
      method: 'GET',
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
          },{
            'type': 'apiKey',
            'name': 'apiLoginAuth',
            'keyName': 'X-API-LOGIN',
            'where': 'header',
          },{
            'type': 'apiKey',
            'name': 'apiPasswordAuth',
            'keyName': 'X-API-PASS',
            'where': 'header',
          },
        ],
        ...?extra,
      },
      validateStatus: validateStatus,
      contentType: [
        'application/json',
      ].first,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    dynamic _bodyData;

    final _response = await _dio.request<dynamic>(
      _request.path,
      data: _bodyData,
      options: _request,
    );

    const _responseType = FullType(MailOrder);
    final _responseData = _serializers.deserialize(
      _response.data,
      specifiedType: _responseType,
    ) as MailOrder;

    return Response<MailOrder>(
      data: _responseData,
      headers: _response.headers,
      isRedirect: _response.isRedirect,
      request: _response.request,
      redirects: _response.redirects,
      statusCode: _response.statusCode,
      statusMessage: _response.statusMessage,
      extra: _response.extra,
    );
  }

  /// displays a list of mail service orders
  ///
  /// 
  Future<Response<BuiltList<MailOrder>>> getMailOrders({ 
    CancelToken cancelToken,
    Map<String, dynamic> headers,
    Map<String, dynamic> extra,
    ValidateStatus validateStatus,
    ProgressCallback onSendProgress,
    ProgressCallback onReceiveProgress,
  }) async {
    final _request = RequestOptions(
      path: r'/mail',
      method: 'GET',
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
          },{
            'type': 'apiKey',
            'name': 'apiLoginAuth',
            'keyName': 'X-API-LOGIN',
            'where': 'header',
          },{
            'type': 'apiKey',
            'name': 'apiPasswordAuth',
            'keyName': 'X-API-PASS',
            'where': 'header',
          },
        ],
        ...?extra,
      },
      validateStatus: validateStatus,
      contentType: [
        'application/json',
      ].first,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    dynamic _bodyData;

    final _response = await _dio.request<dynamic>(
      _request.path,
      data: _bodyData,
      options: _request,
    );

    const _responseType = FullType(BuiltList, [FullType(MailOrder)]);
    final BuiltList<MailOrder> _responseData = _serializers.deserialize(
      _response.data,
      specifiedType: _responseType,
    ) as BuiltList<MailOrder>;

    return Response<BuiltList<MailOrder>>(
      data: _responseData,
      headers: _response.headers,
      isRedirect: _response.isRedirect,
      request: _response.request,
      redirects: _response.redirects,
      statusCode: _response.statusCode,
      statusMessage: _response.statusMessage,
      extra: _response.extra,
    );
  }

  /// Checks if the server is running
  ///
  /// 
  Future<Response<void>> pingServer({ 
    CancelToken cancelToken,
    Map<String, dynamic> headers,
    Map<String, dynamic> extra,
    ValidateStatus validateStatus,
    ProgressCallback onSendProgress,
    ProgressCallback onReceiveProgress,
  }) async {
    final _request = RequestOptions(
      path: r'/ping',
      method: 'GET',
      headers: <String, dynamic>{
        ...?headers,
      },
      extra: <String, dynamic>{
        'secure': <Map<String, String>>[],
        ...?extra,
      },
      validateStatus: validateStatus,
      contentType: [
        'application/json',
      ].first,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    dynamic _bodyData;

    final _response = await _dio.request<dynamic>(
      _request.path,
      data: _bodyData,
      options: _request,
    );

    return _response;
  }

  /// places a mail order
  ///
  /// Adds an item to the system
  Future<Response<void>> placeMailOrder({ 
    MailOrder mailOrder,
    CancelToken cancelToken,
    Map<String, dynamic> headers,
    Map<String, dynamic> extra,
    ValidateStatus validateStatus,
    ProgressCallback onSendProgress,
    ProgressCallback onReceiveProgress,
  }) async {
    final _request = RequestOptions(
      path: r'/mail/order',
      method: 'POST',
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
          },{
            'type': 'apiKey',
            'name': 'apiLoginAuth',
            'keyName': 'X-API-LOGIN',
            'where': 'header',
          },{
            'type': 'apiKey',
            'name': 'apiPasswordAuth',
            'keyName': 'X-API-PASS',
            'where': 'header',
          },
        ],
        ...?extra,
      },
      validateStatus: validateStatus,
      contentType: [
        'application/json',
      ].first,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    dynamic _bodyData;

    const _type = FullType(MailOrder);
    _bodyData = _serializers.serialize(mailOrder, specifiedType: _type);

    final _response = await _dio.request<dynamic>(
      _request.path,
      data: _bodyData,
      options: _request,
    );

    return _response;
  }

  /// Sends an Email with Advanced Options
  ///
  /// Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
  Future<Response<GenericResponse>> sendAdvMailById(
    int id,
    SendMail sendMail, { 
    CancelToken cancelToken,
    Map<String, dynamic> headers,
    Map<String, dynamic> extra,
    ValidateStatus validateStatus,
    ProgressCallback onSendProgress,
    ProgressCallback onReceiveProgress,
  }) async {
    final _request = RequestOptions(
      path: r'/mail/{id}/advsend'.replaceAll('{' r'id' '}', id.toString()),
      method: 'POST',
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
          },{
            'type': 'apiKey',
            'name': 'apiLoginAuth',
            'keyName': 'X-API-LOGIN',
            'where': 'header',
          },{
            'type': 'apiKey',
            'name': 'apiPasswordAuth',
            'keyName': 'X-API-PASS',
            'where': 'header',
          },
        ],
        ...?extra,
      },
      validateStatus: validateStatus,
      contentType: [
        'application/json',
        'application/xml',
        'application/x-www-form-urlencoded',
        'text/plain',
      ].first,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    dynamic _bodyData;

    const _type = FullType(SendMail);
    _bodyData = _serializers.serialize(sendMail, specifiedType: _type);

    final _response = await _dio.request<dynamic>(
      _request.path,
      data: _bodyData,
      options: _request,
    );

    const _responseType = FullType(GenericResponse);
    final _responseData = _serializers.deserialize(
      _response.data,
      specifiedType: _responseType,
    ) as GenericResponse;

    return Response<GenericResponse>(
      data: _responseData,
      headers: _response.headers,
      isRedirect: _response.isRedirect,
      request: _response.request,
      redirects: _response.redirects,
      statusCode: _response.statusCode,
      statusMessage: _response.statusMessage,
      extra: _response.extra,
    );
  }

  /// Sends an Email
  ///
  /// Sends An email through one of your mail orders.
  Future<Response<GenericResponse>> sendMailById(
    int id, { 
    String subject,
    String body,
    String to,
    String toName,
    String from,
    String fromName,
    CancelToken cancelToken,
    Map<String, dynamic> headers,
    Map<String, dynamic> extra,
    ValidateStatus validateStatus,
    ProgressCallback onSendProgress,
    ProgressCallback onReceiveProgress,
  }) async {
    final _request = RequestOptions(
      path: r'/mail/{id}/send'.replaceAll('{' r'id' '}', id.toString()),
      method: 'POST',
      headers: <String, dynamic>{
        ...?headers,
      },
      queryParameters: <String, dynamic>{
        if (subject != null) r'subject': subject,
        if (body != null) r'body': body,
        if (to != null) r'to': to,
        if (toName != null) r'toName': toName,
        if (from != null) r'from': from,
        if (fromName != null) r'fromName': fromName,
      },
      extra: <String, dynamic>{
        'secure': <Map<String, String>>[
          {
            'type': 'apiKey',
            'name': 'apiKeyAuth',
            'keyName': 'X-API-KEY',
            'where': 'header',
          },{
            'type': 'apiKey',
            'name': 'apiLoginAuth',
            'keyName': 'X-API-LOGIN',
            'where': 'header',
          },{
            'type': 'apiKey',
            'name': 'apiPasswordAuth',
            'keyName': 'X-API-PASS',
            'where': 'header',
          },
        ],
        ...?extra,
      },
      validateStatus: validateStatus,
      contentType: [
        'application/json',
      ].first,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    dynamic _bodyData;

    final _response = await _dio.request<dynamic>(
      _request.path,
      data: _bodyData,
      options: _request,
    );

    const _responseType = FullType(GenericResponse);
    final _responseData = _serializers.deserialize(
      _response.data,
      specifiedType: _responseType,
    ) as GenericResponse;

    return Response<GenericResponse>(
      data: _responseData,
      headers: _response.headers,
      isRedirect: _response.isRedirect,
      request: _response.request,
      redirects: _response.redirects,
      statusCode: _response.statusCode,
      statusMessage: _response.statusMessage,
      extra: _response.extra,
    );
  }

  /// validatess order details before placing an order
  ///
  /// 
  Future<Response<void>> validateMailOrder({ 
    CancelToken cancelToken,
    Map<String, dynamic> headers,
    Map<String, dynamic> extra,
    ValidateStatus validateStatus,
    ProgressCallback onSendProgress,
    ProgressCallback onReceiveProgress,
  }) async {
    final _request = RequestOptions(
      path: r'/mail/order',
      method: 'GET',
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
          },{
            'type': 'apiKey',
            'name': 'apiLoginAuth',
            'keyName': 'X-API-LOGIN',
            'where': 'header',
          },{
            'type': 'apiKey',
            'name': 'apiPasswordAuth',
            'keyName': 'X-API-PASS',
            'where': 'header',
          },
        ],
        ...?extra,
      },
      validateStatus: validateStatus,
      contentType: [
        'application/json',
      ].first,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    dynamic _bodyData;

    final _response = await _dio.request<dynamic>(
      _request.path,
      data: _bodyData,
      options: _request,
    );

    return _response;
  }

  /// displays the mail log
  ///
  /// By passing in the appropriate options, you can search for available inventory in the system 
  Future<Response<BuiltList<MailLog>>> viewMailLogById(
    int id, { 
    String searchString,
    int skip,
    int limit,
    CancelToken cancelToken,
    Map<String, dynamic> headers,
    Map<String, dynamic> extra,
    ValidateStatus validateStatus,
    ProgressCallback onSendProgress,
    ProgressCallback onReceiveProgress,
  }) async {
    final _request = RequestOptions(
      path: r'/mail/{id}/log'.replaceAll('{' r'id' '}', id.toString()),
      method: 'GET',
      headers: <String, dynamic>{
        ...?headers,
      },
      queryParameters: <String, dynamic>{
        if (searchString != null) r'searchString': searchString,
        if (skip != null) r'skip': skip,
        if (limit != null) r'limit': limit,
      },
      extra: <String, dynamic>{
        'secure': <Map<String, String>>[
          {
            'type': 'apiKey',
            'name': 'apiKeyAuth',
            'keyName': 'X-API-KEY',
            'where': 'header',
          },{
            'type': 'apiKey',
            'name': 'apiLoginAuth',
            'keyName': 'X-API-LOGIN',
            'where': 'header',
          },{
            'type': 'apiKey',
            'name': 'apiPasswordAuth',
            'keyName': 'X-API-PASS',
            'where': 'header',
          },
        ],
        ...?extra,
      },
      validateStatus: validateStatus,
      contentType: [
        'application/json',
      ].first,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    dynamic _bodyData;

    final _response = await _dio.request<dynamic>(
      _request.path,
      data: _bodyData,
      options: _request,
    );

    const _responseType = FullType(BuiltList, [FullType(MailLog)]);
    final BuiltList<MailLog> _responseData = _serializers.deserialize(
      _response.data,
      specifiedType: _responseType,
    ) as BuiltList<MailLog>;

    return Response<BuiltList<MailLog>>(
      data: _responseData,
      headers: _response.headers,
      isRedirect: _response.isRedirect,
      request: _response.request,
      redirects: _response.redirects,
      statusCode: _response.statusCode,
      statusMessage: _response.statusMessage,
      extra: _response.extra,
    );
  }

}
