--[[
  MailBaby Email Delivery and Management Service API

  **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 

  The version of the OpenAPI document: 1.1.0
  Contact: support@interserver.net
  Generated by: https://openapi-generator.tech
]]

-- email_address_name class
local email_address_name = {}
local email_address_name_mt = {
	__name = "email_address_name";
	__index = email_address_name;
}

local function cast_email_address_name(t)
	return setmetatable(t, email_address_name_mt)
end

local function new_email_address_name(email, name)
	return cast_email_address_name({
		["email"] = email;
		["name"] = name;
	})
end

return {
	cast = cast_email_address_name;
	new = new_email_address_name;
}
