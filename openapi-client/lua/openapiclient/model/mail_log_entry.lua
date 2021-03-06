--[[
  MailBaby Email Delivery API

  **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**   # 📌 Overview  This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).   # 🔐 Authentication  In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.    We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 

  The version of the OpenAPI document: 1.0.0
  Contact: support@interserver.net
  Generated by: https://openapi-generator.tech
]]

-- mail_log_entry class
local mail_log_entry = {}
local mail_log_entry_mt = {
	__name = "mail_log_entry";
	__index = mail_log_entry;
}

local function cast_mail_log_entry(t)
	return setmetatable(t, mail_log_entry_mt)
end

local function new_mail_log_entry(_id, id, from, to, subject, message_id, created, time, user, transtype, transhost, originhost, origin, interface, date, sending_zone, body_size, source_md5, seq, domain, recipient, locked, lock_time, assigned, queued, _lock, logger, mx_port, connection_key, mx_hostname, sent_body_hash, sent_body_size, md5_match)
	return cast_mail_log_entry({
		["_id"] = _id;
		["id"] = id;
		["from"] = from;
		["to"] = to;
		["subject"] = subject;
		["messageId"] = message_id;
		["created"] = created;
		["time"] = time;
		["user"] = user;
		["transtype"] = transtype;
		["transhost"] = transhost;
		["originhost"] = originhost;
		["origin"] = origin;
		["interface"] = interface;
		["date"] = date;
		["sendingZone"] = sending_zone;
		["bodySize"] = body_size;
		["sourceMd5"] = source_md5;
		["seq"] = seq;
		["domain"] = domain;
		["recipient"] = recipient;
		["locked"] = locked;
		["lockTime"] = lock_time;
		["assigned"] = assigned;
		["queued"] = queued;
		["_lock"] = _lock;
		["logger"] = logger;
		["mxPort"] = mx_port;
		["connectionKey"] = connection_key;
		["mxHostname"] = mx_hostname;
		["sentBodyHash"] = sent_body_hash;
		["sentBodySize"] = sent_body_size;
		["md5Match"] = md5_match;
	})
end

return {
	cast = cast_mail_log_entry;
	new = new_mail_log_entry;
}
