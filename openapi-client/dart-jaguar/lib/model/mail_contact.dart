import 'package:jaguar_serializer/jaguar_serializer.dart';


part 'mail_contact.jser.dart';

class MailContact {
   /* The email address */
  @Alias('email', isNullable: false,  )
  final String email;
   /* Optional contact name */
  @Alias('name', isNullable: false,  )
  final String name;
  

  MailContact(
      

{
    
     this.email = null,   this.name = null 
    
    }
  );

  @override
  String toString() {
    return 'MailContact[email=$email, name=$name, ]';
  }
}

@GenSerializer(nullableFields: true)
class MailContactSerializer extends Serializer<MailContact> with _$MailContactSerializer {

}

