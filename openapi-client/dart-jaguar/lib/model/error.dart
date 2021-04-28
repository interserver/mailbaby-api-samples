import 'package:jaguar_serializer/jaguar_serializer.dart';


part 'error.jser.dart';

class Error {
  
  @Alias('code', isNullable: false,  )
  final String code;
  
  @Alias('message', isNullable: false,  )
  final String message;
  

  Error(
      

{
    
     this.code = null,  
     this.message = null 
    }
  );

  @override
  String toString() {
    return 'Error[code=$code, message=$message, ]';
  }
}

@GenSerializer(nullableFields: true)
class ErrorSerializer extends Serializer<Error> with _$ErrorSerializer {

}

