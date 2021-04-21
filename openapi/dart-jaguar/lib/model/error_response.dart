import 'package:jaguar_serializer/jaguar_serializer.dart';


part 'error_response.jser.dart';

class ErrorResponse {
  
  @Alias('code', isNullable: false,  )
  final String code;
  
  @Alias('message', isNullable: false,  )
  final String message;
  

  ErrorResponse(
      

{
    
     this.code = null,  
     this.message = null 
    }
  );

  @override
  String toString() {
    return 'ErrorResponse[code=$code, message=$message, ]';
  }
}

@GenSerializer(nullableFields: true)
class ErrorResponseSerializer extends Serializer<ErrorResponse> with _$ErrorResponseSerializer {

}

