//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'mail_attachment.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class MailAttachment {
  /// Returns a new [MailAttachment] instance.
  MailAttachment({

    required  this.filename,

    required  this.data,
  });

      /// The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).
  @JsonKey(
    
    name: r'filename',
    required: true,
    includeIfNull: false,
  )


  final String filename;



      /// The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
  @JsonKey(
    
    name: r'data',
    required: true,
    includeIfNull: false,
  )


  final String data;





    @override
    bool operator ==(Object other) => identical(this, other) || other is MailAttachment &&
      other.filename == filename &&
      other.data == data;

    @override
    int get hashCode =>
        filename.hashCode +
        data.hashCode;

  factory MailAttachment.fromJson(Map<String, dynamic> json) => _$MailAttachmentFromJson(json);

  Map<String, dynamic> toJson() => _$MailAttachmentToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

