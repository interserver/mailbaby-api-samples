//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.18

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class MailOrder {
  /// Returns a new [MailOrder] instance.
  MailOrder({
    required this.id,
    required this.status,
    required this.username,
    this.comment,
  });

  /// The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
  int id;

  /// The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
  MailOrderStatusEnum status;

  /// The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
  String username;

  /// Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
  ///
  /// Please note: This property should have been non-nullable! Since the specification file
  /// does not include a default value (using the "default:" property), however, the generated
  /// source code must fall back to having a nullable type.
  /// Consider adding a "default:" property in the specification file to hide this note.
  ///
  String? comment;

  @override
  bool operator ==(Object other) => identical(this, other) || other is MailOrder &&
    other.id == id &&
    other.status == status &&
    other.username == username &&
    other.comment == comment;

  @override
  int get hashCode =>
    // ignore: unnecessary_parenthesis
    (id.hashCode) +
    (status.hashCode) +
    (username.hashCode) +
    (comment == null ? 0 : comment!.hashCode);

  @override
  String toString() => 'MailOrder[id=$id, status=$status, username=$username, comment=$comment]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'id'] = this.id;
      json[r'status'] = this.status;
      json[r'username'] = this.username;
    if (this.comment != null) {
      json[r'comment'] = this.comment;
    } else {
      json[r'comment'] = null;
    }
    return json;
  }

  /// Returns a new [MailOrder] instance and imports its values from
  /// [value] if it's a [Map], null otherwise.
  // ignore: prefer_constructors_over_static_methods
  static MailOrder? fromJson(dynamic value) {
    if (value is Map) {
      final json = value.cast<String, dynamic>();

      // Ensure that the map contains the required keys.
      // Note 1: the values aren't checked for validity beyond being non-null.
      // Note 2: this code is stripped in release mode!
      assert(() {
        assert(json.containsKey(r'id'), 'Required key "MailOrder[id]" is missing from JSON.');
        assert(json[r'id'] != null, 'Required key "MailOrder[id]" has a null value in JSON.');
        assert(json.containsKey(r'status'), 'Required key "MailOrder[status]" is missing from JSON.');
        assert(json[r'status'] != null, 'Required key "MailOrder[status]" has a null value in JSON.');
        assert(json.containsKey(r'username'), 'Required key "MailOrder[username]" is missing from JSON.');
        assert(json[r'username'] != null, 'Required key "MailOrder[username]" has a null value in JSON.');
        return true;
      }());

      return MailOrder(
        id: mapValueOfType<int>(json, r'id')!,
        status: MailOrderStatusEnum.fromJson(json[r'status'])!,
        username: mapValueOfType<String>(json, r'username')!,
        comment: mapValueOfType<String>(json, r'comment'),
      );
    }
    return null;
  }

  static List<MailOrder> listFromJson(dynamic json, {bool growable = false,}) {
    final result = <MailOrder>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = MailOrder.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }

  static Map<String, MailOrder> mapFromJson(dynamic json) {
    final map = <String, MailOrder>{};
    if (json is Map && json.isNotEmpty) {
      json = json.cast<String, dynamic>(); // ignore: parameter_assignments
      for (final entry in json.entries) {
        final value = MailOrder.fromJson(entry.value);
        if (value != null) {
          map[entry.key] = value;
        }
      }
    }
    return map;
  }

  // maps a json object with a list of MailOrder-objects as value to a dart map
  static Map<String, List<MailOrder>> mapListFromJson(dynamic json, {bool growable = false,}) {
    final map = <String, List<MailOrder>>{};
    if (json is Map && json.isNotEmpty) {
      // ignore: parameter_assignments
      json = json.cast<String, dynamic>();
      for (final entry in json.entries) {
        map[entry.key] = MailOrder.listFromJson(entry.value, growable: growable,);
      }
    }
    return map;
  }

  /// The list of required keys that must be present in a JSON.
  static const requiredKeys = <String>{
    'id',
    'status',
    'username',
  };
}

/// The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
class MailOrderStatusEnum {
  /// Instantiate a new enum with the provided [value].
  const MailOrderStatusEnum._(this.value);

  /// The underlying value of this enum member.
  final String value;

  @override
  String toString() => value;

  String toJson() => value;

  static const active = MailOrderStatusEnum._(r'active');
  static const canceled = MailOrderStatusEnum._(r'canceled');

  /// List of all possible values in this [enum][MailOrderStatusEnum].
  static const values = <MailOrderStatusEnum>[
    active,
    canceled,
  ];

  static MailOrderStatusEnum? fromJson(dynamic value) => MailOrderStatusEnumTypeTransformer().decode(value);

  static List<MailOrderStatusEnum> listFromJson(dynamic json, {bool growable = false,}) {
    final result = <MailOrderStatusEnum>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = MailOrderStatusEnum.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }
}

/// Transformation class that can [encode] an instance of [MailOrderStatusEnum] to String,
/// and [decode] dynamic data back to [MailOrderStatusEnum].
class MailOrderStatusEnumTypeTransformer {
  factory MailOrderStatusEnumTypeTransformer() => _instance ??= const MailOrderStatusEnumTypeTransformer._();

  const MailOrderStatusEnumTypeTransformer._();

  String encode(MailOrderStatusEnum data) => data.value;

  /// Decodes a [dynamic value][data] to a MailOrderStatusEnum.
  ///
  /// If [allowNull] is true and the [dynamic value][data] cannot be decoded successfully,
  /// then null is returned. However, if [allowNull] is false and the [dynamic value][data]
  /// cannot be decoded successfully, then an [UnimplementedError] is thrown.
  ///
  /// The [allowNull] is very handy when an API changes and a new enum value is added or removed,
  /// and users are still using an old app with the old code.
  MailOrderStatusEnum? decode(dynamic data, {bool allowNull = true}) {
    if (data != null) {
      switch (data) {
        case r'active': return MailOrderStatusEnum.active;
        case r'canceled': return MailOrderStatusEnum.canceled;
        default:
          if (!allowNull) {
            throw ArgumentError('Unknown enum value to decode: $data');
          }
      }
    }
    return null;
  }

  /// Singleton [MailOrderStatusEnumTypeTransformer] instance.
  static MailOrderStatusEnumTypeTransformer? _instance;
}


