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
class MAIL_STATS_TYPE_VOLUME_TO




feature --Access

    clientdomain_com: INTEGER_32
      
    usersite_net: INTEGER_32
      
    salescompany_com: INTEGER_32
      
    clientanothersite_com: INTEGER_32
      

feature -- Change Element

    set_clientdomain_com (a_name: like clientdomain_com)
        -- Set 'clientdomain_com' with 'a_name'.
      do
        clientdomain_com := a_name
      ensure
        clientdomain_com_set: clientdomain_com = a_name
      end

    set_usersite_net (a_name: like usersite_net)
        -- Set 'usersite_net' with 'a_name'.
      do
        usersite_net := a_name
      ensure
        usersite_net_set: usersite_net = a_name
      end

    set_salescompany_com (a_name: like salescompany_com)
        -- Set 'salescompany_com' with 'a_name'.
      do
        salescompany_com := a_name
      ensure
        salescompany_com_set: salescompany_com = a_name
      end

    set_clientanothersite_com (a_name: like clientanothersite_com)
        -- Set 'clientanothersite_com' with 'a_name'.
      do
        clientanothersite_com := a_name
      ensure
        clientanothersite_com_set: clientanothersite_com = a_name
      end


 feature -- Status Report

    output: STRING
          -- <Precursor>
      do
        create Result.make_empty
        Result.append("%Nclass MAIL_STATS_TYPE_VOLUME_TO%N")
        if attached clientdomain_com as l_clientdomain_com then
          Result.append ("%Nclientdomain_com:")
          Result.append (l_clientdomain_com.out)
          Result.append ("%N")
        end
        if attached usersite_net as l_usersite_net then
          Result.append ("%Nusersite_net:")
          Result.append (l_usersite_net.out)
          Result.append ("%N")
        end
        if attached salescompany_com as l_salescompany_com then
          Result.append ("%Nsalescompany_com:")
          Result.append (l_salescompany_com.out)
          Result.append ("%N")
        end
        if attached clientanothersite_com as l_clientanothersite_com then
          Result.append ("%Nclientanothersite_com:")
          Result.append (l_clientanothersite_com.out)
          Result.append ("%N")
        end
      end
end

