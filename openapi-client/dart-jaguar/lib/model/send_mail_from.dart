import 'package:jaguar_serializer/jaguar_serializer.dart';


part 'send_mail_from.jser.dart';

class SendMailFrom {
   /* The email address */
  @Alias('email', isNullable: false,  )
  final String email;
   /* Optional contact name */
  @Alias('name', isNullable: false,  )
  final String name;
  

  SendMailFrom(
      

{
    
     this.email = null,   this.name = null 
    
    }
  );

  @override
  String toString() {
    return 'SendMailFrom[email=$email, name=$name, ]';
  }
}

@GenSerializer(nullableFields: true)
class SendMailFromSerializer extends Serializer<SendMailFrom> with _$SendMailFromSerializer {

}

