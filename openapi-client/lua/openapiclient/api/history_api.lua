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
local openapiclient_mail_log = require "openapiclient.model.mail_log"
local openapiclient_get_mail_orders_401_response = require "openapiclient.model.get_mail_orders_401_response"
local openapiclient_get_stats_200_response_inner = require "openapiclient.model.get_stats_200_response_inner"

local history_api = {}
local history_api_mt = {
	__name = "history_api";
	__index = history_api;
}

local function new_history_api(authority, basePath, schemes)
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
	}, history_api_mt)
end

function history_api:get_stats()
	local req = http_request.new_from_uri({
		scheme = self.default_scheme;
		host = self.host;
		port = self.port;
		path = string.format("%s/mail/stats",
			self.basePath);
	})

	-- set HTTP verb
	req.headers:upsert(":method", "GET")
	-- TODO: create a function to select proper content-type
	--local var_accept = { "application/json" }
	req.headers:upsert("content-type", "application/json")

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
		for _, ob in ipairs(result) do
			openapiclient_get_stats_200_response_inner.cast(ob)
		end
		return result, headers
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

function history_api:view_mail_log(id, origin, mx, from, to, subject, mailid, skip, limit, start_date, end_date)
	local req = http_request.new_from_uri({
		scheme = self.default_scheme;
		host = self.host;
		port = self.port;
		path = string.format("%s/mail/log?id=%s&origin=%s&mx=%s&from=%s&to=%s&subject=%s&mailid=%s&skip=%s&limit=%s&startDate=%s&endDate=%s",
			self.basePath, http_util.encodeURIComponent(id), http_util.encodeURIComponent(origin), http_util.encodeURIComponent(mx), http_util.encodeURIComponent(from), http_util.encodeURIComponent(to), http_util.encodeURIComponent(subject), http_util.encodeURIComponent(mailid), http_util.encodeURIComponent(skip), http_util.encodeURIComponent(limit), http_util.encodeURIComponent(start_date), http_util.encodeURIComponent(end_date));
	})

	-- set HTTP verb
	req.headers:upsert(":method", "GET")
	-- TODO: create a function to select proper content-type
	--local var_accept = { "application/json" }
	req.headers:upsert("content-type", "application/json")

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
		return openapiclient_mail_log.cast(result), headers
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
	new = new_history_api;
}