note
 description:"[
		MailBaby Email Delivery and Management Service API
 		**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
  		The version of the OpenAPI document: 1.1.0
 	    Contact: support@interserver.net

  	NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).

 		 Do not edit the class manually.
 	]"
	date: "$Date$"
	revision: "$Revision$"
	EIS:"Eiffel openapi generator", "src=https://openapi-generator.tech", "protocol=uri"

expanded class
	API_JSON_SERIALIZER


feature -- Access

	to_json_string (a_obj: ANY): STRING
			-- Convert an object `a_obj' to String representation.
		local
			obj: ANY
			conv_to: JSON_REFLECTOR_SERIALIZER
			ctx: detachable JSON_SERIALIZER_CONTEXT
			s: STRING
		do
			obj := a_obj

				-- Auto serialization, handling table iterable as JSON Object, and iterable as ARRAY. Without typename.
			create conv_to
			create ctx
			ctx.set_pretty_printing
			ctx.set_is_type_name_included (False)
			ctx.set_default_serializer (create {JSON_REFLECTOR_SERIALIZER})
			ctx.register_serializer (create {TABLE_ITERABLE_JSON_SERIALIZER [detachable ANY, READABLE_STRING_GENERAL]}, {TABLE_ITERABLE [detachable ANY, READABLE_STRING_GENERAL]})
			ctx.register_serializer (create {ITERABLE_JSON_SERIALIZER [detachable ANY]}, {ITERABLE [detachable ANY]})

			s := conv_to.to_json_string (obj, ctx)
			Result := s
		end

end
