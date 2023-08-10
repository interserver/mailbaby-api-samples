//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.12

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class DenyRuleRecord {
  /// Returns a new [DenyRuleRecord] instance.
  DenyRuleRecord({
    required this.type,
    required this.data,
    required this.id,
    required this.created,
    this.user,
  });

  /// The type of deny rule.
  DenyRuleRecordTypeEnum type;

  /// The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
  String data;

  /// The deny rule Id number.
  int id;

  /// the date the rule was created.
  DateTime created;

  /// Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
  ///
  /// Please note: This property should have been non-nullable! Since the specification file
  /// does not include a default value (using the "default:" property), however, the generated
  /// source code must fall back to having a nullable type.
  /// Consider adding a "default:" property in the specification file to hide this note.
  ///
  String? user;

  @override
  bool operator ==(Object other) => identical(this, other) || other is DenyRuleRecord &&
    other.type == type &&
    other.data == data &&
    other.id == id &&
    other.created == created &&
    other.user == user;

  @override
  int get hashCode =>
    // ignore: unnecessary_parenthesis
    (type.hashCode) +
    (data.hashCode) +
    (id.hashCode) +
    (created.hashCode) +
    (user == null ? 0 : user!.hashCode);

  @override
  String toString() => 'DenyRuleRecord[type=$type, data=$data, id=$id, created=$created, user=$user]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'type'] = this.type;
      json[r'data'] = this.data;
      json[r'id'] = this.id;
      json[r'created'] = this.created.toUtc().toIso8601String();
    if (this.user != null) {
      json[r'user'] = this.user;
    } else {
      json[r'user'] = null;
    }
    return json;
  }

  /// Returns a new [DenyRuleRecord] instance and imports its values from
  /// [value] if it's a [Map], null otherwise.
  // ignore: prefer_constructors_over_static_methods
  static DenyRuleRecord? fromJson(dynamic value) {
    if (value is Map) {
      final json = value.cast<String, dynamic>();

      // Ensure that the map contains the required keys.
      // Note 1: the values aren't checked for validity beyond being non-null.
      // Note 2: this code is stripped in release mode!
      assert(() {
        requiredKeys.forEach((key) {
          assert(json.containsKey(key), 'Required key "DenyRuleRecord[$key]" is missing from JSON.');
          assert(json[key] != null, 'Required key "DenyRuleRecord[$key]" has a null value in JSON.');
        });
        return true;
      }());

      return DenyRuleRecord(
        type: DenyRuleRecordTypeEnum.fromJson(json[r'type'])!,
        data: mapValueOfType<String>(json, r'data')!,
        id: mapValueOfType<int>(json, r'id')!,
        created: mapDateTime(json, r'created', r'')!,
        user: mapValueOfType<String>(json, r'user'),
      );
    }
    return null;
  }

  static List<DenyRuleRecord> listFromJson(dynamic json, {bool growable = false,}) {
    final result = <DenyRuleRecord>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = DenyRuleRecord.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }

  static Map<String, DenyRuleRecord> mapFromJson(dynamic json) {
    final map = <String, DenyRuleRecord>{};
    if (json is Map && json.isNotEmpty) {
      json = json.cast<String, dynamic>(); // ignore: parameter_assignments
      for (final entry in json.entries) {
        final value = DenyRuleRecord.fromJson(entry.value);
        if (value != null) {
          map[entry.key] = value;
        }
      }
    }
    return map;
  }

  // maps a json object with a list of DenyRuleRecord-objects as value to a dart map
  static Map<String, List<DenyRuleRecord>> mapListFromJson(dynamic json, {bool growable = false,}) {
    final map = <String, List<DenyRuleRecord>>{};
    if (json is Map && json.isNotEmpty) {
      // ignore: parameter_assignments
      json = json.cast<String, dynamic>();
      for (final entry in json.entries) {
        map[entry.key] = DenyRuleRecord.listFromJson(entry.value, growable: growable,);
      }
    }
    return map;
  }

  /// The list of required keys that must be present in a JSON.
  static const requiredKeys = <String>{
    'type',
    'data',
    'id',
    'created',
  };
}

/// The type of deny rule.
class DenyRuleRecordTypeEnum {
  /// Instantiate a new enum with the provided [value].
  const DenyRuleRecordTypeEnum._(this.value);

  /// The underlying value of this enum member.
  final String value;

  @override
  String toString() => value;

  String toJson() => value;

  static const domain = DenyRuleRecordTypeEnum._(r'domain');
  static const email = DenyRuleRecordTypeEnum._(r'email');
  static const startswith = DenyRuleRecordTypeEnum._(r'startswith');

  /// List of all possible values in this [enum][DenyRuleRecordTypeEnum].
  static const values = <DenyRuleRecordTypeEnum>[
    domain,
    email,
    startswith,
  ];

  static DenyRuleRecordTypeEnum? fromJson(dynamic value) => DenyRuleRecordTypeEnumTypeTransformer().decode(value);

  static List<DenyRuleRecordTypeEnum> listFromJson(dynamic json, {bool growable = false,}) {
    final result = <DenyRuleRecordTypeEnum>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = DenyRuleRecordTypeEnum.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }
}

/// Transformation class that can [encode] an instance of [DenyRuleRecordTypeEnum] to String,
/// and [decode] dynamic data back to [DenyRuleRecordTypeEnum].
class DenyRuleRecordTypeEnumTypeTransformer {
  factory DenyRuleRecordTypeEnumTypeTransformer() => _instance ??= const DenyRuleRecordTypeEnumTypeTransformer._();

  const DenyRuleRecordTypeEnumTypeTransformer._();

  String encode(DenyRuleRecordTypeEnum data) => data.value;

  /// Decodes a [dynamic value][data] to a DenyRuleRecordTypeEnum.
  ///
  /// If [allowNull] is true and the [dynamic value][data] cannot be decoded successfully,
  /// then null is returned. However, if [allowNull] is false and the [dynamic value][data]
  /// cannot be decoded successfully, then an [UnimplementedError] is thrown.
  ///
  /// The [allowNull] is very handy when an API changes and a new enum value is added or removed,
  /// and users are still using an old app with the old code.
  DenyRuleRecordTypeEnum? decode(dynamic data, {bool allowNull = true}) {
    if (data != null) {
      switch (data) {
        case r'domain': return DenyRuleRecordTypeEnum.domain;
        case r'email': return DenyRuleRecordTypeEnum.email;
        case r'startswith': return DenyRuleRecordTypeEnum.startswith;
        default:
          if (!allowNull) {
            throw ArgumentError('Unknown enum value to decode: $data');
          }
      }
    }
    return null;
  }

  /// Singleton [DenyRuleRecordTypeEnumTypeTransformer] instance.
  static DenyRuleRecordTypeEnumTypeTransformer? _instance;
}


