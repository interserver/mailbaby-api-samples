note
 description:"[
		Mail Baby API
 		This is an API defintion for accesssing the Mail.Baby mail service.
  		The version of the OpenAPI document: 1.0.0
 	    Contact: detain@interserver.net

  	NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).

 		 Do not edit the class manually.
 	]"
	date: "$Date$"
	revision: "$Revision$"
	EIS:"Eiffel openapi generator", "src=https://openapi-generator.tech", "protocol=uri"
class ERROR_RESPONSE 




feature --Access

    code: detachable STRING_32 
      
    message: detachable STRING_32 
      

feature -- Change Element  
 
    set_code (a_name: like code)
        -- Set 'code' with 'a_name'.
      do
        code := a_name
      ensure
        code_set: code = a_name		
      end

    set_message (a_name: like message)
        -- Set 'message' with 'a_name'.
      do
        message := a_name
      ensure
        message_set: message = a_name		
      end


 feature -- Status Report

    output: STRING
          -- <Precursor>
      do
        create Result.make_empty
        Result.append("%Nclass ERROR_RESPONSE%N")
        if attached code as l_code then
          Result.append ("%Ncode:")
          Result.append (l_code.out)
          Result.append ("%N")    
        end  
        if attached message as l_message then
          Result.append ("%Nmessage:")
          Result.append (l_message.out)
          Result.append ("%N")    
        end  
      end
end

