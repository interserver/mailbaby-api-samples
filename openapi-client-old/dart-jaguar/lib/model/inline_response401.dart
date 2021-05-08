import 'package:jaguar_serializer/jaguar_serializer.dart';


part 'inline_response401.jser.dart';

class InlineResponse401 {
  
  @Alias('code', isNullable: false,  )
  final String code;
  
  @Alias('message', isNullable: false,  )
  final String message;
  

  InlineResponse401(
      

{
    
     this.code = null,  
     this.message = null 
    }
  );

  @override
  String toString() {
    return 'InlineResponse401[code=$code, message=$message, ]';
  }
}

@GenSerializer(nullableFields: true)
class InlineResponse401Serializer extends Serializer<InlineResponse401> with _$InlineResponse401Serializer {

}

