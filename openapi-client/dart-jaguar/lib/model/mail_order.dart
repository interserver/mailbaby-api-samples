import 'package:jaguar_serializer/jaguar_serializer.dart';


part 'mail_order.jser.dart';

class MailOrder {
  
  @Alias('id', isNullable: false,  )
  final int id;
  
  @Alias('status', isNullable: false,  )
  final String status;
  
  @Alias('username', isNullable: false,  )
  final String username;
  
  @Alias('password', isNullable: false,  )
  final String password;
  
  @Alias('comment', isNullable: false,  )
  final String comment;
  

  MailOrder(
      

{
    
     this.id = null,  
     this.status = null,  
     this.username = null,   this.password = null,  
     this.comment = null 
    
    }
  );

  @override
  String toString() {
    return 'MailOrder[id=$id, status=$status, username=$username, password=$password, comment=$comment, ]';
  }
}

@GenSerializer(nullableFields: true)
class MailOrderSerializer extends Serializer<MailOrder> with _$MailOrderSerializer {

}

