import 'package:jaguar_serializer/jaguar_serializer.dart';


part 'generic_response.jser.dart';

class GenericResponse {
  
  @Alias('status', isNullable: false,  )
  final String status;
  
  @Alias('text', isNullable: false,  )
  final String text;
  

  GenericResponse(
      

{
     this.status = null,  
     this.text = null 
    
    }
  );

  @override
  String toString() {
    return 'GenericResponse[status=$status, text=$text, ]';
  }
}

@GenSerializer(nullableFields: true)
class GenericResponseSerializer extends Serializer<GenericResponse> with _$GenericResponseSerializer {

}

