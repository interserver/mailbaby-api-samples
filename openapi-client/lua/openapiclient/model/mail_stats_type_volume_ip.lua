--[[
  MailBaby Email Delivery and Management Service API

  **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 

  The version of the OpenAPI document: 1.1.0
  Contact: support@interserver.net
  Generated by: https://openapi-generator.tech
]]

-- mail_stats_type_volume_ip class
local mail_stats_type_volume_ip = {}
local mail_stats_type_volume_ip_mt = {
	__name = "mail_stats_type_volume_ip";
	__index = mail_stats_type_volume_ip;
}

local function cast_mail_stats_type_volume_ip(t)
	return setmetatable(t, mail_stats_type_volume_ip_mt)
end

local function new_mail_stats_type_volume_ip(Var1_1_1_1, Var2_2_2_2, Var3_3_3_3, Var4_4_4_4)
	return cast_mail_stats_type_volume_ip({
		["1.1.1.1"] = Var1_1_1_1;
		["2.2.2.2"] = Var2_2_2_2;
		["3.3.3.3"] = Var3_3_3_3;
		["4.4.4.4"] = Var4_4_4_4;
	})
end

return {
	cast = cast_mail_stats_type_volume_ip;
	new = new_mail_stats_type_volume_ip;
}
