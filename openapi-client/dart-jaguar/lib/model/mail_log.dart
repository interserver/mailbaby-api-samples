import 'package:jaguar_serializer/jaguar_serializer.dart';


part 'mail_log.jser.dart';

class MailLog {
  
  @Alias('id', isNullable: false,  )
  final int id;
  

  MailLog(
      

{
     this.id = null 
    
    }
  );

  @override
  String toString() {
    return 'MailLog[id=$id, ]';
  }
}

@GenSerializer(nullableFields: true)
class MailLogSerializer extends Serializer<MailLog> with _$MailLogSerializer {

}

