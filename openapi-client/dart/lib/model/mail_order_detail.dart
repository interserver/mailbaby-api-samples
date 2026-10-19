//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.18

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class MailOrderDetail {
  /// Returns a new [MailOrderDetail] instance.
  MailOrderDetail({
    required this.id,
    required this.status,
    required this.username,
    required this.password,
    this.comment,
  });

  /// The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
  int id;

  /// The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
  MailOrderDetailStatusEnum status;

  /// The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
  String username;

  /// The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.
  String password;

  /// Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
  ///
  /// Please note: This property should have been non-nullable! Since the specification file
  /// does not include a default value (using the "default:" property), however, the generated
  /// source code must fall back to having a nullable type.
  /// Consider adding a "default:" property in the specification file to hide this note.
  ///
  String? comment;

  @override
  bool operator ==(Object other) => identical(this, other) || other is MailOrderDetail &&
    other.id == id &&
    other.status == status &&
    other.username == username &&
    other.password == password &&
    other.comment == comment;

  @override
  int get hashCode =>
    // ignore: unnecessary_parenthesis
    (id.hashCode) +
    (status.hashCode) +
    (username.hashCode) +
    (password.hashCode) +
    (comment == null ? 0 : comment!.hashCode);

  @override
  String toString() => 'MailOrderDetail[id=$id, status=$status, username=$username, password=$password, comment=$comment]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'id'] = this.id;
      json[r'status'] = this.status;
      json[r'username'] = this.username;
      json[r'password'] = this.password;
    if (this.comment != null) {
      json[r'comment'] = this.comment;
    } else {
      json[r'comment'] = null;
    }
    return json;
  }

  /// Returns a new [MailOrderDetail] instance and imports its values from
  /// [value] if it's a [Map], null otherwise.
  // ignore: prefer_constructors_over_static_methods
  static MailOrderDetail? fromJson(dynamic value) {
    if (value is Map) {
      final json = value.cast<String, dynamic>();

      // Ensure that the map contains the required keys.
      // Note 1: the values aren't checked for validity beyond being non-null.
      // Note 2: this code is stripped in release mode!
      assert(() {
        assert(json.containsKey(r'id'), 'Required key "MailOrderDetail[id]" is missing from JSON.');
        assert(json[r'id'] != null, 'Required key "MailOrderDetail[id]" has a null value in JSON.');
        assert(json.containsKey(r'status'), 'Required key "MailOrderDetail[status]" is missing from JSON.');
        assert(json[r'status'] != null, 'Required key "MailOrderDetail[status]" has a null value in JSON.');
        assert(json.containsKey(r'username'), 'Required key "MailOrderDetail[username]" is missing from JSON.');
        assert(json[r'username'] != null, 'Required key "MailOrderDetail[username]" has a null value in JSON.');
        assert(json.containsKey(r'password'), 'Required key "MailOrderDetail[password]" is missing from JSON.');
        assert(json[r'password'] != null, 'Required key "MailOrderDetail[password]" has a null value in JSON.');
        return true;
      }());

      return MailOrderDetail(
        id: mapValueOfType<int>(json, r'id')!,
        status: MailOrderDetailStatusEnum.fromJson(json[r'status'])!,
        username: mapValueOfType<String>(json, r'username')!,
        password: mapValueOfType<String>(json, r'password')!,
        comment: mapValueOfType<String>(json, r'comment'),
      );
    }
    return null;
  }

  static List<MailOrderDetail> listFromJson(dynamic json, {bool growable = false,}) {
    final result = <MailOrderDetail>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = MailOrderDetail.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }

  static Map<String, MailOrderDetail> mapFromJson(dynamic json) {
    final map = <String, MailOrderDetail>{};
    if (json is Map && json.isNotEmpty) {
      json = json.cast<String, dynamic>(); // ignore: parameter_assignments
      for (final entry in json.entries) {
        final value = MailOrderDetail.fromJson(entry.value);
        if (value != null) {
          map[entry.key] = value;
        }
      }
    }
    return map;
  }

  // maps a json object with a list of MailOrderDetail-objects as value to a dart map
  static Map<String, List<MailOrderDetail>> mapListFromJson(dynamic json, {bool growable = false,}) {
    final map = <String, List<MailOrderDetail>>{};
    if (json is Map && json.isNotEmpty) {
      // ignore: parameter_assignments
      json = json.cast<String, dynamic>();
      for (final entry in json.entries) {
        map[entry.key] = MailOrderDetail.listFromJson(entry.value, growable: growable,);
      }
    }
    return map;
  }

  /// The list of required keys that must be present in a JSON.
  static const requiredKeys = <String>{
    'id',
    'status',
    'username',
    'password',
  };
}

/// The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
enum MailOrderDetailStatusEnum {
  active._(r'active'),
  canceled._(r'canceled'),
  ;

  /// Instantiate a new enum with the provided value.
  const MailOrderDetailStatusEnum._(this._value);

  /// The underlying value of this enum member.
  final String _value;

  @override
  String toString() => _value;

  /// Encodes this enum as a value suitable for JSON.
  String toJson() => _value;

  /// Returns the instance of [MailOrderDetailStatusEnum] that was successfully decoded
  /// from the passed [value] on success, null otherwise.
  static MailOrderDetailStatusEnum? fromJson(dynamic value) => MailOrderDetailStatusEnumTypeTransformer().decode(value);

  /// Returns a [List] containing instances of [MailOrderDetailStatusEnum]
  /// that were successfully decoded from the passed [JSON][json].
  static List<MailOrderDetailStatusEnum> listFromJson(dynamic json, {bool growable = false,}) {
    final result = <MailOrderDetailStatusEnum>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = MailOrderDetailStatusEnum.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }
}

/// Transformation class that can [encode] an instance of [MailOrderDetailStatusEnum] to String,
/// and [decode] dynamic data back to [MailOrderDetailStatusEnum].
class MailOrderDetailStatusEnumTypeTransformer {
  factory MailOrderDetailStatusEnumTypeTransformer() => _instance ??= const MailOrderDetailStatusEnumTypeTransformer._();

  const MailOrderDetailStatusEnumTypeTransformer._();

  String encode(MailOrderDetailStatusEnum data) => data._value;

  /// Returns the instance of [MailOrderDetailStatusEnum] that was successfully decoded
  /// from the passed [data] value on success, null otherwise.
  ///
  /// If [allowNull] is true and the [dynamic value][data] cannot be decoded successfully,
  /// then null is returned. However, if [allowNull] is false and the [dynamic value][data]
  /// cannot be decoded successfully, then an [UnimplementedError] is thrown.
  ///
  /// The [allowNull] is very handy when an API changes and a new enum value is added or removed,
  /// and users are still using an old app with the old code.
  MailOrderDetailStatusEnum? decode(dynamic data, {bool allowNull = true}) {
    if (data is MailOrderDetailStatusEnum) {
      return data;
    }
    if (data != null) {
      switch (data) {
        case r'active': return MailOrderDetailStatusEnum.active;
        case r'canceled': return MailOrderDetailStatusEnum.canceled;
        default:
          if (!allowNull) {
            throw ArgumentError('Unknown enum value to decode: $data');
          }
      }
    }
    return null;
  }

  /// The singleton instance of this transformer.
  static MailOrderDetailStatusEnumTypeTransformer? _instance;
}


