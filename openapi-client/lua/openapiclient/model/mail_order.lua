--[[
  Mail Baby API
 
  This is an API defintion for accesssing the Mail.Baby mail service.
 
  The version of the OpenAPI document: 1.0.0
  Contact: detain@interserver.net
  Generated by: https://openapi-generator.tech
]]

-- mail_order class
local mail_order = {}
local mail_order_mt = {
	__name = "mail_order";
	__index = mail_order;
}

local function cast_mail_order(t)
	return setmetatable(t, mail_order_mt)
end

local function new_mail_order(id, status, username, password, comment)
	return cast_mail_order({
		["id"] = id;
		["status"] = status;
		["username"] = username;
		["password"] = password;
		["comment"] = comment;
	})
end

return {
	cast = cast_mail_order;
	new = new_mail_order;
}