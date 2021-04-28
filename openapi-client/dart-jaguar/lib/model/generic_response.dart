import 'package:jaguar_serializer/jaguar_serializer.dart';


part 'generic_response.jser.dart';

class GenericResponse {
  
  @Alias('status', isNullable: false,  )
  final String status;
  
  @Alias('status_text', isNullable: false,  )
  final String statusText;
  

  GenericResponse(
      

{
     this.status = null,  
     this.statusText = null 
    
    }
  );

  @override
  String toString() {
    return 'GenericResponse[status=$status, statusText=$statusText, ]';
  }
}

@GenSerializer(nullableFields: true)
class GenericResponseSerializer extends Serializer<GenericResponse> with _$GenericResponseSerializer {

}

