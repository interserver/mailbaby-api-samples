import 'package:jaguar_serializer/jaguar_serializer.dart';


part 'mail_attachment.jser.dart';

class MailAttachment {
   /* Contents of the attached file */
  @Alias('data', isNullable: false,  )
  final List<int> data;
   /* Optional filename to specify for the attachment. */
  @Alias('filename', isNullable: false,  )
  final String filename;
  

  MailAttachment(
      

{
    
     this.data = null,   this.filename = null 
    
    }
  );

  @override
  String toString() {
    return 'MailAttachment[data=$data, filename=$filename, ]';
  }
}

@GenSerializer(nullableFields: true)
class MailAttachmentSerializer extends Serializer<MailAttachment> with _$MailAttachmentSerializer {

}

