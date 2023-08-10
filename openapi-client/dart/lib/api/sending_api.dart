//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.12

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;


class SendingApi {
  SendingApi([ApiClient? apiClient]) : apiClient = apiClient ?? defaultApiClient;

  final ApiClient apiClient;

  /// Sends an Email with Advanced Options
  ///
  /// Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
  ///
  /// Note: This method returns the HTTP [Response].
  ///
  /// Parameters:
  ///
  /// * [String] subject (required):
  ///   The subject or title of the email
  ///
  /// * [String] body (required):
  ///   The main email contents.
  ///
  /// * [EmailAddressName] from (required):
  ///
  /// * [List<EmailAddressName>] to (required):
  ///   A list of destionation email addresses to send this to
  ///
  /// * [List<EmailAddressName>] replyto:
  ///   (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
  ///
  /// * [List<EmailAddressName>] cc:
  ///   (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
  ///
  /// * [List<EmailAddressName>] bcc:
  ///   (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
  ///
  /// * [List<MailAttachment>] attachments:
  ///   (optional) File attachments to include in the email.  The file contents must be base64 encoded!
  ///
  /// * [int] id:
  ///   (optional)  ID of the Mail order within our system to use as the Mail Account.
  Future<Response> sendAdvMailWithHttpInfo(String subject, String body, EmailAddressName from, List<EmailAddressName> to, { List<EmailAddressName>? replyto, List<EmailAddressName>? cc, List<EmailAddressName>? bcc, List<MailAttachment>? attachments, int? id, }) async {
    // ignore: prefer_const_declarations
    final path = r'/mail/advsend';

    // ignore: prefer_final_locals
    Object? postBody;

    final queryParams = <QueryParam>[];
    final headerParams = <String, String>{};
    final formParams = <String, String>{};

    const contentTypes = <String>['application/x-www-form-urlencoded', 'application/json'];

    if (subject != null) {
      formParams[r'subject'] = parameterToString(subject);
    }
    if (body != null) {
      formParams[r'body'] = parameterToString(body);
    }
    if (from != null) {
      formParams[r'from'] = parameterToString(from);
    }
    if (to != null) {
      formParams[r'to'] = parameterToString(to);
    }
    if (replyto != null) {
      formParams[r'replyto'] = parameterToString(replyto);
    }
    if (cc != null) {
      formParams[r'cc'] = parameterToString(cc);
    }
    if (bcc != null) {
      formParams[r'bcc'] = parameterToString(bcc);
    }
    if (attachments != null) {
      formParams[r'attachments'] = parameterToString(attachments);
    }
    if (id != null) {
      formParams[r'id'] = parameterToString(id);
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

  /// Sends an Email with Advanced Options
  ///
  /// Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
  ///
  /// Parameters:
  ///
  /// * [String] subject (required):
  ///   The subject or title of the email
  ///
  /// * [String] body (required):
  ///   The main email contents.
  ///
  /// * [EmailAddressName] from (required):
  ///
  /// * [List<EmailAddressName>] to (required):
  ///   A list of destionation email addresses to send this to
  ///
  /// * [List<EmailAddressName>] replyto:
  ///   (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
  ///
  /// * [List<EmailAddressName>] cc:
  ///   (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
  ///
  /// * [List<EmailAddressName>] bcc:
  ///   (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
  ///
  /// * [List<MailAttachment>] attachments:
  ///   (optional) File attachments to include in the email.  The file contents must be base64 encoded!
  ///
  /// * [int] id:
  ///   (optional)  ID of the Mail order within our system to use as the Mail Account.
  Future<GenericResponse?> sendAdvMail(String subject, String body, EmailAddressName from, List<EmailAddressName> to, { List<EmailAddressName>? replyto, List<EmailAddressName>? cc, List<EmailAddressName>? bcc, List<MailAttachment>? attachments, int? id, }) async {
    final response = await sendAdvMailWithHttpInfo(subject, body, from, to,  replyto: replyto, cc: cc, bcc: bcc, attachments: attachments, id: id, );
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
}
