import 'package:jaguar_serializer/jaguar_serializer.dart';


part 'body.jser.dart';

class Body {
   /* The Contact whom is the primary recipient of this email. */
  @Alias('to', isNullable: false,  )
  final String to;
   /* The contact whom is the this email is from. */
  @Alias('from', isNullable: false,  )
  final String from;
   /* The subject or title of the email */
  @Alias('subject', isNullable: false,  )
  final String subject;
   /* The main email contents. */
  @Alias('body', isNullable: false,  )
  final String body;
  

  Body(
      

{
     this.to = null,  
     this.from = null,  
     this.subject = null,  
     this.body = null 
    
    }
  );

  @override
  String toString() {
    return 'Body[to=$to, from=$from, subject=$subject, body=$body, ]';
  }
}

@GenSerializer(nullableFields: true)
class BodySerializer extends Serializer<Body> with _$BodySerializer {

}
