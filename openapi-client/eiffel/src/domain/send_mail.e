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
class SEND_MAIL




feature --Access

    to: detachable STRING_32
      -- The Contact whom is the primary recipient of this email.
    var_from: detachable STRING_32
      -- The contact whom is the this email is from.
    subject: detachable STRING_32
      -- The subject or title of the email
    body: detachable STRING_32
      -- The main email contents.

feature -- Change Element

    set_to (a_name: like to)
        -- Set 'to' with 'a_name'.
      do
        to := a_name
      ensure
        to_set: to = a_name
      end

    set_var_from (a_name: like var_from)
        -- Set 'var_from' with 'a_name'.
      do
        var_from := a_name
      ensure
        var_from_set: var_from = a_name
      end

    set_subject (a_name: like subject)
        -- Set 'subject' with 'a_name'.
      do
        subject := a_name
      ensure
        subject_set: subject = a_name
      end

    set_body (a_name: like body)
        -- Set 'body' with 'a_name'.
      do
        body := a_name
      ensure
        body_set: body = a_name
      end


 feature -- Status Report

    output: STRING
          -- <Precursor>
      do
        create Result.make_empty
        Result.append("%Nclass SEND_MAIL%N")
        if attached to as l_to then
          Result.append ("%Nto:")
          Result.append (l_to.out)
          Result.append ("%N")
        end
        if attached var_from as l_var_from then
          Result.append ("%Nvar_from:")
          Result.append (l_var_from.out)
          Result.append ("%N")
        end
        if attached subject as l_subject then
          Result.append ("%Nsubject:")
          Result.append (l_subject.out)
          Result.append ("%N")
        end
        if attached body as l_body then
          Result.append ("%Nbody:")
          Result.append (l_body.out)
          Result.append ("%N")
        end
      end
end

