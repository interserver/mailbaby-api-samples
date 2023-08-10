//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'dart:async';

import 'package:built_value/serializer.dart';
import 'package:dio/dio.dart';

import 'package:built_collection/built_collection.dart';
import 'package:openapi/src/api_util.dart';
import 'package:openapi/src/model/email_address_name.dart';
import 'package:openapi/src/model/generic_response.dart';
import 'package:openapi/src/model/get_mail_orders401_response.dart';
import 'package:openapi/src/model/mail_attachment.dart';

class SendingApi {

  final Dio _dio;

  final Serializers _serializers;

  const SendingApi(this._dio, this._serializers);

  /// Sends an Email with Advanced Options
  /// Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
  ///
  /// Parameters:
  /// * [subject] - The subject or title of the email
  /// * [body] - The main email contents.
  /// * [from] 
  /// * [to] - A list of destionation email addresses to send this to
  /// * [replyto] - (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
  /// * [cc] - (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
  /// * [bcc] - (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
  /// * [attachments] - (optional) File attachments to include in the email.  The file contents must be base64 encoded!
  /// * [id] - (optional)  ID of the Mail order within our system to use as the Mail Account.
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [GenericResponse] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<GenericResponse>> sendAdvMail({ 
    required String subject,
    required String body,
    required EmailAddressName from,
    required BuiltList<EmailAddressName> to,
    BuiltList<EmailAddressName>? replyto,
    BuiltList<EmailAddressName>? cc,
    BuiltList<EmailAddressName>? bcc,
    BuiltList<MailAttachment>? attachments,
    int? id,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/mail/advsend';
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
        r'subject': encodeQueryParameter(_serializers, subject, const FullType(String)),
        r'body': encodeQueryParameter(_serializers, body, const FullType(String)),
        r'from': encodeQueryParameter(_serializers, from, const FullType(EmailAddressName)),
        r'to': encodeCollectionQueryParameter<EmailAddressName>(_serializers, to, const FullType(BuiltList, [FullType(EmailAddressName)]), format: ListFormat.csv,),
        if (replyto != null) r'replyto': encodeCollectionQueryParameter<EmailAddressName>(_serializers, replyto, const FullType(BuiltList, [FullType(EmailAddressName)]), format: ListFormat.csv,),
        if (cc != null) r'cc': encodeCollectionQueryParameter<EmailAddressName>(_serializers, cc, const FullType(BuiltList, [FullType(EmailAddressName)]), format: ListFormat.csv,),
        if (bcc != null) r'bcc': encodeCollectionQueryParameter<EmailAddressName>(_serializers, bcc, const FullType(BuiltList, [FullType(EmailAddressName)]), format: ListFormat.csv,),
        if (attachments != null) r'attachments': encodeCollectionQueryParameter<MailAttachment>(_serializers, attachments, const FullType(BuiltList, [FullType(MailAttachment)]), format: ListFormat.csv,),
        if (id != null) r'id': encodeQueryParameter(_serializers, id, const FullType(int)),
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

  /// Sends an Email
  /// Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
  ///
  /// Parameters:
  /// * [to] - The Contact whom is the primary recipient of this email.
  /// * [from] - The contact whom is the this email is from.
  /// * [subject] - The subject or title of the email
  /// * [body] - The main email contents.
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [GenericResponse] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<GenericResponse>> sendMail({ 
    required String to,
    required String from,
    required String subject,
    required String body,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/mail/send';
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
        r'to': encodeQueryParameter(_serializers, to, const FullType(String)),
        r'from': encodeQueryParameter(_serializers, from, const FullType(String)),
        r'subject': encodeQueryParameter(_serializers, subject, const FullType(String)),
        r'body': encodeQueryParameter(_serializers, body, const FullType(String)),
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

}
