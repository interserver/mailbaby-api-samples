import 'package:jaguar_serializer/jaguar_serializer.dart';


part 'mail_attachment.jser.dart';

class MailAttachment {
   /* Optional filename to specify for the attachment. */
  @Alias('filename', isNullable: false,  )
  final String filename;
   /* Contents of the attached file */
  @Alias('data', isNullable: false,  )
  final List<int> data;
  

  MailAttachment(
      

{
     this.filename = null,  
    
     this.data = null 
    }
  );

  @override
  String toString() {
    return 'MailAttachment[filename=$filename, data=$data, ]';
  }
}

@GenSerializer(nullableFields: true)
class MailAttachmentSerializer extends Serializer<MailAttachment> with _$MailAttachmentSerializer {

}

