--[[
  Mail Baby API
 
  This is an API defintion for accesssing the Mail.Baby mail service.
 
  The version of the OpenAPI document: 1.0.0
  Contact: detain@interserver.net
  Generated by: https://openapi-generator.tech
]]

-- send_mail class
local send_mail = {}
local send_mail_mt = {
	__name = "send_mail";
	__index = send_mail;
}

local function cast_send_mail(t)
	return setmetatable(t, send_mail_mt)
end

local function new_send_mail(to, from, subject, body)
	return cast_send_mail({
		["to"] = to;
		["from"] = from;
		["subject"] = subject;
		["body"] = body;
	})
end

return {
	cast = cast_send_mail;
	new = new_send_mail;
}