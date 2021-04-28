//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.0

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class MailOrder {
  /// Returns a new [MailOrder] instance.
  MailOrder({
    @required this.id,
    @required this.status,
    @required this.username,
    this.password,
    this.comment,
  });

  int id;

  String status;

  String username;

  String password;

  String comment;

  @override
  bool operator ==(Object other) => identical(this, other) || other is MailOrder &&
     other.id == id &&
     other.status == status &&
     other.username == username &&
     other.password == password &&
     other.comment == comment;

  @override
  int get hashCode =>
    (id == null ? 0 : id.hashCode) +
    (status == null ? 0 : status.hashCode) +
    (username == null ? 0 : username.hashCode) +
    (password == null ? 0 : password.hashCode) +
    (comment == null ? 0 : comment.hashCode);

  @override
  String toString() => 'MailOrder[id=$id, status=$status, username=$username, password=$password, comment=$comment]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'id'] = id;
      json[r'status'] = status;
      json[r'username'] = username;
    if (password != null) {
      json[r'password'] = password;
    }
    if (comment != null) {
      json[r'comment'] = comment;
    }
    return json;
  }

  /// Returns a new [MailOrder] instance and imports its values from
  /// [json] if it's non-null, null if [json] is null.
  static MailOrder fromJson(Map<String, dynamic> json) => json == null
    ? null
    : MailOrder(
        id: json[r'id'],
        status: json[r'status'],
        username: json[r'username'],
        password: json[r'password'],
        comment: json[r'comment'],
    );

  static List<MailOrder> listFromJson(List<dynamic> json, {bool emptyIsNull, bool growable,}) =>
    json == null || json.isEmpty
      ? true == emptyIsNull ? null : <MailOrder>[]
      : json.map((v) => MailOrder.fromJson(v)).toList(growable: true == growable);

  static Map<String, MailOrder> mapFromJson(Map<String, dynamic> json) {
    final map = <String, MailOrder>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) => map[key] = MailOrder.fromJson(v));
    }
    return map;
  }

  // maps a json object with a list of MailOrder-objects as value to a dart map
  static Map<String, List<MailOrder>> mapListFromJson(Map<String, dynamic> json, {bool emptyIsNull, bool growable,}) {
    final map = <String, List<MailOrder>>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) {
        map[key] = MailOrder.listFromJson(v, emptyIsNull: emptyIsNull, growable: growable);
      });
    }
    return map;
  }
}

