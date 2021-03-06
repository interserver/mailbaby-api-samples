package = "openapiclient"
version = "1.0.0-1"
source = {
	url = "https://github.com/GIT_USER_ID/GIT_REPO_ID.git"
}

description = {
	summary = "API client generated by OpenAPI Generator",
	detailed = [[
**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**   # 📌 Overview  This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).   # 🔐 Authentication  In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.    We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. ]],
	homepage = "https://openapi-generator.tech",
	license = "Unlicense",
	maintainer = "OpenAPI Generator contributors",
}

dependencies = {
	"lua >= 5.2",
	"http",
	"dkjson",
	"basexx"
}

build = {
	type = "builtin",
	modules = {
		["openapiclient.api.default_api"] = "openapiclient/api/default_api.lua";
		["openapiclient.model.generic_response"] = "openapiclient/model/generic_response.lua";
		["openapiclient.model.get_mail_orders_200_response_inner"] = "openapiclient/model/get_mail_orders_200_response_inner.lua";
		["openapiclient.model.get_mail_orders_401_response"] = "openapiclient/model/get_mail_orders_401_response.lua";
		["openapiclient.model.mail_log"] = "openapiclient/model/mail_log.lua";
		["openapiclient.model.mail_log_entry"] = "openapiclient/model/mail_log_entry.lua";
		["openapiclient.model.send_mail"] = "openapiclient/model/send_mail.lua";
		["openapiclient.model.send_mail_adv"] = "openapiclient/model/send_mail_adv.lua";
		["openapiclient.model.send_mail_adv_attachments_inner"] = "openapiclient/model/send_mail_adv_attachments_inner.lua";
		["openapiclient.model.send_mail_adv_bcc_inner"] = "openapiclient/model/send_mail_adv_bcc_inner.lua";
		["openapiclient.model.send_mail_adv_cc_inner"] = "openapiclient/model/send_mail_adv_cc_inner.lua";
		["openapiclient.model.send_mail_adv_from"] = "openapiclient/model/send_mail_adv_from.lua";
		["openapiclient.model.send_mail_adv_replyto_inner"] = "openapiclient/model/send_mail_adv_replyto_inner.lua";
		["openapiclient.model.send_mail_adv_to_inner"] = "openapiclient/model/send_mail_adv_to_inner.lua";
	}
}
