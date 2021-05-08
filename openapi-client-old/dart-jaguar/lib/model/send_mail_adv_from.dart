import 'package:jaguar_serializer/jaguar_serializer.dart';


part 'send_mail_adv_from.jser.dart';

class SendMailAdvFrom {
   /* The email address */
  @Alias('email', isNullable: false,  )
  final String email;
   /* Optional contact name */
  @Alias('name', isNullable: false,  )
  final String name;
  

  SendMailAdvFrom(
      

{
    
     this.email = null,   this.name = null 
    
    }
  );

  @override
  String toString() {
    return 'SendMailAdvFrom[email=$email, name=$name, ]';
  }
}

@GenSerializer(nullableFields: true)
class SendMailAdvFromSerializer extends Serializer<SendMailAdvFrom> with _$SendMailAdvFromSerializer {

}

