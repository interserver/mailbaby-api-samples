--[[
  Mail Baby API
 
  This is an API defintion for accesssing the Mail.Baby mail service.
 
  The version of the OpenAPI document: 1.0.0
  Contact: detain@interserver.net
  Generated by: https://openapi-generator.tech
]]

-- mail_attachment class
local mail_attachment = {}
local mail_attachment_mt = {
	__name = "mail_attachment";
	__index = mail_attachment;
}

local function cast_mail_attachment(t)
	return setmetatable(t, mail_attachment_mt)
end

local function new_mail_attachment(filename, data)
	return cast_mail_attachment({
		["filename"] = filename;
		["data"] = data;
	})
end

return {
	cast = cast_mail_attachment;
	new = new_mail_attachment;
}