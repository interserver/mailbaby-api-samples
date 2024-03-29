--[[
  MailBaby Email Delivery and Management Service API

  **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 

  The version of the OpenAPI document: 1.1.0
  Contact: support@interserver.net
  Generated by: https://openapi-generator.tech
]]

--package openapiclient

local http_request = require "http.request"
local http_util = require "http.util"
local dkjson = require "dkjson"
local basexx = require "basexx"

-- model import
local openapiclient_email_address_types = require "openapiclient.model.email_address_types"
local openapiclient_email_addresses_types = require "openapiclient.model.email_addresses_types"
local openapiclient_error_message = require "openapiclient.model.error_message"
local openapiclient_generic_response = require "openapiclient.model.generic_response"
local openapiclient_mail_attachment = require "openapiclient.model.mail_attachment"

local sending_api = {}
local sending_api_mt = {
	__name = "sending_api";
	__index = sending_api;
}

local function new_sending_api(authority, basePath, schemes)
	local schemes_map = {}
	for _,v in ipairs(schemes) do
		schemes_map[v] = v
	end
	local default_scheme = schemes_map.https or schemes_map.http
	local host, port = http_util.split_authority(authority, default_scheme)
	return setmetatable({
		host = host;
		port = port;
		basePath = basePath or "https://api.mailbaby.net";
		schemes = schemes_map;
		default_scheme = default_scheme;
		http_username = nil;
		http_password = nil;
		api_key = {};
		access_token = nil;
	}, sending_api_mt)
end

function sending_api:send_adv_mail(subject, body, from, to, replyto, cc, bcc, attachments, id)
	local req = http_request.new_from_uri({
		scheme = self.default_scheme;
		host = self.host;
		port = self.port;
		path = string.format("%s/mail/advsend",
			self.basePath);
	})

	-- set HTTP verb
	req.headers:upsert(":method", "POST")
	-- TODO: create a function to select proper accept
	--local var_content_type = { "application/x-www-form-urlencoded", "application/json" }
	req.headers:upsert("accept", "application/x-www-form-urlencoded")

	-- TODO: create a function to select proper content-type
	--local var_accept = { "application/json" }
	req.headers:upsert("content-type", "application/json")

	req:set_body(http_util.dict_to_query({
		["subject"] = subject;
		["body"] = body;
		["from"] = from;
		["to"] = to;
		["replyto"] = replyto;
		["cc"] = cc;
		["bcc"] = bcc;
		["attachments"] = attachments;
		["id"] = id;
	}))
	-- api key in headers 'X-API-KEY'
	if self.api_key['X-API-KEY'] then
		req.headers:upsert("apiKeyAuth", self.api_key['X-API-KEY'])
	end

	-- make the HTTP call
	local headers, stream, errno = req:go()
	if not headers then
		return nil, stream, errno
	end
	local http_status = headers:get(":status")
	if http_status:sub(1,1) == "2" then
		local body, err, errno2 = stream:get_body_as_string()
		-- exception when getting the HTTP body
		if not body then
			return nil, err, errno2
		end
		stream:shutdown()
		local result, _, err3 = dkjson.decode(body)
		-- exception when decoding the HTTP body
		if result == nil then
			return nil, err3
		end
		return openapiclient_generic_response.cast(result), headers
	else
		local body, err, errno2 = stream:get_body_as_string()
		if not body then
			return nil, err, errno2
		end
		stream:shutdown()
		-- return the error message (http body)
		return nil, http_status, body
	end
end

function sending_api:send_mail(to, from, subject, body)
	local req = http_request.new_from_uri({
		scheme = self.default_scheme;
		host = self.host;
		port = self.port;
		path = string.format("%s/mail/send",
			self.basePath);
	})

	-- set HTTP verb
	req.headers:upsert(":method", "POST")
	-- TODO: create a function to select proper accept
	--local var_content_type = { "application/x-www-form-urlencoded", "application/json" }
	req.headers:upsert("accept", "application/x-www-form-urlencoded")

	-- TODO: create a function to select proper content-type
	--local var_accept = { "application/json" }
	req.headers:upsert("content-type", "application/json")

	req:set_body(http_util.dict_to_query({
		["to"] = to;
		["from"] = from;
		["subject"] = subject;
		["body"] = body;
	}))
	-- api key in headers 'X-API-KEY'
	if self.api_key['X-API-KEY'] then
		req.headers:upsert("apiKeyAuth", self.api_key['X-API-KEY'])
	end

	-- make the HTTP call
	local headers, stream, errno = req:go()
	if not headers then
		return nil, stream, errno
	end
	local http_status = headers:get(":status")
	if http_status:sub(1,1) == "2" then
		local body, err, errno2 = stream:get_body_as_string()
		-- exception when getting the HTTP body
		if not body then
			return nil, err, errno2
		end
		stream:shutdown()
		local result, _, err3 = dkjson.decode(body)
		-- exception when decoding the HTTP body
		if result == nil then
			return nil, err3
		end
		return openapiclient_generic_response.cast(result), headers
	else
		local body, err, errno2 = stream:get_body_as_string()
		if not body then
			return nil, err, errno2
		end
		stream:shutdown()
		-- return the error message (http body)
		return nil, http_status, body
	end
end

return {
	new = new_sending_api;
}
