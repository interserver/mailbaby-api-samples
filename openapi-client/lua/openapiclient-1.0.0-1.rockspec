package = "openapiclient"
version = "1.0.0-1"
source = {
	url = "https://github.com/GIT_USER_ID/GIT_REPO_ID.git"
}

description = {
	summary = "API client genreated by OpenAPI Generator",
	detailed = [[
This is an API defintion for accesssing the Mail.Baby mail service.]],
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
		["openapiclient.model.body_1"] = "openapiclient/model/body_1.lua";
		["openapiclient.model.error_response"] = "openapiclient/model/error_response.lua";
		["openapiclient.model.generic_response"] = "openapiclient/model/generic_response.lua";
		["openapiclient.model.mail_attachment"] = "openapiclient/model/mail_attachment.lua";
		["openapiclient.model.mail_contact"] = "openapiclient/model/mail_contact.lua";
		["openapiclient.model.mail_log"] = "openapiclient/model/mail_log.lua";
		["openapiclient.model.mail_order"] = "openapiclient/model/mail_order.lua";
		["openapiclient.model.send_mail_adv"] = "openapiclient/model/send_mail_adv.lua";
		["openapiclient.model.send_mail_adv_from"] = "openapiclient/model/send_mail_adv_from.lua";
	}
}
