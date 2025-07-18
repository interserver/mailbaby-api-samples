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
class MAIL_STATS_TYPE_VOLUME_FROM




feature --Access

    billingsomedomain_com: INTEGER_32
      
    salessomedomain_com: INTEGER_32
      

feature -- Change Element

    set_billingsomedomain_com (a_name: like billingsomedomain_com)
        -- Set 'billingsomedomain_com' with 'a_name'.
      do
        billingsomedomain_com := a_name
      ensure
        billingsomedomain_com_set: billingsomedomain_com = a_name
      end

    set_salessomedomain_com (a_name: like salessomedomain_com)
        -- Set 'salessomedomain_com' with 'a_name'.
      do
        salessomedomain_com := a_name
      ensure
        salessomedomain_com_set: salessomedomain_com = a_name
      end


 feature -- Status Report

    output: STRING
          -- <Precursor>
      do
        create Result.make_empty
        Result.append("%Nclass MAIL_STATS_TYPE_VOLUME_FROM%N")
        if attached billingsomedomain_com as l_billingsomedomain_com then
          Result.append ("%Nbillingsomedomain_com:")
          Result.append (l_billingsomedomain_com.out)
          Result.append ("%N")
        end
        if attached salessomedomain_com as l_salessomedomain_com then
          Result.append ("%Nsalessomedomain_com:")
          Result.append (l_salessomedomain_com.out)
          Result.append ("%N")
        end
      end
end

