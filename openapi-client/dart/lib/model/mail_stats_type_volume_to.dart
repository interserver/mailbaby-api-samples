//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.18

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class MailStatsTypeVolumeTo {
  /// Returns a new [MailStatsTypeVolumeTo] instance.
  MailStatsTypeVolumeTo({
    this.clientAtDomainPeriodCom,
    this.userAtSitePeriodNet,
    this.salesAtCompanyPeriodCom,
    this.clientAtAnothersitePeriodCom,
  });

  ///
  /// Please note: This property should have been non-nullable! Since the specification file
  /// does not include a default value (using the "default:" property), however, the generated
  /// source code must fall back to having a nullable type.
  /// Consider adding a "default:" property in the specification file to hide this note.
  ///
  int? clientAtDomainPeriodCom;

  ///
  /// Please note: This property should have been non-nullable! Since the specification file
  /// does not include a default value (using the "default:" property), however, the generated
  /// source code must fall back to having a nullable type.
  /// Consider adding a "default:" property in the specification file to hide this note.
  ///
  int? userAtSitePeriodNet;

  ///
  /// Please note: This property should have been non-nullable! Since the specification file
  /// does not include a default value (using the "default:" property), however, the generated
  /// source code must fall back to having a nullable type.
  /// Consider adding a "default:" property in the specification file to hide this note.
  ///
  int? salesAtCompanyPeriodCom;

  ///
  /// Please note: This property should have been non-nullable! Since the specification file
  /// does not include a default value (using the "default:" property), however, the generated
  /// source code must fall back to having a nullable type.
  /// Consider adding a "default:" property in the specification file to hide this note.
  ///
  int? clientAtAnothersitePeriodCom;

  @override
  bool operator ==(Object other) => identical(this, other) || other is MailStatsTypeVolumeTo &&
    other.clientAtDomainPeriodCom == clientAtDomainPeriodCom &&
    other.userAtSitePeriodNet == userAtSitePeriodNet &&
    other.salesAtCompanyPeriodCom == salesAtCompanyPeriodCom &&
    other.clientAtAnothersitePeriodCom == clientAtAnothersitePeriodCom;

  @override
  int get hashCode =>
    // ignore: unnecessary_parenthesis
    (clientAtDomainPeriodCom == null ? 0 : clientAtDomainPeriodCom!.hashCode) +
    (userAtSitePeriodNet == null ? 0 : userAtSitePeriodNet!.hashCode) +
    (salesAtCompanyPeriodCom == null ? 0 : salesAtCompanyPeriodCom!.hashCode) +
    (clientAtAnothersitePeriodCom == null ? 0 : clientAtAnothersitePeriodCom!.hashCode);

  @override
  String toString() => 'MailStatsTypeVolumeTo[clientAtDomainPeriodCom=$clientAtDomainPeriodCom, userAtSitePeriodNet=$userAtSitePeriodNet, salesAtCompanyPeriodCom=$salesAtCompanyPeriodCom, clientAtAnothersitePeriodCom=$clientAtAnothersitePeriodCom]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
    if (this.clientAtDomainPeriodCom != null) {
      json[r'client@domain.com'] = this.clientAtDomainPeriodCom;
    } else {
      json[r'client@domain.com'] = null;
    }
    if (this.userAtSitePeriodNet != null) {
      json[r'user@site.net'] = this.userAtSitePeriodNet;
    } else {
      json[r'user@site.net'] = null;
    }
    if (this.salesAtCompanyPeriodCom != null) {
      json[r'sales@company.com'] = this.salesAtCompanyPeriodCom;
    } else {
      json[r'sales@company.com'] = null;
    }
    if (this.clientAtAnothersitePeriodCom != null) {
      json[r'client@anothersite.com'] = this.clientAtAnothersitePeriodCom;
    } else {
      json[r'client@anothersite.com'] = null;
    }
    return json;
  }

  /// Returns a new [MailStatsTypeVolumeTo] instance and imports its values from
  /// [value] if it's a [Map], null otherwise.
  // ignore: prefer_constructors_over_static_methods
  static MailStatsTypeVolumeTo? fromJson(dynamic value) {
    if (value is Map) {
      final json = value.cast<String, dynamic>();

      // Ensure that the map contains the required keys.
      // Note 1: the values aren't checked for validity beyond being non-null.
      // Note 2: this code is stripped in release mode!
      assert(() {
        requiredKeys.forEach((key) {
          assert(json.containsKey(key), 'Required key "MailStatsTypeVolumeTo[$key]" is missing from JSON.');
          assert(json[key] != null, 'Required key "MailStatsTypeVolumeTo[$key]" has a null value in JSON.');
        });
        return true;
      }());

      return MailStatsTypeVolumeTo(
        clientAtDomainPeriodCom: mapValueOfType<int>(json, r'client@domain.com'),
        userAtSitePeriodNet: mapValueOfType<int>(json, r'user@site.net'),
        salesAtCompanyPeriodCom: mapValueOfType<int>(json, r'sales@company.com'),
        clientAtAnothersitePeriodCom: mapValueOfType<int>(json, r'client@anothersite.com'),
      );
    }
    return null;
  }

  static List<MailStatsTypeVolumeTo> listFromJson(dynamic json, {bool growable = false,}) {
    final result = <MailStatsTypeVolumeTo>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = MailStatsTypeVolumeTo.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }

  static Map<String, MailStatsTypeVolumeTo> mapFromJson(dynamic json) {
    final map = <String, MailStatsTypeVolumeTo>{};
    if (json is Map && json.isNotEmpty) {
      json = json.cast<String, dynamic>(); // ignore: parameter_assignments
      for (final entry in json.entries) {
        final value = MailStatsTypeVolumeTo.fromJson(entry.value);
        if (value != null) {
          map[entry.key] = value;
        }
      }
    }
    return map;
  }

  // maps a json object with a list of MailStatsTypeVolumeTo-objects as value to a dart map
  static Map<String, List<MailStatsTypeVolumeTo>> mapListFromJson(dynamic json, {bool growable = false,}) {
    final map = <String, List<MailStatsTypeVolumeTo>>{};
    if (json is Map && json.isNotEmpty) {
      // ignore: parameter_assignments
      json = json.cast<String, dynamic>();
      for (final entry in json.entries) {
        map[entry.key] = MailStatsTypeVolumeTo.listFromJson(entry.value, growable: growable,);
      }
    }
    return map;
  }

  /// The list of required keys that must be present in a JSON.
  static const requiredKeys = <String>{
  };
}

