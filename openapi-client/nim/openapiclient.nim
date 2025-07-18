#
# MailBaby Email Delivery and Management Service API
# 
# **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
# The version of the OpenAPI document: 1.1.0
# Contact: support@interserver.net
# Generated by: https://openapi-generator.tech
#

# Models
import openapiclient/models/model_deny_rule_new
import openapiclient/models/model_deny_rule_record
import openapiclient/models/model_email_address_name
import openapiclient/models/model_email_address_types
import openapiclient/models/model_email_addresses_types
import openapiclient/models/model_error_message
import openapiclient/models/model_generic_response
import openapiclient/models/model_mail_attachment
import openapiclient/models/model_mail_block_click_house
import openapiclient/models/model_mail_block_rspamd
import openapiclient/models/model_mail_blocks
import openapiclient/models/model_mail_log
import openapiclient/models/model_mail_log_entry
import openapiclient/models/model_mail_order
import openapiclient/models/model_mail_stats_type
import openapiclient/models/model_mail_stats_type_volume
import openapiclient/models/model_mail_stats_type_volume_from
import openapiclient/models/model_mail_stats_type_volume_ip
import openapiclient/models/model_mail_stats_type_volume_to
import openapiclient/models/model_send_mail
import openapiclient/models/model_send_mail_adv

export model_deny_rule_new
export model_deny_rule_record
export model_email_address_name
export model_email_address_types
export model_email_addresses_types
export model_error_message
export model_generic_response
export model_mail_attachment
export model_mail_block_click_house
export model_mail_block_rspamd
export model_mail_blocks
export model_mail_log
export model_mail_log_entry
export model_mail_order
export model_mail_stats_type
export model_mail_stats_type_volume
export model_mail_stats_type_volume_from
export model_mail_stats_type_volume_ip
export model_mail_stats_type_volume_to
export model_send_mail
export model_send_mail_adv

# APIs
import openapiclient/apis/api_blocking
import openapiclient/apis/api_history
import openapiclient/apis/api_sending
import openapiclient/apis/api_services
import openapiclient/apis/api_status

export api_blocking
export api_history
export api_sending
export api_services
export api_status
